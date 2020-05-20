package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11404�뵆濡쒖씠�뱶 {
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
		// 湲곗��씠 �릺�뒗 嫄곗퀜媛��뒗 �끂�뱶 K
        for(int k = 1; k <= n; k++) {
            // 異쒕컻�븯�뒗 �끂�뱶 i
            for(int i=1; i <= n; i++) {
                // �룄李⑺븯�뒗 �끂�뱶 j
                for(int j=1; j <= n; j++) {
                    //i�뿉�꽌 k瑜� 嫄곗낀�떎媛� k�뿉�꽌 j 源뚯� 媛��뒗 嫄곕━�� i�뿉�꽌 j 源뚯� 媛��뒗 嫄곕━瑜� 鍮꾧탳�빐�꽌 �옉�� 媛믪씠 理쒖냼嫄곕━�씠�떎.
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
