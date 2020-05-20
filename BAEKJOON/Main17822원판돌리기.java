package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17822원판돌리기 {
	static int N,M,T;
	static int[][] circle;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		circle = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) circle[i][j]=Integer.parseInt(st.nextToken());
		}
		int x,d,k,sum=0;
		boolean check;
		int temp[] = new int[M+1];
		boolean[][] link;
		for(int i=0;i<T;i++) {
			System.out.println("전");
			print();
			st = new StringTokenizer(br.readLine());
			x =  Integer.parseInt(st.nextToken());
			d =  Integer.parseInt(st.nextToken());
			k =  Integer.parseInt(st.nextToken());
			// 무조건 시계방향으로 돌림
			if(d==1) k = M-k;
			for(int j=1;j*x<=N;j++) {
				System.arraycopy(circle[j*x], 0, temp, 0, M+1);
				for(int l=1;l<=k;l++) circle[j*x][l]=temp[M-k+l]; 
				for(int l=k+1;l<=M;l++) circle[j*x][l]=temp[l-k]; 
			}
			link = new boolean[N+1][M+1];
			check = false;
			// 같은 수를 찾아서 지운다
			for(int j=1;j<=N;j++) {
				for(int l=1;l<=M;l++) {
					if(circle[j][l]==0) continue;
					if(j<N && circle[j][l]==circle[j+1][l]) {
						link[j][l]=link[j+1][l]=true;
						check=true;
					}
					if(l==1) {
						if(circle[j][l]==circle[j][l+1]) {
							link[j][l]=link[j][l+1]=true;
							check=true;
						}else if(circle[j][l]==circle[j][M]) {
							link[j][l]=link[j][M]=true;
							check=true;
						}
					}else if(l<M){
						if(circle[j][l]==circle[j][l+1]) {
							link[j][l]=link[j][l+1]=true;
							check=true;
						}else if(circle[j][l]==circle[j][l-1]) {
							link[j][l]=link[j][l-1]=true;
							check=true;
						}
					}
				}
			}
			System.out.println("전전");
			print();
			sum=0;
			int cnt=0;
			for(int j=1;j<=N;j++) {
				for(int l=1;l<=M;l++) {
					if(link[j][l]) circle[j][l]=0;
					if(circle[j][l]==0) continue;
					sum+=circle[j][l];
					cnt++;
				}
			}
			System.out.println("후");
			print();
			double limit=0;
			if(!check ) {
				limit=(double)sum/cnt;
				System.out.println(sum +" "+cnt + " "+limit);
				sum=0;
				
				for(int j=1;j<=N;j++) {
					for(int l=1;l<=M;l++) {
						if(circle[j][l]==0) continue;
						if(limit < circle[j][l]) circle[j][l]--;
						else if(limit > circle[j][l]) circle[j][l]++;
						sum+=circle[j][l];
					}
				}
			}
			
			
		}
		System.out.println(sum);
		
	}

	static void print() {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				System.out.print(circle[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
