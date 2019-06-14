package com.facebook.ads.internal.view.p120f.p123c;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.facebook.ads.internal.view.p120f.p121a.C3639c;
import com.facebook.ads.internal.view.p120f.p122b.C3648b;
import com.facebook.ads.internal.view.p120f.p122b.C3649c;
import com.facebook.ads.internal.view.p120f.p122b.C3654h;
import com.facebook.ads.internal.view.p120f.p122b.C3655i;
import com.facebook.ads.internal.view.p120f.p122b.C3656j;
import com.facebook.ads.internal.view.p120f.p122b.C3657k;
import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.internal.view.f.c.b */
public class C4589b extends C3639c implements OnAudioFocusChangeListener {
    /* renamed from: a */
    private WeakReference<OnAudioFocusChangeListener> f12491a = null;
    /* renamed from: b */
    private final C3649c f12492b = new C45861(this);
    /* renamed from: c */
    private final C3655i f12493c = new C45872(this);
    /* renamed from: d */
    private final C3657k f12494d = new C45883(this);

    /* renamed from: com.facebook.ads.internal.view.f.c.b$1 */
    class C45861 extends C3649c {
        /* renamed from: a */
        final /* synthetic */ C4589b f12488a;

        C45861(C4589b c4589b) {
            this.f12488a = c4589b;
        }

        /* renamed from: a */
        public void m15815a(C3648b c3648b) {
            ((AudioManager) this.f12488a.getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(this.f12488a.f12491a == null ? null : (OnAudioFocusChangeListener) this.f12488a.f12491a.get());
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.b$2 */
    class C45872 extends C3655i {
        /* renamed from: a */
        final /* synthetic */ C4589b f12489a;

        C45872(C4589b c4589b) {
            this.f12489a = c4589b;
        }

        /* renamed from: a */
        public void m15817a(C3654h c3654h) {
            ((AudioManager) this.f12489a.getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(this.f12489a.f12491a == null ? null : (OnAudioFocusChangeListener) this.f12489a.f12491a.get());
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.b$3 */
    class C45883 extends C3657k {
        /* renamed from: a */
        final /* synthetic */ C4589b f12490a;

        /* renamed from: com.facebook.ads.internal.view.f.c.b$3$1 */
        class C16361 implements OnAudioFocusChangeListener {
            /* renamed from: a */
            final /* synthetic */ C45883 f4916a;

            C16361(C45883 c45883) {
                this.f4916a = c45883;
            }

            public void onAudioFocusChange(int i) {
                if (this.f4916a.f12490a.getVideoView() != null && i <= 0) {
                    this.f4916a.f12490a.getVideoView().m11917a(false);
                }
            }
        }

        C45883(C4589b c4589b) {
            this.f12490a = c4589b;
        }

        /* renamed from: a */
        public void m15819a(C3656j c3656j) {
            if (this.f12490a.f12491a == null || this.f12490a.f12491a.get() == null) {
                this.f12490a.f12491a = new WeakReference(new C16361(this));
            }
            ((AudioManager) this.f12490a.getContext().getApplicationContext().getSystemService("audio")).requestAudioFocus((OnAudioFocusChangeListener) this.f12490a.f12491a.get(), 3, 1);
        }
    }

    public C4589b(Context context) {
        super(context);
    }

    /* renamed from: a */
    protected void mo2877a() {
        super.mo2877a();
        if (getVideoView() != null) {
            getVideoView().getEventBus().m4804a(this.f12494d, this.f12492b, this.f12493c);
        }
    }

    /* renamed from: b */
    protected void mo2878b() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().m4806b(this.f12493c, this.f12492b, this.f12494d);
        }
        super.mo2878b();
    }

    public void onAudioFocusChange(int i) {
        if (getVideoView() != null && i <= 0) {
            getVideoView().m11917a(false);
        }
    }

    protected void onDetachedFromWindow() {
        ((AudioManager) getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(this.f12491a == null ? null : (OnAudioFocusChangeListener) this.f12491a.get());
        super.onDetachedFromWindow();
    }
}
