package com.example.Street.Clothing.Repository;

import com.example.Street.Clothing.Entity.FuncionarioEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {
}
