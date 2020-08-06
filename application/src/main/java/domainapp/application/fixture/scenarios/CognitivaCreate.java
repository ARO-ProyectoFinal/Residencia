package domainapp.application.fixture.scenarios;

import domainapp.modules.simple.cognitiva.CognitivaMenu;
import domainapp.modules.simple.historia.Selector;
import domainapp.modules.simple.paciente.PacienteMenu;
import lombok.Getter;
import lombok.Setter;
import org.apache.isis.applib.fixturescripts.FixtureScript;


public class CognitivaCreate extends FixtureScript {

    @Getter
    @Setter
    private Selector comerSolo;

    @Getter @Setter
    private Selector bañoSolo;

    @Getter @Setter
    private Selector vestirSolo;

    @Getter @Setter
    private Selector bañarseSolo;

    @Getter @Setter
    private Selector moverSolo;

    @Override
    protected void execute(final ExecutionContext ec) {


        Selector comerSolo = checkParam("comerSolo", ec, Selector.class);
        Selector bañoSolo = checkParam("bañoSolo", ec, Selector.class);
        Selector vestirSolo = checkParam("vestirSolo", ec, Selector.class);
        Selector bañarseSolo = checkParam("bañarseSolo", ec, Selector.class);
        Selector moverSolo = checkParam("moverSolo", ec, Selector.class);

        this.cognitivaObject = wrap(menu).create(comerSolo,bañoSolo,vestirSolo,bañarseSolo,moverSolo);

        // also make available to UI
        ec.addResult(this, cognitivaObject);
    }

    @javax.inject.Inject
    CognitivaMenu menu;
}
