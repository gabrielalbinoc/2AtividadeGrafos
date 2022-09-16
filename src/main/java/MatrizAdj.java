import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class MatrizAdj {
    public static void main(String[] args) {
        LeitorTXT lerTXT = new LeitorTXT("C:/Users/Gabriel/IdeaProjects/Atividade1Grafos/src/main/java/pequenoG.txt");
        ArrayList<String> linhas = LeitorTXT.read();
        int[] grau = new int[Integer.parseInt(linhas.get(0))];
        int[][] matAdj = new int[Integer.parseInt(linhas.get(0))][Integer.parseInt(linhas.get(1))];
        int isolados = 0, extremidades = 0;
        for (int i = 0; i < matAdj.length; i++) {
            String[] valores = linhas.get(i + 2).split(" ");
            matAdj[Integer.parseInt(valores[0])][Integer.parseInt(valores[1])] = 1;
            matAdj[Integer.parseInt(valores[1])][Integer.parseInt(valores[0])] = 1;
            for (int j = 0; j < matAdj[0].length; j++) {
                if (j == Integer.parseInt(valores[0]) || j == Integer.parseInt(valores[1])) {
                    grau[j]++;
                }
                if (j == Integer.parseInt(valores[0]) && j == Integer.parseInt(valores[1])) {
                    isolados++;
                }
            }
        }
        System.out.println("Matriz Adjacência");
        for (int i = 0; i < matAdj.length; i++) {
            if (grau[i] == 1) {
                extremidades++;
            }
            for (int j = 0; j < matAdj[0].length; j++) {

                System.out.print(matAdj[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Ordem = " + Integer.parseInt(linhas.get(0)));
        System.out.println("Tamanho = " + Integer.parseInt(linhas.get(1)));
        System.out.println();
        System.out.println("Grau de cada vertice");
        for (int i = 0; i < Integer.parseInt(linhas.get(0)); i++) {
            System.out.println("Grau de " + i + " = " + grau[i]);
        }
        System.out.println();
        System.out.println("Vertices isolados = " + isolados);
        System.out.println("Vértices de extremidade = " + extremidades);
    }
}
