package domainapp.modules.simple.historia;


import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.joda.time.LocalDate;

import java.util.List;

@DomainService(
        nature = NatureOfService.DOMAIN,
        repositoryFor = Historia.class)

public class HistoriaRepository {

    @Programmatic
    public List<Historia> Listar() {

        return repositoryService.allMatches(
                new QueryDefault<>(
                        Historia.class,
                        "find"));
    }

    @Programmatic
    public Historia create(
            final Selector vacunaRecibida,
            final String vacuRecibida,
            final Selector vacunaFaltante,
            final String vacuFaltante,
            final Selector enfermedadPadecida,
            final String enfePadecida,
            final Selector alergias,
            final String alerPadecida,
            final LocalDate ultimaVisitaMedica,
            final String tipoMedicacion,
            final String lapsoIngesta,
            final Integer stockMedicacion,
            final String medicacionAnterior

    ) {

        final Historia historia = new Historia(vacunaRecibida,vacuRecibida,vacunaFaltante,vacuFaltante,enfermedadPadecida,enfePadecida,alergias,alerPadecida,ultimaVisitaMedica,tipoMedicacion,lapsoIngesta,stockMedicacion,medicacionAnterior);
        repositoryService.persist(historia);
        return historia;
    }

    @javax.inject.Inject
    RepositoryService repositoryService;

}
