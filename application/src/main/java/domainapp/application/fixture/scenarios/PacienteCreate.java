package domainapp.application.fixture.scenarios;

import domainapp.modules.simple.paciente.HabitacionSeleccionada;
import domainapp.modules.simple.paciente.Paciente;
import domainapp.modules.simple.paciente.PacienteMenu;
import domainapp.modules.simple.paciente.TipoDocumento;
import lombok.Getter;
import lombok.Setter;
import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.joda.time.LocalDate;

public class PacienteCreate extends FixtureScript {

    @Getter @Setter
    private LocalDate fechaAlta;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String apellido;

    @Getter @Setter
    private Integer edad;

    @Getter @Setter
    private TipoDocumento tipoDocumento;

    @Getter @Setter
    private String nroDocumento;

    @Getter @Setter
    private LocalDate fechaNacimiento;

    @Getter @Setter
    private String lugarDeNacimiento;

    @Getter @Setter
    private Integer telefono;

    @Getter @Setter
    private String numeroDeSeguroSocial;

    @Getter @Setter
    private String incapacidad;

    @Getter @Setter
    private String observacion;

    @Getter @Setter
    private String nombreFamiliar;

    @Getter @Setter
    private String apellidoFamiliar;

    @Getter @Setter
    private String parentesco;

    @Getter @Setter
    private String numeroContacto;

    @Getter @Setter
    private String mailFamiliar;

    @Getter @Setter
    private String direccionFamiliar;

    @Getter @Setter
    private HabitacionSeleccionada habitacionSeleccionada;

    @Getter @Setter
    private Paciente pacienteObject;

    @Override
    protected void execute(final ExecutionContext ec) {

        LocalDate fechaAlta = checkParam("fechaAlta", ec, LocalDate.class);
        String name = checkParam("name", ec, String.class);
        String apellido = checkParam("apellido", ec, String.class);
        Integer edad = checkParam("edad", ec, Integer.class);
        TipoDocumento tipoDocumento = checkParam("tipoDocumento", ec, TipoDocumento.class);
        String nroDocumento = checkParam("nroDocumento", ec, String.class);
        LocalDate fechaNacimiento = checkParam("fechaNacimiento", ec, LocalDate.class);
        String lugarDeNacimiento = checkParam("lugarDeNacimiento", ec, String.class);
        Integer telefono = checkParam("telefono", ec, Integer.class);
        String numeroDeSeguroSocial = checkParam("numeroDeSeguroSocial", ec, String.class);
        String incapacidad = checkParam("incapacidad", ec, String.class);
        String observacion = checkParam("observacion", ec, String.class);
        String nombreFamiliar = checkParam("nombreFamiliar", ec, String.class);
        String apellidoFamiliar = checkParam("apellidoFamiliar", ec, String.class);
        String parentesco = checkParam("parentesco", ec, String.class);
        String numeroContacto = checkParam("numeroContacto", ec, String.class);
        String mailFamiliar = checkParam("mailFamiliar", ec, String.class);
        String direccionFamiliar = checkParam("direccionFamiliar", ec, String.class);
        HabitacionSeleccionada habitacionSeleccionada = checkParam("habitacionSeleccionada", ec, HabitacionSeleccionada.class);

        this.pacienteObject = wrap(menu).create(name,apellido,fechaAlta,edad,tipoDocumento,nroDocumento,fechaNacimiento,lugarDeNacimiento,telefono,numeroDeSeguroSocial,incapacidad,observacion,nombreFamiliar,apellidoFamiliar,parentesco,numeroContacto,mailFamiliar,direccionFamiliar,habitacionSeleccionada);

        // also make available to UI
        ec.addResult(this, pacienteObject);
    }

    @javax.inject.Inject
    PacienteMenu menu;

}
