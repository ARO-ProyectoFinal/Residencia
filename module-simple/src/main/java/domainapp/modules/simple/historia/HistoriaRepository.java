package domainapp.modules.simple.historia;



import domainapp.modules.simple.paciente.Paciente;
import domainapp.modules.simple.planillaEnfermeros.Estado;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.isis.applib.services.repository.RepositoryService;

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

            final Paciente paciente,
            final Estado hipertensionArterial,
            final Estado diabetes,
            final Estado enfCardiovascular,
            final Estado marcapasos,
            final Estado discopatias,
            final Estado perdidaDeConocimiento,
            final Estado artritis,
            final Estado artrosis,
            final Estado lumbago,
            final Estado neurosis,
            final Estado traumatismos,
            final Estado problemasOtologicos,
            final String comentarios

    ) {

        final Historia historia = new Historia(paciente, hipertensionArterial,diabetes,enfCardiovascular,marcapasos,discopatias,perdidaDeConocimiento,artritis,artrosis,lumbago,neurosis,traumatismos,problemasOtologicos,comentarios);
        repositoryService.persist(historia);
        return historia;
    }

    @javax.inject.Inject
    RepositoryService repositoryService;

}
