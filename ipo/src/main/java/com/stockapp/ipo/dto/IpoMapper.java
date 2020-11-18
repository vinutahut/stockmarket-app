package com.stockapp.ipo.dto;

import com.stockapp.ipo.dao.entities.IpoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface IpoMapper {

    IpoMapper INSTANCE = Mappers.getMapper(IpoMapper.class);
    IpoDTO ipoEntityToDTO(IpoEntity ipoEntity);
}