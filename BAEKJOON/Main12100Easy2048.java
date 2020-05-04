package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2048Easy {
	static int N,ans=0;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		game();
		System.out.println(ans);		
	}
	static void game() {
		for(int k=0;k<4;k++) {
			dfs(map,0,k);
		}
	}
	static void dfs(int[][] mm,int c,int d) {
		int[][] m = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++){
				m[i][j]=mm[i][j];
			}
		}
		if(d==0) right(m);
		else if(d==1) left(m);
		else if(d==2) down(m);
		else if(d==3) up(m);
		if(++c==5) {
			int max=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(max<m[i][j]) max=m[i][j];
				}
			}
			if(ans<max) {
				ans=max;
			}
			return;
		}
		
		dfs(m,c,0);
		dfs(m,c,1);
		dfs(m,c,2);
		dfs(m,c,3);
	}
	static void up(int[][] m) {
		Queue<Integer> q;
		for(int i=0;i<N;i++) {
			q = new LinkedList<>();
			for(int j=0;j<N;j++) {
				if(m[j][i]!=0) q.add(m[j][i]);
			}
			for(int j=0;j<N;) {
				if(q.size()>=2) {
					int a = q.poll();
					int b = q.peek();
					if(a==b) {
						m[j++][i]=a+b;
						q.poll();
					}else {
						m[j++][i]=a;
					}
				}
				else if(q.size()==1){
					m[j++][i]=q.poll();
				}
				else m[j++][i]=0;
			}
			
		}
	}
	static void down(int[][] m) {
		Queue<Integer> q;
		for(int i=0;i<N;i++) {
			q = new LinkedList<>();
			for(int j=N-1;j>=0;j--) {
				if(m[j][i]!=0) q.add(m[j][i]);
			}
			for(int j=N-1;j>=0;) {
				if(q.size()>=2) {
					int a = q.poll();
					int b = q.peek();
					if(a==b) {
						m[j--][i]=a+b;
						q.poll();
					}else {
						m[j--][i]=a;
					}
				}
				else if(q.size()==1){
					m[j--][i]=q.poll();
				}
				else m[j--][i]=0;
			}
			
		}
	}
	static void right(int[][] m) {
		Queue<Integer> q;
		for(int i=0;i<N;i++) {
			q = new LinkedList<>();
			for(int j=N-1;j>=0;j--) {
				if(m[i][j]!=0) q.add(m[i][j]);
			}
			for(int j=N-1;j>=0;) {
				if(q.size()>=2) {
					int a = q.poll();
					int b = q.peek();
					if(a==b) {
						m[i][j--]=a+b;
						q.poll();
					}else {
						m[i][j--]=a;
					}
				}
				else if(q.size()==1){
					m[i][j--]=q.poll();
				}
				else m[i][j--]=0;
			}
		}
	}
	static void left(int[][] m) {
		Queue<Integer> q;
		for(int i=0;i<N;i++) {
			q = new LinkedList<>();
			for(int j=0;j<N;j++) {
				if(m[i][j]!=0) q.add(m[i][j]);
			}
			for(int j=0;j<N;) {
				if(q.size()>=2) {
					int a = q.poll();
					int b = q.peek();
					if(a==b) {
						m[i][j++]=a+b;
						q.poll();
					}else {
						m[i][j++]=a;
					}
				}
				else if(q.size()==1){
					m[i][j++]=q.poll();
				}
				else m[i][j++]=0;
			}
		}
	}
	static void print(int[][] m) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
	}
}
