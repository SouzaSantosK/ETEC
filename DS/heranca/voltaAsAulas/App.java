package voltaAsAulas;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Pessoa pessoa = new Pessoa(in.next(), in.next());
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Sobrenome: " + pessoa.getSobreNome());

        in.close();
    }
}
