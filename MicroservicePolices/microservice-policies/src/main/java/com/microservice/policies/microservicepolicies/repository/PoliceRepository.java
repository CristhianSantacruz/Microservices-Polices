package com.microservice.policies.microservicepolicies.repository;

import com.microservice.policies.microservicepolicies.models.PoliceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoliceRepository extends JpaRepository<PoliceEntity,Long> {

    @Query("select p from PoliceEntity p where p.idDepartmenNorth = ?1")
    List<PoliceEntity> findAllByDepartmentNorth(Long idDepartmentNorth);

    @Query("select p from PoliceEntity p where p. = ?1")
    List<PoliceEntity> findAllByDepartmentSouth(Long idDepartmentb);
}
