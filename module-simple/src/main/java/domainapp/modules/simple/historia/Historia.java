package domainapp.modules.simple.historia;

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
        table = "HistoriaClinica"
)
@DatastoreIdentity(
        strategy = IdGeneratorStrategy.IDENTITY,
        column = "id")
@Version(
        strategy = VersionStrategy.VERSION_NUMBER,
        column = "version")
@Unique(name = "HistoriaClinica_nombre_UNQ", members = { "nombre" })
@DomainObject(
        editing = Editing.DISABLED
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)




public class Historia {

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


    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    HistoriaRepository historiaRepository;

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    TitleService titleService;

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    MessageService messageService;

}
