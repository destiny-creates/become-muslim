package com.facebook.stetho.inspector.elements.android;

import android.app.Activity;
import android.view.View;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.StringUtil;
import com.facebook.stetho.common.android.FragmentCompat;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.Descriptor.Host;

final class ActivityDescriptor extends AbstractChainedDescriptor<Activity> implements HighlightableDescriptor {
    ActivityDescriptor() {
    }

    protected String onGetNodeName(Activity activity) {
        return StringUtil.removePrefix(activity.getClass().getName(), "android.app.");
    }

    protected void onGetChildren(Activity activity, Accumulator<Object> accumulator) {
        getDialogFragments(FragmentCompat.getSupportLibInstance(), activity, accumulator);
        getDialogFragments(FragmentCompat.getFrameworkInstance(), activity, accumulator);
        activity = activity.getWindow();
        if (activity != null) {
            accumulator.store(activity);
        }
    }

    public View getViewForHighlighting(Object obj) {
        Host host = getHost();
        if (!(host instanceof AndroidDescriptorHost)) {
            return null;
        }
        return ((AndroidDescriptorHost) host).getHighlightingView(((Activity) obj).getWindow());
    }

    private static void getDialogFragments(FragmentCompat fragmentCompat, Activity activity, Accumulator<Object> accumulator) {
        if (fragmentCompat != null) {
            if (fragmentCompat.getFragmentActivityClass().isInstance(activity)) {
                activity = fragmentCompat.forFragmentActivity().getFragmentManager(activity);
                if (activity != null) {
                    activity = fragmentCompat.forFragmentManager().getAddedFragments(activity);
                    if (activity != null) {
                        int size = activity.size();
                        for (int i = 0; i < size; i++) {
                            Object obj = activity.get(i);
                            if (fragmentCompat.getDialogFragmentClass().isInstance(obj)) {
                                accumulator.store(obj);
                            }
                        }
                    }
                }
            }
        }
    }
}
