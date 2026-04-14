/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo.java.simulacao_veiculos;

/**
 *
 * @author jeduardo
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Garagem g = new Garagem(3);

        Carro c1 = new Carro("Toyota", "Corolla");
        Carro c2 = new Carro("Honda", "Civic", 60);

        c1.acelerar();         // +10 → 10 km/h
        c1.acelerar(30);       // +30 → 40 km/h
        c2.frear(20);          // -20 → 40 km/h

        g.adicionarCarro(c1);
        g.adicionarCarro(c2);
        g.listarCarros();
        
    }
    
}
