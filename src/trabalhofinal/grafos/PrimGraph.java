/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinal.grafos;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Mounts the minimal tree using the Prim algorithm model
 * It receives a matrix of values as follows:
 * 
 * [code]
 * {
 *   (vertice1, vertice2, arestaValue),
 *   (vertice1, vertice2, arestaValue)
 * }
 * [/code]
 * 
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
class PrimGraph {
    
    private final List vertices = new ArrayList();
    private final Matrix tree = new Matrix();
    
    PrimGraph(int[][] matrix) {
        
        // adding the starting vertice
        vertices.add(matrix[0][0]);
        int rowCount = 0, innerRowCount = 0;
        
        for (int[] row : matrix) {
            
            int originVertice = row[0];
            int destinationVertice = row[1];
            int aresta = row[2];
            tree.addElement(originVertice, destinationVertice);
            
            // iterates over the same matrix to compare with other ocurrences of the same vertice
            for (int[] newRow : matrix) {

                int newOriginVertice = newRow[0];
                int newDestinationVertice = newRow[1];
                int newAresta = newRow[2];
                
                // ensure it is a different row
                if (rowCount != innerRowCount) {
                    
                    // test other ocurrences of the same vertice
                    if ((originVertice == newOriginVertice) && (destinationVertice != newDestinationVertice)) {
                        if (aresta < newAresta) {
                            vertices.add(newOriginVertice);
                            tree.addElement(newOriginVertice, newDestinationVertice);
                        }
                    }
                }
                innerRowCount++;
            }
            innerRowCount = 0;
            rowCount++;
        }
        
    }
    
    public void printMinimalTree() {
        System.out.println("Printing MINIMAL TREE:");
        System.out.println(vertices.toString());
        System.out.println("Printing TREE:");
        System.out.println(tree.toString());
        
        for (int i=0; i<tree.size(); i++) {
            System.out.println(tree.get(i));
        }
    }
    
}
