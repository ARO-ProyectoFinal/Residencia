package domainapp.modules.simple.reportes;

public class RepoDatosFamiliares {

    public String nombreCompletoFamiliar;
    public String parentesco;
    public String numeroContacto;
    public String mailFamiliar;

    public RepoDatosFamiliares(String nombreCompletoFamiliar, String parentesco, String numeroContacto, String mailFamiliar) {
        this.nombreCompletoFamiliar = nombreCompletoFamiliar;
        this.parentesco = parentesco;
        this.numeroContacto = numeroContacto;
        this.mailFamiliar = mailFamiliar;
    }

    public RepoDatosFamiliares() {}


    public String getNombreCompletoFamiliar(){ return  this.nombreCompletoFamiliar; }
    public String getParentesco() { return  this.parentesco; }
    public String getNumeroContacto() { return this.numeroContacto; }
    public String getMailFamiliar() { return this.mailFamiliar; }

}
