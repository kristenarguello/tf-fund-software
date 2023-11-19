package br.fds.demo.Interface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.fds.demo.Aplicacao.EfetivarOrcamento_UC;

@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    private EfetivarOrcamento_UC efetivarOrcamentoUc;

    @PatchMapping("/efetivar-orcamento")
    @CrossOrigin("*")
    public ResponseEntity<String> efetivarOrcamento(long idOrcamento) {
        System.out.println(idOrcamento);
        try {
            efetivarOrcamentoUc.run(idOrcamento);
            return ResponseEntity.ok("Orçamento efetivado com sucesso!");
        }
        catch (ResponseStatusException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
        }
    }
}
