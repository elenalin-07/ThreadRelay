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
    public void run(String n) throws InterruptedException{
        while (stato) {
            System.out.println("t" + n + "in attessa");
            wait();
        }

        stato = true;
        System.out.println("t" + n + "in corsa");
    }
    
    public void pass(){
        stato = false;
        System.out.println("staffetta passata");
        notifyAll();
    }
}
