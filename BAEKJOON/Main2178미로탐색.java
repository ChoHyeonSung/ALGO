package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178미로탐색 {
	static int N,M,ans;
	static char[][] map;
	static int[][] dist;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		dist = new int[N][M];
		for(int i=0;i<N;i++) {
			map[i]=br.readLine().toCharArray();
			for(int j=0;j<M;j++) dist[i][j]=10001;
		}
		ans = Integer.MAX_VALUE;
		bfs();
		System.out.println(ans);
	}
	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0,1));
		dist[0][0]=1;
		while(!q.isEmpty()) {
			Point cur = q.poll();
			if(cur.x == N-1 && cur.y ==M-1) {
				ans = ans>cur.c ? cur.c : ans;
			}
			for(int i=0;i<4;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				if(map[nx][ny]=='0') continue;
				if(dist[nx][ny]<=cur.c+1) continue;
				dist[nx][ny]=cur.c+1;
				q.add(new Point(nx,ny,cur.c+1));
			}
		}
	}
	static class Point{
		int x,y,c;
		Point(int x,int y,int c){
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
}
