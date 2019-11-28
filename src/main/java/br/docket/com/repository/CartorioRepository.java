package br.docket.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.docket.com.model.Cartorio;

@Repository
public interface CartorioRepository extends JpaRepository<Cartorio, Long>{

}
