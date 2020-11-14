package domainapp.modules.simple.reportes;



public class RepoPaciente {

    private String name;
    private String apellido;
    private String fechaAlta;
    private int edad;
    private String incapacidad;
    private String observacion;

    public RepoPaciente(String name, String apellido, String fechaAlta, int edad, String incapacidad, String observacion) {
        this.name = name;
        this.apellido = apellido;
        this.fechaAlta = fechaAlta;
        this.edad = edad;
        this.incapacidad = incapacidad;
        this.observacion = observacion;
    }


    public RepoPaciente() {}

    public String getName(){ return  this.name; }
    public String getApellido() { return this.apellido; }
    public String getFechaAlta() { return  this.fechaAlta; }
    public int getEdad() { return this.edad; }
    public String getIncapacidad() { return this.incapacidad; }
    public String getObservacion() { return this.observacion; }

}
