package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.InboxStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioAttributes.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: NotificationCompat */
public class ac {

    /* compiled from: NotificationCompat */
    /* renamed from: android.support.v4.app.ac$a */
    public static class C0278a {
        /* renamed from: a */
        final Bundle f683a;
        /* renamed from: b */
        public int f684b;
        /* renamed from: c */
        public CharSequence f685c;
        /* renamed from: d */
        public PendingIntent f686d;
        /* renamed from: e */
        private final ah[] f687e;
        /* renamed from: f */
        private final ah[] f688f;
        /* renamed from: g */
        private boolean f689g;

        /* compiled from: NotificationCompat */
        /* renamed from: android.support.v4.app.ac$a$a */
        public static final class C0277a {
            /* renamed from: a */
            private final int f677a;
            /* renamed from: b */
            private final CharSequence f678b;
            /* renamed from: c */
            private final PendingIntent f679c;
            /* renamed from: d */
            private boolean f680d;
            /* renamed from: e */
            private final Bundle f681e;
            /* renamed from: f */
            private ArrayList<ah> f682f;

            public C0277a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i, charSequence, pendingIntent, new Bundle(), null, true);
            }

            private C0277a(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, ah[] ahVarArr, boolean z) {
                this.f680d = true;
                this.f677a = i;
                this.f678b = C0279d.m770d(charSequence);
                this.f679c = pendingIntent;
                this.f681e = bundle;
                if (ahVarArr == null) {
                    i = 0;
                } else {
                    i = new ArrayList(Arrays.asList(ahVarArr));
                }
                this.f682f = i;
                this.f680d = z;
            }

            /* renamed from: a */
            public C0277a m760a(ah ahVar) {
                if (this.f682f == null) {
                    this.f682f = new ArrayList();
                }
                this.f682f.add(ahVar);
                return this;
            }

            /* renamed from: a */
            public C0278a m761a() {
                ah[] ahVarArr;
                List arrayList = new ArrayList();
                List arrayList2 = new ArrayList();
                if (this.f682f != null) {
                    Iterator it = this.f682f.iterator();
                    while (it.hasNext()) {
                        ah ahVar = (ah) it.next();
                        if (ahVar.m845e()) {
                            arrayList.add(ahVar);
                        } else {
                            arrayList2.add(ahVar);
                        }
                    }
                }
                ah[] ahVarArr2 = null;
                if (arrayList.isEmpty()) {
                    ahVarArr = null;
                } else {
                    ahVarArr = (ah[]) arrayList.toArray(new ah[arrayList.size()]);
                }
                if (!arrayList2.isEmpty()) {
                    ahVarArr2 = (ah[]) arrayList2.toArray(new ah[arrayList2.size()]);
                }
                return new C0278a(this.f677a, this.f678b, this.f679c, this.f681e, ahVarArr2, ahVarArr, this.f680d);
            }
        }

        public C0278a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i, charSequence, pendingIntent, new Bundle(), null, null, true);
        }

        C0278a(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, ah[] ahVarArr, ah[] ahVarArr2, boolean z) {
            this.f684b = i;
            this.f685c = C0279d.m770d(charSequence);
            this.f686d = pendingIntent;
            if (bundle == null) {
                bundle = new Bundle();
            }
            this.f683a = bundle;
            this.f687e = ahVarArr;
            this.f688f = ahVarArr2;
            this.f689g = z;
        }

        /* renamed from: a */
        public int m762a() {
            return this.f684b;
        }

        /* renamed from: b */
        public CharSequence m763b() {
            return this.f685c;
        }

        /* renamed from: c */
        public PendingIntent m764c() {
            return this.f686d;
        }

        /* renamed from: d */
        public Bundle m765d() {
            return this.f683a;
        }

        /* renamed from: e */
        public boolean m766e() {
            return this.f689g;
        }

        /* renamed from: f */
        public ah[] m767f() {
            return this.f687e;
        }

        /* renamed from: g */
        public ah[] m768g() {
            return this.f688f;
        }
    }

    /* compiled from: NotificationCompat */
    /* renamed from: android.support.v4.app.ac$d */
    public static class C0279d {
        /* renamed from: A */
        Bundle f690A;
        /* renamed from: B */
        int f691B;
        /* renamed from: C */
        int f692C;
        /* renamed from: D */
        Notification f693D;
        /* renamed from: E */
        RemoteViews f694E;
        /* renamed from: F */
        RemoteViews f695F;
        /* renamed from: G */
        RemoteViews f696G;
        /* renamed from: H */
        String f697H;
        /* renamed from: I */
        int f698I;
        /* renamed from: J */
        String f699J;
        /* renamed from: K */
        long f700K;
        /* renamed from: L */
        int f701L;
        /* renamed from: M */
        Notification f702M;
        @Deprecated
        /* renamed from: N */
        public ArrayList<String> f703N;
        /* renamed from: a */
        public Context f704a;
        /* renamed from: b */
        public ArrayList<C0278a> f705b;
        /* renamed from: c */
        CharSequence f706c;
        /* renamed from: d */
        CharSequence f707d;
        /* renamed from: e */
        PendingIntent f708e;
        /* renamed from: f */
        PendingIntent f709f;
        /* renamed from: g */
        RemoteViews f710g;
        /* renamed from: h */
        Bitmap f711h;
        /* renamed from: i */
        CharSequence f712i;
        /* renamed from: j */
        int f713j;
        /* renamed from: k */
        int f714k;
        /* renamed from: l */
        boolean f715l;
        /* renamed from: m */
        boolean f716m;
        /* renamed from: n */
        C0281g f717n;
        /* renamed from: o */
        CharSequence f718o;
        /* renamed from: p */
        CharSequence[] f719p;
        /* renamed from: q */
        int f720q;
        /* renamed from: r */
        int f721r;
        /* renamed from: s */
        boolean f722s;
        /* renamed from: t */
        String f723t;
        /* renamed from: u */
        boolean f724u;
        /* renamed from: v */
        String f725v;
        /* renamed from: w */
        boolean f726w;
        /* renamed from: x */
        boolean f727x;
        /* renamed from: y */
        boolean f728y;
        /* renamed from: z */
        String f729z;

        public C0279d(Context context, String str) {
            this.f705b = new ArrayList();
            this.f715l = true;
            this.f726w = false;
            this.f691B = 0;
            this.f692C = 0;
            this.f698I = 0;
            this.f701L = 0;
            this.f702M = new Notification();
            this.f704a = context;
            this.f697H = str;
            this.f702M.when = System.currentTimeMillis();
            this.f702M.audioStreamType = -1;
            this.f714k = 0;
            this.f703N = new ArrayList();
        }

        @Deprecated
        public C0279d(Context context) {
            this(context, null);
        }

        /* renamed from: a */
        public C0279d m775a(long j) {
            this.f702M.when = j;
            return this;
        }

        /* renamed from: a */
        public C0279d m785a(boolean z) {
            this.f715l = z;
            return this;
        }

        /* renamed from: a */
        public C0279d m772a(int i) {
            this.f702M.icon = i;
            return this;
        }

        /* renamed from: a */
        public C0279d m783a(CharSequence charSequence) {
            this.f706c = C0279d.m770d(charSequence);
            return this;
        }

        /* renamed from: b */
        public C0279d m789b(CharSequence charSequence) {
            this.f707d = C0279d.m770d(charSequence);
            return this;
        }

        /* renamed from: b */
        public C0279d m787b(int i) {
            this.f713j = i;
            return this;
        }

        /* renamed from: a */
        public C0279d m782a(RemoteViews remoteViews) {
            this.f702M.contentView = remoteViews;
            return this;
        }

        /* renamed from: a */
        public C0279d m776a(PendingIntent pendingIntent) {
            this.f708e = pendingIntent;
            return this;
        }

        /* renamed from: b */
        public C0279d m788b(PendingIntent pendingIntent) {
            this.f702M.deleteIntent = pendingIntent;
            return this;
        }

        /* renamed from: c */
        public C0279d m793c(CharSequence charSequence) {
            this.f702M.tickerText = C0279d.m770d(charSequence);
            return this;
        }

        /* renamed from: a */
        public C0279d m777a(Bitmap bitmap) {
            this.f711h = bitmap;
            return this;
        }

        /* renamed from: a */
        public C0279d m778a(Uri uri) {
            this.f702M.sound = uri;
            this.f702M.audioStreamType = -1;
            if (VERSION.SDK_INT >= 21) {
                this.f702M.audioAttributes = new Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        /* renamed from: a */
        public C0279d m786a(long[] jArr) {
            this.f702M.vibrate = jArr;
            return this;
        }

        /* renamed from: a */
        public C0279d m773a(int i, int i2, int i3) {
            this.f702M.ledARGB = i;
            this.f702M.ledOnMS = i2;
            this.f702M.ledOffMS = i3;
            i = (this.f702M.ledOnMS == 0 || this.f702M.ledOffMS == 0) ? 0 : 1;
            this.f702M.flags = i | (this.f702M.flags & -2);
            return this;
        }

        /* renamed from: b */
        public C0279d m791b(boolean z) {
            m769a(2, z);
            return this;
        }

        /* renamed from: c */
        public C0279d m794c(boolean z) {
            m769a(8, z);
            return this;
        }

        /* renamed from: d */
        public C0279d m796d(boolean z) {
            m769a(16, z);
            return this;
        }

        /* renamed from: e */
        public C0279d m798e(boolean z) {
            this.f726w = z;
            return this;
        }

        /* renamed from: c */
        public C0279d m792c(int i) {
            this.f702M.defaults = i;
            if ((i & 4) != 0) {
                i = this.f702M;
                i.flags |= 1;
            }
            return this;
        }

        /* renamed from: a */
        private void m769a(int i, boolean z) {
            if (z) {
                z = this.f702M;
                z.flags = i | z.flags;
                return;
            }
            z = this.f702M;
            z.flags = (~i) & z.flags;
        }

        /* renamed from: d */
        public C0279d m795d(int i) {
            this.f714k = i;
            return this;
        }

        /* renamed from: a */
        public C0279d m784a(String str) {
            this.f723t = str;
            return this;
        }

        /* renamed from: f */
        public C0279d m800f(boolean z) {
            this.f724u = z;
            return this;
        }

        /* renamed from: a */
        public C0279d m774a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f705b.add(new C0278a(i, charSequence, pendingIntent));
            return this;
        }

        /* renamed from: a */
        public C0279d m779a(C0278a c0278a) {
            this.f705b.add(c0278a);
            return this;
        }

        /* renamed from: a */
        public C0279d m781a(C0281g c0281g) {
            if (this.f717n != c0281g) {
                this.f717n = c0281g;
                if (this.f717n != null) {
                    this.f717n.m805a(this);
                }
            }
            return this;
        }

        /* renamed from: e */
        public C0279d m797e(int i) {
            this.f691B = i;
            return this;
        }

        /* renamed from: f */
        public C0279d m799f(int i) {
            this.f692C = i;
            return this;
        }

        /* renamed from: b */
        public C0279d m790b(String str) {
            this.f697H = str;
            return this;
        }

        /* renamed from: g */
        public C0279d m801g(int i) {
            this.f701L = i;
            return this;
        }

        /* renamed from: a */
        public C0279d m780a(C0280e c0280e) {
            c0280e.m802a(this);
            return this;
        }

        /* renamed from: a */
        public Notification m771a() {
            return new ad(this).m9446b();
        }

        /* renamed from: d */
        protected static CharSequence m770d(CharSequence charSequence) {
            if (charSequence == null) {
                return charSequence;
            }
            if (charSequence.length() > 5120) {
                charSequence = charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }
    }

    /* compiled from: NotificationCompat */
    /* renamed from: android.support.v4.app.ac$e */
    public interface C0280e {
        /* renamed from: a */
        C0279d m802a(C0279d c0279d);
    }

    /* compiled from: NotificationCompat */
    /* renamed from: android.support.v4.app.ac$g */
    public static abstract class C0281g {
        /* renamed from: a */
        protected C0279d f730a;
        /* renamed from: b */
        CharSequence f731b;
        /* renamed from: c */
        CharSequence f732c;
        /* renamed from: d */
        boolean f733d = false;

        /* renamed from: a */
        public void m803a(Bundle bundle) {
        }

        /* renamed from: a */
        public void mo178a(ab abVar) {
        }

        /* renamed from: b */
        public RemoteViews m806b(ab abVar) {
            return null;
        }

        /* renamed from: c */
        public RemoteViews m807c(ab abVar) {
            return null;
        }

        /* renamed from: d */
        public RemoteViews m808d(ab abVar) {
            return null;
        }

        /* renamed from: a */
        public void m805a(C0279d c0279d) {
            if (this.f730a != c0279d) {
                this.f730a = c0279d;
                if (this.f730a != null) {
                    this.f730a.m781a(this);
                }
            }
        }
    }

    /* compiled from: NotificationCompat */
    /* renamed from: android.support.v4.app.ac$b */
    public static class C3170b extends C0281g {
        /* renamed from: e */
        private Bitmap f8128e;
        /* renamed from: f */
        private Bitmap f8129f;
        /* renamed from: g */
        private boolean f8130g;

        /* renamed from: a */
        public C3170b m9436a(CharSequence charSequence) {
            this.c = C0279d.m770d(charSequence);
            this.d = true;
            return this;
        }

        /* renamed from: a */
        public C3170b m9435a(Bitmap bitmap) {
            this.f8128e = bitmap;
            return this;
        }

        /* renamed from: a */
        public void mo178a(ab abVar) {
            if (VERSION.SDK_INT >= 16) {
                abVar = new BigPictureStyle(abVar.mo179a()).setBigContentTitle(this.b).bigPicture(this.f8128e);
                if (this.f8130g) {
                    abVar.bigLargeIcon(this.f8129f);
                }
                if (this.d) {
                    abVar.setSummaryText(this.c);
                }
            }
        }
    }

    /* compiled from: NotificationCompat */
    /* renamed from: android.support.v4.app.ac$c */
    public static class C3171c extends C0281g {
        /* renamed from: e */
        private CharSequence f8131e;

        /* renamed from: a */
        public C3171c m9438a(CharSequence charSequence) {
            this.f8131e = C0279d.m770d(charSequence);
            return this;
        }

        /* renamed from: a */
        public void mo178a(ab abVar) {
            if (VERSION.SDK_INT >= 16) {
                abVar = new BigTextStyle(abVar.mo179a()).setBigContentTitle(this.b).bigText(this.f8131e);
                if (this.d) {
                    abVar.setSummaryText(this.c);
                }
            }
        }
    }

    /* compiled from: NotificationCompat */
    /* renamed from: android.support.v4.app.ac$f */
    public static class C3172f extends C0281g {
        /* renamed from: e */
        private ArrayList<CharSequence> f8132e = new ArrayList();

        /* renamed from: a */
        public C3172f m9440a(CharSequence charSequence) {
            this.b = C0279d.m770d(charSequence);
            return this;
        }

        /* renamed from: b */
        public C3172f m9442b(CharSequence charSequence) {
            this.f8132e.add(C0279d.m770d(charSequence));
            return this;
        }

        /* renamed from: a */
        public void mo178a(ab abVar) {
            if (VERSION.SDK_INT >= 16) {
                abVar = new InboxStyle(abVar.mo179a()).setBigContentTitle(this.b);
                if (this.d) {
                    abVar.setSummaryText(this.c);
                }
                Iterator it = this.f8132e.iterator();
                while (it.hasNext()) {
                    abVar.addLine((CharSequence) it.next());
                }
            }
        }
    }

    /* renamed from: a */
    public static Bundle m809a(Notification notification) {
        if (VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        return VERSION.SDK_INT >= 16 ? ae.m811a(notification) : null;
    }
}
