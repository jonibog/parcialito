package org.escuela.programacionIII2024;

import org.escuela.programacionIII2024.modelo.Biblioteca;
import org.escuela.programacionIII2024.modelo.Libro;
import org.escuela.programacionIII2024.modelo.Persona;
import org.escuela.programacionIII2024.servicios.LibroServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Emanuel Gautero
 */
public class ProgramacionIII2024 {

    public static void main(String[] args) {
        List<Libro> libros = new ArrayList<>();
        libros.add(new Libro("Libro1", new Persona("12123123","Autor 1"), "Ficción"));

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("33345678", "cliente uno"));

        Biblioteca biblioteca = new Biblioteca(new LibroServiceImpl());

        //Agregamos un libro nuevo a la biblioteca

        //Eliminamos un libro de a biblioteca

        //Buscamos un libro por el nombre

        //Buscamos todos los libros por el nombre de un autor

        //Agregamos a un cliente a la biblioteca

        //Eliminamos a un cliente de la biblioteca


    }
}




