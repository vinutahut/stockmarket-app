package com.stockapp.stockExchange.dao.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Entity that maps the ORDER table.
 */
@Data
@Entity
@Table(name = "SE")
public class SeEntity {

    @Id
    @Column(name = "SE_ID")
    private Integer seId;

    @Column(name = "STOCK_EXCHANGE")
    private String stockExchange;

    @Column(name = "BRIEF")
    private String brief;

    @Column(name = "CONTACT_ADDRESS")
    private String contactAddress;

    @Column(name = "REMARKS")
    private String remarks;
}