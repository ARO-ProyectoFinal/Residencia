package domainapp.modules.simple.cognitiva;


import domainapp.modules.simple.historia.HistoriaRepository;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;
import org.apache.isis.applib.annotation.*;
import java.util.List;

public class CognitivaMenu {

    @Action()
    @ActionLayout(named = "Crear Valoraciones Cognitivas")
    @MemberOrder(sequence = "1")
    public Cognitiva create(
            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Comer solo")
            final String comerSolo,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Ir al baño solo")
            final String bañoSolo,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Vestir solo")
            final String vestirSolo,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Bañarse solo")
            final String bañarseSolo,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Moverse solo")
            final String moverSolo)
    {
    return cognitivaRepository.create(comerSolo,bañoSolo,vestirSolo,bañarseSolo,moverSolo);
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "3")
    public List<Cognitiva> listAll () {
        List <Cognitiva> cognitivas = cognitivaRepository.Listar();
        return cognitivas;

    }

    @javax.inject.Inject
    IsisJdoSupport isisJdoSupport;

    @javax.inject.Inject
    CognitivaRepository cognitivaRepository;
}