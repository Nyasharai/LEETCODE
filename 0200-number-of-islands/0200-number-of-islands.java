class Solution {

    static void dfs(char arr[][], int i, int j){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length) return;

        if(arr[i][j]=='0') return;

        arr[i][j] = '0';
        dfs(arr,i,j+1);
        dfs(arr,i,j-1);
        dfs(arr,i-1,j);
        dfs(arr,i+1,j);
    }
    public int numIslands(char[][] arr) {
        int ans = 0;
        int n = arr.length;
        int m = arr[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]=='1'){
                    dfs(arr,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
}