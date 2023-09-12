package com.polije.sem3.util;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.polije.sem3.R;

public class FragmentUtil {

    private static void switchFragment(
            @NonNull FragmentManager fragmentManager, Fragment openedFragment,
            @IdRes int frameId, boolean backStack
    ){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(backStack){
            transaction.replace(frameId, openedFragment);
            transaction.addToBackStack(null).commit();
        }else {
            transaction.replace(frameId, openedFragment).commit();
        }
    }

    public static void switchFragmentMain(
        @NonNull FragmentManager fragmentManager, Fragment openedFragment, boolean backStack
    ){
        switchFragment(fragmentManager, openedFragment, R.id.main_frame_layout, backStack);
    }
}
