package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1987알파벳DFS {
	static int R,C,ans=0;
	static int[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean[] visit = new boolean[26];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int i=0;i<R;i++) {
			String s = br.readLine();
			for(int j=0;j<C;j++) map[i][j] = s.charAt(j)-65;
		}
		visit[map[0][0]]= true;
		dfs(0,0,1);
		System.out.println(ans);
	}
	static void dfs(int x, int y,int cnt) {
		ans = ans<cnt ? cnt:ans;
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0 || nx>=R || ny<0 || ny>=C ) continue;
			if(visit[map[nx][ny]]) continue;
			visit[map[nx][ny]]=true;
			dfs(nx,ny,cnt+1);
			visit[map[nx][ny]]=false;
		}
	}
}
