package com.facebook.stetho.common.android;

import android.app.Dialog;
import android.content.res.Resources;
import android.support.v4.app.C0309n;
import android.support.v4.app.C3178i;
import android.support.v4.app.C4457h;
import android.support.v4.app.C4890j;
import android.view.View;

final class FragmentCompatSupportLib extends FragmentCompat<C3178i, C4457h, C0309n, C4890j> {
    private static final DialogFragmentAccessorSupportLib sDialogFragmentAccessor = new DialogFragmentAccessorSupportLib();
    private static final FragmentAccessorSupportLib sFragmentAccessor = new FragmentAccessorSupportLib();
    private static final FragmentActivityAccessorSupportLib sFragmentActivityAccessor = new FragmentActivityAccessorSupportLib();
    private static final FragmentManagerAccessorViaReflection<C0309n, C3178i> sFragmentManagerAccessor = new FragmentManagerAccessorViaReflection();

    private static class FragmentAccessorSupportLib implements FragmentAccessor<C3178i, C0309n> {
        private FragmentAccessorSupportLib() {
        }

        public C0309n getFragmentManager(C3178i c3178i) {
            return c3178i.getFragmentManager();
        }

        public Resources getResources(C3178i c3178i) {
            return c3178i.getResources();
        }

        public int getId(C3178i c3178i) {
            return c3178i.getId();
        }

        public String getTag(C3178i c3178i) {
            return c3178i.getTag();
        }

        public View getView(C3178i c3178i) {
            return c3178i.getView();
        }

        public C0309n getChildFragmentManager(C3178i c3178i) {
            return c3178i.getChildFragmentManager();
        }
    }

    private static class FragmentActivityAccessorSupportLib implements FragmentActivityAccessor<C4890j, C0309n> {
        private FragmentActivityAccessorSupportLib() {
        }

        public C0309n getFragmentManager(C4890j c4890j) {
            return c4890j.getSupportFragmentManager();
        }
    }

    private static class DialogFragmentAccessorSupportLib extends FragmentAccessorSupportLib implements DialogFragmentAccessor<C4457h, C3178i, C0309n> {
        private DialogFragmentAccessorSupportLib() {
            super();
        }

        public Dialog getDialog(C4457h c4457h) {
            return c4457h.getDialog();
        }
    }

    FragmentCompatSupportLib() {
    }

    public Class<C3178i> getFragmentClass() {
        return C3178i.class;
    }

    public Class<C4457h> getDialogFragmentClass() {
        return C4457h.class;
    }

    public Class<C4890j> getFragmentActivityClass() {
        return C4890j.class;
    }

    public FragmentAccessorSupportLib forFragment() {
        return sFragmentAccessor;
    }

    public DialogFragmentAccessorSupportLib forDialogFragment() {
        return sDialogFragmentAccessor;
    }

    public FragmentManagerAccessor<C0309n, C3178i> forFragmentManager() {
        return sFragmentManagerAccessor;
    }

    public FragmentActivityAccessorSupportLib forFragmentActivity() {
        return sFragmentActivityAccessor;
    }
}
