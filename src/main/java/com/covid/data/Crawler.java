package com.covid.data;

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
        //getCountries();
        getStats();
    }

    public void getCountries(){
        try {
            Document document = Jsoup.connect(URL).get();
            Elements selectedCountries = document.select("table tr th[scope] a[href][title]");
            for (Element page : selectedCountries) {
                countries.add(page.text());
            }

            int lastIndex = countries.indexOf("Tanzania") + 1;

            if (countries.size() > lastIndex) {
                countries.subList(lastIndex, countries.size()).clear();
            }

            for(String st : countries){
                System.out.println(st + " " + countries.lastIndexOf(st));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getStats(){
        List<String> data = new ArrayList<>();
        try {
            Document document = Jsoup.connect(URL).get();
            Elements selectedCountries = document.select("table tr td");

            for (Element page : selectedCountries) {
//                if(!page.text().startsWith("[")) {
//                    System.out.println(page.text());
//                }
                if(page.text().contains("History of deaths")){
                    System.out.println(page.text());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
