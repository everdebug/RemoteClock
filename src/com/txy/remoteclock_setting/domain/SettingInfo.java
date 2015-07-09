package com.txy.remoteclock_setting.domain;
//…Ë÷√bean
public class SettingInfo {

	private String number = null;
	private String bingingCode = null;
	private int musicSourse = 0;
	private String wakeupText = null;

	public SettingInfo() {
	}

	public SettingInfo(String number, String bingingCode, int musicSourse,
			String wakeupText) {
		super();
		this.number = number;
		this.bingingCode = bingingCode;
		this.musicSourse = musicSourse;
		this.wakeupText = wakeupText;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBingingCode() {
		return bingingCode;
	}

	public void setBingingCode(String bingingCode) {
		this.bingingCode = bingingCode;
	}

	public int getMusicSourse() {
		return musicSourse;
	}

	public void setMusicSourse(int musicSourse) {
		this.musicSourse = musicSourse;
	}

	public String getWakeupText() {
		return wakeupText;
	}

	public void setWakeupText(String wakeupText) {
		this.wakeupText = wakeupText;
	}

}
