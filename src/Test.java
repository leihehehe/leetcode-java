import java.util.*;

public class Test {

    public static void main(String[] args) {
        String a ="hello.world.a.";
        StringBuilder stringBuilder = new StringBuilder();
        String[] split = a.split("\\h");
        System.out.println(Arrays.toString(split));
    }


}
