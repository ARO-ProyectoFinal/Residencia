package domainapp.application.fixture.scenarios;

import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.joda.time.LocalDate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HistoriaRecreate extends FixtureScript {

    public final List<String> VacuRecibida = Collections.unmodifiableList(Arrays.asList("Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada"));
    public final List<String> VacuFaltante = Collections.unmodifiableList(Arrays.asList("Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada"));
    public final List<String> EnfePadecida = Collections.unmodifiableList(Arrays.asList("Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada"));
    public final List<String> AlerPadecida = Collections.unmodifiableList(Arrays.asList("Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada"));
    public final List<LocalDate> UltimaVisitaMedica = Collections.unmodifiableList(Arrays.asList(LocalDate.parse("12/12/2020"),LocalDate.parse("12/12/2015"),LocalDate.parse("12/12/2016"),LocalDate.parse("12/12/2017"),LocalDate.parse("12/12/2018"),LocalDate.parse("12/12/2019")));
    public final List<String> LapsoIngesta = Collections.unmodifiableList(Arrays.asList("Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada"));
    public final List<Integer> StockMedicacion = Collections.unmodifiableList(Arrays.asList(22,33,44,55,66,77));
    public final List<String> MedicacionAnterior = Collections.unmodifiableList(Arrays.asList("Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada"));

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
