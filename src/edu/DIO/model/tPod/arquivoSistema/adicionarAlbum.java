package edu.DIO.model.tPod.arquivoSistema;

import java.util.ArrayList;
import java.util.Scanner;

import edu.DIO.model.tPod.tPod;

public class adicionarAlbum extends tPod {
    //Aqui criamos um scanner para pegar as informações do terminal
    private Scanner scanner = new Scanner(System.in); 

    //Essa variavel de serve como uma variavel de controle para artista para o nosso próprio código
    private static ArrayList<String> Album = new ArrayList<>();

    public void adicionarAlbum(String artista) throws InterruptedException {
        System.out.println("Digite o nome do album para adição ao programa");
        String newAlbum = scanner.nextLine();

        //Aqui verificamos se o album adicionado, não já existe no nosso "banco de dados"
        if(!Album.contains(newAlbum)){

            //Se o album não existe, vamos adiciona-ló
            if(artista != null){

                //Para caso o usuário tenha colocado junto com o artista criado recentemente
                setAlbum(newAlbum);
                Album.add(newAlbum);
                setAlbumArtista(artista, newAlbum);

            } else if (artista == null){

                //Para caso o usuário não tenha colocado junto com o artista criado recentemente
                System.out.println("Como todo album precisa ter um artista!");

                //Para ver se existe um artista
                if(getArtista().size() > 1){
                    //Aqui, o usuário irá escolher para qual artista ele deseja adicionar o album
                    System.out.println("Selecione o artista que você quer adicionar ao album pelo número: ");
                    for(int i = 1; i < getArtista().size(); i++){
                        System.out.println(i + ". " + getArtista().get(i));
                    }

                    //Aqui é para pegar qual foi a escolha do usuário
                    System.out.print("\nDigite aqui o número: ");
                    int resultado = scanner.nextInt();
                    artista = getArtista().get(resultado);
                    scanner.nextLine();

                    //Agora sim podemos adicionar ao nosso album
                    setAlbum(newAlbum);
                    Album.add(newAlbum);
                    setAlbumArtista(artista, newAlbum);
                } else {
                    System.err.println("\n \nFoi detectado um erro de sistema");
                    System.err.println("Por conta de não haver artista ainda");
                    System.err.println("E para resolver isso primeiro adicione um artista e depois o album");
                    telaInicial();
                }
            }

            System.out.println("\n \nloading... \n \n");

            //Aqui é para dar um tempinho, como se fosse a tela de loading
            Thread.sleep(60000);
            System.out.println("Album adicionado com sucesso, porém não temos nenhum musica registrado nele");
            Thread.sleep(5000);

            //Como todo artista precisa ter um album, vamos pedir para o usuário (se ele quiser)
            System.out.print("\n \nVocê quer adicionar um: (reponda com s/n) ");
            String resultado = scanner.nextLine();

            //Aqui vamos dar uma olhada para ver se o que o nosso usuario colocou
            if(resultado.equals("s")){

                //Aqui é quando o usuário quer criar uma musica
                adicionarMusica novaMusica = new adicionarMusica();
                novaMusica.adicionarMusica(newAlbum);

            } else if (resultado.equals("n")){
                //Aqui é quando o usuário não quer criar um album
                System.out.println("Voltando para a tela do tPod \n \n \n");
                telaInicial();

            } else {
                //Aqui é quando o usuário digitou a informação incorretamente
                System.out.println("Mensagem inserida incorretamente \n");

            }
        
        } else {
            //Aqui é para quando o album já existe
            System.out.println("O album em questão já existe!");
            System.out.println("Deseja voltar a tela incial ou adicionar um novo album? ");
            System.out.print("(digite s/n) ");
            String resultado = scanner.nextLine();

            if(resultado.equals("s")){
                adicionarAlbum(null);
                
            }else if (resultado.equals("n")){
                //Aqui é quando o usuário não quer criar um novo album
                System.out.println("Voltando para a tela do tPod \n \n \n");
                telaInicial();

            } else {
                //Aqui é quando o usuário digitou a informação incorretamente
                System.out.println("Mensagem inserida incorretamente \n");

            }
        }
    }

}
