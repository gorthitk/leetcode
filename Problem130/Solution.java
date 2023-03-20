/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution
{
    public void solve(char[][] board)
    {
        if (board == null || board.length == 0 || board[0].length == 0)
        {
            return;
        }
        int m = board.length;
        int n = board[0].length;        
        //Step 1 : Flip 'O' to '*' which can never be captured.        
        //Start with the edges as 'O''s on the edges can never be captured.        
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {                
                dfs(0, i, board, m, n);            
            }            
            if (board[m - 1][i] == 'O') {                
                dfs(m - 1, i, board, m, n);            
            }        
        }
        for (int i = 0; i < m; i++) {            
            if (board[i][0] == 'O') {                
                dfs(i,0, board, m, n);            
            }            
            if (board[i][n - 1] == 'O') {                
                dfs(i, n- 1, board, m, n);            
            }        
        }        
        //Step2 : Flip all 'O' to 'X' since the remaining 'O''s can be captured.        
        //Also flip '*' to 'O''s       
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {                
                if (board[i][j] == 'O')  {
                    board[i][j] = 'X';                
                }                
                if (board[i][j] == '*'){
                    board[i][j] = 'O';                
                }            }        
        }    
    }    
    
    private void dfs(int i, int j, char[][]board, int m, int n) {        
        if (i < 0 || i >= m || j < 0 || j >= n)            return;
            board[i][j] = '*';        
        if (i > 1 && board[i - 1][j] == 'O') {            
            dfs(i - 1, j, board, m, n);        
        }       
        if (i < m - 1 && board[i + 1][j] == 'O') {            
            dfs(i + 1, j, board, m, n);        
        }        
        if (j > 1 && board[i][j - 1] == 'O') {           
            dfs(i, j - 1, board, m, n);
        }        
        if (j < n - 1 && board[i][j + 1] == 'O'){            
            dfs(i, j + 1, board, m, n);        
        }
        }
}
