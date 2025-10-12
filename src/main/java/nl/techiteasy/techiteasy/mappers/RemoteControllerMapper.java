package nl.techiteasy.techiteasy.mappers;

import nl.techiteasy.techiteasy.dtos.RemoteControllerDto;
import nl.techiteasy.techiteasy.dtos.RemoteControllerInputDto;
import nl.techiteasy.techiteasy.models.RemoteController;


public class RemoteControllerMapper {

    public static RemoteControllerDto toRemoteControllerDto(RemoteController remoteController) {
        var dto = new RemoteControllerDto();

        dto.id = remoteController.getId();
        dto.compatibleWith = remoteController.getCompatibleWith();
        dto.batteryType = remoteController.getBatteryType();
        dto.name = remoteController.getName();
        dto.brand = remoteController.getBrand();
        dto.price = remoteController.getPrice();
        dto.originalStock = remoteController.getOriginalStock();

        return dto;
    }

    public static RemoteController toRemoteController(RemoteControllerInputDto dto) {
        var remoteController = new RemoteController();

        remoteController.setCompatibleWith(dto.compatibleWith);
        remoteController.setBatteryType(dto.batteryType);
        remoteController.setName(dto.name);
        remoteController.setBrand(dto.brand);
        remoteController.setPrice(dto.price);
        remoteController.setOriginalStock(dto.originalStock);

        return remoteController;
    }
}
