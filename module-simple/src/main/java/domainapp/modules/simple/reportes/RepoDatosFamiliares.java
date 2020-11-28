package domainapp.modules.simple.reportes;

public class RepoDatosFamiliares {

    public String paciente;
    public String nombreCompletoFamiliar;
    public String parentesco;
    public String numeroContacto;
    public String mailFamiliar;

    public RepoDatosFamiliares(String paciente, String nombreCompletoFamiliar, String parentesco, String numeroContacto, String mailFamiliar) {
        this.paciente = paciente;
        this.nombreCompletoFamiliar = nombreCompletoFamiliar;
        this.parentesco = parentesco;
        this.numeroContacto = numeroContacto;
        this.mailFamiliar = mailFamiliar;
    }

    public RepoDatosFamiliares() {}

    public String getPaciente() { return  this.paciente; }
    public String getNombreCompletoFamiliar(){ return  this.nombreCompletoFamiliar; }
    public String getParentesco() { return  this.parentesco; }
    public String getNumeroContacto() { return this.numeroContacto; }
    public String getMailFamiliar() { return this.mailFamiliar; }

}
