package domainapp.application.fixture.scenarios;

import domainapp.modules.simple.paciente.Paciente;
import domainapp.modules.simple.visita.Visita;
import domainapp.modules.simple.visita.VisitaMenu;
import lombok.Getter;
import lombok.Setter;
import org.apache.isis.applib.fixturescripts.FixtureScript;


public class VisitaCreate extends FixtureScript {

    @Getter
    @Setter
    private String altura;

    @Getter @Setter
    private Integer peso;

    @Getter @Setter
    private Integer temperatura;

    @Getter @Setter
    private Integer presionArterial;

    @Getter @Setter
    private Integer frecuenciaCardiaca;

    @Getter @Setter
    private Integer frecuenciaRespiratoria;

    @Getter @Setter
    private String estudiosLaboratorio;

    @Getter @Setter
    private String observacion;

    @Getter @Setter
    private Visita visitaObject;

    @Override
    protected void execute(final ExecutionContext ec) {


        String altura = checkParam("altura", ec, String.class);
        Integer peso = checkParam("peso", ec, Integer.class);
        Integer temperatura = checkParam("temperatura", ec, Integer.class);
        Integer presionArterial = checkParam("presionArterial", ec, Integer.class);
        Integer frecuenciaCardiaca = checkParam("frecuenciaCardiaca", ec, Integer.class);
        Integer frecuenciaRespiratoria = checkParam("frecuenciaRespiratoria", ec, Integer.class);
        String estudiosLaboratorio = checkParam("estudiosLaboratorio", ec, String.class);
        String observacion = checkParam("observacion", ec, String.class);

        this.visitaObject = wrap(menu).create(altura,peso,temperatura,presionArterial,frecuenciaCardiaca,frecuenciaRespiratoria,estudiosLaboratorio,observacion);

        // also make available to UI
        ec.addResult(this, visitaObject);
    }

    @javax.inject.Inject
    VisitaMenu menu;
}
