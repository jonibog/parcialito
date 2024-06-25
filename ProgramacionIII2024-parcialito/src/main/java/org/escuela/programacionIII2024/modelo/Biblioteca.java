package org.escuela.programacionIII2024.modelo;

import org.escuela.programacionIII2024.servicios.LibroServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private LibroServiceImpl libroService;
    private List<Persona> usuarios;

    public Biblioteca(LibroServiceImpl libroService) {
        this.libroService = libroService;
        this.usuarios = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libroService.agregarLibro(libro);
    }

    public void eliminarLibro(Libro libro) {
        libroService.eliminarLibro(libro);
    }

    public Libro buscarLibroPorNombre(String nombre) {
        return libroService.buscarLibroPorNombre(nombre);
    }

    public List<Libro> buscarLibrosPorAutor(Persona autor) {
        return libroService.buscarLibrosPorAutor(autor);
    }

    public void agregarUsuario(Persona usuario) {
        usuarios.add(usuario);
    }

    public List<Persona> getUsuarios() {
        return usuarios;
    }
}
