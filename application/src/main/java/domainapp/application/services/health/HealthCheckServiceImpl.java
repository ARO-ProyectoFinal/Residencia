package domainapp.application.services.health;

import javax.inject.Inject;

import domainapp.modules.simple.dom.impl.paciente.Pacientes;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.services.health.Health;
import org.apache.isis.applib.services.health.HealthCheckService;

@DomainService(nature = NatureOfService.DOMAIN)
public class HealthCheckServiceImpl implements HealthCheckService {

    @Override
    public Health check() {

        try {
            pacientes.ping();
            return Health.ok();
        } catch (Exception ex) {
            return Health.error(ex.getMessage());
        }

    }

    @Inject
    Pacientes pacientes;
}
