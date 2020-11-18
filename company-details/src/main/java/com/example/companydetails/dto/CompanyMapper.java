package com.example.companydetails.dto;

import com.example.companydetails.dao.entities.CompanyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);
    CompanyDTO companyEntityToDTO(CompanyEntity companyEntity);
}
