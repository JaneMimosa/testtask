package com.testtask.repository;

import com.testtask.domain.Clan;

import java.sql.*;

public class ClanRepository {

    private Connection connection;
    private Statement statement;

    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:testtask.db");
            statement = connection.createStatement();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public synchronized int addGold(long clanId, int addedGold) throws SQLException {
        try {
        connect();
            String query = String.format("SELECT clan_gold from Сlans WHERE clan_id='%s';", clanId);
                ResultSet rs = statement.executeQuery(query);
                int gold = rs.getInt("clan_gold") + addedGold;
                String queryGold = String.format("UPDATE Clans SET clan_gold = '%s' WHERE clan_id = '%s';", gold, clanId);
                statement.executeUpdate(queryGold);
                return gold;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return 0;
    }

    public Clan getClan(long clanId) {
        try {
        connect();
        String query = String.format("SELECT * from Clans WHERE clan_id='%s';", clanId);
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                String clanName = rs.getString("clan_name");
                int clanGold = rs.getInt("clan_gold");
                return new Clan(clanId, clanName, clanGold);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return null;
    }

    public synchronized int getClanGold(long clanId) {
        try {
            connect();
            String query = String.format("SELECT clan_gold from Clans WHERE clan_id='%s';", clanId);
            ResultSet rs = statement.executeQuery(query);
            return rs.getInt("clan_gold");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return 0;
    }

    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
