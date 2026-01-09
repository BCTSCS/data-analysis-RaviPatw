import java.util.ArrayList;
public class re {
    public static void main(String [] args){
        String re="#\\w+\\s";
        String text="ABBBBBBBBA";
        ArrayList<String> posts= FileOperator.getStringList("posts.txt");
        System.out.println(posts);
        for(String post:posts){
            boolean result = post.matches(re);
        }
        boolean result = text.matches(re);
        System.out.println(result);
    }
}