package kr.h.gachon.news_application;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.telephony.IccOpenLogicalChannelResponse;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ThreeFragment extends Fragment {

    private FiveFragment fiveFragment=new FiveFragment();
    private SixFragment sixFragment=new SixFragment();
    private Button button1;
    private Button button2;

    public ThreeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(R.layout.fragment_three, container, false);



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentManager childFragment = getChildFragmentManager();
        FragmentTransaction transaction = childFragment.beginTransaction();
        transaction.replace(R.id.fragmentview, sixFragment).commitAllowingStateLoss();

        button1=view.findViewById(R.id.button_scrap);
        button2=view.findViewById(R.id.button_recent);

        button1.setOnClickListener(new ButtonSelectedListener());
        button2.setOnClickListener(new ButtonSelectedListener());

        button2.setBackgroundColor(Color.rgb(169,169,169));
    }

    class ButtonSelectedListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            FragmentManager childFragment = getChildFragmentManager();
            FragmentTransaction transaction = childFragment.beginTransaction();

            int viewId = view.getId();
            if (viewId == R.id.button_scrap) {
                button1.setBackgroundColor(Color.rgb(169,169,169));
                button2.setBackgroundColor(Color.rgb(220,220,220));
                transaction.replace(R.id.fragmentview, fiveFragment).commitAllowingStateLoss();
            } else if (viewId == R.id.button_recent) {
                button2.setBackgroundColor(Color.rgb(169,169,169));
                button1.setBackgroundColor(Color.rgb(220,220,220));
                transaction.replace(R.id.fragmentview, sixFragment).commitAllowingStateLoss();
            } else {
                throw new IllegalStateException("Unexpected value: " + view.getId());
            }
        }
    }




}