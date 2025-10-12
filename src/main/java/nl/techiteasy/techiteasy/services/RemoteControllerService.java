package nl.techiteasy.techiteasy.services;

import nl.techiteasy.techiteasy.dtos.RemoteControllerDto;
import nl.techiteasy.techiteasy.dtos.RemoteControllerInputDto;
import nl.techiteasy.techiteasy.exceptions.RecordNotFoundException;
import nl.techiteasy.techiteasy.mappers.RemoteControllerMapper;
import nl.techiteasy.techiteasy.models.RemoteController;
import nl.techiteasy.techiteasy.repositories.RemoteControllerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RemoteControllerService {

    private final RemoteControllerRepository remoteControllerRepository;

    public RemoteControllerService(RemoteControllerRepository remoteControllerRepository) {
        this.remoteControllerRepository = remoteControllerRepository;
    }

    public List<RemoteControllerDto> getRemoteControllers() {
        List<RemoteController> remoteControllers = remoteControllerRepository.findAll();
        List<RemoteControllerDto> dtoRemoteControllers = new ArrayList<>();
        for (RemoteController remoteController : remoteControllers) {
            dtoRemoteControllers.add(RemoteControllerMapper.toRemoteControllerDto(remoteController));
        }
        return dtoRemoteControllers;
    }

    public RemoteControllerDto getRemoteController(Long id) {
        RemoteController remoteController = remoteControllerRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("RemoteController " + id + " not found"));
        return RemoteControllerMapper.toRemoteControllerDto(remoteController);
    }

    public RemoteControllerDto saveRemoteController(RemoteControllerInputDto inputDto) {
        RemoteController remoteController = RemoteControllerMapper.toRemoteController(inputDto);
        RemoteController saved = remoteControllerRepository.save(remoteController);
        return RemoteControllerMapper.toRemoteControllerDto(saved);
    }

    public RemoteControllerDto updateRemoteController(Long id, RemoteControllerInputDto inputDto) {
        RemoteController existingRemoteController = remoteControllerRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("RemoteController " + id + " not found"));

        existingRemoteController.setCompatibleWith(inputDto.compatibleWith);
        existingRemoteController.setBatteryType(inputDto.batteryType);
        existingRemoteController.setName(inputDto.name);
        existingRemoteController.setBrand(inputDto.brand);
        existingRemoteController.setPrice(inputDto.price);
        existingRemoteController.setOriginalStock(inputDto.originalStock);

        RemoteController updatedRemoteController = remoteControllerRepository.save(existingRemoteController);
        return RemoteControllerMapper.toRemoteControllerDto(updatedRemoteController);
    }

    public void deleteRemoteController(Long id) {
        RemoteController existingRemoteController = remoteControllerRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("RemoteController " + id + " not found"));
        remoteControllerRepository.delete(existingRemoteController);
    }
}
