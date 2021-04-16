/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erwinekowahyudi
 */
public class Node {
    private int iData;
    
    public Node(int key){
        iData = key;
    }
    
    public int getKey(){
        return iData;
    }
    
    public void setKey(int id){
        iData = id;
    }
}
