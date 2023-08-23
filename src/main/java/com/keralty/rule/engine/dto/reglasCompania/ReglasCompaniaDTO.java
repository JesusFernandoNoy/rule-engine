package com.keralty.rule.engine.dto.reglasCompania;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReglasCompaniaDTO {
    private String companyID;
    private String company;
    private ReglasCompaniaResultDTO result;
}
