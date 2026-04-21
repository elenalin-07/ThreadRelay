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
    private String n;
    
    public Runner(Staffetta s, String n){
        v = 0;
        this.s = s;
        this.n = n;
    }
    
    public String getNome(){
        return n;
    }
    
    
    public int getValue(){
        return v;
    }
    
    @Override
    public void run(){
        try {
            s.run(n);
        } catch (InterruptedException ex) {
            System.getLogger(Runner.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        s.pass();
    }
}
