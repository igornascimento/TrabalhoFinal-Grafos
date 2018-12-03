/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinal.grafos;


import java.util.ArrayList;
import java.util.Arrays;
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
    
    private int[][] internalTree = {};
    private int[] internalVertices = {};
    
    PrimGraph(int[][] matrix, int arrayDimension) {
        
        int[] vertices = new int[arrayDimension];
        int[][] tree = new int[arrayDimension][];
        int rowCount = 0, innerRowCount = 0, evaluatedCount = -1;
        
//        // adding the starting vertice and tree element
//        vertices[0] = matrix[0][0];
//        tree[0][0] = matrix[0][0];
//        tree[0][1] = matrix[0][1];
        
        for (int[] row : matrix) {
            int originVertice = row[0];
            int destinationVertice = row[1];
            int aresta = row[2];
            // initializing vars for inner loop
            int newOriginVertice = 0;
            int newDestinationVertice = 0;
            int newAresta;
            
            int[] evaluatedVertices = new int[2];
            int evaluatedAresta = 0;
            boolean verified = false;
            
            // iterates over the same matrix to compare with other ocurrences of the same vertice
            for (int[] newRow : matrix) {

                newOriginVertice = newRow[0];
                newDestinationVertice = newRow[1];
                newAresta = newRow[2];
                
                // ensure it is a different row
                if (rowCount != innerRowCount) {
                    
                    // test other ocurrences of the same vertice
                    if ((originVertice == newOriginVertice) && (destinationVertice != newDestinationVertice)) {
                        System.out.println(">> " + newOriginVertice +":"+":"+ newDestinationVertice +":"+ aresta +":"+ newAresta);
                        if (newAresta < aresta) {
                            System.out.println("Verifying " + newOriginVertice +":"+":"+ newDestinationVertice +":"+ aresta);
                            evaluatedVertices[0] = newOriginVertice;
                            evaluatedVertices[1] = newDestinationVertice;
                            evaluatedAresta = newAresta;
                            verified = true;
                            evaluatedCount++;
                        }
                    }
                }
                innerRowCount++;
            }
            // adding to the tree
            if (verified) {
                System.out.println("Adding " + evaluatedVertices[0] +":"+":"+ evaluatedVertices[1] +":"+ evaluatedAresta);
                vertices[evaluatedCount] = evaluatedVertices[0];
                tree[evaluatedCount] = evaluatedVertices;
            }
            verified = false;
            
            innerRowCount = 0;
            rowCount++;
        }
        this.internalTree = tree;
        this.internalVertices = vertices;
    }
    
    public void printMinimalTree() {
        System.out.println("Printing ARRAY OF VERTICES:");
        System.out.println(Arrays.toString(this.internalVertices));
        System.out.println("Printing MINIMAL TREE:");
        System.out.println(Arrays.toString(this.internalTree));
        
        for (int i=0; i<this.internalTree.length; i++) {
            System.out.println(this.internalTree[i]);
        }
    }
    
}
