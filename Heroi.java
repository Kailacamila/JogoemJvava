package aulajogo;

import java.util.Random;

public class Heroi  extends Atributos{
    static int pocao;
    public Heroi(int vida, String nome, int ataque, int defesa) {
        this.vida = vida;
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
    }

	public int getVida() {
		
		return vida;	
	}

    public int FuncaoAtacar() {

        Random random = new Random();
        int valorAleatorio = random.nextInt(8 , 15 );

        ataque = valorAleatorio;


        return ataque;
    }

    public void funcaoDefender(int danoMitigado){
        vida -= danoMitigado;
        vida += danoMitigado;
    }

    public void usarPocao(){
        if (pocao > 0){
            vida += 50;
            System.out.println("Você curou 50 pontos de vida!");
            if (vida > 100) {
                vida = 100;

            }
            pocao --;
        }else{
            System.out.println("Você nao tem poções disponiveis no momento, derrote uma maldição para conseguir");
        }
    }
}
