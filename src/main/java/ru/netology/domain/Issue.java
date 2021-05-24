package ru.netology.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Issue implements Comparable<Issue>{
    private int id;
    private String author;
    private Set<String> label = new HashSet<>();
    private Set<String> assignee = new HashSet<>();
    private boolean open;
    private Date timeDaysAgo;

    public Issue() {
    }

    public Issue(int id, String author, Set<String> label, Set<String> assignee, boolean open, Date timeDaysAgo) {
        this.id = id;
        this.author = author;
        this.label = label;
        this.assignee = assignee;
        this.open = open;
        this.timeDaysAgo = timeDaysAgo;
    }

    public Issue(int id, boolean open, Date timeDaysAgo) {
        this.id = id;
        this.open = open;
        this.timeDaysAgo = timeDaysAgo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Set<String> getLabel() {
        return label;
    }

    public void setLabel(Set<String> label) {
        this.label = label;
    }

    public Set<String> getAssignee() {
        return assignee;
    }

    public void setAssignee(Set<String> assignee) {
        this.assignee = assignee;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Date getTimeDaysAgo() {
        return timeDaysAgo;
    }

    public void setTimeDaysAgo(Date timeDaysAgo) {
        this.timeDaysAgo = timeDaysAgo;
    }

    @Override
    public int compareTo(Issue o) {
        return o.timeDaysAgo.compareTo(timeDaysAgo);
    }
}
