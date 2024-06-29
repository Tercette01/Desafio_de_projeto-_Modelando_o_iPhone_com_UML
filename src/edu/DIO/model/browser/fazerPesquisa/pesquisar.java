package edu.DIO.model.browser.fazerPesquisa;

import java.net.URI;
import java.util.Scanner;

import edu.DIO.model.browser.Browser;
import edu.DIO.model.browser.arquivoSistema.salvarFavoritos;

import java.awt.Desktop;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class pesquisar extends Browser{
    //Vamos iniciar o nosso scanner
    private Scanner scanner = new Scanner(System.in);

    //Agora vamos criar uma variavel de controle para o nosso while, que vai manter a janela de busca aberta (que vai começar como true)
    private boolean buscandoReusltados = true;

    //Aqui está nosso método para abrir nossa tela de pesquisa
    public void buscar() throws InterruptedException {

        //agora vamos dar inicio ao nosso sistema de busca
        while(buscandoReusltados == true){
            System.out.println("\n \nAntes de começar a pesquisa, se você tiver o link do site");
            System.out.println("digite 1, porém se você quiser procurar pelo nome do site");
            System.out.println("digite 2");
            System.out.print("Coloque sua resposta aqui: ");
            String escolhaLinkOuNome = scanner.nextLine();

            switch (escolhaLinkOuNome) {
                case "1":
                    //A partir daqui, vamos perguntar ao nosso usuário qual o link do site
                    System.out.println("\nAgora coloque logo abaixo o link do site: ");
                    String linkSite = scanner.nextLine();

                    //Agora vamos entrar num bloco de código, que vai entrar no site
                    try {
                        URI link = new URI(linkSite);
                        Desktop.getDesktop().browse(link);

                        //Aqui vamos usar um método que perguntará se usuário deseja continuar pesquisando
                        continuarPesquisa();

                    } catch (Exception erro) {
                        //Para caso o link não entre na página web
                        System.out.println("\nOcorreu um erro");
                        System.out.println("O link foi mau colocado, então...");
                        System.out.println("Verifique se ele está mesmo certado antes de coloca-lo novamente");
                        Thread.sleep(6000);
                    }
                    break;
                
                case "2":
                    //Aqui vamos perguntar para o usuário qual o nome do site
                    System.out.println("\nPor favor, coloque o nome do site logo (em minúsculo), abaixo?");
                    String nomeSite = scanner.nextLine();

                    /**
                     * Agora vamos criar uma variavel para armazenar todos os resultados da busca, além do indice (vamos começar com um por conta de o indice zero, 
                     * vamos utiliza-lo para caso o usuário não tenha encontrado o site dele, porém, lembrando, as variaveis como List, começam com em zero)
                    */
                    int i = 1;
                    List<String> resultadosSite = new ArrayList<>();

                    //Vamos também criar uma List<String> para o nome do site, para caso o usuário desejar salva-lo em favoritos
                    List<String> nomeSiteSalvarFavorito = new ArrayList<>();

                    //Antes de iniciar nosso bloco de resultado vamos anunciar ao usuárioque já foi achado os resultado
                    System.out.println("\nOs resultados encontrados foram: \n");
                    Thread.sleep(1000);

                    //Agora vamos colocar o bloco de código que irá buscar e mostrar os resultados
                    for (Map.Entry<String, String> entrada : getListaSite()) {
                        if (entrada.getKey().toLowerCase().startsWith(String.valueOf(nomeSite))) {

                            //Aqui vamos exibir os resultados encontrados
                            System.out.println("    " + i + "- " + entrada.getKey() + "\n      " + entrada.getValue());

                            //Aqui vamos armazenar os valores, como o resultado e o indice desse resultado
                            resultadosSite.add(entrada.getValue());
                            nomeSiteSalvarFavorito.add(entrada.getKey());
                            i++;
                        }
                    }

                    //Agora vamos perguntar se o site que o usuário procura foi exibido durante a pesquisa (além de mostrar a quantidade de sites encontrados)
                    System.out.println("\nForam localizados " + (i - 1)  + " de sites");
                    System.out.println("Se o site que procuras apareceu, por favor digite o número dele (que aprece em frente ao nome dos sites)");
                    System.out.println("Porém se seu site não apareceu, digite 0, para continuar a busca");
                    System.out.print("Coloque sua resposta aqui: ");
                    String respostaSites = scanner.nextLine();

                    //Agora vamos entrar em um if, para sabermos qual foi a opção do usuário
                    if(!respostaSites.equals("0")){

                        //Para caso a resposta do usuário tenha sido outro número diferente de zero
                        System.out.println("\n \nAbrindo site...\n");
                        Thread.sleep(5000);

                        //Agora vamos entrar num bloco de código, que vai entrar no site
                        try {

                            //Aqui vai pegar o URL do site, porém é bom explicar o por que de eu estar fazer a respostaSites - 1
                            //É por conta que (como dito na declaração do indice), a variavel List começa pelo 0 e não pelo 1
                            URI link = new URI(resultadosSite.get(Integer.parseInt(respostaSites) - 1));
                            Desktop.getDesktop().browse(link);

                            //Agora vamos criar uma variavel de controle para o nosso while que vai perguntar se o usuário deseja adicionar o site aos favoritos (vamos iniciar como falso)
                            boolean respostaFavoritosCheck = false;

                            //Agora vamos dar partida ao nosso while
                            while(respostaFavoritosCheck == false){

                                //Agora vamos perguntar ao usuário se ele deseja adicionar o site a favoritos
                                System.out.println("\nVocê deseja adicionar o site em favoritos?");
                                System.out.print("(Escolha entre s/n) ");
                                String respostaFavoritos = scanner.nextLine();

                                //Agora vamos entrar em nosso switch para ver qual foi a resposta
                                switch (respostaFavoritos) {
                                    case "s":
                                        //Para caso o usuário tenha escolhido que sim, vamos salvar o site na parte dos favoritos
                                        salvarFavoritos newFavoritos = new salvarFavoritos();
                                        newFavoritos.adicionarFavoritosPartirPesquisar(nomeSiteSalvarFavorito.get(Integer.parseInt(respostaSites) - 1));

                                        //E depois vamos perguntar para ele se deseja continuar pesquisando
                                        continuarPesquisa();
                                        respostaFavoritosCheck = true;
                                        break;

                                    case "n":
                                        //Para caso o usuário tenha escolhido não, então vamos direto perguntar para ele se deseja continuar pesquisando
                                        continuarPesquisa();
                                        respostaFavoritosCheck = true;
                                        break;
                                
                                    default:
                                        //Esse é o bloco para caso o usuário tenha digitado errado
                                        System.out.println("\nResposta invalida, refazendo a pergunta\n");
                                        Thread.sleep(6000);
                                        break;
                                }
                            }

                        } catch (Exception erro) {
                            //Para caso o link não entre na página web
                            System.out.println("\nOcorreu um erro");
                            System.out.println("O link foi mau colocado, então...");
                            System.out.println("Verifique se ele está mesmo certado antes de coloca-lo novamente");
                            Thread.sleep(6000);
                        }
                    }
                    break;
            
                default:
                    //Aqui pe para caso o usuário tenha inserido algo além de 1 ou 2
                    System.out.println("\nA resposta foi inserida incorretamente, vamos reinciar a pergunta");
                    Thread.sleep(6000);
                    break;
            }
        }
    }

    //Esse método vai ver se usuário deseja continuar fazendo pesquisa ou voltar para a tela do browser
    private void continuarPesquisa() throws InterruptedException {

        //Vamos criar uma variavel controle, para sabermos de a resposta do usuário foi inserida corretamente (vamos incia-la como false)
        boolean respostaCheck = false;

        //Agora vamos dar inicio ao nosso while, para sabermos se a resposta inserida pelo usuário está de acordo
        while(respostaCheck == false){
            System.out.println("\nDeseja continuar realizando pesquisas?");
            System.out.print("(Escolha entre s/n) ");
            String resposta = scanner.nextLine();

            //Agora vamos testar a resposta do usuário
            switch (resposta) {
                case "s":
                    //Esse bloco é para caso o usuário tenha optado pela opção de continuar a pesquisa
                    System.out.println("\n \nContinuando a pesquisa... \n \n");
                    Thread.sleep(6000);
                    respostaCheck = true;
                    break;
                
                case "n":
                    //Esse bloco é para caso o usuário tenha optado pela opção de voltar a tela do browser
                    System.out.println("\n \nVoltando para a tela do browser... \n \n");
                    Thread.sleep(6000);
                    buscandoReusltados = false;
                    respostaCheck = true;
                    break;
            
                default:
                    //Esse é o bloco para caso o usuário tenha digitado errado
                    System.out.println("\nResposta invalida, refazendo a pergunta\n");
                    Thread.sleep(6000);
                    break;
            }
        }
    }
    
}
