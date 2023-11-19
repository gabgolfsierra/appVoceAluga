package br.com.engsoftware.appVoceAluga.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.engsoftware.appVoceAluga.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	Optional<Funcionario> findById(Long id);
	void deleteById(Long id);
}
