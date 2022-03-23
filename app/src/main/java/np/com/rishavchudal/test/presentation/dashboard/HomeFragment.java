package np.com.rishavchudal.test.presentation.dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import np.com.rishavchudal.domain.models.facts.Fact;
import np.com.rishavchudal.test.R;
import np.com.rishavchudal.test.presentation.dashboard.adapter.FactRecyclerAdapter;

public class HomeFragment extends Fragment {
    private Button btnHomeFragment;
    private RecyclerView factsRecyclerView;
    private DashboardViewModel dashboardViewModel;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initWidgets(view);
        initButtonAction();
        observeMutableLiveDatas();
        fetchFacts();
        return view;
    }

    private void initViewModel() {
        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
    }

    private void initWidgets(View view) {
        btnHomeFragment = view.findViewById(R.id.btn_home_fragment);
        factsRecyclerView = view.findViewById(R.id.facts_recycler_view);
    }

    private void initButtonAction() {
        btnHomeFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void observeMutableLiveDatas() {
        dashboardViewModel.getFactsLiveData().observe(
                this,
                new Observer<List<Fact>>() {
                    @Override
                    public void onChanged(List<Fact> facts) {
                        loadRecyclerViewWithValidFacts(facts);
                    }
                }
        );
    }

    private void loadRecyclerViewWithValidFacts(List<Fact> facts) {
        if (facts.isEmpty()) {
            return;
        }
        FactRecyclerAdapter factRecyclerAdapter = new FactRecyclerAdapter(facts);
        factsRecyclerView.setAdapter(factRecyclerAdapter);
        factsRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        factRecyclerAdapter.notifyDataSetChanged();
    }

    private void fetchFacts() {
        dashboardViewModel.fetchFacts();
    }
}