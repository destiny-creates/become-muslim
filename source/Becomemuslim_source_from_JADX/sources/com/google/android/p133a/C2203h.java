package com.google.android.p133a;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.OrientationEventListener;
import com.facebook.imagepipeline.common.RotationOptions;

/* compiled from: DisplayOrientationDetector */
/* renamed from: com.google.android.a.h */
abstract class C2203h {
    /* renamed from: b */
    static final SparseIntArray f5251b = new SparseIntArray();
    /* renamed from: a */
    private final OrientationEventListener f5252a;
    /* renamed from: c */
    Display f5253c;
    /* renamed from: d */
    private int f5254d = 0;

    /* renamed from: a */
    public abstract void mo2093a(int i);

    static {
        f5251b.put(0, 0);
        f5251b.put(1, 90);
        f5251b.put(2, RotationOptions.ROTATE_180);
        f5251b.put(3, RotationOptions.ROTATE_270);
    }

    public C2203h(Context context) {
        this.f5252a = new OrientationEventListener(this, context) {
            /* renamed from: a */
            final /* synthetic */ C2203h f5249a;
            /* renamed from: b */
            private int f5250b = -1;

            public void onOrientationChanged(int i) {
                if (i != -1) {
                    if (this.f5249a.f5253c != 0) {
                        i = this.f5249a.f5253c.getRotation();
                        if (this.f5250b != i) {
                            this.f5250b = i;
                            this.f5249a.m6078b(C2203h.f5251b.get(i));
                        }
                    }
                }
            }
        };
    }

    /* renamed from: a */
    public void m6076a(Display display) {
        this.f5253c = display;
        this.f5252a.enable();
        m6078b(f5251b.get(display.getRotation()));
    }

    /* renamed from: a */
    public void m6074a() {
        this.f5252a.disable();
        this.f5253c = null;
    }

    /* renamed from: b */
    public int m6077b() {
        return this.f5254d;
    }

    /* renamed from: b */
    void m6078b(int i) {
        this.f5254d = i;
        mo2093a(i);
    }
}
