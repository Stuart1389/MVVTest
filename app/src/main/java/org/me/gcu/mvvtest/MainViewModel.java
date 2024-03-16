package org.me.gcu.mvvtest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<Boolean> isParsed;
    public int number3;
    private Model model = new Model();


    //creating live data
    //i only use this to start shit happening in the view really
    //to make sure parsing is complete b4 updating shit
    //so when parsing is complete i set to true so i dont get fucky lists with threads
    public MutableLiveData<Boolean> getCurrentState() {
        if (isParsed == null) {
            isParsed = new MutableLiveData<Boolean>();
        }
        return isParsed;
    }


    public int addNum(){
        number3 = model.addNumbers();
        return number3;
    }
}
