package com.example.espacioswipeviews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 paginador = findViewById(R.id.paginador);
        FragmentStateAdapter pagerAdapter = new ScreenSlidePagerAdapter(this);
        paginador.setAdapter(pagerAdapter);
    }

    private static class ScreenSlidePagerAdapter extends FragmentStateAdapter {

        public ScreenSlidePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            Fragment f;
            switch (position) {
                case 0:
                    f = new SistemaSolarFragment();
                    break;
                case 1:
                    f = new MisionesEspacialesFragment();
                    break;
                case 2:
                    f = new FuturoFragment();
                    break;
                default:
                    f = null;
            }
            return f;
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }
}