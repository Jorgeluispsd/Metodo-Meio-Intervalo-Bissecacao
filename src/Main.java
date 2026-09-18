import java.util.Scanner;


public class Main {

    // Forma de montar a funcao: f(x) = coeficiente * x^expoente - constante (podendo colocar outros valores na conta)
    public static double calcularF(double coeficiente, int expoente, double constante, double x) {
        return coeficiente * Math.pow(x, expoente) - constante;
    }

    // Feito de uma forma que Calcula apenas a 1 e a 2 regra das derivadas
    //Já que a primeira regra é usado o valor 0 como resultado final ele nem entra na conta devido a constante não estar na conta
    public static double calcularDerivada(double coeficiente, int expoente, double x) {
        double novoCoeficiente = coeficiente * expoente;
        int novoExpoente = expoente - 1;
        return novoCoeficiente * Math.pow(x, novoExpoente);
    }

    public static String sinal(double valor) {
        if (valor > 0) return "+";
        else if (valor < 0) return "-";
        else return "0";
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        // Precisa digitar os 3 números que formam a função
        System.out.println("f(x) = coeficiente * x^expoente - constante");
        System.out.print("Digite o coeficiente: ");
        double coeficiente = leitor.nextDouble();
        System.out.print("Digite o expoente: ");
        int expoente = leitor.nextInt();
        System.out.print("Digite a constante (o valor subtraido): ");
        double constante = leitor.nextDouble();

        // PASSO 1 - Teorema de Bolzano
        double a, b;
        while (true) {
            System.out.print("Digite o valor de a: ");
            a = leitor.nextDouble();
            System.out.print("Digite o valor de b: ");
            b = leitor.nextDouble();

            double fa = calcularF(coeficiente, expoente, constante, a);
            double fb = calcularF(coeficiente, expoente, constante, b);

            System.out.println("f(" + a + ") = " + fa + "   f(" + b + ") = " + fb);

            if (fa * fb < 0) {
                System.out.println("Sinais opostos -> existe raiz em [" + a + ", " + b + "]");
                break;
            } else {
                System.out.println("Mesmo sinal, tente outro intervalo.");
            }
        }

        // PASSO 2 - Calcula a derivada
        double derivadaA = calcularDerivada(coeficiente, expoente, a);
        double derivadaB = calcularDerivada(coeficiente, expoente, b);

        if (Math.signum(derivadaA) == Math.signum(derivadaB)) {
            System.out.println("f'(x) nao muda de sinal -> raiz unica.");
        } else {
            System.out.println("Atencao: f'(x) muda de sinal -> pode haver mais de uma raiz.");
        }

        // PASSO 3 e 4 - laco da bisseccao ate o erro satisfazer a tolerancia
        System.out.print("Digite a margem de erro desejada: ");
        double tolerancia = leitor.nextDouble();

        System.out.printf("%n%-4s %-10s %-10s %-10s %-6s %-9s %-6s %-10s%n",
                "n", "a", "x_Estimado", "b", "f(a)", "f(x_bar)", "f(b)", "erro");

        int n = 0;
        double xEstimado;
        double erro;

        do {
            n++;
            xEstimado = (a + b) / 2.0;
            erro = Math.abs(a - b) / 2.0;

            double fa = calcularF(coeficiente, expoente, constante, a);
            double fx = calcularF(coeficiente, expoente, constante, xEstimado);
            double fb = calcularF(coeficiente, expoente, constante, b);

            System.out.printf("%-4d %-10.4f %-10.4f %-10.4f %-6s %-9s %-6s %-10.4f%n",
                    n, a, xEstimado, b, sinal(fa), sinal(fx), sinal(fb), erro);

            if (fa * fx < 0) {
                b = xEstimado;
            } else {
                a = xEstimado;
            }

        } while (erro >= tolerancia);

        System.out.printf("%nRaiz aproximada: x_Estimado = %.4f (%d iteracoes, erro = %.4f)%n", xEstimado, n, erro);

        leitor.close();
    }
}