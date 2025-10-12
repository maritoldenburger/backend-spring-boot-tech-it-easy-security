package nl.techiteasy.techiteasy.mappers;

import nl.techiteasy.techiteasy.dtos.WallBracketDto;
import nl.techiteasy.techiteasy.dtos.WallBracketInputDto;
import nl.techiteasy.techiteasy.models.WallBracket;


public class WallBracketMapper {

    public static WallBracketDto toWallBracketDto(WallBracket wallBracket) {
        var dto = new WallBracketDto();

        dto.id = wallBracket.getId();
        dto.size = wallBracket.getSize();
        dto.adjustable = wallBracket.getAdjustable();
        dto.name = wallBracket.getName();
        dto.price = wallBracket.getPrice();

        return dto;
    }

    public static WallBracket toWallBracket(WallBracketInputDto dto) {
        var wallBracket = new WallBracket();
        wallBracket.setSize(dto.size);
        wallBracket.setAdjustable(dto.adjustable);
        wallBracket.setName(dto.name);
        wallBracket.setPrice(dto.price);
        return wallBracket;
    }
}
