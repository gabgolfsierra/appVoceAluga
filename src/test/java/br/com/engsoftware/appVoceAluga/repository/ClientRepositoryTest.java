package br.com.engsoftware.appVoceAluga.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.engsoftware.appVoceAluga.domain.Client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.Test;

@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void testSalvarClient() throws ParseException {
        // Fazendo isso pra converter do tipo Date 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dataNascimento = (Date) sdf.parse("2003-03-02");

        // Criando um novo cliente com atributos específicos de teste
        Client client = new Client(
            null, // id vai gerar automaticamente
            "H. Romeu Pinto",
            dataNascimento,
            "123.456.789-00",
            "Rua Teste, 123",
            "1234567890" // telefone
        );

        clientRepository.save(client);
        
        assertNotNull(client.getId()); // Vendo se o Id foi gerado
    }
}