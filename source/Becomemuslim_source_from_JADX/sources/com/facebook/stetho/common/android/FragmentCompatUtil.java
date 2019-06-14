package com.facebook.stetho.common.android;

import android.app.Activity;
import android.view.View;

public final class FragmentCompatUtil {
    private FragmentCompatUtil() {
    }

    public static boolean isDialogFragment(Object obj) {
        FragmentCompat supportLibInstance = FragmentCompat.getSupportLibInstance();
        if (supportLibInstance != null && supportLibInstance.getDialogFragmentClass().isInstance(obj)) {
            return true;
        }
        supportLibInstance = FragmentCompat.getFrameworkInstance();
        if (supportLibInstance == null || supportLibInstance.getDialogFragmentClass().isInstance(obj) == null) {
            return null;
        }
        return true;
    }

    public static Object findFragmentForView(View view) {
        Activity tryGetActivity = ViewUtil.tryGetActivity(view);
        if (tryGetActivity == null) {
            return null;
        }
        return findFragmentForViewInActivity(tryGetActivity, view);
    }

    private static Object findFragmentForViewInActivity(Activity activity, View view) {
        FragmentCompat supportLibInstance = FragmentCompat.getSupportLibInstance();
        if (supportLibInstance != null && supportLibInstance.getFragmentActivityClass().isInstance(activity)) {
            Object findFragmentForViewInActivity = findFragmentForViewInActivity(supportLibInstance, activity, view);
            if (findFragmentForViewInActivity != null) {
                return findFragmentForViewInActivity;
            }
        }
        supportLibInstance = FragmentCompat.getFrameworkInstance();
        if (supportLibInstance != null) {
            activity = findFragmentForViewInActivity(supportLibInstance, activity, view);
            if (activity != null) {
                return activity;
            }
        }
        return null;
    }

    private static Object findFragmentForViewInActivity(FragmentCompat fragmentCompat, Activity activity, View view) {
        activity = fragmentCompat.forFragmentActivity().getFragmentManager(activity);
        return activity != null ? findFragmentForViewInFragmentManager(fragmentCompat, activity, view) : null;
    }

    private static Object findFragmentForViewInFragmentManager(FragmentCompat fragmentCompat, Object obj, View view) {
        obj = fragmentCompat.forFragmentManager().getAddedFragments(obj);
        if (obj != null) {
            int size = obj.size();
            for (int i = 0; i < size; i++) {
                Object findFragmentForViewInFragment = findFragmentForViewInFragment(fragmentCompat, obj.get(i), view);
                if (findFragmentForViewInFragment != null) {
                    return findFragmentForViewInFragment;
                }
            }
        }
        return null;
    }

    private static Object findFragmentForViewInFragment(FragmentCompat fragmentCompat, Object obj, View view) {
        FragmentAccessor forFragment = fragmentCompat.forFragment();
        if (forFragment.getView(obj) == view) {
            return obj;
        }
        obj = forFragment.getChildFragmentManager(obj);
        return obj != null ? findFragmentForViewInFragmentManager(fragmentCompat, obj, view) : null;
    }
}
