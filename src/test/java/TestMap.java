import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Niu Qianghong on 2017-11-01 0001.
 */
public class TestMap {
    public static void main(String[] args) {
        Map<String, String> replacement = new LinkedHashMap<String, String>();
        replacement.put("<.*?>", "");
        replacement.put("</.*?>", "");
        replacement.put("&lt;", "<");
        replacement.put("&gt;", ">");
        for (String key:replacement.keySet()) {
            System.out.println(key);
        }
    }
}
