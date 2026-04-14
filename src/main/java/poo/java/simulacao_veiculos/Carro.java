package poo.java.simulacao_veiculos;

public class Carro extends Veiculo {
    public Carro(String marca, String modelo) {
        super(marca, modelo);
    }
    
    public Carro(String marca, String modelo, int velocidadeInicial) {
        super(marca, modelo);
        setVelocidade(velocidadeInicial);
        
    }
    
    public void acelerar() {
        setVelocidade(getVelocidade() + 10);
    }
    
    public void acelerar(int incremento) {
        setVelocidade(getVelocidade() + incremento);
    }
    
    public void frear() {
        int nova = getVelocidade() - 10;
        setVelocidade(nova < 0 ? 0 : nova);
    }
    
    public void frear(int decremento) {
        int nova = getVelocidade() - decremento;
        setVelocidade(nova < 0 ? 0 : nova);
        
    }
    @Override
    public String toString() {
        return "Carro: " + getMarca() + " " + getModelo() + " - Velocidade: " + getVelocidade() + " km/h";
    }
    
}
