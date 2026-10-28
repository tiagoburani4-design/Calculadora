package calculadora;

/**
 * Módulo de cálculos matemáticos básicos da FinançApp.
 * <p>
 * Realiza soma, subtração, multiplicação e divisão de números inteiros.
 * Em vez de lançar exceções, os erros (divisão por zero e operação inválida)
 * são devolvidos como mensagens de texto, para que a execução do programa
 * nunca seja interrompida.
 * </p>
 *
 * @author Tiago José Redondo Burani
 * @version 2.0
 */
public class Calculadora {

    /** Mensagem devolvida quando há tentativa de divisão por zero. */
    public static final String MSG_DIVISAO_POR_ZERO = "Erro: divisão por zero não é permitida.";

    /** Mensagem devolvida quando o operador informado não é suportado. */
    public static final String MSG_OPERACAO_INVALIDA = "Erro: operação inválida. Use +, -, * ou /.";

    /**
     * Cria uma nova calculadora.
     */
    public Calculadora() {
    }

    /**
     * Executa a operação matemática solicitada entre dois números inteiros.
     * <p>
     * Operadores aceitos: {@code +}, {@code -}, {@code *} e {@code /}.
     * Não lança exceções: operador nulo, vazio ou desconhecido e divisão
     * por zero resultam em mensagem de erro.
     * </p>
     *
     * @param a  primeiro operando
     * @param b  segundo operando
     * @param op operador da operação ("+", "-", "*" ou "/")
     * @return o resultado da operação em formato de texto (a divisão retorna
     *         valor decimal, ex.: "2.5") ou a mensagem de erro correspondente
     */
    public String calc(int a, int b, String op) {
        // Operador nulo seria causa de NullPointerException no switch; trata antes
        if (op == null) {
            return MSG_OPERACAO_INVALIDA;
        }

        // Escolhe a operação de acordo com o operador recebido
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

    /**
     * Soma dois números inteiros.
     *
     * @param a primeira parcela
     * @param b segunda parcela
     * @return a soma de {@code a} e {@code b}
     */
    private long somar(int a, int b) {
        // O cast para long evita estouro do limite do tipo int
        return (long) a + b;
    }

    /**
     * Subtrai dois números inteiros.
     *
     * @param a minuendo
     * @param b subtraendo
     * @return a diferença entre {@code a} e {@code b}
     */
    private long subtrair(int a, int b) {
        // O cast para long evita estouro do limite do tipo int
        return (long) a - b;
    }

    /**
     * Multiplica dois números inteiros.
     *
     * @param a primeiro fator
     * @param b segundo fator
     * @return o produto de {@code a} por {@code b}
     */
    private long multiplicar(int a, int b) {
        // O cast para long evita estouro do limite do tipo int
        return (long) a * b;
    }

    /**
     * Divide dois números inteiros, impedindo a divisão por zero.
     *
     * @param dividendo número a ser dividido
     * @param divisor   número pelo qual o dividendo será dividido
     * @return o quociente decimal em formato de texto, ou
     *         {@link #MSG_DIVISAO_POR_ZERO} quando o divisor for zero
     */
    private String dividir(int dividendo, int divisor) {
        // Validação: divisão por zero não é permitida
        if (divisor == 0) {
            return MSG_DIVISAO_POR_ZERO;
        }
        // O cast para double mantém a parte decimal do resultado (ex.: 7 / 2 = 3.5)
        return String.valueOf((double) dividendo / divisor);
    }
}
