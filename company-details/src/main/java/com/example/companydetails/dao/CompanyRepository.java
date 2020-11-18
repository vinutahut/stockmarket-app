package com.example.companydetails.dao;

import com.example.companydetails.dao.entities.CompanyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends CrudRepository<CompanyEntity, Integer> {
    public List<CompanyEntity> findByCompNameContaining(String compName);
    public List<CompanyEntity> findBySectorContaining(String sector);
    public List<CompanyEntity> findByStockExchangeContaining(String se);
}
