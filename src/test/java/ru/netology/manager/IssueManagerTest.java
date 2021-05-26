package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.VerificationOverTimeImpl;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class IssueManagerTest {
    IssueRepository repository = new IssueRepository();
    IssueManager manager = new IssueManager(repository);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private final Issue issue1 = new Issue(1, "Diana", Set.of("Kotlin"), Set.of("Mike"), true, sdf.parse("2021-05-23"));
    private final Issue issue2 = new Issue(2, "Pavle", Set.of("Jupiter"), Set.of("Mark"), true, sdf.parse("2020-07-06"));
    private final Issue issue3 = new Issue(3, "Peter", Set.of("Platform"), Set.of("Vadim"), false, sdf.parse("2018-09-17"));
    private final Issue issue4 = new Issue(4, "Ani", Set.of("Kotlin"), Set.of("Mark"), true, sdf.parse("2021-03-28"));
    private final Issue issue5 = new Issue(5, "Bob", Set.of("Vintage"), Set.of("Mark"), false, sdf.parse("2019-01-15"));

    IssueManagerTest() throws ParseException {
    }

    @BeforeEach
    void setUp() {
        manager.addAll(List.of(issue1, issue2, issue3, issue4, issue5));
    }

    @Test
    void shouldFilterByAuthor() {
        List<Issue> actual = manager.findByAuthor("Bob");
        List<Issue> expected = List.of(issue5);
        assertEquals(actual, expected);
    }

    @Test
    void shouldFilterByLabel() {
        List<Issue> actual = manager.findByLabel(new HashSet<>(Arrays.asList("Kotlin")));
        List<Issue> expected = List.of(issue1, issue4);
        assertEquals(actual, expected);
    }

    @Test
    void shouldFilterByAssignee() {
        List<Issue> actual = manager.findByAssignee(new HashSet<>(Arrays.asList("Mark")));
        List<Issue> expected = List.of(issue2, issue4, issue5);
        assertEquals(actual, expected);
    }

    @Test
    void shouldSortByNewest() {
        List<Issue> actual = manager.sortByNewest();
        List<Issue> expected = List.of(issue1, issue4, issue2, issue5, issue3);
        assertEquals(actual, expected);
    }

    @Test
    void shouldSortByOldest() {
        List<Issue> actual = manager.sortByOldest();
        List<Issue> expected = List.of(issue3, issue5, issue2, issue4, issue1);
        assertEquals(actual, expected);
    }
}