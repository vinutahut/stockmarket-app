package com.stockapp.ipo.dao;

import com.stockapp.ipo.dao.entities.IpoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpoRepository extends CrudRepository<IpoEntity, Integer> {

}