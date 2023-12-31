package com.microservice.departmentsSouth.dto;

import com.microservice.policies.microservicepolicies.controllers.dto.PoliceDto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DepartmentSouthDto {

    private Long id;
    private String name;
    private String location;

    private PoliceDto policeDtoBoss;
}
