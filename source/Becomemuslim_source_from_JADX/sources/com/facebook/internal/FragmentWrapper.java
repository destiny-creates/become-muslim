package com.facebook.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.C3178i;

public class FragmentWrapper {
    private Fragment nativeFragment;
    private C3178i supportFragment;

    public FragmentWrapper(C3178i c3178i) {
        Validate.notNull(c3178i, "fragment");
        this.supportFragment = c3178i;
    }

    public FragmentWrapper(Fragment fragment) {
        Validate.notNull(fragment, "fragment");
        this.nativeFragment = fragment;
    }

    public Fragment getNativeFragment() {
        return this.nativeFragment;
    }

    public C3178i getSupportFragment() {
        return this.supportFragment;
    }

    public void startActivityForResult(Intent intent, int i) {
        if (this.supportFragment != null) {
            this.supportFragment.startActivityForResult(intent, i);
        } else {
            this.nativeFragment.startActivityForResult(intent, i);
        }
    }

    public final Activity getActivity() {
        if (this.supportFragment != null) {
            return this.supportFragment.getActivity();
        }
        return this.nativeFragment.getActivity();
    }
}
