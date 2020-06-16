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
package domainapp.modules.simple.dom.impl;

import java.util.List;

import org.datanucleus.query.typesafe.TypesafeQuery;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.services.eventbus.ActionDomainEvent;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.joda.time.LocalDate;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        objectType = "simple.SimpleObjectMenu",
        repositoryFor = Paciente.class
)
@DomainServiceLayout(
        named = "Pacientes",
        menuOrder = "10"
)
public class Pacientes {

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "1")
    public List<Paciente> listAll() {
        return repositoryService.allInstances(Paciente.class);
    }


    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "2")
    public List<Paciente> findByName(
            @ParameterLayout(named="Nombre")
            final String name
    ) {
        TypesafeQuery<Paciente> q = isisJdoSupport.newTypesafeQuery(Paciente.class);
        final QPaciente cand = QPaciente.candidate();
        q = q.filter(
                cand.name.indexOf(q.stringParameter("name")).ne(-1)
        );
        return q.setParameter("name", name)
                .executeList();
    }

    @Programmatic
    public Paciente findByNameExact(final String name) {
        TypesafeQuery<Paciente> q = isisJdoSupport.newTypesafeQuery(Paciente.class);
        final QPaciente cand = QPaciente.candidate();
        q = q.filter(
                cand.name.eq(q.stringParameter("name"))
        );
        return q.setParameter("name", name)
                .executeUnique();
    }

    @Programmatic
    public void ping() {
        TypesafeQuery<Paciente> q = isisJdoSupport.newTypesafeQuery(Paciente.class);
        final QPaciente candidate = QPaciente.candidate();
        q.range(0,2);
        q.orderBy(candidate.name.asc());
        q.executeList();
    }

    public static class CreateDomainEvent extends ActionDomainEvent<Pacientes> {}
    @Action(domainEvent = CreateDomainEvent.class)
    @MemberOrder(sequence = "3")
    public Paciente create(
            @ParameterLayout(named = "Nombre") final String name,
            @ParameterLayout(named = "Apellido") final  String apellido,
            @ParameterLayout(named = "Fecha de alta") final LocalDate fechaAlta,
            @ParameterLayout(named = "Edad") final Integer edad,
            @ParameterLayout(named = "Tipo Documento") final TipoDocumento tipoDocumento,
            @ParameterLayout(named = "Numero de documento") final String nroDocumento,
            @ParameterLayout(named = "Fecha de nacimiento ") final  LocalDate fechaNacimiento,
            @ParameterLayout(named = "Lugar de nacimiento ") final  String lugarDeNacimiento,
            @ParameterLayout(named = "Telefono ") final Integer telefono,
            @ParameterLayout(named = "Numero de Seguro Social ") final  String numeroDeSeguroSocial,
            @ParameterLayout(named = "Incapacidad ") final String incapacidad,
            @ParameterLayout(named = "Observacion ") final  String observacion


    ){
        return repositoryService.persist(new Paciente(name,apellido,fechaAlta,edad,tipoDocumento,nroDocumento,fechaNacimiento,lugarDeNacimiento,telefono,numeroDeSeguroSocial,incapacidad,observacion));
    }

    @javax.inject.Inject
    RepositoryService repositoryService;

    @javax.inject.Inject
    IsisJdoSupport isisJdoSupport;

}
