package com.microservice.departmentsNorth.dto;

import com.microservice.policies.microservicepolicies.controllers.dto.PoliceDto;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentNorthDto {

    private Long id;
    private String name;
    private String location;

    private PoliceDto policeDtoBoss;
}
