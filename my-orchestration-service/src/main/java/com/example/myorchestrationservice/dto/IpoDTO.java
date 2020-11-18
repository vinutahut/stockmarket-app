package com.example.myorchestrationservice.dto;

import lombok.Data;

/**
 * POJO for holding Order related data
 */
@Data
public class IpoDTO {

    private Integer compId;

    private String compName;

    private String stockExchange;

    private Double pricePerShare;

    private Integer totalNumberOfShares;

    private String openDateTime;

    private String remarks;

}
