package com.example.Street.Clothing.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table (name = "cliente")

public class ClienteEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private Integer edad;
    private String direccion;

    @JsonIgnore
    @OneToMany(mappedBy = "Cliente")
    private List<VentasEntity> ventas;


}
