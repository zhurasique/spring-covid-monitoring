package com.covid.data;

import com.covid.data.service.DataService;

public class Async extends Thread {
   public final DataService dataService;

    public Async(DataService dataService) {
        this.dataService = dataService;
    }

    public void run() {
        while (true) {
            dataService.save();

            try {
                Thread.sleep((5 * 60) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
