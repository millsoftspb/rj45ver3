package com.wincomp.rj45colors;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {
    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new com.wincomp.rj45colors.Fragment_568B4();
        } else if (position == 1){
            return new com.wincomp.rj45colors.Fragment_568B2();
        } else if (position == 2){
            return new com.wincomp.rj45colors.Fragment_568A4();
        }  else {
            return new com.wincomp.rj45colors.Fragment_568A2();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        //return super.getPageTitle(position);
        return new String[] {
                "T-568B"+"\n4 pairs",
                "T-568B"+"\n2 pairs",
                "T-568A"+"\n4 pairs",
                "T-568A"+"\n2 pairs"
        }[position];
    }

    @Override
    public int getCount() {
        return 4;
    }
}
