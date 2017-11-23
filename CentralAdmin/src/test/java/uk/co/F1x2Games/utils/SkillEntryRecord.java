package uk.co.F1x2Games.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SkillEntryRecord {

    private String skill;
    private String level;
    private String application;
    private String interest;
    private String comment;
    private String date;

    public SkillEntryRecord(String inSkill, String inLevel, String inApplication, String inInterest, String inComment,
            String inDate) {
        skill = inSkill;
        level = inLevel;
        application = inApplication;
        interest = inInterest;
        comment = inComment;
        date = inDate;
    }

    public SkillEntryRecord() {

    }

    public void setSkill(String inSkill) {

        skill = inSkill;
    }

    public String getSkill() {

        return skill;
    }

    public void setLevel(String inLevel) {

        level = inLevel;
    }

    public String getLevel() {

        return level;
    }

    public void setApplication(String inApplication) {

        application = inApplication;
    }

    public String getApplication() {

        return application;
    }

    public void setInterest(String inInterest) {

        interest = inInterest;
    }

    public String getInterest() {

        return interest;
    }

    public void setComment(String inComment) {

        comment = inComment;
    }

    public String getComment() {

        return comment;
    }

    public void setDate(String inDate) {

        date = inDate;
    }

    public String getDate() {

        return date;
    }

    public String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String date = sdf.format(new Date());
        return date;
    }
}
