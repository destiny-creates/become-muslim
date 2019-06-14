package com.facebook.stetho.inspector.elements.android;

import android.app.Dialog;
import android.view.View;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.Descriptor.Host;

final class DialogDescriptor extends AbstractChainedDescriptor<Dialog> implements HighlightableDescriptor {
    DialogDescriptor() {
    }

    protected void onGetChildren(Dialog dialog, Accumulator<Object> accumulator) {
        dialog = dialog.getWindow();
        if (dialog != null) {
            accumulator.store(dialog);
        }
    }

    public View getViewForHighlighting(Object obj) {
        Host host = getHost();
        return host instanceof AndroidDescriptorHost ? ((AndroidDescriptorHost) host).getHighlightingView(((Dialog) obj).getWindow()) : null;
    }
}
