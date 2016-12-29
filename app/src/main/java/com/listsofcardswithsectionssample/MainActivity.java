package com.listsofcardswithsectionssample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.listsofcardswithsectionssample.adapters.SectionOfDays_RecyclerViewAdapter;
import com.listsofcardswithsectionssample.models.TrainDetail;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    /**
     * constant member variables
     */
    private final String LOG_TAG = this.getClass().getSimpleName();

    /**
     * View Objects member variables
     */
    private RecyclerView recyclerView_sectionOfDays, recyclerView_listOfTrains;

    /**
     * data holding member variables
     */
    private HashMap<String, ArrayList<TrainDetail>> hashMapDayWiseTrainDetailArrayList;

    /**
     * days(sections) to be shown in the top horizontal recyclerView
     */
    String[] daysArray = new String[]{"A", "B"/*, "C", "D", "E"*/};

//    private

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeView();

        initializeDataObjects();

        setAdaptersForDataToShow();
    }

    private void initializeDataObjects() {
        hashMapDayWiseTrainDetailArrayList = new HashMap<>();

        /**
         * adding dummy constant data to be shown
         */

        /**
         * trainNumber data for day A
         */
        int[] day_A_trainNumbers = new int[]{1, 2, 5, 7, 8, 9};

        /**
         * fareAmount data for day A
         */
        int[] day_A_fareAmount = new int[]{10, 20, 50, 70, 80, 90};

        /**
         * trainNumber data for day B
         */
        int[] day_B_trainNumbers = new int[]{2, 6, 8, 10};

        /**
         * fareAmount data for day B
         */
        int[] day_B_fareAmount = new int[]{20, 60, 80, 100};

        /**
         * for each day in daysArray[] add corresponding data
         */
        for (String day : daysArray) {
            ArrayList<TrainDetail> trainDetailArrayList = new ArrayList<>();

            switch (day) {

                case "A":
                    if (day_A_trainNumbers.length == day_A_fareAmount.length) {
                        for (int i = 0; i < day_A_trainNumbers.length; i++) {
                            trainDetailArrayList.add(new TrainDetail(day_A_trainNumbers[i], day_A_fareAmount[i]));
                        }
                    } else {
                        Log.e(LOG_TAG, "length of arrays day_A_trainNumbers and day_A_fareAmount is not equal");
                    }
                    break;

                case "B":
                    if (day_B_trainNumbers.length == day_B_fareAmount.length) {
                        for (int i = 0; i < day_B_trainNumbers.length; i++) {
                            trainDetailArrayList.add(new TrainDetail(day_B_trainNumbers[i], day_B_fareAmount[i]));
                        }
                    } else {
                        Log.e(LOG_TAG, "length of arrays day_B_trainNumbers and day_B_fareAmount is not equal");
                    }
                    break;

                default:
                    Log.e(LOG_TAG, "data not set for the day:" + day + " in arrays");
                    break;
            }
            hashMapDayWiseTrainDetailArrayList.put(day, trainDetailArrayList);
        }
        Log.v(LOG_TAG, "after adding data hashMapDayWiseTrainDetailArrayList.size():" + hashMapDayWiseTrainDetailArrayList.size());
    }

    private void initializeView() {
        recyclerView_sectionOfDays = (RecyclerView) findViewById(R.id.recyclerView_sectionOfDays);
        recyclerView_listOfTrains = (RecyclerView) findViewById(R.id.recyclerView_listOfTrains);
    }

    private void setAdaptersForDataToShow() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_sectionOfDays.setLayoutManager(linearLayoutManager);
        recyclerView_sectionOfDays.setAdapter(new SectionOfDays_RecyclerViewAdapter(this, daysArray));
    }
}