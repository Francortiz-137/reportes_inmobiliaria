package cl.praxis.reportes_inmobiliaria.repository;

import cl.praxis.reportes_inmobiliaria.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReportRepository extends JpaRepository<Report, Long> {
}
