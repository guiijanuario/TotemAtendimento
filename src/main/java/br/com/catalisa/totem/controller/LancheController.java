package br.com.catalisa.totem.controller;

import br.com.catalisa.totem.model.LancheModel;
import br.com.catalisa.totem.repository.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Scanner;

@RestController
@RequestMapping("/lanche")
public class LancheController {

    private final LancheRepository lancheRepository;

    @Autowired
    public LancheController(LancheRepository lancheRepository) {
        this.lancheRepository = lancheRepository;
    }

    public LancheModel criarLanche() {

        System.out.print("Digite o nome do lanche: ");
        String nome = new Scanner(System.in).nextLine();
        System.out.print("Digite o valor do lanche: ");
        BigDecimal valor = new Scanner(System.in).nextBigDecimal();

        // Crie uma nova instância de LancheModel com os dados recebidos do Scanner
        LancheModel novoLanche = new LancheModel();
        novoLanche.setNome(nome);
        novoLanche.setValor(valor);

        // Salve o novo lanche no repositório
        LancheModel lancheSalvo = lancheRepository.save(novoLanche);

        ResponseEntity.ok(lancheSalvo);

        return novoLanche;
    }





}
