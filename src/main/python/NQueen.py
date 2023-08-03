class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        # res 存放最终结果
        # chessboard 存放每次的结果

        # n * n 棋盘，深度就是 行 n，树的宽度也是 n，树的宽度也是n
        # 满足 row == n return 
        # 每次遍历 col 时都需要判断 chessbord是否有效 

        res = []
        chessboard = ['.' * n for _ in range(n)] # 初始化棋盘

        self.backTrancking(n, 0, chessboard, res)

        return res

    def backTrancking(self, n, row, chessboard, res):
        if row == n:
            res.append(chessboard[:])
            return

        for col in range(n):
            if self.isValid(row, col, chessboard):
                chessboard[row] = chessboard[row][:col] + 'Q' + chessboard[row][col+1:]
                self.backTrancking(n, row + 1, chessboard, res)
                chessboard[row] = chessboard[row][:col] + '.' + chessboard[row][col+1:]

    def isValid(self, row, col, chessboard):
        # 检查列
        for i in range(row):
            if chessboard[i][col] == 'Q':
                return False

        # 检查45度角
        i, j = row - 1, col - 1
        while i >= 0 and j >= 0:
            if chessboard[i][j] == 'Q':
                return False
            i -= 1
            j -= 1
        
        # 检查135度角
        i, j = row - 1, col + 1
        while i >= 0 and j < len(chessboard):
            if chessboard[i][j] == 'Q':
                return False
            i -= 1
            j += 1
        return True

        