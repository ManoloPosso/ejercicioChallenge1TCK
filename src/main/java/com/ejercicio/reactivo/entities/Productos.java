package com.ejercicio.reactivo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.Date;

@Table("productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Productos {

        @Id
        private Long id;
        private String nombre_producto;
        private double valor;
        private String marca;
        private LocalDate fecha_creacion;
        private Date fecha_modificacion;

}
