package com.example.companydetails.dao.entities;

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
@Table(name = "COMPANY")
public class CompanyEntity {

    @Id
    @Column(name = "COMPANY_ID")
    private Integer compId;

    @Column(name = "COMPANY_NAME")
    private String compName;

    @Column(name = "COMPANY_TURNOVER")
    private Double compTurnover;

    @Column(name = "COMPANY_CEO")
    private String compCeo;

    @Column(name = "STOCK_EXCHANGE")
    private String stockExchange;

    @Column(name = "SECTOR")
    private String sector;

    @Column(name = "BRIEF_WRITEUP")
    private String briefWriteup;
}
