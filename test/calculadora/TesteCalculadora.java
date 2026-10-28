package calculadora;

/**
 * Testes da classe {@link Calculadora}.
 * <p>
 * Cada teste exibe no console as entradas utilizadas, o resultado esperado
 * e o resultado obtido, indicando se o teste passou ou falhou.
 * </p>
 *
 * @author Tiago José Redondo Burani
 * @version 2.0
 */
public class TesteCalculadora {

    /** Instância da calculadora usada em todos os testes. */
    private static final Calculadora calculadora = new Calculadora();

    /** Quantidade de testes aprovados. */
    private static int aprovados = 0;

    /** Quantidade de testes reprovados. */
    private static int reprovados = 0;

    /**
     * Cria a classe de testes.
     */
    public TesteCalculadora() {
    }

    /**
     * Executa todos os testes e exibe o resumo final.
     * Encerra com código 1 se algum teste falhar.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
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

    /** Testa a operação de soma. */
    private static void testarSoma() {
        System.out.println("\n--- SOMA ---");
        verificar("Soma de dois positivos", 5, 3, "+", "8");
        verificar("Soma com número negativo", -4, 10, "+", "6");
        verificar("Soma de zeros", 0, 0, "+", "0");
        verificar("Soma que ultrapassa o limite do int", Integer.MAX_VALUE, 1, "+", "2147483648");
    }

    /** Testa a operação de subtração. */
    private static void testarSubtracao() {
        System.out.println("\n--- SUBTRAÇÃO ---");
        verificar("Subtração com resultado positivo", 10, 4, "-", "6");
        verificar("Subtração com resultado negativo", 3, 8, "-", "-5");
        verificar("Subtração de números iguais", 7, 7, "-", "0");
    }

    /** Testa a operação de multiplicação. */
    private static void testarMultiplicacao() {
        System.out.println("\n--- MULTIPLICAÇÃO ---");
        verificar("Multiplicação de positivos", 6, 7, "*", "42");
        verificar("Multiplicação com número negativo", -3, 5, "*", "-15");
        verificar("Multiplicação por zero", 9, 0, "*", "0");
    }

    /** Testa a operação de divisão. */
    private static void testarDivisao() {
        System.out.println("\n--- DIVISÃO ---");
        verificar("Divisão exata", 10, 2, "/", "5.0");
        verificar("Divisão com resultado decimal", 7, 2, "/", "3.5");
        verificar("Divisão com número negativo", -9, 3, "/", "-3.0");
        verificar("Divisão de zero por número", 0, 5, "/", "0.0");
    }

    /** Testa o impedimento da divisão por zero. */
    private static void testarDivisaoPorZero() {
        System.out.println("\n--- DIVISÃO POR ZERO ---");
        String mensagem = "Erro: divisão por zero não é permitida.";
        verificar("Divisão de positivo por zero", 10, 0, "/", mensagem);
        verificar("Divisão de negativo por zero", -5, 0, "/", mensagem);
        verificar("Divisão de zero por zero", 0, 0, "/", mensagem);
    }

    /** Testa operadores inválidos, vazios e nulos. */
    private static void testarOperacoesInvalidas() {
        System.out.println("\n--- OPERAÇÕES INVÁLIDAS ---");
        String mensagem = "Erro: operação inválida. Use +, -, * ou /.";
        verificar("Operador não suportado (%)", 4, 2, "%", mensagem);
        verificar("Operador com letra", 4, 2, "x", mensagem);
        verificar("Operador com dois caracteres", 4, 2, "++", mensagem);
        verificar("Operador vazio", 4, 2, "", mensagem);
        verificar("Operador nulo", 4, 2, null, mensagem);
    }

    /**
     * Executa a calculadora com as entradas informadas, compara o resultado
     * obtido com o esperado e exibe o relatório do teste.
     *
     * @param descricao descrição do caso de teste
     * @param a         primeiro operando
     * @param b         segundo operando
     * @param op        operador da operação
     * @param esperado  resultado esperado
     */
    private static void verificar(String descricao, int a, int b, String op, String esperado) {
        // Resultado real devolvido pela calculadora
        String obtido = calculadora.calc(a, b, op);
        // O teste passa quando o resultado obtido é igual ao esperado
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
