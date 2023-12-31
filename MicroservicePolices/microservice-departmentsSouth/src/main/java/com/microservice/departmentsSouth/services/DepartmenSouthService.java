package com.microservice.departmentsSouth.services;


import com.microservice.departmentsSouth.config.PoliceClientSouth;
import com.microservice.departmentsSouth.http.response.PoliceByDeparmentSouthResponse;
import com.microservice.departmentsSouth.models.DepartmentSouthEntity;
import com.microservice.departmentsSouth.repository.DeparmentSouthRepository;
import com.microservice.policies.microservicepolicies.controllers.dto.PoliceDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmenSouthService implements IDepartmentSouthService {

    private final DeparmentSouthRepository deparmentSouthRepository;

    private final PoliceClientSouth policeClientSouth;

    public DepartmenSouthService(DeparmentSouthRepository deparmentSouthRepository, PoliceClientSouth policeClientSouth) {
        this.deparmentSouthRepository = deparmentSouthRepository;

        this.policeClientSouth = policeClientSouth;
    }


    @Override
    public List<DepartmentSouthEntity> findAll() {
        return deparmentSouthRepository.findAll();
    }

    @Override
    public Optional<DepartmentSouthEntity> findById(Long idDepartmentSouth) {
        return deparmentSouthRepository.findById(idDepartmentSouth);
    }

    @Override
    public void save(DepartmentSouthEntity departmentSouthEntity) {
        deparmentSouthRepository.save(departmentSouthEntity);
    }

    @Override
    public void deleteById(Long idDepartmentSouth) {
        deparmentSouthRepository.deleteById(idDepartmentSouth);
    }

    @Override
    public PoliceByDeparmentSouthResponse findPoliceByIdDepartmentSouth(Long idDepartmentSouth) {
        Optional<DepartmentSouthEntity> departmentSouthEntity = findById(idDepartmentSouth);
        if(departmentSouthEntity.isPresent()){
            List<PoliceDto> policeDtoList = policeClientSouth.finAllPoliceByDepartmentSouth(idDepartmentSouth);
            return PoliceByDeparmentSouthResponse.builder()
                    .name(departmentSouthEntity.get().getName())
                    .boosInfo(policeClientSouth.findBoosById(departmentSouthEntity.get().getIdBoss()))
                    .policeDtoList(policeDtoList)
                    .build();
        }
        else{
            return new PoliceByDeparmentSouthResponse();
        }
    }

    public PoliceDto finBossPoliceById(Long id){
        return policeClientSouth.findBoosById(id);
    }
}

