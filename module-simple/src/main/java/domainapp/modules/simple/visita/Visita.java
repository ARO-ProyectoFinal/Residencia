package domainapp.modules.simple.visita;


import com.google.common.collect.ComparisonChain;
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
        schema = "simple",
        table = "DatosVisitaMedica"
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
                        + "FROM domainapp.modules.simple.visita.Visita "
                        + "ORDER BY idVisita ASC"),

        @Query(
                name = "findByPaciente", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.modules.simple.visita.Visita "
                        + "WHERE paciente == :paciente "
                        + "ORDER BY idVisita ASC")
})
@Unique(name = "DatosVisitaMedica_idVisita_UNQ", members = { "idVisita" })
@DomainObject(
        editing = Editing.DISABLED
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)


public class Visita implements Comparable <Visita>{

    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    @lombok.NonNull
    @Property(hidden = Where.EVERYWHERE)
    private int idVisita;

    @lombok.NonNull
    @Property()
    @Column(allowsNull = "false")
    private Paciente paciente;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @lombok.NonNull
    @Property() // editing disabled by default, see isis.properties
    @XmlJavaTypeAdapter(JodaDateTimeStringAdapter.ForJaxb.class)
    private LocalDate fechaUltimaVisita;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private String altura;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private String peso;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private String temperatura;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private String presionArterial;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private String frecuenciaCardiaca;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private String observacion;

    public String title(){
        return getIdVisita() == 0 ?"Paciente " : "Paciente " + paciente.getName() + " " + paciente.getApellido(); }



    @Action()
    @ActionLayout(named = "Editar")
    public Visita updateVisita(
            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Fecha Ultima Visita")
            final LocalDate fechaUltimaVisita,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Altura")
            final String altura,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Peso")
            final String peso,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Temperatura")
            final String temperatura,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Presion Arterial")
            final String presionArterial,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Frecuencia Cardiaca")
            final String frecuenciaCardiaca,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Observacion")
            final String observacion){

            this.fechaUltimaVisita = fechaUltimaVisita;
            this.altura = altura;
            this.peso = peso;
            this.temperatura = temperatura;
            this.presionArterial = presionArterial;
            this.frecuenciaCardiaca = frecuenciaCardiaca;
            this.observacion = observacion;


            return this;

    }

    public LocalDate default0UpdateVisita() {
        return getFechaUltimaVisita();
    }
    public String default1UpdateVisita() {
        return getAltura();
    }
    public String default2UpdateVisita() {
        return getPeso();
    }
    public String default3UpdateVisita() {
        return getTemperatura();
    }
    public String default4UpdateVisita() {
        return getPresionArterial();
    }
    public String default5UpdateVisita() {
        return getFrecuenciaCardiaca();
    }
    public String default6UpdateVisita() {
        return getObservacion();
    }


    @Override
    public int compareTo(final Visita other) {
        return org.apache.isis.applib.util.ObjectContracts.compare(this, other, "idVisita");
    }

    @Override
    public String toString() {
        return org.apache.isis.applib.util.ObjectContracts.toString(this, "idVisita");
    }


    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    VisitaRepository visitaRepository;

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
