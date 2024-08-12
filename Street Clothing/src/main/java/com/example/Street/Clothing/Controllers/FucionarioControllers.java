package com.example.Street.Clothing.Controllers;

import com.example.Street.Clothing.Entity.FuncionarioEntity;
import com.example.Street.Clothing.Service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/funcionario")
public class FucionarioControllers {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/guardar")
    public ResponseEntity<FuncionarioEntity> save(@RequestBody FuncionarioEntity funcionarioEntity) {
        try {
            FuncionarioEntity funcionario = this.funcionarioService.save(funcionarioEntity);
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FuncionarioEntity> update(@RequestBody FuncionarioEntity funcionarioEntity, @PathVariable Long id) {
        try {
            FuncionarioEntity funcionario = this.funcionarioService.update(funcionarioEntity, id);
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        try {
            String mensagem = this.funcionarioService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<FuncionarioEntity> findById(@PathVariable long id) {
        try {
            FuncionarioEntity funcionario = this.funcionarioService.findById(id);
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<FuncionarioEntity>> findAll() {
        try {
            List<FuncionarioEntity> lista = this.funcionarioService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }




}
