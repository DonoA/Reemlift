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
package main.java.xyz.dallen.reemlift.Utils;

import java.io.IOException;
import java.io.PrintStream;
import main.java.xyz.dallen.reemlift.Reemlift;

/**
 *
 * @author Donovan
 */
public class LogUtil {
    
    private static PrintStream out;
    
    public static void setOutStream(PrintStream os){
        out = os;
    }
    
    public static void info(Object msg){
        try {
            out.println(Reemlift.getJson().writeValueAsString(msg));
        } catch (IOException ex) {
            out.println("Error printing info");
        }
    }
    
    public static void debug(Object msg){
        if(Reemlift.isDebug()){
            try {
                out.println(StreamColor.CYAN + "[DEBUG] " + Reemlift.getJson().writeValueAsString(msg));
            } catch (IOException ex) {
                out.println("Error printing debug");
            }
        }
    }
    
    public static class StreamColor{
        public static final String RESET = "\u001B[0m";
        public static final String BLACK = "\u001B[30m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String PURPLE = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
        public static final String WHITE = "\u001B[37m";
    }
}
