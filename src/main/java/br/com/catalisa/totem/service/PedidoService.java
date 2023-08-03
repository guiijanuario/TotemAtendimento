package br.com.catalisa.totem.service;

import br.com.catalisa.totem.Exception.ItemNotFoundException;
import br.com.catalisa.totem.Exception.PedidoVazioException;
import br.com.catalisa.totem.model.ItemModel;
import br.com.catalisa.totem.model.ItemPedidoModel;
import br.com.catalisa.totem.model.PedidoModel;
import br.com.catalisa.totem.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;


    public PedidoModel criarPedido(PedidoModel pedido) {
        pedido.setValorTotal(BigDecimal.ZERO);
        return pedidoRepository.save(pedido);
    }

    public PedidoModel buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoVazioException("Pedido não encontrado"));
    }

    public void adicionarItemAoPedido(PedidoModel pedido, ItemModel item, int quantidade) {
        // Verifica se o item já está no pedido
        ItemPedidoModel itemPedidoExistente = pedido.getItensPedidos().stream()
                .filter(itemPedido -> itemPedido.getItem().equals(item))
                .findFirst()
                .orElse(null);

        if (itemPedidoExistente != null) {
            itemPedidoExistente.setQuantidade(itemPedidoExistente.getQuantidade() + quantidade);
        } else {
            ItemPedidoModel novoItemPedido = new ItemPedidoModel();
            novoItemPedido.setPedido(pedido);
            novoItemPedido.setItem(item);
            novoItemPedido.setQuantidade(quantidade);
            novoItemPedido.setValorTotalItem(item.getValor().multiply(BigDecimal.valueOf(quantidade)));

            pedido.getItensPedidos().add(novoItemPedido);
        }

        // Atualiza o valor total do pedido
        BigDecimal valorTotalItem = item.getValor().multiply(BigDecimal.valueOf(quantidade));
        pedido.setValorTotal(pedido.getValorTotal().add(valorTotalItem));

        // Atualiza o pedido no banco de dados
        pedidoRepository.save(pedido);
    }

//    public void removerItemDoPedido(PedidoModel pedido, ItemModel item) {
//        ItemPedidoModel itemPedido = pedido.getItensPedidos().stream()
//                .filter(itemPedido -> itemPedido.getItem().equals(item))
//                .findFirst()
//                .orElseThrow(() -> new ItemNotFoundException("Item não encontrado no pedido"));
//
//        // Atualiza o valor total do pedido
//        BigDecimal valorTotalItem = itemPedido.getValorTotalItem();
//        pedido.setValorTotal(pedido.getValorTotal().subtract(valorTotalItem));
//
//        // Remove o item do pedido
//        pedido.getItensPedidos().remove(itemPedido);
//
//        // Atualiza o pedido no banco de dados
//        pedidoRepository.save(pedido);
//    }
}
