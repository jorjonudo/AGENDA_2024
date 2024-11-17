/**
 * Agenda es la clase que contiene a Contacto. Aquí se crean métodos para operar con los contactos mediante ArrayLists y agrupamos contactos.
 */

/**
 * Lo primero que se realiza es definir el paquete en el que se encuentra la clase; en este caso, el paquete es el dominio.
 * En un paquete del tipo "dominio" introducimos todas aquellas clases con las que trabaja el programa.
 *
 * Después, importamos las librerías pertinentes; para esta clase importaremos las librerías java.io completa, aunque solo necesitaremos Serializable; y java.util también entera, aunque solo necesitemos los ArrayLists.
 */
package dominio;
import java.util.*;
import java.io.*;

/**
 * Agenda es la clase que contiene a Contacto. Aquí se crean métodos para operar con los contactos mediante ArrayLists y agrupamos contactos.
 * Serializable es necesario para el toString final y para la función de guardado.
 */
public class Agenda implements Serializable {
    /**
     * Aquí se definen los atributos de la clase Agenda.
     * Tenemos un atributo tipo String, que es el nombre de la agenda; pero también tenemos un ArrayList, que es la lista de contactos.
     */
    private String nombre;
    private ArrayList <Contacto> lista;

    /**
     * Constructor para la agenda.
     * Es un constructor vacío en el que creamos el ArrayList de la lista y asignamos un valor nulo al nombre, ya que este no se va a usar y da igual el que tenga, pero que la referencia al menos sea vacía y no nula, porque si fuera nula no existiría el objeto.
     */
    //En el constructor sin parámetros inicial creamos el ArrayList
    public Agenda(){
        lista = new ArrayList<>();
        //Referencia vacía: existe el objeto. Referencia nula: no existe el objeto
        nombre="";
    }

    /**
     * El método para buscar contactos dentro de la lista de contactos que tiene la agenda.
     * Definimos un atributo p que sea de tipo Int porque es el índice de la posición de un contacto.
     * Después, si ese índice es igual a -1, lo cual quiere decir que el objeto no está en ese ArrayList, aparece un mensaje que indica que los valores introducidos no se corresponden con ningún contacto de la lista y se retorna un valor nulo.
     * Si el objeto está en la lista, aparece el contacto deseado con todos los sus atributos.
     * @param contacto el contacto buscado.
     * @return Los datos del contacto encontrado.
     */
    //En este método nos estamos fiando de ArrayList. Aquí necesitamos redefinir el método equals.
    public Contacto buscar(Contacto contacto) {
        //IndexOf devuelve la posición en la que está el objeto introducida. Si no lo encuentra, devuelve -1; por eso ponemos la condición con -1
        int p = lista.indexOf(contacto);
        if (p == -1) {
            System.out.print("El contacto no se encuentra en la lista o no se ha buscado correctamente");
            return null;
        } else {
            System.out.print("\n\nEl contacto ha sido encontrado:");
            System.out.print("\n\n"+lista.get(p));
            return lista.get(p);
        }
    }
    /*//Podría hacerse, alternativamente, de la siguiente manera:
    public Contacto buscar (String nombre, String apellido){
        for (Contacto contacto: lista){
              if (contacto.getNombre().equals(nombre) && contacto.getApellido().equals(apellido)){
                  return contacto;
              }
          return null;}}

     */
    //Podría tener ambos activos, ya que, aunque tengan el mismo nombre, tienen distintos parámetros. Es un método sobrecargado.

    /**
     * Método para crear una cadena con todos los contactos que son favoritos.
     * Utilizamos un StringBuilder que se componga de cada contacto que sea favorito, de tal forma que se pueda modificar si pasan a ser o dejan de ser favoritos los contactos.
     * @return La cadena con todos los contactos favoritos. Solo se retorna el nombre; si se buscan más datos, que empleen el método para buscar o la lista completa.
     */
    public String favorito(){
        StringBuilder cadena = new StringBuilder();
        for (Contacto contacto: lista)
            if (contacto.getFavorito()==true){
                cadena.append("- ")
                        .append(contacto.getNombre())
                        .append(" ")
                        .append(contacto.getApellido())
                        .append("\n");
            }
        System.out.print(cadena);
        return cadena.toString();
    }

    /**
     * Método para asignar un valor true al atributo "favorito" del objeto.
     * Aquí se asigna un valor true para que el contacto pase a ser favorito.
     * Si al buscar el contacto por nombre y apellido, se encuentra dentro de la lista, se le asigna el valor true a favorito bajo este método.
     * Además, se indica que el contacto ha pasado a ser favorito.
     * @param contacto: el contacto que se quiere hacer favorito.
     * @return false si el contacto no se encuentra en la lista, para no asignar nada a algo que no existe.
     */

    public boolean cambiarFavoritoV(Contacto contacto){
        Contacto c = buscar(contacto);
        if (c!=null){
            c.setFavorito(true);
            System.out.print("El contacto "+contacto.getNombre()+" "+contacto.getApellido()+" ha sido agregado a favoritos\n\n");
        }
        return false;
    }
    /**
     * Método para asignar un valor false al atributo "favorito" del objeto.
     * Aquí se asigna un valor false para que el contacto deje de ser favorito.
     * Si al buscar el contacto por nombre y apellido, se encuentra dentro de la lista, se le asigna el valor false a favorito bajo este método.
     * Además, se indica que el contacto ha dejado de ser favorito.
     * @param contacto: el contacto que se quiere eliminar de favorito.
     * @return false si el contacto no se encuentra en la lista, para no asignar nada a algo que no existe.
     */
    public boolean cambiarFavoritoF(Contacto contacto) {
        Contacto c = buscar(contacto);
        if (c != null) {
            c.setFavorito(false);
            System.out.print("El contacto " + contacto.getNombre() + " " + contacto.getApellido() + " ha sido eliminado de favoritos\n\n");
        }
        return false;
    }

    /**
     * Método para guardar los datos en un archivo de creación automática.
     * Se emplea un try and catch para el manejo de excepciones, de tal forma que el programa no se pare si se detecta alguna.
     * En el try, se crea un stream de flujo de salida del objeto para crear un fichero de extensión dat con los datos.
     * En el archivo se escriben todos los datos de la agenda en el momento de ejecución del comando.
     * En el catch, se redirige la excepción a un mensaje para corregir la orden o que el programador arregle el programa.
     */
    public void guardar(){
        try{
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("agenda.dat"));
            oo.writeObject(this);
            oo.close();
            System.out.print("El guardado se ha realizado correctamente");
        }
        catch(Exception e){
            System.out.print("Error de guardado");
        }
    }

    /**
     * Método para guardar los datos en un archivo CSV.
     * Se emplea un try and catch para el manejo de excepciones, de tal forma que el programa no se pare si se detecta alguna.
     * En el try, se crea un stream de flujo de salida del objeto para crear un fichero de extensión csv con los datos.
     * En el archivo se escriben todos los datos de la agenda en el momento de ejecución del comando.
     * En el catch, se redirige la excepción a un mensaje para corregir la orden o que el programador arregle el programa.
     */
    public void csv(){
        try{
            FileWriter fw = new FileWriter("agenda.csv");
            for (Contacto contacto : lista)
                fw.write(contacto.getNombre() + ","
                +contacto.getApellido()+","+contacto.getTelefono()+","+contacto.getEmail()+","+contacto.esFavorito()+"\n");
            fw.close();
            System.out.print("Archivo CSV creado con exito");

        }
        catch(Exception e){
            e.printStackTrace();
            System.out.print("Error de guardado");
        }
    }

    /**
     * Método de lectura de los datos del fichero dat.
     * Se emplea un try and catch para el manejo de excepciones, de tal forma que el programa no se pare si se detecta alguna.
     * En este caso, en el try se crea un flujo de entrada para leer el mismo archivo escrito.
     * Después, se crea un nuevo objeto agenda en el que se escribe lo leído en el objeto del flujo de salida de entrada del fichero y se retorna esa agenda nueva.
     * En el catch, se redirige la excepción a un mensaje para corregir la orden o que el programador arregle el programa.
     * @return En el try, un objeto agenda con los datos leídos; en el catch, un nuevo objeto del tipo agenda.
     */
    public static Agenda leer() {
        try {
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream("Agenda.dat"));
            Agenda agenda = (Agenda) oi.readObject();
            return agenda;
        } catch (Exception e) {
            return new Agenda();
        }

    }
    
    /**
     * Método para añadir contactos.
     * Se añade un contacto en la lista y se indica mediante un mensaje.
     * @param contacto el contacto que se va a añadir.
     * @return El objeto agenda con el contacto agregado.
     */

    public Agenda anniadir(Contacto contacto){
        lista.add(contacto);
        System.out.println("Se ha agregado el contacto "+ contacto.getNombre()+" " + contacto.getApellido());
        return this;
    }
/* Método para eliminar mediante posición
    public boolean eliminar(Contacto contacto){
        int posicion = lista.indexOf(contacto);
        if (posicion!=-1){
            lista.remove(posicion);
            return true;
        }
        return false;
    }
*/


    /**
     * Método para borrar mediante un booleano.
     * Se explora si la lista contiene al contacto, porque, si no, no hay nada que eliminar.
     * Si la lista contiene el contacto especificado, se elimina de la lista y se anuncia con un mensaje
     * @param contacto el contacto que se va a borrar.
     * @return Un valor booleano en función de si se puede realizar la operación (true) o no (false).
     */
    public boolean borrar(Contacto contacto){
        if (lista.contains(contacto)){
            lista.remove(contacto);
            System.out.println("Se ha eliminado el contacto "+ contacto.getNombre()+ " " + contacto.getApellido());
            return true;
        }
        return false;
    }

    /**
     * Método para contar la cantidad de contactos que hay en la lista a partir del tamaño de esta.
     * @return El tamaño de la lista (la cantidad de elementos que contiene).
     */
    public int contarContactos(){
        return lista.size();
    }

    /**
     * El método toString, que incorpora a un StringBuilder todos contactos presentes dentro de la lista.
     * Utilizamos un StringBuilder porque, si no, mediante Strings creamos una única cadena cada vez que queda inmutable y se generan copias, lo que es menos eficiente.
     * Se emplea un bucle for que recorre todos los contactos de la lista y va añadiendo cada uno.
     * @return Los datos (contactos) de la agenda.
     */
    public String toString(){
        StringBuilder datos = new StringBuilder();
        datos.append("Contactos: \n\n");
        for (Contacto contacto : lista)
            datos.append(contacto.toString())
                    .append("\n");
        return datos.toString();
    }
}