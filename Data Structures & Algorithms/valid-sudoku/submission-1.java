class Solution {
    public boolean isValidSudoku(char[][] board) {

        for ( int row =0; row < 9; row++){

            for( int col=0; col < 9; col++){


                if(board[row][col] == '.')
                continue;

               char num = board[row][col];
                // check in the same row but change col
                for( int j=0; j<9; j++){
                    if( col !=j && board[row][j]==num)
                    return false;
                }

                // check in the same col but change row
                for( int i=0; i<9; i++){
                    if( i!=row && board[i][col]==num )
                    return false;
                }

                int sr=(row/3)*3;
                int sc=(col/3)*3;

                for( int i=sr; i<sr+3; i++ ){
                    for( int j=sc; j<sc+3; j++){
                        if( (i!=row || j!=col) && board[i][j]==num)
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
