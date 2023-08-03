package br.com.catalisa.totem.repository;

import br.com.catalisa.totem.model.BebidaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaRepository extends JpaRepository<BebidaModel, Long> {
}
