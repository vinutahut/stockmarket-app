package com.stockapp.ipo.dao.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity that maps the ORDER table.
 */
@Data
@Entity
@Table(name = "IPOS")
public class IpoEntity {

    @Id
    @Column(name = "COMPANY_ID")
    private Integer compId;

    @Column(name = "COMPANY_NAME")
    private String compName;

    @Column(name = "STOCK_EXCHANGE")
    private String stockExchange;

    @Column(name = "PRICE_PER_SHARE")
    private Double pricePerShare;

    @Column(name = "TOTAL_NUMBER_OF_SHARES")
    private Integer totalNumberOfShares;

    @Column(name = "OPEN_DATE_TIME")
    private String openDateTime;

    @Column(name = "REMARKS")
    private String remarks;

}
