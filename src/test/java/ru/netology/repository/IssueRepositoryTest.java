package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IssueRepositoryTest {
    private IssueRepository repository = new IssueRepository();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private final Issue issue1 = new Issue(1, false, sdf.parse("2021-03-23"));
    private final Issue issue2 = new Issue(2, true, sdf.parse("2021-04-02"));
    private final Issue issue3 = new Issue(3, true, sdf.parse("2021-04-12"));
    private final Issue issue4 = new Issue(4, false, sdf.parse("2021-05-09"));
    private final Issue issue5 = new Issue(5, true, sdf.parse("2021-05-23"));

    IssueRepositoryTest() throws ParseException {
    }

    @BeforeEach
    void setUp() {
        repository.addAll(List.of(issue1, issue2, issue3, issue4, issue5));
    }

    @Test
    void shouldOpenIssue() {
        List<Issue> actual = repository.getOpenIssue();
        List<Issue> expected = List.of(issue2, issue3, issue5);
        assertEquals(actual, expected);
    }

    @Test
    void shouldClosedIssue() {
        List<Issue> actual = repository.getClosedIssue();
        List<Issue> expected = List.of(issue1, issue4);
        assertEquals(actual, expected);
    }

    @Test
    void shouldOpenIssuesById() {
        repository.openIssueById(1);
        List<Issue> actual = repository.getOpenIssue();
        List<Issue> expected = List.of(issue1, issue2, issue3, issue5);
        assertEquals(actual, expected);
    }

    @Test
    void shouldClosedIssuesById() {
        repository.closedIssueById(5);
        List<Issue> actual = repository.getClosedIssue();
        List<Issue> expected = List.of(issue1, issue4, issue5);
        assertEquals(actual, expected);
    }

    @Test
    void shouldNonExistentIssue() {
        repository.closedIssueById(6);
        List<Issue> actual = repository.getClosedIssue();
        List<Issue> expected = List.of(issue1, issue4);
        assertEquals(actual, expected);
    }

    @Test
    void shouldOpenIssueById() {
        repository.openIssueById(3);
        List<Issue> actual = repository.getOpenIssue();
        List<Issue> expected = List.of(issue2, issue3, issue5);
        assertEquals(actual, expected);
    }

    @Test
    void shouldClosedIssueById() {
        repository.closedIssueById(4);
        List<Issue> actual = repository.getClosedIssue();
        List<Issue> expected = List.of(issue1, issue4);
        assertEquals(actual, expected);
    }
}