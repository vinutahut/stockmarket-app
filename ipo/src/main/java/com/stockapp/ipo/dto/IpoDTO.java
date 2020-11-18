package com.stockapp.ipo.dto;
import lombok.Data;

import javax.persistence.Column;

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
