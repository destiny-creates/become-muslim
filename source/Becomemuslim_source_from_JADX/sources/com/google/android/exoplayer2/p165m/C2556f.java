package com.google.android.exoplayer2.p165m;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManager.DisplayListener;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.exoplayer2.p164l.C2541v;

@TargetApi(16)
/* compiled from: VideoFrameReleaseTimeHelper */
/* renamed from: com.google.android.exoplayer2.m.f */
public final class C2556f {
    /* renamed from: a */
    private final WindowManager f6515a;
    /* renamed from: b */
    private final C2555b f6516b;
    /* renamed from: c */
    private final C2554a f6517c;
    /* renamed from: d */
    private long f6518d;
    /* renamed from: e */
    private long f6519e;
    /* renamed from: f */
    private long f6520f;
    /* renamed from: g */
    private long f6521g;
    /* renamed from: h */
    private long f6522h;
    /* renamed from: i */
    private boolean f6523i;
    /* renamed from: j */
    private long f6524j;
    /* renamed from: k */
    private long f6525k;
    /* renamed from: l */
    private long f6526l;

    @TargetApi(17)
    /* compiled from: VideoFrameReleaseTimeHelper */
    /* renamed from: com.google.android.exoplayer2.m.f$a */
    private final class C2554a implements DisplayListener {
        /* renamed from: a */
        final /* synthetic */ C2556f f6507a;
        /* renamed from: b */
        private final DisplayManager f6508b;

        public void onDisplayAdded(int i) {
        }

        public void onDisplayRemoved(int i) {
        }

        public C2554a(C2556f c2556f, DisplayManager displayManager) {
            this.f6507a = c2556f;
            this.f6508b = displayManager;
        }

        /* renamed from: a */
        public void m7214a() {
            this.f6508b.registerDisplayListener(this, null);
        }

        /* renamed from: b */
        public void m7215b() {
            this.f6508b.unregisterDisplayListener(this);
        }

        public void onDisplayChanged(int i) {
            if (i == 0) {
                this.f6507a.m7226c();
            }
        }
    }

    /* compiled from: VideoFrameReleaseTimeHelper */
    /* renamed from: com.google.android.exoplayer2.m.f$b */
    private static final class C2555b implements Callback, FrameCallback {
        /* renamed from: b */
        private static final C2555b f6509b = new C2555b();
        /* renamed from: a */
        public volatile long f6510a = -9223372036854775807L;
        /* renamed from: c */
        private final Handler f6511c;
        /* renamed from: d */
        private final HandlerThread f6512d = new HandlerThread("ChoreographerOwner:Handler");
        /* renamed from: e */
        private Choreographer f6513e;
        /* renamed from: f */
        private int f6514f;

        /* renamed from: a */
        public static C2555b m7216a() {
            return f6509b;
        }

        private C2555b() {
            this.f6512d.start();
            this.f6511c = new Handler(this.f6512d.getLooper(), this);
            this.f6511c.sendEmptyMessage(0);
        }

        /* renamed from: b */
        public void m7220b() {
            this.f6511c.sendEmptyMessage(1);
        }

        /* renamed from: c */
        public void m7221c() {
            this.f6511c.sendEmptyMessage(2);
        }

        public void doFrame(long j) {
            this.f6510a = j;
            this.f6513e.postFrameCallbackDelayed(this, 500);
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case null:
                    m7217d();
                    return true;
                case 1:
                    m7218e();
                    return true;
                case 2:
                    m7219f();
                    return true;
                default:
                    return null;
            }
        }

        /* renamed from: d */
        private void m7217d() {
            this.f6513e = Choreographer.getInstance();
        }

        /* renamed from: e */
        private void m7218e() {
            this.f6514f++;
            if (this.f6514f == 1) {
                this.f6513e.postFrameCallback(this);
            }
        }

        /* renamed from: f */
        private void m7219f() {
            this.f6514f--;
            if (this.f6514f == 0) {
                this.f6513e.removeFrameCallback(this);
                this.f6510a = -9223372036854775807L;
            }
        }
    }

    public C2556f() {
        this(null);
    }

    public C2556f(Context context) {
        WindowManager windowManager;
        C2554a c2554a = null;
        if (context == null) {
            windowManager = null;
        } else {
            windowManager = (WindowManager) context.getSystemService("window");
        }
        this.f6515a = windowManager;
        if (this.f6515a != null) {
            if (C2541v.f6467a >= 17) {
                c2554a = m7223a(context);
            }
            this.f6517c = c2554a;
            this.f6516b = C2555b.m7216a();
        } else {
            this.f6517c = null;
            this.f6516b = null;
        }
        this.f6518d = -9223372036854775807L;
        this.f6519e = -9223372036854775807L;
    }

    /* renamed from: a */
    public void m7228a() {
        this.f6523i = false;
        if (this.f6515a != null) {
            this.f6516b.m7220b();
            if (this.f6517c != null) {
                this.f6517c.m7214a();
            }
            m7226c();
        }
    }

    /* renamed from: b */
    public void m7229b() {
        if (this.f6515a != null) {
            if (this.f6517c != null) {
                this.f6517c.m7215b();
            }
            this.f6516b.m7221c();
        }
    }

    /* renamed from: a */
    public long m7227a(long j, long j2) {
        long j3;
        long j4;
        long j5;
        long j6 = j;
        long j7 = j2;
        long j8 = 1000 * j6;
        if (this.f6523i) {
            if (j6 != r0.f6520f) {
                r0.f6526l++;
                r0.f6521g = r0.f6522h;
            }
            if (r0.f6526l >= 6) {
                long j9;
                j3 = r0.f6521g + ((j8 - r0.f6525k) / r0.f6526l);
                if (m7225b(j3, j7)) {
                    r0.f6523i = false;
                    j9 = j7;
                    j3 = j8;
                } else {
                    j9 = (r0.f6524j + j3) - r0.f6525k;
                }
                j4 = j9;
                if (!r0.f6523i) {
                    r0.f6525k = j8;
                    r0.f6524j = j7;
                    r0.f6526l = 0;
                    r0.f6523i = true;
                }
                r0.f6520f = j6;
                r0.f6522h = j3;
                if (r0.f6516b != null) {
                    if (r0.f6518d == -9223372036854775807L) {
                        j5 = r0.f6516b.f6510a;
                        if (j5 != -9223372036854775807L) {
                            return j4;
                        }
                        return C2556f.m7222a(j4, j5, r0.f6518d) - r0.f6519e;
                    }
                }
                return j4;
            } else if (m7225b(j8, j7)) {
                r0.f6523i = false;
            }
        }
        j4 = j7;
        j3 = j8;
        if (r0.f6523i) {
            r0.f6525k = j8;
            r0.f6524j = j7;
            r0.f6526l = 0;
            r0.f6523i = true;
        }
        r0.f6520f = j6;
        r0.f6522h = j3;
        if (r0.f6516b != null) {
            if (r0.f6518d == -9223372036854775807L) {
                j5 = r0.f6516b.f6510a;
                if (j5 != -9223372036854775807L) {
                    return C2556f.m7222a(j4, j5, r0.f6518d) - r0.f6519e;
                }
                return j4;
            }
        }
        return j4;
    }

    @TargetApi(17)
    /* renamed from: a */
    private C2554a m7223a(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager == null) {
            return null;
        }
        return new C2554a(this, displayManager);
    }

    /* renamed from: c */
    private void m7226c() {
        Display defaultDisplay = this.f6515a.getDefaultDisplay();
        if (defaultDisplay != null) {
            this.f6518d = (long) (1.0E9d / ((double) defaultDisplay.getRefreshRate()));
            this.f6519e = (this.f6518d * 80) / 100;
        }
    }

    /* renamed from: b */
    private boolean m7225b(long j, long j2) {
        return Math.abs((j2 - this.f6524j) - (j - this.f6525k)) > 20000000 ? 1 : 0;
    }

    /* renamed from: a */
    private static long m7222a(long j, long j2, long j3) {
        j2 += ((j - j2) / j3) * j3;
        if (j <= j2) {
            j3 = j2 - j3;
        } else {
            long j4 = j2;
            j2 = j3 + j2;
            j3 = j4;
        }
        return j2 - j < j - j3 ? j2 : j3;
    }
}
