//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String [] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-- > 0) {
			int N = sc.nextInt();
			Solution obj = new Solution();
			obj.toBinary(N);
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	void toBinary(int N) {
		//Write your code here
		List<Integer> ans = new ArrayList<>();
		while(N>0)
		{
		    ans.add(N%2);
		    N=N>>1;
		}
		for(int i=ans.size()-1;i>=0;i--)
		{
		    System.out.print(ans.get(i));
		}
	}
}