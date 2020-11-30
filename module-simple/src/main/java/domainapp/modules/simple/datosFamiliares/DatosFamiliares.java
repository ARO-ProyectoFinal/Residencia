package domainapp.modules.simple.datosFamiliares;


import com.google.common.collect.ComparisonChain;


import domainapp.modules.simple.paciente.Paciente;
import domainapp.modules.simple.paciente.PacienteRepository;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;

import lombok.AccessLevel;
import javax.jdo.annotations.*;


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
})


@Unique(name = "DatosFamiliares_nombreCompletoFamiliar_UNQ", members = { "nombreCompletoFamiliar" })
@DomainObject(
        editing = Editing.DISABLED
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)


public class DatosFamiliares{

        //Datos familiares paciente
        @lombok.NonNull
        @Property()
        @Column(allowsNull = "false")
        private Paciente paciente;

        @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
        @lombok.NonNull
        @Property()
        private String nombreCompletoFamiliar;

        @javax.jdo.annotations.Column(allowsNull = "true", length = 40)
        @Property()
        @lombok.NonNull
        private String parentesco;

        @javax.jdo.annotations.Column(allowsNull = "true", length = 40)
        @Property()
        @lombok.NonNull
        private String numeroContacto;

        @javax.jdo.annotations.Column(allowsNull = "true", length = 40)
        @Property()
        @lombok.NonNull
        private String mailFamiliar;


        public String title(){
            return getNombreCompletoFamiliar();
        }

        public String RepoPaciente() { return String.valueOf(this.paciente); }
        public String RepoNombreCompletoFamiliar() { return this.nombreCompletoFamiliar; }
        public String RepoParentesco() { return this.parentesco; }
        public String RepoNumeroContacto() { return this.numeroContacto; }
        public String RepoMailFamiliar() { return this.mailFamiliar; }


        @Action()
        @ActionLayout(named = "Editar")
        public DatosFamiliares updateFamiliar(
                @Parameter(maxLength = 40)
                @ParameterLayout(named = "Nombre")
                final String nombreCompletoFamiliar,

                @Parameter(maxLength = 40)
                @ParameterLayout(named = "Parentesco")
                final String parentesco,

                @Parameter(maxLength = 40)
                @ParameterLayout(named = "Numero de Contacto")
                final String numeroContacto,

                @Parameter(maxLength = 40)
                @ParameterLayout(named = "Mail Familiar")
                final String mailFamiliar){

                this.nombreCompletoFamiliar = nombreCompletoFamiliar;
                this.parentesco = parentesco;
                this.numeroContacto = numeroContacto;
                this.mailFamiliar = mailFamiliar;

            return this;

        }

        public String default0UpdateFamiliar() {
            return getNombreCompletoFamiliar();
        }

        public String default1UpdateFamiliar() {
                return getParentesco();
        }

        public String default2UpdateFamiliar() {
                return getNumeroContacto();
        }

        public String default3UpdateFamiliar() {
                return getMailFamiliar();
        }

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
        PacienteRepository pacienteRepository;

        @javax.inject.Inject
        @javax.jdo.annotations.NotPersistent
        @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
        TitleService titleService;

        @javax.inject.Inject
        @javax.jdo.annotations.NotPersistent
        @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
        MessageService messageService;

}
