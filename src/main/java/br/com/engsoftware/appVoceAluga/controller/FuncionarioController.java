package br.com.engsoftware.appVoceAluga.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.engsoftware.appVoceAluga.domain.Funcionario;
import br.com.engsoftware.appVoceAluga.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	
	private final FuncionarioRepository funcionarioRepository;
	
	@Autowired
	public FuncionarioController(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	@GetMapping("/")
	public List<Funcionario> getAllFuncionarios(){
		return funcionarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Funcionario getFuncionarioById( @PathVariable Long id) {
		return funcionarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Funcionario nao encontrado"));
	}
	
	@PostMapping("/")
	public Funcionario addFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	@PutMapping("/{id}")
	public Optional<Funcionario> updateFuncionario(@PathVariable Long id,@RequestBody Funcionario updatedFuncionario) {
		return funcionarioRepository.findById(id)
					.map(funcionario -> {
						funcionario.setCodigoIdentificacao(updatedFuncionario.getCodigoIdentificacao());
						funcionario.setCpf(updatedFuncionario.getCpf());
						funcionario.setDataNascimento(updatedFuncionario.getDataNascimento());
						funcionario.setEndereco(updatedFuncionario.getEndereco());
						funcionario.setFilial(updatedFuncionario.getFilial());
						funcionario.setHorarioDeTrabalho(updatedFuncionario.getHorarioDeTrabalho());
						funcionario.setId(updatedFuncionario.getId());
						funcionario.setNomeCompleto(updatedFuncionario.getNomeCompleto());
						funcionario.setTelefone(updatedFuncionario.getTelefone());
						
						return funcionarioRepository.save(funcionario);
					});
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFuncionario(@PathVariable Long id) {
	    try {
	        funcionarioRepository.deleteById(id);
	        return ResponseEntity.ok("Funcionario deletado com sucesso");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar funcionario: " + e.getMessage());
	    }
	}
}
