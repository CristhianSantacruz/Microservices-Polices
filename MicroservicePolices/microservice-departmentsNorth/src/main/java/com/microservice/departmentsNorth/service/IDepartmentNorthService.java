package com.microservice.departmentsNorth.service;

import com.microservice.departmentsNorth.http.response.PoliceByDeparmentNorthResponse;
import com.microservice.departmentsNorth.models.DepartmentNorthEntity;

import java.util.List;
import java.util.Optional;

public interface IDepartmentNorthService {

    List<DepartmentNorthEntity> findAll();
    Optional<DepartmentNorthEntity> findById(Long idDepartmentNorth);
    void save(DepartmentNorthEntity departmentNorthEntity);
    void deleteById(Long  idDepartmentNorth);

    PoliceByDeparmentNorthResponse findPoliceByIdDepartmentNorth(Long idDeparmentNorth);


}
