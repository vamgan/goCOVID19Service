package com.tracker.gocovid19service.controller;

import com.tracker.gocovid19service.GetFromAPI;
import org.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@RestController
public class covidResource {

    @RequestMapping (value = "/world", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String getWorld() throws IOException, JSONException {
        long startTime = System.currentTimeMillis();
        final String requestForWorld = GetFromAPI.getRequestForWorld();
        long totalTime = System.currentTimeMillis() - startTime;
        MongoDBDump.dumpRequest("https://disease.sh/v3/covid-19/all",requestForWorld, totalTime);
        return requestForWorld;
    }

    @RequestMapping (value = "/state/{stateName}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String getState(@PathVariable("stateName") String stateName) throws IOException, JSONException {
        long startTime = System.currentTimeMillis();
        final String requestForState = GetFromAPI.getRequestForState(stateName);
        long totalTime = System.currentTimeMillis() - startTime;
        MongoDBDump.dumpRequest("https://disease.sh/v3/covid-19/states/",requestForState, totalTime);
        return requestForState;
    }

    @RequestMapping (value = "/country/{countryName}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String getCountry(@PathVariable("countryName") String countryName) throws IOException, JSONException {
        long startTime = System.currentTimeMillis();
        final String requestForCountry = GetFromAPI.getRequestForCountry(countryName);
        long totalTime = System.currentTimeMillis() - startTime;
        MongoDBDump.dumpRequest("https://disease.sh/v3/covid-19/countries/",requestForCountry, totalTime);
        return requestForCountry;
    }

}
