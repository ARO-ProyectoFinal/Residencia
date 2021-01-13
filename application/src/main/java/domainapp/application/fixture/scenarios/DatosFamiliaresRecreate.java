package domainapp.application.fixture.scenarios;

import domainapp.modules.simple.datosFamiliares.DatosFamiliares;
import org.apache.isis.applib.fixturescripts.FixtureScript;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DatosFamiliaresRecreate extends FixtureScript {

    public final List<String> NombreCompletoFamiliar = Collections.unmodifiableList(Arrays.asList("Carlos", "Marcos", "Andrea", "Luz", "Roberto", "Patricio"));
    public final List<String> Parentesco = Collections.unmodifiableList(Arrays.asList("Hermano", "Hermano", "Hija", "Hermana", "Hermano", "Hijo"));
    public final List<String> NumeroContacto = Collections.unmodifiableList(Arrays.asList("2994578632", "2993515759", "2991475852", "2993102456", "2993120123", "2999874102"));
    public final List<String> MailFamiliar = Collections.unmodifiableList(Arrays.asList("carlos@gmail.com", "marcos@gmail.com", "andrea@gmail.com", "luz@gmail.com", "roberto@gmail.com", "patricio@gmail.com"));

    public DatosFamiliaresRecreate() {
        withDiscoverability(Discoverability.DISCOVERABLE);
    }

    @Override
    protected void execute(final ExecutionContext ec) {

        for (int i = 0; i < NombreCompletoFamiliar.size(); i++) {
            final DatosFamiliaresCreate fs = new DatosFamiliaresCreate();
            fs.setNombreCompletoFamiliar(NombreCompletoFamiliar.get(i));
            fs.setParentesco(Parentesco.get(i));
            fs.setNumeroContacto(NumeroContacto.get(i));
            fs.setMailFamiliar(MailFamiliar.get(i));

            ec.executeChild(this, fs.getNombreCompletoFamiliar(), fs);
        }
    }
}
