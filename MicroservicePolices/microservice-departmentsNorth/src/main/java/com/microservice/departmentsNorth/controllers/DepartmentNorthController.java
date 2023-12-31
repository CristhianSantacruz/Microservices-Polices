package com.microservice.departmentsNorth.controllers;

import com.microservice.departmentsNorth.dto.DepartmentNorthDto;
import com.microservice.departmentsNorth.models.DepartmentNorthEntity;
import com.microservice.departmentsNorth.service.DepartmentNorthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/depanorth")
public class DepartmentNorthController {
    
    private final DepartmentNorthService departmentNorthService;


    public DepartmentNorthController(DepartmentNorthService departmentNorthService) {
        this.departmentNorthService = departmentNorthService;
        
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<DepartmentNorthEntity> depaNorth = departmentNorthService.findById(id);
        if(depaNorth.isPresent()){
            DepartmentNorthDto departmentNorthDto = DepartmentNorthDto.builder()
                    .id(depaNorth.get().getId())
                    .location(depaNorth.get().getLocation())
                    .name(depaNorth.get().getName())
                    .policeDtoBoss(departmentNorthService.finBossPoliceById(depaNorth.get().getId_boss()))
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(departmentNorthDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("De[a not found");
    }

    @GetMapping("/all")
    public ResponseEntity<List<?>> findAll(){

        List<DepartmentNorthDto> departmentNorthDtos = departmentNorthService.findAll().stream()
                .map(departmentNorth -> DepartmentNorthDto.builder()
                        .id(departmentNorth.getId())
                        .name(departmentNorth.getName())
                        .location(departmentNorth.getLocation())
                        .policeDtoBoss(departmentNorthService.finBossPoliceById(departmentNorth.getId_boss()))
                        .build()

        ).toList();
        return ResponseEntity.ok().body(departmentNorthDtos);
    }

    @PostMapping("/save")
    public void save(@RequestBody DepartmentNorthEntity depaNorth){
        departmentNorthService.save(depaNorth);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id){

        Optional<DepartmentNorthEntity> depaNorth = departmentNorthService.findById(id);
        if(depaNorth.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found");
        }
        departmentNorthService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted department");
    }
    @GetMapping("/search-police/{idDepartmentNorth}")
    public ResponseEntity<?> findPoliceByIdDepartmentNorth(@PathVariable  Long idDepartmentNorth){
        return ResponseEntity.ok().body(departmentNorthService.findPoliceByIdDepartmentNorth(idDepartmentNorth));
    }
    
}
