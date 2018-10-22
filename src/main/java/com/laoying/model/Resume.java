package com.laoying.model;

import java.io.Serializable;

public class Resume implements Serializable {
    private int res_id;
    private String res_name;
    private int res_age;
    private String res_gender;
    private String res_phone;
    private String res_birth;
    private String res_education;//学历
    private String res_email;
    private String res_address;
    private String res_work_experience;
    private String res_job_intention;
    private String res_about_me;
    private String res_major;
    private String res_idCard;
    private String res_hopeSalary;
    private String res_education_background;//教育经历
    private int u_id;//游客的id

    public Resume() {
    }

    public Resume(int res_id, String res_name, int res_age, String res_gender, String res_phone,
                  String res_birth, String res_education, String res_email, String res_address,
                  String res_work_experience, String res_job_intention, String res_about_me,
                  String res_major, String res_idCard, String res_hopeSalary,
                  String res_education_background,int u_id) {
        this.res_id = res_id;
        this.res_name = res_name;
        this.res_age = res_age;
        this.res_gender = res_gender;
        this.res_phone = res_phone;
        this.res_birth = res_birth;
        this.res_education = res_education;
        this.res_email = res_email;
        this.res_address = res_address;
        this.res_work_experience = res_work_experience;
        this.res_job_intention = res_job_intention;
        this.res_about_me = res_about_me;
        this.res_major = res_major;
        this.res_idCard = res_idCard;
        this.res_hopeSalary = res_hopeSalary;
        this.res_education_background = res_education_background;
        this.u_id = u_id;
    }

    public Resume(String res_name, int res_age, String res_gender,
                  String res_phone, String res_birth, String res_education,
                  String res_email, String res_address, String res_work_experience,
                  String res_job_intention, String res_about_me, String res_major,
                  String res_idCard, String res_hopeSalary, String res_education_background,int u_id) {
        this.res_name = res_name;
        this.res_age = res_age;
        this.res_gender = res_gender;
        this.res_phone = res_phone;
        this.res_birth = res_birth;
        this.res_education = res_education;
        this.res_email = res_email;
        this.res_address = res_address;
        this.res_work_experience = res_work_experience;
        this.res_job_intention = res_job_intention;
        this.res_about_me = res_about_me;
        this.res_major = res_major;
        this.res_idCard = res_idCard;
        this.res_hopeSalary = res_hopeSalary;
        this.res_education_background = res_education_background;
        this.u_id = u_id;
    }

    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }

    public String getRes_name() {
        return res_name;
    }

    public void setRes_name(String res_name) {
        this.res_name = res_name;
    }

    public int getRes_age() {
        return res_age;
    }

    public void setRes_age(int res_age) {
        this.res_age = res_age;
    }

    public String getRes_gender() {
        return res_gender;
    }

    public void setRes_gender(String res_gender) {
        this.res_gender = res_gender;
    }

    public String getRes_phone() {
        return res_phone;
    }

    public void setRes_phone(String res_phone) {
        this.res_phone = res_phone;
    }

    public String getRes_birth() {
        return res_birth;
    }

    public void setRes_birth(String res_birth) {
        this.res_birth = res_birth;
    }

    public String getRes_education() {
        return res_education;
    }

    public void setRes_education(String res_education) {
        this.res_education = res_education;
    }

    public String getRes_email() {
        return res_email;
    }

    public void setRes_email(String res_email) {
        this.res_email = res_email;
    }

    public String getRes_address() {
        return res_address;
    }

    public void setRes_address(String res_address) {
        this.res_address = res_address;
    }

    public String getRes_work_experience() {
        return res_work_experience;
    }

    public void setRes_work_experience(String res_work_experience) {
        this.res_work_experience = res_work_experience;
    }

    public String getRes_job_intention() {
        return res_job_intention;
    }

    public void setRes_job_intention(String res_job_intention) {
        this.res_job_intention = res_job_intention;
    }

    public String getRes_about_me() {
        return res_about_me;
    }

    public void setRes_about_me(String res_about_me) {
        this.res_about_me = res_about_me;
    }

    public String getRes_major() {
        return res_major;
    }

    public void setRes_major(String res_major) {
        this.res_major = res_major;
    }

    public String getRes_idCard() {
        return res_idCard;
    }

    public void setRes_idCard(String res_idCard) {
        this.res_idCard = res_idCard;
    }

    public String getRes_hopeSalary() {
        return res_hopeSalary;
    }

    public void setRes_hopeSalary(String res_hopeSalary) {
        this.res_hopeSalary = res_hopeSalary;
    }

    public String getRes_education_background() {
        return res_education_background;
    }

    public void setRes_education_background(String res_education_background) {
        this.res_education_background = res_education_background;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "res_id=" + res_id +
                ", res_name='" + res_name + '\'' +
                ", res_age=" + res_age +
                ", res_gender='" + res_gender + '\'' +
                ", res_phone='" + res_phone + '\'' +
                ", res_birth=" + res_birth +
                ", res_education='" + res_education + '\'' +
                ", res_email='" + res_email + '\'' +
                ", res_address='" + res_address + '\'' +
                ", res_work_experience='" + res_work_experience + '\'' +
                ", res_job_intention='" + res_job_intention + '\'' +
                ", res_about_me='" + res_about_me + '\'' +
                ", res_major='" + res_major + '\'' +
                ", res_idCard='" + res_idCard + '\'' +
                ", res_hopeSalary='" + res_hopeSalary + '\'' +
                ", res_education_background='" + res_education_background + '\'' +
                '}';
    }
}
