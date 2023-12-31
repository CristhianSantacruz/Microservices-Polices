package com.microservice.departmentsSouth.controller;


import com.microservice.departmentsNorth.dto.DepartmentNorthDto;
import com.microservice.departmentsNorth.models.DepartmentNorthEntity;
import com.microservice.departmentsSouth.dto.DepartmentSouthDto;
import com.microservice.departmentsSouth.models.DepartmentSouthEntity;
import com.microservice.departmentsSouth.services.DepartmenSouthService;
import com.microservice.departmentsSouth.services.IDepartmentSouthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/depasouth")
public class DepartmentSouthController {
    
    private final DepartmenSouthService departmenSouthService;

    public DepartmentSouthController(DepartmenSouthService departmenSouthService) {
        this.departmenSouthService = departmenSouthService;
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<DepartmentSouthEntity> depaSouth= departmenSouthService.findById(id);
        if(depaSouth.isPresent()){
            DepartmentSouthDto departmentSouthDto = DepartmentSouthDto.builder()
                    .id(depaSouth.get().getId())
                    .location(depaSouth.get().getLocation())
                    .name(depaSouth.get().getName())
                    .policeDtoBoss(departmenSouthService.finBossPoliceById(depaSouth.get().getIdBoss()))
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(departmentSouthDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found");
    }

   @GetMapping("/all")
   public ResponseEntity<List<?>> findAll(){
        List<DepartmentSouthDto> departmentSouthDtos = departmenSouthService.findAll()
                .stream().map(departmentSouthEntity -> DepartmentSouthDto.builder()
                        .id(departmentSouthEntity.getId())
                        .name(departmentSouthEntity.getName())
                        .location(departmentSouthEntity.getLocation())
                        .policeDtoBoss(departmenSouthService.finBossPoliceById(departmentSouthEntity.getIdBoss()))
                        .build()).toList();

    return ResponseEntity.ok().body(departmentSouthDtos);
    }

    @PostMapping("/save")
    public void save(@RequestBody DepartmentSouthEntity departmentSouthEntity){
        departmenSouthService.save(departmentSouthEntity);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id){

        Optional<DepartmentSouthEntity> departmentSouth = departmenSouthService.findById(id);
        if(departmentSouth.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deparment not found");
        }

        departmenSouthService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted department");
    }

    @GetMapping("/search-police/{idDeparmentSouth}")
    public ResponseEntity<?> findPoliceDeparmentSouth(@PathVariable Long idDeparmentSouth){
        return ResponseEntity.ok().body(departmenSouthService.findPoliceByIdDepartmentSouth(idDeparmentSouth));

    }
}
