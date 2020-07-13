package domainapp.modules.simple.historia;

import domainapp.modules.simple.dom.impl.paciente.*;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;
import org.datanucleus.query.typesafe.TypesafeQuery;
import org.joda.time.LocalDate;

import java.util.List;

public class HistoriaMenu {

    @Action()
    @ActionLayout(named = "Crear Historia Clinica")
    @MemberOrder(sequence = "1")
    public Historia create(
            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Vacuna Recibida")
            final Selector vacunaRecibida,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Cuales?")
            final  String vacuRecibida,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Vacuanas Faltantes")
            final Selector vacunaFaltante,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Cuales?")
            final String vacuFaltante,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Enfermedades Padecidas")
            final Selector enfermedadPadecida,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Cuales?")
            final String enfePadecida,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Alergias")
            final  Selector alergias,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Cuales")
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
        return historiaRepository.create(vacunaRecibida,vacuRecibida,vacunaFaltante,vacuFaltante,enfermedadPadecida,enfePadecida,alergias,alerPadecida,ultimaVisitaMedica,tipoMedicacion,lapsoIngesta,stockMedicacion,medicacionAnterior);
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
