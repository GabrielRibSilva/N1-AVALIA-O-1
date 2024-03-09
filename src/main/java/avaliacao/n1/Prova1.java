/*
 * Copyright (C) 2024 Gabriel Cândido <gcrs2018@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package avaliacao.n1;

/**
 *
 * @author Gabriel Cândido <gcrs2018@gmail.com>
 * @date 08/03/2024
 * @brief Class Prova1
 */
import java.util.*;

public class Prova1 {

    public static void main(String[] args) {

        int opcao = 0, qde_expresso = 0, qde_capuccino = 0,
                qde_leite_com_cafe = 0, qde_cafes_vendidos, qde_cafe_com_avela = 0;
        double valor_expresso, valor_capuccino,
                valor_leite_com_cafe, valor_cafes_vendidos, valor_cafe_com_avela;

        Scanner sc = new Scanner(System.in);
        //estrutura de repetição para informar o numero de pedidos desejados
        do {

            System.out.println("Forneça uma opção: \n"
                    + "1 ­ café expresso; \n"
                    + "2 ­ café capuccino; \n"
                    + "3 ­ leite com café; \n"
                    + "4 ­ leite com avelã; \n"
                    + "5 ­ remover algum produto; \n"
                    + "6 ­ totalizar vendas;");

            opcao = sc.nextInt();
            //de acordo com a resposta do usuario ele irá adicionar no carrinho o item desejado
            if (opcao == 1) {
                qde_expresso++;
            } else if (opcao == 2) {
                qde_capuccino++;
            } else if (opcao == 3) {
                qde_leite_com_cafe++;
            } else if (opcao == 4) {
                qde_cafe_com_avela++;
            } else if (opcao == 5) {
                int opc_revm = 0;
                //laço de repetição para remover o item do carrinho
                while (opc_revm == 5) ;
                {
                    System.out.println("Qual opção que deseja remover?\n"
                            + "1 ­ café expresso; \n"
                            + "2 ­ café capuccino; \n"
                            + "3 ­ leite com café; \n"
                            + "4 ­ leite com avelã; \n"
                            + "5 ­ sair");
                    opc_revm = sc.nextInt();
                    if (opc_revm != 5) {
                        switch (opc_revm) {
                            case 1:
                                qde_expresso--;
                                break;
                            case 2:
                                qde_capuccino--;
                                break;
                            case 3:
                                qde_leite_com_cafe--;
                                break;
                            case 4:
                                qde_cafe_com_avela--;
                                break;
                        }
                    } else {
                        break;
                    }
                }
            } else if (opcao != 7) {
                System.out.println("Opção inválida");
            }

        } while (opcao != 7);
        {
            //calculo de quanto foi gasto (multiplica a quantidade consumida pelo valor de cada)
            valor_expresso = qde_expresso * 0.75;
            valor_capuccino = qde_capuccino * 1;
            valor_leite_com_cafe = qde_leite_com_cafe * 1.25;
            valor_cafe_com_avela = qde_cafe_com_avela * 2;
            qde_cafes_vendidos = qde_expresso + qde_capuccino + qde_leite_com_cafe + qde_cafe_com_avela;
            valor_cafes_vendidos = valor_expresso + valor_capuccino + valor_leite_com_cafe + valor_cafe_com_avela;
            //exibir na tela a quantidade e valor gasto
            System.out.println("Qde café expresso: " + qde_expresso + " ­ valor: " + valor_expresso);
            System.out.println("Qde café capuccino: " + qde_capuccino + " ­ valor: " + valor_capuccino);
            System.out.println("Qde leite com café: " + qde_leite_com_cafe
                    + " ­ valor: " + valor_leite_com_cafe);
            System.out.println("Qde café com avelã: " + qde_cafe_com_avela + " ­ valor: " + valor_cafe_com_avela);
            //exibir quantidade total de cafes vendidos e o valor total
            System.out.println("Qde cafés vendidos: " + qde_cafes_vendidos
                    + " ­ valor cafés vendidos: " + valor_cafes_vendidos);
        }
        //bloco para informar o metodo de pagamento
        System.out.println("");
        System.out.println("");
        System.out.println("    Como deseja pagar? ");
        System.out.println("1 - Deseja pagar parcialmente");
        System.out.println("2 - Deseja pagar tudo");
        int pgt_client = sc.nextInt();
        //Bloco para ver quanto que foi pago, quanto que está devendo, troco do cliente
        if (pgt_client == 1) {
            double tConta = valor_cafes_vendidos;
            System.out.println("Qual o valor que deseja pagar? ");
            double pgt_prc = sc.nextDouble();
            tConta -= pgt_prc;
            if (tConta == 0) {
                System.out.println("Muito obrigado, volte sempre!");
            } else if (tConta < 0) {
                tConta = -(tConta);
                System.out.println("Seu troco é " + tConta + ". Volte sempre!");
            } else {
                while (tConta > 0) {
                    System.out.println("Está devendo " + tConta + ". Pague!");
                    System.out.println("Qual o valor que irá pagar? ");
                    double novopgt = sc.nextDouble();
                    tConta -= novopgt;
                    if (tConta == 0) {
                        System.out.println("Volte sempre!");
                        break;
                    } else if (tConta > 0) {
                        break;
                    } else {
                        tConta = -(tConta);
                        System.out.println("Seu troco é " + tConta + ". Volte sempre!");
                        break;
                    }
                }
            }
        } else if (pgt_client == 2) {
            System.out.println("Muito obrigado, volte sempre!");
        }
    }
}
