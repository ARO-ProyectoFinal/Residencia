package domainapp.modules.simple.reportes;

import domainapp.modules.simple.datosFamiliares.DatosFamiliares;
import domainapp.modules.simple.enfermero.Enfermero;
import domainapp.modules.simple.paciente.Paciente;
import domainapp.modules.simple.planillaEnfermeros.PlanillaEnfermero;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.apache.isis.applib.value.Blob;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EjecutarReportes {

    public Blob ListadoPacientePDF(List<Paciente> pacientes) throws JRException, IOException {

        List<RepoPaciente> repoPacientes = new ArrayList<>();
        repoPacientes.add(new RepoPaciente());

        for (Paciente paciente : pacientes) {
            RepoPaciente repoPaciente = new RepoPaciente(paciente.RepoName(), paciente.RepoApellido(), paciente.RepoFechaAlta().toString("dd-MM-yyyy"), paciente.RepoEdad(), paciente.RepoIncapacidad(), paciente.RepoObservacion());
            repoPacientes.add(repoPaciente);
        }

        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(repoPacientes);
        return GenerarArchivoPDF("ListadoPacienteDesing.jrxml", "Listado de Paciente.pdf", ds);
    }

    public Blob ListadoFamiliarPDF(List<DatosFamiliares> datosFamiliares) throws JRException, IOException {

        List<RepoDatosFamiliares> repoDatosFamiliares1 = new ArrayList<>();
        repoDatosFamiliares1.add(new RepoDatosFamiliares());

        for (DatosFamiliares datosFamiliar : datosFamiliares) {
            RepoDatosFamiliares repoDatosFamiliares = new RepoDatosFamiliares(datosFamiliar.RepoPaciente(), datosFamiliar.RepoNombreCompletoFamiliar(), datosFamiliar.RepoParentesco(), datosFamiliar.RepoNumeroContacto(), datosFamiliar.RepoMailFamiliar());
            repoDatosFamiliares1.add(repoDatosFamiliares);
        }

        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(repoDatosFamiliares1);
        return GenerarArchivoPDF("ListadoFamiliarDesing.jrxml", "Listado de Familiar.pdf", ds);
    }

    public Blob ListadoEnfermeroPDF(List<Enfermero> enfermeros) throws JRException, IOException {

        List<RepoEnfermero> repoEnfermeros = new ArrayList<>();
        repoEnfermeros.add(new RepoEnfermero());

        for (Enfermero enfermero : enfermeros) {
            RepoEnfermero repoEnfermero = new RepoEnfermero(enfermero.RepoNombre(), enfermero.RepoApellido(), enfermero.RepoEdad(), enfermero.RepoTelefono(), enfermero.RepoNroMatricula());
            repoEnfermeros.add(repoEnfermero);
        }

        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(repoEnfermeros);
        return GenerarArchivoPDF("ListadoEnfermeroDesing.jrxml", "Listado de Enfermero.pdf", ds);
    }

    public Blob ListadoPlanillaEnfermeroPDF(List<PlanillaEnfermero> planillaEnfermeros) throws JRException, IOException {

        List<RepoPlanillaEnfermero> repoPlanillaEnfermeros = new ArrayList<>();
        repoPlanillaEnfermeros.add(new RepoPlanillaEnfermero());

        for (PlanillaEnfermero planillaEnfermero : planillaEnfermeros) {
            RepoPlanillaEnfermero repoPlanillaEnfermero = new RepoPlanillaEnfermero(planillaEnfermero.RepoPaciente(), planillaEnfermero.RepoEnfermero(), planillaEnfermero.RepoFechaPlanilla().toString("dd-MM-yyyy"), planillaEnfermero.RepoTurnos(), planillaEnfermero.RepoMedicacion(), planillaEnfermero.RepoCuraciones(), planillaEnfermero.RepoActividadFisica(), planillaEnfermero.RepoComidas(), planillaEnfermero.RepoRopa(), planillaEnfermero.RepoLimpieza(), planillaEnfermero.RepoObservacion());
            repoPlanillaEnfermeros.add(repoPlanillaEnfermero);
        }

        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(repoPlanillaEnfermeros);
        return GenerarArchivoPDF("ListadoPlanillaEnfermeroDesing.jrxml", "Listado de Planilla Enfermero.pdf", ds);
    }


    private Blob GenerarArchivoPDF(String archivoDesing, String nombreSalida, JRBeanCollectionDataSource ds) throws JRException, IOException{

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(archivoDesing);
        JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ds", ds);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ds);
        byte[] contentBytes = JasperExportManager.exportReportToPdf(jasperPrint);

        return new Blob(nombreSalida, "application/pdf", contentBytes);
    }
}
