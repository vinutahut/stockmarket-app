package com.stockapp.stockExchange.dto;

import com.stockapp.stockExchange.dao.entities.SeEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-03T22:21:35+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class SeMapperImpl implements SeMapper {

    @Override
    public SeDTO seEntityToDTO(SeEntity seEntity) {
        if ( seEntity == null ) {
            return null;
        }

        SeDTO seDTO = new SeDTO();

        seDTO.setSeId( seEntity.getSeId() );
        seDTO.setStockExchange( seEntity.getStockExchange() );
        seDTO.setBrief( seEntity.getBrief() );
        seDTO.setContactAddress( seEntity.getContactAddress() );
        seDTO.setRemarks( seEntity.getRemarks() );

        return seDTO;
    }
}
