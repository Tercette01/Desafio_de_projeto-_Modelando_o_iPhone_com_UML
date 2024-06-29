package edu.DIO.model.telefone.fazerLigacao;

import java.util.Random;
import java.util.Scanner;

import edu.DIO.model.telefone.arquivoSistema.adicionarContato;

public class realizarLigacao {
    
    //Aqui vamos chamar o scanner, para pegar o que o usuário coloca no terminal
    private Scanner scanner = new Scanner(System.in);

    //Aqui é para criar a classe random (que é tipo de um solteador no Java)
    private Random random = new Random();

    public void efetuarLigacao(String contato) throws InterruptedException {
        //Aqui vamos criar uma variavel de controle para o nosso while (que vai ser para ver se o usuário quer encerrar ligação, ou efetuar de novo a ligação caso se o contato não atendeu)
        //Como o nome é continuar ligação, vamos deixar no true mesmo
        boolean continuarLigacao = true;

        //Aqui é nosso while da ligação (como foi dito na variavel continuarLigacao)
        while(continuarLigacao == true){

            //Aqui é para mostrar para o nosso usuário que a ligação está ocorrendo
            System.out.println("\n \nLigando...");

            //Aqui vamos colocar uma variavel que vai soltear um valor de 0 á 10, sendo que quando for 0, 4 ou 8 (o contato atendeu)
            int contatoAtendeu = random.nextInt(11);

            if((contatoAtendeu == 0) || (contatoAtendeu == 4) || (contatoAtendeu == 8)){

                //Se o nosso contato atendeu, vamos colocar para o nosso sistema exibir o nome do usuário
                System.out.println("\n \n");
                System.out.println("            " + contato);
                System.out.println("\n \n");
                System.out.println("Digite enter para continuar (se não aprecer 'Deseja encerrar a chamada?')");

                //Esse comando serve para limpar os espaços deixados pelo nextInt() no terminal
                scanner.nextLine();

                //Agora vamos colocar algo que pergunte ao usuário se deseja encerrar a ligação
                System.out.println("Deseja encerrar a chamada?");
                System.out.print("(digite encerrar ou aperte qualquer tecla) ");
                String RespostaEncerrar = scanner.nextLine();

                //Agora vamos entrar no if, para que a chamada seja encerrada
                if(RespostaEncerrar.equals("encerrar")){

                    //aqui vai ser colocado o comando para encerrar a chamada
                    System.out.println("\n \nEncerrando ligação...\n \n");
                    Thread.sleep(5000);
                    System.out.println("Ligação encerrada, voltando para a tela do telefone!\n \n");
                    Thread.sleep(5000);
                    continuarLigacao = false;

                } else{

                    //O senão também vai fazer a mesma coisa que o 'if'
                    System.out.println("\n \nEncerrando ligação...\n \n");
                    Thread.sleep(5000);
                    System.out.println("Ligação encerrada, voltando para a tela do telefone!");
                    Thread.sleep(5000);
                    continuarLigacao = false;

                }

            } else {
                //Aqui vai ser para caso o nosso contato não tenha atendido

                //Agora vamos criar uma variavel controle que vai checar se a resposta que o usuário inseriu está dentro dos parametros (vamos incia-la como falso)
                boolean respostaCheck = false;

                //Agora vamos criar o while que vai verificar a resposta inserida pelo usuário
                while(respostaCheck == false){

                    //Aqui vamos saber se usuário deseja refazer a ligação
                    System.out.println("\n \nSe desejar ligar novamente digite 1, porém se");
                    System.out.println("deseja voltar para tela do telefone digite 2");
                    System.out.print("Digite aqui a resposta: ");
                    int respostaDeRefazerLigacao = scanner.nextInt();

                    //Agora vamos dar uma olhada nas resposta que o usuário colocou
                    if(respostaDeRefazerLigacao == 1){
                        //Não vamos colocar nada (somente para sair do enquanto), pois o while vai reeniciar sozinho e vai fazer a ligação novamente
                        respostaCheck = true;
                    
                    } else if (respostaDeRefazerLigacao == 2){
                        //Aqui vamos colocar para usuário voltar para a tela do telefone
                        System.out.println("Voltando para a tela do telefone! \n \n");
                        Thread.sleep(5000);
                        respostaCheck = true;
                        continuarLigacao = false;

                    } else {
                        //Aqui vamos colocar o bloco de código para caso o usuário tenha digitado a resposta de maneira errada
                        System.out.println("Número inserido incorretamente, se atente a resposta");

                    }
                }
            }
        }
    }

    //Agora vamos efetuar uma ligação a partir de um número telefonico
    public void Discagem(String numeroTelefonico) throws InterruptedException {

        //Aqui vamos criar uma variavel de controle para o nosso while (que vai ser para ver se o usuário quer encerrar ligação, ou efetuar de novo a ligação caso se o contato não atendeu)
        //Como o nome é continuar ligação, vamos deixar no true mesmo
        boolean continuarLigacao = true;

        //Aqui é nosso while da ligação (como foi dito na variavel continuarLigacao)
        while(continuarLigacao == true){

            //Aqui é para mostrar para o nosso usuário que a ligação está ocorrendo
            System.out.println("\n \nLigando...");

            //Aqui vamos colocar uma variavel que vai soltear um valor de 0 á 10, sendo que quando for 0, 4 ou 8 (o contato atendeu)
            int contatoAtendeu = random.nextInt(11);

            if((contatoAtendeu == 0) || (contatoAtendeu == 4) || (contatoAtendeu == 8)){

                //Se o nosso contato atendeu, vamos colocar para o nosso sistema exibir o nome do usuário
                System.out.println("\n \n \n \n");
                System.out.println("    Ligando para: " + numeroTelefonico);
                System.out.println("\n \n");
                System.out.println("Digite enter para continuar (se não aprecer 'Deseja encerrar a chamada?')");

                //Esse comando serve para limpar os espaços deixados pelo nextInt() no terminal
                scanner.nextLine();

                //Agora vamos colocar algo que pergunte ao usuário se deseja encerrar a ligação
                System.out.println("\nDeseja encerrar a chamada?");
                System.out.print("(digite encerrar ou aperte qualquer tecla) ");
                String RespostaEncerrar = scanner.nextLine();

                //Agora vamos entrar no if, para que a chamada seja encerrada
                if(RespostaEncerrar.equals("encerrar")){

                    //aqui vai ser colocado o comando para encerrar a chamada
                    System.out.println("\n \nEncerrando ligação...\n \n");
                    Thread.sleep(5000);
                    System.out.println("Ligação encerrada, mas antes de voltar a tela inicial");

                    //Antes de sabermos se o usuário vai querer salvar o número ou não, vamos criar uma variavel de controle para o nosso while (que vai ser inicializada como false)
                    boolean respostaAdicionarNovoContatoCheck = false;

                    //Agora vamos dar start ao nosso while para ele verificar se o usuário digitou a resposta corretamente
                    while(respostaAdicionarNovoContatoCheck == false){

                        //Perguntando se o usuário deseja salvar o número discado como um novo usuário
                        System.out.println("Você deseja salvar o número de telefone como um novo usuário? ");
                        System.out.print("(digite s/n) ");
                        String respostaAdicionarNovoContato = scanner.nextLine();

                        if(respostaAdicionarNovoContato.equals("s")){
                            //Aqui vamos inserir o número discado como um novo usuário
                            System.out.println("\n \nRedirecinando para a tela de salvar novo contato...");
                            Thread.sleep(6000);

                            //Indo para a tela adicionar um novo contato
                            adicionarContato adicionarDiscagem = new adicionarContato();
                            adicionarDiscagem.adicionar(Integer.valueOf(numeroTelefonico));
                            respostaAdicionarNovoContatoCheck = true;

                        }else if(respostaAdicionarNovoContato.equals("n")){
                            //Aqui é para quando o usuário não quer adicionar o número discado
                            System.out.println("\nVoltando para a tela do telefone!");
                            Thread.sleep(5000);
                            respostaAdicionarNovoContatoCheck = true;
                            continuarLigacao = false;

                        } else {
                            //Para caso o usuário não tenha inserido a resposta corretamente
                            System.out.println("\nA resposta está fora dos parâmetros do sistema");
                            System.out.println("para que o sistema não caí, vamos reiniciar a pergunta");
                        }
                    }

                } else{

                    //aqui vai ser colocado o comando para encerrar a chamada
                    System.out.println("\n \nEncerrando ligação...\n \n");
                    Thread.sleep(5000);
                    System.out.println("Ligação encerrada, mas antes de voltar a tela inicial");

                    //Antes de sabermos se o usuário vai querer salvar o número ou não, vamos criar uma variavel de controle para o nosso while (que vai ser inicializada como false)
                    boolean respostaAdicionarNovoContatoCheck = false;

                    //Agora vamos dar start ao nosso while para ele verificar se o usuário digitou a resposta corretamente
                    while(respostaAdicionarNovoContatoCheck == false){

                        //Perguntando se o usuário deseja salvar o número discado como um novo usuário
                        System.out.println("Você deseja salvar o número de telefone como um novo usuário? ");
                        System.out.print("(digite s/n) ");
                        String respostaAdicionarNovoContato = scanner.nextLine();

                        if(respostaAdicionarNovoContato.equals("s")){
                            //Aqui vamos inserir o número discado como um novo usuário
                            System.out.println("\n \nRedirecinando para a tela de salvar novo contato...");
                            Thread.sleep(6000);

                            //Indo para a tela adicionar um novo contato
                            adicionarContato adicionarDiscagem = new adicionarContato();
                            adicionarDiscagem.adicionar(Integer.valueOf(numeroTelefonico));
                            respostaAdicionarNovoContatoCheck = true;

                        }else if(respostaAdicionarNovoContato.equals("n")){
                            //Aqui é para quando o usuário não quer adicionar o número discado
                            System.out.println("\nVoltando para a tela do telefone!");
                            Thread.sleep(5000);
                            respostaAdicionarNovoContatoCheck = true;
                            continuarLigacao = false;

                        } else {
                            //Para caso o usuário não tenha inserido a resposta corretamente
                            System.out.println("\nA resposta está fora dos parâmetros do sistema");
                            System.out.println("para que o sistema não caí, vamos reiniciar a pergunta");
                        }
                    }

                }

            } else {
                //Aqui vai ser para caso o nosso contato não tenha atendido

                //Agora vamos criar uma variavel controle que vai checar se a resposta que o usuário inseriu está dentro dos parametros (vamos incia-la como falso)
                boolean respostaCheck = false;

                //Agora vamos criar o while que vai verificar a resposta inserida pelo usuário
                while(respostaCheck == false){

                    //Aqui vamos saber se usuário deseja refazer a ligação
                    System.out.println("\n \nSe desejar ligar novamente digite 1, porém se");
                    System.out.println("deseja voltar para tela do telefone digite 2");
                    System.out.println("deseja adicionar como um novo contato digite 3");
                    System.out.print("Digite aqui a resposta: ");
                    int respostaDeRefazerLigacao = scanner.nextInt();

                    //Agora vamos dar uma olhada nas resposta que o usuário colocou
                    if(respostaDeRefazerLigacao == 1){
                        //Não vamos colocar nada (somente para sair do enquanto), pois o while vai reeniciar sozinho e vai fazer a ligação novamente
                        respostaCheck = true;
                    
                    } else if (respostaDeRefazerLigacao == 2){
                        //Aqui vamos colocar para usuário voltar para a tela do telefone
                        System.out.println("Voltando para a tela do telefone! \n \n");
                        Thread.sleep(5000);
                        respostaCheck = true;
                        continuarLigacao = false;

                    } else if (respostaDeRefazerLigacao == 3){
                        //Aqui vamos inserir o número discado como um novo usuário
                        System.out.println("\n \nRedirecinando para a tela de salvar novo contato...");
                        Thread.sleep(6000);

                        //Indo para a tela adicionar um novo contato
                        adicionarContato adicionarDiscagem = new adicionarContato();
                        adicionarDiscagem.adicionar(Integer.valueOf(numeroTelefonico));

                    }else {
                        //Aqui vamos colocar o bloco de código para caso o usuário tenha digitado a resposta de maneira errada
                        System.out.println("Número inserido incorretamente, se atente a resposta");

                    }
                }
            }
        }
    }

}
