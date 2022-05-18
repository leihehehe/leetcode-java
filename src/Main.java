import backtracking.middle.*;

public class Main {
    public static void main(String[] args) {
        WordSearchMethod2 wordSearch = new WordSearchMethod2();
        char[][] board = {{'a'}};
        String word = "a";
        System.out.println(wordSearch.exist(board,word));
    }


}
