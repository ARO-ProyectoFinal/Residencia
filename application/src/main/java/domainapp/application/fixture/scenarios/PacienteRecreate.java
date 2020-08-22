package domainapp.application.fixture.scenarios;


import org.apache.isis.applib.fixturescripts.FixtureScript;

import org.joda.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PacienteRecreate extends FixtureScript {

    public final List<LocalDate> FachaAlta = Collections.unmodifiableList(Arrays.asList(LocalDate.parse("12/12/2020"),LocalDate.parse("12/12/2015"),LocalDate.parse("12/12/2016"),LocalDate.parse("12/12/2017"),LocalDate.parse("12/12/2018"),LocalDate.parse("12/12/2019")));
    public final List<String> Name = Collections.unmodifiableList(Arrays.asList("Alejando", "Maximiliano", "Maria", "Julia", "Ignacio", "Nicolas"));
    public final List<String> Apellido = Collections.unmodifiableList(Arrays.asList("Roncero", "Ortiz", "Ranquileo", "Assanelli", "Molina", "Barros"));
    public final List<Integer> Edad = Collections.unmodifiableList(Arrays.asList(65,82,81,76,91,86));
    public final List<String> NroDocumento = Collections.unmodifiableList(Arrays.asList("12546325", "10478541", "9751485", "14023147", "8214356", "6789456"));
    public final List<LocalDate> FechaNacimiento = Collections.unmodifiableList(Arrays.asList(LocalDate.parse("12/12/1951"),LocalDate.parse("12/12/1942"),LocalDate.parse("12/12/1954"),LocalDate.parse("12/12/1940"),LocalDate.parse("12/12/1928"),LocalDate.parse("12/12/1945")));
    public final List<String> LugarDeNacimiento = Collections.unmodifiableList(Arrays.asList("Neuquen", "Zapala", "Piedra del Aguila", "Chocon", "Picun Leufu", "Plaza Huincul"));
    public final List<String> Telefono = Collections.unmodifiableList(Arrays.asList("2994758691","2997415352","2999865321","2994761342","2997410256","2993697012"));
    public final List<String> NumeroDeSeguroSocial = Collections.unmodifiableList(Arrays.asList("12547862145", "65478512301", "47512359684", "75482153012", "10247859621", "21024578965"));
    public final List<String> Incapacidad = Collections.unmodifiableList(Arrays.asList("Ninguna", "Ninguna", "Dificultad para Caminar", "Dificultad para Bañarse", "Ninguna", "Ninguna"));
    public final List<String> Observacion = Collections.unmodifiableList(Arrays.asList("Ninguna", "Ninguna", "Ninguna", "Ninguna", "Ninguna", "Ninguna"));


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
           // fs.setTelefono(Telefono.get(i));
            fs.setNumeroDeSeguroSocial(NumeroDeSeguroSocial.get(i));
            fs.setIncapacidad(Incapacidad.get(i));
            fs.setObservacion(Observacion.get(i));

            ec.executeChild(this, fs.getName(), fs);
        }
    }
}
