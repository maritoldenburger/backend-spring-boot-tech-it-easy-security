package nl.techiteasy.techiteasy.services;

import nl.techiteasy.techiteasy.dtos.CIModuleDto;
import nl.techiteasy.techiteasy.dtos.CIModuleInputDto;
import nl.techiteasy.techiteasy.exceptions.RecordNotFoundException;
import nl.techiteasy.techiteasy.mappers.CIModuleMapper;
import nl.techiteasy.techiteasy.models.CIModule;
import nl.techiteasy.techiteasy.repositories.CIModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CIModuleService {

    private final CIModuleRepository ciModuleRepository;

    public CIModuleService(CIModuleRepository ciModuleRepository) {
        this.ciModuleRepository = ciModuleRepository;
    }

    public List<CIModuleDto> getCIModules() {
        List<CIModule> ciModules = ciModuleRepository.findAll();
        List<CIModuleDto> dtoCIModules = new ArrayList<>();
        for (CIModule ciModule : ciModules) {
            dtoCIModules.add(CIModuleMapper.toCIModuleDto(ciModule));
        }
        return dtoCIModules;
    }

    public CIModuleDto getCIModule(Long id) {
        CIModule ciModule = ciModuleRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("CIModule " + id + " not found"));
        return CIModuleMapper.toCIModuleDto(ciModule);
    }

    public CIModuleDto saveCIModule(CIModuleInputDto inputDto) {
        CIModule ciModule = CIModuleMapper.toCIModule(inputDto);
        CIModule saved = ciModuleRepository.save(ciModule);
        return CIModuleMapper.toCIModuleDto(saved);
    }

    public CIModuleDto updateCIModule(Long id, CIModuleInputDto inputDto) {
        CIModule existingCIModule = ciModuleRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("CIModule " + id + " not found"));

        existingCIModule.setName(inputDto.name);
        existingCIModule.setType(inputDto.type);
        existingCIModule.setPrice(inputDto.price);

        CIModule updated = ciModuleRepository.save(existingCIModule);
        return CIModuleMapper.toCIModuleDto(updated);
    }

    public void deleteCIModule(Long id) {
        CIModule existingCIModule = ciModuleRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("CIModule " + id + " not found"));
        ciModuleRepository.delete(existingCIModule);
    }
}
