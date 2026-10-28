package calculadora;

public class TesteCalculadora {

    private static final Calculadora calculadora = new Calculadora();
    private static int aprovados = 0;
    private static int reprovados = 0;

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   TESTES DA CALCULADORA - FinançApp");
        System.out.println("==========================================");

        testarSoma();
        testarSubtracao();
        testarMultiplicacao();
        testarDivisao();
        testarDivisaoPorZero();
        testarOperacoesInvalidas();

        System.out.println("==========================================");
        System.out.println("Total de testes: " + (aprovados + reprovados));
        System.out.println("Aprovados......: " + aprovados);
        System.out.println("Reprovados.....: " + reprovados);
        System.out.println("==========================================");

        if (reprovados > 0) {
            System.exit(1);
        }
    }

    private static void testarSoma() {
        System.out.println("\n--- SOMA ---");
        verificar("Soma de dois positivos", 5, 3, "+", "8");
        verificar("Soma com número negativo", -4, 10, "+", "6");
        verificar("Soma de zeros", 0, 0, "+", "0");
        verificar("Soma que ultrapassa o limite do int", Integer.MAX_VALUE, 1, "+", "2147483648");
    }

    private static void testarSubtracao() {
        System.out.println("\n--- SUBTRAÇÃO ---");
        verificar("Subtração com resultado positivo", 10, 4, "-", "6");
        verificar("Subtração com resultado negativo", 3, 8, "-", "-5");
        verificar("Subtração de números iguais", 7, 7, "-", "0");
    }

    private static void testarMultiplicacao() {
        System.out.println("\n--- MULTIPLICAÇÃO ---");
        verificar("Multiplicação de positivos", 6, 7, "*", "42");
        verificar("Multiplicação com número negativo", -3, 5, "*", "-15");
        verificar("Multiplicação por zero", 9, 0, "*", "0");
    }

    private static void testarDivisao() {
        System.out.println("\n--- DIVISÃO ---");
        verificar("Divisão exata", 10, 2, "/", "5.0");
        verificar("Divisão com resultado decimal", 7, 2, "/", "3.5");
        verificar("Divisão com número negativo", -9, 3, "/", "-3.0");
        verificar("Divisão de zero por número", 0, 5, "/", "0.0");
    }

    private static void testarDivisaoPorZero() {
        System.out.println("\n--- DIVISÃO POR ZERO ---");
        String mensagem = "Erro: divisão por zero não é permitida.";
        verificar("Divisão de positivo por zero", 10, 0, "/", mensagem);
        verificar("Divisão de negativo por zero", -5, 0, "/", mensagem);
        verificar("Divisão de zero por zero", 0, 0, "/", mensagem);
    }

    private static void testarOperacoesInvalidas() {
        System.out.println("\n--- OPERAÇÕES INVÁLIDAS ---");
        String mensagem = "Erro: operação inválida. Use +, -, * ou /.";
        verificar("Operador não suportado (%)", 4, 2, "%", mensagem);
        verificar("Operador com letra", 4, 2, "x", mensagem);
        verificar("Operador com dois caracteres", 4, 2, "++", mensagem);
        verificar("Operador vazio", 4, 2, "", mensagem);
        verificar("Operador nulo", 4, 2, null, mensagem);
    }

    private static void verificar(String descricao, int a, int b, String op, String esperado) {
        String obtido = calculadora.calc(a, b, op);
        boolean passou = esperado.equals(obtido);

        if (passou) {
            aprovados++;
        } else {
            reprovados++;
        }

        String opTexto = (op == null) ? "null" : "\"" + op + "\"";
        System.out.println((passou ? "[PASSOU] " : "[FALHOU] ") + descricao);
        System.out.println("   Entrada  : a = " + a + ", b = " + b + ", op = " + opTexto);
        System.out.println("   Esperado : " + esperado);
        System.out.println("   Obtido   : " + obtido);
    }
}
