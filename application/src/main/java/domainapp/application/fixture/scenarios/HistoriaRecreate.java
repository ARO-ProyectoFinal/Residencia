package domainapp.application.fixture.scenarios;

import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.joda.time.LocalDate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HistoriaRecreate extends FixtureScript {

    public final List<String> VacuRecibida = Collections.unmodifiableList(Arrays.asList("Libreta Completo", "Faltantes", "Libreta Completo", "Libreta Completo", "Faltantes", "Libreta Completo"));
    public final List<String> VacuFaltante = Collections.unmodifiableList(Arrays.asList("Ninguna", "Tdap", "Ninguna", "Ninguna", "Hep B", "Ninguna"));
    public final List<String> EnfePadecida = Collections.unmodifiableList(Arrays.asList("Ninguna", "Ninguna", "Ninguna", "Ninguna", "Ninguna", "Ninguna"));
    public final List<String> AlerPadecida = Collections.unmodifiableList(Arrays.asList("Ninguna", "Ninguna", "Ninguna", "Ninguna", "Ninguna", "Ninguna"));
    public final List<LocalDate> UltimaVisitaMedica = Collections.unmodifiableList(Arrays.asList(LocalDate.parse("05/08/2020"),LocalDate.parse("05/08/2020"),LocalDate.parse("05/08/2020"),LocalDate.parse("05/08/2020"),LocalDate.parse("05/08/2020"),LocalDate.parse("05/08/2020")));
    public final List<String> LapsoIngesta = Collections.unmodifiableList(Arrays.asList("Diario", "Cada dos dias", "Diario", "Diario", "Cada dos dias", "Diario"));
    public final List<Integer> StockMedicacion = Collections.unmodifiableList(Arrays.asList(20,21,20,15,13,12));
    public final List<String> MedicacionAnterior = Collections.unmodifiableList(Arrays.asList("Hidroxicloroquina", "Hidroxicloroquina", "Paracetamol", "Hidroxicloroquina", "Diclofenac", "Omeprazol"));

    public HistoriaRecreate() {
        withDiscoverability(Discoverability.DISCOVERABLE);
    }

    @Override
    protected void execute(final ExecutionContext ec) {

        for (int i = 0; i < VacuRecibida.size(); i++) {
            final HistoriaCreate fs = new HistoriaCreate();
            fs.setVacuRecibida(VacuRecibida.get(i));
            fs.setVacuFaltante(VacuFaltante.get(i));
            fs.setEnfePadecida(EnfePadecida.get(i));
            fs.setAlerPadecida(AlerPadecida.get(i));
            fs.setUltimaVisitaMedica(UltimaVisitaMedica.get(i));
            fs.setLapsoIngesta(LapsoIngesta.get(i));
            fs.setStockMedicacion(StockMedicacion.get(i));
            fs.setMedicacionAnterior(MedicacionAnterior.get(i));


            ec.executeChild(this, fs.getVacuRecibida(), fs);
        }
    }
}
