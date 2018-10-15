package co.wannacrypt.starbuzz;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {


    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_food, container, false);

        final CheckBox checkBox = rootView.findViewById(R.id.checkBox4);
        final CheckBox checkBox2 = rootView.findViewById(R.id.checkBox5);
        final CheckBox checkBox3 = rootView.findViewById(R.id.checkBox6);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    MainActivity.getFavoriteList().add(checkBox.getText().toString());
                } else {
                    MainActivity.getFavoriteList().remove(checkBox.getText().toString());
                }
            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    MainActivity.getFavoriteList().add(checkBox2.getText().toString());
                } else {
                    MainActivity.getFavoriteList().remove(checkBox2.getText().toString());

                }
            }
        });

        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    MainActivity.getFavoriteList().add(checkBox3.getText().toString());
                } else {
                    MainActivity.getFavoriteList().remove(checkBox3.getText().toString());

                }
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

}
