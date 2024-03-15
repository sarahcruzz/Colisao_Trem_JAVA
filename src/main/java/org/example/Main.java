package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // declaração de variáveis
        double posicaoA, posicaoB, velocidadeA, velocidadeB, tempo, posFinalA, posFinalB;
        int confirma;

        // criação do objeto da classe Scanner
        Scanner scanner = new Scanner(System.in);

        // entradas

        do {
            System.out.println("A posição do trem deve estar entre 0KM a 10.000KM");
            System.out.print("Digite a posição inicial do trem A: ");
            posicaoA = scanner.nextDouble();
            System.out.print("Digite a posição inicial do trem B: ");
            posicaoB = scanner.nextDouble();

        } while ((posicaoA < 0 || posicaoA > 10000) && (posicaoB < 0 || posicaoB > 10000));


        do {
            System.out.print("Digite a velocidade do trem A: ");
            velocidadeA = scanner.nextDouble();
            System.out.print("Digite a velocidade do trem B: ");
            velocidadeB = scanner.nextDouble();
        } while ((velocidadeA >= 0 || velocidadeA <= 300 ) && (velocidadeB <= 0 || velocidadeB <= -300 ));


        // processamento
        tempo = (posicaoA - posicaoB) / (velocidadeB - velocidadeA);
        posFinalA = posicaoA + (velocidadeA * tempo);
        posFinalB = posicaoB - (velocidadeB * tempo);

        // saida

    }
}