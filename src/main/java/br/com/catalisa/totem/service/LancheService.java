package br.com.catalisa.totem.service;

import br.com.catalisa.totem.model.LancheModel;
import br.com.catalisa.totem.repository.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancheService {

    private final LancheRepository lancheRepository;

    @Autowired
    public LancheService(LancheRepository lancheRepository) {
        this.lancheRepository = lancheRepository;
    }

    public LancheModel criarLanche(LancheModel lanche) {
        System.out.print("""

				[---------------------------------------------]
				[       Lanche Cadastrado com Sucesso!        ]
				[---------------------------------------------]

				""");
        return lancheRepository.save(lanche);
    }

    public void listarLanches() {
        lancheRepository.findAll();
    }

}
