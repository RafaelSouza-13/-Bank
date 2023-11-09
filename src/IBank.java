import java.util.Scanner;

import controller.BancoController;
import controller.ClienteController;
import controller.ContaController;
import view.BancoView;
import view.ClienteView;
import view.ContaView;

public class IBank {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ClienteController clienteController = new ClienteController();
        ContaController contaController = new ContaController();
        BancoController bancoController = new BancoController();
        ClienteView clienteView =  new ClienteView();
        ContaView contaView = new ContaView();
        BancoView bancoView = new BancoView();
        boolean executar = true;
        while(executar){
            String escolha = bancoView.menu(scanner);
            switch (escolha) {
                case "1":
                    clienteView.cadastrarCliente(scanner, clienteController, contaController, bancoController);
                    break;
                case "2":
                    contaView.depositar(scanner, contaController, bancoController);
                    break;
                case "3":
                    contaView.sacar(scanner, contaController, bancoController);
                    break;
                case "4":
                    contaView.transferir(scanner, contaController, bancoController);
                    break;
                case "5":
                    contaView.extrato(scanner, contaController, bancoController);
                    break;
                case "6":
                    bancoView.exibeContas(bancoController);
                    break;
                case "0":
                    System.out.println("Encerrando o programa!");
                    executar = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
        scanner.close();
    }
}
