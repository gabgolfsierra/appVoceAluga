package br.com.engsoftware.appVoceAluga.repository;



import br.com.engsoftware.appVoceAluga.domain.Client;



import java.text.ParseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ClientRepositoryTest {

    @Mock
    private ClientRepository clientRepository;

    @Test
    public void testSalvarClient() throws ParseException {
        String dataNascimento = ("2003-03-02");

        // Criando um novo cliente com atributos específicos de teste
        Client client = new Client();
            client.setId(null);
            client.setNomeCompleto("H. Romeu Pinto");
            client.setDataNascimento(dataNascimento);
            client.setCpf("123.456.789-00");
            client.setEndereco("Rua Teste, 123");
            client.setNumeroTelefone("1234567890"); 
        

        clientRepository.save(client);
        
        
    }
}