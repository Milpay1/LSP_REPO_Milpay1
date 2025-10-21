package org.howard.edu.lsp.midterm.question4;

public class Camera extends Device implements Networked, BatteryPowered {
    private int batteryPercent;

    public Camera(String id, String location) {
        super(id, location);
        this.batteryPercent = 100; // Assume new device starts with full battery
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
    public boolean isConnected() {
        return super.isConnected(); 
    }

    @Override
    public int getBatteryPercent() {
        return this.batteryPercent;
    }

    @Override
    public void setBatteryPercent(int percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Battery percent must be between 0 and 100");
        }
        this.batteryPercent = percent;
    }

    @Override public String getStatus() {
    String connStatus = isConnected() ? "up" : "down";
    return "Camera[id=" + getId() + ", loc=" + getLocation() +
            ", conn=" + connStatus + ", batt=" + batteryPercent + "%]";
    }


}
