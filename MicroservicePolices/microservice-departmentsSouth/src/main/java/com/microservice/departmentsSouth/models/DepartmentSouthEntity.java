package com.microservice.departmentsSouth.models;



import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "tb_deparment_south")
public class DepartmentSouthEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    @Column(name = "id_boss")
    private Long idBoss;

}
