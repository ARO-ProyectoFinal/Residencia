package domainapp.modules.simple.datosFamiliares;

import domainapp.modules.simple.paciente.Paciente;
import domainapp.modules.simple.paciente.PacienteRepository;
import domainapp.modules.simple.reportes.EjecutarReportes;
import net.sf.jasperreports.engine.JRException;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;
import org.apache.isis.applib.value.Blob;
import org.datanucleus.query.typesafe.TypesafeQuery;

import java.io.IOException;
import java.util.List;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        objectType = "DatosFamiliares",
        repositoryFor = DatosFamiliares.class
)
@DomainServiceLayout(
        named = "DatosFamiliares",
        menuOrder = ""
)

public class DatosFamiliaresMenu {


    @Action()
    @ActionLayout(named = "Datos Familiares")
    @MemberOrder(sequence = "1")
    public DatosFamiliares create(
            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "Paciente: ")
            final Paciente paciente,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Nombre Completo del familiar ")
            final String nombreCompletoFamiliar,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Parentesco ")
            final  String parentesco,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Numero Contacto ")
            final  String numeroContacto,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Mail Contacto ")
            final  String mailFamiliar)

    {
        return datosfamiliaresrepository.create (paciente,nombreCompletoFamiliar, parentesco,numeroContacto,mailFamiliar);
    }

    public List<Paciente> choices0Create() {return pacienteRepository.Listar();}

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Buscar familiar")
    @MemberOrder(sequence = "2")
    public DatosFamiliares findByFamiliar(
            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "Por nombre completo: ")
            final String nombreCompletoFamiliar) {
        TypesafeQuery<DatosFamiliares> q = isisJdoSupport.newTypesafeQuery(DatosFamiliares.class);
        final QDatosFamiliares cand = QDatosFamiliares.candidate();
        q = q.filter(
                cand.nombreCompletoFamiliar.eq(q.stringParameter("nombreCompletoFamiliar"))
        );
        return q.setParameter("nombreCompletoFamiliar", nombreCompletoFamiliar)
                .executeUnique();
    }


    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Listado de familiares")
    @MemberOrder(sequence = "3")
    public List<DatosFamiliares> listAll() {
        List <DatosFamiliares> datosFamiliares =  datosfamiliaresrepository.Listar();
        return datosFamiliares;

    }

    @Action()
    @ActionLayout(named = "Listado Exportado")
    public Blob ExportarListado() throws JRException, IOException {
        EjecutarReportes ejecutarReportes = new EjecutarReportes();
        return ejecutarReportes.ListadoFamiliarPDF(datosfamiliaresrepository.Listar());
    }

    @javax.inject.Inject
    IsisJdoSupport isisJdoSupport;

    @javax.inject.Inject
    DatosFamiliaresRepository datosfamiliaresrepository;

    @javax.inject.Inject
    PacienteRepository pacienteRepository;
}



