package simulador;

public class SimuladorDeTrafego {
    private Veiculo[] pista;
    private int totalNaPista;
    private int capacidadePista;

    public SimuladorDeTrafego(int capacidade) {
        this.capacidadePista = capacidade;
        this.pista = new Veiculo[capacidade];
        this.totalNaPista = 0;
    }

    public void adicionarVeiculo(Veiculo v) {
        if (totalNaPista >= capacidadePista) {
            System.out.println("[ERRO] Pista cheia! Nao foi possivel adicionar " + v.getMarca() + " " + v.getModelo() + ".");
            return;
        }
        pista[totalNaPista] = v;
        totalNaPista++;
        System.out.println(v + " adicionado a pista.");
    }

    public void simularCorrida(int rodadas) {
        System.out.println("\n=== INICIO DA SIMULACAO (" + rodadas + " rodadas) ===\n");
        for (int r = 1; r <= rodadas; r++) {
            System.out.println("-- Rodada " + r + " --");
            for (int i = 0; i < totalNaPista; i++) {
                if (pista[i] != null) {
                    pista[i].acelerar();
                    System.out.println(pista[i]);
                }
            }
        }
        System.out.println("\n=== FIM DA SIMULACAO ===\n");
    }

    public void simularInteracoes() {
        System.out.println("\n=== INTERACOES NA PISTA ===\n");
        for (int i = 0; i < totalNaPista; i++) {
            for (int j = i + 1; j < totalNaPista; j++) {
                if (pista[j] instanceof Caminhao) {
                    pista[i].interagir((Caminhao) pista[j]);
                } else {
                    pista[i].interagir(pista[j]);
                }
            }
        }
        System.out.println();
    }

    public void exibirStatusTodos() {
        System.out.println("\n=== STATUS DE TODOS OS VEICULOS ===");
        for (int i = 0; i < totalNaPista; i++) {
            if (pista[i] != null) {
                pista[i].exibirStatus();
            }
        }
        System.out.println("===================================\n");
    }

    public void compararVeiculos(Veiculo v1, Veiculo v2) {
        System.out.println("\n=== COMPARACAO DE VEICULOS ===");
        System.out.println("V1: " + v1);
        System.out.println("V2: " + v2);
        System.out.println("Sao o mesmo veiculo (por placa)? " + v1.equals(v2));
        System.out.println("Consumo V1: " + v1.calcularConsumo() + " km/L");
        System.out.println("Consumo V2: " + v2.calcularConsumo() + " km/L");
        System.out.println("==============================\n");
    }
}
