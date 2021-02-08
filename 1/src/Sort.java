import java.util.Random;

public class Sort {


    public static int[][] create(int m,int n,int minl,int maxl){
        final Random random = new Random();

        int[][] a = new int[m][n];

        for (int i = 0;i<a.length;i++){
            for (int j = 0;j<a[0].length; j++){
                a[i][j]= random.nextInt(maxl+Math.abs(minl))+minl;
            }
        }
        return a;
    }

    public static void main(String[] args) {
       var c = create(6,6,-250,1000+12);
       matout(c);
        System.out.println();
        System.out.println();
       matout(sortvibor(c));
        System.out.println();
        System.out.println();
        matout(sortinsert(c));
        System.out.println();
        System.out.println();
        matout(bubblesort(c));
        System.out.println();
        System.out.println();
        matout(Shellsort(c));
        System.out.println();
        System.out.println();



    }


    public static void matout(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(" " + a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] tom(int[][] a){
        int ch = 0;
        int[] b = new int[a.length*a[0].length];

        for (int i = 0;i<a.length;i++){
            for (int j = 0;j<a[0].length; j++){
                b[ch]=a[i][j];
                ch++;
            }
        }
        return b;
    }


    public static int[][] sortvibor (int[][] a){
        int[] b = tom(a);
        int ch = 0;





        int min = Integer.MAX_VALUE;
        int k = 0;
        int ind = 0;


        for (int i = 0;i<b.length;i++){
            for (int j = i;j<b.length; j++){
                if (min>b[j]) {min=b[j];ind = j;}
            }
            k=b[i];b[i]=min; b[ind] = k;
            min = Integer.MAX_VALUE;
        }


        ch = 0;
        int[][] d=a;

        for (int i = 0;i<d.length;i++){
            for (int j = 0;j<d[0].length; j++){
                d[i][j]=b[ch];
                ch++;
            }

        }
        return d;
    }

    public static int[][] sortinsert(int[][] a){
        int k;
        int[] b=tom(a);
        for (int i = 1; i < b.length; i++) {
            k=b[i];

            for (int j = i-1; j >=0; j--) {
                if (k<b[j]) {
                    b[j]=b[j+1];
                }
            }
        }
        int ch = 0;
        int[][] d=a;

        for (int i = 0;i<d.length;i++){
            for (int j = 0;j<d[0].length; j++){
                d[i][j]=b[ch];
                ch++;
            }

        }
        return d;

    }
    public static int[][] bubblesort(int[][] a){
        int[] b = tom(a);
        int k=0;
        for (int i= 0;i<b.length;i++){
            for (int j = 1; j < b.length-i; j++) {
                if(b[j]<b[j-1]){k=b[j];b[j]=b[j+1];b[j+1]=k;}
            }
        }
        int  ch = 0;
        int[][] d=a;

        for (int i = 0;i<d.length;i++){
            for (int j = 0;j<d[0].length; j++){
                d[i][j]=b[ch];
                ch++;
            }

        }
        return d;
    }

    public static int[][] Shellsort(int[][] a){
        int[] b = tom(a);
        int i=b.length;
        int k;
        while (i>0){

            for (int j = i; j < b.length; j++) {
                if (b[j]<b[j-i]){
                    k=b[j];
                    b[j]=b[j+i];
                    b[j+1]=b[j];
                }
            }
                
            i/=2;
        }
        int  ch = 0;
        int[][] d=a;

        for ( i = 0;i<d.length;i++){
            for (int j = 0;j<d[0].length; j++){
                d[i][j]=b[ch];
                ch++;
            }

        }
        return d;
    }

    public static int[][] Tournamentsort(int[][] a){

        return a;
    }

}
