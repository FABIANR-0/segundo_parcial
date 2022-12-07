package com.examen.procesos.negocios.Data;

import com.examen.procesos.negocios.models.Articulo;

import java.util.Date;

public class FactoryArticuloTestData {
    public static Articulo mockArticulo() {
        Articulo articulo = new Articulo();
        articulo.setId(1L);
        articulo.setCodigo("A01");
        articulo.setNombre("Jabon");
        articulo.setDescripcion("Jabon azul");
        articulo.setFecha_registro(new Date(2004, 7, 14));
        articulo.setCategoria(FactoryCategoriaTestData.mockCategoria());
        articulo.setUsuario(FactoryUsuarioTestData.mockUsuario());
        articulo.setStock(32);
        articulo.setPrecio_compra(1.200);
        articulo.setPrecio_venta(1.500);

        return articulo;
    }
    public static Articulo mockArticuloAct() {

        Articulo articulo = new Articulo();

        articulo.setId(1L);
        articulo.setCodigo("A01");
        articulo.setNombre("arroz");
        articulo.setDescripcion("otro");
        articulo.setFecha_registro(new Date(2004, 7, 14));
        articulo.setCategoria(FactoryCategoriaTestData.mockCategoria());
        articulo.setUsuario(FactoryUsuarioTestData.mockUsuario());
        articulo.setStock(32);
        articulo.setPrecio_compra(1.200);
        articulo.setPrecio_venta(1.500);

        return articulo;
    }
}
