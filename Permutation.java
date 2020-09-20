import java.util.ArrayList;
import java.util.Arrays;
/*
 * created by DevHyeonseong 2020/09/21
 *
 * 모든 경우의 수를 찾아주는  순열 클래스
 * 0~n-1 까지의 수 중 크기가 start~end인 int[]형 순열배열 리스트를 리턴한다
 * ex) n = 3, start = 2, end = 3 -> ArryaList<int[]> = [[0, 1], [0, 2], [1, 0], [1, 2], [2, 0], [2, 1], [0, 1, 2], [0, 2, 1], [1, 0, 2], [1, 2, 0], [2, 0, 1], [2, 1, 0]]
 * 시간복잡도 : O(N!)
 */
public class Permutation {

    private int n;
    private int start;
    private int end;
    private ArrayList<int[]> list;

    public Permutation(int n, int start, int end){
        this.n = n;
        this.start = start;
        this.end = end;
        this.list = new ArrayList<>();
        init();
    }

    private void init(){
        int[] arr = new int[n];
        boolean[] visit = new boolean[n];

        for(int r=start;r<=end;r++){
            makePermutation(arr,visit,0,n,r);
        }
    }

    private void makePermutation(int[] arr, boolean[] visit, int depth, int n, int r){
        if(depth == r){
            int[] temp = new int[depth];
            int idx = 0;
            for(int i=0;i<arr.length;i++){
                temp[idx] = arr[i];
                idx++;
                if(idx==depth) break;
            }
            list.add(temp);
            return;
        }
        
        for(int i=0;i<n;i++){
            if(visit[i]) continue;
            visit[i] = true;
            arr[depth] = i;
            makePermutation(arr,visit,depth+1,n,r);
            visit[i] = false;
        }
    }


    public ArrayList<int[]> getPermutation(){
        return this.list;
    }

    public void printPermutation(){
        for(int[] arr : list){
            System.out.println(Arrays.toString(arr));
        }
    }
    
}
