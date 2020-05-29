package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main6118숨바꼭질dijkstra {
	public static void main(String[] args) throws IOException {
 		System.setIn(new FileInputStream("input.txt"));
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		StringTokenizer st = new StringTokenizer(br.readLine());
 		int N = Integer.parseInt(st.nextToken());
 		int M = Integer.parseInt(st.nextToken());
 		ArrayList<Integer>[] nodes = new ArrayList[N];
 		for(int i=0;i<N;i++) nodes[i] = new ArrayList<>();
 		for(int i=0;i<M;i++) {
 			st = new StringTokenizer(br.readLine());
 			int a = Integer.parseInt(st.nextToken())-1;
 			int b = Integer.parseInt(st.nextToken())-1;
 			nodes[a].add(b);
 			nodes[b].add(a);
 		}
 		int hide = 2;
 		int max = -1;
 		int cnt = 1;
 		
 	}
	static void dijkstra(int idx) {
		
	}
	static class Node{
		int idx,dist;
		Node(int idx,int dist){
			this.idx = idx;
			this.dist = dist;
		}
	}
}
