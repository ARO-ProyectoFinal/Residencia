package domainapp.modules.simple.historia;

import com.google.common.collect.ComparisonChain;
import domainapp.modules.simple.datosFamiliares.DatosFamiliares;
import domainapp.modules.simple.paciente.Paciente;
import domainapp.modules.simple.paciente.PacienteRepository;
import domainapp.modules.simple.planillaEnfermeros.Estado;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.title.TitleService;
import org.apache.isis.schema.utils.jaxbadapters.JodaDateTimeStringAdapter;
import org.joda.time.LocalDate;

import javax.jdo.annotations.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

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
        table = "HistoriaClinica"
)
@DatastoreIdentity(
        strategy = IdGeneratorStrategy.IDENTITY,
        column = "id")
@Version(
        strategy = VersionStrategy.VERSION_NUMBER,
        column = "version")
@Unique(name = "HistoriaClinica_hipertensionArterial_UNQ", members = { "hipertensionArterial" })
@DomainObject(
        editing = Editing.DISABLED
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)

public class Historia {

    @lombok.NonNull
    @Property()
    @Column()
    private Paciente paciente;

    @lombok.NonNull
    @Column(length = 40)
    @Property()
    private Estado hipertensionArterial;

    @javax.jdo.annotations.Column(length = 40)
    @Property()
    @lombok.NonNull
    private Estado diabetes;

    @javax.jdo.annotations.Column(length = 40)
    @Property()
    @lombok.NonNull
    private Estado enfCardiovascular;

    @javax.jdo.annotations.Column(length = 40)
    @Property()
    @lombok.NonNull
    private Estado marcapasos;

    @javax.jdo.annotations.Column(length = 40)
    @Property()
    @lombok.NonNull
    private Estado discopatias;

    @javax.jdo.annotations.Column(length = 40)
    @Property()
    @lombok.NonNull
    private Estado perdidaDeConocimiento;

    @javax.jdo.annotations.Column(length = 40)
    @Property()
    @lombok.NonNull
    private Estado artritis;

    @javax.jdo.annotations.Column(length = 40)
    @Property()
    @lombok.NonNull
    private Estado artrosis;

    @javax.jdo.annotations.Column(length = 40)
    @Property()
    @lombok.NonNull
    private Estado lumbago;

    @javax.jdo.annotations.Column(length = 40)
    @Property()
    @lombok.NonNull
    private Estado neurosis;

    @javax.jdo.annotations.Column(length = 40)
    @Property()
    @lombok.NonNull
    private Estado traumatismos;

    @javax.jdo.annotations.Column(length = 40)
    @Property()
    @lombok.NonNull
    private Estado problemasOtologicos;

    @javax.jdo.annotations.Column(length = 40)
    @Property()
    @lombok.NonNull
    private String comentarios;



    public String title(){
        return paciente.getName() + " " + paciente.getApellido();
    }


    @Action()
    @ActionLayout(named = "Editar")
    public Historia updateHistoria(
            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Hipertension Arterial")
            final Estado hipertensionArterial,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Diabetes")
            final Estado diabetes,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Enfermedad Cardiovascular")
            final Estado enfCardiovascular,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Usa Marcapasos")
            final Estado marcapasos,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Discopatias")
            final Estado discopatias,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Perdida del Conocimiento")
            final Estado perdidaDeConocimiento,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Artritis")
            final Estado artritis,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Artrosis")
            final Estado artrosis,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Lumbago")
            final Estado lumbago,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Neurosis")
            final Estado neurosis,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Traumatismos")
            final Estado traumatismos,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Problemas Otologicos")
            final Estado problemasOtologicos,

            @Parameter(maxLength = 200)
            @ParameterLayout(named = "Comentarios")
            final String comentarios){

          this.hipertensionArterial = hipertensionArterial;
          this.diabetes = diabetes;
          this.enfCardiovascular = enfCardiovascular;
          this.marcapasos = marcapasos;
          this.discopatias = discopatias;
          this.perdidaDeConocimiento = perdidaDeConocimiento;
          this.artritis = artritis;
          this.artrosis = artrosis;
          this.lumbago = lumbago;
          this.neurosis = neurosis;
          this.traumatismos = traumatismos;
          this.problemasOtologicos = problemasOtologicos;
          this.comentarios = comentarios;


          return this;

    }

    public Estado default0UpdateHistoria() { return getHipertensionArterial(); }
    public Estado default1UpdateHistoria() { return getDiabetes(); }
    public Estado default2UpdateHistoria() { return getEnfCardiovascular(); }
    public Estado default3UpdateHistoria() { return getMarcapasos(); }
    public Estado default4UpdateHistoria() { return getDiscopatias(); }
    public Estado default5UpdateHistoria() { return getPerdidaDeConocimiento(); }
    public Estado default6UpdateHistoria() { return getArtritis(); }
    public Estado default7UpdateHistoria() { return getArtrosis(); }
    public Estado default8UpdateHistoria() { return getLumbago(); }
    public Estado default9UpdateHistoria() { return getNeurosis(); }
    public Estado default10UpdateHistoria() { return getTraumatismos(); }
    public Estado default11UpdateHistoria() { return getProblemasOtologicos(); }
    public String default12UpdateHistoria() { return getComentarios(); }



    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    HistoriaRepository historiaRepository;

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
