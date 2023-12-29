package com.microservice.departmentsNorth.controllers;

import com.microservice.departmentsNorth.models.DepartmentNorthEntity;
import com.microservice.departmentsNorth.service.DepartmentNorthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/depanorth/")
public class DepartmentNorthController {
    
    private final DepartmentNorthService departmentNorthService;

    public DepartmentNorthController(DepartmentNorthService departmentNorthService) {
        this.departmentNorthService = departmentNorthService;
        
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<DepartmentNorthEntity> depaNorth = departmentNorthService.findById(id);
        if(depaNorth.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(depaNorth.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("De[a not found");
    }

    @GetMapping("/all")
    public ResponseEntity<List<DepartmentNorthEntity>> findAll(){
        return ResponseEntity.ok(departmentNorthService.findAll());
    }

    @PostMapping("/save")
    public void save(@RequestBody DepartmentNorthEntity depaNorth){
        departmentNorthService.save(depaNorth);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id){

        Optional<DepartmentNorthEntity> depaNorth = departmentNorthService.findById(id);
        if(depaNorth.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Depa not found");
        }
        departmentNorthService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted depa");
    }
    
}
