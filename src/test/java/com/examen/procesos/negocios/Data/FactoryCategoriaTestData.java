package com.examen.procesos.negocios.Data;

import com.examen.procesos.negocios.models.Categoria;

public class FactoryCategoriaTestData {

    public static Categoria mockCategoria() {

        Categoria categoria = new Categoria();
        categoria.setId_ctg(1l);
        categoria.setNombre("Aseo");
        categoria.setDescripcion("articulos para el aseo");

        return categoria;
    }

}
