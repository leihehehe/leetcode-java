import java.util.ArrayDeque;
import java.util.Deque;

public class Test {

    public static void main(String[] args) {
        int a = 0, b = 0, c = 0;
        char ch = '(';
        switch(ch){
            case '(':
                a++;
                break;
            case ')':
                a--;
            case '{':
                b++;
            case '}':
                b--;
            case '[':
                c++;
            case ']':
                c--;
        }
        System.out.println(a);
    }

}
