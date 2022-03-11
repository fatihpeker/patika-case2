package com.example.converter;

import com.example.dto.AddNewAdreessRequestDto;
import com.example.dto.AdreessResponseDto;
import com.example.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    //Address addreessRequestDtoToAddreess(AddNewAdreessRequestDto addNewAdreessRequestDto);

    AdreessResponseDto addreessToAddreessResponseDto(Address address);

}
