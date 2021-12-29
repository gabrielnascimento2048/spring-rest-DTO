package pt.com.consulta.cep.Refactory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.com.consulta.cep.model.Postal;

@Repository
public interface PostalRepository extends JpaRepository<Postal, Long> {

    public Postal getByPostal(String postal);
}
