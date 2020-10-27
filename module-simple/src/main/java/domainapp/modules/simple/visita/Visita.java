package domainapp.modules.simple.visita;


import com.google.common.collect.ComparisonChain;
import domainapp.modules.simple.datosFamiliares.DatosFamiliares;
import domainapp.modules.simple.paciente.Paciente;
import domainapp.modules.simple.paciente.PacienteRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.title.TitleService;


import javax.jdo.annotations.*;

import static org.apache.isis.applib.annotation.CommandReification.ENABLED;
import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;


@Getter
@Setter
@lombok.RequiredArgsConstructor

@Queries({
        @Query(
                name = "find", language = "JDOQL",
                value = "SELECT "),
})
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
@Unique(name = "DatosVisitaMedica_altura_UNQ", members = { "altura" })
@DomainObject(
        editing = Editing.DISABLED
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)


public class Visita {

    @lombok.NonNull
    @Property()
    @Column(allowsNull = "false")
    private Paciente paciente;

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
    private String frecuenciaRespiratoria;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private String estudiosLaboratorio;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private String observacion;

    public String title(){ return paciente.getName() + " " + paciente.getApellido(); }



    @Action()
    @ActionLayout(named = "Editar")
    public Visita updateVisita(
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
            @ParameterLayout(named = "Frecuencia Respiratoria")
            final String frecuenciaRespiratoria,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Estudios Laboratorio")
            final String estudiosLaboratorio,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Observacion")
            final String observacion){

            this.altura = altura;
            this.peso = peso;
            this.temperatura = temperatura;
            this.presionArterial = presionArterial;
            this.frecuenciaCardiaca = frecuenciaCardiaca;
            this.frecuenciaRespiratoria = frecuenciaRespiratoria;
            this.estudiosLaboratorio = estudiosLaboratorio;
            this.observacion = observacion;


            return this;

    }

    public String default0UpdateVisita() {
        return getAltura();
    }
    public String default1UpdateVisita() {
        return getPeso();
    }
    public String default2UpdateVisita() {
        return getTemperatura();
    }
    public String default3UpdateVisita() {
        return getPresionArterial();
    }
    public String default4UpdateVisita() {
        return getFrecuenciaCardiaca();
    }
    public String default5UpdateVisita() {
        return getFrecuenciaRespiratoria();
    }
    public String default6UpdateVisita() {
        return getEstudiosLaboratorio();
    }
    public String default7UpdateVisita() {
        return getObservacion();
    }

    /*public TranslatableString validate0UpdateName(final String altura) {
        return altura != null && altura.contains("!") ? TranslatableString.tr("Exclamation mark is not allowed") : null;
    }*/


    // @Action(semantics = NON_IDEMPOTENT_ARE_YOU_SURE)
    // public void delete() {
    //    final String title = titleService.titleOf(this);
    //   messageService.informUser(String.format("'%s' deleted", title));
    //   visitaRepository.remove(this);
    // }


    @Override
    public String toString() {
        return getAltura();
    }

    public int compareTo(final Visita other) {
        return ComparisonChain.start()
                .compare(this.getAltura(), other.getAltura())
                .result();
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
