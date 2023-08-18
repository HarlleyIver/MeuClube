package clube;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import clube.controller.ClubeController;
import clube.model.Clube;
import clube.model.Inteira;
import clube.model.MeiaEntrada;
import clube.util.Cores;

public class Menu {
	
	public static Scanner leia = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ClubeController ingresso = new ClubeController();
		
		int opcao, id, tipo;
		String time1, time2, estadio, data, hora;
		float valor;
		
		
		while (true) {
			System.out.println(Cores.TEXT_RED + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                    MEU CLUBE                        ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Adicionar Ingresso                   ");
			System.out.println("            2 - Listar todos os Ingressos            ");
			System.out.println("            3 - Buscar Ingresso por Número	         ");
			System.out.println("            4 - Atualizar Dados do Ingresso          ");
			System.out.println("            5 - Apagar Ingresso                      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
			}catch(InputMismatchException e){
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao=0;
			}

			if (opcao == 9) {
				System.out.println("\nMEU CLUBE - Torça com a gente!");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println("Adicionar Ingresso\n");
					System.out.println("\nInsira o primeiro time: ");
					leia.skip("\\R");
					time1=leia.nextLine();
					System.out.println("Insira o time visitante: ");
					time2=leia.nextLine();
					System.out.println("Insira o Estádio: ");
					estadio=leia.nextLine();
				do {
					System.out.println("Insira tipo do Ingresso:(1 - Inteira ou 2 - Meia Entrada): ");
					tipo=leia.nextInt();
				}while(tipo < 1 && tipo > 2);
					
					System.out.println("Insira a data do jogo: ");
					leia.skip("\\R");
					data=leia.nextLine();
					System.out.println("Insira o horário do jogo: ");
					hora=leia.nextLine();
			
			switch(tipo) {
				case 1 ->{
					System.out.println("Insira o Valor Inteiro: ");
					valor = leia.nextFloat();
					ingresso.cadastrar(new Inteira(ingresso.incrementoId(), time1, time2, estadio, tipo, data, hora, valor));
				}
				case 2 -> {
					System.out.println("Insira o Valor da Meia - Entrada: ");
					valor = leia.nextFloat();
					ingresso.cadastrar(new MeiaEntrada(ingresso.incrementoId(), time1, time2, estadio, tipo, data, hora, valor));
				}
			}
					keyPress();
					break;
				case 2:
					System.out.println("Listar todos os Ingressos\n\n");
					ingresso.listarTodas();
					keyPress();
					break;
				case 3:
					System.out.println("Buscar dados do Ingresso por número\n\n");
					int num = 1;
					System.out.println("Insira o Número do Ingresso: ");
					id = leia.nextInt();
					ingresso.procurarPorId(id);
					keyPress();
					break;
				case 4:
					System.out.println("Atualizar dados do Ingresso\n\n");
					System.out.println("Insira o Número do Ingresso: ");
					id = leia.nextInt();
					ingresso.procurarPorId(id);
					if (ingresso.buscarPorId(id) != null){
						System.out.println("\nInsira o primeiro time: ");
						leia.skip("\\R");
						time1=leia.nextLine();
						System.out.println("Insira o time visitante: ");
						time2=leia.nextLine();
						System.out.println("Insira o Estádio: ");
						estadio=leia.nextLine();
						do {
							System.out.println("Insira tipo do Ingresso:(1 - Inteira ou 2 - Meia Entrada): ");
							tipo=leia.nextInt();
						}while(tipo < 1 && tipo > 2);

						System.out.println("Insira a data do jogo: ");
						leia.skip("\\R");
						data=leia.nextLine();
						System.out.println("Insira o horário do jogo: ");
						hora=leia.nextLine();
						tipo = ingresso.retornatipo(id);
						switch(tipo) {
							case 1 ->{
								System.out.println("Insira o Valor Inteiro: ");
								valor = leia.nextFloat();
								ingresso.atualizar(new Inteira(id, time1, time2, estadio, tipo, data, hora, valor));
							}
							case 2 -> {
								System.out.println("Insira o Valor da Meia - Entrada: ");
								valor = leia.nextFloat();
								ingresso.atualizar(new MeiaEntrada(id, time1, time2, estadio, tipo, data, hora, valor));
							}
						}
					}

					keyPress();
					break;
				case 5:
					System.out.println("Apagar Ingresso\n\n");
					System.out.println("Digite o número da conta: ");
					id = leia.nextInt();

					ingresso.deletar(id);
					keyPress();
					break;
			 
				default:
					System.out.println("\nOpção Inválida!\n");
					keyPress();
					break;
			 }

		}
		
	}	

	public static void keyPress() {

	try {

		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
		System.in.read();

	} catch (IOException e) {

		System.out.println("Você pressionou uma tecla diferente de enter!");

	}
 }

}
