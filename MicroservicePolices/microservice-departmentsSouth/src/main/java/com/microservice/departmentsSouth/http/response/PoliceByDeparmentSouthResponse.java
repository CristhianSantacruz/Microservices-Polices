package com.microservice.departmentsSouth.http.response;

import com.microservice.policies.microservicepolicies.controllers.dto.PoliceDto;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class PoliceByDeparmentSouthResponse {
    private String name;
    private PoliceDto boosInfo;
    private List<PoliceDto> policeDtoList;
}





