package domainapp.application.fixture.scenarios;

import domainapp.modules.simple.visita.Visita;
import org.apache.isis.applib.fixturescripts.FixtureScript;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VisitaRecreate extends FixtureScript {

    public final List<String> Altura = Collections.unmodifiableList(Arrays.asList("Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada"));
    public final List<Integer> Peso = Collections.unmodifiableList(Arrays.asList(65,82,81,76,91,86));
    public final List<Integer> Temperatura = Collections.unmodifiableList(Arrays.asList(65,82,81,76,91,86));
    public final List<Integer> PresionArterial = Collections.unmodifiableList(Arrays.asList(65,82,81,76,91,86));
    public final List<Integer> FrecuenciaCardiaca = Collections.unmodifiableList(Arrays.asList(65,82,81,76,91,86));
    public final List<Integer> FrecuenciaRespiratoria = Collections.unmodifiableList(Arrays.asList(65,82,81,76,91,86));
    public final List<String> EstudiosLaboratorio = Collections.unmodifiableList(Arrays.asList("Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada"));
    public final List<String> Observacion = Collections.unmodifiableList(Arrays.asList("Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada"));
    public final List<Visita> VisitaObject = Collections.unmodifiableList(Arrays.asList("Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada"));

    public VisitaRecreate() {
        withDiscoverability(Discoverability.DISCOVERABLE);
    }

    @Override
    protected void execute(final ExecutionContext ec) {

        for (int i = 0; i < Altura.size(); i++) {
            final VisitaCreate fs = new VisitaCreate();
            fs.setAltura(Altura.get(i));
            fs.setPeso(Peso.get(i));
            fs.setTemperatura(Temperatura.get(i));
            fs.setPresionArterial(PresionArterial.get(i));
            fs.setFrecuenciaCardiaca(FrecuenciaCardiaca.get(i));
            fs.setFrecuenciaRespiratoria(FrecuenciaRespiratoria.get(i));
            fs.setEstudiosLaboratorio(EstudiosLaboratorio.get(i));
            fs.setObservacion(Observacion.get(i));
            fs.setVisitaObject(VisitaObject.get(i));

            ec.executeChild(this, fs.getAltura(), fs);
        }
    }
}


