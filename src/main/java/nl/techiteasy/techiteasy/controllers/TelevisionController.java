package nl.techiteasy.techiteasy.controllers;

import nl.techiteasy.techiteasy.dtos.TelevisionDto;
import nl.techiteasy.techiteasy.dtos.TelevisionInputDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nl.techiteasy.techiteasy.services.TelevisionService;

import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService service;

    public TelevisionController(TelevisionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions() {
        List<TelevisionDto> dtos = service.getTelevisions();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDto> getTelevision(@PathVariable Long id) {
        TelevisionDto dto = service.getTelevision(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<TelevisionDto> createTelevision(@RequestBody TelevisionInputDto inputDto) {
        TelevisionDto savedDto = service.saveTelevision(inputDto);
        return ResponseEntity.created(null).body(savedDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionDto> updateTelevision(@PathVariable Long id, @RequestBody TelevisionInputDto inputDto) {
        TelevisionDto updatedDto = service.updateTelevision(id, inputDto);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable Long id) {
        service.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }
}
