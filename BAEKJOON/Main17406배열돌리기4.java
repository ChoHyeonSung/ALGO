package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17406배열돌리기4 {
	static int N,M,K,ans;
	static int[][] A;
	static rcs[] order;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) A[i][j] = Integer.parseInt(st.nextToken());
		}
		print();
		int r,c,s;
		order = new rcs[K];
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			order[i]=new rcs(r,c,s);
		}
		ans=Integer.MAX_VALUE;
		combination(0,new int[K],new boolean[K]);
		System.out.println(ans);
	}
	static void combination(int idx,int[] turn,boolean[] visit) {
		if(idx==K) {
			int[][] temp = new int[N][M];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) temp[i][j]=A[i][j];
			}
			for(int i=0;i<K;i++) {
				rotation(order[turn[i]],temp);
			}
			int f = find(temp);
			ans=ans>f?f:ans;
			return;
		}
		for(int i=0;i<K;i++) {
			if(visit[i]) continue;
			turn[idx]=i;
			visit[i]=true;
			combination(idx+1, turn, visit);
			visit[i]=false;
		}
	}
	static void rotation(rcs turn,int[][] temp) {
		int sx = turn.r-turn.s-1;
		int sy = turn.c-turn.s-1;
		int ex = turn.r+turn.s-1;
		int ey = turn.c+turn.s-1;
		int cnt = ((ex-sx)/2);
		int t=0;
		for(int i=0;i<cnt;i++) {
			t = temp[sx][sy];
			for(int j=sx;j<ex;j++) temp[j][sy]=temp[j+1][sy];
			for(int j=sy;j<ey;j++) temp[ex][j]=temp[ex][j+1];
			for(int j=ex;j>sx;j--) temp[j][ey]=temp[j-1][ey];
			for(int j=ey;j>sy;j--) temp[sx][j]=temp[sx][j-1];
			temp[sx][sy+1]=t;
			sx++;
			sy++;
			ex--;
			ey--;
		}
		//print();
	}
	static class rcs{
		int r,c,s;
		rcs(int r,int c,int s){
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static int find(int[][] temp) {
		int min=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			int sum=0;
			for(int j=0;j<M;j++) {
				sum+=temp[i][j];
			}
			if(min>sum) min=sum;
		}
		return min;
	}
}
