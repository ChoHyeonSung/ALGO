import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // ���Ѵ� |v - 1| * maxLength
    private static int INF = 16 * 1_000_000;
    // vertex ��
    static int n;
    // graph �迭
    static int arr[][];
    // dp[node][visit] = k -> ���� node���� �հ� visit�� �湮�ϰ� ���� ��
    // 0�� ���� ���� �ּ��� �Ÿ�
    static int dp[][];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][(1 << n) - 1];

        for(int i = 0 ; i < n; i++)
            Arrays.fill(dp[i], INF);

        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int value = Integer.parseInt(st.nextToken());
                arr[i][j] = value;
            }
        }

        bw.write(tsp(0, 1) + "\n");

        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		System.out.print(dp[i][j]+" ");
        	}
        	System.out.println();
        }
        br.close();
        bw.close();
    }

    private static int tsp(int node, int visit){
        // ��� ������ �湮�� ���
        if(visit == (1 << n) - 1){
            if(arr[node][0] == 0) return INF;
            return arr[node][0];
        }

        // �̹� ��� �ߴ� ���
        if(dp[node][visit] != INF)
            return dp[node][visit];

        for(int i = 0 ; i < n; i++){
            int next = visit | (1 << i);
            // i�� ��忡 ���ؼ� ���� ���ų� �湮�� ���
            if(arr[node][i] == 0 || (visit & (1 << i)) != 0) continue;

            dp[node][visit] = Math.min(dp[node][visit], tsp(i, next) + arr[node][i]);
        }

        return dp[node][visit];
    }
}