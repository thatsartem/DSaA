import java.util.Arrays;
import java.util.Scanner;

public class Substring {

    public static void main(String[] args) {
        System.out.println("print string");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("print substring");
        String sub = scanner.nextLine();
        System.out.println(findStringKMP(str, sub));
        System.out.println(findStringBM(str, sub));
    }

    public static int findStringKMP(String str, String sub) {
        long t1 = System.nanoTime();
        char[] S = str.toCharArray();
        char[] T = sub.toCharArray();
        int[] prefix = prefixFunc(sub);
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (S[i] == T[index]) {
                index++;
            } else {
                if (index != 0)
                    index = prefix[index - 1];
            }
            if (index == sub.length()) {
                long t2 = System.nanoTime();
                System.out.println("KMP: "+ (t2-t1));
                return i - index + 1;
            }
        }
        long t2 = System.nanoTime();
        System.out.println("KMP: "+ (t2-t1));
        return -1;

    }



    public static int findStringBM(String str, String sub) {
        long t1 = System.nanoTime();
        char[] S = str.toCharArray();
        char[] T = sub.toCharArray();
        int[] basis = basisFunc(sub);
        int index = basis.length-1;
        int i = sub.length()-1;
        while (i < str.length()){
            if(S[i]==T[index]){
                int tmp = index;
                for(int j = i;j>=i-tmp;j--){
                    if(S[j]==T[index]){
                        index--;
                    }else{
                        i+=basis[sub.indexOf(S[j])]-1;
                        break;
                    }
                    if((index==0)){
                        if((S[j-1]==T[0])){
                            long t2 = System.nanoTime();
                            System.out.println("BM: "+ (t2-t1));
                            return j-1;
                        }else{
                            if(sub.indexOf(S[i])==-1) {
                                i+=sub.length();
                                break;
                            }else {
                                i += basis[sub.indexOf(S[i])];
                                break;
                            }
                        }
                    }
                }
                index = basis.length-1;
            }else{
                if(sub.indexOf(S[i])==-1) {
                    i+=sub.length();
                }else {
                    i += basis[sub.indexOf(S[i])];
                }
            }
        }
        long t2 = System.nanoTime();
        System.out.println("BM: "+ (t2-t1));
        return -1;
    }

    public static int[] basisFunc(String sub) {
        int[] result = new int[sub.length()];
        int tmp = 1;
        result[sub.length() - 2] = tmp;
        for (int i = sub.length() - 3; i > -1; i--) {
            for (int j = sub.length() - 2; j > i; j--) {
                if (sub.charAt(i) == sub.charAt(j)) {
                    result[i] = result[j];
                    break;
                }
            }
            if (result[i] ==0) result[i] = ++tmp;
            }
        int ind = sub.length()-1;
        for (int j = 0; j < sub.length()-1; j++) {
            if(sub.charAt(ind)==sub.charAt(j)){
                result[ind]=result[j];
            }
        }
        if(result[ind]==0) result[ind]=sub.length();
        return result;
    }




    public static int[] prefixFunc(String sub) {
        int len = sub.length();
        int[] result = new int[len];
        String str = "" + sub.charAt(0);
        String prefix = "";
        String suffix = "";
        int maxl = 0;
        result[0] = 0;
        for (int k = 1; k < len; k++) {
            str += sub.charAt(k);
            for (int i = 0; i < str.length() -1; i++) {
                prefix += str.charAt(i);
                suffix = str.charAt(str.length() - 1 - i) + suffix;
                if (suffix.equals(prefix)) {
                    maxl = prefix.length();
                } else break;
            }
            result[k] = maxl;
            maxl = 0;
            suffix = "";
            prefix = "";
        }
        return result;
    }

}
