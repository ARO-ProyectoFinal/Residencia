package domainapp.modules.simple.historia;

import domainapp.modules.simple.datosFamiliares.DatosFamiliares;
import domainapp.modules.simple.datosFamiliares.QDatosFamiliares;
import domainapp.modules.simple.paciente.Paciente;
import domainapp.modules.simple.paciente.PacienteRepository;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;
import org.datanucleus.query.typesafe.TypesafeQuery;
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

            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "Paciente: ")
            final Paciente paciente,

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
        return historiaRepository.create(paciente, vacuRecibida,vacuFaltante,enfePadecida,alerPadecida,ultimaVisitaMedica,tipoMedicacion,lapsoIngesta,stockMedicacion,medicacionAnterior);
    }

    public List<Paciente> choices0Create() {return pacienteRepository.Listar();}

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Buscar Historia Clinica")
    @MemberOrder(sequence = "2")
    public Historia findByHistoria(
            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "Por vacuna recibida: ")
            final String vacuRecibida) {
        TypesafeQuery<Historia> q = isisJdoSupport.newTypesafeQuery(Historia.class);
        final QHistoria cand = QHistoria.candidate();
        q = q.filter(
                cand.vacuRecibida.eq(q.stringParameter("vacuRecibida"))
        );
        return q.setParameter("vacuRecibida", vacuRecibida)
                .executeUnique();
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

    @javax.inject.Inject
    PacienteRepository pacienteRepository;
}
