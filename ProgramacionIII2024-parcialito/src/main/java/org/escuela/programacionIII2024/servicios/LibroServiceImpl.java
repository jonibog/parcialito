package org.escuela.programacionIII2024.servicios;

import org.escuela.programacionIII2024.modelo.Libro;
import org.escuela.programacionIII2024.modelo.Persona;

import java.util.ArrayList;
import java.util.List;

public class LibroServiceImpl implements LibroService {
    private List<Libro> libros = new ArrayList<>();

    @Override
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    @Override
    public void eliminarLibro(Libro libro) {
        libros.remove(libro);
    }

    @Override
    public Libro buscarLibroPorNombre(String nombre) {
        for (Libro libro : libros) {
            if (libro.getNombre().equalsIgnoreCase(nombre)) {
                return libro;
            }
        }
        return null;
    }

    @Override
    public List<Libro> buscarLibrosPorAutor(Persona autor) {
        List<Libro> librosPorAutor = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().getNombre().equalsIgnoreCase(autor.getNombre())) {
                librosPorAutor.add(libro);
            }
        }
        return librosPorAutor;
    }
}
