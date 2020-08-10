package domainapp.modules.simple.datosFamiliares;


import com.google.common.collect.ComparisonChain;


import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.title.TitleService;

import lombok.AccessLevel;


import static org.apache.isis.applib.annotation.CommandReification.ENABLED;
import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;

@lombok.Getter @lombok.Setter
@lombok.RequiredArgsConstructor


public class DatosFamiliares {


        //Datos familiares paciente
        @javax.jdo.annotations.Column(allowsNull = "true", length = 40)
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
