import java.io.*;
import java.util.*;

public class Notebook {
    private Map<String, ArrayList<String>> map = new HashMap<>();
    private ArrayList<String> names = new ArrayList<>();
    public Notebook() {}

    public synchronized void add(String name, String number) {
        if(name != null || number != null) {
            if(!name.equals("") && !number.equals("")) {
                if (map.get(name) != null) {
                    for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
                        if (entry.getKey().equals(name)) {
                            entry.getValue().add(number);
                            break;
                        }
                    }
                } else {
                    map.put(name, new ArrayList<>(Collections.singleton(number)));
                    names.add(name);
                }
                try {
                    addInFile();
                }
                catch (IOException r){
                    System.out.println("error");
                }
            }
        }
    }

    public synchronized StringBuffer getNamesStrings() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            String name = entry.getKey() + " " + entry.getValue();
            stringBuffer.append("<p>").append(name).append("</p>");
        }
        return stringBuffer;
    }

    public synchronized StringBuffer sort() {
        StringBuffer stringBuffer = new StringBuffer();
        Collections.sort(names);
        for(int i = 0; i < names.size(); i++) {
            String username = names.get(i);
            String number = map.get(username).toString();
            stringBuffer.append("<p>").append(username).append(" ").append(number).append("</p>");
        }
        return stringBuffer;
    }

    public synchronized void reset() throws IOException {
        map.clear();
        names.clear();
        File file = new File("/home/kenan/JavaProjects/servlet/notebook.txt");
        FileWriter fw = new FileWriter(file);
        fw.write("");
        fw.flush();
        fw.close();
    }

    public synchronized void addInFile() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            String name = entry.getKey() + " " + entry.getValue();
//            System.out.println(name);
            stringBuilder.append(name).append("\n");
        }
        for(int i = 0; i < stringBuilder.length(); i++)
        {
            if(stringBuilder.charAt(i) == ']' || stringBuilder.charAt(i) == '[' || stringBuilder.charAt(i) == ','){
                stringBuilder.deleteCharAt(i);
            }
        }
        File file = new File("/home/kenan/JavaProjects/servlet/notebook.txt");
        FileWriter fw = new FileWriter(file);
        fw.write(String.valueOf(stringBuilder));
        fw.flush();
        fw.close();
    }

    public synchronized void file(){
        try {
            File file = new File("/home/kenan/JavaProjects/servlet/notebook.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String read;
            StringTokenizer stringTokenizer;
            String name = null;
            String number = null;
            while((read = br.readLine()) != null) {
                stringTokenizer = new StringTokenizer(read, " ");
                for (int i = 0; stringTokenizer.hasMoreTokens() ; i++) {
                    if(i == 0) {
                        name = stringTokenizer.nextToken();
                    }
                    number = stringTokenizer.nextToken();
                    if (map.get(name) != null && number != null) {
                        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
                            if(entry.getKey().equals(name)) {
                                entry.getValue().add(number);
                                break;
                            }
                        }
                    }
                    else {
                        map.put(name, new ArrayList<>(Collections.singleton(number)));
                        names.add(name);
                    }
                }
            }
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
}