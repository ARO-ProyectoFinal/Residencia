package domainapp.application.fixture.scenarios;

import org.apache.isis.applib.fixturescripts.FixtureScript;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CognitivaRecreate extends FixtureScript {

    public final List<Selector> comerSolo = Collections.unmodifiableList(Arrays.asList());
    public final List<Selector> bañoSolo = Collections.unmodifiableList(Arrays.asList());
    public final List<Selector> vestirSolo = Collections.unmodifiableList(Arrays.asList());
    public final List<Selector> bañarseSolo = Collections.unmodifiableList(Arrays.asList());
    public final List<Selector> moverSolo = Collections.unmodifiableList(Arrays.asList());

    public CognitivaRecreate() {
        withDiscoverability(Discoverability.DISCOVERABLE);
    }

    @Override
    protected void execute(final ExecutionContext ec) {

        for (int i = 0; i < ComerSolo.size(); i++) {
            final CognitivaCreate fs = new CognitivaCreate();
            fs.setComerSolo(ComerSolo.get(i));
            fs.setBañoSolo(BañoSolo.get(i));
            fs.setVestirSolo(VestirSolo.get(i));
            fs.setBañarseSolo(BañarseSolo.get(i));
            fs.setMoverSolo(MoverSolo.get(i));


            ec.executeChild(this, fs.getComerSolo(), fs);
        }
    }
}
