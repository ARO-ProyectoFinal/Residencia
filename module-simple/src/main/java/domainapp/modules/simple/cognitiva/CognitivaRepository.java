package domainapp.modules.simple.cognitiva;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.isis.applib.services.repository.RepositoryService;

import java.util.List;

@DomainService(
        nature = NatureOfService.DOMAIN,
        repositoryFor = Cognitiva.class)

public class CognitivaRepository {

    @Programmatic
    public List<Cognitiva> Listar() {
        return repositoryService.allMatches(
                new QueryDefault<>(
                        Cognitiva.class,
                        "find"));


    }

    @Programmatic
    public Cognitiva create(
            final String comerSolo,
            final String bañoSolo,
            final String vestirSolo,
            final String bañarseSolo,
            final String moverSolo
    ) {

        final Cognitiva cognitiva = new Cognitiva(comerSolo, bañoSolo, vestirSolo, bañarseSolo, moverSolo);
        repositoryService.persist(cognitiva);
        return cognitiva;
    }

    @javax.inject.Inject
    RepositoryService repositoryService;
}

