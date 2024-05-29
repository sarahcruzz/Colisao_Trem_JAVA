package org.example;

import java.util.Scanner;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        double posicaoInicialA = 0, posicaoInicailB = 0, velocidadeA = 0, velocidadeB = 0, converterParNegativo = -1;

        double tempo, tremA, tremB, horas, minutos, segundos, tempoSegundos, horarioSaida = 17;

        int resultado;
        boolean executarNovamente = false, correto = false;
        String horario, erroCaracter = "Valor inválio, você digitou caracteres! Tente novamente utilizando números decimais.\n";


        do{

            while(true){
                try{
                    System.out.println("Insira a posição inicial do trem A(Km): ");
                    posicaoInicialA = read.nextDouble();

                    if (posicaoInicialA >=0 && posicaoInicialA <=10000){


                        do{
                            try{
                                correto = false;
                                System.out.println("Insira a posição inicial do trem B(Km): ");
                                posicaoInicailB = read.nextDouble();
                                if (posicaoInicailB < 0 || posicaoInicailB > 10000){
                                    System.out.println("A posição do trem deve estar entre 0km á 10000km");
                                }else{
                                    correto = true;
                                }
                            }catch (InputMismatchException e){
                                System.out.println(erroCaracter);
                            }
                            read.nextLine();
                        }while (!correto);

                        do{
                            try{
                                correto = false;
                                System.out.println("Insira a velocidade do trem A (Km/h): ");
                                velocidadeA = read.nextDouble();

                                if (velocidadeA < 0 || velocidadeA > 300){
                                    System.out.println("A velocidade do trem A, deve ser sempre positiva e estar entre 0km/h á 300km/h");
                                }else{
                                    correto = true;
                                }
                            }catch (InputMismatchException e){
                                System.out.println(erroCaracter);
                            }
                            read.nextLine();

                        }while (!correto);

                        do {
                            try{
                                correto = false;
                                System.out.print("Insira a velocidade do trem B (Km/h): ");
                                velocidadeB = read.nextDouble();
                                if (velocidadeB < 0 || velocidadeB > 300){
                                    System.out.println("A velocidade do trem B, deve estar entre 0km/h á 300km/h");
                                }else{
                                    correto = true;
                                }
                            }catch (InputMismatchException e){
                                System.out.println(erroCaracter);
                            }
                            read.nextLine();
                        }while (!correto);

                        break;
                    }
                    System.out.println("A posição do trem deve estar entre 0km á 10000km");
                    continue;

                } catch (InputMismatchException e){
                    System.out.println(erroCaracter);
                }
                read.nextLine();
            }

            tempo = (posicaoInicialA - (posicaoInicailB * converterParNegativo)) / (velocidadeB - velocidadeA);
            tempoSegundos  = (tempo*60)*60;
            tremA = posicaoInicialA + (velocidadeA * tempo);
            tremB = posicaoInicailB + (velocidadeB * tempo);

            // hora 00:00:00
            tempo = horarioSaida + tempo;
            horas = tempo %60;
            minutos = (tempo*60) %60;
            segundos = (tempo/60) %60;

            horario = String.format("%02.0f:%02.0f:%02.0f", horas,  minutos, segundos);

            if (posicaoInicialA == posicaoInicailB) {
                System.out.println("A colisão de trens já ocorreu!!!");

            }else if (velocidadeA == 0 && velocidadeB == 0) {
                System.out.println("A colisão de trens não ocorreu!!!");

            }else if (posicaoInicialA > posicaoInicailB) {
                System.out.println("A colisão de trens não ocorreu!!!");

            }else if(tremA == tremB){
                System.out.printf("\nA colisão de trens acontecerá no Km %.2f e ocorrerá após %.2f segundos no horário de %sh",
                        tremA, tempoSegundos, horario);
            }

            System.out.println("\nVocê deseja executar o programa novamente?\n1 - Sim\n2 - Não");
            resultado = read.nextInt();

            switch (resultado){
                case 1:
                    continue;
                case 2:
                    executarNovamente = true;
            }

        }while (!executarNovamente);

        System.out.println("Ok, muito obrigada por usar o programa de Colisão de Trens!\nVolte sempre!");
    }
}