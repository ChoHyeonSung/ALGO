package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1261¾Ë°í½ºÆÌBFS {
	static int N,M,ans;
	static PriorityQueue<Point> pq;
	static int[][] map;
	static int[][] dist_map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans=Integer.MAX_VALUE;
		map= new int[N][M];
		dist_map= new int[N][M];
		pq= new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			String[] temp = br.readLine().split("");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(temp[j]);
				dist_map[i][j]=Integer.MAX_VALUE;
			}
		}
		bfs();
		System.out.println(ans);
	
	}
	
	static void bfs() {
		pq.add(new Point(0,0,0));
		dist_map[0][0]=0;
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			
			if(p.x == N-1 && p.y == M-1) {
				ans = p.cnt;
				return;
			}
			
			for(int i=0;i<4;i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
				if(dist_map[nx][ny]<=dist_map[p.x][p.y]+map[nx][ny]) continue;
				dist_map[nx][ny]=dist_map[p.x][p.y]+map[nx][ny];
				pq.add(new Point(nx,ny,dist_map[nx][ny]));
			}
		}
		
	}
	static class Point implements Comparable<Point>{
		int x,y,cnt;
		Point(int x,int y,int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Point o) {
			return this.cnt<o.cnt ? -1:1;
		}
	}
}
