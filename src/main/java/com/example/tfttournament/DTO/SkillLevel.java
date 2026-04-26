package com.example.tfttournament.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SkillLevel {

    Y("Y"),
    Y_PLUS("Y+"),
    TBY("TBY"),
    TBY_PLUS("TBY+");

    private final String label;

    SkillLevel(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }

    @JsonCreator
    public static SkillLevel from(String value) {
        if (value == null) {
            return null;
        }

        for (SkillLevel item : values()) {
            if (item.name().equalsIgnoreCase(value) || item.label.equalsIgnoreCase(value)) {
                return item;
            }
        }

        throw new IllegalArgumentException("Invalid skill level: " + value);
    }
}