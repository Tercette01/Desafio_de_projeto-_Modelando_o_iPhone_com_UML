package edu.DIO.model.tPod.arquivoSistema;

import java.util.ArrayList;
import java.util.Scanner;

import edu.DIO.model.tPod.tPod;
import edu.DIO.model.tPod.ouvirMusica.TocarMusica;

public class adicionarMusica  extends tPod{
    //Aqui criamos um scanner para pegar as informações do terminal
    private Scanner scanner = new Scanner(System.in); 

    //Essa variavel serve como uma variavel de controle para o nosso próprio código
    private static ArrayList<String> musica = new ArrayList<>();

    public void adicionarMusica(String album) throws InterruptedException{
        System.out.println("Digite o nome da música para adição ao programa");
        String newMusica = scanner.nextLine();

        //Aqui verificamos se a musica adicionada, não já existe no nosso "banco de dados"
        if(!musica.contains(newMusica)){

            //Se a musica não existe, vamos adiciona-la
            if(album != null){

                //Para caso o usuário tenha colocado junto com o album criado recentemente
                setMusica(newMusica);
                musica.add(newMusica);
                setMusicaAlbum(album, newMusica);

            } else if (album == null){

                //Para caso o usuário não tenha colocado junto com o album criado recentemente
                System.out.println("Como toda música precisa ter um album!");

                //Para ver se existe um album
                if(getAlbum().size() > 1){
                    //Aqui, o usuário irá escolher para qual album ele deseja adicionar a musica
                    System.out.println("Selecione o album que você quer adicionar a música pelo número: ");
                    for(int i = 1; i < getAlbum().size(); i++){
                        System.out.println(i + ". " + getAlbum().get(i));
                    }

                    //Aqui é para pegar qual foi a escolha do usuário
                    System.out.print("\nDigite aqui o número: ");
                    int resultado = scanner.nextInt();
                    album = getAlbum().get(resultado);
                    scanner.nextLine();

                    //Agora sim podemos adicionar ao nosso album
                    setMusica(newMusica);
                    musica.add(newMusica);
                    setMusicaAlbum(album, newMusica);

                } else {
                    System.err.println("\n \nFoi detectado um erro de sistema");
                    System.err.println("Por conta de não haver album ainda");
                    System.err.println("E para resolver isso primeiro adicione um album e depois a música");
                    telaInicial();
                }
            }

            System.out.println("\n \nloading... \n \n");

            //Aqui é para dar um tempinho, como se fosse a tela de loading
            Thread.sleep(60000);
            System.out.println("Música adicionada com sucesso!");
            Thread.sleep(5000);

            //Agora o usuário vai escolher se vai querer escutar a música
            System.out.println("\n \nVocê vai querer escutar essa música? ");
            System.out.print("(Use s/n) ");
            String escutarSimNao = scanner.nextLine();

            if(escutarSimNao.equals("s")){
                
                //A música vai ser inciada
                TocarMusica tocar = new TocarMusica();
                tocar.tocarMusica(newMusica);

            }else if (escutarSimNao.equals("n")){
                
                //Como usuário não deseja tocar a música, vamos voltar para a tela inicial
                telaInicial();
            }

        
        } else {
            //Aqui é para quando a música já existe
            System.out.println("\nA música em questão já existe!");
            System.out.println("Deseja voltar a tela incial ou adicionar uma nova música? ");
            System.out.print("(digite s/n) ");
            String resultado = scanner.nextLine();

            if(resultado.equals("s")){
                adicionarMusica(null);
                
            }else if (resultado.equals("n")){
                //Aqui é quando o usuário não quer criar uma nova música
                System.out.println("Voltando para a tela do tPod \n \n \n");
                telaInicial();

            } else {
                //Aqui é quando o usuário digitou a informação incorretamente
                System.out.println("Mensagem inserida incorretamente \n");

            }
        }
        
    }

}
