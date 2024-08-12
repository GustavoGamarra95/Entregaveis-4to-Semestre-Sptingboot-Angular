package com.example.Street.Clothing.Repository;

import com.example.Street.Clothing.Entity.ProductoEntity;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {

    @Query(value = "SELECT * FROM tb_produto ORDER BY precio DESC LIMIT 10", nativeQuery = true)
    List<ProductoEntity> find10ProdutosMaisCaros();

}
