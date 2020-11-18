package com.example.companydetails.dto;

import com.example.companydetails.dao.entities.CompanyEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-03T15:38:37+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class CompanyMapperImpl implements CompanyMapper {

    @Override
    public CompanyDTO companyEntityToDTO(CompanyEntity companyEntity) {
        if ( companyEntity == null ) {
            return null;
        }

        CompanyDTO companyDTO = new CompanyDTO();

        companyDTO.setCompId( companyEntity.getCompId() );
        companyDTO.setCompName( companyEntity.getCompName() );
        companyDTO.setCompTurnover( companyEntity.getCompTurnover() );
        companyDTO.setCompCeo( companyEntity.getCompCeo() );
        companyDTO.setStockExchange( companyEntity.getStockExchange() );
        companyDTO.setSector( companyEntity.getSector() );
        companyDTO.setBriefWriteup( companyEntity.getBriefWriteup() );

        return companyDTO;
    }
}
