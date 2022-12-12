package com.xuegao.remind.remind.job;

import com.xuegao.remind.RemindServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = RemindServiceApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRemindScheduled {

    @Autowired
    private RemindScheduled remindScheduled;

    @Test
    public void coreScheduledByMorning() {
        remindScheduled.coreScheduledByMorning();
    }

    @Test
    public void coreScheduledByEvening() {
        remindScheduled.coreScheduledByEvening();
    }
}
