package domainapp.application.fixture.scenarios;

import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.joda.time.LocalDate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EnfermeroRecreate extends FixtureScript {


    public final List<String> Nombre = Collections.unmodifiableList(Arrays.asList("Ricardo", "Fernando", "Florencia", "Marcela", "Brenda", "Fusto"));
    public final List<String> Apellido = Collections.unmodifiableList(Arrays.asList("Aguero", "Walter", "Fontela", "Martinez", "Lopez", "Mora"));
    public final List<LocalDate> FachaAlta = Collections.unmodifiableList(Arrays.asList(LocalDate.parse("12/12/2010"),LocalDate.parse("12/12/2012"),LocalDate.parse("12/12/2013"),LocalDate.parse("12/12/2011"),LocalDate.parse("12/12/2018"),LocalDate.parse("12/12/2009")));
    public final List<String> NroDocumento = Collections.unmodifiableList(Arrays.asList("35546325", "33478541", "3651485", "39023147", "3214356", "3389456"));
    public final List<LocalDate> FechaNacimiento = Collections.unmodifiableList(Arrays.asList(LocalDate.parse("12/12/1982"),LocalDate.parse("12/12/1988"),LocalDate.parse("12/12/1990"),LocalDate.parse("12/12/1996"),LocalDate.parse("12/12/1997"),LocalDate.parse("12/12/1992")));
    public final List<String> LugarNacimiento = Collections.unmodifiableList(Arrays.asList("Neuquen", "Zapala", "Piedra del Aguila", "Chocon", "Picun Leufu", "Plaza Huincul"));
    public final List<String> Telefono = Collections.unmodifiableList(Arrays.asList("2994758612","2997415357","2999865456","2994761789","2997410253","2993697011"));
    public final List<String> Edad = Collections.unmodifiableList(Arrays.asList("25", "32", "30", "23", "33", "31"));
    public final List<String> NroMatricula = Collections.unmodifiableList(Arrays.asList("456789852", "123456741", "123456789", "741852963", "753612896", "369258147"));

    public EnfermeroRecreate() {
        withDiscoverability(Discoverability.DISCOVERABLE);
    }

    @Override
    protected void execute(final ExecutionContext ec) {

        for (int i = 0; i < Nombre.size(); i++) {
            final EnfermeroCreate fs = new EnfermeroCreate();

            fs.setNombre(Nombre.get(i));
            fs.setApellido(Apellido.get(i));
            fs.setFechaAlta(FachaAlta.get(i));
            fs.setNroDocumento(NroDocumento.get(i));
            fs.setFechaNacimiento(FechaNacimiento.get(i));
            fs.setLugarNacimiento(LugarNacimiento.get(i));
            fs.setTelefono(Telefono.get(i));
            fs.setEdad(Edad.get(i));
            fs.setNroMatricula(NroMatricula.get(i));

            ec.executeChild(this, fs.getNombre(), fs);
        }
    }
}
