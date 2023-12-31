package com.microservice.departmentsSouth.repository;

import com.microservice.departmentsSouth.models.DepartmentSouthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeparmentSouthRepository extends JpaRepository<DepartmentSouthEntity,Long> {
}
