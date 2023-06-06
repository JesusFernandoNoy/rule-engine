package com.keralty.rule.engine.dto.program;

import com.keralty.rule.engine.entity.request.ProgramVariablesRequest;
import com.keralty.rule.engine.entity.response.ProgramVariablesResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CalculateVariablesProgramDTO {
    ProgramVariablesRequest request;
    ProgramVariablesResponse result;
}
