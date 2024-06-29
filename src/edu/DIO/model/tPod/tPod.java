package edu.DIO.model.tPod;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import edu.DIO.model.tPod.arquivoSistema.adicionarAlbum;
import edu.DIO.model.tPod.arquivoSistema.adicionarArtista;
import edu.DIO.model.tPod.arquivoSistema.adicionarMusica;
import edu.DIO.model.tPod.ouvirMusica.TocarMusica;
import edu.DIO.model.tPod.ouvirMusica.videoPlayer;

public class tPod{
   //Aqui está nossa variavel principal para o album
   private static ArrayList<String> Album = new ArrayList<>();
   public static void setAlbum(String newAlbum) {
       Album.add(newAlbum);
   }
   public static ArrayList<String> getAlbum() {
       return Album;
   }

   //Aqui está nossa variavel principal para o artista
   private static ArrayList<String> artista = new ArrayList<>();
   public static void setArtista(String newArtista) {
       artista.add(newArtista);
   }
   public static ArrayList<String> getArtista() {
       return artista;
   }

   //Aqui está nossa variavel princiapl para a musica
   private static ArrayList<String> musica = new ArrayList<>();
   public static void setMusica(String newMusica) {
       musica.add(newMusica);
   }

   //Aqui está nossa variavel princiapl união de artista com album
   private static List<Map.Entry<String, String>> albumArtista = new ArrayList<>();
   public static void setAlbumArtista(String newArtista, String newAlbum) {
      albumArtista.add(new AbstractMap.SimpleEntry<>(newArtista, newAlbum));
   }
   public static List<Map.Entry<String, String>> getAlbumArtista() {
       return albumArtista;
   }

   //Aqui está nossa variavel princiapl união do album com a musica
   private static List<Map.Entry<String, String>> musicaAlbum = new ArrayList<>();
   public static List<Map.Entry<String, String>> getMusicaAlbum() {
       return musicaAlbum;
   }
   public static void setMusicaAlbum(String newAlbum, String newMusica) {
      musicaAlbum.add(new AbstractMap.SimpleEntry<>(newAlbum, newMusica));
   }

   //Aqui é metodo inicial do nosso tPod
   public void telaInicial() throws InterruptedException{
    @SuppressWarnings("resource")
   Scanner scanner = new Scanner(System.in);

    //Aqui verificamos se nossas variaveis já tem o que queremos adicionar
    if(!Album.contains("Adicionar mais um album") && !artista.contains("Adicionar mais um artista") && !musica.contains("Adicionar mais uma musica")){

      //Aqui damos uma inicialização das nossas variaveis colocando nelas a opção de adicionar mais um (desde album e artistas)
      Album.add("Adicionar mais um album");
      artista.add("Adicionar mais um artista");
      musica.add("Adicionar mais uma musica");
    }

    //Aqui vamos dar as opções por onde o usuário quer começar a sua pesquisa
    System.out.println("\n \n \nSeja bem-vido ao tPod");
    System.out.println("Selecione (via número), uma das opções abaixo para continuarmos");
    System.out.println("   1. Pesquisar por artistas");
    System.out.println("   2. Pesquisar por album");
    System.out.println("   3. Pesquisar por música");
    System.out.println("   4. Pesquisar por video");
    System.out.println("   5. Fechar tPod");
    System.out.print("\nInsira o número: ");

    //Aqui pegamos a resposta do usuário
    String desejoDoUsuario = scanner.nextLine();

    //Apartir daqui, conferimos qual a resposta do usuário e verificamos o que ele quer pesquisar
    if(desejoDoUsuario.equals("1")){

      //Aqui vemos que o usuário quer pesquisar por artista
      if(artista.size() == 1){

         //Quando entramos nesse bloco, quer dizer que, não existe artistas ainda, e talvez o usuário vai querer adicionar um
         System.out.println("Você não tem artistas adicionados no momento");
         System.out.print("Você quer adicionar um: (reponda com s/n) ");
         String resultado = scanner.nextLine();

         //Aqui verificamos se a resposta do usuário para adicionar um artista foi sim ou não
         if(resultado.equals("s")){

            //O usuário dize sim, então daremos procedimento ao nosso programa 
            adicionarArtista novoArtista = new adicionarArtista();
            novoArtista.adicionarArtista();

         } else if (resultado.equals("n")){

            //A partir daqui verificamos se o usuário quer voltar para a tela inicial
            System.out.println("\n \n \n \nNenhum artista encontrado!");
            System.out.print("Que voltar para a tela inicial? (reponda com s/n) ");
            resultado = scanner.nextLine();

            //Aqui verificamos se a resposta do usuário para adicionar um artista foi sim ou não
            if(resultado.equals("s")){
               //Voltando para a tela incial do smartphone

            } else if (resultado.equals("n")){
               //Volta para a tela inicial do tPod
               telaInicial();

            } else {
               //Aqui é para quando o usuário não inseriu a senha corretamente
               System.err.println("Mensagem inserida incorretamente");
            }

         } else {
            //Aqui é para quando o usuário não inseriu a senha corretamente
            System.err.println("Mensagem inserida incorretamente");

         }

      } else {
         //Aqui é para caso o usuário achou o album que ele queria
         System.out.println("\nSelecione o artista que você quer pelo número: \n");
         for(int i = 0; i < artista.size(); i++){
            System.out.println(i + ". " + artista.get(i));
         }

         //Aqui vamos pegar a resposta do nosso usuário
         System.out.print("\nDigite aqui o número: ");
         int resposta = scanner.nextInt();

         if(resposta == 0){
            //Aqui o usuário dize que quer adicionar um novo artista
            adicionarArtista novoArtista = new adicionarArtista();
            novoArtista.adicionarArtista();

         } else if (resposta != 0){
            //O usuário escolheu a música dele e agora está na hora de colocar para tocar
            TocarMusica tocar = new TocarMusica();
            tocar.tocarArtista(artista.get(resposta));
         }
      }
   
   //Apartir daqui, conferimos qual a resposta do usuário e verificamos o que ele quer pesquisar
    } else if(desejoDoUsuario.equals("2")){

      //Aqui vemos que o usuário quer pesquisar por album
      if(Album.size() == 1){

         //Quando entramos nesse bloco, quer dizer que, não existe albuns ainda, e talvez o usuário vai querer adicionar um
         System.out.println("Você não tem albuns adicionados no momento");
         System.out.print("Você quer adicionar um: (reponda com s/n) ");
         String resultado = scanner.nextLine();

         //Aqui verificamos se a resposta do usuário para adicionar um album foi sim ou não
         if(resultado.equals("s")){

            //O usuário dize sim, então daremos procedimento ao nosso programa 
            adicionarAlbum novoAlbum = new adicionarAlbum();
            novoAlbum.adicionarAlbum(null);

         } else if (resultado.equals("n")){

            //A partir daqui verificamos se o album quer voltar para a tela inicial
            System.out.println("\n \n \n \nNenhum album encontrado!");
            System.out.print("Que voltar para a tela inicial? (reponda com s/n) ");
            resultado = scanner.nextLine();

            //Aqui verificamos se a resposta do usuário para adicionar um artista foi sim ou não
            if(resultado.equals("s")){
               //Voltando para a tela incial do smartphone

            } else if (resultado.equals("n")){
               //Volta para a tela inicial do tPod
               telaInicial();

            } else {
               //Aqui é para quando o usuário não inseriu a senha corretamente
               System.err.println("Mensagem inserida incorretamente");
            }

         } else {
            //Aqui é para quando o usuário não inseriu a senha corretamente
            System.err.println("Mensagem inserida incorretamente");

         }

      } else {
         //Aqui é para caso o usuário achou o album que ele queria
         System.out.println("\nSelecione o album que você quer pelo número: \n");
         for(int i = 0; i < Album.size(); i++){
            System.out.println(i + ". " + Album.get(i));
         }

         //Aqui vamos pegar a resposta do nosso usuário
         System.out.print("\nDigite aqui o número: ");
         int resposta = scanner.nextInt();

         if(resposta == 0){
            //Aqui o usuário dize que quer adicionar um novo album
            adicionarAlbum novoAlbum = new adicionarAlbum();
            novoAlbum.adicionarAlbum(null);

         } else if (resposta >= 1) {
            //O usuário escolheu a música dele e agora está na hora de colocar para tocar
            TocarMusica tocar = new TocarMusica();
            tocar.tocarAlbum(Album.get(resposta));
         }
      }
   
   //Apartir daqui, conferimos qual a resposta do usuário e verificamos o que ele quer pesquisar
    } else if(desejoDoUsuario.equals("3")){

      //Aqui vemos que o usuário quer pesquisar por musica
      if(musica.size() == 1){

         //Quando entramos nesse bloco, quer dizer que, não existe nenhuma música ainda, e talvez o usuário vai querer adicionar um
         System.out.println("Você não têm músicas adicionados no momento");
         System.out.print("Você quer adicionar uma: (reponda com s/n) ");
         String resultado = scanner.nextLine();

         //Aqui verificamos se a resposta do usuário para adicionar um música foi sim ou não
         if(resultado.equals("s")){

            //O usuário dize sim, então daremos procedimento ao nosso programa 
            adicionarMusica novaMusica = new adicionarMusica();
            novaMusica.adicionarMusica(null);

         } else if (resultado.equals("n")){

            //A partir daqui verificamos se o música quer voltar para a tela inicial
            System.out.println("\n \n \n \nNenhum música foi encontrada!");
            System.out.print("Que voltar para a tela inicial? (reponda com s/n) ");
            resultado = scanner.nextLine();

            //Aqui verificamos se a resposta do usuário para adicionar uma música foi sim ou não
            if(resultado.equals("s")){
               //Voltando para a tela incial do smartphone

            } else if (resultado.equals("n")){
               //Volta para a tela inicial do tPod
               telaInicial();

            } else {
               //Aqui é para quando o usuário não inseriu a senha corretamente
               System.err.println("Mensagem inserida incorretamente");
            }

         } else {
            //Aqui é para quando o usuário não inseriu a senha corretamente
            System.err.println("Mensagem inserida incorretamente");

         }

      } else {
         //Aqui é para caso o usuário achou o musica que ele queria
         System.out.println("Selecione a música que você quer pelo número: \n");
         for(int i = 0; i < musica.size(); i++){
            System.out.println(i + ". " + musica.get(i));
         }

         //Aqui vamos pegar a resposta do nosso usuário
         System.out.print("\nDigite aqui o número: ");
         int resposta = scanner.nextInt();

         if(resposta == 0){
            //Aqui o usuário dize que quer adicionar uma nova musica
            adicionarMusica novaMusica = new adicionarMusica();
            novaMusica.adicionarMusica(null);

         } else{
            //O usuário escolheu a música dele e agora está na hora de colocar para tocar
            TocarMusica tocar = new TocarMusica();
            tocar.tocarMusica(musica.get(resposta));
         }
      }
   
   //Aqui é para caso o usuário selecione a opção quatro, que irá levar ao usuário a parte de vídeo
    } else if(desejoDoUsuario.equals("4")){
      videoPlayer video = new videoPlayer();
      video.parteInicial();
    
   //Aqui é para caso o usuário selecione a opção quinta, que irá finalizar o tPod
    } else if(desejoDoUsuario.equals("5")){
      //tPod finalizado

    } else {
      //Aqui é para quando o usuário não inseriu a senha corretamente
      System.err.println("Mensagem inserida incorretamente");
    }
   }
}
