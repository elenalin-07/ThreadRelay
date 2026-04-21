/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

/**
 *
 * @author lin.elena
 */
public class Staffetta {
    private boolean stato;
    
    public Staffetta(){
        stato = false;
    }
    public void run(Runner r) throws InterruptedException{
        while (stato) {
            wait();
        }

        stato = true;

        while (r.getValue() < 90) {
            r.wait(500);
            r.run();
        }
    }
    
    public void pass(){
        stato = false;
        notifyAll();
    }
}
