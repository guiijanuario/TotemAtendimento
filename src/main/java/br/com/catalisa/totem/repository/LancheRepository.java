package br.com.catalisa.totem.repository;

import br.com.catalisa.totem.model.LancheModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancheRepository extends JpaRepository<LancheModel, Long> {
}
