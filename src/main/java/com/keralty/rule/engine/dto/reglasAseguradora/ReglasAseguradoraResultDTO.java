package com.keralty.rule.engine.dto.reglasAseguradora;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReglasAseguradoraResultDTO {
    private String status;//SUCCES or FAIL
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String insuranceCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String insuranceType;
}
