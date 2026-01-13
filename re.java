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
        String re_zip = "^\\d{5}(-\\d{4})?$";
        String[] zips = {"07675", "10001-1234", "1234", "ABCDE"};
        for (String zip : zips) {
            boolean matches = zip.matches(re_zip);
            System.out.println(zip + " -> " + matches);
        }
        String re_cap = "^[A-Z].*";

        String[] words = {"Hello", "world", "Java", "java", "APPLE", "1Test"};

        for (String word : words) {
            boolean matches = word.matches(re_cap);
            System.out.println(word + " -> " + matches);
        }

    }
   
    
}