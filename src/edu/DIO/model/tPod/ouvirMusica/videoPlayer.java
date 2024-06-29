package edu.DIO.model.tPod.ouvirMusica;

import java.util.ArrayList;
import java.util.Scanner;

import edu.DIO.model.tPod.tPod;

public class videoPlayer  extends tPod{

    //Aqui criamos um scanner para pegar as informações do terminal
    private Scanner scanner = new Scanner(System.in); 

    //Variavel que irá gardar os filmes e series
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static ArrayList<String> filmeOuSerie = new ArrayList();

    //Aqui é parte inicial para os filmes e series
    public void parteInicial() throws InterruptedException {
        System.out.println("\n \n \nBem-vindo ao Streming TerFilmes");
        
        //Aqui é variavel que vai dar procedimento ao while, para que o usuário possa escolher outro filme ou serie
        boolean retorneVideo = true;

        //Aqui vamos colocar dentro da variavel filmeOuSerie, algo que indique para nós se o usuário quer adicionar mais um filme
        if(!filmeOuSerie.contains("Adicionar uma nova serie ou filme")){
            filmeOuSerie.add("Adicionar uma nova serie ou filme");
        }
        
        //Aqui é nosso bloco de repetição do videoPlayer
        while(retorneVideo == true){

            //Agora vamos dar uma olhada, se existe um filme ou uma serie dentro de filmeOuSerie
            if(filmeOuSerie.size() == 1){
                //Quando entramos nesse bloco, quer dizer que, não existe artistas ainda, e talvez o usuário vai querer adicionar um
                System.out.println("\nVocê não tem filmes ou series no momento");
                System.out.print("Você quer procurar um/uma: (reponda com s/n) ");
                String resultado = scanner.nextLine();

                if(resultado.equals("s")){
                    //Aqui é para caso o usuário queira adicionar um filme a lista
                    System.out.println("\n \nComo nosso sistema de Streaming funciona a partir da nuvem vai");
                    System.out.println("demorar um pouquinho para localiza-la, porém coloque o nome dela");
                    System.out.println("logo abaixo:");
                    String nomeFilmeOuSerie = scanner.nextLine();

                    //A partir daqui vamos adicionar o filme a nossa varieval filmeOuSerie
                    filmeOuSerie.add(nomeFilmeOuSerie);
                    Thread.sleep(6000);
                    System.out.println("\n \n \nO filme " + nomeFilmeOuSerie + " foi adicionado com sucesso a nossa lista");

                } else if(resultado.equals("n")){
                    //Aqui é para quando o usuário decidiu não adicionar um filme a lista (sendo que ela não tem nada)
                    System.out.println("\n \nComo não há filmes ou series. Digite tPod (para retornar ao tPod),");
                    System.out.println("smartPhone (para retornar ao smartPhone)");
                    System.out.println("videoPlayer (para caso queira procurar um filme ou serie)");
                    System.out.print("\nSua resposta: ");
                    String resposta = scanner.nextLine();

                    //Agora vamos ver qual foi a opção do usuário
                    if(resposta.equals("tPod")){

                        //Aqui nós voltamos para a tela do tPod
                        retorneVideo = false;
                        telaInicial();

                    } else if(resposta.equals("smartPhone")){
                        //Aqui nós voltamos para a tela do smartPhone
                        retorneVideo = false;

                    } else if(resposta.equals("videoPlayer")){
                        //Aqui vamos reiniciar o método, para caso o usuário queira adiconar um vídeo

                    }

                } else {
                    //Aqui é para caso a resposta do usuário for diferente á s ou n
                    System.out.println("Mensagem inserida incorretamente, reiniciando tPod");
                    telaInicial();

                }

            } else{

                //Aqui é para quando já existe um filme dentro da variavel filmeOuSerie
                System.out.println("\n \n \nSelecione o filme ou serie que você quer pelo número: \n");
                for(int i = 0; i < filmeOuSerie.size(); i++){
                    System.out.println(i + ". " + filmeOuSerie.get(i));
                }

                //Aqui vamos pegar a resposta do nosso usuário
                System.out.print("\nDigite aqui o número: ");
                int resposta = scanner.nextInt();
                scanner.nextLine();

                if(resposta == 0){
                    //Aqui o usuário dize que quer adicionar um novo filme ou uma serie
                    //Aqui é para caso o usuário queira adicionar um filme a lista
                    System.out.println("\n \nComo nosso sistema de Streaming funciona a partir da nuvem vai");
                    System.out.println("demorar um pouquinho para localiza-la, porém coloque o nome dela");
                    System.out.println("logo abaixo:");
                    String nomeFilmeOuSerie = scanner.nextLine();

                    //A partir daqui vamos adicionar o filme a nossa varieval filmeOuSerie
                    filmeOuSerie.add(nomeFilmeOuSerie);
                    Thread.sleep(6000);
                    System.out.println("\n \n \nO filme " + nomeFilmeOuSerie + " foi adicionado com sucesso a nossa lista");

                } else if (resposta >= 1) {
                    //O usuário escolheu o filme ou a serie dele e agora está na hora de colocar para tocar
                    playVideo(resposta);

                    //Aqui é para quando o usuário quiser sair do videoPlayer
                    System.out.println("\n \nPara sair do filme ou do videoPlayer. Digite tPod (para retornar ao tPod),");
                    System.out.println("smartPhone (para retornar ao smartPhone)");
                    System.out.println("videoPlayer (para caso queira procurar um filme ou serie)");
                    System.out.print("\nSua resposta: ");
                    String respostaAPerguntaDeSair = scanner.nextLine();

                    //Agora vamos ver qual foi a opção do usuário
                    if(respostaAPerguntaDeSair.equals("tPod")){

                        //Aqui nós voltamos para a tela do tPod
                        retorneVideo = false;
                        telaInicial();

                    } else if(respostaAPerguntaDeSair.equals("smartPhone")){
                        //Aqui nós voltamos para a tela do smartPhone
                        retorneVideo = false;

                    } else if(respostaAPerguntaDeSair.equals("videoPlayer")){
                        //Aqui vamos reiniciar o método, para caso o usuário queira escolher outro filme ou serie

                    }
                }
            }
        }
    }
    
    private void playVideo(int resposta){
        //O usuário escolheu o filme ou a serie dele e agora está na hora de colocar para tocar
        System.out.println("\n \n \n \n \n \nInicializando filme " + filmeOuSerie.get(resposta));
        System.out.println("\n \n \n \n \n \n \n \n \n \n \n            " + filmeOuSerie.get(resposta));
    }
}
