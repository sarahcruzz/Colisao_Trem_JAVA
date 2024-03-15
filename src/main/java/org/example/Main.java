package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // declaração de variáveis
        double posicaoA, posicaoB, velocidadeA, velocidadeB, tempo, posColisao, posFinalA, posFinalB;

        // criação do objeto da classe Scanner
        Scanner scanner = new Scanner(System.in);

        // entradas

        do {
            System.out.print("Digite a posição inicial do trem A: ");
            posicaoA = scanner.nextDouble();
            System.out.print("Digite a posição inicial do trem B: ");
            posicaoB = scanner.nextDouble();

        } while ((posicaoA < 0 || posicaoA > 10000) && (posicaoB < 0 || posicaoB > 10000));



        System.out.print("Digite a velocidade do trem A: ");
        velocidadeA = scanner.nextDouble();

        System.out.print("Digite a velocidade do trem B: ");
        velocidadeB = scanner.nextDouble();

        // processamento
        tempo = (posicaoA - posicaoB) / (velocidadeB - velocidadeA);
        posFinalA = posicaoA + (velocidadeA * tempo);
        posFinalB = posicaoB + (velocidadeB * tempo);

        // saida
    }
}