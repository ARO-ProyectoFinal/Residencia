package domainapp.modules.simple.visita;



import domainapp.modules.simple.enfermero.Enfermero;
import org.apache.isis.applib.annotation.*;

import java.util.List;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        objectType = "DatosVisitaMedica",
        repositoryFor = Visita.class
)
@DomainServiceLayout(
        named = "DatosVisitaMedica",
        menuOrder = ""
)

public class VisitaMenu {

    @Action()
    @ActionLayout(named = "Crear Visita Medica")
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
            @ParameterLayout(named = "Frecuencia Cardiaca")
            final Integer frecuenciaCardiaca,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Frecuencia Respiratoria")
            final Integer frecuenciaRespiratoria,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Estudios Laboratorio")
            final String estudiosLaboratorio,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Observacion")
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
