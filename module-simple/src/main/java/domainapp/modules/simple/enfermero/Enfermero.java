package domainapp.modules.simple.enfermero;


import com.google.common.collect.ComparisonChain;
import domainapp.modules.simple.datosFamiliares.DatosFamiliares;
import domainapp.modules.simple.paciente.Paciente;
import domainapp.modules.simple.paciente.TipoDocumento;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.sf.cglib.core.Local;
import org.apache.isis.applib.annotation.*;

import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;
import org.apache.isis.schema.utils.jaxbadapters.JodaDateTimeStringAdapter;
import org.joda.time.LocalDate;

import javax.jdo.annotations.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

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
        table = "DatosEnfermero"
)
@DatastoreIdentity(
        strategy = IdGeneratorStrategy.IDENTITY,
        column = "id")
@Version(
        strategy = VersionStrategy.VERSION_NUMBER,
        column = "version")
@Unique(name = "DatosEnfermero_nombre_UNQ", members = { "nombre" })
@DomainObject(
        editing = Editing.DISABLED
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)


public class Enfermero  {

    /*public Enfermero(final String nombre, final String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Paciente newPaciente(final String name, final String apellido) {
        return repositoryService.persist(new Paciente(this,name,apellido));
    }

    @Persistent(mappedBy = "enfermero", dependentElement = "true")
    @Column(allowsNull = "true")
    @Property()
    private List<Paciente> pacientes;*/


    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private String nombre;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private String apellido;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @lombok.NonNull
    @Property() // editing disabled by default, see isis.properties
    @XmlJavaTypeAdapter(JodaDateTimeStringAdapter.ForJaxb.class)
    private LocalDate fechaAlta;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @lombok.NonNull
    @Property()
    private TipoDocumento tipoDocumento;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private String nroDocumento;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @lombok.NonNull
    @Property() // editing disabled by default, see isis.properties
    @XmlJavaTypeAdapter(JodaDateTimeStringAdapter.ForJaxb.class)
    private LocalDate fechaNacimiento;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private String lugarNacimiento;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private String telefono;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private String edad;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private String nroMatricula;

    public String title(){ return getNombre() + " " + getApellido(); }

    @Action()
    @ActionLayout(named = "Editar")
    public Enfermero updateEnfermero(
            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Nombre")
            final String nombre,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Apellido")
            final String apellido,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Fecha de Alta")
            final LocalDate fechaAlta,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Tipo de Documento")
            final TipoDocumento tipoDocumento,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Numero de Documento")
            final String nroDocumento,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Fecha de Nacimiento")
            final LocalDate fechaNacimiento,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Lugar de Nacimiento")
            final String lugarNacimiento,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Telefono")
            final String telefono,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Edad")
            final String edad,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Numero de Matricola")
            final String nroMatricula){

        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaAlta = fechaAlta;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.lugarNacimiento = lugarNacimiento;
        this.telefono = telefono;
        this.edad = edad;
        this.nroMatricula = nroMatricula;

        return this;

    }

    public String default0UpdateEnfermero() { return getNombre(); }
    public String default1UpdateEnfermero() { return getApellido(); }
    public LocalDate default2UpdateEnfermero() { return getFechaAlta(); }
    public TipoDocumento default3UpdateEnfermero() { return getTipoDocumento(); }
    public String default4UpdateEnfermero() { return getNroDocumento(); }
    public LocalDate default5UpdateEnfermero() { return getFechaNacimiento(); }
    public String default6UpdateEnfermero() { return getLugarNacimiento(); }
    public String default7UpdateEnfermero() { return getTelefono(); }
    public String default8UpdateEnfermero() { return getEdad(); }
    public String default9UpdateEnfermero() { return getNroMatricula(); }

    /*public TranslatableString validate0UpdateName(final String nombre) {
        return nombre != null && nombre.contains("!") ? TranslatableString.tr("Exclamation mark is not allowed") : null;
    }*/

    // @Action(semantics = NON_IDEMPOTENT_ARE_YOU_SURE)
    // public void delete() {
    //    final String title = titleService.titleOf(this);
    //   messageService.informUser(String.format("'%s' deleted", title));
    //   enfermeroRepository.remove(this);
    // }

    @Override
    public String toString() {
        return getNombre();
    }

    public int compareTo(final Enfermero other) {
        return ComparisonChain.start()
                .compare(this.getNombre(), other.getNombre())
                .result();
    }


    @javax.jdo.annotations.NotPersistent
    @javax.inject.Inject
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    RepositoryService repositoryService;

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    EnfermeroRepository enfermeroRepository;

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    TitleService titleService;

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    MessageService messageService;


}
