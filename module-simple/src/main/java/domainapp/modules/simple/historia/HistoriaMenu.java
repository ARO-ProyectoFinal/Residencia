package domainapp.modules.simple.historia;

import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;
import org.joda.time.LocalDate;

import java.util.List;
@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        objectType = "HistoriaClinica",
        repositoryFor = Historia.class
)
@DomainServiceLayout(
        named = "HistoriaClinica",
        menuOrder = ""
)

public class HistoriaMenu {

    @Action()
    @ActionLayout(named = "Crear Historia Clinica")
    @MemberOrder(sequence = "1")
    public Historia create(

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Vacunas Recibidas")
            final  String vacuRecibida,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Vacunas Faltantes")
            final String vacuFaltante,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Enfermedades Padecidas")
            final String enfePadecida,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Alergias")
            final  String alerPadecida,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Ultima Visita Medica")
            final LocalDate ultimaVisitaMedica,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Tipo de Medicacion")
            final  String tipoMedicacion,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Lapso de Ingesta")
            final String lapsoIngesta,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Stock Medicacion")
            final  Integer stockMedicacion,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Medicacion Anterior")
            final String medicacionAnterior)

    {
        return historiaRepository.create(vacuRecibida,vacuFaltante,enfePadecida,alerPadecida,ultimaVisitaMedica,tipoMedicacion,lapsoIngesta,stockMedicacion,medicacionAnterior);
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "3")
    public List<Historia> listAll() {
        List <Historia> historias =  historiaRepository.Listar();
        return historias;

    }

    @javax.inject.Inject
    IsisJdoSupport isisJdoSupport;

    @javax.inject.Inject
    HistoriaRepository historiaRepository;
}
