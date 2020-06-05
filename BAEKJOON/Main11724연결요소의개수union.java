package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11724연결요소의개수union {
	static int N,M;
	static int[] parent;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N];
		for(int i=0;i<N;i++) parent[i]=i;
		int u,v,cnt=0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken())-1;
			v = Integer.parseInt(st.nextToken())-1;
			if(union(v,u)) {
				System.out.println(u+" "+v); 
				cnt++;
			}
		}
		System.out.println(cnt);
		for(int i=0;i<N;i++) System.out.print(parent[i]+" ");
	}
	static int find(int u) {
		if(u == parent[u]) return u;
		else return parent[u] = find(parent[u]);
	}
	static boolean union(int u,int v) {
		u = find(u);
		v = find(v);
		if(u == v) return false;
		
		parent[v]=u;
		return true;
		
	}
	
}
