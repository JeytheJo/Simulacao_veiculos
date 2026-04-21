package simulador;

public class Caminhao extends Veiculo {
    private double capacidadeCarga; // em toneladas

    public Caminhao(String marca, String modelo) {
        super(marca, modelo);
        this.capacidadeCarga = 5.0;
    }

    public Caminhao(String marca, String modelo, double velocidadeInicial) {
        super(marca, modelo, velocidadeInicial);
        this.capacidadeCarga = 5.0;
    }

    public Caminhao(String marca, String modelo, double velocidadeInicial, double capacidadeCarga) {
        super(marca, modelo, velocidadeInicial);
        this.capacidadeCarga = capacidadeCarga;
    }

    public double getCapacidadeCarga() { return capacidadeCarga; }
    public void setCapacidadeCarga(double capacidadeCarga) { this.capacidadeCarga = capacidadeCarga; }

    // Sobrescrita acelerar - Caminhao acelera mais devagar: 5km/h
    @Override
    public void acelerar() {
        if (getCombustivel() <= 0) {
            System.out.println("[ERRO] " + getMarca() + " " + getModelo() + " sem combustivel!");
            return;
        }
        setVelocidade(getVelocidade() + 5);
        setCombustivel(getCombustivel() - 3);
    }

    // Sobrescrita exibirStatus
    @Override
    public void exibirStatus() {
        System.out.println("Caminhao: " + getMarca() + " " + getModelo()
                + " | Velocidade: " + getVelocidade() + " km/h"
                + " | Carga: " + capacidadeCarga + "t"
                + " | Combustivel: " + getCombustivel() + "L");
    }

    // Sobrescrita calcularConsumo - Caminhao consome muito mais
    @Override
    public double calcularConsumo() {
        return 3.5; // 3.5 km/L - bem menos eficiente
    }

    @Override
    public String toString() {
        return "Caminhao: " + getMarca() + " " + getModelo() + " - Velocidade: " + getVelocidade() + " km/h";
    }
}
