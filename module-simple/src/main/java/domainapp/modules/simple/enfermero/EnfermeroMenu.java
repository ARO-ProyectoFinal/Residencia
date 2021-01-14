package domainapp.modules.simple.enfermero;


import domainapp.modules.simple.paciente.TipoDocumento;
import domainapp.modules.simple.reportes.EjecutarReportes;
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
        objectType = "DatosEnfermero",
        repositoryFor = Enfermero.class
)
@DomainServiceLayout(
        named = "DatosEnfermero",
        menuOrder = ""
)
public class EnfermeroMenu {

    @Action()
    @ActionLayout(named = "Crear Enfermero")
    @MemberOrder(sequence = "1")
    public Enfermero create(

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Nombre Enfermero")
            final String nombre,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Apellido Enfermero")
            final String apellido,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Fecha Alta")
            final LocalDate fechaAlta,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Tipo de Documento")
            final TipoDocumento tipoDocumento,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Numero de Documento")
            final String nroDocumento,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Fecha de Nacimiento")
            final LocalDate fechaNacimiento,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Lugar de Nacimiento")
            final String lugarNacimiento,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Telefono")
            final String telefono,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Edad")
            final String edad,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Numero de Matricula")
            final String nroMatricula)

    {
        return enfermeroRepository.create(nombre,apellido,fechaAlta,tipoDocumento,nroDocumento,fechaNacimiento,lugarNacimiento,edad,telefono,nroMatricula);
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Buscar Enfermero")
    @MemberOrder(sequence = "2")
    public Enfermero findByEnfermero(
            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "Por nombre: ")
            final Enfermero enfermero) {

        return enfermero;
    }

    public List<Enfermero> choices0FindByEnfermero() {return enfermeroRepository.Listar();}

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Listado de Enfermero")
    @MemberOrder(sequence = "3")
    public List<Enfermero> listAll() {
        List <Enfermero> enfermero =  enfermeroRepository.Listar();
        return enfermero;

    }

    @Action()
    @ActionLayout(named = "Listado Exportado")
    public Blob ExportarListado() throws JRException, IOException {
        EjecutarReportes ejecutarReportes = new EjecutarReportes();
        return ejecutarReportes.ListadoEnfermeroPDF(enfermeroRepository.Listar());
    }

    @javax.inject.Inject
    IsisJdoSupport isisJdoSupport;

    @javax.inject.Inject
    EnfermeroRepository enfermeroRepository;
}

