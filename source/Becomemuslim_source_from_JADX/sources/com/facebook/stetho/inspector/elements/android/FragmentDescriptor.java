package com.facebook.stetho.inspector.elements.android;

import android.view.View;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.android.FragmentAccessor;
import com.facebook.stetho.common.android.FragmentCompat;
import com.facebook.stetho.common.android.ResourcesUtil;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.AttributeAccumulator;
import com.facebook.stetho.inspector.elements.DescriptorMap;

final class FragmentDescriptor extends AbstractChainedDescriptor<Object> implements HighlightableDescriptor {
    private static final String ID_ATTRIBUTE_NAME = "id";
    private static final String TAG_ATTRIBUTE_NAME = "tag";
    private final FragmentAccessor mAccessor;

    public static DescriptorMap register(DescriptorMap descriptorMap) {
        maybeRegister(descriptorMap, FragmentCompat.getSupportLibInstance());
        maybeRegister(descriptorMap, FragmentCompat.getFrameworkInstance());
        return descriptorMap;
    }

    private static void maybeRegister(DescriptorMap descriptorMap, FragmentCompat fragmentCompat) {
        if (fragmentCompat != null) {
            LogUtil.m5739d("Adding support for %s", fragmentCompat.getFragmentClass().getName());
            descriptorMap.register(r0, new FragmentDescriptor(fragmentCompat));
        }
    }

    private FragmentDescriptor(FragmentCompat fragmentCompat) {
        this.mAccessor = fragmentCompat.forFragment();
    }

    protected void onGetAttributes(Object obj, AttributeAccumulator attributeAccumulator) {
        int id = this.mAccessor.getId(obj);
        if (id != 0) {
            attributeAccumulator.store("id", ResourcesUtil.getIdStringQuietly(obj, this.mAccessor.getResources(obj), id));
        }
        obj = this.mAccessor.getTag(obj);
        if (obj != null && obj.length() > 0) {
            attributeAccumulator.store(TAG_ATTRIBUTE_NAME, obj);
        }
    }

    protected void onGetChildren(Object obj, Accumulator<Object> accumulator) {
        obj = this.mAccessor.getView(obj);
        if (obj != null) {
            accumulator.store(obj);
        }
    }

    public View getViewForHighlighting(Object obj) {
        return this.mAccessor.getView(obj);
    }
}
