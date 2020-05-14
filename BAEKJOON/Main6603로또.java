package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6603로또 {
	static int[] num ;
	static boolean[] visit;
	static int len;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] str = br.readLine().split(" ");
			len = Integer.parseInt(str[0]);
			if(len==0) break;
			num = new int[len];
			visit = new boolean[len];
			for(int i=0;i<len;i++) num[i]=Integer.parseInt(str[i+1]);
			dfs(0,0);
			System.out.println();
		}

	}
	static void dfs(int idx,int cnt) {
		if(cnt==6) {
			for(int i=0;i<len;i++) {
				if(visit[i]) System.out.print(num[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=idx;i<len;i++) {
			visit[i]=true;
			dfs(i+1,cnt+1);
			visit[i]=false;
		}
	}

}
