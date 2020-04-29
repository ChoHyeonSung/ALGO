package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main3187양치기꿍DFS {
	static int R,C,v,k,ans_v,ans_k;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static ArrayList<Point> start = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// Init && Input
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ans_k=ans_v=v=k=0;
		map = new char[R][C];
		visit = new boolean[R][C];
		// . : point , # : fencd , v : wolf , k : sheep
		for(int i=0;i<R;i++) {
			map[i]=br.readLine().toCharArray();
			for(int j=0;j<C;j++) {
				// Check all sheep and wolf coordinates
				if(map[i][j]=='v' || map[i][j]=='k') start.add(new Point(i,j));
			}
		}
		
		for(Point p:start) {
			if(visit[p.x][p.y]) continue;
			// Compare number of sheep&wolf in fence
			dfs(p.x,p.y);
			if(v>=k) ans_v+=v;
			else ans_k+=k;
			v=k=0;
		}
		System.out.println(ans_k+" "+ans_v);
	}
	static void dfs(int x,int y) {
		visit[x][y]=true;
		if(map[x][y]=='v') v++;
		else if(map[x][y]=='k') k++;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			// Check range, fence, visit
			if(nx<0||ny<0||nx>=R||ny>=C) continue;
			if(map[nx][ny]=='#' || visit[nx][ny]) continue;
			visit[nx][ny]=true;
			dfs(nx,ny);
		}
	}
	static class Point{
		int x,y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
