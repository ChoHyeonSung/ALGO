package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11724연결요소의개수 {
	static int N,M;
	static boolean[][] graph;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new boolean[N][N];
		visit = new boolean[N];
		int u,v;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken())-1;
			v = Integer.parseInt(st.nextToken())-1;
			graph[u][v]=graph[v][u]=true;
		}
		int count=0;
		for(int i=0;i<N;i++) {
			if(visit[i]) continue;
			dfs(i);
			count++;
		}
		System.out.println(count);
	}
	static void dfs(int idx) {
		if(visit[idx]) return;
		for(int i=0;i<N;i++) {
			if(idx == i) continue;
			if(graph[idx][i]) {
				visit[idx] = true;
				dfs(i);
			}
		}
	}
}
