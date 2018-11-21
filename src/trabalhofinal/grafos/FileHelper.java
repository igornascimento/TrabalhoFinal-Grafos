/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinal.grafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Reads the file and returns the final matrix
 * 
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
class FileHelper {
    
    public int[][] readFile(String source) throws FileNotFoundException {
        
        File file = new File(source);
        Scanner scanner = new Scanner(file);
        
        // gets the first line to define the array
        String[] arrStrings = scanner.nextLine().split(" ");
        int numRows = Integer.parseInt(arrStrings[1]);
        
        int cnt = 0;
        int[][] finalMatrix = new int[numRows][3];
        
        while (scanner.hasNextLine()) {
            
            arrStrings = scanner.nextLine().split(" ");
            
            // ignoring first line (num of vertices and arestas)
            if (cnt != 0) {
                int[] arr = {
                    Integer.parseInt(arrStrings[0]), 
                    Integer.parseInt(arrStrings[1]), 
                    Integer.parseInt(arrStrings[2])
                };
                
                // populating the final matrix
                finalMatrix[cnt-1] = arr;
            }
            cnt++;
        }
        
        return finalMatrix;
    }
    
}
