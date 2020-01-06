# REQUISITOS PARA EXECUÇÃO DO CÓDIGO:
    - Instalar **Java 8**
    - Instalar **Maven**
    - Rodar o comando `$ mvn install`

# EXERCICIO 01:
## Aspectos Negativos do código antigo:
    - Nomenclatura das variáveis e funções estavam muito confusas, não estavam verbosas
    - Código desnecessário
    - Comentarios desnecessarios (Com nomenclaturas claras, é despensável o uso de comentários que explicam código)
    - Função retornaCodigos() não respeitava o Princípio da Responsabilidade Única

## Melhorias:
    - Ajustes nos nomes das funções e variáveis
    - Criados métodos mais genéricos e reutilizaveis
    - Ajustado visibilidade de funções e variáveis

## Nova implementação (classe GeradorObservacaoDetalhada):
    - Foi criada uma classe pois não se modifica classes existentes, se extende para implementar novos comportamentos
    - Parametrizei o tipo de moeda corrente e texto

# EXERCICIO 02:

    Por questão de tempo, não finalizei este exercício.
    Implementações que faltantes:
    - Arredondar Double: O resultado final não ficou com arredondamento correto
    - Testes: Não implementei testes

# OBSERVAÇÕES:
    - Para rodar testes `$ mvn tests`
    - Foi criado alguns exemplos na main class App