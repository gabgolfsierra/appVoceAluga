package br.com.engsoftware.appVoceAluga.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.engsoftware.appVoceAluga.domain.Veiculo;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class VeiculoRepositoryTest {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Test
    public void testFindByMarca() {
        
        Veiculo veiculo = new Veiculo();
        veiculo.setMarca("Nissan");
        veiculo.setModelo("GT-R");
        veiculo.setAno(1998);
        veiculo.setPlaca("BRAIA123");
        veiculo.setCor("AZUL");
        veiculo.setTipo("SEDAN");

        
        veiculoRepository.save(veiculo);

        
        List<Veiculo> veiculosEncontrados = veiculoRepository.findByMarca("TesteMarca");

        
        assertEquals(1, veiculosEncontrados.size());
        Veiculo veiculoEncontrado = veiculosEncontrados.get(0);
        assertEquals("TesteMarca", veiculoEncontrado.getMarca());
        assertEquals("TesteModelo", veiculoEncontrado.getModelo());
        assertEquals(2022, veiculoEncontrado.getAno());
        assertEquals("TEST1234", veiculoEncontrado.getPlaca());
        assertEquals("Preto", veiculoEncontrado.getCor());
        assertEquals("SUV", veiculoEncontrado.getTipo());
    }
}
