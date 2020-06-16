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

package domainapp.modules.simple.fixture;

import domainapp.modules.simple.dom.impl.Pacientes;
import domainapp.modules.simple.dom.impl.TipoDocumento;
import org.apache.isis.applib.fixturescripts.BuilderScriptAbstract;

import domainapp.modules.simple.dom.impl.Paciente;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.joda.time.LocalDate;

@Accessors(chain = true)
public class SimpleObjectBuilder extends BuilderScriptAbstract<Paciente, SimpleObjectBuilder> {

    @Getter @Setter
    private LocalDate fechaAlta;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String apellido;

    @Getter @Setter
    private Integer edad;

    @Getter @Setter
    private TipoDocumento tipoDocumento;

    @Getter @Setter
    private String nroDocumento;

    @Getter @Setter
    private LocalDate fechaNacimiento;

    @Getter @Setter
    private String lugarDeNacimiento;

    @Getter @Setter
    private Integer telefono;

    @Getter @Setter
    private String numeroDeSeguroSocial;

    @Getter @Setter
    private String incapacidad;

    @Getter @Setter
    private String observacion;

    @Getter
    private Paciente object;

    @Override
    protected void execute(final ExecutionContext ec) {

        checkParam("name", ec, String.class);

        object = wrap(pacientes).create(name,apellido,fechaAlta,edad,tipoDocumento,nroDocumento,fechaNacimiento,lugarDeNacimiento,telefono,numeroDeSeguroSocial,incapacidad,observacion);
    }

    @javax.inject.Inject
    Pacientes pacientes;

}
