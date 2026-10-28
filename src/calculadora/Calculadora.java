package calculadora;

public class Calculadora {

    public String calc(int a, int b, String op) {
        String resultado;

        if (op == null) {
            resultado = "Erro: operação inválida. Use +, -, * ou /.";
        } else if (op.equals("+")) {
            resultado = String.valueOf((long) a + b);
        } else if (op.equals("-")) {
            resultado = String.valueOf((long) a - b);
        } else if (op.equals("*")) {
            resultado = String.valueOf((long) a * b);
        } else if (op.equals("/")) {
            if (b == 0) {
                resultado = "Erro: divisão por zero não é permitida.";
            } else {
                resultado = String.valueOf((double) a / b);
            }
        } else {
            resultado = "Erro: operação inválida. Use +, -, * ou /.";
        }

        return resultado;
    }
}
