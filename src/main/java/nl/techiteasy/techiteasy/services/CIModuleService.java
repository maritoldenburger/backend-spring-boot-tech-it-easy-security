package nl.techiteasy.techiteasy.services;

import nl.techiteasy.techiteasy.repositories.CIModuleRepository;
import org.springframework.stereotype.Service;

@Service
public class CIModuleService {

    private final CIModuleRepository ciModuleRepository;

    public CIModuleService(CIModuleRepository ciModuleRepository) {
        this.ciModuleRepository = ciModuleRepository;
    }
}
