package edu.DIO.model.telefone.arquivoSistema;

import java.util.Scanner;

import edu.DIO.model.telefone.Telefone;

public class adicionarContato extends Telefone {
    //Vamos dar inicio ao nosso scanner
    private Scanner scanner = new Scanner(System.in);

    //Agora vamos colocar as variaveis de informações
    //variavel de nome
    private String nome;

    //variavel de número de telefone
    private String numeroTelefonico;

    //variavel de email
    private String email;

    //variavel de endereço
    private String endereco;

    private boolean tudoPreenchidoCorretamente = false;

    //Vamos dar inicio ao nosso método de adicionar um novo usuário
    public void adicionar(int numeroDeDiscagem) throws InterruptedException {
        System.out.println("\n \nAntes de adicionar um novo contato, vamos preencher alguns detalhes");

        //Vamos criar um while, para verificar se todas as informações foram preenchidas corretamente
        while(tudoPreenchidoCorretamente == false){
            //A partir daqui, vamos pedir detalhes de novo contato

            //Aqui vamos entrar em um if, pois é para caso o usuário tenha salvo um usuário a partir da ligação
            if(numeroDeDiscagem == 0){

                //Se o usuário decidio adicionar um novo contato a partir da tela inicial do telefone
                System.out.print("\nPrimeiro adicione o número para o novo contato: ");
                numeroTelefonico = scanner.nextLine(); 

            } else {

                //Se o usuário decidio adicionar a partir da tela de discagem
                numeroTelefonico = Integer.toString(numeroDeDiscagem);
            }

            //Aqui vamos pedir o nome desse novo contato
            System.out.print("\nPor favor coloque o nome do novo contato: ");
            nome = scanner.nextLine();

            //Aqui vamos pedir o email do novo contato (porém somente se o usuário quiser)
            System.out.print("\nVai querer adicionar um email a este contato: ");
            String resposta = scanner.nextLine();

            //Aqui vamos entrar no if para verificar se sim, ele colocará um email se não, vamos adicionar um null
            if(resposta.equals("s")){

                //Como foi colocado sim, vamos adicionar o email no novo contato
                System.out.print("\nDigite aqui o email do novo contato: ");
                email = scanner.nextLine();

            } else if(resposta.equals("n")){

                //Como foi colocado não, vamos colocar um null no email
                email = "email nao adicionado";

            } else {

                //Para caso o usuário decida colocar algo além de s ou n
                System.out.println("Mensagem inserida incorretamente (o que gerou um erro), voltando para a tela inicial de telefone");
                telaInicial();

            }

            //Aqui vamos pedir o endereço do novo contato (porém somente se o usuário quiser)
            System.out.print("\nVai querer adicionar um endereço a este contato: ");
            resposta = scanner.nextLine();

            //Aqui vamos fazer a mesma coisa que o email, vamos verificar se o usuário vai querer adicionar um endereço
            if(resposta.equals("s")){

                //Como foi colocado sim, vamos adicionar o email no novo contato
                System.out.print("\nDigite aqui o endereço do novo contato: ");
                endereco = scanner.nextLine();

            } else if(resposta.equals("n")){

                //Como foi colocado não, vamos colocar um null no email
                endereco = "endereço nao adicionado";

            } else {

                //Para caso o usuário decida colocar algo além de s ou n
                System.out.println("Mensagem inserida incorretamente (o que gerou um erro), voltando para a tela inicial de telefone");
                telaInicial();

            }

            //Aqui vamos analisar se todas as repostas foram inseridas corretamente

            //Vamos ver se o numero do telefone é somente numero ou tem letra
            if(numeroTelefonico.matches("\\d+")){
                tudoPreenchidoCorretamente = true;
                
                //Vamos ver se o usuário colocou o email corretamente (se colocou email)
                if((email.contains("@") && email.contains(".com")) || email == "email nao adicionado"){
                    tudoPreenchidoCorretamente = true;

                    //Para verificar se o usuário já existe
                    if(!contato.contains(nome)){
                        tudoPreenchidoCorretamente = true;

                    } else{
                        //Aqui é para caso o contato adicionado já exista
                        System.out.println("\nO contato já existe");
                        Thread.sleep(6000);
                        tudoPreenchidoCorretamente = false;

                    }

                } else {
                    //Aqui é para caso o usuário tenha colado um email não valido
                    System.out.println("\nO email do novo contato é invalido"); 
                    Thread.sleep(6000);    
                    tudoPreenchidoCorretamente = false;
                }

            } else{
                //Aqui é para caso o usuário tenha colocado o letra no número de telefone
                System.out.println("\nO número de telefone, só pode ter número"); 
                Thread.sleep(6000);    
                tudoPreenchidoCorretamente = false;
            } 
        }

        //A partir daqui, vai ser o nosso código para salvar o novo usuário
        //Aqui é para juntar as informações em um só bloc de texto
        String informacaoDoNovoUsuario = "\nNúmero de telefone: " + numeroTelefonico + ";\nEndereço de email: " + email + ";\nEndereço de " + nome + ": " + endereco;

        //Agora podemos adicionar tudo em um lugar só
        setContato(nome);
        setContatoESeusDados(nome, informacaoDoNovoUsuario);

        //Agora vamos retornar para a tela de telefone
        telaInicial();
    }
    
}
