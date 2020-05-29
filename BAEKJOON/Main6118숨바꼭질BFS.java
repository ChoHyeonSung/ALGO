package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main6118숨바꼭질BFS {
	public static void main(String[] args) throws IOException {
 		System.setIn(new FileInputStream("input.txt"));
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		StringTokenizer st = new StringTokenizer(br.readLine());
 		int N = Integer.parseInt(st.nextToken());
 		int M = Integer.parseInt(st.nextToken());
 		ArrayList<Integer>[] nodes = new ArrayList[N+1];
 		for(int i=0;i<=N;i++) nodes[i] = new ArrayList<>();
 		for(int i=0;i<M;i++) {
 			st = new StringTokenizer(br.readLine());
 			int a = Integer.parseInt(st.nextToken());
 			int b = Integer.parseInt(st.nextToken());
 			nodes[a].add(b);
 			nodes[b].add(a);
 		}
 		int hide = 2;
 		int max = -1;
 		int cnt = 1;
 		
 		Queue<Node> q = new LinkedList<>();
 		boolean[] visit = new boolean[N+1];
 		q.add(new Node(1,0));
 		visit[1]=true;
 		while(!q.isEmpty()) {
 			Node now = q.poll();
 			if(max<now.dist) {
 				max = now.dist;
 				hide = now.idx;
 				cnt=1;
 			}
 			else if(max==now.dist) {
 				cnt++;
 				if(hide>now.idx) {
 					hide = now.idx;
 				}
 			}
 			for(Integer next:nodes[now.idx]) {
 				if(visit[next]) continue;
 				q.add(new Node(next,now.dist+1));
 				visit[next]=true;
 			}
 		}
 		System.out.println(hide +" "+ max+" "+cnt);
	}	
	static class Node{
		int idx,dist;
		Node(int idx,int dist){
			this.idx = idx;
			this.dist = dist;
		}
	}
}
