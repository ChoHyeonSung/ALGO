package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main2941크로아티아알파벳 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String croatia[] = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		for(int i=0;i<8;i++) {
			s = s.replace(croatia[i], "a");
		}
		System.out.println(s.length());

	}

}
