package model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.*;

/**
 *
 * @author Admin
 */
public class SlangWordModel {
    private HashMap<String, String> slangList;
    private ArrayList<String> history;

    public SlangWordModel() {
        this.slangList = null;
        this.history = null;
    }

    public SlangWordModel(HashMap<String, String> slangList, ArrayList<String> history) {
        this.slangList = slangList;
        this.history = history;
    }

    public HashMap<String, String> getSlangList() {
        return slangList;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public void setSlangList(HashMap<String, String> slangList) {
        this.slangList = slangList;
    }

    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }
    public HashMap<String, String> readFile(){
        HashMap<String,String> newSlangList = new HashMap<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("slang.txt"));
            String str;
            br.readLine();
            String line;
            while ((line = br.readLine())!= null) {
                String[] word = line.split("`");
                if (word.length == 2)
                    newSlangList.put(word[0], word[1]); // Only add lines in correct format
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.print(newSlangList.size());
//        for (String i : newSlangList.keySet()) {
//            System.out.println("key: " + i + " value: " + newSlangList.get(i));
//        }
        return newSlangList;
    }

//    write FIle
    public void writeFile(HashMap<String,String> slangList){
        PrintWriter p = null;
        try {
            p = new PrintWriter("currentSlang.txt","UTF-8");
            p.println("Slag`Meaning");
            for (String i : slangList.keySet()) {
                p.println(i+"`"+slangList.get(i));
            }
            p.flush();
            p.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public String randomSlangWord(HashMap<String, String> l){
        String slangRandom;
        long sizeSlangList = l.size();
        Random random = new Random();
        String randomKey = l.keySet().toArray()[
                random.nextInt(l.keySet().toArray().length)].toString();
        slangRandom = randomKey+ "`"+l.get(randomKey);
        return slangRandom;
    }

    public String findSlangWord(HashMap<String, String> l, String slang){
        String s = slang+ "`"+ l.get(slang);
        return s;
    }
    public ArrayList<String> findDefinition(HashMap<String, String> l, String slang){
        ArrayList<String>arrSlang = new ArrayList<>();
        for (String i : l.keySet()) {
            if(l.get(i).contains(slang)){
                arrSlang.add(i+"`"+l.get(i));
            }
        }
        return arrSlang;
    }

    public void addSlangWord(HashMap<String, String> l, String slang, String definition, int check){
        //if check == 1: overwrite
        //else if check == 2: create new slang word
        if(l.containsKey(slang)){
            if(check ==1){
                System.out.println("check =1 ");
                l.put(slang,definition);
            }
            else if(check==2){
                System.out.println("check =2 ");
                l.put(slang, l.get(slang) + "| " + definition);
            }
        }
        else {
            l.put(slang,definition);
        }
        writeFile(l);
    }

    public int editSlang(HashMap<String, String> l, String key, String valueUpdate){
        if(l.containsKey(key)){
            l.put(key,valueUpdate);
            return 1; //success
        }
        else return 0;//fail
    }
    public void deleteSlang(HashMap<String, String> l, String key){
        if(l.containsKey(key)){
            l.remove(key);
        }
    }
    //9. do vui slang word
    public void slangQuiz(HashMap<String, String> l){
        String randomSlang = randomSlangWord(l);
        System.out.println(randomSlang);
//        String result = l.get(randomSlang);
        String a="",b="",c="";
        if(!l.containsKey(randomSlang)){
            a = randomSlangWord(l);
            b = randomSlangWord(l);
            c = randomSlangWord(l);
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }


}
