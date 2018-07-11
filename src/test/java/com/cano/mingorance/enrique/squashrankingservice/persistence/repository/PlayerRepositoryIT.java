package com.cano.mingorance.enrique.squashrankingservice.persistence.repository;

import com.cano.mingorance.enrique.squashrankingservice.persistence.entity.Player;
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

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
public class PlayerRepositoryIT {

    @Autowired
    private PlayerRepository repository;

    @Test
    @DatabaseSetup("/db/player/initial.xml")
    public void testFindAll() {
        // Act
        final List<Player> all = (List<Player>) repository.findAll();

        // Assert
        Assert.assertEquals(2, all.size());
    }

    @Test
    @DatabaseSetup("/db/player/initial.xml")
    public void testDelete() {
        // Act
        repository.deleteById(1L);

        // Assert
        Assert.assertTrue(repository.findById(1L).get().getIsDeleted());
    }
}
