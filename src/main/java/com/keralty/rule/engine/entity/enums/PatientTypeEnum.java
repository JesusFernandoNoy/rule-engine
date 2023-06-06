package com.keralty.rule.engine.entity.enums;

public enum PatientTypeEnum {
    CANDIDATE("candidate");

    private String description;

    PatientTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
