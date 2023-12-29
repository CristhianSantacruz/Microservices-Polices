package com.microservice.departmentsNorth.http.response;

import com.microservice.departmentsNorth.dtos.PoliceDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PoliceByDeparmentNorthResponse {

    private String name;
    private String boosInfo;
    private List<PoliceDto> policeDtoList;
}
