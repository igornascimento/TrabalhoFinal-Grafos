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
    private final List<Integer> tree = new ArrayList<>();
    
    PrimGraph(int[][] matrix) {
        
        // adding the starting vertice
        vertices.add(matrix[0][0]);
        
        for (int[] row : matrix) {
            
            int originVertice = row[0];
            int destinationVertice = row[1];
            int aresta = row[2];
            Integer[] tempTreeSegment = {originVertice, destinationVertice};
            
            // // adds the first vertice if not exists
            // if (!IntStream.of(vertices).anyMatch(x -> x == originVertice)) {
            //     vertices[ vertices.length+1 ] = tempTreeSegment[0];
            // }
            
            // iterates over the same matrix to compare with other ocurrences of the same vertice
            for (int[] newRow : matrix) {

                int newOriginVertice = newRow[0];
                int newDestinationVertice = newRow[1];
                int newAresta = newRow[2];
                
                // test other ocurrences of the same vertice AND ensure it is another row
                if (originVertice == newOriginVertice && destinationVertice != newDestinationVertice) {
                    if (aresta < newAresta) {
                        tempTreeSegment[0] = newOriginVertice;
                        tempTreeSegment[1] = newDestinationVertice;
                        
                        // adds the second vertice
                        vertices.add(tempTreeSegment[0]);

                        // adds to the tree
                        //tree.add(tempTreeSegment);
                        Collections.addAll(tree, tempTreeSegment);
                        System.out.println("Segment: " + tempTreeSegment[0]);
                    }
                }
            }
        }
        
    }
    
    public void printMinimalTree() {
        System.out.println("Printing MINIMAL TREE:");
        System.out.println(vertices.toString());
        System.out.println("Printing TREE:");
        System.out.println(tree.toString());
    }
    
}
