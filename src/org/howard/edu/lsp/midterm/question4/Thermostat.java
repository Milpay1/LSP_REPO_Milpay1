package org.howard.edu.lsp.midterm.question4;

public class Thermostat extends Device implements BatteryPowered, Networked {
    private int batteryPercent;
    private double temperatureC;

    public Thermostat(String id, String location, double initialTempC) {
        super(id, location);
        this.batteryPercent = 100; // Default battery percent
        this.temperatureC = initialTempC; // Default temperature
    }

    @Override
    public int getBatteryPercent() {
        return batteryPercent;
    }

    @Override
    public void setBatteryPercent(int percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Battery percent must be between 0 and 100");
        }
        this.batteryPercent = percent;
    }

    @Override
    public void connect() {
        setConnected(true);
    }

    @Override
    public void disconnect() {
        setConnected(false);
    }

    @Override
    public String getStatus() {
        return "Thermostat at " + getLocation() + " is " + (isConnected() ? "connected" : "disconnected") +
               ", Battery: " + batteryPercent + "%, Temperature: " + temperatureC + "°F";
    }

    public double getTempC() {
        return temperatureC;
    }

    public void setTempC(double temperature) {
        this.temperatureC = temperature;
    }

    @Override public boolean isConnected() { return super.isConnected(); }
    

}
