package aulajogo;

import java.awt.*;
import java.util.Random;

public class Criatura extends Atributos{
	
    public Criatura(int vida, String nome, int ataque, int defesa) {
        this.vida = vida;
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public int FuncaoAtacar() {

        Random random = new Random();
        int valorAleatorio = random.nextInt(5 , 16);

        ataque = valorAleatorio;


        return ataque;
    }

    public void funcaoDefender(int danoMitigado){
        vida -= danoMitigado;
        vida += danoMitigado;
    }

}
