package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3187양치기꿍BFS {
	static int R,C,wolf,sheep;
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
		// Init input
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		wolf=sheep=0;
		for(int i=0;i<R;i++) {
			map[i]=br.readLine().toCharArray();
			for(int j=0;j<C;j++) {
				if(map[i][j]=='v'||map[i][j]=='k') start.add(new Point(i,j));
			}
		}
		
		for(Point p:start) {
			if(visit[p.x][p.y]) continue;
			BFS(p.x,p.y);
		}
		System.out.println(sheep+" "+wolf);
	}
	static void BFS(int x, int y) {
		int v=0,k=0;
		visit[x][y]=true;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(map[p.x][p.y]=='v') v++;
			else if(map[p.x][p.y]=='k') k++;
			for(int i=0;i<4;i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(nx<0||nx>=R||ny<0||ny>=C) continue;
				if(visit[nx][ny]||map[nx][ny]=='#') continue;
				visit[nx][ny]=true;
				q.add(new Point(nx,ny));
			}
		}
		if(v>=k) wolf+=v;
		else sheep+=k;
	}
	static class Point{
		int x, y;
		Point(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
}
