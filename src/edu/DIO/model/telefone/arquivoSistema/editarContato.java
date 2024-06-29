package edu.DIO.model.telefone.arquivoSistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import edu.DIO.model.telefone.Telefone;

public class editarContato extends Telefone {
    //Vamos dar inicio ao nosso scanner
    private Scanner scanner = new Scanner(System.in);

    //Agora vamos colocar as variaveis de informações
    //variavel de nome
    private String nome;

    //variavel de número de telefone
    private String newNumeroTelefonico;

    //variavel de email
    private String newEmail;

    //variavel de endereço
    private String newEndereco;

    //variavel para armazenar as informações
    private List<String> buscarInformacao = new ArrayList<>();

    //Vamos dar inicio ao nosso método de edição de contato
    public void editar() {
        System.out.println("\nAntes de iniciar a editar um contato! Escolha");
        System.out.println("um dos contatos que você tem na lista");

        //Aqui vamos saber qual contato o usuário vai escolher para modificar
        int contatoParaModificar = pesquisarContato(3);

        //Aqui colocamos o nome que vai ser modificado
        nome = getContato(contatoParaModificar);

        System.out.println("\n \nAntes de iniciar a modificação, o sistema vai mostrar");
        System.out.println("uma pré-vizualização do contato selecionado");

        //Aqui vamos mostrar a pré-vizualização
        System.out.println("\nNome: " + nome);

        //variavel para pegar o indice da chave
        int indiceEncontrado = 0;

        //Aqui vamos pegar as informações do contato, além disso, também vamos pegar o indice da chave
        for (Map.Entry<String, String> par : getContatoESeusDados()) {
            if (par.getKey().equals(nome)) {
                buscarInformacao.add(par.getValue());
                indiceEncontrado = buscarInformacao.size() - 1; // O índice é o tamanho atual da lista menos 1
                break; // Se encontrou, pode sair do loop
            }
        }

        //Aqui vamos mostrar quais alterações tem o contato
        buscarInformacao.stream().forEach(elemento -> System.out.print(elemento + " "));

        //Aqui é a variavel que iremos trabalhar dentro de nosso programa
        List<String> editarInformacao = new ArrayList<>();

        //Aqui vamos dividir nossa variavel para pegar os valores, como telefone, email e endereço
        for (String elemento : buscarInformacao) {
            String[] linhas = elemento.split("\n"); // Divide cada elemento em linhas
            for (String linha : linhas) {
                String[] partes = linha.split(":"); // Divide cada linha em partes usando ":"
                if (partes.length == 2) {
                    String valor = partes[1].trim(); // Pega o valor e remove espaços em branco
                    editarInformacao.add(valor);
                }
            }
        }

        //Agora vamos começar a dar uma olhada no que o usuário que alterar

        //Aqui vamos ver se o usuário que alterar o numero telefonico do contato
        System.out.println("\n \nDeseja alterar o número telefonico? ");
        System.out.print("(digite s/n) ");
        String resposta = scanner.nextLine();

        //Agora vamos dar uma olhada na resposta do usuário
        if(resposta.equals("s")){

            //Nossa variavel de controle, para caso o usuário não tenha colocado somente números no número telefonico (já vamos começar como falso)
            boolean numeroCheck = false;

            //Esse while vai servir para ver se o número telefonico, somente é número
            while(numeroCheck == false){

                //Se o usuário digitou sim, vamos alterar o número
                System.out.print("\nDigite aqui o novo número: ");
                newNumeroTelefonico = scanner.nextLine();

                if(newNumeroTelefonico.matches("\\d+")){
                    numeroCheck = true;

                 }else {
                    //Para caso o usuário não tenha colocado somente números
                    System.out.println("O novo número telefonico só pode conter números, tente novamente!");

                }
            }

        }else if (resposta.equals("n")){
            //Para caso o usuário tenha digitado não, vamos manter o número telefonico
            newNumeroTelefonico = editarInformacao.get(0).replace(";", "");
        }

        //Aqui vamos ver se o usuário que alterar o email do contato
        System.out.println("\nDeseja alterar o email? ");
        System.out.print("(digite s/n) ");
        resposta = scanner.nextLine();

        //Agora vamos dar uma olhada na resposta do usuário
        if(resposta.equals("s")){
            
            //Nossa variavel de controle, para caso o usuário não tenha colocado o email corretamente (já vamos começar como falso)
            boolean emailCheck = false;

            //Esse while vai servir para ver se o email colocado tem @ e .com
            while(emailCheck == false){

                //Se o usuário digitou sim, vamos alterar o email
                System.out.print("\nDigite aqui o novo email: ");
                newEmail = scanner.nextLine();

                //Vamos ver se o usuário colocou o email corretamente
                if(newEmail.contains("@") && newEmail.contains(".com")){
                    emailCheck = true;

                }else {
                    //Para caso o usuário não tenha colocado o email corretamente
                    System.out.println("O novo email foi inserido incorretamente, tente novamente!");

                }
            }

        }else if (resposta.equals("n")){
            //Para caso o usuário tenha digitado não, vamos manter o email
            newEmail = editarInformacao.get(1).replace(";", "");
        }

        //Aqui vamos ver se o usuário que alterar o endereço do contato
        System.out.println("\nDeseja alterar o endereço? ");
        System.out.print("(digite s/n) ");
        resposta = scanner.nextLine();

        //Agora vamos dar uma olhada na resposta do usuário
        if(resposta.equals("s")){

            //Se o usuário digitou sim, vamos alterar o número
            System.out.print("\nDigite aqui o novo endereço: ");
            newEndereco = scanner.nextLine();

        }else if (resposta.equals("n")){
            //Para caso o usuário tenha digitado não, vamos manter o número telefonico
            newEndereco = editarInformacao.get(2);
        }

        //Aqui é para juntar as informações em um só bloco de texto
        String informacaoDoNovoUsuario = "\nNúmero de telefone: " + newNumeroTelefonico + ";\nEndereço de email: " + newEmail + ";\nEndereço de " + nome + ": " + newEndereco;

        //Aqui é para salvar as alterações feitas
        editarContatoESeusDados(indiceEncontrado, nome, informacaoDoNovoUsuario);
    }
    
}
