package com.example.lab5.backend.enums;

public enum SkillLevel {
    MASTER(1),
    BEGiNER(2),
    ADVANCED(3),
    PROFESSIONAL(4),
    IMTERMEDIATE(5);   

    private int value;

    SkillLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
