package com.stockapp.ipo.dto;

import com.stockapp.ipo.dao.entities.IpoEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-04T12:05:57+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class IpoMapperImpl implements IpoMapper {

    @Override
    public IpoDTO ipoEntityToDTO(IpoEntity ipoEntity) {
        if ( ipoEntity == null ) {
            return null;
        }

        IpoDTO ipoDTO = new IpoDTO();

        ipoDTO.setCompId( ipoEntity.getCompId() );
        ipoDTO.setCompName( ipoEntity.getCompName() );
        ipoDTO.setStockExchange( ipoEntity.getStockExchange() );
        ipoDTO.setPricePerShare( ipoEntity.getPricePerShare() );
        ipoDTO.setTotalNumberOfShares( ipoEntity.getTotalNumberOfShares() );
        ipoDTO.setOpenDateTime( ipoEntity.getOpenDateTime() );
        ipoDTO.setRemarks( ipoEntity.getRemarks() );

        return ipoDTO;
    }
}
