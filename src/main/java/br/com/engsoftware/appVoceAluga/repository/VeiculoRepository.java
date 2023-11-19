package br.com.engsoftware.appVoceAluga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.engsoftware.appVoceAluga.domain.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	 List<Veiculo> findByMarca(String marca);
}