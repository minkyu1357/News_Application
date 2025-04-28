package kr.h.gachon.news_application;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private OneFragment firstFragment = new OneFragment();
    private TwoFragment secondFragment = new TwoFragment();
    private ThreeFragment thirdFragment = new ThreeFragment();
    private FourFragment forthFragment = new FourFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentview, firstFragment).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            int itemId = item.getItemId();
            if (itemId == R.id.menu1) {
                transaction.replace(R.id.fragmentview, firstFragment).commitAllowingStateLoss();
            } else if (itemId == R.id.menu2) {
                transaction.replace(R.id.fragmentview, secondFragment).commitAllowingStateLoss();
            } else if (itemId == R.id.menu3) {
                transaction.replace(R.id.fragmentview, thirdFragment).commitAllowingStateLoss();
            } else if (itemId == R.id.menu4) {
                transaction.replace(R.id.fragmentview, forthFragment).commitAllowingStateLoss();
            } else {
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
            }
            return true;
        }
    }

}