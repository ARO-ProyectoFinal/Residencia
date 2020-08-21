package domainapp.application.fixture.scenarios;


import org.apache.isis.applib.fixturescripts.FixtureScript;

import org.joda.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PacienteRecreate extends FixtureScript {

    public final List<LocalDate> FachaAlta = Collections.unmodifiableList(Arrays.asList(LocalDate.parse("12/12/2020"),LocalDate.parse("12/12/2015"),LocalDate.parse("12/12/2016"),LocalDate.parse("12/12/2017"),LocalDate.parse("12/12/2018"),LocalDate.parse("12/12/2019")));
    public final List<String> Name = Collections.unmodifiableList(Arrays.asList("Halliburton Argentina S.r.l.", "Schlumberger Neuquen", "Weatherford", "NABORS", "Meier & Fischer", "Ingeniería SIMA SA"));
    public final List<String> Apellido = Collections.unmodifiableList(Arrays.asList("San Fernando y Tinogasta, Neuquen", "Tte. Juan Solalique 412-440, Neuquén", "Juan José Lastra 5500, Neuquén", "Dr. Teodoro Luis Planas 4955, Neuquén", "Carlos Pellegrini 2560, Neuquén", "PIN Este - Manzana R Lote M1, Neuquén"));
    public final List<Integer> Edad = Collections.unmodifiableList(Arrays.asList(65,82,81,76,91,86));
    public final List<String> NroDocumento = Collections.unmodifiableList(Arrays.asList("Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada"));
    public final List<LocalDate> FechaNacimiento = Collections.unmodifiableList(Arrays.asList(LocalDate.parse("12/12/1951"),LocalDate.parse("12/12/1942"),LocalDate.parse("12/12/1954"),LocalDate.parse("12/12/1940"),LocalDate.parse("12/12/1928"),LocalDate.parse("12/12/1945")));
    public final List<String> LugarDeNacimiento = Collections.unmodifiableList(Arrays.asList("Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada"));
    public final List<Integer> Telefono = Collections.unmodifiableList(Arrays.asList(22,33,44,55,66,77));
    public final List<String> NumeroDeSeguroSocial = Collections.unmodifiableList(Arrays.asList("Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada"));
    public final List<String> Incapacidad = Collections.unmodifiableList(Arrays.asList("Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada"));
    public final List<String> Observacion = Collections.unmodifiableList(Arrays.asList("Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada", "Habilitada"));


    public PacienteRecreate() {
        withDiscoverability(Discoverability.DISCOVERABLE);
    }

    @Override
    protected void execute(final ExecutionContext ec) {

        for (int i = 0; i < Name.size(); i++) {
            final PacienteCreate fs = new PacienteCreate();
            fs.setFechaAlta(FachaAlta.get(i));
            fs.setName(Name.get(i));
            fs.setApellido(Apellido.get(i));
            fs.setEdad(Edad.get(i));
            fs.setNroDocumento(NroDocumento.get(i));
            fs.setFechaNacimiento(FechaNacimiento.get(i));
            fs.setLugarDeNacimiento(LugarDeNacimiento.get(i));
            fs.setTelefono(Telefono.get(i));
            fs.setNumeroDeSeguroSocial(NumeroDeSeguroSocial.get(i));
            fs.setIncapacidad(Incapacidad.get(i));
            fs.setObservacion(Observacion.get(i));

            ec.executeChild(this, fs.getName(), fs);
        }
    }
}
