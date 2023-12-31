package com.microservice.policies.microservicepolicies.models;


import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data

@Entity
@Table(name="tb_police")
public class PoliceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String dni;
    private String age;
    @Column(name = "id_deparmentNorth")
    private Long idDepartmenNorth;
    @Column(name = "id_deparmentSouth")
    private Long idDepartmenSouth;


    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(10) default 'ACTIVO'",name = "state")
    public EstadoPolice statePolice;

}
