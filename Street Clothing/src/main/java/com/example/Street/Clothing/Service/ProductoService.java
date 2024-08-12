package com.example.Street.Clothing.Service;

import com.example.Street.Clothing.Entity.ProductoEntity;
import com.example.Street.Clothing.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public ProductoEntity save(ProductoEntity productoEntity) {
        try {
            return this.productoRepository.save(productoEntity);
        } catch (Exception e) {
            System.out.println("Producto no guardado: " + e.getMessage());
            return new ProductoEntity();
        }
    }

    public ProductoEntity update(ProductoEntity productoEntity, Long id) {
        try {
            productoEntity.setId(id);
            return this.productoRepository.save(productoEntity);
        } catch (Exception e) {
            System.out.println("Producto no Actualizado: " + e.getMessage());
            return new ProductoEntity();
        }
    }

    public String delete(Long id) {
        try {
            this.productoRepository.deleteById(id);
            return "Eliminado";
        } catch (Exception e) {
            return "Producto no Eliminado";
        }
    }

    public ProductoEntity findById(Long id) {
        try {
            Optional<ProductoEntity> produto = this.productoRepository.findById(id);
            return produto.orElse(null);
        } catch (Exception e) {
            System.out.println("Erro ao procurar o produto com ID " + id + ": " + e.getMessage());
            return new ProductoEntity();
        }
    }

    public List<ProductoEntity> findAll() {
        try {
            return this.productoRepository.findAll();
        } catch (Exception e) {
            System.out.println("Erro ao buscar todos os produtos: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<ProductoEntity> find10ProdutosMaisCaros() {
        return null;
    }


}
