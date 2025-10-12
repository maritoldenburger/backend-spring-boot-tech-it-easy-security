package nl.techiteasy.techiteasy.mappers;

import nl.techiteasy.techiteasy.dtos.CIModuleDto;
import nl.techiteasy.techiteasy.dtos.CIModuleInputDto;
import nl.techiteasy.techiteasy.models.CIModule;

public class CIModuleMapper {

    public static CIModuleDto toCIModuleDto(CIModule ciModule) {
        var dto = new CIModuleDto();

        dto.id = ciModule.getId();
        dto.name = ciModule.getName();
        dto.type = ciModule.getType();
        dto.price = ciModule.getPrice();

        return dto;
    }

    public static CIModule toCIModule(CIModuleInputDto dto) {
        var ciModule = new CIModule();

        ciModule.setName(dto.name);
        ciModule.setType(dto.type);
        ciModule.setPrice(dto.price);

        return ciModule;
    }


}
