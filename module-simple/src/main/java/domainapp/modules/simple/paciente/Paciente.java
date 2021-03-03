/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package domainapp.modules.simple.paciente;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Queries;
import javax.jdo.annotations.Query;
import javax.jdo.annotations.VersionStrategy;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.google.common.collect.ComparisonChain;
import domainapp.modules.simple.datosFamiliares.DatosFamiliares;
import domainapp.modules.simple.datosFamiliares.DatosFamiliaresRepository;
import domainapp.modules.simple.enfermero.Enfermero;
import domainapp.modules.simple.enfermero.EnfermeroRepository;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.title.TitleService;
import lombok.AccessLevel;
import org.apache.isis.schema.utils.jaxbadapters.JodaDateTimeStringAdapter;
import org.joda.time.LocalDate;
import java.util.List;


@Queries({
        @Query(
                name = "find", language = "JDOQL",
                value = "SELECT "),
        @Query(
                name = "findByEstado", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.modules.simple.paciente.Paciente "
                        + "WHERE estado == :estado "
                        + "ORDER BY name ASC")
})


@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE, schema = "simple")
@javax.jdo.annotations.DatastoreIdentity(strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column="id")
@javax.jdo.annotations.Version(strategy= VersionStrategy.DATE_TIME, column="version")
@javax.jdo.annotations.Unique(name="Paciente_nroDocumento_UNQ", members = {"nroDocumento"})
@DomainObject(auditing = Auditing.ENABLED)
@DomainObjectLayout()  // causes UI events to be triggered
@lombok.Getter @lombok.Setter
@lombok.RequiredArgsConstructor
public class Paciente implements Comparable<Paciente> {

    @javax.jdo.annotations.Column(allowsNull = "true", name = "sol_datos_famId")
    @Property()
    @PropertyLayout(named = "Familiar")
    private DatosFamiliares solicitanteDatosFamiliares;


    @javax.jdo.annotations.Column(allowsNull = "true", name = "asi_enfer_Id")
    @Property()
    @PropertyLayout(named = "Enfermero")
    private Enfermero asignarEnfermero;

    @javax.jdo.annotations.Column(allowsNull = "true", name = "estado")
    @Property()
    private EstadoPaciente estado;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @PropertyLayout(named = "Nombre")
    @Property() // editing disabled by default, see isis.properties
    private String name;

    @javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @lombok.NonNull
    @Property()
    private String apellido;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @lombok.NonNull
    @Property() // editing disabled by default, see isis.properties
    @XmlJavaTypeAdapter(JodaDateTimeStringAdapter.ForJaxb.class)
    private LocalDate fechaAlta;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @lombok.NonNull
    @Property()
    private Integer edad;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @lombok.NonNull
    @Property()
    private TipoDocumento tipoDocumento;

    @javax.jdo.annotations.Column(allowsNull = "true", length = 40)
    @lombok.NonNull
    @Property()
    private String nroDocumento;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @lombok.NonNull
    @Property() // editing disabled by default, see isis.properties
    @XmlJavaTypeAdapter(JodaDateTimeStringAdapter.ForJaxb.class)
    private LocalDate fechaNacimiento;

    @javax.jdo.annotations.Column(allowsNull = "true", length = 40)
    @lombok.NonNull
    @Property()
    private String lugarDeNacimiento;

    @javax.jdo.annotations.Column(allowsNull = "true", length = 40)
    @lombok.NonNull
    @Property()
    private String telefono;

    @javax.jdo.annotations.Column(allowsNull = "true", length = 40)
    @lombok.NonNull
    @Property()
    private String nroSeguroSocial;

    @javax.jdo.annotations.Column(allowsNull = "true", length = 40)
    @lombok.NonNull
    @Property()
    private String incapacidad;

    @javax.jdo.annotations.Column(allowsNull = "true", length = 40)
    @Property()
    @lombok.NonNull
    private String observacion;


    public String RepoName() { return this.name; }
    public String RepoApellido() { return this.apellido; }
    public LocalDate RepoFechaAlta() { return this.fechaAlta; }
    public int RepoEdad() { return this.edad; }
    public String RepoIncapacidad() { return this.incapacidad; }
    public String RepoObservacion() { return this.observacion; }


    public String title(){
        return getApellido()+" " + getName();
    }

    public String iconName(){
        if (this.estado == EstadoPaciente.Activo){
            return "Activo";
        }else{
            return "Baja";
        }
    }


    @Action()
    @ActionLayout(named = "Editar")
    public Paciente updatePaciente(
            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Nombre") final String name,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Apellido") final String apellido,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Fecha de Alta") final LocalDate fechaAlta ,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Edad") final Integer edad,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Tipo de Documento") final TipoDocumento tipoDocumento ,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Nro de Documento") final String nroDocumento,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Fecha de Nacimiento") final LocalDate fechaNacimiento,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Lugar de Nacimiento") final String lugarDeNacimiento,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Telefono") final String telefono,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Nro de Seguro Social") final String nroSeguroSocial,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Incapacidad") final String incapacidad,

            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Observacion") final String observacion) {

        this.name = name;
        this.apellido = apellido;
        this.fechaAlta = fechaAlta;
        this.edad = edad;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.lugarDeNacimiento = lugarDeNacimiento;
        this.telefono = telefono;
        this.nroSeguroSocial = nroSeguroSocial;
        this.incapacidad = incapacidad;
        this.observacion = observacion;

        return this;
    }

    public String default0UpdatePaciente() {
        return getName();
    }

    public String default1UpdatePaciente() {
        return getApellido();
    }

    public LocalDate default2UpdatePaciente() {
        return getFechaAlta();
    }

    public Integer default3UpdatePaciente() {
        return getEdad();
    }

    public TipoDocumento default4UpdatePaciente() {
        return getTipoDocumento();
    }

    public String default5UpdatePaciente() {
        return getNroDocumento();
    }

    public LocalDate default6UpdatePaciente() {
        return getFechaNacimiento();
    }

    public String default7UpdatePaciente() {
        return getLugarDeNacimiento();
    }

    public String default8UpdatePaciente() {
        return getTelefono();
    }

    public String default9UpdatePaciente() {
        return getNroSeguroSocial();
    }

    public String default10UpdatePaciente() {
        return getIncapacidad();
    }

    public String default11UpdatePaciente() {
        return getObservacion();
    }

    @Programmatic
    public void CambiarEstado(EstadoPaciente estado){
        this.estado = estado;
    }

    @Action()
    @ActionLayout(named = "Activar")
    public Paciente Activo(){
        CambiarEstado(EstadoPaciente.Activo);
        return this;
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT_ARE_YOU_SURE)
    @ActionLayout(named = "Dar de baja")
    public Paciente Baja(){
        CambiarEstado(EstadoPaciente.Baja);
        return this;
    }
    public boolean hideActivo(){return  this.estado == EstadoPaciente.Activo;}
    public boolean hideBaja(){return  this.estado == EstadoPaciente.Baja;}


    @Override
    public String toString() {
        return getName();
    }

    public int compareTo(final Paciente other) {
        return ComparisonChain.start()
                .compare(this.getName(), other.getName())
                .result();
    }

    @Action()
    @ActionLayout(named = "Asignar Familiar")
    public Paciente AgregarDatosFamiliar(
            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "Familiar")
            final DatosFamiliares datosFamiliares) {

        this.solicitanteDatosFamiliares = datosFamiliares;
        return this;
    }

    public List<DatosFamiliares> choices0AgregarDatosFamiliar() {
        return datosFamiliaresRepository.Listar();
    }

    @Action()
    @ActionLayout(named = "Asignar Enfermero")
    public Paciente AgregarEnfermero(
            @Parameter(optionality = Optionality.MANDATORY)
            @ParameterLayout(named = "Enfermero")
            final Enfermero enfermero) {

        this.asignarEnfermero = enfermero;
        return this;
    }

    public List<Enfermero> choices0AgregarEnfermero() { return enfermeroRepository.Listar(); }

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    DatosFamiliaresRepository datosFamiliaresRepository;

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    EnfermeroRepository enfermeroRepository;

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