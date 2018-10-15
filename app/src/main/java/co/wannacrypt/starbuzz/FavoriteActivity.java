package co.wannacrypt.starbuzz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        ListView listView = findViewById(R.id.fovoriteListView);

        ArrayList<String> favoriteList = (ArrayList<String>) getIntent().getSerializableExtra("favoriteList");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, favoriteList);

        listView.setAdapter(arrayAdapter);

    }
}
