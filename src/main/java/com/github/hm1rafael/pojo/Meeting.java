package com.github.hm1rafael.pojo;

public class Meeting {

    public Meeting(String name, Integer time) {
        this.name = name;
        this.duration = time;
    }

    private String name;
    private Integer duration;

    public Integer getDuration() {
        return this.duration;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format(" %s (%d min) ", this.name, this.duration);
    }

}
