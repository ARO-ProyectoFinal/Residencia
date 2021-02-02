package domainapp.modules.simple.planillaEnfermeros;


import domainapp.modules.simple.enfermero.Enfermero;
import domainapp.modules.simple.enfermero.EnfermeroRepository;
import domainapp.modules.simple.paciente.Paciente;
import domainapp.modules.simple.paciente.PacienteRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.title.TitleService;
import org.apache.isis.schema.utils.jaxbadapters.JodaDateTimeStringAdapter;
import org.joda.time.LocalDate;

import javax.jdo.annotations.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Getter
@Setter
@lombok.RequiredArgsConstructor



@PersistenceCapable(
        identityType = IdentityType.DATASTORE,
        schema = "simple"

)
@DatastoreIdentity(
        strategy = IdGeneratorStrategy.IDENTITY,
        column = "id")
@Version(
        strategy = VersionStrategy.VERSION_NUMBER,
        column = "version")
@Queries({
        @Query(
                name = "find", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.modules.simple.planillaEnfermeros.PlanillaEnfermero "
                        + "ORDER BY idPlanillaEnfermeros ASC"),

        @Query(
                name = "findByPaciente", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.modules.simple.planillaEnfermeros.PlanillaEnfermero "
                        + "WHERE paciente == :paciente "
                        + "ORDER BY idPlanillaEnfermeros ASC")
})

@Unique(name = "PlanillaEnfermero_idPlanillaEnfermeros_UNQ", members = { "idPlanillaEnfermeros" })
@DomainObject(
        editing = Editing.DISABLED
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)

public class PlanillaEnfermero implements Comparable <PlanillaEnfermero> {

    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    @lombok.NonNull
    @Property(hidden = Where.EVERYWHERE)
    private int idPlanillaEnfermeros;

    @lombok.NonNull
    @Property()
    @Column(allowsNull = "false")
    private Paciente paciente;

    @lombok.NonNull
    @Property()
    @Column(allowsNull = "false")
    private Enfermero enfermero;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @lombok.NonNull
    @Property() // editing disabled by default, see isis.properties
    @XmlJavaTypeAdapter(JodaDateTimeStringAdapter.ForJaxb.class)
    private LocalDate fechaPlanilla;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private Turnos turno;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private Estado medicacion;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private Estado curaciones;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private Estado actividadFisica;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private Comidas comidas;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private Estado ropa;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private Estado limpieza;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private String observacion;

    public String title(){
       return getIdPlanillaEnfermeros() == 0 ?"Paciente " : "Paciente " + paciente.getName() + " " + paciente.getApellido();
    }

    public String RepoPaciente() { return String.valueOf(this.paciente); }
    public String RepoEnfermero() { return String.valueOf(this.enfermero); }
    public LocalDate RepoFechaPlanilla() { return this.fechaPlanilla; }
    public String RepoTurnos() { return this.turno.toString(); }
    public String RepoMedicacion() { return this.medicacion.toString(); }
    public String RepoCuraciones() { return this.curaciones.toString(); }
    public String RepoActividadFisica() { return this.actividadFisica.toString(); }
    public String RepoComidas() { return this.comidas.toString(); }
    public String RepoRopa() { return this.ropa.toString(); }
    public String RepoLimpieza() { return this.limpieza.toString(); }
    public String RepoObservacion() { return this.observacion; }


    @Action()
    @ActionLayout(named = "Editar")
    public PlanillaEnfermero updatePlanillaEnfermeros(
            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Paciente")
            final Paciente paciente,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Enfermero")
            final Enfermero enfermero,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Fecha Planilla")
            final LocalDate fechaPlanilla,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Turno")
            final Turnos turno,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Tomo Medicacion")
            final Estado medicacion,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Realizo Curaciones")
            final Estado curaciones,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Realizo Actividad Fisica")
            final Estado actividadFisica,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Comidas realizadas")
            final Comidas comidas,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Realizo Limpieza de Ropa")
            final Estado ropa,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Realizo Limpieza de Pisos")
            final Estado limpieza,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Observacion")
            final String observacion){

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


        return this;

    }

    public Paciente default0UpdatePlanillaEnfermeros() {
        return getPaciente();
    }
    public Enfermero default1UpdatePlanillaEnfermeros() {
        return getEnfermero();
    }
    public LocalDate default2UpdatePlanillaEnfermeros() {
        return getFechaPlanilla();
    }
    public Turnos default3UpdatePlanillaEnfermeros() {
        return getTurno();
    }
    public Estado default4UpdatePlanillaEnfermeros() {
        return getMedicacion();
    }
    public Estado default5UpdatePlanillaEnfermeros() {
        return getCuraciones();
    }
    public Estado default6UpdatePlanillaEnfermeros() {
        return getActividadFisica();
    }
    public Comidas default7UpdatePlanillaEnfermeros() {
        return getComidas();
    }
    public Estado default8UpdatePlanillaEnfermeros() {
        return getRopa();
    }
    public Estado default9UpdatePlanillaEnfermeros() {
        return getLimpieza();
    }
    public String default10UpdatePlanillaEnfermeros() {
        return getObservacion();
    }

    public int compareTo(final PlanillaEnfermero other) {
        return org.apache.isis.applib.util.ObjectContracts.compare(this, other, "idPlanillaEnfermero");
    }

    @Override
    public String toString() {
        return org.apache.isis.applib.util.ObjectContracts.toString(this, "idPlanillaEnfermero");
    }

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    PlanillaEnfermeroRepository planillaEnfermeroRepository;

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    EnfermeroRepository enfermeroRepository;

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    PacienteRepository pacienteRepository;

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    TitleService titleService;

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    MessageService messageService;

}
