package domainapp.modules.simple.visita;


import com.google.common.collect.ComparisonChain;
import domainapp.modules.simple.datosFamiliares.DatosFamiliares;
import domainapp.modules.simple.paciente.Paciente;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
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

    /*@Persistent(mappedBy = "visita",defaultFetchGroup = "true")
    @Column(allowsNull = "false", length = 40)
    private Paciente paciente;*/

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

    /*public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }*/

    public String title(){
        return getAltura();
    }


    @Action(semantics = IDEMPOTENT, command = ENABLED, publishing = Publishing.ENABLED, associateWith = "altura")
    public Visita updateName(
            @Parameter(maxLength = 40)
            @ParameterLayout(named = "altura") final String altura


    ) {
        setAltura(altura);

        return this;

    }

    public String default0UpdateName() {
        return getAltura();
    }

    public TranslatableString validate0UpdateName(final String altura) {
        return altura != null && altura.contains("!") ? TranslatableString.tr("Exclamation mark is not allowed") : null;
    }


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

    @javax.jdo.annotations.NotPersistent
    @javax.inject.Inject
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    RepositoryService repositoryService;

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    TitleService titleService;

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    MessageService messageService;
}
