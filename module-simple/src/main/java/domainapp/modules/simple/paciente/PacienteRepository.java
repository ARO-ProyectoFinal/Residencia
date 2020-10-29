package domainapp.modules.simple.paciente;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.joda.time.LocalDate;

import java.util.List;


@DomainService(
        nature = NatureOfService.DOMAIN,
        repositoryFor = Paciente.class)

public class PacienteRepository {

    @Programmatic
    public List<Paciente> Listar() {

        return repositoryService.allMatches(
                new QueryDefault<>(
                        Paciente.class,
                        "find"));
    }

    @Programmatic
    public List<Paciente> Listar(final EstadoPaciente estado) {

        return repositoryService.allMatches(
                new QueryDefault<>(
                        Paciente.class,
                        "findByEstado",
                        "estado", estado));
    }

    @Programmatic
    public Paciente create(
            final String name,
            final String apellido,
            final LocalDate fechaAlta,
            final Integer edad,
            final TipoDocumento tipoDocumento,
            final String nroDocumento,
            final LocalDate fechaNacimiento,
            final String lugarDeNacimiento,
            final String telefono,
            final String nroSeguroSocial,
            final String incapacidad,
            final String observacion
    ) {

        final Paciente paciente = new Paciente(name, apellido,fechaAlta,edad,tipoDocumento,nroDocumento,fechaNacimiento,lugarDeNacimiento,telefono,nroSeguroSocial,incapacidad,observacion);
        repositoryService.persist(paciente);
        return paciente;
    }

    @javax.inject.Inject
    RepositoryService repositoryService;
}
