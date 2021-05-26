package ru.netology.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Issue implements Comparable<Issue>{
    private int id;
    private String author;
    private Set<String> label;
    private Set<String> assignee;
    private boolean isOpen;
    private Date timeDaysAgo;

    public Issue() {
    }

    public Issue(int id, String author, Set<String> label, Set<String> assignee, boolean isOpen, Date timeDaysAgo) {
        this.id = id;
        this.author = author;
        this.label = label;
        this.assignee = assignee;
        this.isOpen = isOpen;
        this.timeDaysAgo = timeDaysAgo;
    }

    public Issue(int id, boolean open, Date timeDaysAgo) {
        this.id = id;
        this.isOpen = open;
        this.timeDaysAgo = timeDaysAgo;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public Set<String> getLabel() {
        return label;
    }

    public Set<String> getAssignee() {
        return assignee;
    }

    public boolean isOpen() {
        return isOpen;
    }


    public void setOpen(boolean open) {
        this.isOpen = open;
    }

    @Override
    public int compareTo(Issue o) {
        return o.timeDaysAgo.compareTo(timeDaysAgo);
    }
}
