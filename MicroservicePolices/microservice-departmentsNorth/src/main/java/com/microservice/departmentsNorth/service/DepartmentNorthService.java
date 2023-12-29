package com.microservice.departmentsNorth.service;

import com.microservice.departmentsNorth.client.PoliceClient;
import com.microservice.departmentsNorth.dtos.PoliceDto;
import com.microservice.departmentsNorth.http.response.PoliceByDeparmentNorthResponse;
import com.microservice.departmentsNorth.models.DepartmentNorthEntity;
import com.microservice.departmentsNorth.repository.DepartmentNorthRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentNorthService implements IDepartmentNorthService{

    private final DepartmentNorthRepository departmentNorthRepository;

    private final PoliceClient policeClient;

    public DepartmentNorthService(DepartmentNorthRepository departmentNorthRepository, PoliceClient policeClient){
        this.departmentNorthRepository = departmentNorthRepository;
        this.policeClient = policeClient;
    }

    @Override
    public List<DepartmentNorthEntity> findAll() {
        return departmentNorthRepository.findAll();
    }

    @Override
    public Optional<DepartmentNorthEntity> findById(Long idDepartmentNorth) {
        return departmentNorthRepository.findById(idDepartmentNorth);
    }

    @Override
    public void save(DepartmentNorthEntity departmentNorthEntity) {
        departmentNorthRepository.save(departmentNorthEntity);
    }

    @Override
    public void deleteById(Long idDepartmentNorth) {
        departmentNorthRepository.deleteById(idDepartmentNorth);
    }

    @Override
    public PoliceByDeparmentNorthResponse findPoliceByIdDepartmentNorth(Long idDeparmentNorth) {

        Optional<DepartmentNorthEntity> departmentNorthEntity = findById(idDeparmentNorth);
        if(departmentNorthEntity.isEmpty()){
            List<PoliceDto> policeDtoList = policeClient.findAllPoliceByDepartmentNorth(idDeparmentNorth);



            return PoliceByDeparmentNorthResponse.builder()
                    .name(departmentNorthEntity.get().getName())
                    .boosInfo(null)
                    .policeDtoList(policeDtoList)
                    .build();
        }
        return null;


    }
}
