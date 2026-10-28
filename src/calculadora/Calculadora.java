package calculadora;

public class Calculadora {

    public static final String MSG_DIVISAO_POR_ZERO = "Erro: divisão por zero não é permitida.";
    public static final String MSG_OPERACAO_INVALIDA = "Erro: operação inválida. Use +, -, * ou /.";

    public String calc(int a, int b, String op) {
        if (op == null) {
            return MSG_OPERACAO_INVALIDA;
        }

        switch (op) {
            case "+":
                return String.valueOf(somar(a, b));
            case "-":
                return String.valueOf(subtrair(a, b));
            case "*":
                return String.valueOf(multiplicar(a, b));
            case "/":
                return dividir(a, b);
            default:
                return MSG_OPERACAO_INVALIDA;
        }
    }

    private long somar(int a, int b) {
        return (long) a + b;
    }

    private long subtrair(int a, int b) {
        return (long) a - b;
    }

    private long multiplicar(int a, int b) {
        return (long) a * b;
    }

    private String dividir(int dividendo, int divisor) {
        if (divisor == 0) {
            return MSG_DIVISAO_POR_ZERO;
        }
        return String.valueOf((double) dividendo / divisor);
    }
}
