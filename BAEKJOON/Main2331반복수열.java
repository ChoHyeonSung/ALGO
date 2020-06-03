package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2331반복수열 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int[] D = new int[20000];
		int idx = 0;
		D[idx] = A;
		while(true) {
			int cur = D[idx];
			int add = 0;
			while(true) {
				if(cur>0) {
					add+=Math.pow((cur%10),P);
					cur/=10;
				}else break;
			}
			D[++idx] = add;
			
			for(int i=0;i<idx;i++) {
				if(add == D[i]) {
					System.out.println(i);
					return;
				}
				
			}
		}
	}

}
