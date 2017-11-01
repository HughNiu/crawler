import com.github.kevinsawicki.http.HttpRequest;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Niu Qianghong on 2017-11-01 0001.
 */
public class HttpRequestDemo {
    public static void main(String[] args) {
        String url = "https://m.bookbao8.com/views/201207/30/id_XMjgyMzIz_1.html";
        Map<String, String> replacement = new LinkedHashMap<String, String>();
        replacement.put("\\s", "");
        replacement.put("<br>|</br>|</p>", "\r\n");
        replacement.put("<.*?>", "");
        replacement.put("</.*?>", "");
        replacement.put("&lt;", "<");
        replacement.put("&gt;", ">");
        replacement.put("\".*?>", ""); // 知乎特殊的转义
        crawl("get", "https://www.zhihu.com/question/27850529", null, ".RichContent-inner", replacement);
    }

    /**
     * 爬数据方法
     * @param type get/post
     * @param url
     * @param params
     * @param selector jquery选择器
     * @param replacement 需要替换的内容[正则表达式, key为原始内容, value为替换内容]
     * @return
     */
    public static String crawl(String type, String url, Map<String, Object> params, String selector, Map<String, String> replacement){
        try {
            HttpRequest request = null;
            // 获得网页内容
            if ("get".equalsIgnoreCase(type)) {
                request = HttpRequest.get(url);
            } else if ("post".equalsIgnoreCase(type)) {
                request = HttpRequest.post(url);
            }

            String content = "";
            if (request != null && params != null && !params.isEmpty()) {
                content = request.form(params).body();
            } else {
                content = request.body();
            }

            // jquery选择器处理
            if (!StringUtil.isBlank(content) && !StringUtil.isBlank(selector)) {
                content = Jsoup.parse(content).select(selector).html();
            }

            // 网页内容处理
            if (replacement != null && !replacement.isEmpty()) {
                for (String key:replacement.keySet()) {
                    content = content.replaceAll(key, replacement.get(key));
                }
            }
            content = content.replaceAll("(\r\n)+", "\r\n"); // 多个换行转换为1个
            System.out.println(content);
            return content;
        } catch (HttpRequest.HttpRequestException e) {
            return "处理异常-->" + e.getMessage();
        }
    }
}
