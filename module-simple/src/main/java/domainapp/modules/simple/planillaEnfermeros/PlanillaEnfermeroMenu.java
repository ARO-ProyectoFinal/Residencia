package domainapp.modules.simple.planillaEnfermeros;

import domainapp.modules.simple.enfermero.Enfermero;
import domainapp.modules.simple.enfermero.EnfermeroRepository;
import domainapp.modules.simple.paciente.Paciente;
import domainapp.modules.simple.paciente.PacienteRepository;


import domainapp.modules.simple.reportes.EjecutarReportes;
import domainapp.modules.simple.visita.VisitaRepository;
import net.sf.jasperreports.engine.JRException;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;
import org.apache.isis.applib.value.Blob;
import org.datanucleus.query.typesafe.TypesafeQuery;
import org.joda.time.LocalDate;

import java.io.IOException;
import java.util.List;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        objectType = "PlanillaEnfermero",
        repositoryFor = PlanillaEnfermero.class
)
@DomainServiceLayout(
        named = "PlanillaEnfermero",
        menuOrder = ""
)

public class PlanillaEnfermeroMenu {

    @Action()
    @ActionLayout(named = "Crear Planilla Enfermero")
    @MemberOrder(sequence = "1")
    public PlanillaEnfermero create(

            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "Paciente: ")
            final Paciente paciente,

            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "Enfermero: ")
            final Enfermero enfermero,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Fecha Planilla: ")
            final LocalDate fechaPlanilla,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Turno")
            final Turnos turno,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Tomo Medicacion")
            final Estado medicacion,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Realizo Curaciones")
            final Estado curaciones,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Realizo Actividad Fisica")
            final Estado actividadFisica,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Comidas realizadas")
            final Comidas comidas,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Realizo Limpieza de Ropa")
            final Estado ropa,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Realizo Limpieza de Pisos")
            final Estado limpieza,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Observacion")
            final String observacion)
    {
        return planillaEnfermeroRepository.create(paciente, enfermero, fechaPlanilla, turno, medicacion, curaciones, actividadFisica, comidas, ropa, limpieza, observacion);
    }

    public List<Paciente> choices0Create() {return pacienteRepository.Listar();}
    public List<Enfermero> choices1Create() {return enfermeroRepository.Listar();}

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Buscar Planilla")
    @MemberOrder(sequence = "2")
    public PlanillaEnfermero findByPaciente(
            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "Por Paciente: ")
            final Paciente paciente) {
        TypesafeQuery<PlanillaEnfermero> q = isisJdoSupport.newTypesafeQuery(PlanillaEnfermero.class);
        final QPlanillaEnfermero cand = QPlanillaEnfermero.candidate();
        q = q.filter(
                cand.paciente.eq(q.stringParameter("paciente"))
        );
        return q.setParameter("paciente", paciente)
                .executeUnique();
    }

    public List<Paciente> choices0FindByPaciente() {return pacienteRepository.Listar();}

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Planillas de Enfermeros")
    @MemberOrder(sequence = "4")
    public List<PlanillaEnfermero> listAll() {
        List <PlanillaEnfermero> planillaEnfermeros =  planillaEnfermeroRepository.Listar();
        return planillaEnfermeros;

    }

    @Action()
    @ActionLayout(named = "Listado Exportado")
    public Blob ExportarListado() throws JRException, IOException {
        EjecutarReportes ejecutarReportes = new EjecutarReportes();
        return ejecutarReportes.ListadoPlanillaEnfermeroPDF(planillaEnfermeroRepository.Listar());
    }

    @javax.inject.Inject
    IsisJdoSupport isisJdoSupport;

    @javax.inject.Inject
    PlanillaEnfermeroRepository planillaEnfermeroRepository;

    @javax.inject.Inject
    EnfermeroRepository enfermeroRepository;

    @javax.inject.Inject
    PacienteRepository pacienteRepository;
}
