class Solution {
    public static boolean isSafe(List<String> board,int row,int col){
        //vertical-up
        for(int i=row-1,j=col;i>=0;i--){
            if(board.get(i).charAt(j)=='Q'){
                return false;
            }
        }
        //left-diagonal
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board.get(i).charAt(j)=='Q'){
                return false;
            }
        }
        //right-diagonal
        for(int i=row-1,j=col+1;i>=0 && j<board.size();i--,j++){
            if(board.get(i).charAt(j)=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void solve(List<List<String>> result, List<String> board,int row){
        if(row == board.size()){
            List<String> finalBoard = new ArrayList<>(board);
            result.add(finalBoard);
            return;
        }
        for(int j=0;j<board.size();j++){
            if(isSafe(board,row,j)){
                StringBuilder sb1 = new StringBuilder(board.get(row));
                sb1.setCharAt(j,'Q');
                board.set(row,sb1.toString());
                solve(result,board,row+1);
                sb1.setCharAt(j,'.');
                board.set(row,sb1.toString());
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> board = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(".");
            }
            board.add(sb.toString());
        }
        solve(result,board,0);
        return result;
    }
}
