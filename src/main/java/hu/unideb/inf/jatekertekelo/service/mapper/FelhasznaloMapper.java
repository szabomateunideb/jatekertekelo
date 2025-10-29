package hu.unideb.inf.jatekertekelo.service.mapper;

import hu.unideb.inf.jatekertekelo.data.entity.FelhasznaloEntity;
import hu.unideb.inf.jatekertekelo.service.dto.RegisztracioDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FelhasznaloMapper {

    @Mapping(target = "jogosultsag", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ertekelesek", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    @Mapping(target = "hash", source = "dto.jelszo")
    FelhasznaloEntity regisztracioToEntity(RegisztracioDto dto);
}
