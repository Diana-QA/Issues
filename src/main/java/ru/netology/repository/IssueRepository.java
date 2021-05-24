package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.List;

public class IssueRepository {
    private List<Issue> items = new ArrayList<>();

    public boolean add(Issue item) {
        return items.add(item);
    }

    public boolean addAll(List<? extends Issue> items) {
        return this.items.addAll(items);
    }

    public List<Issue> findAll() {
        return items;
    }

    public void openIssueById(int id) {
        for (Issue item : items) {
            if (item.getId() == id && item.isOpen()) {
                item.setOpen(false);
            }
        }
    }

    public void closedIssueById(int id) {
        for (Issue item : items) {
            if (item.getId() == id && !item.isOpen()) {
                item.setOpen(true);
            }
        }
    }

    public List<Issue> getOpenIssue() {
        List<Issue> issues = new ArrayList<>();
        for (Issue item : findAll()) {
            if (item.isOpen()) {
                issues.add(item);
            }
        }
        return issues;
    }

    public List<Issue> getClosedIssue() {
        List<Issue> issues = new ArrayList<>();
        for (Issue item : findAll()) {
            if (!item.isOpen()) {
                issues.add(item);
            }
        }
        return issues;
    }
}