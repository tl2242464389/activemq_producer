package com.activemq.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Description:
 * @Author: tl
 * @Date: 2019-06-07 12:07
 * @Version: 1.0
 */
public class Mail implements Serializable{
    // 发件人
    private String from;
    // 收件人
    private String to;
    // 主题
    private String suject;
    // 内容
    private String content;

    @Override
    public String toString() {
        return "Mail{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", suject='" + suject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mail mail = (Mail) o;
        return Objects.equals(from, mail.from) &&
                Objects.equals(to, mail.to) &&
                Objects.equals(suject, mail.suject) &&
                Objects.equals(content, mail.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, suject, content);
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSuject() {
        return suject;
    }

    public void setSuject(String suject) {
        this.suject = suject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
