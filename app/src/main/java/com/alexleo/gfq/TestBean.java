package com.alexleo.gfq;

import java.util.List;

public class TestBean {

    private String name;

    private String content;

    public String getName() {
        return name;
    }

    public TestBean setName(String name) {
        this.name = name;
        return this;
    }

    public String getContent() {
        return content;
    }

    public TestBean setContent(String content) {
        this.content = content;
        return this;
    }

    private List<InnerBean> innerList;

    public List<InnerBean> getInnerList() {
        return innerList;
    }

    public TestBean setInnerList(List<InnerBean> innerList) {
        this.innerList = innerList;
        return this;
    }
}
