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
    private int v;
    private Staffetta s;
    
    public Runner(Staffetta s){
        v = 0;
        this.s = s;
    }
    
    public void run(){
        v++;
    }
    
    public int getValue(){
        return v;
    }
    
    @Override
    public void start(){
        try {
            s.run(this);
        } catch (InterruptedException ex) {
            System.getLogger(Runner.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        s.pass();
    }
}
