# Método da Bissecção

Atividade da matéria de Cálculo Numérico Computacional.

Este projeto resolve exercícios pelo Método da Bissecção (também chamado de
Método do Meio-Intervalo), usado para encontrar raízes de uma função.

## Como rodar

```bash
javac BissecaoParametrizada.java
java BissecaoParametrizada
```

O programa pede o coeficiente, o expoente e a constante da função, o intervalo
[a, b] e a margem de erro desejada, e mostra a tabela de iterações até
encontrar a raiz aproximada.

## Exemplo de uso

Para resolver f(x) = x² - 5:

```
f(x) = coeficiente * x^expoente - constante
Digite o coeficiente: 1
Digite o expoente: 2
Digite a constante (o valor subtraido): 5
Digite o valor de a: 2
Digite o valor de b: 3
f(2.0) = -1.0   f(3.0) = 4.0
Sinais opostos -> existe raiz em [2.0, 3.0]
f'(x) nao muda de sinal -> raiz unica.
Digite a margem de erro desejada: 0.1

n    a          x_barra    b          f(a)   f(x_bar)  f(b)   epsilon
1    2.0000     2.5000     3.0000     -      +         +      0.5000
2    2.0000     2.2500     2.5000     -      +         +      0.2500
3    2.0000     2.1250     2.2500     -      -         +      0.1250
4    2.1250     2.1875     2.2500     -      -         +      0.0625

Raiz aproximada: x_barra = 2.1875 (4 iteracoes, epsilon = 0.0625)
```
