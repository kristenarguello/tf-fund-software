package br.fds.demo.Interface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fds.demo.Aplicacao.SolicitarPedidoUC;
import br.fds.demo.Aplicacao.DTOs.ItemPedidoDTO;
import br.fds.demo.Aplicacao.DTOs.PedidoDTO;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private SolicitarPedidoUC solicitarPedidoUC;

    @PostMapping("/gerar")
    @CrossOrigin("*")
    public PedidoDTO solicitarOrcamento(List<ItemPedidoDTO> itens, long idCliente) {
        return solicitarPedidoUC.run(itens, idCliente);
    }

}
