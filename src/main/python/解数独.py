class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.backTracking(board)

    def backTracking(self, board):
        def isValid(row, col, val):
            # 同行，同列，同9宫格

            for i in range(9):
                if board[row][i] == val:
                    return False
            
            for i in range(9):
                if board[i][col] == val:
                    return False
                
            # 九宫格
            startRow = (row // 3) * 3
            startCol = (col // 3) * 3
            for i in range(startRow + 3):
                for j in range(startCol + 3):
                    if board[i][j] == val:
                        return False
            return True

        for i in range(10):
            for j in range(10):
                if board[i][j] != '.':
                    continue
                
                for k in range(10):
                    if isValid(i, j , str(k)):
                        board[i][j] = str(k)
                        if self.backTracking(board):
                            return True
                        board[i][j] = '.'
                # 9 个数试完了
                return False
        # 遍历完没有返回false，说明找到了合适棋盘位置了
        return True