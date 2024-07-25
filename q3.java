// Online Java Compiler
// Use this editor to write, compile and run your Java code online
//Problem Statement
//Write a function to solve the 0/1 Knapsack problem using dynamic programming.
import java.util.*;
import java.lang.Math; 
public class Knap{
    public static int napsack(int [] wts , int [] vals ,int caps){
        
        int n = wts.length;
        int [][] dp = new int[n+1][caps +1];
        
        
        for (int i = 0;i<n;i++){
            for(int w = 0;w<=caps;w++){
                if(i == 0 || w == 0){
                    dp[i][w] = 0;
                } else if (wts[i-1] <=w){
                    dp[i][w] = Math.max(vals[i-1]+ dp[i-1][w-wts[i-1]] , dp[i-1][w]);
                } else{
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        
        return dp[n][caps];

    }
    
    public static void main (String [] args){
        int [] wts = {1, 2, 3};
        int [] vals = {10, 15, 40};
        int caps = 6;
        int maxVal = napsack(wts , vals , caps);
        System.out.println("Max value obtained : " + maxVal);
    }
}
