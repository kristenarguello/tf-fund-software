package br.fds.demo.Interface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.fds.demo.Aplicacao.EfetivarOrcamento_UC;
import br.fds.demo.Aplicacao.ListarTodosProdutos_UC;
import br.fds.demo.Aplicacao.SolicitarOrcamentoUC;
import br.fds.demo.Aplicacao.DTOs.OrcamentoDTO;
import br.fds.demo.Aplicacao.DTOs.ProdutoDTO;

@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    private EfetivarOrcamento_UC efetivarOrcamentoUc;

    @Autowired
    private ListarTodosProdutos_UC listarTodosProdutosUc;

    @Autowired 
    private SolicitarOrcamentoUC solicitarOrcamentoUC;

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

    @PostMapping("/solicitar-orcamento")
    @CrossOrigin("*")
    public OrcamentoDTO solicitarOrcamento(long idPedido) {
            return solicitarOrcamentoUC.run(idPedido);
    }


    @GetMapping("/listar-todos-produtos")
    @CrossOrigin("*")
    public List<ProdutoDTO> listarTodosProdutos() {
        return listarTodosProdutosUc.run();
    }

}
