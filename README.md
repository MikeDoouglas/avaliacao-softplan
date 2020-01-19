## Como executar:
- Instalar **Java 8**
- Instalar **Maven**
- Executar o comando `$ mvn install`

## Exercício 01:
### Aspectos Negativos do código antigo:
- Nomenclatura das variáveis e funções estavam muito confusas, não estavam verbosas
- Código desnecessário
- Comentarios desnecessarios (Com nomenclaturas claras, é dispensável o uso de comentários que explicam código)
- Função retornaCodigos() não respeitava o Princípio da Responsabilidade Única

### Melhorias:
- Ajustes nos nomes das funções e variáveis
- Criados métodos mais genéricos e reutilizaveis
- Ajustado visibilidade de funções e variáveis

### Nova implementação (classe GeradorObservacaoDetalhada):
- Foi criada uma classe pois não se modifica classes existentes, e criada uma interface e utilizado composição para reutilização de código 
- Parametrizado o tipo de moeda corrente e texto

## Exercício 02:

<s>Por questão de tempo, não finalizei este exercício.
Implementações que faltantes:
- Arredondar Double: O resultado final não ficou com arredondamento correto
- Testes: Não implementei testes</s>

- Criado função para extração do JSON para objetos
- Criado as classes Composicao, Insumo e ItemComposicao
- Criada a Interface Item pois uma composição possui varios itens, destes itens, eles podem ser tanto um Insumo como uma outra Composicao
- ItemComposicao: Criada para manter a lista de itens que uma Composição possui, e para manter a quantidade destes itens

## Observações:
- Para rodar testes `$ mvn tests`
- Resultado após executar o main.java: 
![Resultado da Avaliação](assets/img.png?raw=true "Resultado da Avaliação")