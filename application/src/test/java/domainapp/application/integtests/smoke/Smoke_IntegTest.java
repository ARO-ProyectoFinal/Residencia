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
package domainapp.application.integtests.smoke;

import java.util.List;

import javax.inject.Inject;

import domainapp.modules.simple.dom.impl.Pacientes;
import domainapp.modules.simple.dom.impl.Paciente;
import domainapp.modules.simple.dom.impl.TipoDocumento;
import org.joda.time.LocalDate;
import org.junit.Test;

import domainapp.application.integtests.DomainAppIntegTestAbstract;

import static org.assertj.core.api.Assertions.assertThat;

public class Smoke_IntegTest extends DomainAppIntegTestAbstract {

    @Inject
    Pacientes menu;

    @Test
    public void create() {

        // when
        List<Paciente> all = wrap(menu).listAll();

        // then
        assertThat(all).isEmpty();



        // when
        final Paciente fred = wrap(menu).create("Maxi", "fredisom",LocalDate.parse(String.valueOf(16/06/2020)), 23, TipoDocumento.DNI, "15589632", LocalDate.parse(String.valueOf(11/11/1998)), "Nequen", 299854565, "321654", "manco", "muy crack" , "Pablo", "Perez", "Hijo","155422217","pablo@gmail.com","Av.755");
        transactionService.flushTransaction();

        // then
        all = wrap(menu).listAll();
        assertThat(all).hasSize(1);
        assertThat(all).contains(fred);



        // when
        final Paciente bill = wrap(menu).create("Bill", "fredisom",LocalDate.parse(String.valueOf(16/06/2020)), 23, TipoDocumento.DNI, "15589632", LocalDate.parse(String.valueOf(11/11/1998)), "Nequen", 299854565, "321654", "manco", "muy crack","Pablo", "Perez", "Hijo","155422217","pablo@gmail.com","Av.755" );
        transactionService.flushTransaction();

        // then
        all = wrap(menu).listAll();
        assertThat(all).hasSize(2);
        assertThat(all).contains(fred, bill);



        // when
        wrap(fred).updateName("Freddy", "fredisom",LocalDate.parse(String.valueOf(16/06/2020)), 23, TipoDocumento.DNI, "15589632", LocalDate.parse(String.valueOf(11/11/1998)), "Nequen", 299854565, "321654", "manco", "muy crack","Pablo", "Perez", "Hijo","155422217","pablo@gmail.com","Av.755" );
        transactionService.flushTransaction();

        // then
        assertThat(wrap(fred).getName()).isEqualTo("Freddy");

        // when
        wrap(fred).delete();
        transactionService.flushTransaction();


        all = wrap(menu).listAll();
        assertThat(all).hasSize(1);

    }

}

