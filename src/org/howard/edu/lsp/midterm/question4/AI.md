I used AI to ensure that the super was properly constructed in the constructor of my subclasses. I also used to gain insight for how to answer the written portion of this question.

My prompts and their responses:
Given this DoorLock subclass constructor:
    public DoorLock(String name) {
        super(getId(), getLocation());
        this.connected = false;
        this.batteryPercent = 100; // Assume new device starts with full battery
    }
and the Device class:
package org.howard.edu.lsp.midterm.question4;

public abstract class Device {
  private String id;
  private String location;
  private long lastHeartbeatEpochSeconds;
  private boolean connected;

  // PROVIDED CONSTRUCTOR
  public Device(String id, String location) {
    if (id == null || id.isEmpty() || location == null || location.isEmpty()) {
      throw new IllegalArgumentException("Invalid id or location");
    }
    this.id = id;
    this.location = location;
    this.lastHeartbeatEpochSeconds = 0;
    this.connected = false;
  }

  public String getId() {
    return id;
  }

  public String getLocation() {
    return location;
  }



  public long getLastHeartbeatEpochSeconds() {
    return lastHeartbeatEpochSeconds;
  }

  public boolean isConnected() {
    return connected;
  }

  protected void setConnected(boolean connected) {
    this.connected = connected;
  }

  public void heartbeat() {
    this.lastHeartbeatEpochSeconds = System.currentTimeMillis() / 1000;
  }

  public abstract String getStatus();
}

Call super(id, location) in the constructor of DoorLock

package org.howard.edu.lsp.midterm.question4;

public class DoorLock extends Device {
    private boolean connected;
    private int batteryPercent;

    // Correct constructor — takes id and location as parameters
    public DoorLock(String id, String location) {
        super(id, location);  // Proper call to Device constructor
        this.connected = false;
        this.batteryPercent = 100; // Assume new device starts with full battery
    }

    @Override
    public String getStatus() {
        return "DoorLock " + getId() + " at " + getLocation() +
               " is " + (isConnected() ? "connected" : "disconnected") +
               " with battery " + batteryPercent + "%";
    }
}

Why is Device defined as an abstract class? 

Device is defined as an abstract class because it represents a general concept (a generic “device”) that provides common attributes and behavior for all specific device types (like DoorLock, Thermostat, Camera, etc.), but it is not meant to be instantiated on its own.

This is a subclass the following questions will be around it and its use of interfaces:
package org.howard.edu.lsp.midterm.question4;

public class DoorLock extends Device implements Networked, BatteryPowered {
    private int batteryPercent;

    public DoorLock(String id, String location, int initialBatteryPercent) {
        super(id, location);
        // Initialize battery percent with setter to enforce validation
        setBatteryPercent(initialBatteryPercent);
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

    @Override public int getBatteryPercent() { return batteryPercent; }
    @Override public void setBatteryPercent(int percent) {
    if (percent < 0 || percent > 100) throw new IllegalArgumentException("battery 0..100");
    this.batteryPercent = percent;
    }

    @Override public String getStatus() {
    String connStatus = isConnected() ? "up" : "down";
    return "DoorLock[id=" + getId() + ", loc=" + getLocation() +
            ", conn=" + connStatus + ", batt=" + batteryPercent + "%]";
    }
    
    



    

}

	•	How do the Networked and BatteryPowered interfaces add behavior to your concrete classes?
	•	Is this design an example of multiple inheritance in Java? Explain why or why not.

The interfaces don’t add state (data fields), but they add abilities — they let your class promise “I can do these things,” and you define how those things are done.

This design shows multiple inheritance of behavior (via interfaces), not multiple inheritance of code.
It’s safe and flexible because there’s no ambiguity or conflict from inheriting actual method bodies (as can happen in languages like C++).

Could you further describe the multiple inheritance via interfaces

Java supports single inheritance of implementation (extends one class)
and multiple inheritance of type/behavior (implements many interfaces).

This lets classes like DoorLock act in multiple roles safely.

The interfaces add flexible, modular behavior definitions without the risk of conflicting code.
