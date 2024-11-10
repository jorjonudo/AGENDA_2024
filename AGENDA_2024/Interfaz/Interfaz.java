package Interfaz;

import dominio.Agenda;

public class Interfaz {
    private Agenda libreta;

    public Interfaz() {
        libreta = new Agenda();
    }

    public void procesarComando(String comando) {
        String[] partes = comando.split(" ");
        if (partes.length == 0) {
            mostrarAyuda();
            return;
        }

        String operacion = partes[0];
        switch (operacion) {
            case "add":
                if (partes.length == 3) {
                    String nombre = partes[1];
                    String telefono = partes[2];
                    libreta.addContacto(nombre, telefono);
                } else {
                    System.out.println("Uso incorrecto de 'add'. Ejemplo: add Pepe 654321234");
                }
                break;
            case "list":
                libreta.listarContactos();
                break;
            case "delete":
                if (partes.length == 2) {
                    String nombre = partes[1];
                    libreta.eliminarContacto(nombre);
                } else {
                    System.out.println("Uso incorrecto de 'delete'. Ejemplo: delete Pepe");
                }
                break;
            case "update":
                if (partes.length == 3) {
                    String nombre = partes[1];
                    String nuevoTelefono = partes[2];
                    libreta.modificarContacto(nombre, nuevoTelefono);
                } else {
                    System.out.println("Uso incorrecto de 'update'. Ejemplo: update Pepe 654321234");
                }
                break;
            case "export":
                libreta.exportarACSV();
                break;
            case "help":
                mostrarAyuda();
                break;
            default:
                System.out.println("Comando desconocido.");
                mostrarAyuda();
        }
    }

    private void mostrarAyuda() {
        System.out.println("Las operaciones posibles son las siguientes:");
        System.out.println("- Añadir contacto: 'java -jar libreta.jar add <nombre> <teléfono>'");
        System.out.println("  Ejemplo: java -jar libreta.jar add Pepe 654321234");
        System.out.println("- Eliminar contacto: 'java -jar libreta.jar delete <nombre>'");
        System.out.println("  Ejemplo: java -jar libreta.jar delete Pepe");
        System.out.println("- Modificar contacto: 'java -jar libreta.jar update <nombre> <nuevoTeléfono>'");
        System.out.println("  Ejemplo: java -jar libreta.jar update Pepe 654321234");
        System.out.println("- Exportar contactos a CSV: 'java -jar libreta.jar export'");
        System.out.println("- Mostrar contactos: java -jar libreta.jar list");
        System.out.println("- Mostrar esta ayuda: java -jar libreta.jar help");
    }
}
