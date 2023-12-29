package com.microservice.departmentsNorth.repository;

import com.microservice.departmentsNorth.models.DepartmentNorthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentNorthRepository extends JpaRepository<DepartmentNorthEntity,Long> {
}
