package com.ejercicio.reactivo.repositories;

import com.ejercicio.reactivo.entities.Productos;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository  extends ReactiveCrudRepository<Productos,Long> {
}
