package com.microservice.departmentsSouth.config;

import com.microservice.policies.microservicepolicies.controllers.dto.PoliceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-policies",url = "localhost:8090/api/police")
public interface PoliceClientSouth {
    @GetMapping("/search-by-depasouth/{idDepartmentSouth}")
    List<PoliceDto> finAllPoliceByDepartmentSouth(@PathVariable Long idDepartmentSouth);


    @GetMapping("/search/{id}")
    PoliceDto findBoosById(@PathVariable Long id);


}