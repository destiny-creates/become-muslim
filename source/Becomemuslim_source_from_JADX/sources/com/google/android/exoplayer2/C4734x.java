package com.google.android.exoplayer2;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.google.android.exoplayer2.C2575s.C2574a;
import com.google.android.exoplayer2.C4159f.C2331b;
import com.google.android.exoplayer2.C4159f.C2332c;
import com.google.android.exoplayer2.p134a.C2219b;
import com.google.android.exoplayer2.p134a.C2230e;
import com.google.android.exoplayer2.p135b.C2249d;
import com.google.android.exoplayer2.p145g.C2344a;
import com.google.android.exoplayer2.p145g.C2367f;
import com.google.android.exoplayer2.p149h.C2423i;
import com.google.android.exoplayer2.p157i.C2458b;
import com.google.android.exoplayer2.p157i.C2475k;
import com.google.android.exoplayer2.p162j.C2487h;
import com.google.android.exoplayer2.p165m.C2565g;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@TargetApi(16)
/* compiled from: SimpleExoPlayer */
/* renamed from: com.google.android.exoplayer2.x */
public class C4734x implements C4159f {
    /* renamed from: a */
    protected final C4256t[] f12941a;
    /* renamed from: b */
    private final C4159f f12942b;
    /* renamed from: c */
    private final C4257a f12943c = new C4257a();
    /* renamed from: d */
    private final CopyOnWriteArraySet<C2586b> f12944d = new CopyOnWriteArraySet();
    /* renamed from: e */
    private final CopyOnWriteArraySet<C2475k> f12945e = new CopyOnWriteArraySet();
    /* renamed from: f */
    private final CopyOnWriteArraySet<C2367f> f12946f = new CopyOnWriteArraySet();
    /* renamed from: g */
    private final CopyOnWriteArraySet<C2565g> f12947g = new CopyOnWriteArraySet();
    /* renamed from: h */
    private final CopyOnWriteArraySet<C2230e> f12948h = new CopyOnWriteArraySet();
    /* renamed from: i */
    private final int f12949i;
    /* renamed from: j */
    private final int f12950j;
    /* renamed from: k */
    private C2515k f12951k;
    /* renamed from: l */
    private C2515k f12952l;
    /* renamed from: m */
    private Surface f12953m;
    /* renamed from: n */
    private boolean f12954n;
    /* renamed from: o */
    private int f12955o;
    /* renamed from: p */
    private SurfaceHolder f12956p;
    /* renamed from: q */
    private TextureView f12957q;
    /* renamed from: r */
    private C2249d f12958r;
    /* renamed from: s */
    private C2249d f12959s;
    /* renamed from: t */
    private int f12960t;
    /* renamed from: u */
    private C2219b f12961u;
    /* renamed from: v */
    private float f12962v;

    /* compiled from: SimpleExoPlayer */
    /* renamed from: com.google.android.exoplayer2.x$b */
    public interface C2586b {
        void onRenderedFirstFrame();

        void onVideoSizeChanged(int i, int i2, int i3, float f);
    }

    /* compiled from: SimpleExoPlayer */
    /* renamed from: com.google.android.exoplayer2.x$a */
    private final class C4257a implements Callback, SurfaceTextureListener, C2230e, C2367f, C2475k, C2565g {
        /* renamed from: a */
        final /* synthetic */ C4734x f11273a;

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        private C4257a(C4734x c4734x) {
            this.f11273a = c4734x;
        }

        /* renamed from: a */
        public void mo2333a(C2249d c2249d) {
            this.f11273a.f12958r = c2249d;
            Iterator it = this.f11273a.f12947g.iterator();
            while (it.hasNext()) {
                ((C2565g) it.next()).mo2333a(c2249d);
            }
        }

        /* renamed from: a */
        public void mo2336a(String str, long j, long j2) {
            Iterator it = this.f11273a.f12947g.iterator();
            while (it.hasNext()) {
                ((C2565g) it.next()).mo2336a(str, j, j2);
            }
        }

        /* renamed from: a */
        public void mo2335a(C2515k c2515k) {
            this.f11273a.f12951k = c2515k;
            Iterator it = this.f11273a.f12947g.iterator();
            while (it.hasNext()) {
                ((C2565g) it.next()).mo2335a(c2515k);
            }
        }

        /* renamed from: a */
        public void mo2330a(int i, long j) {
            Iterator it = this.f11273a.f12947g.iterator();
            while (it.hasNext()) {
                ((C2565g) it.next()).mo2330a(i, j);
            }
        }

        /* renamed from: a */
        public void mo2329a(int i, int i2, int i3, float f) {
            Iterator it = this.f11273a.f12944d.iterator();
            while (it.hasNext()) {
                ((C2586b) it.next()).onVideoSizeChanged(i, i2, i3, f);
            }
            it = this.f11273a.f12947g.iterator();
            while (it.hasNext()) {
                ((C2565g) it.next()).mo2329a(i, i2, i3, f);
            }
        }

        /* renamed from: a */
        public void mo2332a(Surface surface) {
            Iterator it;
            if (this.f11273a.f12953m == surface) {
                it = this.f11273a.f12944d.iterator();
                while (it.hasNext()) {
                    ((C2586b) it.next()).onRenderedFirstFrame();
                }
            }
            it = this.f11273a.f12947g.iterator();
            while (it.hasNext()) {
                ((C2565g) it.next()).mo2332a(surface);
            }
        }

        /* renamed from: b */
        public void mo2337b(C2249d c2249d) {
            Iterator it = this.f11273a.f12947g.iterator();
            while (it.hasNext()) {
                ((C2565g) it.next()).mo2337b(c2249d);
            }
            this.f11273a.f12951k = null;
            this.f11273a.f12958r = null;
        }

        /* renamed from: c */
        public void mo2340c(C2249d c2249d) {
            this.f11273a.f12959s = c2249d;
            Iterator it = this.f11273a.f12948h.iterator();
            while (it.hasNext()) {
                ((C2230e) it.next()).mo2340c(c2249d);
            }
        }

        /* renamed from: a */
        public void mo2328a(int i) {
            this.f11273a.f12960t = i;
            Iterator it = this.f11273a.f12948h.iterator();
            while (it.hasNext()) {
                ((C2230e) it.next()).mo2328a(i);
            }
        }

        /* renamed from: b */
        public void mo2339b(String str, long j, long j2) {
            Iterator it = this.f11273a.f12948h.iterator();
            while (it.hasNext()) {
                ((C2230e) it.next()).mo2339b(str, j, j2);
            }
        }

        /* renamed from: b */
        public void mo2338b(C2515k c2515k) {
            this.f11273a.f12952l = c2515k;
            Iterator it = this.f11273a.f12948h.iterator();
            while (it.hasNext()) {
                ((C2230e) it.next()).mo2338b(c2515k);
            }
        }

        /* renamed from: a */
        public void mo2331a(int i, long j, long j2) {
            Iterator it = this.f11273a.f12948h.iterator();
            while (it.hasNext()) {
                ((C2230e) it.next()).mo2331a(i, j, j2);
            }
        }

        /* renamed from: d */
        public void mo2341d(C2249d c2249d) {
            Iterator it = this.f11273a.f12948h.iterator();
            while (it.hasNext()) {
                ((C2230e) it.next()).mo2341d(c2249d);
            }
            this.f11273a.f12952l = null;
            this.f11273a.f12959s = null;
            this.f11273a.f12960t = 0;
        }

        /* renamed from: a */
        public void mo2327a(List<C2458b> list) {
            Iterator it = this.f11273a.f12945e.iterator();
            while (it.hasNext()) {
                ((C2475k) it.next()).mo2327a(list);
            }
        }

        /* renamed from: a */
        public void mo2334a(C2344a c2344a) {
            Iterator it = this.f11273a.f12946f.iterator();
            while (it.hasNext()) {
                ((C2367f) it.next()).mo2334a(c2344a);
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.f11273a.m16380a(surfaceHolder.getSurface(), false);
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f11273a.m16380a(null, false);
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f11273a.m16380a(new Surface(surfaceTexture), true);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f11273a.m16380a(null, true);
            return true;
        }
    }

    protected C4734x(C2584w c2584w, C2487h c2487h, C2567n c2567n) {
        this.f12941a = c2584w.mo2158a(new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()), this.f12943c, this.f12943c, this.f12943c, this.f12943c);
        int i = 0;
        int i2 = 0;
        for (C4256t a : this.f12941a) {
            switch (a.mo3177a()) {
                case 1:
                    i2++;
                    break;
                case 2:
                    i++;
                    break;
                default:
                    break;
            }
        }
        this.f12949i = i;
        this.f12950j = i2;
        this.f12962v = 1.0f;
        this.f12960t = 0;
        this.f12961u = C2219b.f5278a;
        this.f12955o = 1;
        this.f12942b = m16391a(this.f12941a, c2487h, c2567n);
    }

    /* renamed from: a */
    public void m16395a(Surface surface) {
        m16389l();
        m16380a(surface, false);
    }

    /* renamed from: a */
    public void m16392a(float f) {
        this.f12962v = f;
        C2332c[] c2332cArr = new C2332c[this.f12950j];
        int i = 0;
        for (C2331b c2331b : this.f12941a) {
            if (c2331b.mo3177a() == 1) {
                int i2 = i + 1;
                c2332cArr[i] = new C2332c(c2331b, 2, Float.valueOf(f));
                i = i2;
            }
        }
        this.f12942b.mo3232a(c2332cArr);
    }

    /* renamed from: f */
    public C2515k m16408f() {
        return this.f12952l;
    }

    /* renamed from: g */
    public int m16409g() {
        return this.f12960t;
    }

    /* renamed from: a */
    public void m16399a(C2586b c2586b) {
        this.f12944d.add(c2586b);
    }

    @Deprecated
    /* renamed from: b */
    public void m16402b(C2586b c2586b) {
        this.f12944d.clear();
        if (c2586b != null) {
            m16399a(c2586b);
        }
    }

    /* renamed from: a */
    public void mo3230a(C2574a c2574a) {
        this.f12942b.mo3230a(c2574a);
    }

    /* renamed from: a */
    public int mo3225a() {
        return this.f12942b.mo3225a();
    }

    /* renamed from: a */
    public void mo3228a(C2423i c2423i) {
        this.f12942b.mo3228a(c2423i);
    }

    /* renamed from: a */
    public void mo3231a(boolean z) {
        this.f12942b.mo3231a(z);
    }

    /* renamed from: b */
    public boolean mo3234b() {
        return this.f12942b.mo3234b();
    }

    /* renamed from: a */
    public void mo3226a(int i) {
        this.f12942b.mo3226a(i);
    }

    /* renamed from: c */
    public void mo3235c() {
        this.f12942b.mo3235c();
    }

    /* renamed from: a */
    public void mo3227a(long j) {
        this.f12942b.mo3227a(j);
    }

    /* renamed from: a */
    public void mo3229a(C2573r c2573r) {
        this.f12942b.mo3229a(c2573r);
    }

    /* renamed from: d */
    public void mo3236d() {
        this.f12942b.mo3236d();
    }

    /* renamed from: e */
    public void mo3237e() {
        this.f12942b.mo3237e();
        m16389l();
        if (this.f12953m != null) {
            if (this.f12954n) {
                this.f12953m.release();
            }
            this.f12953m = null;
        }
    }

    /* renamed from: a */
    public void mo3232a(C2332c... c2332cArr) {
        this.f12942b.mo3232a(c2332cArr);
    }

    /* renamed from: b */
    public void mo3233b(C2332c... c2332cArr) {
        this.f12942b.mo3233b(c2332cArr);
    }

    /* renamed from: h */
    public long mo3238h() {
        return this.f12942b.mo3238h();
    }

    /* renamed from: i */
    public long mo3239i() {
        return this.f12942b.mo3239i();
    }

    /* renamed from: j */
    public long mo3240j() {
        return this.f12942b.mo3240j();
    }

    /* renamed from: k */
    public int mo3241k() {
        return this.f12942b.mo3241k();
    }

    /* renamed from: a */
    protected C4159f m16391a(C4256t[] c4256tArr, C2487h c2487h, C2567n c2567n) {
        return new C4723h(c4256tArr, c2487h, c2567n);
    }

    /* renamed from: l */
    private void m16389l() {
        if (this.f12957q != null) {
            if (this.f12957q.getSurfaceTextureListener() != this.f12943c) {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f12957q.setSurfaceTextureListener(null);
            }
            this.f12957q = null;
        }
        if (this.f12956p != null) {
            this.f12956p.removeCallback(this.f12943c);
            this.f12956p = null;
        }
    }

    /* renamed from: a */
    private void m16380a(Surface surface, boolean z) {
        C2332c[] c2332cArr = new C2332c[this.f12949i];
        int i = 0;
        for (C2331b c2331b : this.f12941a) {
            if (c2331b.mo3177a() == 2) {
                int i2 = i + 1;
                c2332cArr[i] = new C2332c(c2331b, 1, surface);
                i = i2;
            }
        }
        if (this.f12953m == null || this.f12953m == surface) {
            this.f12942b.mo3232a(c2332cArr);
        } else {
            this.f12942b.mo3233b(c2332cArr);
            if (this.f12954n) {
                this.f12953m.release();
            }
        }
        this.f12953m = surface;
        this.f12954n = z;
    }
}
