package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main10026적녹색약DFS {
	static int N;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Init input
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visit = new boolean[N][N];
		for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
		
		int normal,unnormal;
		normal = seperation();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]=='G') map[i][j]='R';
			}
		}
		visit = new boolean[N][N];
		unnormal = seperation();
		
		System.out.println(normal+" "+unnormal);

	}
	static int seperation() {
		int count=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visit[i][j]) continue;
				count++;
				DFS(i,j,map[i][j]);
				
			}
		}
		return count;
	}
	static void DFS(int x,int y,char c) {
		visit[x][y]=true;
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0||ny<0||nx>=N||ny>=N) continue;
			if(map[nx][ny]==c && !visit[nx][ny]) DFS(nx,ny,c);
		}
	}
}
