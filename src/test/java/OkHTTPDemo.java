import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Niu Qianghong on 2017-11-01 0001.
 */
public class OkHTTPDemo {
    public static void main(String[] args) throws Exception{
        long s = System.currentTimeMillis();
        String url = "https://m.bookbao8.com/views/201207/30/id_XMjgyMzIz_1.html";
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("服务器端错误: " + response);
        }

        Headers responseHeaders = response.headers();
        for (int i = 0; i < responseHeaders.size(); i++) {
            System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
        }
        System.out.println(response.body().string());
        long e = System.currentTimeMillis();
        System.out.println(e-s);
    }
}
