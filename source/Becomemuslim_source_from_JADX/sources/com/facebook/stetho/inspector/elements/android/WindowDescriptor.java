package com.facebook.stetho.inspector.elements.android;

import android.view.View;
import android.view.Window;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;

final class WindowDescriptor extends AbstractChainedDescriptor<Window> implements HighlightableDescriptor {
    WindowDescriptor() {
    }

    protected void onGetChildren(Window window, Accumulator<Object> accumulator) {
        window = window.peekDecorView();
        if (window != null) {
            accumulator.store(window);
        }
    }

    public View getViewForHighlighting(Object obj) {
        return ((Window) obj).peekDecorView();
    }
}
