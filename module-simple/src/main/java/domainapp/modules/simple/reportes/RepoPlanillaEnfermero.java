package domainapp.modules.simple.reportes;


public class RepoPlanillaEnfermero {

    public String paciente;
    public String enfermero;
    public String fechaPlanilla;
    public String turno;
    public String medicacion;
    public String curaciones;
    public String actividadFisica;
    public String comidas;
    public String ropa;
    public String limpieza;
    public String observacion;



    public RepoPlanillaEnfermero(String paciente, String enfermero, String fechaPlanilla, String turno, String medicacion, String curaciones, String actividadFisica, String comidas, String ropa, String limpieza, String observacion) {

        this.paciente = paciente;
        this.enfermero = enfermero;
        this.fechaPlanilla = fechaPlanilla;
        this.turno = turno;
        this.medicacion = medicacion;
        this.curaciones = curaciones;
        this.actividadFisica = actividadFisica;
        this.comidas = comidas;
        this.ropa = ropa;
        this.limpieza = limpieza;
        this.observacion = observacion;
    }

    public RepoPlanillaEnfermero() {}

    public String getPaciente() { return  this.paciente; }
    public String getEnfermero() { return  this.enfermero; }
    public String getFechaPlanilla() { return this.fechaPlanilla; }
    public String getTurno() { return this.turno; }
    public String getMedicacion() { return this.medicacion; }
    public String getCuraciones() { return  this.curaciones; }
    public String getActividadFisica() { return this.actividadFisica; }
    public String getComidas() { return  this.comidas; }
    public String getRopa() { return  this.ropa; }
    public String getLimpieza() { return this.limpieza; }
    public String getObservacion() { return this.observacion; }

}

