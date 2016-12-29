package com.listsofcardswithsectionssample.models;

/**
 * Created by Admin on 29-12-2016.
 */
public class TrainDetail {

    private int trainNumber;
    private int fareAmount;

    public TrainDetail() {
    }

    public TrainDetail(int trainNumber, int fareAmount) {
        this.trainNumber = trainNumber;
        this.fareAmount = fareAmount;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public int getFareAmount() {
        return fareAmount;
    }

    public void setFareAmount(int fareAmount) {
        this.fareAmount = fareAmount;
    }
}