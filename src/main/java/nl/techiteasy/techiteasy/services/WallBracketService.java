package nl.techiteasy.techiteasy.services;

import nl.techiteasy.techiteasy.dtos.WallBracketDto;
import nl.techiteasy.techiteasy.dtos.WallBracketInputDto;
import nl.techiteasy.techiteasy.exceptions.RecordNotFoundException;
import nl.techiteasy.techiteasy.mappers.WallBracketMapper;
import nl.techiteasy.techiteasy.models.WallBracket;
import nl.techiteasy.techiteasy.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WallBracketService {

    private final WallBracketRepository wallBracketRepository;

    public WallBracketService(WallBracketRepository wallBracketRepository) {
        this.wallBracketRepository = wallBracketRepository;
    }

    public List<WallBracketDto> getWallBrackets() {
        List<WallBracket> wallBrackets = wallBracketRepository.findAll();
        List<WallBracketDto> dtoWallBrackets = new ArrayList<>();
        for (WallBracket wallBracket : wallBrackets) {
            dtoWallBrackets.add(WallBracketMapper.toWallBracketDto(wallBracket));
        }
        return dtoWallBrackets;
    }

    public WallBracketDto getWallBracket(Long id) {
        WallBracket wallBracket = wallBracketRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("WallBracket " + id + " not found"));
        return WallBracketMapper.toWallBracketDto(wallBracket);
    }

    public WallBracketDto saveWallBracket(WallBracketInputDto inputDto) {
        WallBracket wallBracket = WallBracketMapper.toWallBracket(inputDto);
        WallBracket saved = wallBracketRepository.save(wallBracket);
        return WallBracketMapper.toWallBracketDto(saved);
    }

    public WallBracketDto updateWallBracket(Long id, WallBracketInputDto inputDto) {
        WallBracket existingWallBracket = wallBracketRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("WallBracket " + id + " not found"));

       existingWallBracket.setSize(inputDto.size);
       existingWallBracket.setAdjustable(inputDto.adjustable);
       existingWallBracket.setName(inputDto.name);
       existingWallBracket.setPrice(inputDto.price);

        WallBracket updated = wallBracketRepository.save(existingWallBracket);
        return WallBracketMapper.toWallBracketDto(updated);
    }
}
