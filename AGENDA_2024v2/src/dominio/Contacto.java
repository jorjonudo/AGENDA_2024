/**
 * Contacto es la clase más básica dentro de este programa; es aquello con lo que trabajamos, principalmente.
 * En este caso, el programa consiste en una agenda de contactos.
 */


//Definimos el paquete
/**
 * Lo primero que se realiza es definir el paquete en el que se encuentra la clase; en este caso, el paquete es el dominio.
 * En un paquete del tipo "dominio" introducimos todas aquellas clases con las que trabaja el programa.
 *
 * Después, importamos las librerías pertinentes; para esta clase importaremos la librería java.io completa, aunque solo necesitaremos Serializable.
 */
package dominio;
import java.io.*;
//Definimos la clase

/**
 * Contacto es la clase más básica dentro de este programa; es aquello con lo que trabajamos, principalmente.
 * En este caso, el programa consiste en una agenda de contactos.
 * Serializable es necesario para el toString final y para la función de guardado.
 */
public class Contacto implements Serializable{
    /**
     * Aquí se definen los atributos de la clase Contacto.
     * Tenemos cuatro atributos tipo String, que son nombre, apellido, telefono y email; pero también tenemos un boolean, que es favorito.
     * Empleamos un boolean en favorito porque un contacto solo puede ser favorito o no favorito, pero no los dos a la vez.
     */
    //Definimos atributos
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private boolean favorito;

    /**
     * El constructor utilizado para asignar unos valores iniciales a cada atributo es este.
     * @param nombre el nombre del contacto. Si el contacto tiene más de un nombre, se deben escribir separados por espacios, ya que se cuenta como un solo string porque la separación entre órdenes y atributos y entre atributos viene dada por comas (,).
     * @param apellido el apellido del contacto. Dado que puede tener más de uno, se separan con espacios porque la separación entre órdenes y atributos y entre atributos se hace con comas (,).
     * @param telefono el número de teléfono del contacto. Es un String y no un Int porque su tratamiento final es como el de un String, ya que no hay que hacer operaciones con este número.
     * @param email el correo electrónico del contacto.
     * El único de loss valores que es un poco distinto es el del boolean (favorito); como queremos agregar manualmente un contacto a favoritos, por defecto no lo será.
     * Además, favorito no se añade cuando agregamos un contacto, sino que se realiza con otra función distinta, por esto no se le llama en el paréntesis.
     */
    //Constructor. SIEMPRE con el nombre de la clase y sin tipo de retorno (VOID)
    public Contacto(String nombre, String apellido, String telefono, String email){
        this.nombre=nombre;
        this.apellido=apellido;
        this.telefono=telefono;
        this.email=email;
        this.favorito=false;
    }

    /**
     * Un constructor únicamente con los atributos nombre y apellido.
     * Este constructor se utiliza mediante sobrecarga para realizar operaciones sobre un contacto sin necesidad de escribir cada dato.
     * Vemos de vital importancia este constructor para la búsqueda por nombre, ya que en un caso real podríamos no saber datos como el teléfono o el email del contacto.
     *
     * @param nombre el nombre del contacto. Si el contacto tiene más de un nombre, se deben escribir separados por espacios, ya que se cuenta como un solo string porque la separación entre órdenes y atributos y entre atributos viene dada por comas (,).
     * @param apellido el apellido del contacto. Dado que puede tener más de uno, se separan con espacios porque la separación entre órdenes y atributos y entre atributos se hace con comas (,).
     */
    public Contacto(String nombre, String apellido){
        this.nombre=nombre;
        this.apellido=apellido;
    }

    /**
     * Un constructor vacío y, por tanto, sin parámetros.
     */
    public Contacto(){
        nombre = "";
        apellido = "";
    }

    /**
     * Método setter del nombre del contacto para asignar un valor a partir de un String.
     * @param nombre el nombre del contacto.
     * @return El contacto con el nuevo nombre asignado.
     */
    //Métodos setter
    public Contacto setNombre(String nombre){
        this.nombre=nombre;
        return this;
    }
    /**
     * Método setter del apellido del contacto para asignar un valor a partir de un String.
     * @param apellido el apellido del contacto.
     * @return El contacto con el nuevo apellido asignado.
     */
    public Contacto setApellido(String apellido){
        this.apellido=apellido;
        return this;
    }
    /**
     * Método setter del teléfono del contacto para asignar un valor a partir de un String.
     * @param telefono el teléfono del contacto.
     * @return El contacto con el nuevo número de teléfono asignado.
     */
    public Contacto setTelefono(String telefono){
        this.telefono=telefono;
        return this;
    }
    /**
     * Método setter del correo electrónico del contacto para asignar un valor a partir de un String.
     * @param email el correo electrónico del contacto.
     * @return El contacto con el nuevo correo electrónico asignado.
     */
    public Contacto setEmail(String email){
        this.email=email;
        return this;
    }

    /**
     * Método setter del nombre del contacto para asignar un valor a partir de un valor boolean.
     */
    public void setFavorito(boolean favorito){
        this.favorito=favorito;
    }

    //Métodos getter

    /**
     * Método getter para obtener el nombre de un contacto.
     * @return El nombre del contacto.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Método getter para obtener el apellido de un contacto.
     * @return El apellido del contacto.
     */
    public String getApellido() {
        return apellido;
    }
    /**
     * Método getter para obtener el número de teléfono de un contacto.
     * @return El número de teléfono del contacto.
     */
    public String getTelefono() {
        return telefono;
    }
    /**
     * Método getter para obtener el correo electrónico de un contacto.
     * @return El correo electrónico del contacto.
     */
    public String getEmail(){
        return email;
    }
    /**
     * Método getter para obtener el valor boolean que indica si el contacto es favorito o no.
     * @return El valor boolean del atributo favorito del contacto.
     */
    public boolean getFavorito(){
        return favorito;
    }

    public String esFavorito(){
        if (favorito==true){
            return ("Favorito");
        }
        return ("");
    }

    //Método toString utilizando un StringBuilder para que me devuelva un solo String con cada uno, de forma que no queden inmutables por separado
    //Preferimos concatenar, que deja menos "basura" y es más eficiente porque no crea un String nuevo cada vez

    /**
     * El método toString, que incorpora a un StringBuilder todos los atributos asignados al contacto.
     * Utilizamos un StringBuilder porque, si no, mediante Strings creamos una única cadena cada vez que queda inmutable y se generan copias, lo que es menos eficiente.
     * @return Los datos (atributos) del contacto.
     */

    public String toString(){
        StringBuilder datos = new StringBuilder();
        datos.append("Nombre: ")
                .append(getNombre())
                .append(" ")
                .append(getApellido())
                .append("\n")
                .append("Telefono: ")
                .append(getTelefono())
                .append("\n")
                .append("Email: ")
                .append(getEmail())
                .append("\n")
                .append(esFavorito())
                .append("\n");
        return datos.toString();
    }

    //Necesitamos un método que compare los datos introducidos con los que ya hay dentro. Si el objeto introducido es una referenca nula, le pedimos que retorne falso dentro del boolean, y también si la clase no es la misma.
    //Si no se define el método equals, se compara la misma referencia.
    //Objetos con mismo estado: objetos diferentes que tienen mismos atributos, pero no son el mismo. Equals compara el estado de los objetos

    /**
     * Redefinición del método equals, que ya viene definido por defecto en la clase Object.
     * Al sobreescribir el método equals, ahora responde de forma distinta porque ya no es el mismo. No es una sobrecarga porque solo permanece el método sobreescrito.
     * El método equals consiste en un booleano en el que se comparan determinados atributos.
     * Si el objeto es nulo, se retorna falso, ya que un objeto nunca puede ser nulo. O existe, o no existe, pero si existe no puede ser nulo.
     * Si el objeto dado tiene una clase distinta al objeto ya creado, también se retorna falso, ya que no podemos comparar objetos de distintas clases; sería algo que no tendría sentido.
     * Por último, si no se da ninguna de estas condiciones, se le atribuyes a un nuevo contacto c los valores del contacto o y se comparan el nombre y el apellido.
     * @param o el objeto que se está utilizando.
     * @return Valores booleanos falsos o la comparación del nombre y apellido.
     */
    public boolean equals (Object o){
        //Escribimos Object o porque sobreescribimos el método equals de la clase object. Sobreescribir NO es sobrecargar
        //Compara si el objeto es nulo. This no puede ser nulo nunca, por lógica
        if (o==null){
            return false;
        }
        //Comprobar si son de la misma clase
        else if (this.getClass()!=o.getClass()){
            return false;
        } //Después de un retorno, el if no se continúa
        //Hay que cambiar el tipo de o de Object a Contacto, de tal forma que podamos comparar dos obetos del mismo tipo. CAMBIO DE TIPO
        Contacto c = (Contacto) o;
        return nombre.equals(c.nombre) && apellido.equals(c.apellido);
    }

    /**
     * Método hashCode para "cifrar" la dirección de almacenamiento del contacto para que no aparezcan dos iguales.
     * Se realizan algunas operaciones con el hashCode original de cada atributo para dar dos números diferentes.
     * @return El valor hashCode del nombre tras realizarse unas operaciones y el del apellido.
     */
    //Internamente, utiliza el diccionario para saber en qué dirección almacenar el contacto. LO MANEJA JAVA INTERNAMENTE, NO YO.
    public int hashCode (){
        //Hacemos operaciones "complejas" con el hashCode para que no dé problemas de sinónimos
        return (nombre.hashCode()-1)*33+apellido.hashCode();

    }
}