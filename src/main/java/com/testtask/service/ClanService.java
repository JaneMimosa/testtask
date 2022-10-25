package com.testtask.service;

import com.testtask.repository.ClanRepository;
import com.testtask.domain.Clan;

import java.sql.SQLException;

public class ClanService {

    private final ClanRepository clanRepository;

    public ClanService(ClanRepository clanRepository) {
        this.clanRepository = clanRepository;
    }

    public int addGold(long clanId, long userId, int addedGold) {
        try {
            return clanRepository.addGold(clanId, userId, addedGold);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addedGold;
    }

    public int decreaseGold(long clanId, long userId, int decreaseGold) {
        try {
            return clanRepository.decreaseGold(clanId, userId, decreaseGold);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getClanGold(long clanId) {
        return clanRepository.getClanGold(clanId);
    }
    public Clan getClan(long clanId) {
        return clanRepository.getClan(clanId);
    }
}
