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
        Testimone t = new Testimone(1);
        ThreadManager tm = new ThreadManager(t, 4);
        
        Runner r1 = new Runner(1, tm);
        Runner r2 = new Runner(2, tm);
        Runner r3 = new Runner(3, tm);
        Runner r4 = new Runner(4, tm);
        
        r1.start();
        r2.start();
        r3.start();
        r4.start();
    }
    
}
