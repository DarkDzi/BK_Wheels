package org.example;

import java.util.Scanner;

public class MenuUI {
    private QRgenerator qrgen = new QRgenerator();
    private boolean menu = true;
    private Scanner sc = new Scanner(System.in);
    private Scanner scan = new Scanner(System.in);
       public void MostrarMenu() {
           while (menu) {
               try {
                   System.out.println("===========Bem vindo ao Menu===========");
                   System.out.println("Oque deseja fazer?");
                   System.out.println("1. Gerar um QRCode para uma bicicleta");
                   System.out.println("2. Listar QRCodes já existentes");
                   System.out.println("3. Deletar um QrCode Existente ");
                   System.out.println("4. Sair");
                   System.out.println("=======================================");
                   String opcaoStr = scan.nextLine();
                   int opcao = Integer.parseInt(opcaoStr);


                   switch (opcao) {
                       case 1:
                           System.out.println("1. Gerar mais de uma QRCode");
                           System.out.println("2. Gerar um unico QRCode");
                           int genop = sc.nextInt();
                           if (genop == 1) {
                               System.out.println("Quantos códigos você deseja gerar?");
                               int codenumber = sc.nextInt();
                               System.out.println("Quais são os numeros de indentificação das bicicletas digite no formato 1,2,3... ");
                               String ids = scan.nextLine();
                               String[] bikeid = ids.split(",");
                               if (ids.matches("^\\d+(,\\d+)*$")) {
                                   for (int i = 0; i < codenumber; i++) {
                                       qrgen.GenerateQR(Integer.parseInt(bikeid[i]));
                                   }
                               } else {
                                   System.out.println("Identificação de bicicleta inválida");
                               }

                           } else if (genop == 2) {
                               System.out.println("Qual o numero de indentificação da bicicleta ?");
                               int bikeid = sc.nextInt();
                               qrgen.GenerateQR(bikeid);
                               System.out.println("Aperte qualquer tecla pra continuar");
                               scan.nextLine();
                           } else {
                               System.out.println("Opção inválida");
                           }


                           break;
                       case 2:
                           System.out.println("========Lista de Códigos======");
                           qrgen.ListarQRCodes();
                           System.out.println("=============================");
                           System.out.println("Aperte qualquer tecla pra continuar");
                           scan.nextLine();
                           break;
                       case 3:
                           qrgen.DeletarQrCodes();
                           break;
                       case 4:
                           menu = false;
                           break;
                       default:
                           System.out.println("Opção não indentificada digite uma opção válida");
                           break;
                   }
               } catch (Exception e) {
                   System.out.println("Algo deu errado, certifiqui-se de digitar tudo de forma correta");
                   System.out.println("Erro: " + e.getMessage());
               }
                   System.out.println();
           }
       }
}
