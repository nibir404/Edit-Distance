import java.util.Scanner;

public class EditDistance {
    public static int minDistance(String word1 , String word2){
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] DP = new int[len1+1][len2+1];
        for (int i = 0 ; i<len1 ; i++)
            DP[i][0] = i;

        for (int j = 0 ; j<len2 ; j++)
            DP[0][j] = j;

        for (int i = 0 ; i<len1 ;i++){
            char ch1 = word1.charAt(i);
            for (int j = 0 ; j<len2 ; j++){
                char ch2 = word2.charAt(j);

                if (ch1 == ch2){
                    DP[i+1][j+1] = DP[i][j];
                } else {
                    int replace = DP[i][j]+1;
                    int insert = DP[i][j+1]+1;
                    int delete = DP[i+1][j]+1;

                    int min = replace > insert ? insert : replace;
                    min = delete > min ? min : delete;
                    DP[i+1][j+1] = min;
                }
            }
        }
        return DP[len1][len2];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 , s2 ;
        System.out.println("Enter the first string : ");
        s1 = sc.nextLine();
        System.out.println("Enter the second string");
        s2 = sc.nextLine();

        int ans = minDistance(s1,s2);
        System.out.println("The minimum Edit Distance between \"" +s1+ "\" and \"" +s2+ "\" is "+ans);
    }
}
