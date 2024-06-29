package edu.DIO.model.browser.arquivoSistema;

import java.net.URI;
import java.util.List;
import java.util.Scanner;

import edu.DIO.model.browser.Browser;

import java.awt.Desktop;

public class salvarFavoritos extends Browser {
    //Vamos iniciar o scanner
    private Scanner scanner = new Scanner(System.in);

    //Aqui está um comando universal para todas outras funções que desejam adicionar um site em favoritos
    private void adicionarSite(String nomeSite) throws InterruptedException{

        //Aqui está nosso comando para salvar em favoritos
        setSitesFavoritos(nomeSite);

        //agora vamos mostrar pro nosso usuário que o site foi salvado em favoritos com sucesso
        System.out.println("\n \nO site " + nomeSite + " foi salvo com sucesso em favoritos \n \n");

        //Um tempo para usuário ler o que o sistema está falando
        Thread.sleep(3000);
    }

    //A partir dessa função, iremos salvar os sites na seção de favoritos (a partir de adicionarSite)
    public void adicionarFavoritosPartirAdicionarSite(String nomeSite) throws InterruptedException {
        
        //Aqui está nosso comando para salvar em favoritos
        adicionarSite(nomeSite);

        //Agora vamos criar uma variavel de controle para sabermos se a resposta do usuário será o que nós pedimos (vamos começar com false)
        boolean respostaVizualizarFavoritosCheck = false;

        //Agora vamos dar inicio ao while para sabermos se o usuário vai querer vizualizar o site 
        while(respostaVizualizarFavoritosCheck == false){

            //Aqui vamos perguntar para o usuário se ele deseja abrir a página
            System.out.println("\nVocê deseja abrir o site salvo em favoritos?");
            System.out.print("(Escolha entre s/n) ");
            String respostaVizualizarFavoritos = scanner.nextLine();

            switch (respostaVizualizarFavoritos) {
                case "s":
                    //Aqui vamos colocar nosso bloco de código para abrir a página, a partir da variavel Link do site
                    List<String> LinkDoSite = buscarLink(nomeSite);

                    //Agora vamos entrar num bloco de código, que vai entrar no site
                    try {
                        URI link = new URI(LinkDoSite.get(0));
                        Desktop.getDesktop().browse(link);

                    } catch (Exception erro) {
                        System.out.println(erro);
                    }

                    //Para que usuário senha do while e possa retornar a tela do Browser
                    respostaVizualizarFavoritosCheck = true;
                    telaInicial();
                    break;
            
                case "n":
                    //Aqui é para caso o usuário tenha escolhido não abrir o site
                    System.out.println("\n \nRetornando para a tela inicial do Browser\n");
                    Thread.sleep(6000);

                    //Para que usuário senha do while e possa retornar a tela do Browser
                    respostaVizualizarFavoritosCheck = true;
                    telaInicial();
                    break;

                default:
                    //Aqui é para caso o usuário tenha inserido uma resposta incorretamente
                    System.out.println("Resposta inserida incorretamente, a pergunta será reinciada");
                    break;
            }
        }
    }

    //Adicionando um site na parte de favoritos durante a pesquisa
    public void adicionarFavoritosPartirPesquisar(String nomeSite) throws InterruptedException{

        //Aqui está nosso comando para salvar em favoritos
        adicionarSite(nomeSite);

        //Somente para mostrar o usuário que o site foi salvo com sucesso em favoritos
        System.out.println("\n \nO site foi salvo com sucesso em favoritos\n");
        telaInicial();
    }

    
}
