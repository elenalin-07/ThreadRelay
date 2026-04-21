/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package threadrelay;

/**
 *
 * @author delfo
 */
public class ThreadRelay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Staffetta s = new Staffetta();
        
        Runner r1 = new Runner(s, "1");
        Runner r2 = new Runner(s, "2");
        Runner r3 = new Runner(s, "3");
        Runner r4 = new Runner(s, "4");
        
        r1.start();
        r2.start();
        r3.start();
        r4.start();
    }
    
}
