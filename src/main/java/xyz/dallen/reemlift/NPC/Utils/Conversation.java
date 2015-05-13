/*
 * This file is part of Reemlift.
 * 
 * Reemlift is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Reemlift is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Reemlift.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * 
 */
package main.java.xyz.dallen.reemlift.NPC.Utils;

import java.util.Arrays;
import java.util.HashMap;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 
 * @author Donovan
 */
public class Conversation {
    
    public static class Node {
        
        @Getter @Setter
        private int toAdv;
        
        @Getter @Setter
        private HashMap<String, String> ops = new HashMap<>();
        
        public Node(){}
        
    }
    
    @Getter @Setter
    private int size; 
    
    @Getter @Setter @JsonIgnore
    private Node[] nodes = new Node[size];
    
    @Getter @JsonIgnore
    private int current = 0;
    
    @Getter @Setter
    private String end;
    
    public Conversation(){}
    
    public String getChat(String input){
        String rtn = nodes[current].getOps().get(input);
        int index = Arrays.asList(nodes[current].getOps().keySet().toArray()).indexOf(input);
        if(nodes[current].getToAdv() == index){
            if(nodes.length > current){
                current++;
                return rtn;
            }else{
                return end;
            }
        }else{
            return rtn;
        }
    }
    
}
