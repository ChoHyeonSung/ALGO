package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11404플로이드 {
	static int n,m;
	static int[][] ans;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		ans=new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i!=j) ans[i][j]=10000001;
			}
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(c<ans[a][b]) ans[a][b] = c;
		}
		floyd();
		print();
	}
	static void floyd() {
		// 기준이 되는 거쳐가는 노드 K
        for(int k = 1; k <= n; k++) {
            // 출발하는 노드 i
            for(int i=1; i <= n; i++) {
                // 도착하는 노드 j
                for(int j=1; j <= n; j++) {
                    //i에서 k를 거쳤다가 k에서 j 까지 가는 거리와 i에서 j 까지 가는 거리를 비교해서 작은 값이 최소거리이다.
                	if(i!=j&&i!=k) ans[i][j] = Math.min(ans[i][k] + ans[k][j], ans[i][j]);
                }
            }
        }
	}
	static void print() {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(ans[i][j]>=10000001) System.out.print("0 ");
				else System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
}
