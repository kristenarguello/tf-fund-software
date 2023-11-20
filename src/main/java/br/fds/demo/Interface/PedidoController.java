package br.fds.demo.Interface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.fds.demo.Aplicacao.SolicitarPedidoUC;
import br.fds.demo.Aplicacao.DTOs.ItemPedidoDTO;
import br.fds.demo.Aplicacao.DTOs.PedidoDTO;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private SolicitarPedidoUC solicitarPedidoUC;

    @PostMapping("/gerar")
    @CrossOrigin("*")
    public PedidoDTO solicitarPedido(@RequestBody List<ItemPedidoDTO> itens, @RequestParam long idCliente) {
        return solicitarPedidoUC.run(itens, idCliente);
    }

}