
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
    private HashMap<String, ArrayList<String>> slangList;
    private ArrayList<String> history;

    public SlangWordModel() {
        this.slangList = null;
        this.history = null;
    }

    public SlangWordModel(HashMap<String, ArrayList<String>> slangList, ArrayList<String> history) {
        this.slangList = slangList;
        this.history = history;
    }

    public HashMap<String, ArrayList<String>> getSlangList() {
        return this.slangList;
    }

    public ArrayList<String> getHistory() {
        return this.history;
    }

    public void setSlangList(HashMap<String, ArrayList<String>> slangList) {
        this.slangList = slangList;
    }

    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }

    public String toStringDef(ArrayList<String> l){
        String temp="";
        if(l.size()>1){
            temp=l.get(0);
            for(int i=1;i<l.size()-1;i++){
                temp=temp+"| "+l.get(i);
            }
            temp=temp+"| "+l.get(l.size()-1);
        }
        else temp=l.get(0);
        return temp;
    }

//    public String[] splitSlang(String slang){
//        String[] temp = slang.split(" ");
//        String key = temp[0];
//        String value = temp[1];
//        return temp;
//    }

    public String[] splitSlangV2(String slang){
        String[] temp = slang.split("` ");
        String key = temp[0];
        String value = temp[1];
        return temp;
    }

    public HashMap<String, ArrayList<String>> readFile(String file){
        HashMap<String,ArrayList<String>> newSlangList = new HashMap<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            br.readLine();
            String line;
            while ((line = br.readLine())!= null) {
                if(!line.contains("`")){
                    continue;
                }
                String[] word = line.split("`");
                ArrayList<String> def = new ArrayList<>();
                if(word.length>0){
                    int index = word[1].indexOf("| ");
                    if(index==-1){
                        def.add(word[1]);
                    }
                    else {
                        String[] temp = word[1].split("\\| ");
                        for(String i: temp){
                            def.add(i);
                        }
                    }
                }
                if (word.length == 2)
                    newSlangList.put(word[0], def); // Only add lines in correct format
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.print(newSlangList.size());
//        for (String i : newSlangList.keySet()) {
//            System.out.println("key: " + i + " value: " + this.toStringDef(newSlangList.get(i)));
//        }
        return newSlangList;
    }

//    write FIle
    public void writeFile(HashMap<String,ArrayList<String>> slangList){
        PrintWriter p = null;
        try {
            p = new PrintWriter("currentSlang.txt","UTF-8");
            p.println("Slag`Meaning");
            for (String i : slangList.keySet()) {
                p.print(i+"`");
                p.print(this.toStringDef(slangList.get(i)));
//                System.out.println(this.toStringDef(slangList.get(i)));
                p.println();
            }
            p.flush();
            p.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<String> readFileHistory(String file){
        ArrayList<String> newHistory = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String str;
//            br.readLine();
            String line;
            while ((line = br.readLine())!= null) {
                newHistory.add(line);
//                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return newHistory;
    }
    public void writeFileHistory(ArrayList<String>history){
        PrintWriter p = null;
        try {
            p = new PrintWriter("history.txt","UTF-8");
            for (String i : history) {
                p.println(i);
            }
            p.flush();
            p.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public String randomSlangWord(HashMap<String, ArrayList<String>> l){
        String slangRandom;
        long sizeSlangList = l.size();
        Random random = new Random();
        String randomKey = l.keySet().toArray()[
                random.nextInt(l.keySet().toArray().length)].toString();
        slangRandom = randomKey+ "` "+this.toStringDef(l.get(randomKey));
        return slangRandom;
    }

    public String findSlangWord(HashMap<String, ArrayList<String>> l, String slang){
        String s="";
        if(l.containsKey(slang)){
            s = slang+ "` "+ this.toStringDef(l.get(slang));
        }
        ArrayList<String> his = readFileHistory("history.txt");
        if(history!=null){
            his = getHistory();
            his.add(slang);
            setHistory(his);
        }
        else {
            his.add(slang);
            setHistory(his);
        }
        writeFileHistory(history);
        return s;
    }

    public String findSlangWordEdit(HashMap<String, ArrayList<String>> l, String slang){
        String s="";
        if(l.containsKey(slang)){
            s = slang+ "` "+ this.toStringDef(l.get(slang));
        }
        return s;
    }
    public ArrayList<String> findDefinition(HashMap<String, ArrayList<String>> l, String slang){
        ArrayList<String>arrSlang = new ArrayList<>();
        for (String i : l.keySet()) {
            if(this.toStringDef(l.get(i)).contains(slang)){
                arrSlang.add(i+"` "+this.toStringDef(l.get(i)));
            }
        }
        return arrSlang;
    }

    public void addSlangWord(HashMap<String, ArrayList<String>> l, String slang, String definition, int check){
        //if check == 1: overwrite
        //else if check == 2: create new slang word
        if(l.containsKey(slang)){
            if(check ==1){
                System.out.println("check =1 ");
                ArrayList<String> defList = new ArrayList<>();
                defList.add(definition);
                l.put(slang,defList);
            }
            else if(check==2){
                System.out.println("check = 2 ");
                ArrayList<String> defList = l.get(slang);
                defList.add(definition);
                l.put(slang, defList);
            }
        }
        else {
            ArrayList<String> defList = new ArrayList<>();
            defList.add(definition);
            l.put(slang,defList);
            System.out.println("OK");
        }
        writeFile(l);
    }

    public void editSlang(HashMap<String, ArrayList<String>> l, String key, String valueUpdate){
        if(l.containsKey(key)){
            ArrayList<String> defList = new ArrayList<>();
            defList.add(valueUpdate);
            l.put(key,defList);
//            return 1; //success
        }
//        else return 0;//fail
        writeFile(l);
    }
    public void deleteSlang(HashMap<String, ArrayList<String>> l, String key){
        if(l.containsKey(key)){
            l.remove(key);
        }
        writeFile(l);
    }
    public void resetSlang(){
        HashMap<String, ArrayList<String>>l = this.readFile("slang.txt");
        this.setSlangList(l);
        writeFile(l);
    }
    public void clearHistory(){
        ArrayList<String> newHistory = new ArrayList<>();
        writeFileHistory(newHistory);
    }

    //9. do vui slang word
    public void slangQuiz(HashMap<String, ArrayList<String>> l, ArrayList<String> answersRes, ArrayList<String> result, int check){
        ArrayList<String> newArr = new ArrayList<>();
        ArrayList<String> answers = new ArrayList<>();
        answers.add("0");
        answers.add("0");
        answers.add("0");
        answers.add("0");
        String[] temp = null;
        String key=null;

        String randomSlang = randomSlangWord(l);
        temp = splitSlangV2(randomSlang);
        if(check==1){
            newArr.add(temp[0]);
            newArr.add(temp[1]);
        }
        else if(check==2){
            newArr.add(temp[1]);
            newArr.add(temp[0]);
        }


        ArrayList<String> abc = new ArrayList<>();
        abc.add("0");
        abc.add("0");
        abc.add("0");
        l.remove(temp[0]);

        abc.set(0,randomSlangWord(l));
        temp = splitSlangV2(abc.get(0));
        key = temp[0];
        if(check==1){
            abc.set(0,temp[1]);
        }
        else {
            abc.set(0,temp[0]);
        }
        l.remove(key);
        temp=null;

        abc.set(1,randomSlangWord(l));
        temp = splitSlangV2(abc.get(1));
        key = temp[0];
        if(check==1){
            abc.set(1,temp[1]);
        }
        else {
            abc.set(1,temp[0]);
        }
        l.remove(key);
        temp=null;

        abc.set(2,randomSlangWord(l));
        temp = splitSlangV2(abc.get(2));
        if(check==1){
            abc.set(2,temp[1]);
        }
        else {
            abc.set(2,temp[0]);
        }

        Random random = new Random();
        int res = random.nextInt(0, 4);

        answers.set(res,newArr.get(1));
        answersRes.add(answers.get(res));

        int i=0,i2=0;
        while(i<4 && answersRes.size() <4){
            if(i==res){
                i=i+1;
            }
            else {
                answersRes.add(abc.get(i2));
                i++;i2++;
            }

        }
        for(String str: newArr){
            result.add(str);
        }
    }

}
