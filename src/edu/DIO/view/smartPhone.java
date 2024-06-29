package edu.DIO.view;
import java.io.IOException;
import java.util.Scanner;

import edu.DIO.model.browser.Browser;
import edu.DIO.model.tPod.tPod;
import edu.DIO.model.telefone.Telefone;

public class smartPhone {
    public static void main(String[] args) throws InterruptedException, IOException {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("Aperte a tecla quatro para ligar o smartPhone!");
        int repostaLigar = scanner.nextInt();
        scanner.nextLine();

        //Aqui é para deixar nosso smartphone ligado, até que o usuário decida desliga-lo
        while(repostaLigar == 4){
            //Aqui vamos mostrar ao usuário os aplicativos que ele tem instalado
            System.out.println("\n \n \nOlá, sejá bem-vindo a tela inicial do seu smartPhone");
            System.out.println("Por favor, escolha uma dos aplicativos disponiveis");
            System.out.println("    1. tPod ");
            System.out.println("    2. Browser ");
            System.out.println("    3. Telefone");
            System.out.println("    4. Para desligar");

            System.out.println("\n \nPara fazer a escolha a parte o número, que o aplicativo aparece");
            System.out.print("\nInsira o número: ");
            String resposta = scanner.nextLine();


            //Aqui vamos ver o que o usuário quer incializar (tPod, navegador a internet [no caso Buscar], ligação, ou desligar)
            switch (resposta) {
                
                //Para caso o usuário selecione a opção um, vamos dar inicio ao tPod
                case "1":
                    System.out.println("\n \n \nAbrindo o tPod... \n");
                    tPod tocaMusica = new tPod();
                    tocaMusica.telaInicial();
                    break;
                
                //Para caso o usuário selecione a opção dois, vamos dar inicio ao Buscar
                case "2":
                    System.out.println("\n \n \nAbrindo o Browser... \n");
                    //Vou deixar esse código abaixo como comentário, para que seja realizado o teste e depois dado o procedimento
                    Browser navegador = new Browser();
                    navegador.telaInicial();
                    break;

                //Para caso o usuário selecione a opção três, vamos dar inicio ao Buscar
                case "3":
                    System.out.println("\n \n \nAbrindo o Telefone... \n");
                    
                    //Vou deixar esse código abaixo como comentário, para que seja realizado o teste e depois dado o procedimento
                    Telefone telefone = new Telefone();
                    telefone.telaInicial();
                    break;
                
                //Para caso o usuário selecione a opção quatro, vamos desligar o smartPhone
                case "4":
                    System.out.println("\n \n \nDeligando o smatPhone \n");
                    repostaLigar--;
                    break;
            
                default:
                    System.out.println("Deu erro desconhecido, o smartPhone vai se reiniciar em 10 segundos\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n");
                    Thread.sleep(10000);
                    break;
            }
        }
    }
}
