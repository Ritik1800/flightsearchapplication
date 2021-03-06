package com.nagarro;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Generated;

@Entity
public class CSVData {
	@Id @GeneratedValue
	int serial_no;
	
	String flight_no;
	String dep_loc;
	String arr_loc;
	String valid_till;
	int flight_time;
	double flight_dur;
	int fare;
	String seat_av;
	String class_av;
	public String getFlight_no() {
		return flight_no;
	}
	public void setFlight_no(String flight_no) {
		this.flight_no = flight_no;
	}
	public String getDep_loc() {
		return dep_loc;
	}
	public void setDep_loc(String dep_loc) {
		this.dep_loc = dep_loc;
	}
	public String getArr_loc() {
		return arr_loc;
	}
	public void setArr_loc(String arr_loc) {
		this.arr_loc = arr_loc;
	}
	public String getValid_till() {
		return valid_till;
	}
	public void setValid_till(String valid_till) {
		this.valid_till = valid_till;
	}
	public int getFlight_time() {
		return flight_time;
	}
	public void setFlight_time(int flight_time) {
		this.flight_time = flight_time;
	}
	public double getFlight_dur() {
		return flight_dur;
	}
	public void setFlight_dur(double flight_dur) {
		this.flight_dur = flight_dur;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public String getSeat_av() {
		return seat_av;
	}
	public void setSeat_av(String seat_av) {
		this.seat_av = seat_av;
	}
	public String getClass_av() {
		return class_av;
	}
	public void setClass_av(String class_av) {
		this.class_av = class_av;
	}
	
}
