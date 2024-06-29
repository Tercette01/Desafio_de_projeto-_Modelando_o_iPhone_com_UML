package edu.DIO.model.telefone;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import edu.DIO.model.telefone.arquivoSistema.adicionarContato;
import edu.DIO.model.telefone.arquivoSistema.editarContato;
import edu.DIO.model.telefone.fazerLigacao.realizarLigacao;

public class Telefone {
    //Aqui vamos dar inicio a nossa variavel scanner
    private Scanner scanner = new Scanner(System.in);

    //Aqui está nossa variavel que vai ser nossa variavel de contato
    protected static ArrayList<String> contato = new ArrayList<>();
    public static String getContato(int posicao) {
        String resposta = contato.get(posicao);
        return resposta;
    }
    public static void setContato(String newContato) {
        contato.add(newContato);
    }

    //Aqui está nossa variavel para gravar os dados do usuário, desde email, endereço, número telefonico e etc
    private static List<Map.Entry<String, String>>  contatoESeusDados = new ArrayList<>();
    public static List<Map.Entry<String, String>> getContatoESeusDados() {
        return contatoESeusDados;
    }
    public static void setContatoESeusDados(String newContato, String newInformacoes) {
        contatoESeusDados.add(new AbstractMap.SimpleEntry<>(newContato, newInformacoes));
    }
    //Aqui é para alterar um valor dentro de contato
    public static void editarContatoESeusDados(int indiceChave, String Contato, String newInformacoes){
        contatoESeusDados.set(indiceChave, new AbstractMap.SimpleEntry<>(Contato, newInformacoes));
    }

    public void telaInicial() throws InterruptedException {
        //Aqui vamos adicionar a opção do nosso usuário a adicionar ou editar um contato
        if(!contato.contains("adicionar novo contato") && !contato.contains("editar contato existente")){
            contato.add("editar contato existente");
            contato.add("adicionar novo contato");
            contato.add("Discagem");
        }

        //Aqui vamos dar inicio a tela para o nosso usuário
        System.out.println("\n \n \nSeja bem-vindo ao telefone");
        System.out.println("\nSe você tiver algum contato vai aparecer logo abaixo, se");
        System.out.println("não aparecer, e somente aparecer para você adicionar, então");
        System.out.println("você ainda não tem contatos ainda. \n");

        //variavel de segurança
        int resposta;

        //Aqui vamos criar nossa variavel, para caso o usuário queira sair do telefone (que já comoeçar como false)
        boolean sairDoTelefone = false;

        //A partir daqui vamos criar um while para que o usuário só sai do telefone, quando ele quiser
        while(sairDoTelefone == false){

            //Aqui chamamos o método para realizar a pesquisa para o usuário
            if(contato.size() > 3){
                
                //Para quando o usuário tiver contatos
                System.out.println("\n \n \nSeja bem-vindo novamente a tela do telefone");
                System.out.println("\nPara sair do telefone digite -1");
                resposta = pesquisarContato(0);

            } else {
                //Para quando o usuário não tiver contatos
                System.out.println("\nPara sair do telefone digite -1");
                resposta = pesquisarContato(1);
            }

            if(resposta == -1){
                //Aqui vamos para a tela do smartPhone
                System.out.println("\nVoltando para a tela do smartPhone\n");
                Thread.sleep(6000);
                sairDoTelefone = true;
                break;

            } else if(resposta == 0){
                //Aqui vamos para a tela de editar um contato já existenet
                System.out.println("\n \nRedirecionando para a tela para editar um contato");
                editarContato editarContato = new editarContato();
                editarContato.editar();

            } else if(resposta == 1){
                //Aqui vamos para a tela de adicionar um novo contato
                System.out.println("\n \nRedirecionando para a tela para adicionar um contato");
                adicionarContato adicionarContato = new adicionarContato();
                adicionarContato.adicionar(0);

            } else if(resposta == 2){
                scanner.nextLine();

                //Agora é para caso o usuário deseja ligar para um contato que não esteja na lista
                System.out.println("\n \nDigite logo abaixo o número de telefone que deseja ligar");
                String numeroTelefonico = scanner.nextLine();

                if(numeroTelefonico.matches("\\d+")){
                    //Para caso o usuário tenha inserido somente números
                    realizarLigacao ligarDiscagem = new realizarLigacao();
                    ligarDiscagem.Discagem(numeroTelefonico);

                }else {
                    //Para caso o usuário não tenha colocado somente números
                    System.out.println("\n \nPor conta da resposta inserida não conter somente números");
                    System.out.println("Ocorreu um erro de sistema, o aplicativo telefone terá que");
                    System.out.println("ser reiniciado \n \n");
                    Thread.sleep(6000);

                }

            }else {
                scanner.nextLine();

                //Aqui vamos perguntar para o usuário se é esse contato 
                System.out.println("\nAntes de realizar a ligação, vamos");
                System.out.println("verificar se é esse contato mesmo! \n");

                //Aqui vamos mostrar o contato que o usuário selecionou
                System.out.println("Nome " + getContato(resposta));
                //Aqui vamos mostrar quais alterações tem o contato
                vizualizarContato(getContato(resposta)).stream().forEach(elemento -> System.out.print(elemento + " "));

                //Aqui é nossa variavel de controle, para caso a resposta for dada de maneira correta (vamos incia-la como false)
                boolean repostaCheck = false;

                while(repostaCheck == false){
                    System.out.println("\nDeseja efetuar ligação ou voltar para a tela de contatos?");
                    System.out.print("(digite ligar/retornar) ");
                    String respostaLigarOuRetornar = scanner.nextLine();

                    //Agora vamos entrar no if, para saber qual a resposta do usuário
                    if(respostaLigarOuRetornar.equals("ligar")){

                        //Aqui é para o usuário queira efetuar a ligação
                        realizarLigacao ligar = new realizarLigacao();
                        ligar.efetuarLigacao(getContato(resposta));
                        repostaCheck = true;

                    } else if (respostaLigarOuRetornar.equals("retornar")){

                        //Aqui é para quando o usuário deseja retornar a tela de contatos
                        System.out.println("\nRetornando a tela de contatos");
                        Thread.sleep(5000);
                        repostaCheck = true;

                    } else {

                        //Aqui é para quando o usuário inseriu a resposta errada
                        System.out.println("A resposta foi inserida incorretamente, reiniciando a pergunta");
                    }
                }
            }
        }
    }

    //Nesse método, vamos simplificar um pouco o código, assim podemos fazer as pesquisas em qualquer lugar do nosso arquivo, sem ficar muito grande e complexo
    //Só para adicionar o porque da variavel valorDePesquisa, pois vamos chamar esse método nos seus filhos que não precisam mostrar "adicionar um novo contato" ou "editar contato"
    protected int pesquisarContato(int valorDePesquisa){

        //Aqui vamos mostrar os contatos que o usuário tem no nosso sistema
        for(int i = valorDePesquisa; i < contato.size(); i++){
            System.out.println((i - valorDePesquisa) + ". " + contato.get(i));
        }

        //Aqui vamos capturar qual a opção que o usuário escolheu
        System.out.print("\nEscolha a opção a partir do número: ");
        int resposta = scanner.nextInt();

        return resposta + valorDePesquisa;
    }

    protected List<String> vizualizarContato(String nomeContato){
        //variavel que vai armazenar os dados encontrados
        List<String> dadosDoContato = new ArrayList<>();

        //Aqui vamos buscar o contato
        for (Map.Entry<String, String> par : getContatoESeusDados()) {
            if (par.getKey().equals(nomeContato)) {
                dadosDoContato.add(par.getValue());
                break;
            }
        }

        //Agora vamos retornar as informações desse contato
        return dadosDoContato;
    }
}
