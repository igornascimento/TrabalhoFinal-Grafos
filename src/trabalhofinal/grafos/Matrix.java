/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinal.grafos;

import java.util.ArrayList;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class Matrix<T> extends ArrayList<ArrayList<T>> {
    
    public void addElement(T value1, T value2) {
        ArrayList<T> innerMatrix = new ArrayList<>();
        innerMatrix.add(value1);
        innerMatrix.add(value2);
        this.add(innerMatrix);
    }

}
