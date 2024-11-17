/**
 * La clase Principal es la responsable de la ejecución.
 * En la clase Principal es necesario tener acceso a la interfaz, por lo que se importa.
 */

/**
 * Lo primero que se hace es definir el paquete. Al ser este el método de ejecución, es necesario que se encuentre en el paquete de aplicación.
 */
package aplicacion;
import interfaz.*;

/**
 * La clase Principal es la responsable de la ejecución.
 * En la clase Principal es necesario tener acceso a la interfaz, por lo que se importa.
 */
public class Principal {
    /**
     * Método main de ejecución.
     * Es estático, de tal forma que todo lo creado dentro del mismo es solo accesible deste este, como el atributo Array de Strings instruccion.
     * Se crea un nuevo objeto interfaz, se escribe un mensaje de bienvenida y se llama al método de ayuda para desplegar las opciones disponibles.
     * También hay un bucle do while en el que se ejecuta la lectura de instrucción, luego el procesamiento de la mismay, mientras haya procesamiento (boolean con valor true), habrá lectura.
     * @param args: los argumentos pasados por terminal por el usuario.
     */
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        String [] instruccion;
        System.out.print("\n\n Bienvenido a la agenda de contactos.\n\n");
        interfaz.help();
        do {
            instruccion = interfaz.leerInstruccion();
        }
        while (interfaz.procesarInstruccion(instruccion));
    }
}