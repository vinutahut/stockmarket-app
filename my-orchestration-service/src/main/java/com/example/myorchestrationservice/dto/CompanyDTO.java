package com.example.myorchestrationservice.dto;

import lombok.Data;

/**
 * POJO for holding Order related data
 */
@Data
public class CompanyDTO {

    private Integer compId;

    private String compName;

    private Double compTurnover;

    private String compCeo;

    private String stockExchange;

    private String sector;

    private String briefWriteup;
}
