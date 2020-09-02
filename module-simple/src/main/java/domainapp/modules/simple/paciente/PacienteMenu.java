package domainapp.modules.simple.paciente;

import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;
import org.datanucleus.query.typesafe.TypesafeQuery;
import org.joda.time.LocalDate;

import java.util.List;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        objectType = "Paciente",
        repositoryFor = Paciente.class
)
@DomainServiceLayout(
        named = "Paciente",
        menuOrder = ""
)

public class PacienteMenu {

    @Action()
    @ActionLayout(named = "Crear Paciente")
    @MemberOrder(sequence = "1")
    public Paciente create(
            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Nombre")
            final String name,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Apellido")
            final  String apellido,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Fecha de alta")
            final LocalDate fechaAlta,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Edad")
            final Integer edad,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Tipo Documento")
            final TipoDocumento tipoDocumento,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Numero de documento")
            final String nroDocumento,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Fecha de nacimiento ")
            final  LocalDate fechaNacimiento,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Lugar de nacimiento ")
            final  String lugarDeNacimiento,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Telefono ")
            final String telefono,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Numero de Seguro Social ")
            final  String numeroDeSeguroSocial,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Incapacidad ")
            final String incapacidad,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Observacion ")
            final  String observacion)


    {
        return pacienteRepository.create (name, apellido,fechaAlta,edad,tipoDocumento,nroDocumento,fechaNacimiento,lugarDeNacimiento,telefono,numeroDeSeguroSocial,incapacidad,observacion);
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Buscar Paciente")
    @MemberOrder(sequence = "2")
    public Paciente findByNameExact(final String name) {
        TypesafeQuery<Paciente> q = isisJdoSupport.newTypesafeQuery(Paciente.class);
        final QPaciente cand = QPaciente.candidate();
        q = q.filter(
                cand.name.eq(q.stringParameter("name"))
        );
        return q.setParameter("name", name)
                .executeUnique();
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Listado de Pacientes")
    @MemberOrder(sequence = "3")
    public List<Paciente> listAll() {
        List <Paciente> pacientes =  pacienteRepository.Listar();
        return pacientes;

    }

    @javax.inject.Inject
    IsisJdoSupport isisJdoSupport;

    @javax.inject.Inject
    PacienteRepository pacienteRepository;
}
