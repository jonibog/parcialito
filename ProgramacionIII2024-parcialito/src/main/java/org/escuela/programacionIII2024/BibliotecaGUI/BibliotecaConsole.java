package org.escuela.programacionIII2024.BibliotecaGUI;

import org.escuela.programacionIII2024.modelo.Biblioteca;
import org.escuela.programacionIII2024.modelo.Libro;
import org.escuela.programacionIII2024.modelo.Persona;
import org.escuela.programacionIII2024.servicios.LibroServiceImpl;

import java.util.List;
import java.util.Scanner;

public class BibliotecaConsole {
    private Biblioteca biblioteca;
    private Scanner scanner;

    public BibliotecaConsole() {
        LibroServiceImpl libroService = new LibroServiceImpl();
        biblioteca = new Biblioteca(libroService);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Buscar libro por nombre");
            System.out.println("4. Buscar libros por autor");
            System.out.println("5. Agregar usuario");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (option) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    eliminarLibro();
                    break;
                case 3:
                    buscarLibro();
                    break;
                case 4:
                    buscarLibrosPorAutor();
                    break;
                case 5:
                    agregarUsuario();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void agregarLibro() {
        System.out.print("Nombre del libro: ");
        String nombreLibro = scanner.nextLine();
        System.out.print("Género del libro: ");
        String genero = scanner.nextLine();
        System.out.print("Nombre del autor: ");
        String nombreAutor = scanner.nextLine();
        System.out.print("DNI del autor: ");
        String dniAutor = scanner.nextLine();
        Persona autor = new Persona(dniAutor, nombreAutor);

        Libro libro = new Libro(nombreLibro, autor, genero);
        biblioteca.agregarLibro(libro);
        System.out.println("Libro agregado: " + nombreLibro);
    }

    private void eliminarLibro() {
        System.out.print("Nombre del libro a eliminar: ");
        String nombre = scanner.nextLine();
        Libro libro = biblioteca.buscarLibroPorNombre(nombre);
        if (libro != null) {
            biblioteca.eliminarLibro(libro);
            System.out.println("Libro eliminado: " + nombre);
        } else {
            System.out.println("Libro no encontrado: " + nombre);
        }
    }

    private void buscarLibro() {
        System.out.print("Nombre del libro a buscar: ");
        String nombre = scanner.nextLine();
        Libro libro = biblioteca.buscarLibroPorNombre(nombre);
        if (libro != null) {
            System.out.println("Libro encontrado: " + libro.getNombre() + " por " + libro.getAutor().getNombre());
        } else {
            System.out.println("Libro no encontrado: " + nombre);
        }
    }

    private void buscarLibrosPorAutor() {
        System.out.print("Nombre del autor: ");
        String nombreAutor = scanner.nextLine();
        Persona autor = new Persona(null, nombreAutor); // Assuming null for DNI if not provided
        List<Libro> libros = biblioteca.buscarLibrosPorAutor(autor);
        if (!libros.isEmpty()) {
            System.out.println("Libros encontrados:");
            for (Libro libro : libros) {
                System.out.println(libro.getNombre());
            }
        } else {
            System.out.println("No se encontraron libros para el autor: " + nombreAutor);
        }
    }

    private void agregarUsuario() {
        System.out.print("Nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("DNI del usuario: ");
        String dni = scanner.nextLine();
        Persona usuario = new Persona(dni, nombre);
        biblioteca.agregarUsuario(usuario);
        System.out.println("Usuario agregado: " + nombre);
    }

    public static void main(String[] args) {
        BibliotecaConsole console = new BibliotecaConsole();
        console.start();
    }
}
