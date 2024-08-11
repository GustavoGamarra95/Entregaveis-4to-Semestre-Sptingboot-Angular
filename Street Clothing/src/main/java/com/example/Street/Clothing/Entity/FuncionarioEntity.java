package com.example.Street.Clothing.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Entity
@Table (name = "funcionario")


public class FuncionarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private Integer edade;
    private String direccion;
    private String funcion;

    @JsonIgnore
    @OneToMany(mappedBy = "funcionario")
    private List<VentasEntity> ventas;


}