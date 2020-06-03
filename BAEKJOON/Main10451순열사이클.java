package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10451순열사이클 {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int[] perm = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=n;i++) perm[i] = Integer.parseInt(st.nextToken());
			int count=0;
			for(int i=1;i<=n;i++) {
				if(perm[i]==0) continue;
				
				int cnt=1;
				int idx = perm[i];
				boolean[] visit = new boolean[n+1];
				while(true) {
					if(cnt>n || visit[idx] || idx==0 || perm[idx]==0) break;
					if(i==idx) {
						count++;
						for(int j=1;j<=n;j++) {
							if(visit[j]) {
								perm[j]=0;
							}
						}
						break;
					}
					visit[idx]=true;
					idx=perm[idx];
					cnt++;
				}
			}
			System.out.println(count);
		}

	}
}
