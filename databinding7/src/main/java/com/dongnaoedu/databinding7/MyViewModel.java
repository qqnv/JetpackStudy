package com.dongnaoedu.databinding7;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class MyViewModel extends ViewModel {

    private MutableLiveData<Integer> aTeamScore;
    private MutableLiveData<Integer> bTeamScore;
    private Integer aLast;
    private Integer bLast;

    public MutableLiveData<Integer> getATeamScore() {
        if(aTeamScore == null){
            aTeamScore = new MutableLiveData<>();
            aTeamScore.setValue(0);
        }
        return aTeamScore;
    }

    public MutableLiveData<Integer> getBTeamScore() {
        if(bTeamScore == null){
            bTeamScore = new MutableLiveData<>();
            bTeamScore.setValue(0);
        }
        return bTeamScore;
    }

    public void aTeamAdd(int i){
        saveLastScore();
        aTeamScore.setValue(aTeamScore.getValue() + i);
    }

    public void bTeamAdd(int i){
        saveLastScore();
        bTeamScore.setValue(bTeamScore.getValue() + i);
    }

    public void undo(){
        aTeamScore.setValue(aLast);
        bTeamScore.setValue(bLast);
    }

    public void reset(){
        aTeamScore.setValue(0);
        bTeamScore.setValue(0);
    }

    //记录上一次的分数
    private void saveLastScore(){
        this.aLast = aTeamScore.getValue();
        this.bLast = bTeamScore.getValue();
    }

}
