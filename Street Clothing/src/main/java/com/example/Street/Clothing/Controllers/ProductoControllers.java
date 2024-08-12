package com.example.Street.Clothing.Controllers;


import com.example.Street.Clothing.Entity.ProductoEntity;
import com.example.Street.Clothing.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProductoControllers {
    @Autowired
    private ProductoService productoService;

    @PostMapping("/save")
    public ResponseEntity<ProductoEntity> save(@RequestBody ProductoEntity productoEntity) {
        try {
            ProductoEntity producto = this.productoService.save(productoEntity);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductoEntity> update(@RequestBody ProductoService productoEntity, @PathVariable Long id) {
        try {
            ProductoEntity producto = this.productoService.update(productoEntity, id);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        try {
            String mensage = this.productoService.delete(id);
            return new ResponseEntity<>(mensage, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ProductoEntity> findById(@PathVariable long id) {
        try {
            ProductoEntity produto = this.productoService.findById(id);
            return new ResponseEntity<>(produto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ProductoEntity>> findAll() {
        try {
            List<ProductoEntity> lista = this.productoService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find10ProdutosMaisCaros")
    public ResponseEntity<List<ProductoEntity>> find10ProdutosMaisCaros() {
        try {
            List<ProductoEntity> lista = this.productoService.find10ProdutosMaisCaros();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
