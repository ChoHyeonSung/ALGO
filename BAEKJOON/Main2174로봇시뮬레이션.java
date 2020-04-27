package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2174·Îº¿½Ã¹Ä·¹ÀÌ¼Ç {
	static int A,B,N,M;
	static Robot[] R;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//Input the size of the map
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		// Location and Command
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// Init Robot size
		R = new Robot[N];
		// Set Location
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = B-Integer.parseInt(st.nextToken());
			char dd = st.nextToken().charAt(0);
			int d = 0;
			if(dd =='W') d = 3;
			else if(dd =='E') d = 1;
			else if(dd =='S') d = 2;
			R[i] = new Robot(x,y,d);
		}
		// Check for collision
		boolean check = true;
		// Execute Command
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken())-1;
			char command = st.nextToken().charAt(0);
			int c = Integer.parseInt(st.nextToken());
			
			while(c-->0 && check) {
				if(command == 'L') {
					R[n].d--;
					if(R[n].d ==-1) R[n].d = 3;
				} else if(command == 'R') {
					R[n].d++;
					if(R[n].d == 4) R[n].d = 0;
				} else {
					if(R[n].d == 0) {
						R[n].x--;
					}else if(R[n].d == 1) {
						R[n].y++;
					}else if(R[n].d == 2) {
						R[n].x++;
					}else {
						R[n].y--;
					}
					// Out of range
					if(R[n].x<0 || R[n].x>=B || R[n].y<0 || R[n].y>=A) {
						System.out.printf("Robot %d crashes into the wall\n",n+1);
						check=false;
						break;
					}
					for(int j=0;j<N;j++) {
						if(n == j) continue;
						// Robot collision
						if(R[n].x == R[j].x && R[n].y == R[j].y) {
							System.out.printf("Robot %d crashes into robot %d\n",n+1,j+1);
							check=false;
							break;
						}
					}
				}
			}
		}
		if(check) System.out.println("OK");
	}
	static class Robot{
		int x,y,d;
		Robot(int x,int y,int d){
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
