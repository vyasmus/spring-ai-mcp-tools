package org.example.model;

public class Current{
    public String time;
    public int interval;
    public int temperature_2m;

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTemperature_2m() {
        return temperature_2m;
    }

    public void setTemperature_2m(int temperature_2m) {
        this.temperature_2m = temperature_2m;
    }
}
