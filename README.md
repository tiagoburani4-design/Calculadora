# Projeto Calculadora — FinançApp

> Projeto acadêmico desenvolvido com foco em Qualidade de Software, Testes, Refatoração, Documentação e Versionamento.

---

## 1. Identificação do Projeto

**Projeto:** Projeto Calculadora  
**Contexto:** FinançApp  
**Aluno:** Tiago José Redondo Burani  
**RA:** 252110  
**Curso:** Análise e Desenvolvimento de Sistemas  
**Disciplina:** UI/UX 
**Professor:** Daniel Ohata  
**Semestre:** 2026.2  

---

# 2. Visão Geral

O projeto consiste no desenvolvimento de um módulo de cálculos matemáticos básicos em Java para a startup fictícia **FinançApp**.

O módulo foi desenvolvido com o objetivo de ser utilizado futuramente em funcionalidades de controle financeiro, como:

- orçamento mensal;
- divisão de despesas;
- projeções financeiras;
- cálculos auxiliares.

Além do funcionamento correto das operações, o projeto aplica práticas de qualidade de software relacionadas a:

- testes;
- tratamento de erros;
- refatoração;
- documentação;
- versionamento;
- manutenção de código.

---

# 3. Problema

Durante o desenvolvimento da aplicação FinançApp, foi identificada a necessidade de criar um módulo matemático reutilizável.

Entretanto, a equipe definiu que o módulo não deveria apenas funcionar corretamente, mas também apresentar:

- código legível;
- testes automatizados;
- tratamento de falhas;
- documentação técnica;
- controle de versões;
- facilidade de manutenção.

O desafio consiste, portanto, em desenvolver uma solução funcional e ao mesmo tempo aplicar boas práticas de Engenharia de Software.

---

# 4. Objetivo

## 4.1 Objetivo Geral

Desenvolver uma calculadora em Java aplicando práticas de qualidade, testes, documentação, refatoração e versionamento.

## 4.2 Objetivos Técnicos

- implementar operações matemáticas básicas;
- tratar entradas inválidas;
- impedir divisão por zero;
- desenvolver testes automatizados;
- refatorar o código sem alterar seu comportamento;
- documentar classes e métodos com JavaDoc;
- gerar documentação HTML;
- utilizar Git e GitHub;
- organizar commits e branches;
- manter documentação técnica no README.

---

# 5. Escopo Funcional

A aplicação deverá oferecer as seguintes operações:

| ID | Funcionalidade | Descrição | Status |
|---|---|---|---|
| RF01 | Soma | Soma dois números inteiros | ✅ |
| RF02 | Subtração | Subtrai dois números inteiros | ✅ |
| RF03 | Multiplicação | Multiplica dois números inteiros | ✅ |
| RF04 | Divisão | Divide dois números inteiros | ✅ |
| RF05 | Validação de divisão | Impede divisão por zero | ✅ |
| RF06 | Operação inválida | Trata operadores não suportados | ✅ |

---

# 6. Requisitos Não Funcionais

| ID | Categoria | Requisito |
|---|---|---|
| RNF01 | Qualidade | O código deve possuir organização e legibilidade |
| RNF02 | Testabilidade | As operações devem possuir testes automatizados |
| RNF03 | Manutenção | O código deve permitir refatoração sem alteração funcional |
| RNF04 | Documentação | Classes e métodos devem possuir JavaDoc |
| RNF05 | Versionamento | O projeto deve utilizar Git e GitHub |
| RNF06 | Confiabilidade | Erros não devem interromper inesperadamente a execução |

---

# 7. Tecnologias Utilizadas

| Tecnologia | Versão | Utilização |
|---|---|---|
| Java | 21 | Desenvolvimento |
| JDK | 21 | Compilação |
| Java puro (classe de teste com `main`) | — | Testes |
| Git | 2.43 | Controle de versão |
| GitHub | — | Repositório remoto |
| JavaDoc | 21 | Documentação |
| IDE | Visual Studio Code | Ambiente de desenvolvimento |

---

# 8. Estrutura do Projeto

```text
projeto_calculadora/
│
├── src/
│   └── calculadora/
│       └── Calculadora.java
│
├── test/
│   └── calculadora/
│       └── TesteCalculadora.java
│
├── docs/
│   └── index.html
│
├── images/
│   ├── testes/
│   ├── javadoc/
│   └── refatoracao/
│
├── README.md
├── .gitignore
└── demais arquivos do projeto
```

---

# 9. Explicação das Operações

A operação é executada pelo método `calc(int a, int b, String op)` da classe `Calculadora`, que recebe dois números inteiros e o operador desejado e **devolve o resultado em formato de texto** (`String`). Assim, tanto resultados quanto mensagens de erro são retornados da mesma forma, sem lançar exceções e sem interromper a execução do programa.

| Operador | Operação | Exemplo | Resultado |
|---|---|---|---|
| `+` | Soma | `calc(5, 3, "+")` | `8` |
| `-` | Subtração | `calc(10, 4, "-")` | `6` |
| `*` | Multiplicação | `calc(6, 7, "*")` | `42` |
| `/` | Divisão | `calc(7, 2, "/")` | `3.5` |
| `/` com divisor `0` | Divisão por zero | `calc(10, 0, "/")` | `Erro: divisão por zero não é permitida.` |
| qualquer outro (inclusive nulo ou vazio) | Operação inválida | `calc(4, 2, "%")` | `Erro: operação inválida. Use +, -, * ou /.` |

**Observações:**

- A divisão retorna valor decimal (ex.: `10 / 2` resulta em `5.0`), para não perder a parte fracionária.
- Soma, subtração e multiplicação são calculadas internamente com `long`, evitando estouro do limite do tipo `int` (ex.: `2147483647 + 1` resulta em `2147483648`).

---

# 10. Testes

A classe `TesteCalculadora` executa **22 casos de teste**, cobrindo soma, subtração, multiplicação, divisão, divisão por zero e operações inválidas. Para cada caso são exibidos no console a **entrada utilizada**, o **resultado esperado** e o **resultado obtido**.

## 10.1 Como compilar e executar

Na raiz do projeto:

```bash
# Compilar
javac -encoding UTF-8 -d out src/calculadora/*.java test/calculadora/*.java

# Executar os testes
java -cp out calculadora.TesteCalculadora
```

Também é possível executar a classe `TesteCalculadora` diretamente pela IDE.

## 10.2 Resultado esperado

```text
Total de testes: 22
Aprovados......: 22
Reprovados.....: 0
```

# 11. Refatoração

A refatoração foi realizada na branch **`Refatoracao`**, sem alterar o comportamento do sistema. Os mesmos 22 testes foram executados antes e depois, com 100% de aprovação.

| Técnica aplicada | Antes | Depois |
|---|---|---|
| Extração de métodos | Toda a lógica dentro de `calc` | Métodos `somar`, `subtrair`, `multiplicar` e `dividir` |
| Simplificação de condicionais | Cadeia de `if / else if` aninhada | `switch` com retornos diretos |
| Eliminação de repetição | Mensagens de erro escritas duas vezes | Constantes `MSG_DIVISAO_POR_ZERO` e `MSG_OPERACAO_INVALIDA` |
| Melhoria de nomes | Variável genérica `resultado` | Nomes descritivos como `dividendo` e `divisor` |
| Organização lógica | Validações misturadas ao cálculo | Validação do operador separada da execução da operação |

# 12. Documentação JavaDoc

Todas as classes, métodos, atributos, parâmetros, retornos e exceções foram documentados com JavaDoc (`@author`, `@version`, `@param`, `@return`), além de comentários técnicos no código.

A documentação HTML foi gerada na pasta `docs/`. Para visualizá-la, abra o arquivo `docs/index.html` no navegador.

Comando utilizado para gerar:

```bash
javadoc -private -author -version -encoding UTF-8 -docencoding UTF-8 -charset UTF-8 -d docs src/calculadora/Calculadora.java test/calculadora/TesteCalculadora.java
```

# 13. Versionamento

| Branch | Descrição |
|---|---|
| `main` | Branch principal, com o projeto completo |
| `Refatoracao` | Refatoração do código, JavaDoc, documentação HTML e README |

Os commits seguem o padrão `tipo: descrição` (`chore`, `feat`, `test`, `refactor`, `docs`).

---

# 14. Repositório

🔗 **Link do repositório:** www.github.com/tiagoburani4-design/Calculadora
