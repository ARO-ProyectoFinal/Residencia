package domainapp.modules.simple.planillaEnfermeros;

import domainapp.modules.simple.enfermero.Enfermero;
import domainapp.modules.simple.paciente.Paciente;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.joda.time.LocalDate;

import java.util.List;

@DomainService(
        nature = NatureOfService.DOMAIN,
        repositoryFor = PlanillaEnfermero.class)

public class PlanillaEnfermeroRepository {

    @Programmatic
    public List<PlanillaEnfermero> Listar() {

        return repositoryService.allMatches(
                new QueryDefault<>(
                        PlanillaEnfermero.class,
                        "find"));
    }

    @Programmatic
    public PlanillaEnfermero buscarPlanillaEnfermero(final Paciente paciente){

        return repositoryService.uniqueMatch(
                new QueryDefault<>(
                        PlanillaEnfermero.class,
                        "buscarPlanillaEnfermero",
                        "paciente", paciente));
    }

    @Programmatic
    public PlanillaEnfermero create(

            final int idPlanillaEnfermeros,
            final Paciente paciente,
            final Enfermero enfermero,
            final LocalDate fechaPlanilla,
            final Turnos turno,
            final Estado medicacion,
            final Estado curaciones,
            final Estado actividadFisica,
            final Comidas comidas,
            final Estado ropa,
            final Estado limpieza,
            final String observacion

    ) {
        final PlanillaEnfermero planillaEnfermero = new PlanillaEnfermero(idPlanillaEnfermeros, paciente, enfermero, fechaPlanilla, turno, medicacion, curaciones, actividadFisica, comidas, ropa, limpieza,observacion);
        repositoryService.persist(planillaEnfermero);
        return planillaEnfermero;
    }
    @javax.inject.Inject
    RepositoryService repositoryService;
}
