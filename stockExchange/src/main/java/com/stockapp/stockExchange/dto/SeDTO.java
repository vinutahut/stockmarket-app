package com.stockapp.stockExchange.dto;

import lombok.Data;

/**
 * POJO for holding Order related data
 */
@Data
public class SeDTO {

    private Integer seId;

    private String stockExchange;

    private String brief;

    private String contactAddress;

    private String remarks;
}
