/**
 * This is the main Entity class of our application.
 * <p>
 * Since the application is fairly simple, I opted for a flat data structure. The other option would be to
 * normalize and have separate entities for Persons and Surveys, at least. Since JPA takes care of the heavy
 * lifting of producing database tables and queries, this class is fairly empty outside of getters and setters.
 */

package com.gmu.jmd.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Survey {
    public Survey() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long surveyId;

    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipcode;
    private String telephoneNumber;
    private String emailAddress;

    @Temporal(TemporalType.DATE)
    private Date surveyDate;

    @ElementCollection
    private List<String> thingsLiked = new ArrayList<>();

    private String interestSource;

    private String likelihoodOfRecommendation;


    @Lob
    @Column(name = "additional_comments", length = 1024)
    private String additionalComments;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public Date getSurveyDate() {
        return surveyDate;
    }

    public void setSurveyDate(Date surveyDate) {
        this.surveyDate = surveyDate;
    }

    public List<String> getThingsLiked() {
        return thingsLiked;
    }

    public void setThingsLiked(List<String> thingsLiked) {
        this.thingsLiked = thingsLiked;
    }

    public String getInterestSource() {
        return interestSource;
    }

    public void setInterestSource(String interestSource) {
        this.interestSource = interestSource;
    }

    public String getLikelihoodOfRecommendation() {
        return likelihoodOfRecommendation;
    }

    public void setLikelihoodOfRecommendation(String likelihoodOfRecommendation) {
        this.likelihoodOfRecommendation = likelihoodOfRecommendation;
    }

    public String getAdditionalComments() {
        return additionalComments;
    }

    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "surveyId=" + surveyId +
                ", surveyDate=" + surveyDate +
                ", thingsLiked=" + String.join(",", thingsLiked) +
                ", interestSource='" + interestSource + '\'' +
                ", likelihoodOfRecommendation='" + likelihoodOfRecommendation + '\'' +
                ", additionalComments='" + additionalComments + '\'' +
                '}';
    }
}
