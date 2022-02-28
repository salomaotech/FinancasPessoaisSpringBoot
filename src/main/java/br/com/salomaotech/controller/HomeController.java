package br.com.salomaotech.controller;

import br.com.salomaotech.model.Cadastro;
import br.com.salomaotech.model.FormataDataParaBrasileiro;
import br.com.salomaotech.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    CadastroRepository cadastroRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/cadastro-form")
    public String cadastroForm() {
        return "cadastro-form";
    }

    @GetMapping("/lista-resultados")
    public String listaResultados() {
        return "lista-resultados";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Cadastro cadastro) {

        /* formata a data para brasileiro */
        cadastro.setData(FormataDataParaBrasileiro.formatar(cadastro.getData()));

        /* salva */
        this.cadastroRepository.save(cadastro);

        /* redireciona */
        return "redirect:/lista-resultados";
    }

}
