package edu.DIO.model.browser.arquivoSistema;

import java.util.Scanner;

import edu.DIO.model.browser.Browser;

public class adicionarSite extends Browser {
    //vamos iniciar o scanner
    private static Scanner scanner = new Scanner(System.in);

    //Aqui vamos armazenar o nome do site
    private String nomeSite;

    //Aqui vamos armezar o link do site
    private String linkSite;

    //Aqui vamos iniciar nosso sistema para salvar o site
    public void adicionarSite() throws InterruptedException {

        //Vamos dar introdução ao nosso sistema para adicionar um site
        System.out.println("\n \nPara salvar um novo site no sistema do browser vamos precisar");
        System.out.println("obrigatóriamente do nome do site e de seu link, por conta dele");
        System.out.println("funcionar a partir de adições de sites (tornando um browser mais");
        System.out.println("customizado comparado com os outros) \n \n");

        //Vamos dar um tempinho de introdução
        Thread.sleep(12000);

        //Vamos criar uma variavel para ver se as resposta do usuário estão corretas (nesse caso, se nenhuma é vazia) [vamos começar como false]
        boolean respostaCheck = false;

        //Agora vamos criar nosso while para ficar repetindo as perguntas até o usuário colocar tudo certinho
        while(respostaCheck == false){

            //Aqui vamos pegar o nome do site que usuário quer salvar
            System.out.println("\nPrimeiro coloque o nome do site: ");
            System.out.println("(Dica: não invente o nome do site e sim coloque o seu nome verdadeiro)\n");
            nomeSite = scanner.nextLine();

            //Aqui vamos pegar o link do site
            System.out.println("\n \nAgora coloque o link do site: ");
            System.out.println("(Dica: coloque o link do site de mesmo nome, para que não haja problemas no futuro)\n");
            linkSite = scanner.nextLine();

            //Agora vamos verificar se o nomeSite é vazio ou só contém espaços (resumindo sem letras)
            if(!nomeSite.isBlank() && !verificarListaSiteExiste(nomeSite, null)){
                
                //Agora vamos fazer uma nova verificação, testando para ver se o link inserido é um link valido
                if(linkSite.matches("^(http|https)://.*$") && !verificarListaSiteExiste(null, linkSite)){
                    System.out.println("\n \nNome do site e link estão validos salvando os dados");
                    Thread.sleep(6000);

                    //Agora vamos sair do while, pois as resposta do usuário estão certas
                    respostaCheck = true;

                } else{
                    //Aqui é para caso o link inserido pelo usuário seja invalido
                    System.out.println("\n \nO link inserido é invalido (por conta de não ser ou já ter sido inserido no sistema), então...");
                    System.out.println("por favor, tente novamente, porém antes de inseri-lo novamente, verifique ele antes\n \n");

                    //Aqui está tempo, para que usuário leia e veja aonde foi o erro
                    Thread.sleep(600);

                }

            } else{
                //Aqui é para caso o nome inserido pelo usuário seja invalido
                System.out.println("\n \nO nome inserido está invalido por conta de conter somente espaço ou nada, ou por");
                System.out.println("conta desse site já existir no sistema, então na próxima vez verifeque ele antes \n \n");

                //Aqui está tempo, para que usuário leia e veja aonde foi o erro
                Thread.sleep(6000);
            }

        }

        //Agora vamos salvar ele na nossa variavel listaSite
        setListaSite(nomeSite, linkSite);

        //Mostrar para o usuário que o site foi salvo com sucesso
        System.out.println("\n \nSite salvo com sucesso\n \n");

        //Agora vamos dar um tempo para o usuário ler o conteúdo
        Thread.sleep(3000);

        //Agora vamos criar uma nava variavel de controle para sabermos se usuário quer salvar este site na lista de favoritos (vamos inciar como falso)
        boolean respostaSalvarFavoritosCheck = false;

        //Agora vamos criar o nosso while, para verificar se a resposta está correta
        while (respostaSalvarFavoritosCheck == false) {

            //Aqui vamos peguntar se o usuário quer salvar o novo site inserido na lista de favoritos
            System.out.println("\n \nVocê deseja adicionar o site na lista de favoritos?");
            System.out.print("(Escolha s/n) ");
            String respostaSalvarFavoritos = scanner.nextLine();

            //Vamos iniciar nosso bloco de decisão
            switch (respostaSalvarFavoritos) {
                case "s":
                    //Para caso o usuário tenha colocado que sim
                    System.out.println("\n \nSalvando o site na área de favoritos");
                    salvarFavoritos salvarSite = new salvarFavoritos();
                    salvarSite.adicionarFavoritosPartirAdicionarSite(nomeSite);

                    //Para sair do while
                    respostaSalvarFavoritosCheck = true;
                    break;

                case "n":
                    //Para caso o usuário tenha colocado que não
                    System.out.println("\n \nVoltando para a tela inicial do Browser\n");

                    //Para sair do while
                    respostaSalvarFavoritosCheck = true;
                    telaInicial();
                    break;

                default:
                    //Para caso o usuário tenha colocado uma resposta que não está no sistema
                    System.out.println("\n \nA resposta inserida não está de acordo com o que o sistema pede, então");
                    System.out.println("você terá que responder a pergunta\n");

                    //Aqui está tempo, para que usuário leia e veja aonde foi o erro
                    Thread.sleep(6000);
                    break;
            }
            
        }

    }
    
}
