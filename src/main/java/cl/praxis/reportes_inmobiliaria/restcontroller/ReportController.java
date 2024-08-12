package cl.praxis.reportes_inmobiliaria.restcontroller;

import cl.praxis.reportes_inmobiliaria.entity.Report;
import cl.praxis.reportes_inmobiliaria.service.IReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private IReportService reportService;
    public ReportController(IReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("")
    public List<Report> getReports() {
        return reportService.getReports();
    }

    @GetMapping("/{id}")
    public Report getReport(@PathVariable Long id) {
        return reportService.getReport(id);
    }

    @PostMapping("")
    public Report addReport(@RequestBody Report report) {
        System.out.println(report);
        return reportService.addReport(report);
    }

    @PutMapping("")
    public Report updateReport(@RequestBody Report report) {
        return reportService.updateReport(report);
    }

    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable Long id) {
        reportService.deleteReport(id);
    }
}
