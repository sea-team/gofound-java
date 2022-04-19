package io.github.newpanjing;

import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;
import io.github.newpanjing.model.Result;

/**
 * GoFound客户端
 */
public class Client {
    String addr;

    /**
     * 设置服务器接口地址
     *
     * @param addr
     */
    public Client(String addr) {
        this.addr = addr;
    }

    public String getAddr() {
        return addr;
    }

    /**
     * 发送请求
     *
     * @param url
     * @param json
     * @return
     */
    private Result post(String url, JSONObject json) {
        HttpRequest request = HttpRequest.post(this.addr + url).acceptJson();
        request.header("Content-Type", "application/json");

        request.send(json.toJSONString());
        String body = request.body();
        return Result.parse(body);
    }

    /**
     * 查询索引
     *
     * @param q
     * @return
     */
    public Result query(String q) {
        return query(q, 0, 10, null, null);
    }

    /**
     * 查询索引
     *
     * @param query
     * @param page
     * @param limit
     * @param order
     * @param highlight
     * @return
     */
    public Result query(String query, int page, int limit, String order, JSONObject highlight) {

        JSONObject json = new JSONObject();
        json.put("query", query);
        json.put("page", page);
        json.put("limit", limit);
        json.put("order", order);
        json.put("highlight", highlight);

        return post("/query", json);
    }

    /**
     * 删除索引
     *
     * @param id
     * @return
     */
    public Result removeDocument(int id) {
        JSONObject json = new JSONObject();
        json.put("id", id);
        return post("/remove", json);
    }

    /**
     * 添加索引
     *
     * @param id
     * @param text
     * @param document
     * @return
     */
    public Result addDocument(int id, String text, JSONObject document) {
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("text", text);
        json.put("document", document);
        return post("/index", json);
    }

}
