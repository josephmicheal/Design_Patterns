package com.structural.bridge;

public class BridgeDesignPatternApp {

	public static void main(String[] args) {
        testDevice(new TV());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        basicRemote.volumeUp();
        basicRemote.channelUp();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}

interface Device {
	boolean isEnabled();

	void enable();

	void disable();

	int getVolume();

	void setVolume(int percent);

	int getChannel();

	void setChannel(int channel);

	void printStatus();
}

interface Remote {
	void power();

	void volumeDown();

	void volumeUp();

	void channelDown();

	void channelUp();
}

class TV implements Device {

	private boolean enable;
	private int volume;
	private int channel;

	@Override
	public boolean isEnabled() {

		return enable;
	}

	@Override
	public void enable() {

		this.enable = true;
	}

	@Override
	public void disable() {

		this.enable = false;
	}

	@Override
	public int getVolume() {

		return this.volume;
	}

	@Override
	public void setVolume(int volume) {

		this.volume = volume;
	}

	@Override
	public int getChannel() {

		return this.channel;
	}

	@Override
	public void setChannel(int channel) {
		this.channel = channel;
	}

	@Override
	public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm TV set.");
        System.out.println("| I'm " + (enable ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + volume + "%");
        System.out.println("| Current channel is " + channel);
        System.out.println("------------------------------------\n");
	}

}

class Radio implements Device {

	private boolean enable;
	private int volume;
	private int channel;

	@Override
	public boolean isEnabled() {

		return enable;
	}

	@Override
	public void enable() {

		this.enable = true;
	}

	@Override
	public void disable() {

		this.enable = false;
	}

	@Override
	public int getVolume() {

		return this.volume;
	}

	@Override
	public void setVolume(int volume) {

		this.volume = volume;
	}

	@Override
	public int getChannel() {

		return this.channel;
	}

	@Override
	public void setChannel(int channel) {
		this.channel = channel;
	}

	@Override
	public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm TV set.");
        System.out.println("| I'm " + (enable ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + volume + "%");
        System.out.println("| Current channel is " + channel);
        System.out.println("------------------------------------\n");
	}

}

class BasicRemote implements Remote {

	Device device;

	public BasicRemote(Device device2) {
		// TODO Auto-generated constructor stub
		this.device = device2;
	}

	@Override
	public void power() {

		device.enable();
	}

	@Override
	public void volumeDown() {

		device.setVolume(device.getVolume() - 10);
	}

	@Override
	public void volumeUp() {

		device.setVolume(device.getVolume() + 10);
	}

	@Override
	public void channelDown() {

		device.setChannel(device.getChannel() - 1);
	}

	@Override
	public void channelUp() {

		device.setChannel(device.getChannel() + 1);
	}

}

class AdvancedRemote extends BasicRemote {
	public AdvancedRemote(Device device) {
		super(device);
	}

	public void mute() {
		super.device.setVolume(0);
	}
}
