package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1697숨바꼭질 {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		System.out.println(bfs(N,K));
	}
	static int bfs(int N,int K) {
		int[] visit = new int[100001];
		int[] move = new int[3];
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		visit[N]=1;
		
		int next;
		while(!q.isEmpty()) {
			next = q.poll();
			move[0] = next-1;
			move[1] = next+1;
			move[2] = next*2;
			
			for(int i=0;i<3;i++) {
				if(move[i]<0 || move[i]>100000) continue;
				if(visit[move[i]]!=0) continue;
				q.add(move[i]);
				visit[move[i]]=visit[next]+1;
			}
		}
		return visit[K]-1;
	}
}
