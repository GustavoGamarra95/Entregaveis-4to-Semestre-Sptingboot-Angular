package com.example.Street.Clothing.Repository;


import com.example.Street.Clothing.Entity.VentasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VentaRepository extends JpaRepository<VentasEntity, Long> {

    @Query(value = "SELECT v.* FROM tb_venda v JOIN tb_cliente c ON v.cliente_id = c.id WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :nomeCliente, '%'))", nativeQuery = true)
    List<VentasEntity> findByClienteNome(@Param("nomeCliente") String nomeCliente);

    @Query(value = "SELECT v.* FROM tb_venda v JOIN tb_funcionario f ON v.funcionario_id = f.id WHERE LOWER(f.nome) LIKE LOWER(CONCAT('%', :nomeFuncionario, '%'))", nativeQuery = true)
    List<VentasEntity> findByFuncionarioNombre(@Param("nomeFuncionario") String nombreFuncionario);

    @Query(value = "SELECT * FROM tb_venda ORDER BY total DESC LIMIT 10", nativeQuery = true)
    List<VentasEntity> find10ComTotalMaisAlto();


}
