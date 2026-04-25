/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

/**
 *
 * @author zxt02
 */
public class ThreadManager {
    private Testimone t;
    private int nRunner;
    
    public ThreadManager(Testimone t, int nRunner){
        this.t = t;
        this.nRunner = nRunner;
    }
    
    public synchronized void attendi(int id) throws InterruptedException{
        while(t.getTurno() != id){
            wait();
        }
    }
    
    public synchronized void passa(){
        t.setTurno(t.getTurno() + 1);
        notifyAll();
    }
}
