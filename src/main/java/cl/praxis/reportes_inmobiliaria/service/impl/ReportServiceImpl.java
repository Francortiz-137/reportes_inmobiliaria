package cl.praxis.reportes_inmobiliaria.service.impl;

import cl.praxis.reportes_inmobiliaria.entity.Report;
import cl.praxis.reportes_inmobiliaria.repository.IReportRepository;
import cl.praxis.reportes_inmobiliaria.service.IReportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements IReportService {

    private IReportRepository reportRepository;

    public ReportServiceImpl(IReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public List<Report> getReports() {
        return reportRepository.findAll();
    }

    @Override
    public Report getReport(Long id) {
        return reportRepository.findById(id).orElse(null);
    }

    @Override
    public Report addReport(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public Report updateReport(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}
