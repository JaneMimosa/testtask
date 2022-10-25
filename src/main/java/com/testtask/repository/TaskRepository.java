package com.testtask.repository;

import com.testtask.domain.Clan;
import com.testtask.service.ClanService;

import java.sql.*;

public class TaskRepository {

    private Connection connection;
    private Statement statement;
    private final ClanService clanService;

    public TaskRepository(ClanService clanService) {
        this.clanService = clanService;
    }

    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:testtask.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public int getTaskReward(long taskId) {
        try {
            connect();
            String query = String.format("SELECT task_gold FROM Tasks WHERE task_id='%s'", taskId);

            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                return rs.getInt("task_gold");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return 0;
    }
    public void completeTask(long clanId, long userId, long taskId) {
        Clan clan = clanService.getClan(clanId);
        clanService.addGold(clanId, userId, getTaskReward(taskId));
    }
    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
