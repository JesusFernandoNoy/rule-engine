package com.keralty.rule.engine.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExecutionDTO {
    private PatientDTO patient;
    private ResultDTO result;
}
