package com.testtask.service;

import com.testtask.repository.TaskRepository;

public class TaskService {

    private final ClanService clanService;
    private final TaskRepository taskRepository;

    public TaskService(ClanService clanService, TaskRepository taskRepository) {
        this.clanService = clanService;
        this.taskRepository = taskRepository;
    }

    public void completeTask(long clanId, long userId, long taskId) {
    taskRepository.completeTask(clanId, userId, taskId);
    }

    public int getTaskReward(long taskId) {
        return taskRepository.getTaskReward(taskId);
    }
}
