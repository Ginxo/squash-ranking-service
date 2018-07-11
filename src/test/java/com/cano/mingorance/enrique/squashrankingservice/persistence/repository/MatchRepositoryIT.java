package com.cano.mingorance.enrique.squashrankingservice.persistence.repository;

import com.cano.mingorance.enrique.squashrankingservice.persistence.entity.Match;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
public class MatchRepositoryIT {

    @Autowired
    private MatchRepository repository;

    @Test
    @DatabaseSetup("/db/match/initial.xml")
    public void testFindAll() {
        // Act
        final List<Match> all = (List<Match>) repository.findAll();

        // Assert
        Assert.assertEquals(3, all.size());
        Assert.assertEquals(3, all.get(0).getMatchSets().size());
        Assert.assertEquals(2, all.get(1).getMatchSets().size());
        Assert.assertEquals(1, all.get(2).getMatchSets().size());
        Assert.assertNotNull(all.get(0).getPlayer1());
        Assert.assertNotNull(all.get(0).getPlayer2());
        Assert.assertNotNull(all.get(0).getWinner());
        Assert.assertNotNull(all.get(0).getLoser());
    }

    @Test
    @DatabaseSetup("/db/match/initial.xml")
    public void testFindMatchesBetweenDates() {
        // Arrange
        GregorianCalendar gcDate1 = new GregorianCalendar();
        gcDate1.set(GregorianCalendar.YEAR, 2018);
        gcDate1.set(GregorianCalendar.MONTH, 1);
        gcDate1.set(GregorianCalendar.DATE, 1);

        GregorianCalendar gcDate2 = new GregorianCalendar();
        gcDate2.set(GregorianCalendar.YEAR, 2018);
        gcDate2.set(GregorianCalendar.MONTH, 12);
        gcDate2.set(GregorianCalendar.DATE, 31);
        // Act
        final List<Match> all = (List<Match>) repository.findByMatchDateBetween(gcDate1.getTime(), gcDate2.getTime());

        // Assert
        Assert.assertEquals(1, all.size());
    }
}
