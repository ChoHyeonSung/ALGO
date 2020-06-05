package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17836공주님을구해라 {
	static int N,M,T,ans;
	static boolean flag=false;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		ans=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) map[i][j]=Integer.parseInt(st.nextToken());
			
		}
		bfs();
		System.out.println(ans<=T?ans:"Fail");
	}
	static void bfs() {
		Queue<Hero> q = new LinkedList<>();
		q.add(new Hero(0,0,0));
		visit[0][0]=true;
		while(!q.isEmpty()) {
			Hero h = q.poll();
			if(h.x == N-1 && h.y == M-1) {
				ans=ans>h.c?h.c:ans;
				return;
			}
			for(int i=0;i<4;i++) {
				int nx = h.x + dx[i];
				int ny = h.y + dy[i];
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				if(map[nx][ny]==1 || visit[nx][ny]) continue;
				visit[nx][ny] = true;
				q.add(new Hero(nx,ny,h.c+1));
				if(map[nx][ny]==2) ans = (N - nx) + (M - ny) + h.c - 1;
			}
		}
		
	}
	static class Hero{
		int x,y,c;
		Hero(int x,int y,int c){
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
}
