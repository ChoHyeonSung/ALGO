package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main17837새로운게임2 {
	static int N, K;
	static int[][] map;
	static ArrayList<Integer>[][] hmap;
	static Horse[] horse;
	static int[][] change = { { 0, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 입력 및 초기화
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		hmap = new ArrayList[N][N];
		horse = new Horse[K + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				hmap[i][j] = new ArrayList<Integer>();
			}
		}

		int x, y, d;
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			d = Integer.parseInt(st.nextToken());
			horse[i] = new Horse(x, y, d);
			hmap[x][y].add(i);
		}

		game();

	}

	static void print(int[][] m) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void game() {
		int nx, ny, nd, target;
		Horse cur;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int t=1;t<=1000;t++) {
			for (int i = 1; i <= K; i++) {
				cur = horse[i];
				nd = cur.d;
				nx = cur.x + change[nd][0];
				ny = cur.y + change[nd][1];
				target = -1;
				if (!range(nx, ny) || map[nx][ny] == 2) { // 예외+파란칸
					if (nd == 1)
						nd = 2;
					else if (nd == 2)
						nd = 1;
					else if (nd == 3)
						nd = 4;
					else if (nd == 4)
						nd = 3;
					horse[i].d = nd;
					nx = cur.x + change[nd][0];
					ny = cur.y + change[nd][1];
				}
				if (range(nx, ny) && map[nx][ny] != 2) { 
					if (map[nx][ny] == 0) { // 흰색칸
						// 현재 말 직전까지 위에서 부터 차례대로 뺀후 다음 칸에 넣음
						while (target != i) { 
							target = hmap[cur.x][cur.y].remove(hmap[cur.x][cur.y].size() - 1);
							temp.add(target);
						}
						while (!temp.isEmpty()) {
							target = temp.remove(temp.size() - 1);
							horse[target].x = nx;
							horse[target].y = ny;
							hmap[nx][ny].add(target);
						}
					} else { // 빨간칸
						while (target != i) {
							target = hmap[cur.x][cur.y].remove(hmap[cur.x][cur.y].size() - 1);
							horse[target].x = nx;
							horse[target].y = ny;
							hmap[nx][ny].add(target);
						}
					}
					if (hmap[nx][ny].size() >= 4) {
						System.out.println(t);
						return;
					}
				}
			}
		}
		System.out.println(-1);
	}

	static boolean range(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;
		return true;
	}

	static class Horse {
		int x, y, d;

		Horse(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
