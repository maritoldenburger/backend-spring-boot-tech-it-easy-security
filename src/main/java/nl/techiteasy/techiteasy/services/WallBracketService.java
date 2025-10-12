package nl.techiteasy.techiteasy.services;

import nl.techiteasy.techiteasy.repositories.RemoteControllerRepository;
import nl.techiteasy.techiteasy.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

@Service
public class WallBracketService {

    private final WallBracketRepository wallBracketRepository;

    public WallBracketService(WallBracketRepository wallBracketRepository) {
        this.wallBracketRepository = wallBracketRepository;
    }
}
