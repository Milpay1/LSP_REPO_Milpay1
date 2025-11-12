1:
Device is defined as an abstract class because it represents a general concept (a generic “device”) that provides common attributes and behavior for all specific device types (like DoorLock, Thermostat, Camera, etc.), but it is not meant to be instantiated on its own.

2:
The interfaces define what the devices have but not how they have it. It shows that they will be connected to a network and a battery with a percent. 

3:
It shows it through the use of its interfaces. The subclasses are Devices, they are Networked, and they are BatteryPowered and they inherit the aspects of all three. 