package com.testtask.service;

import com.testtask.domain.Clan;
import com.testtask.repository.TaskRepository;

import java.sql.SQLException;

public class TaskService {

    private ClanService clanService;
    TaskRepository taskRepository;

    public TaskService(ClanService clanService, TaskRepository taskRepository) {
        this.clanService = clanService;
        this.taskRepository = taskRepository;
    }

    public void completeTask(long clanId, long taskId) {
    Clan clan = clanService.getClan(clanId);
    clanService.AddGold(clanId, getTaskReward(taskId));
    }

    public int getTaskReward(long taskId) {
        return taskRepository.getTaskReward(taskId);
    }
}
