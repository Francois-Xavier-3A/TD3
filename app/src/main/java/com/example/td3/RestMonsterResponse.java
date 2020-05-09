package com.example.td3;

import java.util.List;

public class RestMonsterResponse {
    private Integer count;
    private String next;
    private List<Monster> results;

    public Integer getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public List<Monster> getResults() {
        return results;
    }
}
