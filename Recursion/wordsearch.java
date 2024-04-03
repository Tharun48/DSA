class Solution {
    private boolean isValid(int row,int col,char board[][]) {
        int n = board.length;
        int m = board[0].length;
        if(row<0 || col<0 ||row>=n || col>=m) return false;
        return true;
    }
    private boolean func(int row,int col,int index,char c[][],String word,boolean vis[][]) {
        int len = word.length();
        if(index==len-1) {
            if(word.charAt(index)==c[row][col]) return true;
            return false;
        }
        if(word.charAt(index)!=c[row][col]) return false;
        int dRow[] = {1,-1,0,0};
        int dCol[] = {0,0,1,-1};
        // System.out.println("********");
        for(int i=0;i<4;i++) {
            int r = row + dRow[i];
            int cl = col + dCol[i];
            if(r==row && cl==col) continue;
            if(isValid(r,cl,c) && !vis[r][cl]) {
                vis[r][cl]=true;
                // System.out.println("row = "+ r + " col = " + cl + " index "+ (index+1) );
                if(func(r,cl,index+1,c,word,vis)) return true;
                vis[r][cl]=false;
            }
        }
        // System.out.println("********");
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                boolean vis[][] = new boolean[n][m];
                vis[i][j]=true;
                // System.out.println("********");
                // System.out.println("rowstart " + i + " colstart = " + j);
                if(func(i,j,0,board,word,vis)) return true;
            }
        }
        return false;
    }
}
/*1)The two basic pruning are stoping when reaching a mismatch of the word[k] and the current letter in board.
Also, I used the board as a hashset to know if I already pass at the current coordinate. (vis array)
Passing the board and the word as reference also helps because in this way it don't need to copy the hole thing.
The two not so obvious pruning are to calculate the frequency of the letters of the word in the board, if some letter doesn't exist in the board, return false immediately. 
2)***Also, if the frequency of the first letter is greater than the frequency of the last letter, reverse the string before passing to the algorithm, 
that way you have less calls to the backtracking function on the for loop. */