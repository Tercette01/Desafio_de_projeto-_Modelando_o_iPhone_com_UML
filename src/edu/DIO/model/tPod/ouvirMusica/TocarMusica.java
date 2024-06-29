package edu.DIO.model.tPod.ouvirMusica;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import edu.DIO.model.tPod.tPod;

public class TocarMusica extends tPod{
    //Aqui criamos um scanner para pegar as informações do terminal
    private Scanner scanner = new Scanner(System.in);

    //Aqui vamos dar inicio a tocar a partir do album
    public void tocarAlbum(String album) throws InterruptedException {
        //Aqui estão nossas principais variaveis desse metodo
        int cancelarReproducao = 0;
        int musicaReproducao = 0;
        List<String> musicasDoAlbum = new ArrayList<>();
        String artistaDoAlbum = null;

        //Aqui vamos pegar o album da música
        for (Map.Entry<String, String> par : getMusicaAlbum()) {
            if (par.getKey().equals(album)) {
                musicasDoAlbum.add(par.getValue());
            }
        }

        //Aqui vamos pegar o album da música
        for (Map.Entry<String, String> par : getAlbumArtista()) {
            if (par.getValue().equals(album)) {
                artistaDoAlbum = par.getKey();
            }
        }

        //Serve para que o usuário possa cancelar a reprodução do album
        while(cancelarReproducao != 1 && !musicasDoAlbum.get(musicaReproducao).isEmpty()){

            //Se o album ou a música existir, podemos dar inicio ao tocar
            if(artistaDoAlbum != null && !musicasDoAlbum.isEmpty()){

                //A partir daqui, iniciamos a tela para indicar as músicas que estão sendo tocadas
                System.out.println("\n \n \n \nIniciando a música " + musicasDoAlbum.get(musicaReproducao));
                Thread.sleep(6000);

                System.out.println("\n \n \n \n \n \n \n \n \n \n \n" + musicasDoAlbum.get(musicaReproducao));

                //Agora vamos mostrar para o usuário qual album ele está houvindo
                System.out.println("\n \nA música está no album: " + album);

                //Agora vamos mostrar para o usuário qual album ele está houvindo
                System.out.println("\n \nA música está sendo tocada por: " + artistaDoAlbum);

                //Agora vamos colocar para nosso usuário sair da música e retornar para o tPod ou para o smartPhone
                System.out.println("\nPara sair da música, por digite tPod (para retornar ao tPod),");
                System.out.println("smartPhone (para retornar ao smartPhone)");

                //Para caso haja uma próxima música
                int testeDeMusicaReproducao = musicaReproducao + 1;
                if(musicasDoAlbum.size() > testeDeMusicaReproducao){
                    System.out.println("proxima (para ir para a próxima  música, que sera "+ musicasDoAlbum.get(testeDeMusicaReproducao) +")");
                }

                //Para que essa opção só aparessa, caso for a segunda música
                testeDeMusicaReproducao = musicaReproducao - 1;
                if(musicaReproducao != 0){
                    System.out.println("voltar (para retornar uma música, que sera "+ musicasDoAlbum.get(testeDeMusicaReproducao) +")");
                }

                System.out.print("Sua resposta: ");
                String resposta = scanner.nextLine();

                //Agora vamos ver qual foi a opção do usuário
                if(resposta.equals("tPod")){

                    //Aqui nós voltamos para a tela do tPod
                    telaInicial();
                    cancelarReproducao++;

                } else if(resposta.equals("smartPhone")){
                    //Aqui nós voltamos para a tela do smartPhone
                    cancelarReproducao++;

                } else if(resposta.equals("proxima")){

                    //Aqui nós pulamos para a próxima música
                    musicaReproducao++;

                } else if(resposta.equals("voltar")){
                    //Aqui nós voltamos uma música
                    musicaReproducao--;

                }

            } else {
                //Aqui é para quando ou o album ou a musica não existirem
                System.out.println("\n \nFalha no sistema, o tPod será reiniciado");
                System.out.println("Possível causa, ou o album ou a música não existe \n \n \n \n");
                Thread.sleep(6000);
                telaInicial();
                cancelarReproducao++;
            }
        }
    }

    //Aqui vamos iniciar a tocar a partir do artista
    public void tocarArtista(String artista) throws InterruptedException {
        //Aqui estão nossas principais variaveis desse metodo
        int albumNumero = 0;
        String musicaDoAlbum = null;
        List<String> albumDoArtista = new ArrayList<>();

        //Aqui vamos pegar o album do artista
        for (Map.Entry<String, String> par : getAlbumArtista()) {
            if (par.getKey().equals(artista)) {
                albumDoArtista.add(par.getValue());
            }
        }

        //Aqui vamos pegar a música do album
        for (Map.Entry<String, String> par : getMusicaAlbum()) {
            if (par.getKey().equals(albumDoArtista.get(albumNumero))) {
                musicaDoAlbum = par.getValue();
            }
        }

        //Essa repetição é para conferir os albuns, se eles ainda existirem (deixei ela como true, pois eu não tinha ideia de qual condição colocar dentro dela)
        while(true){

            //Se o album ou a música existir, podemos dar inicio ao tocar
            if(!albumDoArtista.isEmpty() && musicaDoAlbum != null){

                //A partir daqui, iniciamos a tela para indicar as músicas que estão sendo tocadas
                System.out.println("\n \n \n \nIniciando a música " + musicaDoAlbum);
                Thread.sleep(6000);

                System.out.println("\n \n \n \n \n \n \n \n \n \n \n" + musicaDoAlbum);

                //Agora vamos mostrar para o usuário qual album ele está houvindo
                System.out.println("\n \nA música está no album: " + albumDoArtista);

                //Agora vamos mostrar para o usuário qual album ele está houvindo
                System.out.println("\n \nA música está sendo tocada por: " + artista);

                //Agora vamos colocar para nosso usuário sair da música e retornar para o tPod ou para o smartPhone
                System.out.println("\nPara sair da música, por digite tPod (para retornar ao tPod),");
                System.out.println("smartPhone (para retornar ao smartPhone)");
                System.out.print("Sua resposta: ");
                String resposta = scanner.nextLine();

                //Agora vamos ver qual foi a opção do usuário
                if(resposta.equals("tPod")){

                    //Aqui nós voltamos para a tela do tPod
                    telaInicial();

                } else if(resposta.equals("smartPhone")){
                    //Aqui nós voltamos para a tela do smartPhone
                    break;

                }
            
            //Aqui é para quando o album que foi selecionado é vazio
            } else if (albumDoArtista.size() >= 1){

                //Aqui é para quando for o último album do artista, e que ainda é vazio
                int testeDeAlbumNumero = albumNumero;
                if(albumDoArtista.size() < (testeDeAlbumNumero)){
                    //Aqui é para quando ou o album ou a musica não existirem
                    System.out.println("\n \nFalha no sistema, o tPod será reiniciado");
                    System.out.println("Possível causa, ou o album ou a música não existe \n \n \n \n");
                    Thread.sleep(6000);
                    telaInicial();

                //Aqui é para quando o artista ter mais albuns
                } else {
                    albumNumero++;

                    //Aqui vamos pegar a música do album
                    for (Map.Entry<String, String> par : getMusicaAlbum()) {
                        if (par.getKey().equals(albumDoArtista.get(albumNumero))) {
                            musicaDoAlbum = par.getValue();
                        }
                    }
                }
            
            //Por conta do erro do sistema, coloquei uma trava de segurança
            } else {

                //Aqui é para quando ou o album ou a musica não existirem
                System.out.println("\n \nFalha no sistema, o tPod será reiniciado");
                System.out.println("Possível causa, ou o album ou a música não existe \n \n \n \n");
                Thread.sleep(6000);
                telaInicial();
            }
        }
    }


    //Aqui vamos iniciar a tocar música
    public void tocarMusica(String musica) throws InterruptedException{
        //Aqui estão nossas principais variaveis desse metodo
        String albumDaMusica = "";
        String ArtistaDoAlbum = "";

        //Aqui vamos pegar o album da música
        for (Map.Entry<String, String> par : getMusicaAlbum()) {
            if (par.getValue().equals(musica)) {
                albumDaMusica = par.getKey();
            }
        }
        
        //Aqui vamos pegar o artista do album
        for (Map.Entry<String, String> par : getAlbumArtista()) {
            if (par.getValue().equals(albumDaMusica)) {
                ArtistaDoAlbum = par.getKey();
            }
        }
        
        //A partir daqui, iniciamos a tela para indicar as músicas que estão sendo tocadas
        System.out.println("\n \n \n \nIniciando a música " + musica);
        Thread.sleep(6000);

        System.out.println("\n \n \n \n \n \n \n \n \n \n \n" + musica);

        //Agora vamos mostrar para o usuário qual album ele está houvindo
        System.out.println("\n \nA música está no album: " + albumDaMusica);

        //Agora vamos mostrar para o usuário qual album ele está houvindo
        System.out.println("\n \nA música está sendo tocada por: " + ArtistaDoAlbum);

        //Agora vamos colocar para nosso usuário sair da música e retornar para o tPod ou para o smartPhone
        System.out.println("\nPara sair da música, por digite tPod (para retornar ao tPod),");
        System.out.println("smartPhone (para retornar ao smartPhone)");
        System.out.print("Sua resposta: ");
        String resposta = scanner.nextLine();

        //Agora vamos ver qual foi a opção do usuário
        if(resposta.equals("tPod")){

            //Aqui nós voltamos para a tela do tPod
            telaInicial();

        } else if(resposta.equals("smartPhone")){
            //Aqui nós voltamos para a tela do smartPhone

        }
    }
}
