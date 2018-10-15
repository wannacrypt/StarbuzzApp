package co.wannacrypt.starbuzz;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class PageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public PageAdapter(FragmentManager supportFragmentManager, int tabCount) {
        super(supportFragmentManager);
        numOfTabs = tabCount;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new DrinkFragment();
            case 1:
                return new FoodFragment();
            case 2:
                return new StoreFragment();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
