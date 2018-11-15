package com.musicreview.model;

public enum UserRole {
    ADMIN, USER, REVIEWER;

    @Override
    public String toString() {
        return "ROLE_" + name();
    }
}
