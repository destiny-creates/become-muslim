package com.facebook.ads.internal.view.p120f.p123c;

import android.content.Context;
import android.widget.TextView;
import com.facebook.ads.internal.p095j.C1402f;
import com.facebook.ads.internal.view.p120f.p121a.C3639c;
import com.facebook.ads.internal.view.p120f.p122b.C3660n;
import java.util.concurrent.TimeUnit;

/* renamed from: com.facebook.ads.internal.view.f.c.c */
public class C4590c extends C3639c {
    /* renamed from: a */
    private final TextView f12495a;
    /* renamed from: b */
    private final String f12496b;
    /* renamed from: c */
    private final C1402f<C3660n> f12497c = new C36741(this);

    /* renamed from: com.facebook.ads.internal.view.f.c.c$1 */
    class C36741 extends C1402f<C3660n> {
        /* renamed from: a */
        final /* synthetic */ C4590c f9790a;

        C36741(C4590c c4590c) {
            this.f9790a = c4590c;
        }

        /* renamed from: a */
        public Class<C3660n> mo930a() {
            return C3660n.class;
        }

        /* renamed from: a */
        public void m11975a(C3660n c3660n) {
            if (this.f9790a.getVideoView() != null) {
                this.f9790a.f12495a.setText(this.f9790a.m15827a((long) (this.f9790a.getVideoView().getDuration() - this.f9790a.getVideoView().getCurrentPositionInMillis())));
            }
        }
    }

    public C4590c(Context context, String str) {
        super(context);
        this.f12495a = new TextView(context);
        this.f12496b = str;
        addView(this.f12495a);
    }

    /* renamed from: a */
    private String m15827a(long j) {
        if (j <= 0) {
            return "00:00";
        }
        long toMinutes = TimeUnit.MILLISECONDS.toMinutes(j);
        j = TimeUnit.MILLISECONDS.toSeconds(j % 60000);
        if (this.f12496b.isEmpty()) {
            return String.format("%02d:%02d", new Object[]{Long.valueOf(toMinutes), Long.valueOf(j)});
        }
        return this.f12496b.replace("{{REMAINING_TIME}}", String.format("%02d:%02d", new Object[]{Long.valueOf(toMinutes), Long.valueOf(j)}));
    }

    /* renamed from: a */
    protected void mo2877a() {
        super.mo2877a();
        if (getVideoView() != null) {
            getVideoView().getEventBus().m4805a(this.f12497c);
        }
    }

    /* renamed from: b */
    protected void mo2878b() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().m4807b(this.f12497c);
        }
        super.mo2878b();
    }

    public void setCountdownTextColor(int i) {
        this.f12495a.setTextColor(i);
    }
}
