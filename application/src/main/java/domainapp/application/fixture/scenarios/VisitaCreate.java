package domainapp.application.fixture.scenarios;

import domainapp.modules.simple.paciente.Paciente;
import domainapp.modules.simple.visita.Visita;
import domainapp.modules.simple.visita.VisitaMenu;
import lombok.Getter;
import lombok.Setter;
import org.apache.isis.applib.fixturescripts.FixtureScript;


public class VisitaCreate extends FixtureScript {

    @Getter @Setter
    private Paciente paciente;

    @Getter @Setter
    private String altura;

    @Getter @Setter
    private String peso;

    @Getter @Setter
    private String temperatura;

    @Getter @Setter
    private String presionArterial;

    @Getter @Setter
    private String frecuenciaCardiaca;

    @Getter @Setter
    private String frecuenciaRespiratoria;

    @Getter @Setter
    private String estudiosLaboratorio;

    @Getter @Setter
    private String observacion;

    @Getter @Setter
    private Visita visitaObject;

    @Override
    protected void execute(final ExecutionContext ec) {

        Paciente paciente = checkParam("paciente", ec, Paciente.class);
        String altura = checkParam("altura", ec, String.class);
        String peso = checkParam("peso", ec, String.class);
        String temperatura = checkParam("temperatura", ec, String.class);
        String presionArterial = checkParam("presionArterial", ec, String.class);
        String frecuenciaCardiaca = checkParam("frecuenciaCardiaca", ec, String.class);
        String frecuenciaRespiratoria = checkParam("frecuenciaRespiratoria", ec, String.class);
        String estudiosLaboratorio = checkParam("estudiosLaboratorio", ec, String.class);
        String observacion = checkParam("observacion", ec, String.class);

        this.visitaObject = wrap(menu).create(paciente, altura,peso,temperatura,presionArterial,frecuenciaCardiaca,frecuenciaRespiratoria,estudiosLaboratorio,observacion);

        // also make available to UI
        ec.addResult(this, visitaObject);
    }

    @javax.inject.Inject
    VisitaMenu menu;
}
