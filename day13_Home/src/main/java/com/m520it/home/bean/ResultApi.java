package com.m520it.home.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class ResultApi implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int state;
	private String msg;
	private ArrayList<HomeBean> date;

	@Override
	public String toString() {
		return "ResultApi [state=" + state + ", msg=" + msg + ", date=" + date + "]";
	}

	public int getState() {
		return state;
	}

	public String getMsg() {
		return msg;
	}

	public ArrayList<HomeBean> getDate() {
		return date;
	}

}
