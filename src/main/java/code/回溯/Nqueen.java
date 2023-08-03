package code.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nqueen {
    
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        
        char[][] chessboard = new char[n][n];

        for (char[] ch : chessboard) {
            Arrays.fill(ch, '.');
        }

        backTracking(n, 0, chessboard);

        return res;
    }

    private void backTracking(int n, int row, char[][] chessboard) {
        if (row == n) {
            res.add(Array2List(chessboard));
            return;
        }

        for (int col = 0; col < chessboard.length; col++) {
            if (isValid(row, col, chessboard)) {
                chessboard[row][col] = 'Q';
                backTracking(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, char[][] chessboard) {

        // 判断列
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') return false;
        }

        // 判断45度角
        int i = row - 1, j = col - 1;
        for ( ; i >=0 && j >= 0; j--, i--) {
            if (chessboard[i][j] == 'Q') return false;
        }

        // 判断135度角
        for ( i = row - 1, j = col + 1 ; i >=0 && j < chessboard.length; j++, i--) {
            if (chessboard[i][j] == 'Q') return false;
        }
        return true;
    }

    private List<String> Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] ch : chessboard) {
            list.add(String.valueOf(ch));
        }
        return list;
    }
}
