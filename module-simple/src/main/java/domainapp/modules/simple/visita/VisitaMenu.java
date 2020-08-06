package domainapp.modules.simple.visita;



import org.apache.isis.applib.annotation.*;

import java.util.List;

public class VisitaMenu {

    @Action()
    @ActionLayout(named = "Crear Visita medica")
    @MemberOrder(sequence = "1")
    public Visita create(
            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Altura")
            final String altura,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Peso")
            final Integer peso,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Temperatura")
            final Integer temperatura,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Presion Arterial")
            final Integer presionArterial,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Frecuencia Cardiaac")
            final Integer frecuenciaCardiaca,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Cuales?")
            final Integer frecuenciaRespiratoria,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Cuales?")
            final String estudiosLaboratorio,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Cuales?")
            final String observacion)
    {
        return visitaRepository.create(altura, peso, temperatura, presionArterial, frecuenciaCardiaca, frecuenciaRespiratoria, estudiosLaboratorio, observacion);
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "3")
    public List<Visita> listAll() {
        List <Visita> visitas =  visitaRepository.Listar();
        return visitas;

    }

    @javax.inject.Inject
    VisitaRepository visitaRepository;
}
