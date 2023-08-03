package br.com.catalisa.totem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_itens_pedido")
@Getter
@Setter
public class ItemPedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private PedidoModel pedido;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemModel item;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "valor_total_item")
    private BigDecimal valorTotalItem;
}
