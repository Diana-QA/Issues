package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IssueManager {
    private IssueRepository repository;

    public IssueManager() {
    }

    public IssueManager(IssueRepository repository) {
        this.repository = repository;
    }

    public Predicate<Issue> byAuthor(String author) {
        return p -> p.getAuthor().equalsIgnoreCase(author);
    }

    public Predicate<Issue> byLabel(String label) {
        return p -> p.getLabel().contains(label);
    }

    public Predicate<Issue> byAssignee(String assignee) {
        return p -> p.getAssignee().contains(assignee);
    }

    public List<Issue> filterIssues(List<Issue> issues, Predicate<Issue> predicate) {
        return issues.stream().filter(predicate).collect(Collectors.toList());
    }

    public List<Issue> sortByIssue(List<Issue> sorted) {
        Collections.sort(sorted);
        return sorted;
    }

    public List<Issue> filterByAuthor(String author) {
        return sortByIssue(filterIssues(repository.findAll(), byAuthor(author)));
    }

    public List<Issue> filterByLabel(String label) {
        return sortByIssue(filterIssues(repository.findAll(), byAuthor(label)));
    }

    public List<Issue> filterByAssignee(String assignee) {
        return sortByIssue(filterIssues(repository.findAll(), byAuthor(assignee)));
    }
}
