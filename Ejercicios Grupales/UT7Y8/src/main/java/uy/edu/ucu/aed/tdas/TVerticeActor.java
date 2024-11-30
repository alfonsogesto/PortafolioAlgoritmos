/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.ucu.aed.tdas;


public class TVerticeActor extends TVertice<Object> implements IVerticeKevinBacon {
    private int bacon = -1;

    public TVerticeActor(Comparable unaEtiqueta) {
        super(unaEtiqueta);
    }

    @Override
    public int getBacon() {
        return this.bacon;
    }

    @Override
    public void setBacon(int newBacon) {
        this.bacon = newBacon;
    }
    
}
