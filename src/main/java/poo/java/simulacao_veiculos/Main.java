package simulador;

public class Main {
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("  SISTEMA DE SIMULACAO DE VEICULOS");
        System.out.println("========================================\n");

        // ==========================================
        // PARTE 1 - O Primeiro Motor
        // ==========================================
        System.out.println(">>> PARTE 1: O Primeiro Motor\n");

        // Sobrecarga de construtores
        Carro carro1 = new Carro("Toyota", "Corolla");
        Carro carro2 = new Carro("Honda", "Civic", 30.0);

        // toString sobrescrito
        System.out.println(carro1);
        System.out.println(carro2);

        // Sobrecarga de acelerar/frear
        carro1.acelerar();        // +10 km/h
        carro1.acelerar(25);      // +25 km/h
        System.out.println("Apos acelerar: " + carro1);

        carro1.frear();           // -10 km/h
        carro1.frear(15);         // -15 km/h
        System.out.println("Apos frear: " + carro1);

        // Garagem com array fixo (Parte 1 - só carros)
        Garagem garagem = new Garagem(3);
        garagem.estacionar(carro1);
        garagem.estacionar(carro2);
        garagem.listarVeiculos();

        // ==========================================
        // PARTE 2 - A Frota Diversificada
        // ==========================================
        System.out.println(">>> PARTE 2: A Frota Diversificada\n");

        Moto moto1 = new Moto("Honda", "CB300", 0, 300);
        Moto moto2 = new Moto("Yamaha", "MT-07");

        // Estacionar motos (sobrecarga de estacionar)
        garagem.estacionar(moto1);
        garagem.estacionar(moto2); // deve dar erro: garagem cheia (cap=3)
        garagem.listarVeiculos();

        // Moto acelera mais rapido (sobrescrita)
        moto1.acelerar(); // +15 km/h
        moto1.acelerar(); // +15 km/h
        System.out.println("Moto apos 2x acelerar: " + moto1);

        carro1.acelerar(); // +10 km/h
        System.out.println("Carro apos 1x acelerar: " + carro1);

        // exibirStatus (sobrescrita nas filhas)
        moto1.exibirStatus();
        carro1.exibirStatus();

        // ligar com sobrecarga
        carro1.ligar();
        moto1.ligar("Esportivo");
        carro2.ligar("Economico");

        // ==========================================
        // PARTE 3 - O Simulador de Trafego
        // ==========================================
        System.out.println("\n>>> PARTE 3: O Simulador de Trafego\n");

        Caminhao caminhao1 = new Caminhao("Volvo", "FH 500", 0, 20.0);
        Carro carro3 = new Carro("Ford", "Mustang", 0, 2);
        Moto moto3 = new Moto("Kawasaki", "Ninja", 0, 650);

        // Placas para equals/hashCode
        carro3.setPlaca("ABC-1234");
        caminhao1.setPlaca("XYZ-9999");

        Carro carroIgual = new Carro("Outra", "Marca");
        carroIgual.setPlaca("ABC-1234"); // mesma placa = mesmo veiculo

        SimuladorDeTrafego simulador = new SimuladorDeTrafego(5);
        simulador.adicionarVeiculo(carro3);
        simulador.adicionarVeiculo(moto3);
        simulador.adicionarVeiculo(caminhao1);

        // Simulacao de corrida
        simulador.simularCorrida(3);

        // Interacoes
        simulador.simularInteracoes();

        // Status geral
        simulador.exibirStatusTodos();

        // Abastecer - sobrecarga
        caminhao1.abastecer(50.0);
        carro3.abastecer(30.0, "Gasolina Aditivada");

        // calcularConsumo (sobrescrita)
        System.out.println("\n=== CONSUMO POR VEICULO ===");
        System.out.println("Carro " + carro3.getModelo() + ": " + carro3.calcularConsumo() + " km/L");
        System.out.println("Moto " + moto3.getModelo() + ": " + moto3.calcularConsumo() + " km/L");
        System.out.println("Caminhao " + caminhao1.getModelo() + ": " + caminhao1.calcularConsumo() + " km/L");

        // equals e hashCode
        simulador.compararVeiculos(carro3, carroIgual);
        simulador.compararVeiculos(carro3, caminhao1);

        // Teste de robustez: veiculo sem combustivel
        System.out.println("=== TESTE ROBUSTEZ: acelerando sem combustivel ===");
        Carro semGas = new Carro("Fiat", "Uno");
        semGas.setCombustivel(0);
        semGas.acelerar();

        System.out.println("\nFim da simulacao!");
    }
}
