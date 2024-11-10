package dominio;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase Libreta gestiona una lista de contactos.
 * Permite añadir, listar, eliminar, modificar y exportar contactos a un archivo CSV.
 * Los contactos se guardan de forma persistente en un archivo de texto.
 * 
 * @author [Tu Nombre]
 * @version 1.0
 */
public class Agenda {
    /** Lista de contactos almacenados en la libreta. */
    private List<Contacto> contactos;
    
    /** Ruta del archivo donde se almacenan los contactos. */
    private final String archivo = "contactos.txt";

    /**
     * Constructor de la clase Libreta. Inicializa la lista de contactos
     * y carga los contactos previamente guardados desde el archivo.
     */
    public Agenda() {
        contactos = new ArrayList<>();
        cargarContactos();
    }

    /**
     * Añade un nuevo contacto a la libreta.
     * 
     * @param nombre El nombre del contacto.
     * @param telefono El número de teléfono del contacto.
     */
    public void addContacto(String nombre, String telefono) {
        Contacto nuevoContacto = new Contacto(nombre, telefono);
        contactos.add(nuevoContacto);
        guardarContactos();
        System.out.println("Contacto añadido: " + nombre + ", " + telefono);
    }

    /**
     * Muestra todos los contactos almacenados en la libreta.
     * Si no hay contactos, muestra un mensaje indicando que la libreta está vacía.
     */
    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos en la libreta.");
        } else {
            System.out.println("Lista de contactos:");
            for (Contacto contacto : contactos) {
                System.out.println(contacto);
            }
        }
    }

    /**
     * Elimina un contacto de la libreta basado en su nombre.
     * 
     * @param nombre El nombre del contacto a eliminar.
     */
    public void eliminarContacto(String nombre) {
        Contacto contactoAEliminar = buscarContacto(nombre);
        if (contactoAEliminar != null) {
            contactos.remove(contactoAEliminar);
            guardarContactos();
            System.out.println("Contacto eliminado: " + nombre);
        } else {
            System.out.println("Contacto no encontrado: " + nombre);
        }
    }

    /**
     * Modifica el número de teléfono de un contacto basado en su nombre.
     * 
     * @param nombre El nombre del contacto a modificar.
     * @param nuevoTelefono El nuevo número de teléfono del contacto.
     */
    public void modificarContacto(String nombre, String nuevoTelefono) {
        Contacto contactoAModificar = buscarContacto(nombre);
        if (contactoAModificar != null) {
            contactoAModificar.setTelefono(nuevoTelefono);
            guardarContactos();
            System.out.println("Contacto modificado: " + nombre + ", " + nuevoTelefono);
        } else {
            System.out.println("Contacto no encontrado: " + nombre);
        }
    }

    /**
     * Exporta los contactos de la libreta a un archivo CSV.
     * El archivo CSV contiene dos columnas: "Nombre" y "Teléfono".
     * 
     * @see Contacto
     */
    public void exportarACSV() {
        String archivoCSV = "contactos.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoCSV))) {
            // Escribe la cabecera del archivo CSV.
            writer.write("Nombre,Teléfono");
            writer.newLine();
            // Escribe los contactos en el archivo CSV.
            for (Contacto contacto : contactos) {
                writer.write(contacto.getNombre() + "," + contacto.getTelefono());
                writer.newLine();
            }
            System.out.println("Contactos exportados a " + archivoCSV);
        } catch (IOException e) {
            System.out.println("Error al exportar los contactos a CSV: " + e.getMessage());
        }
    }

    /**
     * Busca un contacto por su nombre.
     * 
     * @param nombre El nombre del contacto a buscar.
     * @return El contacto encontrado o {@code null} si no existe.
     */
    private Contacto buscarContacto(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        return null;
    }

    /**
     * Guarda la lista de contactos en el archivo de texto especificado.
     * Cada línea contiene el nombre y el teléfono de un contacto, separados por una coma.
     */
    private void guardarContactos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Contacto contacto : contactos) {
                writer.write(contacto.getNombre() + "," + contacto.getTelefono());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los contactos: " + e.getMessage());
        }
    }

    /**
     * Carga los contactos desde un archivo de texto.
     * El archivo debe tener el formato "nombre,telefono" por línea.
     * 
     * @see Contacto
     */
    private void cargarContactos() {
        File file = new File(archivo);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    String nombre = datos[0];
                    String telefono = datos[1];
                    contactos.add(new Contacto(nombre, telefono));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los contactos: " + e.getMessage());
        }
    }
}
