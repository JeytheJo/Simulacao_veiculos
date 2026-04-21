package simulador;

public class Veiculo {
    private String marca;
    private String modelo;
    private double velocidade;
    private String placa;
    private double combustivel;

    public Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidade = 0;
        this.combustivel = 100.0;
    }

    public Veiculo(String marca, String modelo, double velocidade) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidade = velocidade;
        this.combustivel = 100.0;
    }

    // Getters e Setters
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public double getVelocidade() { return velocidade; }
    public void setVelocidade(double velocidade) { this.velocidade = velocidade; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public double getCombustivel() { return combustivel; }
    public void setCombustivel(double combustivel) { this.combustivel = combustivel; }

    // Acelerar - sobrecarga
    public void acelerar() {
        if (combustivel <= 0) {
            System.out.println("[ERRO] " + marca + " " + modelo + " sem combustivel! Abasteça antes de acelerar.");
            return;
        }
        this.velocidade += 10;
        this.combustivel -= 1;
    }

    public void acelerar(int incremento) {
        if (combustivel <= 0) {
            System.out.println("[ERRO] " + marca + " " + modelo + " sem combustivel! Abasteça antes de acelerar.");
            return;
        }
        this.velocidade += incremento;
        this.combustivel -= (incremento * 0.1);
    }

    // Frear - sobrecarga
    public void frear() {
        this.velocidade = Math.max(0, this.velocidade - 10);
    }

    public void frear(int decremento) {
        this.velocidade = Math.max(0, this.velocidade - decremento);
    }

    // Ligar - sobrecarga
    public void ligar() {
        System.out.println(marca + " " + modelo + " ligado no modo padrão.");
    }

    public void ligar(String modo) {
        System.out.println(marca + " " + modelo + " ligado no modo: " + modo + ".");
    }

    // Abastecer - sobrecarga
    public void abastecer(double litros) {
        this.combustivel += litros;
        System.out.println(marca + " " + modelo + " abastecido com " + litros + "L. Combustivel total: " + combustivel + "L");
    }

    public void abastecer(double litros, String tipoCombustivel) {
        this.combustivel += litros;
        System.out.println(marca + " " + modelo + " abastecido com " + litros + "L de " + tipoCombustivel + ". Combustivel total: " + combustivel + "L");
    }

    // Calcular consumo por km
    public double calcularConsumo() {
        return 10.0; // km por litro padrao
    }

    // Exibir status - sobrescrito nas filhas
    public void exibirStatus() {
        System.out.println("Veiculo: " + marca + " " + modelo + " | Velocidade: " + velocidade + " km/h | Combustivel: " + combustivel + "L");
    }

    // Interagir - sobrecarga
    public void interagir(Veiculo outro) {
        System.out.println(this.marca + " " + this.modelo + " interagindo com " + outro.getMarca() + " " + outro.getModelo() + ".");
    }

    public void interagir(Caminhao c) {
        if (this.velocidade > c.getVelocidade()) {
            System.out.println(this.marca + " " + this.modelo + " ultrapassando o caminhao " + c.getMarca() + " " + c.getModelo() + "!");
        } else {
            System.out.println(this.marca + " " + this.modelo + " nao consegue ultrapassar o caminhao " + c.getMarca() + " " + c.getModelo() + ". Risco de colisao!");
        }
    }

    // equals e hashCode baseados na placa
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Veiculo outro = (Veiculo) obj;
        if (this.placa == null || outro.placa == null) return false;
        return this.placa.equalsIgnoreCase(outro.placa);
    }

    @Override
    public int hashCode() {
        return placa != null ? placa.toUpperCase().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Veiculo: " + marca + " " + modelo + " - Velocidade: " + velocidade + " km/h";
    }
}
