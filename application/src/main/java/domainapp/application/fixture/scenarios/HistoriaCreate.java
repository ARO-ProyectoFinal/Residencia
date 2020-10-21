package domainapp.application.fixture.scenarios;

import domainapp.modules.simple.historia.Historia;
import domainapp.modules.simple.historia.HistoriaMenu;
import domainapp.modules.simple.paciente.Paciente;
import lombok.Getter;
import lombok.Setter;
import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.joda.time.LocalDate;

public class HistoriaCreate extends FixtureScript {

    @Getter
    @Setter
    private Paciente paciente;

    @Getter
    @Setter
    private String vacuRecibida;

    @Getter
    @Setter
    private String vacuFaltante;

    @Getter
    @Setter
    private String enfePadecida;

    @Getter
    @Setter
    private String alerPadecida;

    @Getter
    @Setter
    private LocalDate ultimaVisitaMedica;

    @Getter
    @Setter
    private String tipoMedicacion;

    @Getter
    @Setter
    private String lapsoIngesta;

    @Getter
    @Setter
    private Integer stockMedicacion;

    @Getter
    @Setter
    private String medicacionAnterior;

    @Getter
    @Setter
    private Historia historiaObject;

    @Override
    protected void execute(final ExecutionContext ec) {

        Paciente paciente = checkParam("paciente", ec, Paciente.class);
        String vacuRecibida = checkParam("vacuRecibida", ec, String.class);
        String vacuFaltante = checkParam("vacuFaltante", ec, String.class);
        String enfePadecida = checkParam("enfePadecida", ec, String.class);
        String alerPadecida = checkParam("alerPadecida", ec, String.class);
        LocalDate ultimaVisitaMedica = checkParam("ultimaVisitaMedica", ec, LocalDate.class);
        String tipoMedicacion = checkParam("tipoMedicacion", ec, String.class);
        String lapsoIngesta = checkParam("lapsoIngesta", ec, String.class);
        Integer stockMedicacion = checkParam("stockMedicacion", ec, Integer.class);
        String medicacionAnterior = checkParam("medicacionAnterior", ec, String.class);


        this.historiaObject = wrap(menu).create(paciente, vacuRecibida,vacuFaltante,enfePadecida,alerPadecida,ultimaVisitaMedica,tipoMedicacion,lapsoIngesta,stockMedicacion,medicacionAnterior);

        // also make available to UI
        ec.addResult(this, historiaObject);
    }

    @javax.inject.Inject
    HistoriaMenu menu;
}
