package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17779게리맨더링 {
	static int N;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) map[i][j]=Integer.parseInt(st.nextToken());
		}
		int ans=Integer.MAX_VALUE;
		for(int i=1;i<=N-2;i++) {
			for(int j=2;j<=N-1;j++) {
				for(int d1=1;j-d1>=1;d1++) {
					for(int d2=1;j+d2<=N;d2++) {
						if(i+d1+d2>N) continue;
						int temp = zone(i,j,d1,d2);
						ans = temp<ans?temp:ans;
					}
				}
			}
		}
		System.out.println(ans);

	}
	static int zone(int x,int y,int d1,int d2){
		int tx,ty;
		tx=x;
		ty=y;
		int[] z = new int[5];
		// 1
		for(int i=1;i<tx+d1;i++) {
			if(i>=tx) ty--;
			for(int j=1;j<=ty;j++) {
				z[0]+=map[i][j];
			}
		}
		tx=x;
		ty=y;
		//2
		for(int i=1;i<=tx+d2;i++) {
			if(i>tx) ty++;
			for(int j=ty+1;j<=N;j++) {
				z[1]+=map[i][j];
			}
			
		}
		tx=x;
		ty=y;
		//3
		for(int i=tx+d1;i<=N;i++) {
			for(int j=1;j<ty-d1;j++) {
				z[2]+=map[i][j];
			}
			if(i<tx+d1+d2) ty++;
		}
		tx=x;
		ty=y;
		//4
		for(int i=tx+d2+1;i<=N;i++) {
			for(int j=ty+d2;j<=N;j++) {
				z[3]+=map[i][j];
				
			}
			if(i<=tx+d1+d2) ty--;
		}
		tx=x;
		ty=y;
		int td1=0;
		int td2=0;
		//5
		for(int i=tx;i<=tx+d1+d2;i++) {
			for(int j=ty-td1;j<=ty+td2;j++) {
				z[4]+=map[i][j];
			}
			if(i<x+d2) td2++;
			else td2--;
			if(i<x+d1) td1++;
			else td1--;
		}
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<5;i++) {
			if(max<z[i]) max=z[i];
			if(min>z[i]) min=z[i];
		}
		return max-min;
	}
}
