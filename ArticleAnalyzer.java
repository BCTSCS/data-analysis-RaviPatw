
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ArticleAnalyzer {

    private ArrayList<String> stopWords; 
    private ArrayList<Article> articles; 

    public ArticleAnalyzer(){
        stopWords=FileOperator.getStringList("stopwords.txt");
        System.out.println("Stop Word count"+stopWords.size());
        articles=new ArrayList<>();
        System.out.println("Articles count"+articles.size());

    }
    public static void main(String[] args) {
       ArticleAnalyzer riano = new ArticleAnalyzer();
       ArrayList<String> lines= FileOperator.getStringList("data.txt");
        for(String line : lines){
            Article a = riano.parseJson(line);
            String clean = riano.removeStopWords(a.getDescription());
            a.setDescription(clean);
            System.out.println(a);
            riano.addArticle(a);
        }

       


    }

    public void addStopWord(String word){

    }

    public void addArticle(Article article){
        articles.add(article);
    }

    public Article parseJson(String jsonLine){
 
        Article result;
        Pattern l = Pattern.compile("\"link\":\\s*\"([^\"]+)\"");  
        Matcher lm =l.matcher(jsonLine); 
        String lt = lm.find() ? lm.group(1) : ""; 

        
        Pattern h = Pattern.compile("\"headline\":\\s*\"([^\"]+)\"");  
        Matcher hm = h.matcher(jsonLine); 
        String ht = hm.find() ? hm.group(1) : ""; 
        
        Pattern c = Pattern.compile("\"category\":\\s*\"([^\"]+)\"");  
        Matcher cm = c.matcher(jsonLine); 
        String ct = cm.find() ? cm.group(1) : ""; 

        Pattern d = Pattern.compile("\"short_description\":\\s*\"([^\"]+)\"");
        Matcher dm = d.matcher(jsonLine);
        String dt = dm.find() ? dm.group(1) : "";


        Pattern a = Pattern.compile("\"authors\":\\s*\"([^\"]+)\"");  
        Matcher am =a.matcher(jsonLine); 
        String at = am.find() ? am.group(1) : ""; 

        Pattern t = Pattern.compile("\"date\":\\s*\"([^\"]+)\"");  
        Matcher tm =t.matcher(jsonLine); 
        String tt = tm.find() ? tm.group(1) : ""; 

        
        result=new Article(lt, ht, ct, dt, at, tt);

    return result;
}

 
    public String removeStopWords(String text){
        if (text == null) return "";
        String result = text;  
        for (String stop : stopWords) {
            result = result.replaceAll("\\b" + stop + "\\b", "");
        }
        return result.trim();
        }

} 

