package domainapp.modules.simple.historia;


import domainapp.modules.simple.datosFamiliares.DatosFamiliares;
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
    public Historia buscarHistoria(final String vacuRecibida){

        return repositoryService.uniqueMatch(
                new QueryDefault<>(
                        Historia.class,
                        "buscarHistoria",
                        "vacuRecibida", vacuRecibida));
    }

    @Programmatic
    public Historia create(
            final String vacuRecibida,
            final String vacuFaltante,
            final String enfePadecida,
            final String alerPadecida,
            final LocalDate ultimaVisitaMedica,
            final String tipoMedicacion,
            final String lapsoIngesta,
            final Integer stockMedicacion,
            final String medicacionAnterior

    ) {

        final Historia historia = new Historia(vacuRecibida,vacuFaltante,enfePadecida,alerPadecida,ultimaVisitaMedica,tipoMedicacion,lapsoIngesta,stockMedicacion,medicacionAnterior);
        repositoryService.persist(historia);
        return historia;
    }

    @javax.inject.Inject
    RepositoryService repositoryService;

}
