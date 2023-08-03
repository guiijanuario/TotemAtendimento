package br.com.catalisa.totem.repository;

import br.com.catalisa.totem.model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {

    @Query(value = "SELECT p FROM PedidoModel p ORDER BY p.id DESC")
    PedidoModel findLastPedido();
}
