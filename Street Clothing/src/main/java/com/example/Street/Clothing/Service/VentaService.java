package com.example.Street.Clothing.Service;

import com.example.Street.Clothing.Entity.ClienteEntity;
import com.example.Street.Clothing.Entity.FuncionarioEntity;
import com.example.Street.Clothing.Entity.ProductoEntity;
import com.example.Street.Clothing.Entity.VentasEntity;
import com.example.Street.Clothing.Repository.ClienteRepository;
import com.example.Street.Clothing.Repository.FuncionarioRepository;
import com.example.Street.Clothing.Repository.ProductoRepository;
import com.example.Street.Clothing.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ClienteRepository clientesRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public VentasEntity save(VentasEntity ventaEntity) {
        try {
            if (ventaEntity.getCliente() != null && ventaEntity.getCliente().getId() != null) {
                Optional<ClienteEntity> clienteOptional = clientesRepository.findById(ventaEntity.getCliente().getId());
                if (clienteOptional.isPresent()) {
                    ventaEntity.setCliente(clienteOptional.get());
                } else {
                    throw new Exception("Cliente no encontrado");
                }
            }

            if (ventaEntity.getFuncionario() != null && ventaEntity.getFuncionario().getId() != null) {
                Optional<FuncionarioEntity> funcionarioOptional = funcionarioRepository.findById(ventaEntity.getFuncionario().getId());
                if (funcionarioOptional.isPresent()) {
                    ventaEntity.setFuncionario(funcionarioOptional.get());
                } else {
                    throw new Exception("Funcionario no encontrado");
                }
            }

            double total = 0.0;
            if (ventaEntity.getProductos() != null && !ventaEntity.getProductos().isEmpty()) {
                List<ProductoEntity> productosAssociados = new ArrayList<>();
                for (ProductoEntity producto : ventaEntity.getProductos()) {
                    Optional<ProductoEntity> productoOptional = productoRepository.findById(producto.getId());
                    if (productoOptional.isPresent()) {
                        ProductoEntity productoEncontrado = productoOptional.get();
                        productosAssociados.add(productoEncontrado);
                        total += productoEncontrado.getValor();
                    } else {
                        throw new Exception("Producto con ID " + producto.getId() + " no encontrado");
                    }
                }
                ventaEntity.setProductos(productosAssociados);
            }
            ventaEntity.setTotal(total);

            return this.ventaRepository.save(ventaEntity);
        } catch (Exception e) {
            System.out.println("Error al guardar la venta: " + e.getMessage());
            return new VentasEntity();
        }
    }

    public VentasEntity update(VentasEntity ventaEntity, Long id) {
        try {

            if (ventaEntity.getCliente() != null && ventaEntity.getCliente().getId() != null) {
                Optional<ClienteEntity> clienteOptional = clientesRepository.findById(ventaEntity.getCliente().getId());
                if (clienteOptional.isPresent()) {
                    ventaEntity.setCliente(clienteOptional.get());
                } else {
                    throw new Exception("Cliente no encontrado");
                }
            }

            if (ventaEntity.getFuncionario() != null && ventaEntity.getFuncionario().getId() != null) {
                Optional<FuncionarioEntity> funcionarioOptional = funcionarioRepository.findById(ventaEntity.getFuncionario().getId());
                if (funcionarioOptional.isPresent()) {
                    ventaEntity.setFuncionario(funcionarioOptional.get());
                } else {
                    throw new Exception("Funcionario no encontrado");
                }
            }

            double total = 0.0;
            if (ventaEntity.getProductos() != null && !ventaEntity.getProductos().isEmpty()) {
                List<ProductoEntity> productosAsociados = new ArrayList<>();
                for (ProductoEntity producto : ventaEntity.getProductos()) {
                    Optional<ProductoEntity> productoOptional = productoRepository.findById(producto.getId());
                    if (productoOptional.isPresent()) {
                        ProductoEntity produtoEncontrado = productoOptional.get();
                        productosAsociados.add(produtoEncontrado);
                        total += produtoEncontrado.getValor();
                    } else {
                        throw new Exception("Produto con ID " + producto.getId() + " no encontrado");
                    }
                }
                ventaEntity.setProductos(productosAsociados);
            }
            ventaEntity.setTotal(total);

            ventaEntity.setId(id);
            return this.ventaRepository.save(ventaEntity);
        } catch (Exception e) {
            System.out.println("Error al actualizar la venta: " + e.getMessage());
            return new VentasEntity();
        }
    }

    public String delete(Long id) {
        try {
            this.ventaRepository.deleteById(id);
            return "Eliminado";
        } catch (Exception e) {
            return "Error al eliminar la venta";
        }
    }

    public VentasEntity findById(Long id) {
        try {
            Optional<VentasEntity> venda = this.ventaRepository.findById(id);
            return venda.orElse(null);
        } catch (Exception e) {
            System.out.println("Erro al buscar la venta com ID " + id + ": " + e.getMessage());
            return new VentasEntity();
        }
    }

    public List<VentasEntity> findAll() {
        try {
            return this.ventaRepository.findAll();
        } catch (Exception e) {
            System.out.println("Erro al buscar todas las ventas: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<VentasEntity> findByClienteNombre(String nomeCliente) {
        try {
            return ventaRepository.findByClienteNome(nomeCliente);
        } catch (Exception e) {
            System.out.println("Erro al buscar ventas com el nombre del cliente: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<VentasEntity> findByFuncionarioNombre(String nomeFuncionario) {
        try {
            return ventaRepository.findByFuncionarioNombre(nomeFuncionario);
        } catch (Exception e) {
            System.out.println("Error al buscar ventas com el nombre del funcionario: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<VentasEntity> find10ComTotalMaisAlto() {
        try {
            return ventaRepository.find10ComTotalMaisAlto();
        } catch (Exception e) {
            System.out.println("Error al buscar las ventas: " + e.getMessage());
            return Collections.emptyList();
        }
    }



}
