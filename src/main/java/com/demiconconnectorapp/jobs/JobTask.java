package com.demiconconnectorapp.jobs;

import com.demiconconnectorapp.models.RandomUser;
import com.demiconconnectorapp.models.ResultsWrapper;
import com.demiconconnectorapp.repositories.RandomUserRepository;
import com.demiconconnectorapp.services.RandomUserWebClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Objects.requireNonNull;

@Component
public class JobTask {

    @Autowired
    private RandomUserWebClientService randomUserWebClientService;

    @Autowired
    private RandomUserRepository randomUserRepository;

    private static final Logger logger = LoggerFactory.getLogger(JobTask.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");


    @Value("${userSize}")
    private Integer userSize;

    @Value("${period}")
    private Integer period;

    @Value("${url}")
    private String url;

    public JobTask(RandomUserWebClientService randomUserWebClientService) {
        this.randomUserWebClientService = requireNonNull(randomUserWebClientService);
    }

    /**
     * The connector's cron job task (running every hour) getting the data from the provided API and storing it in the database
     */
    @Scheduled(cron = "0 0 0/1 1/1 * ?")
    @Transactional
    public void scheduleTaskWithCronExpression() {
        url = url + "?results=" + userSize;
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<?> future = executorService.submit(() -> {
            List<ResultsWrapper> randomUsersData = randomUserWebClientService.getRandomUserFromApi(url);
            logger.info("Connector Job Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
            List<RandomUser> randomUsers = newArrayList(getRandomUsers(randomUsersData));
            randomUsers.forEach(user -> user.setDateModified(new Date()));
            randomUserRepository.saveAll(randomUsers);
            logger.info("### Users successfully stored into the database ###");
        });
        try {
            future.get(period, TimeUnit.SECONDS);
        } catch (TimeoutException | InterruptedException | ExecutionException e) {
            future.cancel(true);
            e.printStackTrace();
        }

    }

    /**
     * gets the data within the results array of the API
     *
     * @param userJsonData
     * @return the results from the API's results JSON
     */
    private List<RandomUser> getRandomUsers(List<ResultsWrapper> userJsonData) {
        if (userJsonData != null) {
            for (ResultsWrapper data : userJsonData) {
                if (data.getResults().size() > 0) {
                    return data.getResults();
                }
            }
        }
        return null;
    }

}
