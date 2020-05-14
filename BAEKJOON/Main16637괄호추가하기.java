package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main16637괄호추가하기 {
	static int n,ans=Integer.MIN_VALUE;
	static int[] num;
	static char[] oper;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[n/2+1];
		oper = new char[n/2];
		String[] str = br.readLine().split("");
		for(int i=0;i<n;i++) {
			if(i%2==0) num[i/2] = Integer.parseInt(str[i]);
			else oper[i/2] = str[i].charAt(0);
		}
		dfs(0,num[0]);
		System.out.println(ans);
	}
	static void dfs(int idx,int res) {
		if(idx>=n/2) {
			if(ans<res) ans=res;
			return;
		}
		// 괄호 묶고 계산
		dfs(idx+1,cal(res,oper[idx],num[idx+1]));
		// 괄호 안치고 뒤에 연산자 있을경우
		if(idx+1<n/2) {
			dfs(idx+2,cal(res,oper[idx],cal(num[idx+1],oper[idx+1],num[idx+2])));
		}
	}
	static int cal(int a,char operation,int b) {
		if(operation=='+') return a+b;
		else if(operation=='-') return a-b;
		else return a*b;
	}
}
