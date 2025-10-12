package nl.techiteasy.techiteasy.services;

import nl.techiteasy.techiteasy.dtos.TelevisionDto;
import nl.techiteasy.techiteasy.dtos.TelevisionInputDto;
import nl.techiteasy.techiteasy.exceptions.RecordNotFoundException;
import nl.techiteasy.techiteasy.mappers.TelevisionMapper;
import nl.techiteasy.techiteasy.models.Television;
import nl.techiteasy.techiteasy.models.WallBracket;
import nl.techiteasy.techiteasy.repositories.CIModuleRepository;
import nl.techiteasy.techiteasy.repositories.RemoteControllerRepository;
import nl.techiteasy.techiteasy.repositories.TelevisionRepository;
import nl.techiteasy.techiteasy.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    private final RemoteControllerRepository remoteControllerRepository;

    private final CIModuleRepository ciModuleRepository;

    private final WallBracketRepository wallBracketRepository;

    public TelevisionService(TelevisionRepository televisionRepository,
                             RemoteControllerRepository remoteControllerRepository,
                             CIModuleRepository ciModuleRepository,
                             WallBracketRepository wallBracketRepository) {
        this.televisionRepository = televisionRepository;
        this.remoteControllerRepository = remoteControllerRepository;
        this.ciModuleRepository = ciModuleRepository;
        this.wallBracketRepository = wallBracketRepository;
    }

    public List<TelevisionDto> getTelevisions() {
        List<Television> televisions = televisionRepository.findAll();
        List<TelevisionDto> dtoTelevisions = new ArrayList<>();
        for (Television tv : televisions) {
            dtoTelevisions.add(TelevisionMapper.toTelevisionDto(tv));
        }
        return dtoTelevisions;
    }

    public TelevisionDto getTelevision(Long id) {
        Television television = televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television " + id + " not found"));
        return TelevisionMapper.toTelevisionDto(television);
    }

    public TelevisionDto saveTelevision(TelevisionInputDto inputDto) {
        Television television = TelevisionMapper.toTelevision(inputDto);
        Television saved = televisionRepository.save(television);
        return TelevisionMapper.toTelevisionDto(saved);
    }

    public TelevisionDto updateTelevision(Long id, TelevisionInputDto inputDto) {
        Television existingTelevision = televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television " + id + " not found"));

        existingTelevision.setType(inputDto.type);
        existingTelevision.setBrand(inputDto.brand);
        existingTelevision.setName(inputDto.name);
        existingTelevision.setPrice(inputDto.price);
        existingTelevision.setAvailableSize(inputDto.availableSize);
        existingTelevision.setRefreshRate(inputDto.refreshRate);
        existingTelevision.setScreenType(inputDto.screenType);
        existingTelevision.setScreenQuality(inputDto.screenQuality);
        existingTelevision.setSmartTv(inputDto.smartTv);
        existingTelevision.setWifi(inputDto.wifi);
        existingTelevision.setVoiceControl(inputDto.voiceControl);
        existingTelevision.setHdr(inputDto.hdr);
        existingTelevision.setBluetooth(inputDto.bluetooth);
        existingTelevision.setAmbiLight(inputDto.ambiLight);
        existingTelevision.setOriginalStock(inputDto.originalStock);
        existingTelevision.setSold(inputDto.sold);

        Television updated = televisionRepository.save(existingTelevision);
        return TelevisionMapper.toTelevisionDto(updated);
    }

    public void deleteTelevision(Long id) {
        Television existingTelevision = televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television " + id + " not found"));
        televisionRepository.delete(existingTelevision);
    }

    public void assignRemoteControllerToTelevision(Long televisionId, Long remoteControllerId) {
        var television = televisionRepository.findById(televisionId)
                .orElseThrow(() -> new RecordNotFoundException("Television " + televisionId + " not found"));

        var remoteController = remoteControllerRepository.findById(remoteControllerId)
                .orElseThrow(() -> new RecordNotFoundException("RemoteController " + remoteControllerId + " not found"));

        television.setRemoteController(remoteController);
        televisionRepository.save(television);
    }

    public void assignCiModuleToTelevision(Long televisionId, Long ciModuleId) {
        var television = televisionRepository.findById(televisionId)
                .orElseThrow(() -> new RecordNotFoundException("Television " + televisionId + " not found"));

        var ciModule = ciModuleRepository.findById(ciModuleId)
                .orElseThrow(() -> new RecordNotFoundException("CIModule " + ciModuleId + " not found"));

        television.setCiModule(ciModule);
        televisionRepository.save(television);
    }

    public void assignWallBracketToTelevision(Long televisionId, Long wallBracketId) {
        Television television = televisionRepository.findById(televisionId)
                .orElseThrow(() -> new RecordNotFoundException("Television " + televisionId + " not found"));

        WallBracket wallBracket = wallBracketRepository.findById(wallBracketId)
                .orElseThrow(() -> new RecordNotFoundException("WallBracket " + wallBracketId + " not found"));

        television.getWallBrackets().add(wallBracket);
        televisionRepository.save(television);
    }
}
