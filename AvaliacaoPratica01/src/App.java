import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        Utilitario utilitario = new Utilitario();
        

        ArrayList<Box> boxes = utilitario.criarBoxes();
        ArrayList<Mecanico> mecanicos = utilitario.criarMecanicos();    
        ArrayList<Servico> servicos = utilitario.criarServicos(); 
        ArrayList<Ordem> ordens = new ArrayList<>();

        int opcao;

        while(true){
            System.out.println("=== Menu de Opções ===");
            System.out.println("0 - Sair ou finalizar");
            System.out.println("1 - Cadastrar ordem de serviço");
            System.out.println("2 - Associr um mecânico a um box");
            System.out.println("3 - Atribuir ordem de serviço a um box");
            System.out.println("4 - Exibir todas as ordens atribuídas a um box específico");
            System.out.println("5 - Informar a quantidade total de ordens finalizadas por cada box");
            System.out.println("6 - Buscar ordens por status");
            System.out.println("7 - Exibir os detalhes completos de uma ordem específica");
            opcao = entrada.nextInt();

             if(opcao == 0){
                break;
            }


            if(opcao == 1){
                System.out.println("== Nova ordem de serviço ==");
                System.out.println("Informe o código da ordem:");
                String codigo = entrada.next();
                if(utilitario.existeOrdem(ordens, codigo)==null){
                    System.out.println("Informe seu nome:");
                    entrada.nextLine();
                    String nome = entrada.nextLine();
                    System.out.println("Informe o modelo do veículo:");
                    String modelo = entrada.nextLine();
                    System.out.println("Informe a placa do veículo:");
                    String placa = entrada.nextLine();
                    System.out.println("Informe o serviço desejado:");
                    String nomeServico = entrada.nextLine();
                    Servico servico = utilitario.existeServico(servicos, nomeServico);
                    if (servico!= null){
                        Ordem novaOrdem = new Ordem(codigo, nome, modelo, placa, servico);
                        ordens.add(novaOrdem);
                        System.out.println("Ordem cadastrada no sistema.");
                    } else {
                        System.out.println("Serviço indisponível ou inexistente");
                    }
                } else {
                    System.out.println("Já existe uma ordem com esse código.");
                }
            }

            if(opcao == 2){
                System.out.println("== Associar um mecânico a um box ==");

                System.out.println("Informe o nome do mecânico:");
                entrada.nextLine();
                String nomeMecanico = entrada.nextLine();
                Mecanico mecanico = utilitario.existeMecanico(mecanicos, nomeMecanico);
                if(mecanico!=null){

                    if(mecanico.getBox() != null){
                        System.out.println("Mecânico já associado a um box.");
                        continue;
                    }

                    System.out.println("Informe o número do box:");
                    int numeroBox = entrada.nextInt();
                    Box box = utilitario.existeBox(boxes, numeroBox);
                    if (box!=null){

                        if (box.getMecanico() != null){
                            System.out.println("Box já associado a um mecânico.");
                            continue;
                        }

                        mecanico.setBox(box);
                        box.setMecanico(mecanico);
                        System.out.println("Mecânico associado ao box.");

                    } else {
                        System.out.println("Box inexistente no sistema.");
                    }
                } else {
                System.out.println("Mecânico inexistente no sistema.");
                }
            }

            if(opcao == 3){
                System.out.println("== Atribuir ordem de serviço a um box ==");
                System.out.println("Informe o código da ordem:");
                String codigo = entrada.next();
                Ordem ordem = utilitario.existeOrdem(ordens, codigo);
                if (ordem != null){
                    System.out.println("Informe o número do box:");
                    int numeroBox = entrada.nextInt();
                    Box box = utilitario.existeBox(boxes, numeroBox);
                    if (box != null){
                        box.atribuirOrdem(ordem);
                        ordem.setBox(box);
                    } else {
                        System.out.println("Box inexistente no sistema.");
                    }
                } else {
                    System.out.println("Ordem inexistente no sistema.");
                }
            }

             if(opcao == 4){
                System.out.println("== Exibir ordens de um box específico ==");
                System.out.println("Informe o número do box:");
                int numeroBox = entrada.nextInt();
                Box box = utilitario.existeBox(boxes, numeroBox);
                if (box != null){
                    int quantidade = box.exibirOrdens();
                    System.out.println("Total de ordens do box: " + quantidade);
                } else {
                    System.out.println("Box inexistente no sistema");
                }
            }

            if(opcao == 5){
                System.out.println("== Quantidade de ordens finalizadas para cada box ==");
                for (Box b : boxes){
                    System.out.println(b);
                    System.out.println("Total de ordens finalizadas: " + b.qtdOrdensFinalizadas());

                }
            }

            if(opcao == 6){
                System.out.println("== Buscar ordens por status ==");
                System.out.println("Informe o status procurado: (Aberta, Em execucao, Finalizada):");
                entrada.nextLine();
                String status = entrada.nextLine();
                if((!status.equalsIgnoreCase("Aberta")) && (!status.equalsIgnoreCase("Em execucao")) && (!status.equalsIgnoreCase("Finalizada"))){
                    System.out.println("Status informado é inválido.");
                    continue;
                }
                System.out.println("Resultado da busca:");
                for(Ordem o : ordens){
                    if(o.getStatus().equalsIgnoreCase(status)){
                        System.out.println(o);
                    }
                }
            }

             if(opcao == 7){
                System.out.println("== Exibir detalhes de uma ordem específica ==");
                System.out.println("Informe o código da ordem desejada:");
                String codigo = entrada.next();
                Ordem ordem = utilitario.existeOrdem(ordens, codigo);
                if (ordem == null){
                    System.out.println("Ordem inexistente no sistema.");
                    continue;
                }
                System.out.println("Informações da ordem:");
                System.out.println(ordem);
                
            }
        }

        entrada.close();
    }
}
