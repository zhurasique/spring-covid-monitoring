package com.covid.data;

import com.covid.data.domain.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawler {
    private String URL = "https://en.wikipedia.org/wiki/Template:COVID-19_pandemic_data";

    private List<String> countries = new ArrayList<>();
    private List<Integer> cases = new ArrayList<>();
    private List<Integer> deaths = new ArrayList<>();
    private List<Integer> recovered = new ArrayList<>();

    public Crawler() { }

    public void getData() {
        countries();
        stats();
    }

    public void countries(){
        try {
            Document document = Jsoup.connect(URL).get();
            Elements selectedCountries = document.select("table tr th[scope] a[href][title]");
            for (Element page : selectedCountries)
                countries.add(page.text());

            int lastIndex = countries.indexOf("Tanzania") + 1;

            if (countries.size() > lastIndex)
                countries.subList(lastIndex, countries.size()).clear();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stats(){
        List<String> data = new ArrayList<>();
        try {
            Document document = Jsoup.connect(URL).get();
            Elements selectedCountries = document.select("table tr td");

            int count = -1;
            int lastIndex = 0;
            for (Element page : selectedCountries) {
                if(!page.text().startsWith("[")) {
                    data.add(page.text().replace("\n", "").replace(",", "").replace("No data", "-1"));
                    count++;
                }
                if(page.text().contains("History of deaths"))
                    lastIndex = count;
            }

            if (data.size() > lastIndex)
                data.subList(lastIndex, data.size()).clear();

            for(int i = 0; i < data.size(); i++){
                if(i + 2 < data.size()) {
                    cases.add(Integer.parseInt(data.get(i)));
                    i += 2;
                }
            }

            for(int i = 1; i < data.size(); i++){
                if(i + 2 <= data.size()) {
                    deaths.add(Integer.parseInt(data.get(i)));
                    i += 2;
                }
            }

            for(int i = 2; i < data.size(); i++){
                if(i + 2 <= data.size()) {
                    recovered.add(Integer.parseInt(data.get(i)));
                    i += 2;
                }else
                    recovered.add(Integer.parseInt(data.get(data.size() - 1)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> getCases() {
        return cases;
    }

    public List<Integer> getDeaths() {
        return deaths;
    }

    public List<Integer> getRecovered() {
        return recovered;
    }

    public List<String> getCountries() {
        return countries;
    }
}
