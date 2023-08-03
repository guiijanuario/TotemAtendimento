package br.com.catalisa.totem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "tb_pedidos")
@Getter
@Setter
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cliente")
    private String cliente;

    @Column(name = "nro_pedido")
    private int nroPedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedidoModel> itensPedidos = new ArrayList<>();

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

}
