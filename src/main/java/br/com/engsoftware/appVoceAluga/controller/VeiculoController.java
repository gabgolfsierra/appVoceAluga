package br.com.engsoftware.appVoceAluga.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.com.engsoftware.appVoceAluga.domain.Veiculo;
import br.com.engsoftware.appVoceAluga.repository.VeiculoRepository;

import java.util.List;

@Controller
@RequestMapping("/veiculos") 
public class VeiculoController {

    private final VeiculoRepository veiculoRepository;

    @Autowired
    public VeiculoController(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    // Endpoint para listar todos os veículos
    @GetMapping("/")
    public String listarVeiculos(Model model) {
        List<Veiculo> veiculos = veiculoRepository.findAll();
        model.addAttribute("veiculos", veiculos);
        return "listaveiculos"; // Nome da página HTML que lista os veículos
    }

    // Endpoint para exibir formulário de cadastro de veículos
    @GetMapping("/cadastrar")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("veiculo", new Veiculo());
        return "cadastrarveiculo"; // Nome da página HTML do formulário de cadastro
    }

    
    @PostMapping("/cadastrar")
    public String cadastrarVeiculo(@ModelAttribute Veiculo novoVeiculo) {
        veiculoRepository.save(novoVeiculo);
        return "redirect:/veiculos/"; 
    }

    
}
