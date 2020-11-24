package domainapp.modules.simple.visita;

import domainapp.modules.simple.paciente.Paciente;
import domainapp.modules.simple.paciente.PacienteRepository;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;
import org.datanucleus.query.typesafe.TypesafeQuery;
import org.joda.time.LocalDate;

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

            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "Paciente: ")
            final Paciente paciente,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Fecha Ultima Visita")
            final LocalDate fechaUltimaVisita,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Altura")
            final String altura,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Peso")
            final String peso,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Temperatura")
            final String temperatura,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Presion Arterial")
            final String presionArterial,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Frecuencia Cardiaca")
            final String frecuenciaCardiaca,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Observacion")
            final String observacion)
    {
        return visitaRepository.create(paciente, fechaUltimaVisita, altura, peso, temperatura, presionArterial, frecuenciaCardiaca, observacion);
    }

    public List<Paciente> choices0Create() {return pacienteRepository.Listar();}

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Buscar Visita")
    @MemberOrder(sequence = "2")
    public Visita findByPaciente(
            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "Por Paciente: ")
            final Paciente paciente) {
        TypesafeQuery<Visita> q = isisJdoSupport.newTypesafeQuery(Visita.class);
        final QVisita cand = QVisita.candidate();
        q = q.filter(
                cand.paciente.eq(q.stringParameter("paciente"))
        );
        return q.setParameter("paciente", paciente)
                .executeUnique();
    }

    public List<Paciente> choices0FindByPaciente() {return pacienteRepository.Listar();}

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Listado de Visita Medica")
    @MemberOrder(sequence = "4")
    public List<Visita> listAll() {
        List <Visita> visitas =  visitaRepository.Listar();
        return visitas;

    }

    @javax.inject.Inject
    IsisJdoSupport isisJdoSupport;

    @javax.inject.Inject
    VisitaRepository visitaRepository;

    @javax.inject.Inject
    PacienteRepository pacienteRepository;
}
