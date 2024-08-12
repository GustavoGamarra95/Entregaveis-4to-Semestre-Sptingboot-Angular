package com.example.Street.Clothing.Controllers;
import com.example.Street.Clothing.Entity.VentasEntity;
import com.example.Street.Clothing.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venta")

public class VentaControllers {
    @Autowired
    private VentaService ventaService;

    @PostMapping("/save")
    public ResponseEntity<VentasEntity> save(@RequestBody VentasEntity ventasEntity) {
        try {
            VentasEntity venta = this.ventaService.save(ventasEntity);
            return new ResponseEntity<>(venta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<VentasEntity> update(@RequestBody VentasEntity ventasEntity, @PathVariable Long id) {
        try {
            VentasEntity venta = this.ventaService.update(ventasEntity, id);
            return new ResponseEntity<>(venta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        try {
            String mensaje = this.ventaService.delete(id);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la venta", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<VentasEntity> findById(@PathVariable long id) {
        try {
            VentasEntity venta = this.ventaService.findById(id);
            return new ResponseEntity<>(venta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<VentasEntity>> findAll() {
        try {
            List<VentasEntity> lista = this.ventaService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByClienteNombre")
    public ResponseEntity<List<VentasEntity>> findByClienteNombre(@RequestParam String nombreCliente) {
        try {
            List<VentasEntity> ventas = ventaService.findByClienteNombre(nombreCliente);
            return new ResponseEntity<>(ventas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByFuncionarioNombre")
    public ResponseEntity<List<VentasEntity>> findByFuncionarioNombre(@RequestParam String nombreFuncionario) {
        try {
            List<VentasEntity> ventas = ventaService.findByFuncionarioNombre(nombreFuncionario);
            return new ResponseEntity<>(ventas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find10ConTotalMasAlto")
    public ResponseEntity<List<VentasEntity>> find10ComTotalMaisAlto() {
        try {
            List<VentasEntity> ventas = ventaService.find10ComTotalMaisAlto();
            return new ResponseEntity<>(ventas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
