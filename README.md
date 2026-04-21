# Sistema de Simulação de Veículos

Atividade da disciplina de Programação Orientada a Objetos — UNIFSA.

## Estrutura do Projeto

```
src/simulador/
├── Veiculo.java           # Classe base
├── Carro.java             # Herda de Veiculo
├── Moto.java              # Herda de Veiculo
├── Caminhao.java          # Herda de Veiculo
├── Garagem.java           # Gerencia array de Veiculo
├── SimuladorDeTrafego.java # Pista de testes com simulação ativa
└── Main.java              # Demonstração completa do sistema
```

## Conceitos aplicados

- **Herança**: `Carro`, `Moto` e `Caminhao` herdam de `Veiculo`
- **Encapsulamento**: todos os atributos são `private` com getters/setters
- **Sobrecarga**: construtores, `acelerar()`, `frear()`, `ligar()`, `abastecer()`, `estacionar()` e `interagir()`
- **Sobrescrita**: `acelerar()`, `exibirStatus()`, `calcularConsumo()`, `toString()`, `equals()` e `hashCode()`
- **Polimorfismo**: `Garagem` e `SimuladorDeTrafego` operam com array genérico de `Veiculo`
- **Tratamento de erros**: garagem cheia e aceleração sem combustível
