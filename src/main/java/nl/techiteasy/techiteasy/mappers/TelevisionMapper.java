package nl.techiteasy.techiteasy.mappers;

import nl.techiteasy.techiteasy.dtos.TelevisionDto;
import nl.techiteasy.techiteasy.dtos.TelevisionInputDto;
import nl.techiteasy.techiteasy.models.Television;

public class TelevisionMapper {

    public static TelevisionDto toTelevisionDto(Television television) {
        var dto = new TelevisionDto();

        dto.setId(television.getId());
        dto.setType(television.getType());
        dto.setBrand(television.getBrand());
        dto.setName(television.getName());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.isSmartTv());
        dto.setWifi(television.isWifi());
        dto.setVoiceControl(television.isVoiceControl());
        dto.setHdr(television.isHdr());
        dto.setBluetooth(television.isBluetooth());
        dto.setAmbiLight(television.isAmbiLight());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());

        return dto;
    }

    public static Television toTelevision(TelevisionInputDto dto) {
        var television = new Television();

        television.setId(dto.getId());
        television.setType(dto.getType());
        television.setBrand(dto.getBrand());
        television.setName(dto.getName());
        television.setPrice(dto.getPrice());
        television.setAvailableSize(dto.getAvailableSize());
        television.setRefreshRate(dto.getRefreshRate());
        television.setScreenType(dto.getScreenType());
        television.setScreenQuality(dto.getScreenQuality());
        television.setSmartTv(dto.isSmartTv());
        television.setWifi(dto.isWifi());
        television.setVoiceControl(dto.isVoiceControl());
        television.setHdr(dto.isHdr());
        television.setBluetooth(dto.isBluetooth());
        television.setAmbiLight(dto.isAmbiLight());
        television.setOriginalStock(dto.getOriginalStock());
        television.setSold(dto.getSold());

        return television;
    }
}
