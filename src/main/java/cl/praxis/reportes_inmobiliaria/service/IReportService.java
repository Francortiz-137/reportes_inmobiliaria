package cl.praxis.reportes_inmobiliaria.service;

import cl.praxis.reportes_inmobiliaria.entity.Report;

import java.util.List;

public interface IReportService {

    List<Report> getReports();
    Report getReport(Long id);
    Report addReport(Report report);
    Report updateReport(Report report);
    void deleteReport(Long id);
}
