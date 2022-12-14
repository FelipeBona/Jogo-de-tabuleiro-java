package trabfinal;
import java.util.Scanner;

public class Jogador {
    // atributo mapa para poder usar no metodo jogar
    Mapa mapa;
    private char letra = 'X';

    public Jogador(Mapa mapa){

        this.mapa = mapa; 
    }

    public boolean jogar(Scanner teclado){ 

        boolean jogadaJogador;
        int l; int c;

        do {
            System.out.println("Jogador ..");
            System.out.print("  linha: ");
            l = teclado.nextInt();
            System.out.print("  coluna: ");
            c = teclado.nextInt();
            
        } while ((l < 0 || l > 2) || (c < 0 || c > 2));

        jogadaJogador = mapa.jogar(l, c, letra);
 
        while (jogadaJogador == false){  
                System.out.println("posição inválida!");
                System.out.println("Jogador ..");
                System.out.print("  linha: ");
                l = teclado.nextInt();
                System.out.print("  coluna: ");
                c = teclado.nextInt();
 
                if ((l < 0 || l > 2) || (c < 0 || c > 2)){
                    System.out.println("Jogador ..");
                    System.out.print("  linha: ");
                    l = teclado.nextInt();
                    System.out.print("  coluna: ");
                    c = teclado.nextInt();
                }
 
                jogadaJogador = mapa.jogar(l, c, letra);
            }
 
        boolean naoVenceu = mapa.verificarGanhador('X');
        if (naoVenceu == false){
            System.out.println("... Jogador GANHOU!");
            return false;
        }
        return true;
    }
}

