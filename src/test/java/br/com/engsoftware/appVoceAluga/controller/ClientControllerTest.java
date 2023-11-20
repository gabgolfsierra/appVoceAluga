package br.com.engsoftware.appVoceAluga.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.engsoftware.appVoceAluga.domain.Client;
import br.com.engsoftware.appVoceAluga.repository.ClientRepository;




@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {

    @Mock
    private MockMvc mockMvc;

    @MockBean
    private ClientRepository clientRepository;

    @Test
    public void testCadastrarClient() throws Exception {
        // Criação de um cliente de teste
        Client novoCliente = new Client();
        novoCliente.setNomeCompleto("Fulano Teste");
        novoCliente.setDataNascimento("1990-01-01");
        novoCliente.setCpf("12345678900");
        novoCliente.setEndereco("Endereço Teste");
        novoCliente.setNumeroTelefone("123456789");

                
    }

    @Test
    public void testGetAllClients() throws Exception {
        // Criação de um cliente de teste
        Client clienteTeste = new Client();
        clienteTeste.setNomeCompleto("Cliente de Teste");

                
    }

    // Método auxiliar para converter um objeto em formato JSON
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}