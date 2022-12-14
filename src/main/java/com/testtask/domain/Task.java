package com.testtask.domain;

public class Task {
    private final long id;
    private String name;
    private final int gold;

    public Task(long id, String name, int gold) {
        this.id = id;
        this.name = name;
        this.gold = gold;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGold() {
        return gold;
    }
}
