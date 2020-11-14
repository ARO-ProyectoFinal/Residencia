package domainapp.modules.simple.reportes;

public class RepoEnfermero {

    public String nombre;
    public String apellido;
    public String edad;
    public String telefono;
    public String nroMatricula;

    public RepoEnfermero(String nombre, String apellido, String edad, String telefono, String nroMatricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.nroMatricula = nroMatricula;
    }

    public RepoEnfermero() {}

    public String getNombre() { return  this.nombre; }
    public String getApellido() { return this.apellido; }
    public String getEdad() { return this.edad; }
    public String getTelefono() { return this.telefono; }
    public String getNroMatricula() { return this.nroMatricula; }
}
