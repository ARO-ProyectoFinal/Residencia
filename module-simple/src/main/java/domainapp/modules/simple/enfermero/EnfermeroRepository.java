package domainapp.modules.simple.enfermero;

import domainapp.modules.simple.datosFamiliares.DatosFamiliares;
import domainapp.modules.simple.paciente.TipoDocumento;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.isis.applib.services.repository.RepositoryService;

import org.joda.time.LocalDate;
import java.util.List;

@DomainService(
        nature = NatureOfService.DOMAIN,
        repositoryFor = Enfermero.class)

public class EnfermeroRepository {

    @Programmatic
    public List<Enfermero> Listar() {
        return repositoryService.allMatches(
                new QueryDefault<>(
                        Enfermero.class,
                        "find"));
    }

    @Programmatic
    public Enfermero buscarEnfermero(final String nombre){

        return repositoryService.uniqueMatch(
                new QueryDefault<>(
                        Enfermero.class,
                        "buscarEnfermero",
                        "nombre", nombre));
    }


    @Programmatic
    public Enfermero create (

            final String nombre,
            final String apellido,
            final LocalDate fechaAlta,
            final TipoDocumento tipoDocumento,
            final String nroDocumento,
            final LocalDate fechaNacimiento,
            final String lugarNacimiento,
            final String telefono,
            final String edad,
            final String nroMatricula

    ) {

        final Enfermero enfermero = new Enfermero(nombre,apellido,fechaAlta,tipoDocumento,nroDocumento,fechaNacimiento,lugarNacimiento,edad,telefono,nroMatricula);
        repositoryService.persist(enfermero);
        return enfermero;
    }

    @javax.inject.Inject
    RepositoryService repositoryService;
}
