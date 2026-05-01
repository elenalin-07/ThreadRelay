/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

import java.util.ArrayList;

/**
 *
 * @author zxt02
 */
import java.util.ArrayList;

public class ThreadManager {
    private Testimone t;
    private ArrayList<Observer> observers = new ArrayList<>();

    public ThreadManager(Testimone t) {
        this.t = t;
    }

    public synchronized void attendi(int id) throws InterruptedException {
        while (t.getTurno() != id) {
            wait();
        }
    }

    public synchronized void passa() {
        t.setTurno(t.getTurno() + 1);
        notifyAll();
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public synchronized void notifyProgress(int id, int value) {
        for (Observer o : observers) {
            o.update(id, value);
        }
    }
}
