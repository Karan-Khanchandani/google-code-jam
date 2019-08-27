package standard_codes;

public class KMP {

    private static int[] kmpProcess(String pattern){
        int n = pattern.length();
        int[] b = new int[n];
        b[0] = -1;
        int i = 0, j = -1;
        while(i < n){
            while(j >= 0 && pattern.charAt(i) != pattern.charAt(j)) j = b[j];
            i++; j++;
            b[i] = j;
        }
        for(int k : b){
            System.out.print(k + " ");
        }
        return b;
    }

    private static int kmpSearch(String text, String pattern, int[] backTable){
        int m = pattern.length(), n = text.length();
        int i = 0, j = 0;
        while(i < n){
            while(j >= 0 && text.charAt(i) != pattern.charAt(j)) j = backTable[j];
            i++; j++;
            if(j == m){
                return i - j;
            }

        }
        return  -1;
    }

    public static void main(String[] args) {
        kmpProcess("ABABA");
    }
}
