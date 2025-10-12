package nl.techiteasy.techiteasy.mappers;

import nl.techiteasy.techiteasy.dtos.TelevisionDto;
import nl.techiteasy.techiteasy.dtos.TelevisionInputDto;
import nl.techiteasy.techiteasy.models.Television;

public class TelevisionMapper {

    public static TelevisionDto toTelevisionDto(Television television) {
        var dto = new TelevisionDto();

        dto.id = television.getId();
        dto.type = television.getType();
        dto.brand = television.getBrand();
        dto.name = television.getName();
        dto.price = television.getPrice();
        dto.availableSize = television.getAvailableSize();
        dto.refreshRate = television.getRefreshRate();
        dto.screenType = television.getScreenType();
        dto.screenQuality = television.getScreenQuality();
        dto.smartTv = television.isSmartTv();
        dto.wifi = television.isWifi();
        dto.voiceControl = television.isVoiceControl();
        dto.hdr = television.isHdr();
        dto.bluetooth = television.isBluetooth();
        dto.ambiLight = television.isAmbiLight();
        dto.originalStock = television.getOriginalStock();
        dto.sold = television.getSold();

        return dto;
    }

    public static Television toTelevision(TelevisionInputDto dto) {
        var television = new Television();

        television.setId(dto.id);
        television.setType(dto.type);
        television.setBrand(dto.brand);
        television.setName(dto.name);
        television.setPrice(dto.price);
        television.setAvailableSize(dto.availableSize);
        television.setRefreshRate(dto.refreshRate);
        television.setScreenType(dto.screenType);
        television.setScreenQuality(dto.screenQuality);
        television.setSmartTv(dto.smartTv);
        television.setWifi(dto.wifi);
        television.setVoiceControl(dto.voiceControl);
        television.setHdr(dto.hdr);
        television.setBluetooth(dto.bluetooth);
        television.setAmbiLight(dto.ambiLight);
        television.setOriginalStock(dto.originalStock);
        television.setSold(dto.sold);

        return television;
    }
}
