package br.com.catalisa.totem.service;

import br.com.catalisa.totem.model.BebidaModel;
import br.com.catalisa.totem.model.LancheModel;
import br.com.catalisa.totem.repository.BebidaRepository;
import br.com.catalisa.totem.repository.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BebidaService {
    private final BebidaRepository bebidaRepository;

    @Autowired
    public BebidaService(BebidaRepository bebidaRepository) {
        this.bebidaRepository = bebidaRepository;
    }

    public BebidaModel criarBebida(BebidaModel bebida) {
        System.out.print("""

				[---------------------------------------------]
				[       Lanche Cadastrado com Sucesso!        ]
				[---------------------------------------------]

				""");
        return bebidaRepository.save(bebida);
    }
}
