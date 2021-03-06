package com.company.principal;
import com.company.enums.Horarios;
import com.company.enums.Membro;
import com.company.interfaces.Apresentacao;
import com.company.models.BigBrothers;
import com.company.models.HeavyLifters;
import com.company.models.MobileMembers;
import com.company.models.ScriptGuys;

import java.util.ArrayList;
import java.util.Scanner;

/** Principal.:
 * - Realiza varias operacoes, serve para rodar o principal codigo
 */
public class Principal implements Apresentacao {



    /** Uma lista de todos os "hackers" registrados.
     *
     * */
    private ArrayList<String> hackers = new ArrayList<String>();

    /**
     *  Membro, funcionando como enum para registro inicial
     */
    Membro membro;

    /**
     *  horarios, utilizado para registrar os possiveis horarios.
     */
    Horarios horarios = Horarios.REGULAR;

    /**
     * Usado para registrar input do usuario.
     */
    Scanner input = new Scanner(System.in);
    /**
     * Menu, feito para representar o loop de mensagems e possiveis escolhas.
     * @return escolha Output usado pelo metodo run() para ajudar em outras escolhas
     */
    private String menu() {
        System.out.println("Bem vindo ao sistema MAsK_S0c13ty");
        System.out.println("Escolha uma das seguintes opções.:");
        System.out.println("1 - Cadastrar novo h4ck3r");
        System.out.println("2 - H4ck3rs cadastrados");
        System.out.println("3 - Eliminar h4ck3r que fala muito");
        System.out.println("4 - Mudar horario");
        System.out.println("5 - Enviar mensagem para todos os h4ck3rs");
        System.out.println("6 - Sair por hoje");

        String escolha = this.input.nextLine();
        return escolha;
    }

    /**
     * Metodo cadastro.
     * Feito para inserir um novo membro na lista de hackers. Void
     */
    private String cadastro(){
        // Username
        System.out.println("Digitar o nome do h4ck3r.:");
        String nome = this.input.nextLine();

        // User email
        System.out.println("Digitar o email do h4ck3r.:");

        // User type
        String email = this.input.nextLine();
        System.out.println("Qual o tipo?");
        System.out.println("1 - Mobile Members");
        System.out.println("2 - Heavy Lifters");
        System.out.println("3 - Script Guys");
        System.out.println("4 - Big Brothers");
        String type = this.input.nextLine();
        switch (type){
            case "1":
                membro = Membro.MOBILE_MEMBERS;
                break;
            case "2":
                membro = Membro.HEAVY_LIFTERS;
                break;
            case "3":
                membro = Membro.SCRIPT_GUYS;
                break;
            case "4":
                membro = Membro.BIG_BROTHERS;

        }

        return (nome + ";" +  email + ";" + membro);
    }

    /**
     * Metodo usuarios.
     * Feito para colocar na tela todos os usuarios que tem na lista de hackers. Void.
     */
    private void usuarios(){
        for (String hacker: this.hackers) {
            String[] dados = hacker.split(";");
            System.out.println( "H4ck3r.: " + dados[0] + " " +
                                "E-mail.: " + dados[1] + " " +
                                "Classe.: " + dados[2]);
        }

    }


    /**
     *  Metodo apresentacao.
     *  Usado para escrever todos os possiveis valores da mensagem.
     */
    public void apresentacao(){
        for (String hacker: hackers) {
            String[] dados = hacker.split(";");
            switch (dados[2]){
                case "MOBILE_MEMBERS":
                    MobileMembers mm = new MobileMembers();
                    System.out.println(dados[0] + " - " + mm.postarMensagem(this.horarios));
                    break;
                case "HEAVY_LIFTERS":
                    HeavyLifters hl = new HeavyLifters();
                    System.out.println(dados[0] + " - " + hl.postarMensagem(this.horarios));
                    break;
                case "SCRIPT_GUYS":
                    ScriptGuys sc = new ScriptGuys();
                    System.out.println(dados[0] + " - " + sc.postarMensagem(this.horarios));
                    break;
                case "BIG_BROTHERS":
                    BigBrothers bb = new BigBrothers();
                    System.out.println(dados[0] + " - " + bb.postarMensagem(this.horarios));
                    break;
            }
        }
    }


    /**
     * Metodo deletar.
     * Remove um hacker da lista de hackers existentes.
     */
    private void deletar(){
        int pos = 0;
        for (String hacker: this.hackers) {
            String[] dados = hacker.split(";");
            System.out.println(pos + " - " + dados[0] + " - " + dados[2]);
            pos += 1;
        }
        String type = this.input.nextLine();
        System.out.println("Eliminando hacker...");
        this.hackers.remove(type);
    }


    /**
     * Metodo horario.
     * Feito para alternar o horario entre "Regular" e "Extra"
     */
    private void horario(){
        switch (this.horarios){
            case REGULAR:
            System.out.println("Mudando horário para.: Extra");
            this.horarios = Horarios.EXTRA;
            break;
            case EXTRA:
            System.out.println("Mudando horário para.: Regular");
            this.horarios = Horarios.REGULAR;
            break;
            default:
            System.out.println("System Error. Please contact administrators.");
            break;
        }
    }



    /**
     * Metodo run.
     * Usado para escolher qual metodo usar, de acordo com o user input.
     * 1 - Metodo cadástro, usado para registrar novos "hackers"
     * 2 - Metodo usuários, usado para ver todos os "hackers"
     * 3 - Metodo deletar, usado para eliminar um "hacker" que fala muito.
     * 4 - Metodo horário, usado para alternar horario "Regular" e "Extra"
     * 5 - Metodo Apresentação, interface usada para enviar mensagems a todos os hackers e dar display do que foi enviado.
     * 6 - Sair do loop.
     */
    public void run() {
        int exit = 0;
        while (exit == 0) {
            String escolha = menu();
            switch (escolha) {
                    // Novo hacker
                case "1":
                    System.out.println("Favor inserir os dados.");
                    hackers.add(cadastro());
                    System.out.println("H4ck3r cadastrado com sucesso.");
                    break;

                    // Todos os hackers
                case "2":
                    System.out.println("Todos os h4ck3rs cadastrados.:");
                    usuarios();
                    break;

                    // Remover hacker
                case "3":
                    System.out.println("Escolha o h4ck3r");
                    deletar();
                    break;

                    // Mudar horário
                case "4":
                    horario();
                    break;

                    // Output de todas as mensagems para cada hacker
                case "5":
                    System.out.println("Enviando mensagem geral. Relatório de mensagems enviadas.:");
                    for (String hacker: this.hackers) {
                        apresentacao();
                    }
                    break;

                    // Saindo código
                case "6":
                    System.out.println("Saindo...");
                    exit += 1;
                    break;

                default:
                    System.out.println("Input detectado não reconhecido. Favor tentar novamente.");
                    break;
            }
            System.out.println(" Voltando ao menu...");
        }
    }

}



