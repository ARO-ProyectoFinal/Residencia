package domainapp.modules.simple.enfermero;


import com.google.common.collect.ComparisonChain;
import domainapp.modules.simple.paciente.TipoDocumento;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;
import org.apache.isis.schema.utils.jaxbadapters.JodaDateTimeStringAdapter;
import org.joda.time.LocalDate;

import javax.jdo.annotations.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@Getter
@Setter
@lombok.RequiredArgsConstructor

@Queries({
        @Query(
                name = "find", language = "JDOQL",
                value = "SELECT "),
        @Query(
                name = "findByEstado", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.modules.simple.enfermero.Enfermero "
                        + "WHERE estado == :estado "
                        + "ORDER BY name ASC")

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

    @javax.jdo.annotations.Column(allowsNull = "true", name = "estado")
    @Property()
    private EstadoEnfermero estado;

    public String title(){ return getNombre() + " " + getApellido(); }

    public String RepoNombre() { return this.nombre; }
    public String RepoApellido() { return this.apellido; }
    public String RepoEdad() { return this.edad; }
    public String RepoTelefono() { return this.telefono; }
    public String RepoNroMatricula() { return this.nroMatricula; }

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


    @Override
    public String toString() {
        return getNombre();
    }

    public int compareTo(final Enfermero other) {
        return ComparisonChain.start()
                .compare(this.getNombre(), other.getNombre())
                .result();
    }

    @Programmatic
    public  void CambiarEstado(EstadoEnfermero estado){
        this.estado = estado;
    }
    @Action()
    public  Enfermero Habilitar(){
        CambiarEstado(EstadoEnfermero.Habilitado);
        return this;
    }
    @Action(semantics = SemanticsOf.IDEMPOTENT_ARE_YOU_SURE)
    public  Enfermero Inhabilitar(){
        CambiarEstado(EstadoEnfermero.Inhabilitado);
        return this;
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
