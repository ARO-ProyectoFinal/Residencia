package domainapp.modules.simple.historia;

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
@Unique(name = "HistoriaClinica_vacuRecibida_UNQ", members = { "vacuRecibida" })
@DomainObject(
        editing = Editing.DISABLED
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)

public class Historia {

    @lombok.NonNull
    @Property()
    @Column(allowsNull = "false")
    private Paciente paciente;

    @lombok.NonNull
    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private String vacuRecibida;

    @lombok.NonNull
    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private String vacuFaltante;

    @lombok.NonNull
    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private String enfePadecida;

    @lombok.NonNull
    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private String alerPadecida;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @lombok.NonNull
    @Property()
    @XmlJavaTypeAdapter(JodaDateTimeStringAdapter.ForJaxb.class)
    @Title()
    private LocalDate ultimaVisitaMedica;

    @lombok.NonNull
    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private String tipoMedicacion;

    @lombok.NonNull
    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private String lapsoIngesta;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @lombok.NonNull
    @Property()
    @Title()
    private Integer stockMedicacion;

    @lombok.NonNull
    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private String medicacionAnterior;


    public String title(){
        return paciente.getName() + " " + paciente.getApellido();
    }


    @Action()
    @ActionLayout(named = "Editar")
    public Historia updateHistoria(
            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Vacuna Recibida")
            final String vacuRecibida,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Vacuna Faltante")
            final String vacuFaltante,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Enfermedad Padecida")
            final String enfePadecida,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Alegia Padecida")
            final String alerPadecida,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Ultima Visita Medica")
            final LocalDate ultimaVisitaMedica,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Tipo de Medicacion")
            final String tipoMedicacion,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Lapso Ingesta")
            final String lapsoIngesta,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Stock Medicacion")
            final Integer stockMedicacion,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Medicacion Anterior")
            final String medicacionAnterior){

          this.vacuRecibida = vacuRecibida;
          this.vacuFaltante = vacuFaltante;
          this.enfePadecida = enfePadecida;
          this.alerPadecida = alerPadecida;
          this.ultimaVisitaMedica = ultimaVisitaMedica;
          this.tipoMedicacion = tipoMedicacion;
          this.lapsoIngesta = lapsoIngesta;
          this.stockMedicacion = stockMedicacion;
          this.medicacionAnterior = medicacionAnterior;

          return this;

    }

    public String default0UpdateHistoria() { return getVacuRecibida(); }
    public String default1UpdateHistoria() { return getVacuFaltante(); }
    public String default2UpdateHistoria() { return getEnfePadecida(); }
    public String default3UpdateHistoria() { return getAlerPadecida(); }
    public LocalDate default4UpdateHistoria() { return getUltimaVisitaMedica(); }
    public String default5UpdateHistoria() { return getTipoMedicacion(); }
    public String default6UpdateHistoria() { return getLapsoIngesta(); }
    public Integer default7UpdateHistoria() { return getStockMedicacion(); }
    public String default8UpdateHistoria() { return getMedicacionAnterior(); }


    @Override
    public String toString() {  return getVacuRecibida(); }

    public int compareTo(final Historia other) {
        return ComparisonChain.start()
                .compare(this.getVacuRecibida(), other.getVacuRecibida())
                .result();
    }

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
