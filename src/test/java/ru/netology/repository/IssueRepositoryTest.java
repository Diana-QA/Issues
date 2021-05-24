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
    private Issue issue1 = new Issue(1, false, sdf.parse("2021-03-23"));
    private Issue issue2 = new Issue(2, true, sdf.parse("2021-04-02"));
    private Issue issue3 = new Issue(3, true, sdf.parse("2021-04-12"));
    private Issue issue4 = new Issue(4, false, sdf.parse("2021-05-09"));
    private Issue issue5 = new Issue(5, true, sdf.parse("2021-05-23"));

    IssueRepositoryTest() throws ParseException {
    }

    @BeforeEach
    void setUp() {
        List<Issue> issues = new ArrayList<>();
        repository.add(issue1);
        repository.add(issue2);
        repository.add(issue3);
        repository.add(issue4);
        repository.add(issue5);
    }

}