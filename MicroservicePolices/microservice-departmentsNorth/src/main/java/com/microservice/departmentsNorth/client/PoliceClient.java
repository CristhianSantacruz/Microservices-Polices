package com.microservice.departmentsNorth.client;


import com.microservice.policies.microservicepolicies.controllers.dto.PoliceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-policies",url = "localhost:8090/api/police")
public interface  PoliceClient {

    @GetMapping("/search-by-depanorth/{idDepartmentNorth}")
    List<PoliceDto> findAllPoliceByDepartmentNorth(@PathVariable Long idDepartmentNorth);


    @GetMapping("/search/{id}")
    PoliceDto findBoosById(@PathVariable Long id);

  
}
