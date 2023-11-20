package br.com.engsoftware.appVoceAluga.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



import br.com.engsoftware.appVoceAluga.domain.Veiculo;




@ExtendWith(MockitoExtension.class)
public class VeiculoRepositoryTest {

    @Mock
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

        
        

        
        
    }
}
