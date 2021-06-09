package com.improve.springdatajpa;

import org.mapstruct.Mapper;

@Mapper
public interface UserWithCompositeKeyMapper {
    UserWithCompositeKey dtoToPojo(UserWithCompositeKeyDTO userWithCompositeKeyDTO);
    UserWithCompositeKeyDTO pojoToDto(UserWithCompositeKey userWithCompositeKey);
}
