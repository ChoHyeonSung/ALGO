package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1261¾Ë°í½ºÆÌDFS {
	static int N,M,ans;
	static int[][] map;
	static int[][] dist_map;
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
		ans=Integer.MAX_VALUE;
		map= new int[N][M];
		dist_map= new int[N][M];
		visit = new boolean[N][M];
		for(int i=0;i<N;i++) {
			String[] temp = br.readLine().split("");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(temp[j]);
				dist_map[i][j]=Integer.MAX_VALUE;
			}
		}
		
		visit[0][0]=true;
		dfs(0,0,0);
		
		System.out.println(dist_map[N-1][M-1]);
	}
	
	static void dfs(int x,int y,int cnt) {
		if(dist_map[x][y]<=cnt) return;
		else dist_map[x][y]=cnt;
		
		if(x==N-1 && y==M-1) return;
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
			if(visit[nx][ny]) continue;
			
			visit[nx][ny]=true;
			dfs(nx,ny,cnt+(map[nx][ny]==1?1:0));
			visit[nx][ny]=false;
			
		}
	}
}
