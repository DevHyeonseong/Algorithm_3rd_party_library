import java.util.ArrayList;
import java.util.Arrays;
/*
 * created by DevHyeonseong 2020/09/20
 *
 * 모든 경우의 수를 찾아주는 조합 클래스
 * 0~n-1 까지의 수 중 크기가 start~end인 int[]형 조합배열 리스트를 리턴한다
 * ex) n = 4, start = 2, end = 3 -> ArryaList<int[]> = [[0,1], [0,2], [0,3], [1,2], [1,3], [2,3], [0,1,2], [0,1,3], [0,2,3], [1,2,3]]
 * 시간복잡도 : O(N!)
 */
public class Combination {

    private int n;
    private int start;
    private int end;
    private ArrayList<int[]> list;

    public Combination(int n, int start, int end){
        this.n = n;
        this.start = start;
        this.end = end;
        this.list = new ArrayList<>();
        init();
    }

    private void init(){
        int[] arr = new int[n];
        boolean[] visit = new boolean[n];

        for(int i=0;i<n;i++){
            arr[i] = i;
        }

        for(int r=start;r<=end;r++){
            makeCombination(arr, visit, 0, n, r, r);
        }
    }

    private void makeCombination(int[] arr, boolean[] visit, int depth, int n, int r, int ar){
        if (r == 0) {
            add(arr, visit, n, ar);
            return;
        }

        if (depth == n) {
            return;
        }

        visit[depth] = true;
        makeCombination(arr, visit, depth + 1, n, r - 1, ar);

        visit[depth] = false;
        makeCombination(arr, visit, depth + 1, n, r, ar);
    }

    private void add(int[] arr, boolean[] visited, int n, int ar) {
        int[] temp = new int[ar];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                temp[idx] = arr[i];
                idx++;
            }
        }
        list.add(temp);
    }

    public ArrayList<int[]> getCombination(){
        return this.list;
    }

    public void printCombination(){
        for(int[] arr : list){
            System.out.println(Arrays.toString(arr));
        }
    }
}
