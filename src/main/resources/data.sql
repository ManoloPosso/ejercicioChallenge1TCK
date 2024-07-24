create table productos(
    id bigint auto_increment primary key,
    nombre_producto varchar(255),
    valor double,
    marca varchar(255),
    fecha_creacion date DEFAULT now(),
    fecha_modificacion date
);

insert into productos (nombre_producto,valor,marca) values('producto_prueba',1000,'marca_prueba');