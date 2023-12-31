package com.microservice.policies.microservicepolicies.controllers;

import com.microservice.policies.microservicepolicies.controllers.dto.PoliceDto;
import com.microservice.policies.microservicepolicies.models.EstadoPolice;
import com.microservice.policies.microservicepolicies.models.PoliceEntity;
import com.microservice.policies.microservicepolicies.service.implement.PoliceService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/police")
public class PoliceController {
    private final PoliceService policeService;

    public PoliceController(PoliceService policeService) {
        this.policeService = policeService;
    }


    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<PoliceEntity> policeEntity = policeService.findById(id);
        if(policeEntity.isPresent()){
            PoliceEntity police = policeEntity.get();
            PoliceDto policeDto = PoliceDto.builder()
                    .id(police.getId())
                    .name(police.getName())
                    .age(police.getAge())
                    .dni(police.getDni())
                    .idDepartmenNorth(police.getIdDepartmenNorth())
                    .idDepartmenSouth(police.getIdDepartmenSouth())
                    .statePolice(police.statePolice.name().toUpperCase())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(policeDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Police not found");
    }

    @GetMapping("/all")
    public ResponseEntity<List<?>> findAll(){

        List<PoliceDto> policeDtoList = policeService.findByAll()
                .stream().map(police-> PoliceDto.builder()
                        .name(police.getName())
                        .id(police.getId())
                        .age(police.getAge())
                        .dni(police.getDni())
                        .idDepartmenNorth(police.getIdDepartmenNorth())
                        .idDepartmenSouth(police.getIdDepartmenSouth())
                        .statePolice(police.getStatePolice().name().toUpperCase())
                        .build()

                ).toList();

        return ResponseEntity.ok().body(policeDtoList);
    }

    @PostMapping("/save")
    public void save(@RequestBody PoliceDto policeDto){

        policeService.save(PoliceEntity.builder()
                        .name(policeDto.getName())
                        .age(policeDto.getAge())
                        .dni(policeDto.getDni())
                        .idDepartmenSouth(policeDto.getIdDepartmenSouth())
                        .idDepartmenNorth(policeDto.getIdDepartmenNorth())
                        .statePolice(EstadoPolice.valueOf(policeDto.getStatePolice().toUpperCase()))
                .build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id){

        Optional<PoliceEntity> policeEntity = policeService.findById(id);
        if(policeEntity.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Police not found");
        }
        policeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted Police");
    }

    @GetMapping("/search-by-depanorth/{idDepartmentNorth}")
    public ResponseEntity<?> findByIdDepartmentNorth(@PathVariable Long idDepartmentNorth){
        return ResponseEntity.ok(policeService.findAllByDepartmentNorth(idDepartmentNorth));
    }

    @GetMapping("/search-by-depasouth/{idDepartmentSouth}")
    public ResponseEntity<?> findByIdDepartmentSouth(@PathVariable Long idDepartmentSouth){
        return ResponseEntity.ok(policeService.findAllByDepartmentSouth(idDepartmentSouth));
    }
}
