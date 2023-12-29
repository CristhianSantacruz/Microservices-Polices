package com.microservice.policies.microservicepolicies.controllers;

import com.microservice.policies.microservicepolicies.models.PoliceEntity;
import com.microservice.policies.microservicepolicies.service.implement.PoliceService;
import lombok.Getter;
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
            return ResponseEntity.status(HttpStatus.OK).body(policeEntity.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Police not found");
    }

    @GetMapping("/all")
    public ResponseEntity<List<PoliceEntity>> findAll(){
        return ResponseEntity.ok(policeService.findByAll());
    }

    @PostMapping("/save")
    public void save(@RequestBody PoliceEntity policeEntity){
        policeService.save(policeEntity);
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
}
