package br.com.catalisa.totem;

import br.com.catalisa.totem.controller.BebidaController;
import br.com.catalisa.totem.controller.LancheController;
import br.com.catalisa.totem.controller.PedidoController;
import br.com.catalisa.totem.model.PedidoModel;
import br.com.catalisa.totem.service.LancheService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Scanner;

@SpringBootApplication
public class TotemApplication {

	@Autowired
	LancheController lancheController;
	BebidaController bebidaController;

	PedidoController pedidoController;

	LancheService lancheService;

	public static void main(String[] args) {
		SpringApplication.run(TotemApplication.class, args);
	}



	@PostConstruct
	private void init() {

		Scanner scanner = new Scanner(System.in);

		System.out.print("""

				[---------------------------------------------]
				[ Olá seja bem vindo ao totem de atendimento! ]
				[---------------------------------------------]

				""");
		System.out.print("Informe o nome do cliente: ");
		String cliente = new Scanner(System.in).nextLine();

		System.out.print("Informe o codigo do pedido: ");
		int nroPedido = new Scanner(System.in).nextInt();

		PedidoModel pedido = new PedidoModel();
		pedido.setCliente(cliente);
		pedido.setNroPedido(nroPedido);

		boolean continuar = true;
		while (continuar) {
			System.out.print("""
					[----------------------------]
					[ 1 - Lanche                 ]
					[ 2 - Bebida                 ]
					[ 3 - Cadastrar Itens        ]
					[ 4 - Finalizar pedido       ]
					[ 0 - Sair                   ]
					[----------------------------]
					->\s""");
			int opcao = scanner.nextInt();

			switch (opcao) {
				case 1:
					lancheService.listarLanches();
					break;
				case 2:
					// Lógica para adicionar lanche ao pedido
					break;
				case 3:
					boolean continuarMenuCriar = true;
					while (continuarMenuCriar) {

						System.out.print("""

				[---------------------------------------------]
				[               Cadastrar Itens               ]
				[---------------------------------------------]

				""");

						System.out.print("""
					[----------------------------]
					[ 1 - Lanche                 ]
					[ 2 - Bebida                 ]
					[ 0 - Sair                   ]
					[----------------------------]
					->\s""");

						int opcaoCriarItem = scanner.nextInt();
						scanner.nextLine(); // Consumir a quebra de linha

						switch (opcaoCriarItem) {
							case 1:
								lancheController.criarLanche();
								break;
							case 2:
								bebidaController.criarBebida();
								break;
							case 0:
								continuarMenuCriar = false;
								break;

							default:
								System.out.println("Opção inválida. Tente novamente.");
						}
					}
					break;
				case 4:
					continuar = false;
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
			}
		}





	}
}
