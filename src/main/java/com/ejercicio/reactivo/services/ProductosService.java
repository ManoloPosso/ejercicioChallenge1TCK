package com.ejercicio.reactivo.services;

import com.ejercicio.reactivo.entities.Productos;
import com.ejercicio.reactivo.repositories.ProductosRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProductosService {

    private final ProductosRepository productosRepository;

    public ProductosService(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }


    public Mono<Productos> findById(Long id){
        return productosRepository.findById(id);
    }


}
