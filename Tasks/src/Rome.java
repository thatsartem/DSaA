import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rome {
    public static void main(String[] args) {
        System.out.println(HashTag("мтуси туси жить класссно"));

        System.out.println(Arrays.toString(dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"})));
        System.out.println(nextInt(1234567890));
    }


    public static String HashTag(String str){
        if (str.length()>140) return "false";
        String[] text = str.split(" ");
        String result = "#";
        for (String item: text) {
            result+= Character.toUpperCase(item.charAt(0))+item.substring(1,item.length());
        }
        result = result.trim();
        return result;
    }



    public static int longestSlideDown(int[][] pyramid) {
        int max = -1000000000;
        int sum = 0;
        for(int i=0;i<pyramid.length;i++){
            for (int j = 0; j < pyramid[i].length; j++) {
                if (pyramid[i][j]>max) max = pyramid[i][j];
            }
            sum+=max;
            max = -1000000000;
        }
        return sum;
    }

    public static String[] dirReduc(String[] str) {
        List<String> arr = new ArrayList<>(Arrays.asList(str));
        while (true) {
            int forcheck = 0;
            if (arr.size()==0) return (String[]) arr.toArray(new String[0]);
            if (arr.size()==1) return (String[]) arr.toArray(new String[0]);
            int size = arr.size();
            for (int i = 0; i < size - 1; i++) {
                if ((arr.get(i).equals("NORTH") && (arr.get(i + 1).equals("SOUTH"))) || (arr.get(i).equals("WEST") && (arr.get(i + 1).equals("EAST"))) || (arr.get(i).equals("SOUTH") && (arr.get(i + 1).equals("NORTH"))) || (arr.get(i).equals("EAST") && (arr.get(i + 1).equals("WEST")))) {

                    arr.remove(i+1);
                    arr.remove(i);
                    forcheck +=1;
                    break;
                }

            }
            if(forcheck==0) return (String[]) arr.toArray(new String[0]);
        }
    }

    public static int nextInt(long num) {
        String str = Long.toString(num);
        char[] chars = str.toCharArray();
        int counter = 0;
        for (int i = 0; i < chars.length-1; i++) {
            if(chars[i]<chars[i+1]) counter++;
        }
        if(counter == 0) return -1;

        for (int i = str.length()-1; i > 0 ; i--) {
            for (int j = i-1;j>=0;j--){
                if ((j==0)){
                    char min = '9';
                    int minind = -1;
                    for(int x = 1;x<chars.length;x++){
                        if((chars[0]<chars[x])&&(chars[x]<=min)){
                            min = chars[x]; minind = x;
                        }
                    }
                    char tmp = chars[0];
                    chars[0]=min;
                    chars[minind]=tmp;
                    char[] result = Arrays.copyOfRange(chars,1,chars.length);
                    Arrays.sort(result);
                    str = "";
                    str += chars[0];
                    for (char item: result) {
                        str+=item;
                    }
                    return  Integer.parseInt(str);
                }
                if(chars[i]>chars[j]){

                    char k = chars[i];
                    chars[i]=chars[j];
                    chars[j]=k;
                    for(int x = i;i<str.length()-1;i++){
                        if (chars[i]>chars[i+1]){
                            char tmp = chars[i];
                            chars[i]=chars[i+1];
                            chars[i+1]=tmp;
                        }else break;
                    }
                    str = "";
                    for (char item: chars) {
                        str+=item;
                    }
                    return  Integer.parseInt(str);
                }
            }
        }
        return -1;
    }



}

