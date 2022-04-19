package io.github.newpanjing;

import com.alibaba.fastjson.JSONObject;
import io.github.newpanjing.model.Result;

public class Test {

    //声明客户端
    static Client client = new Client("http://127.0.0.1:5678/api");


    //测试查询
    public static void query() {
        Result result = client.query("北京什么时候举办的奥运会");
        System.out.println(result);
    }

    //移除文档
    public static void remove() {
        Result result = client.removeDocument(100);
        System.out.println(result);
    }

    //添加索引
    public static void addDocument() {
        JSONObject document = new JSONObject();
        document.put("area", "北京");
        document.put("date", "2008-08-08");

        Result result = client.addDocument(100, "北京时间于2008年成功举了奥运会", document);
        System.out.println(result);
    }

    public static void main(String[] args) {
        addDocument();
        query();
        remove();
    }
}
