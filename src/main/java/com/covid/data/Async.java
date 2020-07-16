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

            Data data = new Data();
            for(int i = 0; i < countries.size(); i++){
                data.setCountry(countries.get(i));
                data.setCases(cases.get(i));
                data.setDeaths(deaths.get(i));
                data.setRecovered(recovered.get(i));

                if(dataService.getDataByCountry(data.getCountry()) != null)
                    dataService.update(dataService.getDataByCountry(data.getCountry()), data);
                else
                    dataService.save(data.getCountry(), data.getCases(), data.getDeaths(), data.getRecovered());
            }

            try {
                Thread.sleep( 5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
