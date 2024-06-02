package aulajogo;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class MenuJogo {
	
	private static Heroi heroi;
	private static List<Criatura> criaturas;
	private static List<String> jogadores;
	private static int turno = 0;
	
	public static void main(String[] args) {
	 
	 	Scanner sc = new Scanner(System.in);
	 	
	 	int escolha;
	 	
	 	while (true){
	 		System.out.println("\n------------------ Curse Slayer----------------------");
	 		System.out.println("1----------------- INICIAR GAME----------------------");
	 		System.out.println("2 ------------- QUEM JOGOU O GAME--------------------");
	 		System.out.println("3--------------------- EXIT -------------------------");
	 		escolha = sc.nextInt();
	 		
	 		switch (escolha) {
	 			case 1:
	 				novoJogo();
	 				break;
	 			case 2:
	 				mostrarJogadores();
	 				break;
	 			case 3:
	 				System.out.println("----------Saindo do jogo---------");
	 				System.exit(0);
	 				break;
	 			default:
	 				System.out.println("----------Escolha inválida!-------");
	 				break;
	 		}
	 	}
	}
	
	private static void mostrarJogadores() {
		System.out.println ("Jogadores: \n");
		System.out.println ( heroi.nome);
		
	}

	public static void novoJogo() {
	 	Scanner sc = new Scanner(System.in);

		System.out.println("Qual seu nome Feiticeiro? ");
		String nome = sc.nextLine();
	    heroi = new Heroi (100, nome, 10, 5) ;
	    
	    criaturas = new ArrayList<>();
		criaturas.add (new Criatura(50 , "Jogo", 15, 3 ));
	    criaturas.add (new Criatura(60 , "Mahito", 15, 3 ));
	    criaturas.add (new Criatura(70 , "Mahoraga", 15, 3 ));
		criaturas.add (new Criatura(80 , "Sukuna", 15, 3 ));
	    
	    while (heroi.getVida() > 0 && !criaturas.isEmpty()) {
			System.out.print("\033[2J");
			Criatura criaturaAtual = criaturas.get(0);
			System.out.println ("\n Nome: " + heroi.nome + "	Vida: " + heroi.getVida());
	    	System.out.println ("Maldição: "  + criaturaAtual.nome  + "	Vida: " + criaturaAtual.vida + "\n");
	    	System.out.println ("Escolha uma opção: ");
	    	System.out.println ("1 - Ataque ");
	    	System.out.println ("2 - Defesa ");
	    	System.out.println ("3 - Curar  \n");
	    	
	    	int acaojogo = sc.nextInt();

			Random random = new Random();
			int valorAleatorio = random.nextInt(1 , 3 );
	    	int acaoCriatura = valorAleatorio;
	    	
	    	
	    	switch (acaojogo) {
	        case 1:
				System.out.print("\033[2J");

				int danoHeroi = heroi.FuncaoAtacar();
	                criaturaAtual.vida -= danoHeroi;
	                System.out.println("Você causou na Maldição " + danoHeroi + " de dano na Maldição " + criaturaAtual.nome + "... ");
				if (acaoCriatura == 1 && criaturaAtual.vida >0) {
					int danoCriatura = criaturas.get(0).FuncaoAtacar();
					heroi.vida -= danoCriatura;
					System.out.println("A maldição causou " + danoCriatura + " de dano e você");
				}
				if (acaoCriatura == 2) {
					criaturaAtual.funcaoDefender(danoHeroi);
					System.out.println("A maldição defendeu seu ataque :(");
				}
	                if (criaturaAtual.vida <= 0) {
						System.out.print("\033[2J");
	                	 System.out.println("Você derrotou a Maldição " + criaturaAtual.nome + " !!\n");
	                	 criaturas.remove(criaturaAtual);
						 Heroi.pocao ++;
						System.out.println("Você ganhou uma poção!");

					}
	               

	            break;
	            
	        case 2:
				System.out.print("\033[2J");

				if (acaoCriatura == 1) {
	        		int danoCriatura = criaturas.get(0).FuncaoAtacar();

					System.out.println ("Voce bloqueou " + danoCriatura + " de dano da maldição!");
	        	}if (acaoCriatura == 2) {

				System.out.println ("Você e a Maldição se defenderam");
	        	}
	        	break;
	        	
	        case 3:
				System.out.print("\033[2J");

				heroi.usarPocao();

				if (acaoCriatura == 1) {
					int danoCriatura = criaturas.get(0).FuncaoAtacar();
					heroi.vida -= danoCriatura;
					System.out.println("A maldição causou " + danoCriatura + " de dano e você");
				}
				if (acaoCriatura == 2) {
					System.out.println("A maldição tentou se defender:)");
				}
	        	break;
	        	
	        	default:
	        	
	        	System.out.println ("Opção não e Valida. Escolha novamente ");
	    	
	    	}
	      	
	    	
	    }
	    
	    if (criaturas.isEmpty()) {
	    	
	    	System.out.println ("Bom trabalho jovem feiticeiro você derrotou todas as Maldições!!!!");
	    } else if (heroi.getVida()<=0) {
	    	System.out.println ("Jovem mestre você foi derrotado pelas Maldições!!!!");
	    }
	   
	    
	}
	

}