package com.example.bancodelechematerna.repositorio;

import com.example.bancodelechematerna.entidades.IMaestro;
import com.example.bancodelechematerna.entidades.TipoDocumento;
import java.util.ArrayList;
import java.util.List;

public class RepositorioMaestro {
    public static List<IMaestro> obtenerTiposDocumento() {
        List<IMaestro> tiposDocumento = new ArrayList<>() ;
        IMaestro cedula = new TipoDocumento();
        cedula.setId(1);
        cedula.setNombre("Cédula de Ciudadanía");
        tiposDocumento.add(cedula);
        IMaestro ti = new TipoDocumento();
        ti.setId(2);
        ti.setNombre("Tarjeta de Identidad");
        tiposDocumento.add(ti);
        IMaestro extranjero = new TipoDocumento();
        extranjero.setId(2);
        extranjero.setNombre("Cedula de extranjeria");
        tiposDocumento.add(extranjero);

        return tiposDocumento;
    }
}
