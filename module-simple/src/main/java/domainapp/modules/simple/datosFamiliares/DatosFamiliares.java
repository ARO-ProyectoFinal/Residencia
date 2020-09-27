package domainapp.modules.simple.datosFamiliares;


import com.google.common.collect.ComparisonChain;


import domainapp.modules.simple.paciente.Paciente;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;

import lombok.AccessLevel;


import javax.jdo.annotations.*;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.apache.isis.applib.annotation.CommandReification.ENABLED;
import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;

@lombok.Getter @lombok.Setter
@lombok.RequiredArgsConstructor

@PersistenceCapable(
        identityType = IdentityType.DATASTORE,
        schema = "simple",
        table = "DatosFamiliar"
)
@DatastoreIdentity(
        strategy = IdGeneratorStrategy.IDENTITY,
        column = "id")
@Version(
        strategy = VersionStrategy.VERSION_NUMBER,
        column = "version")
@Queries({
        @Query(
                name = "find", language = "JDOQL",
                value = "SELECT "),
       /* @Query(
                name = "buscaFamiliar", language = "JDOQL",
                value = "SELECT"
                        +"FROM domainapp.modules.simple.datosFamiliares.DatosFamiliares"
                        +"WHERE nombreCompletoFamiliar == nombreCompletoFamiliar"),



        */

})





@Unique(name = "DatosFamiliares_nombreCompletoFamiliar_UNQ", members = { "nombreCompletoFamiliar" })
@DomainObject(
        editing = Editing.DISABLED
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)


public class DatosFamiliares implements Comparable<DatosFamiliares>{

        public DatosFamiliares(final String nombreCompletoFamiliar, String parentesco) {
                this.nombreCompletoFamiliar = nombreCompletoFamiliar;
                this.parentesco = parentesco;
        }


        public Paciente newPaciente(final String name, final String apellido) {
                return repositoryService.persist(new Paciente(this, name, apellido));
        }

        @Persistent(mappedBy = "datosFamiliares", dependentElement = "true")
        @Column(allowsNull = "true")
        @Property()
        private List<Paciente> pacientes;


        //Datos familiares paciente
        @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
        @lombok.NonNull
        @Property(editing = Editing.ENABLED)
        private String nombreCompletoFamiliar;


        @javax.jdo.annotations.Column(allowsNull = "true", length = 40)
        @Property(editing = Editing.ENABLED)
        @lombok.NonNull
        private String parentesco;

        @javax.jdo.annotations.Column(allowsNull = "true", length = 40)
        @Property(editing = Editing.ENABLED)
        @lombok.NonNull
        private String numeroContacto;

        @javax.jdo.annotations.Column(allowsNull = "true", length = 40)
        @Property(editing = Editing.ENABLED)
        @lombok.NonNull
        private String mailFamiliar;


        public String title(){
            return getNombreCompletoFamiliar();
        }


        @Action(semantics = IDEMPOTENT, command = ENABLED, publishing = Publishing.ENABLED, associateWith = "nombreCompletoFamiliar")
        public DatosFamiliares updateName(
                @Parameter(maxLength = 40)
                @ParameterLayout(named = "Nombre") final String nombreCompletoFamiliar


        ) {
            setNombreCompletoFamiliar(nombreCompletoFamiliar);

            return this;

        }

        public String default0UpdateName() {
            return getNombreCompletoFamiliar();
        }

        public TranslatableString validate0UpdateName(final String name) {
            return name != null && name.contains("!") ? TranslatableString.tr("Exclamation mark is not allowed") : null;
        }


        // @Action(semantics = NON_IDEMPOTENT_ARE_YOU_SURE)
        // public void delete() {
        //    final String title = titleService.titleOf(this);
        //   messageService.informUser(String.format("'%s' deleted", title));
        //   pacienteRepository.remove(this);
        // }


        @Override
        public String toString() {
            return getNombreCompletoFamiliar();
        }

        public int compareTo(final DatosFamiliares other) {
            return ComparisonChain.start()
                    .compare(this.getNombreCompletoFamiliar(), other.getNombreCompletoFamiliar())
                    .result();
        }

        @javax.jdo.annotations.NotPersistent
        @javax.inject.Inject
        @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
        RepositoryService repositoryService;

        @javax.inject.Inject
        @javax.jdo.annotations.NotPersistent
        @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
        DatosFamiliaresRepository datosfamiliaresrepository;

        @javax.inject.Inject
        @javax.jdo.annotations.NotPersistent
        @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
        TitleService titleService;

        @javax.inject.Inject
        @javax.jdo.annotations.NotPersistent
        @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
        MessageService messageService;


}
