/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinal.grafos;

import java.io.FileNotFoundException;


/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class TrabalhoFinalGrafos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            FileHelper fileHelper = new FileHelper();
            fileHelper.readFile("./src/files/input.txt");
            
            PrimGraph graph = new PrimGraph(fileHelper.getFinalMatrix(), fileHelper.getarrayDimension());
            graph.printMinimalTree();
        
        } catch (FileNotFoundException ex) {
            // Logger.getLogger(TrabalhoFinalGrafos.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Arquivo não encontrado.");
        }
        
    }
    
}
