package co.wannacrypt.starbuzz;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter pageAdapter;
    private TabItem tabDrinks;
    private TabItem tabFoods;
    private TabItem tabStores;
    private TabItem tabFavorites;
    private Button button;

    public static Set<String> favoriteList;
    public static final String DATA = "co.wannacrypt.starbuzz.DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        favoriteList = new HashSet<>();

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Starbuzz");
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tabLayout);
        tabDrinks = findViewById(R.id.tabDrinks);
        tabFoods = findViewById(R.id.tabFoods);
        tabStores = findViewById(R.id.tabStores);
        viewPager = findViewById(R.id.viewPager);

        button = findViewById(R.id.button);
        final Intent intent = new Intent(this, FavoriteActivity.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("favoriteList", getArrayList(favoriteList));
                startActivity(intent);
            }
        });

        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorBlue));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorBlue));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.colorBlue));
                    }
                } else if (tab.getPosition() == 1) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimaryDark));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimaryDark));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimaryDark));
                    }
                } else if (tab.getPosition() == 2) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

    public static Set<String> getFavoriteList() { return favoriteList; }

    public static ArrayList<String> getArrayList(Set<String> set) {
        ArrayList<String> al = new ArrayList<>();
        for (String str : set)
            al.add(str);
        return al;
    }
}
