package com.sfood.mapper;

public interface GenericMapper <E, D>{
    D toDTO(E entity);
    E toEntity(D dto);
}
