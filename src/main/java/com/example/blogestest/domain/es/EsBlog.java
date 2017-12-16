package com.example.blogestest.domain.es;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * 文档类
 *
 * @auther AN dengchangneng
 * @create 2017/12/16
 */
@Document(indexName = "blog", type = "blog")
public class EsBlog implements Serializable {

    //主键
    @Id
    private String id;

    //标题
    private String title;

    //摘要
    private String summary;

    //正文
    private String content;

    protected EsBlog() {//JPA规范要求，防止直接使用
    }

    public EsBlog(String id, String title, String summary, String content) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("EsBlog[id='%s',title='%s',summary='%s',content='%s']", id, title, summary, content);
    }
}
