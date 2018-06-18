package com.mylevel.app.helper;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.mylevel.app.R;

/**
 * Created by akamahesh on 11/5/17.
 */

public class FragmentUtil {

    /**
     * Change the current displayed fragment by a new one.
     * - if the fragmebt is in backstack, it will pop it
     * - if the fragment is already displayed (trying to change the fragment with the same), it will not do anything
     *
     * @param fragment        the new fragment display
     * @param saveInBackstack if we want the fragment to be in backstack
     * @param animate         if we want a nice animation or not
     */
    public static void changeFragment(FragmentManager fragmentManager, Fragment fragment, boolean saveInBackstack, boolean animate) {
        String backStateName = fragment.getClass().getName();
        try {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            if (animate) {
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
            }
            transaction.replace(R.id.rootContainer,fragment,backStateName);
            if (saveInBackstack) {
                transaction.addToBackStack(backStateName);
            }

            transaction.commitAllowingStateLoss( );

        } catch (IllegalStateException e) {
            Toaster.toast(e.getMessage());
        }
    }

    /**
     * Change the current displayed fragment by a new one.
     * - if the fragmebt is in backstack, it will pop it
     * - if the fragment is already displayed (trying to change the fragment with the same), it will not do anything
     *
     * @param fragment        the new fragment display
     * @param saveInBackstack if we want the fragment to be in backstack
     * @param animate         if we want a nice animation or not
     */
    public static void changeFragmentWithOld(FragmentManager fragmentManager, Fragment fragment, boolean saveInBackstack, boolean animate) {
        String backStateName = fragment.getClass().getName();
        try {
            boolean fragmentPopped = fragmentManager.popBackStackImmediate (backStateName, 0);
            if(!fragmentPopped){//fragment not in back stack, create it.
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                if (animate) {
                    transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                }
                transaction.replace(R.id.rootContainer,fragment,backStateName);
                if (saveInBackstack) {
                    transaction.addToBackStack(backStateName);
                }
                transaction.commit();
            }


        } catch (IllegalStateException e) {
            Toaster.toast(e.getMessage());
        }
    }


    /**
     * Replace the current displayed fragment by a new one.
     * - if the fragmebt is in backstack, it will pop it
     * - if the fragment is already displayed (trying to change the fragment with the same), it will not do anything
     *
     * @param fragment        the new fragment display
     * @param saveInBackstack if we want the fragment to be in backstack
     * @param animate         if we want a nice animation or not
     */
    public static void replaceFragment(FragmentManager fragmentManager, Fragment fragment, boolean saveInBackstack, boolean animate) {
        String backStateName = fragment.getClass().getName();
        try {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            if (animate) {
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
            }
            transaction.replace(R.id.rootContainer, fragment, backStateName);
            if (saveInBackstack) {
                transaction.addToBackStack(backStateName);
            }

            transaction.commitAllowingStateLoss( );

        } catch (IllegalStateException e) {
            Toaster.toast(e.getMessage());
        }
    }

    /**
     * Add a new fragment above the current displayed fragment
     * - if the fragmebt is in backstack, it will pop it
     * - if the fragment is already displayed (trying to change the fragment with the same), it will not do anything
     *
     * @param fragment        the new fragment display
     * @param saveInBackstack if we want the fragment to be in backstack
     * @param animate         if we want a nice animation or not
     */
    public static void addFragment(FragmentManager fragmentManager, Fragment fragment, boolean saveInBackstack, boolean animate) {
        String backStateName = fragment.getClass().getName();
        try {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            if (animate) {
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
            }
            transaction.add(R.id.rootContainer, fragment, backStateName);
            if (saveInBackstack) {
                transaction.addToBackStack(backStateName);
            }

            transaction.commit();

        } catch (IllegalStateException e) {
            Toaster.toast(e.getMessage());
        }
    }

    public static void showDialog(FragmentManager fragmentManager, DialogFragment dialogFragment, boolean saveInBackstack) {
        String backStateName = dialogFragment.getClass().getName();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        if (saveInBackstack) {
            ft.addToBackStack(backStateName);
        }
        dialogFragment.show(fragmentManager, backStateName);
    }

}
