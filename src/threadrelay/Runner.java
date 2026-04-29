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

    private int v, id;
    private ThreadManager tm;

    public Runner(int id, ThreadManager tm) {
        this.id = id;
        this.tm = tm;
        this.v = 0;
    }
    
    public int getValue() {
        return v;
    }

    @Override
    public void run() {
        try {
            tm.attendi(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (v < 100) {
            v += 10;

            tm.notifyProgress(id, v); // 🔥 notifica GUI

            if (v == 90) {
                tm.passa();
            }

            try {
                Thread.sleep(500);
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
