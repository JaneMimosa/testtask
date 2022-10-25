package com.testtask;


import com.testtask.domain.Clan;
import com.testtask.repository.ClanRepository;
import com.testtask.repository.TaskRepository;
import com.testtask.service.ClanService;
import com.testtask.service.TaskService;
import java.util.logging.Logger;

public class ClanController {

    ClanService clanService = new ClanService(new ClanRepository());
    TaskService taskService = new TaskService(clanService, new TaskRepository());
    Logger logger = Logger.getLogger(ClanController.class.getName());

    public Clan getClan(long clanId) {
        Clan clan = clanService.getClan(clanId);
        logger.info("Clan with id " + clan.getId() + " has " + clan.getGold() + " gold");
        return clan;
    }

    public int addGold(long clanId, int addedGold) {
        int gold =  clanService.AddGold(clanId, addedGold);
        logger.info("Clan with id " + clanId + " has added " + gold + " gold");
        return gold;
    }

    public int getClanGold(long clanId) {
        int gold = clanService.getClanGold(clanId);
        logger.info("Clan with id " + clanId + " has " + gold + " gold");
        return gold;
    }

    public void completeTask(long clanId, long taskId) {
        taskService.completeTask(clanId, taskId);
        logger.info("Clan with id " + clanId + " completed the task and received  " + getTaskReward(taskId) + " gold");
    }

    public int getTaskReward(long taskId) {
        return taskService.getTaskReward(taskId);
    }
}
