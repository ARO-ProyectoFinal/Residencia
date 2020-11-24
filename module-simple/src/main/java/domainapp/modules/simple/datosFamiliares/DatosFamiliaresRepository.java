package domainapp.modules.simple.datosFamiliares;

import domainapp.modules.simple.paciente.Paciente;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.isis.applib.services.repository.RepositoryService;


import java.util.List;


@DomainService(
        nature = NatureOfService.DOMAIN,
        repositoryFor = DatosFamiliares.class)



public class DatosFamiliaresRepository {


    @Programmatic
    public List<DatosFamiliares> Listar() {

        return repositoryService.allMatches(
                new QueryDefault<>(
                        DatosFamiliares.class,
                        "find"));
    }
    @Programmatic
    public  DatosFamiliares buscaFamiliar(final String nombreCompletoFamiliar){

        return repositoryService.uniqueMatch(
                new QueryDefault<>(
                        DatosFamiliares.class,
                        "buscaFamiliar",
                        "nombreCompletoFamiliar", nombreCompletoFamiliar));
    }


    @Programmatic
    public DatosFamiliares create(

            final String nombreCompletoFamiliar,
            final Paciente paciente,
            final String parentesco,
            final String numeroContacto,
            final String mailFamiliar
    ) {

        final DatosFamiliares datosFamiliares = new DatosFamiliares(nombreCompletoFamiliar,paciente,parentesco,numeroContacto,mailFamiliar);
        repositoryService.persist(datosFamiliares);
        return datosFamiliares;
    }

    @javax.inject.Inject
    RepositoryService repositoryService;
}

