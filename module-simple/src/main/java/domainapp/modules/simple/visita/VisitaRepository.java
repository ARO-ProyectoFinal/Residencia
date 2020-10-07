package domainapp.modules.simple.visita;

import domainapp.modules.simple.datosFamiliares.DatosFamiliares;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.isis.applib.services.repository.RepositoryService;


import java.util.List;

@DomainService(
        nature = NatureOfService.DOMAIN,
        repositoryFor = Visita.class)

public class VisitaRepository {

    @Programmatic
    public List<Visita> Listar() {

        return repositoryService.allMatches(
                new QueryDefault<>(
                        Visita.class,
                        "find"));
    }

    @Programmatic
    public Visita buscarVisita(final String altura){

        return repositoryService.uniqueMatch(
                new QueryDefault<>(
                        Visita.class,
                        "buscarVisita",
                        "altura", altura));
    }

    @Programmatic
    public Visita create(
            final String altura,
            final String peso,
            final String temperatura,
            final String presionArterial,
            final String frecuenciaCardiaca,
            final String frecunciaRespiratoria,
            final String estudiosLaboratorio,
            final String observacion

    ) {
        final Visita visita = new Visita(altura,peso,temperatura,presionArterial,frecuenciaCardiaca,frecunciaRespiratoria,estudiosLaboratorio,observacion);
        repositoryService.persist(visita);
        return visita;
    }
    @javax.inject.Inject
    RepositoryService repositoryService;
}
