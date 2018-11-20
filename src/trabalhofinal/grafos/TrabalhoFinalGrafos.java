/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinal.grafos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class TrabalhoFinalGrafos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List input = new ArrayList();
        FileHelper fileHelper = new FileHelper();
        input = fileHelper.readFile("etc/input.txt");
        
        PrimGraph graph = new PrimGraph(input);
        graph.printMinimalTree();
        
    }
    
}
