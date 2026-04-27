/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

/**
 *
 * @author lin.elena
 */
public class Runner extends Thread{
    private int v, id;
    private ThreadManager tm;
    
    public Runner(int id, ThreadManager tm){
        v = 0;
        this.id = id;
        this.tm = tm;
    }
    
    public int getid(){
        return id;
    }
    
    
    public int getValue(){
        return v;
    }
    
    @Override
    public void run(){
        try {
            tm.attendi(id);
        } catch (InterruptedException ex) {
            System.getLogger(Runner.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        while (v < 100) {
            v += 10;
            
            System.out.println("Runner " + id + " corre...");
            
            if (v == 90) {
                tm.passa();
                System.out.println("Runner " + id + " passa...");
            }
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
