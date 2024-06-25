package org.escuela.programacionIII2024.BibliotecaGUI;

import org.escuela.programacionIII2024.modelo.Biblioteca;
import org.escuela.programacionIII2024.modelo.Libro;
import org.escuela.programacionIII2024.modelo.Persona;
import org.escuela.programacionIII2024.servicios.LibroServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BibliotecaGUI {
    private Biblioteca biblioteca;

    // Variables de instancia para almacenar temporalmente los datos del libro
    private String nombreLibroTemp;
    private String generoTemp;
    private Persona autorTemp;

    // Componentes de la interfaz
    private JFrame frame;
    private JTextField txtNombreLibro, txtAutorLibro, txtGeneroLibro, txtNombreUsuario, txtDniUsuario;
    private JTextField txtBuscarLibro, txtEliminarLibro, txtBuscarAutor;
    private JTextArea textArea;

    public BibliotecaGUI() {
        // Asegúrate de crear una instancia de LibroServiceImpl
        LibroServiceImpl libroService = new LibroServiceImpl();
        biblioteca = new Biblioteca(libroService);
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Biblioteca");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        // Panel principal
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(9, 3)); // Ajustar el layout para acomodar nuevos componentes

        // Componentes para agregar un libro
        JLabel lblNombreLibro = new JLabel("Nombre del Libro:");
        txtNombreLibro = new JTextField();
        JButton btnAgregarNombreLibro = new JButton("Agregar Nombre del Libro");
        btnAgregarNombreLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarNombreLibro();
            }
        });

        JLabel lblGeneroLibro = new JLabel("Género:");
        txtGeneroLibro = new JTextField();
        JButton btnAgregarGenero = new JButton("Agregar Género");
        btnAgregarGenero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarGenero();
            }
        });

        JLabel lblAutorLibro = new JLabel("Autor:");
        txtAutorLibro = new JTextField();
        JButton btnAgregarAutor = new JButton("Agregar Autor");
        btnAgregarAutor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarAutor();
            }
        });

        JButton btnAgregarLibro = new JButton("Agregar Libro");
        btnAgregarLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }
        });

        panel.add(lblNombreLibro);
        panel.add(txtNombreLibro);
        panel.add(btnAgregarNombreLibro);
        panel.add(lblGeneroLibro);
        panel.add(txtGeneroLibro);
        panel.add(btnAgregarGenero);
        panel.add(lblAutorLibro);
        panel.add(txtAutorLibro);
        panel.add(btnAgregarAutor);
        panel.add(new JLabel("")); // Placeholder
        panel.add(new JLabel("")); // Placeholder
        panel.add(btnAgregarLibro);

        // Componentes para eliminar un libro
        JLabel lblEliminarLibro = new JLabel("Eliminar Libro por Nombre:");
        txtEliminarLibro = new JTextField();
        JButton btnEliminarLibro = new JButton("Eliminar Libro");
        btnEliminarLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarLibro();
            }
        });

        panel.add(lblEliminarLibro);
        panel.add(txtEliminarLibro);
        panel.add(btnEliminarLibro);

        // Componentes para buscar libros por nombre
        JLabel lblBuscarLibro = new JLabel("Buscar Libro por Nombre:");
        txtBuscarLibro = new JTextField();
        JButton btnBuscarLibro = new JButton("Buscar Libro");
        btnBuscarLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarLibro();
            }
        });

        panel.add(lblBuscarLibro);
        panel.add(txtBuscarLibro);
        panel.add(btnBuscarLibro);

        // Componentes para buscar libros por autor
        JLabel lblBuscarAutor = new JLabel("Buscar Libros por Autor:");
        txtBuscarAutor = new JTextField();
        JButton btnBuscarAutor = new JButton("Buscar Libros por Autor");
        btnBuscarAutor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarLibrosPorAutor();
            }
        });

        panel.add(lblBuscarAutor);
        panel.add(txtBuscarAutor);
        panel.add(btnBuscarAutor);

        // Componentes para agregar un usuario
        JLabel lblNombreUsuario = new JLabel("Nombre del Usuario:");
        txtNombreUsuario = new JTextField();
        JLabel lblDniUsuario = new JLabel("DNI del Usuario:");
        txtDniUsuario = new JTextField();
        JButton btnAgregarUsuario = new JButton("Agregar Usuario");
        btnAgregarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarUsuario();
            }
        });

        panel.add(lblNombreUsuario);
        panel.add(txtNombreUsuario);
        panel.add(lblDniUsuario);
        panel.add(txtDniUsuario);
        panel.add(btnAgregarUsuario);

        // TextArea para mostrar los resultados
        textArea = new JTextArea();
        frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void agregarNombreLibro() {
        nombreLibroTemp = txtNombreLibro.getText();
        textArea.append("Nombre del libro agregado: " + nombreLibroTemp + "\n");
    }

    private void agregarGenero() {
        generoTemp = txtGeneroLibro.getText();
        textArea.append("Género agregado: " + generoTemp + "\n");
    }

    private void agregarAutor() {
        String nombreAutor = txtAutorLibro.getText();
        autorTemp = new Persona(nombreAutor);
        textArea.append("Autor agregado: " + nombreAutor + "\n");
    }

    private void agregarLibro() {
        if (nombreLibroTemp != null && generoTemp != null && autorTemp != null) {
            Libro libro = new Libro(nombreLibroTemp, autorTemp, generoTemp);
            biblioteca.agregarLibro(libro);
            textArea.append("Libro agregado: " + nombreLibroTemp + "\n");
            // Reseteamos los valores temporales
            nombreLibroTemp = null;
            generoTemp = null;
            autorTemp = null;
        } else {
            textArea.append("Falta información para agregar el libro.\n");
        }
    }

    private void eliminarLibro() {
        String nombre = txtEliminarLibro.getText();
        Libro libro = biblioteca.buscarLibroPorNombre(nombre);
        if (libro != null) {
            biblioteca.eliminarLibro(libro);
            textArea.append("Libro eliminado: " + nombre + "\n");
        } else {
            textArea.append("Libro no encontrado: " + nombre + "\n");
        }
    }

    private void buscarLibro() {
        String nombre = txtBuscarLibro.getText();
        Libro libro = biblioteca.buscarLibroPorNombre(nombre);
        if (libro != null) {
            textArea.append("Libro encontrado: " + libro.getNombre() + " por " + libro.getAutor().getNombre() + "\n");
        } else {
            textArea.append("Libro no encontrado: " + nombre + "\n");
        }
    }

    private void buscarLibrosPorAutor() {
        String nombreAutor = txtBuscarAutor.getText();
        Persona autor = new Persona(nombreAutor);
        List<Libro> libros = biblioteca.buscarLibrosPorAutor(autor);
        if (!libros.isEmpty()) {
            StringBuilder sb = new StringBuilder("Libros encontrados:\n");
            for (Libro libro : libros) {
                sb.append(libro.getNombre()).append("\n");
            }
            textArea.append(sb.toString());
        } else {
            textArea.append("No se encontraron libros para el autor: " + nombreAutor + "\n");
        }
    }

    private void agregarUsuario() {
        String nombre = txtNombreUsuario.getText();
        String dni = txtDniUsuario.getText();
        Persona usuario = new Persona(nombre, dni);
        biblioteca.agregarUsuario(usuario);
        textArea.append("Usuario agregado: " + nombre + " con DNI: " + dni + "\n");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BibliotecaGUI window = new BibliotecaGUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
