package com.stockapp.stockExchange.dto;

import com.stockapp.stockExchange.dao.entities.SeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface SeMapper {

    SeMapper INSTANCE = Mappers.getMapper(SeMapper.class);
    SeDTO seEntityToDTO(SeEntity seEntity);
}