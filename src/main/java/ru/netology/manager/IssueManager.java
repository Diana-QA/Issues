package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IssueManager {
    private IssueRepository repository;

    public IssueManager() {
    }

    public IssueManager(IssueRepository repository) {
        this.repository = repository;
    }

    public boolean addAll(List<? extends Issue> items) {
        return this.repository.addAll(items);
    }

    public List<Issue> findByAuthor(String author) {
        Predicate<String> byAuthor = Predicate.isEqual(author);
        List<Issue> issues = new ArrayList<>();
        for (Issue item : repository.findAll())
            if (byAuthor.test(item.getAuthor())) {
                issues.add(item);
            }
        return issues;
    }

    public List<Issue> findByLabel(Set<String> label) {
        Predicate<Set<String>> byLabel = p -> p.containsAll(label);
        List<Issue> issues = new ArrayList<>();
        for (Issue item : repository.findAll())
            if (byLabel.test(item.getLabel())) {
                issues.add(item);
            }
        return issues;
    }

    public List<Issue> findByAssignee(Set<String> assignee) {
        Predicate<Set<String>> byAssignee = p -> p.containsAll(assignee);
        List<Issue> issues = new ArrayList<>();
        for (Issue item : repository.findAll())
            if (byAssignee.test(item.getAssignee())) {
                issues.add(item);
            }
        return issues;
    }

    public List<Issue> sortByNewest() {
        Comparator byNewest = Comparator.naturalOrder();
        List<Issue> issues = new ArrayList<>();
        issues.addAll(repository.findAll());
        issues.sort(byNewest);
        return issues;
    }

    public List<Issue> sortByOldest() {
        Comparator byOldest = Comparator.reverseOrder();
        List<Issue> issues = new ArrayList<>();
        issues.addAll(repository.findAll());
        issues.sort(byOldest);
        return issues;
    }
}
