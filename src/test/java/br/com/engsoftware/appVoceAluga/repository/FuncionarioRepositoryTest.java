package br.com.engsoftware.appVoceAluga.repository;

import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import java.sql.Time;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.engsoftware.appVoceAluga.domain.Filial;
import br.com.engsoftware.appVoceAluga.domain.Funcionario;

@ExtendWith(MockitoExtension.class)
public class FuncionarioRepositoryTest {
	
	
	@Mock
	private FuncionarioRepository funcionarioRepositoryMock;
	
	@Test
	public void testFindFuncionarioById() {
		Long id = 1L;
		String cpf = "123.456.789-00";
		String nomeCompleto = "Stevie Ray Vaughan";
		LocalDate dataNascimento = LocalDate.of(1984, 10, 3);
		String telefone = "2198777333";
		String endereco = "Praça Saens Pena";
		String horarioDeTrabalho = "7:00 - 17:00";
		String codigoIdentificacao = "FUNC1";
		Filial filial = new Filial();
		filial.setNome("Nome da Filial");
		filial.setEndereco("Endereço da Filial");
		filial.setTelefone("Telefone da Filial");
		filial.setEmail("Email da Filial");
		Time horarioFuncionamento = Time.valueOf("09:00:00");
		filial.setHorarioFuncionamento(horarioFuncionamento); 
		
	
		Funcionario funcionario = new Funcionario();
		funcionario.setId(id);
		funcionario.setNomeCompleto(nomeCompleto);
		funcionario.setDataNascimento(dataNascimento);
		funcionario.setCpf(cpf);
		funcionario.setEndereco(endereco);
		funcionario.setTelefone(telefone);
		funcionario.setFilial(filial);
		funcionario.setHorarioDeTrabalho(horarioDeTrabalho);
		funcionario.setCodigoIdentificacao(codigoIdentificacao);
		
		
		when(funcionarioRepositoryMock.findById(id)).thenReturn(Optional.of(funcionario));
		
		Optional<Funcionario> found = funcionarioRepositoryMock.findById(id);
        assertEquals(cpf, found.get().getCpf());
        assertEquals(endereco, found.get().getEndereco());
        assertEquals(telefone, found.get().getTelefone());
        assertEquals(filial, found.get().getFilial());
        assertEquals(horarioDeTrabalho, found.get().getHorarioDeTrabalho());
        assertEquals(codigoIdentificacao, found.get().getCodigoIdentificacao());
        assertEquals(dataNascimento, found.get().getDataNascimento());
		
	}
	
}
