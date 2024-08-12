package cl.praxis.reportes_inmobiliaria.repository;

import cl.praxis.reportes_inmobiliaria.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
}
