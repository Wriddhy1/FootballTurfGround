package com.oop.footballturfground;

public class Teamname {
    private String teamname;
    private String phonenumber;
    private String time;

    public Teamname(String teamname, String phonenumber, String time) {
        this.teamname = teamname;
        this.phonenumber = phonenumber;
        this.time = time;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Teamname{" +
                "teamname='" + teamname + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", time=" + time +
                '}';
    }
}
