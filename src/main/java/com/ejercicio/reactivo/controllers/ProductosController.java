package com.ejercicio.reactivo.controllers;

import com.ejercicio.reactivo.entities.Productos;
import com.ejercicio.reactivo.services.ProductosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/productos")
public class ProductosController {

    private final ProductosService productosService;


    public ProductosController(ProductosService productosService) {

        this.productosService = productosService;
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Productos>> findById(@PathVariable Long id){

        return productosService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


}
