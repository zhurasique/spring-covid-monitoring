package com.covid.data;

import com.covid.data.domain.Data;
import com.covid.data.service.DataService;

import java.util.List;

public class Async extends Thread {
   public final DataService dataService;

    public Async(DataService dataService) {
        this.dataService = dataService;
    }

    public void run() {
        while (true) {
            Crawler crawler = new Crawler();
            crawler.getData();

            List<String> countries = crawler.getCountries();
            List<Integer> cases = crawler.getCases();
            List<Integer> deaths = crawler.getDeaths();
            List<Integer> recovered = crawler.getRecovered();


            for(int i = 0; i < countries.size(); i++){
                dataService.save(countries.get(i), cases.get(i), deaths.get(i), recovered.get(i));
            }

            try {
                Thread.sleep((5 * 60) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
