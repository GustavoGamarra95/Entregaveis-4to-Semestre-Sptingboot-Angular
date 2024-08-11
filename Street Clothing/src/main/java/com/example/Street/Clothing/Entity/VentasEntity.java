package com.example.Street.Clothing.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "venta")

public class VentasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String observacion;
    private Double total;

    @ManyToOne
    @JoinColumn (name = "cliente_id")
    private FuncionarioEntity funcionario;

    @ManyToMany
    @JoinTable(
            name = "venda_item",
            joinColumns = @JoinColumn(name = "venta_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<ProductoEntity> productos;


}
