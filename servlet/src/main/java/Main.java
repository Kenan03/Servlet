//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args) {
//        try {
//            File file = new File("/home/kenan/JavaProjects/servlet/notebook.txt");
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            String read;
//            StringTokenizer stringTokenizer;
//            String name;
//            String number;
//            while((read = br.readLine()) != null) {
//                stringTokenizer = new StringTokenizer(read, " ");
//                for (int i = 0; stringTokenizer.hasMoreTokens(); i++) {
//                    if(i == 0) {
//                        name = stringTokenizer.nextToken();
//                    }
//                    else {
//                        number = stringTokenizer.nextToken();
//                    }
//                    add(name, number);
//                }
//            }
//            while (stringTokenizer.hasMoreTokens()) {
//                if(){}
//                // Выводим лексемы в консоль
//                System.out.println(stringTokenizer.nextToken());
//            }
//            //            String name;
////            String number;
////            int indexStart = 0;
////            int indexEnd;
////            for(int i = 0; i < stringBuilder.length(); i++)
////            {
////                String t = String.valueOf(stringBuilder.charAt(i));
////                if(t.equals(" ")) {
////                    indexEnd = stringBuilder.charAt(i);
////                    name = stringBuilder.substring(indexStart, indexEnd);
////                }
////                else {
////                    name.append(t);
////
////                }
////            }
//        }
//        catch (IOException e)
//        {
//            System.out.println(e);
//        }
//    }
//}
