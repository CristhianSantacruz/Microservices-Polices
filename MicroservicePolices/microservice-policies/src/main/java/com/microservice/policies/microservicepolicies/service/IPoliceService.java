package com.microservice.policies.microservicepolicies.service;

import com.microservice.policies.microservicepolicies.controllers.dto.PoliceDto;
import com.microservice.policies.microservicepolicies.models.PoliceEntity;

import java.util.List;
import java.util.Optional;

public interface IPoliceService {

    List<PoliceEntity> findByAll();

    Optional<PoliceEntity> findById(Long id);

    void save(PoliceEntity policeEntity);

    void deleteById(Long id);

    List<PoliceEntity> findAllByDepartmentNorth(Long idDepartmentNorth);

    List<PoliceEntity> findAllByDepartmentSouth(Long idDepartmentSouth);
}
