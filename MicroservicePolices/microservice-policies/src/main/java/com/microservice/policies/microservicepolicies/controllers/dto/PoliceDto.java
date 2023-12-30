package com.microservice.policies.microservicepolicies.controllers.dto;

import com.microservice.policies.microservicepolicies.models.EstadoPolice;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class PoliceDto {

    private Long id;
    private String name;
    private String dni;
    private String age;
    private Long idDepartmenNorth;
    private Long idDepartmenSouth;
    public  String statePolice;

}