package edu.DIO.model.browser;

import java.awt.Desktop;
import java.net.URI;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import edu.DIO.model.browser.arquivoSistema.adicionarSite;
import edu.DIO.model.browser.fazerPesquisa.pesquisar;

public class Browser {

    //vamos iniciar o scanner
    private static Scanner scanner = new Scanner(System.in);

    //Agora vamos dar inicio a nossa variavel site (que vai ter o nome e o lindo site)
    private static List<Map.Entry<String, String>> listaSite = new ArrayList<>();
    public static List<Map.Entry<String, String>> getListaSite() {
        return listaSite;
    }
    public static void setListaSite(String site, String link) {
        listaSite.add(new AbstractMap.SimpleEntry<>(site, link));
    }
    public static boolean verificarListaSiteExiste(String site, String link){
        boolean contem = false;

        for (Map.Entry<String, String> entrada : listaSite) {
            if (site != null && site.equals(entrada.getKey())) {
                contem = true;
            }
            if (link != null && link.equals(entrada.getValue())) {
                contem = true;
            }
        }

        return contem;
    }

    //E também vamos criar a lista de sites favoritos
    private static List<String> sitesFavoritos = new ArrayList<>();
    public static void setSitesFavoritos(String siteFavorito) {
        sitesFavoritos.add(siteFavorito);
    }


    //Aqui vai dar inicio aao nosso browser
    public void telaInicial() throws InterruptedException{

        //Aqui vamos dar inicio a tela para o nosso usuário
        System.out.println("\n \n \nSeja bem-vindo ao Browser, o melhor navegador do mundo");
        System.out.println("\nPara começar, primeiro escolha uma das opções abaixo: (escolha pelo número)");
        System.out.println("    1. Pesquisar sites");
        System.out.println("    2. Adicionar um site");
        System.out.println("    3. Dar uma olhada em favoritos");
        System.out.println("    4. Voltar a tela inicial do smartPhone");
        System.out.print("\nNúmero escolhido: ");
        String opcaoDoUsuario = scanner.nextLine();

        //Agora vamos conferir qual foi a resposta do usuário
        switch (opcaoDoUsuario) {
            case "1":
                //Vamos verificar se existem sites para serem pesquisados
                if(listaSite.isEmpty()){

                    //Aqui está o bloco de código para caso o usuário não exista
                    System.out.println("\nVocê não tem nenhum site adicionado ao nosso navegador");

                    //Vamos criar uma variavel de controle para caso o usuário tenha digitado uma resposta fora do proposto (vamos começar com falso)
                    boolean opcaoDoUsuarioCheck = false;

                    //Vamos criar um while, até o usuário colocar umas das opções que demos a ele
                    while (opcaoDoUsuarioCheck == false) {

                        //Agora vamos perguntar ao usuário se ele deseja adicionar um site
                        System.out.println("Você quer adicionar um site ao sistema?");
                        System.out.print("(escolha entre s/n) ");
                        opcaoDoUsuario = scanner.nextLine();  
                        
                        switch (opcaoDoUsuario) {
                            case "s":
                                //Caso usuário escolha que sim, nós vamos redireciona-lo para atela de adicionar um site
                                System.out.println("\nRedirecionando para a tela de adicionar um site!\n");
                                adicionarSite adicionar = new adicionarSite();
                                adicionar.adicionarSite();

                                //Aqui desativamos o while, por conta do usuário ter escolhido a resposta certa
                                opcaoDoUsuarioCheck = true;
                                break;
                            
                            case "n":
                                //Aqui vamos redirecionar o usuário para a tela inicial do smartPhone
                                System.out.println("\nComo não foi encontrado site, vamos redireciona-lo para");
                                System.out.println("a tela incial do smartPhone\n \n");

                                //Aqui desativamos o while, por conta do usuário ter escolhido a resposta certa
                                opcaoDoUsuarioCheck = true;
                                break;
                        
                            default:
                                //Aqui é para caso o usuário escolha uma opção que não esteja de acordo com as nossas duas opções
                                System.out.println("\nPor conta da resposta não ser 's' e nem 'n', vamos ter que");
                                System.out.println("refazer a pergunta em alguns segundos\n");
                                Thread.sleep(6000);
                                break;
                        }
                    }
                } else{
                    //Aqui vai ser para nós pesquisarmos o site
                    System.out.println("\n \nIndo para a tela de busca");
                    pesquisar pesquisar = new pesquisar();
                    pesquisar.buscar();
                }

                break;
            
            case "2":
                //Aqui é para caso o usuario desejar adicionar um site ao sistema
                System.out.println("\nRedirecionando para a tela de adicionar um site!\n");
                adicionarSite adicionar = new adicionarSite();
                adicionar.adicionarSite();
                break;
            
            case "3":
                //Aqui vamos mostrar os sites salvos em favoritos

                //Antes, vamos fazer uma lista que reorganize os favoritos, para que o usuário poss encontra-los
                List<String> listaFavoritosOrdemAlfabetica = sitesFavoritos.stream().sorted().collect(Collectors.toList());

                //Agora vamos criar uma variavel para o indice se o usuário quiser ver o site
                int i = 0;

                //Agora vamos mostrar as opções de sites dentro de favoritos
                for (String favoritos : listaFavoritosOrdemAlfabetica) {
                    //Aqui vai mostrar o site com seu indice
                    System.out.println(i + ". "+ favoritos);
                    i++;
                }

                //Agora vamos criar uma variavel para verificar a resposta do usuário, se o usuário quer abrir um dos sites acima ou não (que vai começar como false)
                boolean respostaAbrirSiteCheck = false;

                //Vamos dar start ao nosso while
                while(respostaAbrirSiteCheck == false){

                    //Vamos fazer a pergunta para o nosso usuário, para ver se ele deseja abrir algum dos sites
                    System.out.println("\n \nVocê deseja abrir um dos sites da lista de favoritos?");
                    System.out.print("(Escolha entre s/n) ");
                    String resposta = scanner.nextLine();

                    switch (resposta) {
                        case "s":
                            //Aqui é para caso o usuário queira abrir um dos sites listados
                            System.out.println("\nQual seria o site que você deseja?");
                            System.out.print("(Digite o número dele) ");
                            resposta = scanner.nextLine();

                            //Aqui vamos pegar o link do site que o usuário escolheu
                            List<String> LinkDoSite = buscarLink(listaFavoritosOrdemAlfabetica.get(Integer.parseInt(resposta)));

                            //Agora vamos entrar num bloco de código, que vai entrar no site
                            try {
                                URI link = new URI(LinkDoSite.get(0));
                                Desktop.getDesktop().browse(link);

                            } catch (Exception erro) {
                                System.out.println(erro);
                            }

                            respostaAbrirSiteCheck = true;
                            telaInicial();
                            break;

                        case "n":
                            //Aqui é para caso o usuário não queira abrir um dos sites listados
                            System.out.println("\nVoltando para a tela inicial do browser\n");
                            Thread.sleep(6000);

                            respostaAbrirSiteCheck = true;
                            telaInicial();
                            break;
                    
                        default:
                            //Aqui é para quando o usuário não coloca a resposta como o sistema pede
                            System.out.println("\nA resposta inserida está incorreta, iremos refazer a pergunta\n");
                            Thread.sleep(6000);
                            break;
                    }
                }

                break;
            
            case "4":
                //Para voltar para a tela inicial do smartPhone (aí não precisa colocar nenhum comando, somente mostrar para o usuário que está voltando para a tela inicial)
                System.out.println("\n \nVoltando para a tela inicial do smartPhone...\n");
                Thread.sleep(6000);
                break;
        
            default:
                //Aqui é para caso o usuário escolha uma resposta que não esteja na lista
                System.out.println("\nHouve um erro na leitura, por conta da resposta inserida não estar programada");
                System.out.println("no sistema, então o sistema irá se reinciar em alguns segundos");
                Thread.sleep(6000);

                //Para que o sistema do browser seja reinciado
                telaInicial();
                break;
        }
    }

    //Aqui vamos buscar o link do site
    protected List<String> buscarLink(String nomeSite){
        //variavel que vai armazenar os dados encontrados
        List<String> linkDoSite = new ArrayList<>();

        //Aqui vamos buscar o contato
        for (Map.Entry<String, String> par : getListaSite()) {
            if (par.getKey().equals(nomeSite)) {
                linkDoSite.add(par.getValue());
                break;
            }
        }

        //Agora vamos retornar as informações desse contato
        return linkDoSite;
    }
}

