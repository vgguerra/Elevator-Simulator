# Projeto 01 de POO - Simulador de elevador
  Neste projeto, a proposta era realizar a criação de um elevador, onde o usuário poderia arbitrar o número de andares ao iniciar o programa, indicar se estava dentro ou fora do elevador, subir e descer de um andar para outro e chamar o elevador em um determinado andar. O principal objetivo deste projeto, era utilizar o princípio da divisão de responsabilidades (SOC, Separation of Concerns) e da responsabilidade única (SRP, Single Responsibility Principle).

  ## Funcionalidades do programa
  - Chamar um elevador em um determinado andar, indicando se deseja subir ou descer
  - Indicar, quando dentro do elevador, para qual andar o usuário deseja ir, se deslocando do andar atual até o selecionado

  Abaixo, segue o diagrama de classes UML, indicando os principais atributos e os principais métodos do programa

```mermaid
classDiagram
    direction LR
    direction TD

    class Botao{
      -boolean estadoBotao

      +ativaBotao() boolean
      +desativaBotao() boolean
    }

    class PainelExterno{
      -Botao sobe
      -Botao desce
      -int andar
      -String visor

      +apertarBotaoSubida() boolean
      +apertarBotaoDescida() boolean
    }

    class Elevador{
      -ArrayList~Botao~ botoesAndares
      -int andar
      -String visor

      +selecioneAndar(andar: int) boolean
      +desativaBotao(andar: int)
    }


    class Predio{
      -int numAndares
      -ArrayList~PainelExterno~ paineis
      -Elevador elevador

      +chamaElevador(sobeDesce:String,andar:int) boolean
      +selecionaAndar(andar:int) boolean
      +desativaBotaPainelExterno(andar:int)
    }

    class App{
      -Predio predio

      +imprimeAndares(andar:int)
      +imprimePainel(app:App,andarSelecionado:int,dentroFora:String)
    }


    Botao "2" --* "1" PainelExterno
    Botao "1..*" --* "1" Elevador
    PainelExterno "1" --* "1" Predio
    Elevador "1" --* "1" Predio    
    Predio "1" --* "1" App
```