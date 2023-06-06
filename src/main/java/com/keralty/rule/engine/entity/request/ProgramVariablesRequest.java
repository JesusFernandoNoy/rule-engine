package com.keralty.rule.engine.entity.request;


import com.keralty.rule.engine.entity.enums.PatientTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramVariablesRequest {
    private String healthCareProgramID;
    private PatientTypeEnum patientType;
}
