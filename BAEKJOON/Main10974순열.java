package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10974순열 {
	static int n;
	static boolean[] visit;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visit = new boolean[n];
		dfs(0,"");
	}
	static void dfs(int cnt,String s) {
		if(cnt==n) {
			System.out.println(s);
			return;
		}
		for(int i=0;i<n;i++) {
			if(visit[i]) continue;
			visit[i]=true;
			dfs(cnt+1,s+(i+1)+" ");
			visit[i]=false;
		}
	}
}
