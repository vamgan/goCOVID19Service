package com.tracker.gocovid19service.model;

public class MongoDumpObject {
    private final long timeRequested;
    private final String requestURL;
    private final String responseFromAPI;
    private final long apiResponseTime;

    public MongoDumpObject(String requestURL, long timeRequested, String responseFromAPI, long apiResponseTime){

        this.timeRequested = timeRequested;
        this.requestURL = requestURL;
        this.responseFromAPI = responseFromAPI;
        this.apiResponseTime = apiResponseTime;
    }

    public long getTimeRequested() {
        return timeRequested;
    }

    public String getRequestURL() {
        return requestURL;
    }

    public String getResponseFromAPI() {
        return responseFromAPI;
    }

    public long getApiResponseTime() {
        return apiResponseTime;
    }



}
