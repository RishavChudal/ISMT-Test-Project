package np.com.rishavchudal.test.presentation.dashboard;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import np.com.rishavchudal.domain.models.facts.Fact;

/**
 * Created by Rishav Chudal on 22/03/2022.
 */
public class DashboardViewModel extends AndroidViewModel {
    private MutableLiveData<List<Fact>> factsLiveData = new MutableLiveData<>();

    public DashboardViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<Fact>> getFactsLiveData() {
        return factsLiveData;
    }

    public void fetchFacts() {
        //TODO Fetch Data
        List<Fact> facts = new ArrayList<>(); //TODO Remove (For example purpose only)
        factsLiveData.setValue(facts);
    }
}
