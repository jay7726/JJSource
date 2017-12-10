package com.seri;

import java.io.Serializable;

public class SeriVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String birth;
	private int score;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return String.format("%5s %10s %4d",
				name,birth,score);
	}
	
}
