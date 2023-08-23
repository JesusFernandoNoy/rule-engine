package com.keralty.rule.engine.dto.reglasAseguradora;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReglasAseguradoraDTO {
    private String company;
    private String insuranceID;
    private String insuranceName;
    private ReglasAseguradoraResultDTO result;
}
