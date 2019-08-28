import java.util.Scanner;

public class cifra_de_cesar {

public static String criptografar(int chave, String texto) {
    StringBuilder textocriptografado = new StringBuilder();
    int tamanhoTexto = texto.length();

    for (int c = 0; c < tamanhoTexto; c++) {
        int letracriptografadaASCII = ((int) texto.charAt(c)) + chave;

        while (letracriptografadaASCII > 126) {
        	letracriptografadaASCII -= 94;
        }
        textocriptografado.append((char) letracriptografadaASCII);
    }
    return textocriptografado.toString();
}
public static String descriptografar(int chave, String textocriptografado) {
    StringBuilder texto = new StringBuilder();
    int tamanhoTexto = textocriptografado.length();

    for (int c = 0; c < tamanhoTexto; c++) {
        int letraDecifradaASCII = ((int) textocriptografado.charAt(c)) - chave;

        while (letraDecifradaASCII < 32) {
            letraDecifradaASCII += 94;
        }

        texto.append((char) letraDecifradaASCII);
    }

    return texto.toString();
}

public static void main(String[] args) {

    try {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Informe a mensagem que deseja criptografar: ");
        String texto = entrada.nextLine();
        System.out.print("Informe a CHAVE: ");
        int chave = entrada.nextInt();

        String textoCriptografado = criptografar(chave, texto);
        String textoDescriptografado = descriptografar(chave, textoCriptografado);

        System.out.println("\n\nMensagem Criptografada: " + textoCriptografado);
        System.out.println("Mensagem Descriptografada: " + textoDescriptografado);
       
    } catch (RuntimeException e) {
        System.out.println("A CHAVE deve ser em números.");
       }
}
}