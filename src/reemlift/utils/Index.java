/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reemlift.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Donovan
 */
public class Index {
    public static HashMap<String, HashMap<String, Integer>> races = new HashMap<>();
    public static HashMap<String, String> raceDes = new HashMap<>();
    public static void Setup(){
        HashMap<String, Integer> holder = new HashMap<>();
        //hp, int, dex, acc, str
        holder.put("hp", 1);
        holder.put("int", 1);
        holder.put("dex", 1);
        holder.put("acc", 1);
        holder.put("str", 1);
        raceDes.put("Orc", "thing and also a lot more things that are here now cuz testing royal");
        races.put("Orc", holder);
        holder = new HashMap<>();
        //hp, int, dex, acc, str
        holder.put("hp", 1);
        holder.put("int", 1);
        holder.put("dex", 1);
        holder.put("acc", 1);
        holder.put("str", 1);
        raceDes.put("Elf", "thing");
        races.put("Elf", holder);
        holder = new HashMap<>();
        //hp, int, dex, acc, str
        holder.put("hp", 1);
        holder.put("int", 1);
        holder.put("dex", 1);
        holder.put("acc", 1);
        holder.put("str", 1);
        raceDes.put("Dwarf", "thing");
        races.put("Dwarf", holder);
    }
}
