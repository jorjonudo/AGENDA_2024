package dominio;
public class Contacto {
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;
    public Contacto (String nombre_, String apellidos_, String telefono_, String email_){
            nombre = nombre_;
            apellidos = apellidos_;
            telefono = telefono_;
            email = email_;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellidos (){
        return apellidos;
    }
    public String getTelefono(){
        return telefono;
    }
    public String getEmail (){
        return email;
    }
    public Contacto setNomrbe(String nombre_){
        nombre = nombre_;
        return this;
    }
    public Contacto setApellidos(String apellidos_){
        apellidos = apellidos_;
        return this;
    }
    public Contacto setTelefono(String telefono_){
        telefono = telefono_;
        return this;
    }
    public Contacto setEmail(String email_){
        email = email_;
        return this;
    }
    public String toString (){
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ")
        .append(nombre).append(" ")
        .append("apellidos ")
        .append(apellidos)
        .append("\n")
        .append("telefono")
        .append(telefono)
        .append("\n")
        .append("email")
        .append(email);
        return sb.toString();
    }
    public boolean equals(Object o){
        if (o == null)
            return false;
    if (this.getClass() == o.getClass())
        return false;
        Contacto c = (Contacto) o;
        return nombre.equals(c.nombre) && apellidos.equals(c.apellidos);
    }
    public int hashCode (){
        return (nombre.hashCode()-1)*33+apellidos.hashCode();
    }
    public Contacto(String nombre, String telefono){
        this(nombre, "", telefono, "");
    }
}