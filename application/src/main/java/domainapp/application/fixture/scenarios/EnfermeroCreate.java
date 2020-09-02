package domainapp.application.fixture.scenarios;

import domainapp.modules.simple.enfermero.Enfermero;
import domainapp.modules.simple.enfermero.EnfermeroMenu;
import domainapp.modules.simple.paciente.TipoDocumento;
import lombok.Getter;
import lombok.Setter;
import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.joda.time.LocalDate;

public class EnfermeroCreate extends FixtureScript {

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String apellido;

    @Getter @Setter
    private LocalDate fechaAlta;

    @Getter @Setter
    private TipoDocumento tipoDocumento;

    @Getter @Setter
    private String nroDocumento;

    @Getter @Setter
    private LocalDate fechaNacimiento;

    @Getter @Setter
    private String lugarNacimiento;

    @Getter @Setter
    private String telefono;

    @Getter @Setter
    private String edad;

    @Getter @Setter
    private String nroMatricula;

    @Getter @Setter
    private Enfermero enfermeroObject;

    @Override
    protected void execute(final ExecutionContext ec) {


        String nombre = checkParam("nombre", ec, String.class);
        String apellido = checkParam("apellido", ec, String.class);
        LocalDate fechaAlta = checkParam("fechaAlta", ec, LocalDate.class);
        TipoDocumento tipoDocumento = checkParam("tipoDocumento", ec, TipoDocumento.class);
        String nroDocumento = checkParam("nroDocumento", ec, String.class);
        LocalDate fechaNacimiento = checkParam("fechaNacimiento", ec, LocalDate.class);
        String lugarNacimiento = checkParam("lugarNacimiento", ec, String.class);
        String telefono = checkParam("telefono", ec, String.class);
        String edad = checkParam("edad", ec, String.class);
        String nroMatricula = checkParam("nroMatricula", ec, String.class);

        this.enfermeroObject = wrap(menu).create(nombre,apellido,fechaAlta,tipoDocumento,nroDocumento,fechaNacimiento,lugarNacimiento,telefono,edad,nroMatricula);

        // also make available to UI
        ec.addResult(this, enfermeroObject);
    }

    @javax.inject.Inject
    EnfermeroMenu menu;
}
