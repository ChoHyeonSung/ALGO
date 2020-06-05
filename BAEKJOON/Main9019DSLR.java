package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main9019DSLR {
	static boolean[] visit;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int A,B;
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			visit = new boolean[10000];
			bfs(A,B);
		}
		
	}
	static void bfs(int A,int B) {
		Queue<State> q = new LinkedList<>();
		q.add(new State(A,""));
		visit[A]=true;
		while(!q.isEmpty()) {
			State st = q.poll();
			if(st.n == B) {
				System.out.println(st.s);
				break;
			}
			int D = (st.n*2)%10000;
			int S = (st.n == 0) ? 9999 : st.n-1;
			int L = (st.n%1000)*10 +st.n/1000;
			int R = (st.n%10)*1000 + st.n/10;
			
			if(!visit[D]) {
				q.add(new State(D,st.s+"D"));
				visit[D]=true;
			}
			if(!visit[S]) {
				q.add(new State(S,st.s+"S"));
				visit[S]=true;
			}
			if(!visit[L]) {
				q.add(new State(L,st.s+"L"));
				visit[L]=true;
			}
			if(!visit[R]) {
				q.add(new State(R,st.s+"R"));
				visit[R]=true;
			}
		}
	}
	static class State{
		int n;
		String s;
		public State(int n,String s){
			this.n = n;
			this.s = s;
		}
	}
}
