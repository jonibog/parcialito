package org.escuela.programacionIII2024.servicios;

import org.escuela.programacionIII2024.modelo.Libro;
import org.escuela.programacionIII2024.modelo.Persona;

import java.util.List;

public interface LibroService {
    void agregarLibro(Libro libro);
    void eliminarLibro(Libro libro);
    Libro buscarLibroPorNombre(String nombre);
    List<Libro> buscarLibrosPorAutor(Persona autor);
}
