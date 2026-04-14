/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.java.simulacao_veiculos;

/**
 *
 * @author jeduardo
 */
public class Garagem {
    private Carro[] carros;
    private int totalCarros;
    
    public Garagem(int capacidade){
        carros = new Carro[capacidade];
        totalCarros = 0;
        
    }
    
    public boolean adicionarCarro(Carro carro) {
        if (totalCarros < carros.length) {
            carros[totalCarros] = carro;
            totalCarros++;
            return true;
        }
        System.out.println("Garagem cheia!!");
        return false;
        
    }
    
    public void listarCarros() {
        if (totalCarros == 0) {
            System.out.println("Garagem vazia");
            return;
        }
        for (int i = 0; i < totalCarros; i++) {
            System.out.println(carros[i]); // chama o toString() automaticamente
        } 
    }
    
}
