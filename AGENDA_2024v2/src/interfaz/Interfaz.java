/**
 * Interfaz es la clase que se encarga de la interacción máquina-usuario. Aquí se crean métodos para utilizar los creados en la agenda y en el contacto.
 *
 */

/**
 * Lo primero que se realiza es definir el paquete en el que se encuentra la clase; en este caso, el paquete es el interfaz.
 * En un paquete del tipo "interfaz" solo tiene sentido tener elementos relativos a la interfaz.
 * Después, importamos las librerías pertinentes; para esta clase importaremos la librería java.util entera, aunque solo necesitemos los ArrayLists.
 * Es necesario importar también el paquete o directorio dominio, puesto que interfaz llama a métodos y atributos pertenecientes tanto a los contactos como a la agenda.
 */
package interfaz;
import java.util.*;
import dominio.*;

/**
 * Interfaz es la clase que se encarga de la interacción máquina-usuario. Aquí se crean métodos para utilizar los creados en la agenda y en el contacto.
 * Se crea el atributo de la agenda, que es de tipo Agenda.
 * Se crea también un escáner, que sirve para leer las entradas por teclado que haga el usuario.
 */
public class Interfaz{
    private Agenda agenda;
    private Scanner sc = new Scanner(System.in);

    /**
     * Se crea un constructor en el que se le da de valor inicial a la agenda la lectura que se realiza de otra agenda anterior.
     */
    public Interfaz() {
        agenda = agenda.leer();
    }

    /**
     * Método para la lectura de la instrucción pasada por teclado a partir de un Array.
     * Se escanea la instrucción como String.
     * @return La instrucción dividida según los separadores establecidos para la instrucción; en este caso, comas (,).
     */
    //Los corchetes son porque esto es un Array
    public String[] leerInstruccion() {
        System.out.println("\n Escriba la instruccion: \n");
        String instruccion = sc.nextLine();
        return instruccion.split(",");
    }

    /**
     * Método para procesar la instrucción mediante un boolean.
     * Se emplea try and catch para manejo de instrucciones.
     * Dentro del try, se establecen condicionales para las instrucciones que acepta el programa según sus funciones.
     * Si la primera palabra previa a una coma se corresponde con el mensaje determinado, se ejecutarán distintas instrucciones.
     * Siempre, dentro del try, se retorna true del boolean para que se siga ejecutando el procesamiento de instrucciones y, por tanto, el programa; sin embargo, en la opción de salir se devuelve un valor false para parar el programa tras guardar los datos.
     * En el catch, si se da una excepción, se envía un mensaje de error, pero que siga funcionando el programa.
     * @param instruccion las palabras pasadas por terminal por parte del usuario. [i], donde i es el índice de posición de la palabra, siempre separadas entre comas (,).
     * @return Valores booleanos para que el programa siga funcionando (true) o se pare (false).
     */

    public boolean procesarInstruccion(String [] instruccion) {
                try
                {if (instruccion[0].equals("help")) {
                    help();
                } else if (instruccion[0].equals("list")) {
                    list();
                } else if (instruccion[0].equals("add")) {
                    add(instruccion[1], instruccion[2], instruccion[3], instruccion[4]);
                } else if (instruccion[0].equals("remove")) {
                    eliminar(instruccion[1], instruccion[2]);
                } else if (instruccion[0].equals("search")) {
                    agenda.buscar(new Contacto(instruccion[1], instruccion[2]));
                } else if (instruccion[0].equals("save")) {
                    agenda.guardar();
                } else if (instruccion[0].equals("favs")) {
                    agenda.favorito();
                } else if (instruccion[0].equals("csv")) {
                    agenda.csv();
                } else if (instruccion[0].equals("addFav")) {
                    agenda.cambiarFavoritoV(new Contacto(instruccion[1],instruccion[2]));
                } else if (instruccion[0].equals("remFav")) {
                    agenda.cambiarFavoritoF(new Contacto(instruccion[1],instruccion[2]));
                } else if (instruccion[0].equals("exit")) {
                    agenda.guardar();
                    return false;
                }
                else {
                    System.out.print("Error de peticion. Escriba una opcion de las disponibles en la ayuda.");
                    help();
                    return true;
                }}
                catch(Exception e){
                    System.out.println("Error en la escritura de la instruccion. Recuerda que a cada comando deben seguirle los atributos (de haberlos) separados por comas (,).");
                }


        return true;

    }

    /**
     * Método de ayuda.
     * Imprime por pantalla todas las opciones disponibles, lo que hace cada una e incluso en algunas ejemplos de uso.
     */
    public void help() {
        System.out.print("\n\n Las opciones disponibles son las siguientes: " +
                "\n - help: para desplegar las opciones disponibles de este programa. " +
                "\n - list: para ver todos los elementos de la agenda. " +
                "\n - add: para annadir contactos. \n EJEMPLO: add,Jorge,Delgado Castellanos,764336276,jdelca@gmail.com" +
                "\n - remove: para eliminar contactos. \n EJEMPLO: remove,Jorge,Delgado Castellanos" +
                "\n - search: para buscar contactos. \n EJEMPLO: search,Jorge,Delgado Castellanos" +
                "\n - save: para guardar los datos en un archivo de creacion automatica. " +
                "\n - favs: para ver la lista de contactos marcados como favoritos. " +
                "\n - addFav: para annadir un contacto a favoritos. \n EJEMPLO: addFav,Jorge,Delgado Castellanos" +
                "\n - remFav: para eliminar un contacto de favoritos. \n EJEMPLO: remFav,Jorge,Delgado Castellanos" +
                "\n - exit: para salir y guardar automaticamente los datos en un archivo de guardado. " +
                "\n\n IMPORTANTE: para cada comando, debe escribir la instruccion y los atributos separados por comas (,). En el caso de haber dos nombre o apellidos en un mismo contacto, estos se separan entre si con un espacio. \n");
    }

    /**
     * Método para imprimir la lista por pantalla.
     * Indica la cantidad de comandos con el método contarContactos de la clase agenda y luego imprime el toString de la agenda con todos los contactos.
     */
    public void list() {
        System.out.print("\n\n La cantidad de contactos es:"+" "+agenda.contarContactos());
        System.out.println(agenda.toString());
    }

    /**
     * Método para añadir contactos.
     * Se llama al método para añadir de la clase agenda.
     * @param nombre nombre del nuevo contacto.
     * @param apellido apellido del nuevo contactp.
     * @param numero número de teléfono del nuevo contacto.
     * @param email correo electrónico del nuevo contacto.
     */
    public void add(String nombre, String apellido, String numero, String email) {
        agenda.anniadir(new Contacto(nombre, apellido, numero, email));
    }

    /**
     * Método para eliminar contactos.
     * Se llama al método para eliminar de la clase agenda.
     * @param nombre nombre del contacto que se va a eliminar.
     * @param apellido apellido del contacto que se va a eliminar.
     */
    public void eliminar(String nombre, String apellido) {
        agenda.borrar(new Contacto(nombre, apellido));
    }
}