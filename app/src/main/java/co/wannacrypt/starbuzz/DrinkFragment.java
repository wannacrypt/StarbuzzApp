package co.wannacrypt.starbuzz;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrinkFragment extends Fragment {

    public DrinkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_drink, container, false);

        LinearLayout ll = rootView.findViewById(R.id.drinkLayout);

        ArrayList<String> arr = MainActivity.getDrinkList();

        for (String s : arr) {
            final CheckBox cb = new CheckBox(getActivity().getApplicationContext());
            cb.setText(s);

            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked)
                        MainActivity.getFavoriteList().add(cb.getText().toString());
                    else
                        MainActivity.getFavoriteList().remove(cb.getText().toString());
                }
            });

            ll.addView(cb);
        }

        // Inflate the layout for this fragment
        return rootView;
    }

}
