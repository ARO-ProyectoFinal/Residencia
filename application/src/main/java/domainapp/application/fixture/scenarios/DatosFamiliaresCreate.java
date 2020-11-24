package domainapp.application.fixture.scenarios;

import domainapp.modules.simple.datosFamiliares.DatosFamiliares;
import domainapp.modules.simple.datosFamiliares.DatosFamiliaresMenu;
import domainapp.modules.simple.paciente.Paciente;
import lombok.Getter;
import lombok.Setter;
import org.apache.isis.applib.fixturescripts.FixtureScript;

public class DatosFamiliaresCreate extends FixtureScript {

    @Getter @Setter
    private String nombreCompletoFamiliar;

    @Getter @Setter
    private Paciente paciente;

    @Getter @Setter
    private String parentesco;

    @Getter @Setter
    private String numeroContacto;

    @Getter @Setter
    private String mailFamiliar;

    @Getter @Setter
    private DatosFamiliares datosFamiliaresObject;

    @Override
    protected void execute(final ExecutionContext ec) {

        String nombreCompletoFamiliar = checkParam("nombreCompletoFamiliar", ec, String.class);
        String parentesco = checkParam("parentesco", ec, String.class);
        String numeroContacto = checkParam("numeroContacto", ec, String.class);
        String mailFamiliar = checkParam("mailFamiliar", ec, String.class);


        this.datosFamiliaresObject = wrap(menu).create(nombreCompletoFamiliar,paciente,parentesco,numeroContacto,mailFamiliar);

        // also make available to UI
        ec.addResult(this, datosFamiliaresObject);
    }

    @javax.inject.Inject
    DatosFamiliaresMenu menu;
}
