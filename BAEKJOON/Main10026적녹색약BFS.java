package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main10026적녹색약BFS {
	static int N;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static Queue<Point> q = new LinkedList<>();
	static int cc=0;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map=new char[N][N];
		visit=new boolean[N][N];
		for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
		
		int normal,unnormal;
		normal = seperation();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]=='G') map[i][j]='R';
			}
		}
		visit=new boolean[N][N];
		unnormal = seperation();
		System.out.println(normal+" "+unnormal);
		System.out.println(cc);
	}
	static int seperation() {
		int count=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visit[i][j]) continue;
				count++;
				BFS(i,j,map[i][j]);
				
			}
		}
		return count;
	}
	static void BFS(int x,int y,char c) {	
		q.add(new Point(x,y));
		visit[x][y]=true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			cc++;
			System.out.println(p.x+ " "+p.y);
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx<0||ny<0||nx>=N||ny>=N) continue;
				if(map[nx][ny]==c && !visit[nx][ny]) {
					visit[nx][ny]=true;
					q.add(new Point(nx,ny));
				}
			}
		}
	}
	static class Point{
		int x,y;
		Point(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
}
