package domainapp.modules.simple.historia;


import domainapp.modules.simple.paciente.EstadoPaciente;
import domainapp.modules.simple.paciente.Paciente;
import domainapp.modules.simple.paciente.PacienteRepository;
import domainapp.modules.simple.planillaEnfermeros.Estado;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;
import org.datanucleus.query.typesafe.TypesafeQuery;


import java.util.List;
@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        objectType = "Historia",
        repositoryFor = Historia.class
)
@DomainServiceLayout(
        named = "Historia",
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
            @ParameterLayout(named = "Hipertension Arterial")
            final Estado hipertensionArterial,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Diabetes")
            final Estado diabetes,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Enfermedad Cardiovascular")
            final Estado enfCardiovascular,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Usa Marcapasos")
            final Estado marcapasos,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Discopatias")
            final Estado discopatias,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Perdida del Conocimiento")
            final Estado perdidaDeConocimiento,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Artritis")
            final Estado artritis,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Artrosis")
            final Estado artrosis,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Lumbago")
            final Estado lumbago,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Neurosis")
            final Estado neurosis,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Traumatismos")
            final Estado traumatismos,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Problemas Otologicos")
            final Estado problemasOtologicos,

            @Parameter(maxLength = 200)
            @ParameterLayout(named = "Comentarios")
            final String comentarios)
    {
        int idHistoria = 0;
        return historiaRepository.create(idHistoria, paciente, hipertensionArterial,diabetes,enfCardiovascular,marcapasos,discopatias,perdidaDeConocimiento,artritis,artrosis,lumbago,neurosis,traumatismos,problemasOtologicos,comentarios);
    }

    public List<Paciente> choices0Create() {return pacienteRepository.Listar(EstadoPaciente.Activo);}

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Buscar Historia Clinica")
    @MemberOrder(sequence = "2")
    public Historia findByPaciente(
            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "Por Paciente: ")
            final Paciente paciente) {
        TypesafeQuery<Historia> q = isisJdoSupport.newTypesafeQuery(Historia.class);
        final QHistoria cand = QHistoria.candidate();
        q = q.filter(
                cand.paciente.eq(q.stringParameter("paciente"))
        );
        return q.setParameter("paciente", paciente)
                .executeUnique();
    }

    public List<Paciente> choices0FindByPaciente() {return pacienteRepository.Listar();}

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Listado de Historias Clinicas")
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
