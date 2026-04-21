package simulador;

public class Carro extends Veiculo {
    private int numeroDePorras;

    // Sobrecarga de construtores
    public Carro(String marca, String modelo) {
        super(marca, modelo);
        this.numeroDePorras = 4;
    }

    public Carro(String marca, String modelo, double velocidadeInicial) {
        super(marca, modelo, velocidadeInicial);
        this.numeroDePorras = 4;
    }

    public Carro(String marca, String modelo, double velocidadeInicial, int numeroDePortas) {
        super(marca, modelo, velocidadeInicial);
        this.numeroDePorras = numeroDePortas;
    }

    public int getNumeroDePortas() { return numeroDePorras; }
    public void setNumeroDePortas(int numeroDePortas) { this.numeroDePorras = numeroDePortas; }

    // Sobrescrita acelerar - Carro acelera 10km/h por padrão (já herdado, mas explícito)
    @Override
    public void acelerar() {
        if (getCombustivel() <= 0) {
            System.out.println("[ERRO] " + getMarca() + " " + getModelo() + " sem combustivel!");
            return;
        }
        setVelocidade(getVelocidade() + 10);
        setCombustivel(getCombustivel() - 1);
    }

    // Sobrescrita exibirStatus
    @Override
    public void exibirStatus() {
        System.out.println("Carro: " + getMarca() + " " + getModelo()
                + " | Velocidade: " + getVelocidade() + " km/h"
                + " | Portas: " + numeroDePorras
                + " | Combustivel: " + getCombustivel() + "L");
    }

    // Sobrescrita calcularConsumo
    @Override
    public double calcularConsumo() {
        return 12.0; // 12 km/L
    }

    // Sobrescrita toString
    @Override
    public String toString() {
        return "Carro: " + getMarca() + " " + getModelo() + " - Velocidade: " + getVelocidade() + " km/h";
    }
}
