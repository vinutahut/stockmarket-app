package com.stockapp.stockExchange.dao;


import com.stockapp.stockExchange.dao.entities.SeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SeRepository extends CrudRepository<SeEntity, Integer> {

}