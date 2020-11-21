package domainapp.application.fixture.scenarios;

import domainapp.modules.simple.visita.Visita;
import org.apache.isis.applib.fixturescripts.FixtureScript;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VisitaRecreate extends FixtureScript {

    public final List<String> Altura = Collections.unmodifiableList(Arrays.asList("1.65", "1.73", "1.75", "1.69", "1.89", "1.85"));
    public final List<String> Peso = Collections.unmodifiableList(Arrays.asList("65","82","81","76","91","86"));
    public final List<String> Temperatura = Collections.unmodifiableList(Arrays.asList("36","36","37","35","36","36"));
    public final List<String> PresionArterial = Collections.unmodifiableList(Arrays.asList("120/80","122/75","119/92","118/20","120/85","120/90"));
    public final List<String> FrecuenciaCardiaca = Collections.unmodifiableList(Arrays.asList("86","90","95","95","100","85"));
    public final List<String> FrecuenciaRespiratoria = Collections.unmodifiableList(Arrays.asList("20","22","23","18","19","20"));
    public final List<String> EstudiosLaboratorio = Collections.unmodifiableList(Arrays.asList("Entregados", "Entregados", "Entregados", "Debe", "Debe", "Entregados"));
    public final List<String> Observacion = Collections.unmodifiableList(Arrays.asList("Ninguna", "Ninguna", "Ningunaa", "Entregar Laboratorio", "Entregar Laboratorio", "Ninguna"));

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
            fs.setObservacion(Observacion.get(i));

            ec.executeChild(this, fs.getAltura(), fs);
        }
    }
}


