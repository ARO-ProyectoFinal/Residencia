package domainapp.modules.simple.enfermero;


import domainapp.modules.simple.paciente.TipoDocumento;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;


import org.apache.isis.applib.services.repository.RepositoryService;
import org.joda.time.LocalDate;
import java.util.List;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        objectType = "Enfermero",
        repositoryFor = Enfermero.class
)
@DomainServiceLayout(
        named = "Enfermero",
        menuOrder = ""
)
public class EnfermeroMenu {

    @Action()
    @ActionLayout(named = "Enfermero")
    @MemberOrder(sequence = "1")
    public Enfermero create(

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Nombre Enfermero ")
            final String nombre,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Nombre Enfermero ")
            final String apellido,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Nombre Enfermero ")
            final LocalDate fechaAlta,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Nombre Enfermero ")
            final TipoDocumento tipoDocumento,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Nombre Enfermero ")
            final String nroDocumento,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Nombre Enfermero ")
            final LocalDate fechaNacimiento,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Nombre Enfermero ")
            final String lugarNacimiento,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Nombre Enfermero ")
            final String telefono,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Nombre Enfermero ")
            final String edad,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Nombre Enfermero ")
            final String nroMatricula)

    {
        return enfermeroRepository.create(nombre,apellido,fechaAlta,tipoDocumento,nroDocumento,fechaNacimiento,lugarNacimiento,edad,telefono,nroMatricula);
    }


    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, named = "Listado de Enfermero")
    @MemberOrder(sequence = "3")
    public List<Enfermero> listAll() {
        List <Enfermero> enfermero =  enfermeroRepository.Listar();
        return enfermero;

    }

    @javax.inject.Inject
    IsisJdoSupport isisJdoSupport;

    @javax.inject.Inject
    EnfermeroRepository enfermeroRepository;
}

