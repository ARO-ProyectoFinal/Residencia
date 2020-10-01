package domainapp.modules.simple.visita;


import domainapp.modules.simple.paciente.Paciente;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.title.TitleService;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Persistent;

@Getter
@Setter
@lombok.RequiredArgsConstructor
public class Visita {

    @Persistent(mappedBy = "visita",defaultFetchGroup = "true")
    @Column(allowsNull = "false", length = 40)
    private Paciente paciente;

    @lombok.NonNull
    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private String altura;

    @lombok.NonNull
    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private Integer peso;

    @lombok.NonNull
    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private Integer temperatura;

    @lombok.NonNull
    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private Integer presionArterial;

    @lombok.NonNull
    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private Integer frecuenciaCardiaca;

    @lombok.NonNull
    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private Integer frecuenciaRespiratoria;

    @lombok.NonNull
    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private String estudiosLaboratorio;

    @lombok.NonNull
    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private String observacion;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    VisitaRepository visitaRepository;

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    TitleService titleService;

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    MessageService messageService;
}
