import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Course {

    public static int[][] createmat(int m, int n, int minl, int maxl){
        final Random random = new Random();
        int[][] a = new int[m][n];

        for (int i = 0;i<a.length;i++){
            for (int j = 0;j<a[0].length; j++){
                a[i][j]= random.nextInt(maxl+Math.abs(minl))+minl;
            }
        }
        return a;
    }

    public static int[] create(int n, int minl, int maxl){
        final Random random = new Random();

        int[] a = new int[n];
        for (int i = 0;i<a.length;i++){
            a[i]= random.nextInt(maxl+Math.abs(minl))+minl;
        }
        return a;
    }

    public static int[][] diagonal(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[1].length; j++) {
                sort(a,i,j);
            }

        }
        return a;
    }

    public static void sort(int [][] a, int i, int j){


        if (i==0 || j==0){}else{
            if(a[i][j]<a[i-1][j-1]){
                int k = a[i][j];
                a[i][j]=a[i-1][j-1];
                a[i-1][j-1]=k;
            }
            sort(a,i-1,j-1);
        }
    }

    public static String maxdigit(int[] mas){

        String str = "";
        int k=0;
        for (int i= 0;i<mas.length;i++){
            for (int j = 1; j < mas.length-i; j++) {

                String XY = Integer.toString(mas[j-1])+Integer.toString(mas[j]);
                String YX = Integer.toString(mas[j])+Integer.toString(mas[j-1]);
                if (XY.compareTo(YX)<0) {
                    k=mas[j];mas[j]=mas[j-1];mas[j-1]=k;
                }
            }
        }

        for (int item:mas) {
            str+=Integer.toString(item);
        }
        return str;
    }

    public static int maxP(int[] mas){
        Arrays.sort(mas);
        int P = 0;
        for (int i = mas.length-1; i >=2 ; i--) {
            if(mas[i]<mas[i-1]+mas[i-2]){
                P=mas[i]+mas[i-1]+mas[i-2];
            }
        }
        return P;
    }

    public static int balloons(int [][] points){
        if (points.length == 0) return 0;
        Arrays.sort(points, (a,b) -> Integer.compare(a[1],b[1]));
        int result = 0;
        long end = Long.MIN_VALUE;
        for( int[] p: points){
            if( p[0]> end){
                end = p[1];
                result++;
            }
        }
        return result;
    }

    public static boolean stringBattle(String s1, String s2){
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (int i = 0; i<chars1.length;i++){
            for (int j = 0; j < chars2.length-1-i; j++){
                if(chars1[j]>chars1[j+1]){
                    char tmp = chars1[j];
                    chars1[j]= chars1[j+1];
                    chars1[j+1] = tmp;
                }

                if(chars2[j]>chars2[j+1]){
                    char tmp = chars2[j];
                    chars2[j]= chars2[j+1];
                    chars2[j+1] = tmp;
                }
            }
        }
        int counter1 = 0;
        int counter2 = 0;
        for(int i = 0; i< chars1.length; i++){
            if(chars1[i]>=chars2[i]) counter1++;
            if(chars1[i]<=chars2[i]) counter2++;
        }

        return  (Math.abs(counter1)==chars1.length)||(Math.abs(counter2)==chars2.length);

    }

    public static int coins(Integer[] piles){
        Arrays.sort(piles);
        List<Integer> list = new ArrayList<>(Arrays.asList(piles)) ;
        int max = 0;
        while (!list.isEmpty()){
            max+=list.get(list.size()-2);
            list.remove(list.size()-1);
            list.remove(list.size()-2);
            list.remove(0);
        }
        return max;
    }

    public static String longestPalindrome(String str){
        String sub = "";
        String result = "";
        for(int i = 0;i<str.length();i++){
            for (int j = i;j < str.length();j++){
                sub+=str.charAt(j);
                if(isPali(sub)&&(result.length()<sub.length())){
                    result = sub;
                }
            }
            sub = "";
        }
        return result;
    }

    public static boolean isPali(String str){
        String s2="";
        for(int i = str.length()-1;i>=0;i--){
            s2+=str.charAt(i);
        }
        return str.equals(s2);
    }

    public static int isConcat(String s){
        int count = 0;
        ArrayList<String> substrings = new ArrayList<>();
        String substring = "";
        for(int i = 0; i < s.length(); i++) {
            substring = "";
            for(int j = i; j < s.length(); j++) {
                substring += s.charAt(j);
                if(substring.length() % 2 == 0) {
                    if(!substrings.contains(substring) && substring.equals(substring.substring(0, substring.length()/2) + substring.substring(0, substring.length()/2))) {
                        substrings.add(substring);
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
