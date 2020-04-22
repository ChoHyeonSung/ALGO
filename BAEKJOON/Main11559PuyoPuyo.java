package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main11559PuyoPuyo {
	static char[][] map = new char[12][6];
	static boolean[][] visit;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static ArrayList<Point> al;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		for(int i=0;i<12;i++) map[i]=br.readLine().toCharArray();
		
		while(true) {
			setting();
			boolean boom = false;
			visit = new boolean[12][6];
			
			for(int i=11;i>=0;i--) {
				for(int j=0;j<6;j++) {
					if(map[i][j]=='.' || visit[i][j]) continue;
					al = new ArrayList<>();
					dfs(i,j,map[i][j]);
					if(al.size()>=4) {
						boom =true;
						for(Point p:al) map[p.x][p.y] = '.';
					}
				}
			}
			
			
			if(boom) ans++;
			else break;
		}
		
		System.out.println(ans);
	}
	static void setting() {
		for(int i=0;i<6;i++) {
			for(int j=10;j>=0;j--) {
				for(int k=11;k>j;k--) {
					if(map[j][i] !='.' && map[k][i]=='.') {
						map[k][i]=map[j][i];
						map[j][i]='.';
						break;
					}
				}
			}
		}

	}
	
	static void dfs(int x,int y,int color) {
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0||ny<0||nx>=12||ny>=6) continue;
			if(map[nx][ny]!=color || visit[nx][ny]) continue;
			al.add(new Point(nx,ny));
			visit[nx][ny]=true;
			dfs(nx,ny,color);
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
