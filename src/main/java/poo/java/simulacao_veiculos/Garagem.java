package simulador;

public class Garagem {
    private Veiculo[] veiculos;
    private int totalVeiculos;
    private int capacidade;

    public Garagem(int capacidade) {
        this.capacidade = capacidade;
        this.veiculos = new Veiculo[capacidade];
        this.totalVeiculos = 0;
    }

    // Sobrecarga de estacionar
    public void estacionar(Carro c) {
        if (totalVeiculos >= capacidade) {
            System.out.println("[ERRO] Garagem cheia! Nao foi possivel estacionar o carro " + c.getMarca() + " " + c.getModelo() + ".");
            return;
        }
        veiculos[totalVeiculos] = c;
        totalVeiculos++;
        System.out.println("Carro " + c.getMarca() + " " + c.getModelo() + " estacionado. (" + totalVeiculos + "/" + capacidade + ")");
    }

    public void estacionar(Moto m) {
        if (totalVeiculos >= capacidade) {
            System.out.println("[ERRO] Garagem cheia! Nao foi possivel estacionar a moto " + m.getMarca() + " " + m.getModelo() + ".");
            return;
        }
        veiculos[totalVeiculos] = m;
        totalVeiculos++;
        System.out.println("Moto " + m.getMarca() + " " + m.getModelo() + " estacionada. (" + totalVeiculos + "/" + capacidade + ")");
    }

    public void estacionar(Caminhao c) {
        if (totalVeiculos >= capacidade) {
            System.out.println("[ERRO] Garagem cheia! Nao foi possivel estacionar o caminhao " + c.getMarca() + " " + c.getModelo() + ".");
            return;
        }
        veiculos[totalVeiculos] = c;
        totalVeiculos++;
        System.out.println("Caminhao " + c.getMarca() + " " + c.getModelo() + " estacionado. (" + totalVeiculos + "/" + capacidade + ")");
    }

    public void listarVeiculos() {
        System.out.println("\n--- Veiculos na Garagem (" + totalVeiculos + "/" + capacidade + ") ---");
        if (totalVeiculos == 0) {
            System.out.println("Garagem vazia.");
            return;
        }
        for (int i = 0; i < totalVeiculos; i++) {
            System.out.println("[" + (i + 1) + "] " + veiculos[i]);
        }
        System.out.println("-----------------------------------\n");
    }

    public Veiculo[] getVeiculos() { return veiculos; }
    public int getTotalVeiculos() { return totalVeiculos; }
    public int getCapacidade() { return capacidade; }
}
