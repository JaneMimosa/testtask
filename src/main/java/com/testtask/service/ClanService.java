package com.testtask.service;

import com.testtask.repository.ClanRepository;
import com.testtask.domain.Clan;

import java.sql.SQLException;

public class ClanService {

    private final ClanRepository clanRepository;

    public ClanService(ClanRepository clanRepository) {
        this.clanRepository = clanRepository;
    }

    public int AddGold(long clanId, int addedGold) {
        try {
            return clanRepository.addGold(clanId, addedGold);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addedGold;
    }

    public int getClanGold(long clanId) {
        return clanRepository.getClanGold(clanId);
    }
    public Clan getClan(long clanId) {
        return clanRepository.getClan(clanId);
    }
}
