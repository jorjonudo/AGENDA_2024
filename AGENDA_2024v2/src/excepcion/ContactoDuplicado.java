package excepcion;
import dominio.*;


public class ContactoDuplicado extends Exception {


    private Contacto contactoDuplicado;


    public ContactoDuplicado(Contacto contactoDuplicado){
        this.contactoDuplicado=contactoDuplicado;
    }

    public ContactoDuplicado(){}

    public Contacto getContactoDuplicado(){
        return contactoDuplicado;
    }

}