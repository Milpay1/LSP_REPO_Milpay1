package org.howard.edu.lsp.midterm.question4;

public class DoorLock extends Device implements Networked, BatteryPowered {
    private boolean connected;
    private int batteryPercent;

    public DoorLock(String id, String location) {
        super(id, location);
        this.connected = false;
        this.batteryPercent = 100; // Assume new device starts with full battery
    }

    @Override
    public void connect() {
        this.connected = true;
        setConnected(true);
    }

    @Override
    public void disconnect() {
        this.connected = false;
        setConnected(false);
    }

    @Override
    public boolean isConnected() {
        return this.connected; 
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

    @Override
    public String getStatus() {
        return "DoorLock [connected=" + connected + ", batteryPercent=" + batteryPercent + "%]";
    }
    
    



    

}
