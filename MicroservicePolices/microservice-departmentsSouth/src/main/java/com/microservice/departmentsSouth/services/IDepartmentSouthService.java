package com.microservice.departmentsSouth.services;



import com.microservice.departmentsSouth.http.response.PoliceByDeparmentSouthResponse;
import com.microservice.departmentsSouth.models.DepartmentSouthEntity;

import java.util.List;
import java.util.Optional;

public interface IDepartmentSouthService {


    List<DepartmentSouthEntity> findAll();
    Optional<DepartmentSouthEntity> findById(Long idDepartmentNorth);
    void save(DepartmentSouthEntity departmentNorthEntity);
    void deleteById(Long  idDepartmentNorth);

   PoliceByDeparmentSouthResponse findPoliceByIdDepartmentSouth(Long idDepartmentSouth);



}
