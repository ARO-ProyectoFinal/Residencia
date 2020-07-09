package domainapp.modules.simple.historia;

import lombok.Getter;
import lombok.Setter;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.schema.utils.jaxbadapters.JodaDateTimeStringAdapter;
import org.joda.time.LocalDate;

import javax.jdo.annotations.Column;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Getter
@Setter
public class Historia {

    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private VacunaRecibida vacunaRecibida;

    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private String vacuRecibida;

    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private VacunaFaltante vacunaFaltante;

    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private String vacuFaltante;

    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private EnfermedadPadecida enfermedadPadecida;

    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private String enfePadecida;

    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private Alergias alergias;

    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private String alerPadecida;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @lombok.NonNull
    @Property(editing = Editing.ENABLED)
    @XmlJavaTypeAdapter(JodaDateTimeStringAdapter.ForJaxb.class)
    @Title()
    private LocalDate ultimaVisitaMedica;

    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private String tipoMedicacion;

    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private String lapsoIngesta;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @lombok.NonNull
    @Property(editing = Editing.ENABLED)
    @Title()
    private Integer stockMedicacion;

    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private String medicacionAnterior;

}
