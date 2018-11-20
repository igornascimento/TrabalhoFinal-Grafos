/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinal.grafos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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
    
    private int[] vertices = {};
    private int[][] tree = {};
    
    PrimGraph(int[][] matrix) {
        
        for (int[] row : matrix) {
            
            int originVertice = row[0];
            int destinationVertice = row[1];
            int aresta = row[2];
            int[] tempTreeSegment = {originVertice, destinationVertice};
            
            // adds the vertice if not exists
            if (!IntStream.of(vertices).anyMatch(x -> x == originVertice)) {
                vertices[ vertices.length+1 ] = originVertice;
            }
            
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
                    }
                }
                
                // adds to the tree
                tree[ tree.length+1 ] = tempTreeSegment;
            }
        }
        
    }
    
    public void printMinimalTree() {
        
    }
    
}
