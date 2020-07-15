package com.covid.data;

import com.covid.data.service.DataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DataApplication {
    private static DataService dataService;

    public DataApplication(DataService dataService) {
        this.dataService = dataService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DataApplication.class, args);

        Crawler crawler = new Crawler();
        crawler.getPageLinks("http://www.mkyong.com/", 0);

        //Async async = new Async(dataService);
        //async.start();
    }
}
