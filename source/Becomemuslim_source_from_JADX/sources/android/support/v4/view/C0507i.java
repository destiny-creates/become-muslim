package android.support.v4.view;

import android.view.MotionEvent;

/* compiled from: MotionEventCompat */
/* renamed from: android.support.v4.view.i */
public final class C0507i {
    @Deprecated
    /* renamed from: a */
    public static int m1607a(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    /* renamed from: a */
    public static boolean m1608a(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i ? true : null;
    }
}
