/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

/**
 *
 * @author lin.elena
 */
public class Runner extends Thread implements Observer {
    private int v, id, velocita;
    private ThreadManager tm;
    private boolean run;

    public Runner(int id, ThreadManager tm) {
        this.id = id;
        this.tm = tm;
        this.v = 0;
        run = true;
    }
    
    public int getValue() {
        return v;
    }
    
    public void setVelocita(int v){
        velocita = v;
    }
    
    public void stoppa(){
        run = false;
    }
    
    public synchronized void continua(){
        run = true;
        notify();
    }
    
    @Override
    public void run() {
        try {
            tm.attendi(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (v < 100) {
            v += 1;
            
            synchronized (this) {
                while (!run) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
             
            tm.notifyProgress(id, v); // 🔥 notifica GUI

            if (v == 90) {
                tm.passa();
            }

            try {
                Thread.sleep(velocita);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void update(int runnerId, int value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
