package com.examen.procesos.negocios.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name ="categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ctg;
    @Column(nullable = false, unique = true, length = 50)
    private String nombre;
    @Column(nullable = false, length = 300)
    private String descripcion;
}
