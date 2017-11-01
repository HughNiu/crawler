/**
 * Created by Niu Qianghong on 2017-11-01 0001.
 */
public class TestReg {
    public static void main(String[] args) {
        String str = "<img src=\"data:image/svg+xml;utf8,&lt;svg%20xmlns='http://www.w3.org/2000/svg'%20width='623'%20height='230'&gt;&lt;/svg&gt;\" data-rawwidth=\"623\" data-rawheight=\"230\" class=\"origin_image zh-lightbox-thumb lazy\" width=\"623\" data-original=\"https://pic2.zhimg.com/f2c8c28c042956c93b7df06a009f17c1_r.jpg\" data-actualsrc=\"https://pic2.zhimg.com/50/f2c8c28c042956c93b7df06a009f17c1_hd.jpg\"><br><br><noscript><img src=\"https://pic1.zhimg.com/50/5ba6cfef4df08db85eef9e6342951f14_hd.jpg\" data-rawwidth=\"627\" data-rawheight=\"261\" class=\"origin_image zh-lightbox-thumb\" width=\"627\" data-original=\"https://pic1.zhimg.com/5ba6cfef4df08db85eef9e6342951f14_r.jpg\"></noscript><img src=\"data:image/svg+xml;utf8,&lt;svg%20xmlns='http://www.w3.org/2000/svg'%20width='627'%20height='261'&gt;&lt;/svg&gt;\" data-rawwidth=\"627\" data-rawheight=\"261\" class=\"origin_image zh-lightbox-thumb lazy\" width=\"627\" data-original=\"https://pic1.zhimg.com/5ba6cfef4df08db85eef9e6342951f14_r.jpg\" data-actualsrc=\"https://pic1.zhimg.com/50/5ba6cfef4df08db85eef9e6342951f14_hd.jpg\"><br><p>从中我们可以发现，部分伪信息或虚信息会采用过多的修饰，从中很难发现一个比较清晰实在的描述，就一个目的，让你上钩，具有强烈的诱导性。而真信息，则会更实在的进行描述，有清晰的叙述逻辑，能给予你更多的决策空间。</p><br><br><p>2、 <b>真信息一般都经过审核，有一个可靠的源头</b>，比如国家的各信息发布平台发布的公开信息。又比如某引擎的这样（转自新浪微博大V@勿怪幸）：</p>";
        str = str.replaceAll("</.*?>", "");
        str = str.replaceAll("<.*?>", "");
        str = str.replaceAll("&lt;", "<");
        str = str.replaceAll("&gt;", ">");
        System.out.println(str);
    }
}
