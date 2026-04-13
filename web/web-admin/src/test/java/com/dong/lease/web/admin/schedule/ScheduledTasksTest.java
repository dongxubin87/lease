package com.dong.lease.web.admin.schedule;

import com.dong.lease.model.entity.LeaseAgreement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ScheduledTasksTest {

    @Autowired
    private ScheduledTasks scheduledTasks;

    @Test
    public void test() {
        scheduledTasks.checkLeaseStatus();
    }


}