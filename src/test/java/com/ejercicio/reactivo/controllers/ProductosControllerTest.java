package com.ejercicio.reactivo.controllers;

import com.ejercicio.reactivo.entities.Productos;
import com.ejercicio.reactivo.services.ProductosService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@WebFluxTest(ProductosController.class)
public class ProductosControllerTest {

    @MockBean
    private ProductosService productosService;

    @InjectMocks
    private ProductosController productosController;

    @Autowired
    private WebTestClient webTestClient = WebTestClient.bindToController(new ProductosController(productosService)).build();

    @Test
    void findById() {
        Productos productos = listaProductos();

        when(productosService.findById(1L)).thenReturn(Mono.just(productos));

        webTestClient.get().uri("/productos/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.nombre_producto").isEqualTo("prueba_producto")
                .jsonPath("$.valor").isEqualTo(1000)
                .jsonPath("$.marca").isEqualTo("marca_prueba");
    }

    private Productos listaProductos(){

        Productos productos = new Productos();
        productos.setId(1L);
        productos.setNombre_producto("prueba_producto");
        productos.setValor(1000);
        productos.setMarca("marca_prueba");

        return productos;
    }
}