package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.C0494b;
import android.support.v4.view.C0517s;
import android.support.v4.view.p033a.C0483b;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.widget.C3327p;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;

public class CheckableImageButton extends C3327p implements Checkable {
    /* renamed from: a */
    private static final int[] f11848a = new int[]{16842912};
    /* renamed from: b */
    private boolean f11849b;

    /* renamed from: android.support.design.widget.CheckableImageButton$1 */
    class C31231 extends C0494b {
        /* renamed from: a */
        final /* synthetic */ CheckableImageButton f7994a;

        C31231(CheckableImageButton checkableImageButton) {
            this.f7994a = checkableImageButton;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setChecked(this.f7994a.isChecked());
        }

        public void onInitializeAccessibilityNodeInfo(View view, C0483b c0483b) {
            super.onInitializeAccessibilityNodeInfo(view, c0483b);
            c0483b.m1507a(true);
            c0483b.m1514b(this.f7994a.isChecked());
        }
    }

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0581a.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0517s.m1695a((View) this, new C31231(this));
    }

    public void setChecked(boolean z) {
        if (this.f11849b != z) {
            this.f11849b = z;
            refreshDrawableState();
            sendAccessibilityEvent(true);
        }
    }

    public boolean isChecked() {
        return this.f11849b;
    }

    public void toggle() {
        setChecked(this.f11849b ^ 1);
    }

    public int[] onCreateDrawableState(int i) {
        if (this.f11849b) {
            return mergeDrawableStates(super.onCreateDrawableState(i + f11848a.length), f11848a);
        }
        return super.onCreateDrawableState(i);
    }
}
