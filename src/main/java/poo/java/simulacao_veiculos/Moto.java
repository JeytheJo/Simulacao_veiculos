package simulador;

public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String marca, String modelo) {
        super(marca, modelo);
        this.cilindradas = 150;
    }

    public Moto(String marca, String modelo, double velocidadeInicial) {
        super(marca, modelo, velocidadeInicial);
        this.cilindradas = 150;
    }

    public Moto(String marca, String modelo, double velocidadeInicial, int cilindradas) {
        super(marca, modelo, velocidadeInicial);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() { return cilindradas; }
    public void setCilindradas(int cilindradas) { this.cilindradas = cilindradas; }

    // Sobrescrita acelerar - Moto acelera mais rapido: 15km/h por padrão
    @Override
    public void acelerar() {
        if (getCombustivel() <= 0) {
            System.out.println("[ERRO] " + getMarca() + " " + getModelo() + " sem combustivel!");
            return;
        }
        setVelocidade(getVelocidade() + 15);
        setCombustivel(getCombustivel() - 0.8);
    }

    // Sobrescrita exibirStatus
    @Override
    public void exibirStatus() {
        System.out.println("Moto: " + getMarca() + " " + getModelo()
                + " | Velocidade: " + getVelocidade() + " km/h"
                + " | Cilindradas: " + cilindradas + "cc"
                + " | Combustivel: " + getCombustivel() + "L");
    }

    // Sobrescrita calcularConsumo
    @Override
    public double calcularConsumo() {
        return 25.0; // 25 km/L - moto é mais econômica
    }

    @Override
    public String toString() {
        return "Moto: " + getMarca() + " " + getModelo() + " - Velocidade: " + getVelocidade() + " km/h";
    }
}
