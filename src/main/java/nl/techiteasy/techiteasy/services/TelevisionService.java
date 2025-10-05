package nl.techiteasy.techiteasy.services;

import nl.techiteasy.techiteasy.dtos.TelevisionDto;
import nl.techiteasy.techiteasy.dtos.TelevisionInputDto;
import nl.techiteasy.techiteasy.exceptions.RecordNotFoundException;
import nl.techiteasy.techiteasy.mappers.TelevisionMapper;
import nl.techiteasy.techiteasy.models.Television;
import nl.techiteasy.techiteasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionService {

    private final TelevisionRepository repos;

    public TelevisionService(TelevisionRepository repos) {
        this.repos = repos;
    }

    public List<TelevisionDto> getTelevisions() {
        List<Television> televisions = repos.findAll();
        List<TelevisionDto> dtos = new ArrayList<>();
        for (Television tv : televisions) {
            dtos.add(TelevisionMapper.toTelevisionDto(tv));
        }
        return dtos;
    }

    public TelevisionDto getTelevision(Long id) {
        Television television = repos.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television " + id + " not found"));
        return TelevisionMapper.toTelevisionDto(television);
    }

    public TelevisionDto saveTelevision(TelevisionInputDto inputDto) {
        Television television = TelevisionMapper.toTelevision(inputDto);
        Television saved = repos.save(television);
        return TelevisionMapper.toTelevisionDto(saved);
    }

    public TelevisionDto updateTelevision(Long id, TelevisionInputDto inputDto) {
        Television existingTelevision = repos.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television " + id + " not found"));

        existingTelevision.setType(inputDto.getType());
        existingTelevision.setBrand(inputDto.getBrand());
        existingTelevision.setName(inputDto.getName());
        existingTelevision.setPrice(inputDto.getPrice());
        existingTelevision.setAvailableSize(inputDto.getAvailableSize());
        existingTelevision.setRefreshRate(inputDto.getRefreshRate());
        existingTelevision.setScreenType(inputDto.getScreenType());
        existingTelevision.setScreenQuality(inputDto.getScreenQuality());
        existingTelevision.setSmartTv(inputDto.isSmartTv());
        existingTelevision.setWifi(inputDto.isWifi());
        existingTelevision.setVoiceControl(inputDto.isVoiceControl());
        existingTelevision.setHdr(inputDto.isHdr());
        existingTelevision.setBluetooth(inputDto.isBluetooth());
        existingTelevision.setAmbiLight(inputDto.isAmbiLight());
        existingTelevision.setOriginalStock(inputDto.getOriginalStock());
        existingTelevision.setSold(inputDto.getSold());

        Television updated = repos.save(existingTelevision);
        return TelevisionMapper.toTelevisionDto(updated);

    }

    public void deleteTelevision(Long id) {
        Television existingTelevision = repos.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television " + id + " not found"));
        repos.delete(existingTelevision);
    }
}
