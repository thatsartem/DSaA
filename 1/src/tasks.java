import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.Character.toUpperCase;

public class tasks {

    public static void matout(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(" " + a[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
//        int[][] m = createmat(20000,20000,1,100);
//        System.out.println();
//        int[] mas = create(5,0,1000);
//        System.out.println(Arrays.toString(mas));
//        long t1= System.currentTimeMillis();
//        System.out.println(maxdigit(mas));
//        long t2= System.currentTimeMillis();
//        System.out.println("vremya: " + (t2-t1)+ "ms");
//        System.out.println(maxP(new int[]{5,3,991,9,90,611,6}));
        System.out.println((dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})));

    }
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

    public static int digroot(int p0, double percent, int aug, int p){
        double p1=p0;
        percent/=100;
        int i = 0;
        while(p1<p){
            p1= p1+p1*percent+aug;
            i++;
        }
        return i;
    }



    public static String[] uper(String str) {

        String[] token = new String[(str.replaceAll(" ", "")).length()];
        if(str.length()==0) return token;
        int ch = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            if(chars[i] == ' '){continue;}else{
                token[ch]="";
                chars[i] = Character.toUpperCase(chars[i]);
                }
            for (int j = 0; j < chars.length; j++) {
                token[ch]+=chars[j];
            }
            chars[i] = Character.toLowerCase(chars[i]);
            ch++;

        }
        return token;
    }
    public static int greedy(int[] dice){
        int[] ch = new int[7];
        int sum = 0;
        Arrays.fill(ch, 0);
        for( int item: dice) ch[item]++;
        sum += ch[1]/3*1000 + ch[5]/3*500 + ch[2]/3*200 + ch[3]/3*300 + ch[4]/3*400 + ch[6]/3*600;
        sum+=ch[1]%3*100 + ch[5]%3*50;
        return sum;
    }
    public static List<Integer> sqInRect(int lng, int wdth) {

        List<Integer> result = new ArrayList<Integer>();
        if (lng == wdth){return null;} else {
            while ((lng!=0)&&(wdth!=0)){

                if(lng>wdth){
                    result.add(wdth);
                    lng-=wdth;
                }else {
                    result.add(lng);
                    wdth-=lng;
                }
            }

        }
        return result;
}
    public static boolean validParentheses(String parens1)
    {
        String parens = parens1;
        parens = parens.replaceAll("[^()]","");
        System.out.println(parens);
        for(int i = 0; i < parens1.length()/2+1;i++) parens = parens.replace("()","");
        return  (parens.equals(""));
    }
    public static List<String> dirReduc(String[] arr) {
        // Your code here.
        List<String> ls = Arrays.asList(arr);
        for(int i = 1;i<ls.size();){
            if (((ls.get(i).equals("EAST"))&&(ls.get(i - 1).equals("WEST")))||((ls.get(i).equals("WEST"))&&(ls.get(i - 1).equals("EAST")))||((ls.get(i).equals("SOUTH"))&&(ls.get(i - 1).equals("NORTH")))||((ls.get(i).equals("NORTH"))&&(ls.get(i - 1).equals("SOUTH")))){
                ls.remove(i);
                ls.remove(i-1);
            }else{
                i++;
            }
        }
        return ls;
    }
}

