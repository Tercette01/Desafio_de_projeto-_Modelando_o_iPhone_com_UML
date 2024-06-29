package edu.DIO.model.tPod.arquivoSistema;

import java.util.ArrayList;
import java.util.Scanner;

import edu.DIO.model.tPod.tPod;

public class adicionarArtista extends tPod {
    //Aqui criamos um scanner para pegar as informações do terminal
    private Scanner scanner = new Scanner(System.in); 

    //Essa variavel serve como uma variavel de controle para o nosso próprio código
    private static ArrayList<String> artista = new ArrayList<>();

    //Esse método serve para adicionar um artista ao nosso "banco de dados"
    public void adicionarArtista() throws InterruptedException {
        System.out.println("\nDigite o nome do artista para adição ao programa");
        String newArtista = scanner.nextLine();

        //Aqui verificamos se o artista adicionado, não já existe no nosso "banco de dados"
        if(!artista.contains(newArtista)){
            
            //Se o artista não existe, vamos adiciona-ló
            setArtista(newArtista);
            artista.add(newArtista);

            System.out.println("\n \nloading... \n \n");

            //Aqui é para dar um tempinho, como se fosse a tela de loading
            Thread.sleep(60000);
            System.out.println("Artista adicionado com sucesso, porém não temos nenhum album registrado nele");
            Thread.sleep(5000);

            //Como todo artista precisa ter um album, vamos pedir para o usuário (se ele quiser)
            System.out.print("\n \nVocê quer adicionar um: (reponda com s/n) ");
            String resultado = scanner.nextLine();

            //Aqui vamos dar uma olhada para ver se o que o nosso usuario colocou
            if(resultado.equals("s")){

                //Aqui é quando o usuário quer criar um album
                adicionarAlbum novoAlbum = new adicionarAlbum();
                novoAlbum.adicionarAlbum(newArtista);

            } else if (resultado.equals("n")){
                //Aqui é quando o usuário não quer criar um album
                System.out.println("Voltando para a tela do tPod \n \n \n");
                telaInicial();

            } else {
                //Aqui é quando o usuário digitou a informação incorretamente
                System.out.println("Mensagem inserida incorretamente \n");

            }
        
        } else {
            //Aqui é para quando o artista já existe
            System.out.println("O artista em questão já existe!");
            System.out.println("Deseja voltar a tela incial ou adicionar um novo artista? ");
            System.out.print("(digite s/n) ");
            String resultado = scanner.nextLine();

            if(resultado.equals("s")){
                adicionarArtista();
                
            }else if (resultado.equals("n")){
                //Aqui é quando o usuário não quer criar um novo artista
                System.out.println("Voltando para a tela do tPod \n \n \n");
                telaInicial();

            } else {
                //Aqui é quando o usuário digitou a informação incorretamente
                System.out.println("Mensagem inserida incorretamente \n");

            }
        }
    }

}
