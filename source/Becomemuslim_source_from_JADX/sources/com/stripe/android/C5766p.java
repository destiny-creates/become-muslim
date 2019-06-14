package com.stripe.android;

import android.content.Context;
import android.os.AsyncTask;
import com.facebook.share.internal.ShareConstants;
import com.stripe.android.C5770q.C5767a;
import com.stripe.android.p285b.C5722b;
import com.stripe.android.p285b.C5728m;
import com.stripe.android.p285b.C7157c;
import com.stripe.android.p285b.C7162i;
import com.stripe.android.p285b.C7168u;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: Stripe */
/* renamed from: com.stripe.android.p */
public class C5766p {
    /* renamed from: a */
    C5764b f19143a = new C71721(this);
    /* renamed from: b */
    C5765c f19144b = new C71732(this);
    /* renamed from: c */
    private Context f19145c;
    /* renamed from: d */
    private C5767a f19146d;
    /* renamed from: e */
    private String f19147e;
    /* renamed from: f */
    private String f19148f;

    /* compiled from: Stripe */
    /* renamed from: com.stripe.android.p$a */
    private class C5763a {
        /* renamed from: a */
        final C7162i f19139a;
        /* renamed from: b */
        final C7168u f19140b;
        /* renamed from: c */
        final Exception f19141c;
        /* renamed from: d */
        final /* synthetic */ C5766p f19142d;

        private C5763a(C5766p c5766p, C7168u c7168u) {
            this.f19142d = c5766p;
            this.f19140b = c7168u;
            this.f19139a = null;
            this.f19141c = null;
        }

        private C5763a(C5766p c5766p, C7162i c7162i) {
            this.f19142d = c5766p;
            this.f19139a = c7162i;
            this.f19141c = null;
            this.f19140b = null;
        }

        private C5763a(C5766p c5766p, Exception exception) {
            this.f19142d = c5766p;
            this.f19141c = exception;
            this.f19139a = null;
            this.f19140b = null;
        }
    }

    /* compiled from: Stripe */
    /* renamed from: com.stripe.android.p$b */
    interface C5764b {
        /* renamed from: a */
        void mo5069a(C5728m c5728m, String str, String str2, Executor executor, C5760o c5760o);
    }

    /* compiled from: Stripe */
    /* renamed from: com.stripe.android.p$c */
    interface C5765c {
        /* renamed from: a */
        void mo5070a(Map<String, Object> map, String str, String str2, String str3, Executor executor, C5817w c5817w);
    }

    /* compiled from: Stripe */
    /* renamed from: com.stripe.android.p$1 */
    class C71721 implements C5764b {
        /* renamed from: a */
        final /* synthetic */ C5766p f25434a;

        C71721(C5766p c5766p) {
            this.f25434a = c5766p;
        }

        /* renamed from: a */
        public void mo5069a(C5728m c5728m, String str, String str2, Executor executor, C5760o c5760o) {
            final C5728m c5728m2 = c5728m;
            final String str3 = str;
            final String str4 = str2;
            final C5760o c5760o2 = c5760o;
            this.f25434a.m24347a(executor, new AsyncTask<Void, Void, C5763a>(this) {
                /* renamed from: e */
                final /* synthetic */ C71721 f19132e;

                protected /* synthetic */ Object doInBackground(Object[] objArr) {
                    return m24336a((Void[]) objArr);
                }

                protected /* synthetic */ void onPostExecute(Object obj) {
                    m24337a((C5763a) obj);
                }

                /* renamed from: a */
                protected C5763a m24336a(Void... voidArr) {
                    try {
                        return new C5763a(C5770q.m24365a(null, this.f19132e.f25434a.f19145c, c5728m2, str3, str4, null));
                    } catch (Exception e) {
                        return new C5763a(e);
                    }
                }

                /* renamed from: a */
                protected void m24337a(C5763a c5763a) {
                    if (c5763a.f19139a != null) {
                        c5760o2.mo5071a(c5763a.f19139a);
                    } else if (c5763a.f19141c != null) {
                        c5760o2.mo5072a(c5763a.f19141c);
                    }
                }
            });
        }
    }

    /* compiled from: Stripe */
    /* renamed from: com.stripe.android.p$2 */
    class C71732 implements C5765c {
        /* renamed from: a */
        final /* synthetic */ C5766p f25435a;

        C71732(C5766p c5766p) {
            this.f25435a = c5766p;
        }

        /* renamed from: a */
        public void mo5070a(Map<String, Object> map, String str, String str2, String str3, Executor executor, C5817w c5817w) {
            final String str4 = str;
            final String str5 = str2;
            final Map<String, Object> map2 = map;
            final String str6 = str3;
            final C5817w c5817w2 = c5817w;
            this.f25435a.m24347a(executor, new AsyncTask<Void, Void, C5763a>(this) {
                /* renamed from: f */
                final /* synthetic */ C71732 f19138f;

                protected /* synthetic */ Object doInBackground(Object[] objArr) {
                    return m24338a((Void[]) objArr);
                }

                protected /* synthetic */ void onPostExecute(Object obj) {
                    m24339a((C5763a) obj);
                }

                /* renamed from: a */
                protected C5763a m24338a(Void... voidArr) {
                    try {
                        return new C5763a(C5770q.m24368a(this.f19138f.f25435a.f19145c, map2, C5759n.m24327a(str4, str5, ShareConstants.FEED_SOURCE_PARAM).m24322a(), str6, this.f19138f.f25435a.f19146d));
                    } catch (Exception e) {
                        return new C5763a(e);
                    }
                }

                /* renamed from: a */
                protected void m24339a(C5763a c5763a) {
                    this.f19138f.f25435a.m24343a(c5763a, c5817w2);
                }
            });
        }
    }

    public C5766p(Context context) {
        this.f19145c = context;
    }

    public C5766p(Context context, String str) {
        this.f19145c = context;
        m24357a(str);
    }

    /* renamed from: a */
    public void m24352a(C5722b c5722b, String str, Executor executor, C5817w c5817w) {
        if (c5722b != null) {
            m24346a(C5772r.m24406a(this.f19145c, c5722b), str, "bank_account", executor, c5817w);
            return;
        }
        throw new RuntimeException("Required parameter: 'bankAccount' is requred to create a token");
    }

    /* renamed from: a */
    public void m24355a(C5728m c5728m, C5760o c5760o) {
        m24356a(c5728m, c5760o, null, null);
    }

    /* renamed from: a */
    public void m24356a(C5728m c5728m, C5760o c5760o, String str, Executor executor) {
        if (str == null) {
            str = this.f19147e;
        }
        String str2 = str;
        if (str2 != null) {
            this.f19143a.mo5069a(c5728m, str2, this.f19148f, executor, c5760o);
        }
    }

    /* renamed from: a */
    public void m24353a(C7157c c7157c, String str, C5817w c5817w) {
        m24354a(c7157c, str, null, c5817w);
    }

    /* renamed from: a */
    public void m24354a(C7157c c7157c, String str, Executor executor, C5817w c5817w) {
        if (c7157c != null) {
            m24346a(C5772r.m24407a(this.f19145c, c7157c), str, "card", executor, c5817w);
            return;
        }
        throw new RuntimeException("Required Parameter: 'card' is required to create a token");
    }

    /* renamed from: a */
    public C7162i m24350a(String str, String str2) {
        return m24351a(str, str2, null);
    }

    /* renamed from: a */
    public C7162i m24351a(String str, String str2, String str3) {
        if (str3 == null) {
            str3 = this.f19147e;
        }
        if (str3 == null) {
            return null;
        }
        return C5770q.m24367a(str, str2, str3);
    }

    /* renamed from: a */
    public void m24357a(String str) {
        m24349b(str);
        this.f19147e = str;
    }

    /* renamed from: a */
    private void m24346a(Map<String, Object> map, String str, String str2, Executor executor, C5817w c5817w) {
        if (c5817w != null) {
            m24349b(str);
            this.f19144b.mo5070a(map, str, this.f19148f, str2, executor, c5817w);
            return;
        }
        throw new RuntimeException("Required Parameter: 'callback' is required to use the created token and handle errors");
    }

    /* renamed from: b */
    private void m24349b(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Invalid Publishable Key: You must use a valid publishable key to create a token.  For more info, see https://stripe.com/docs/stripe.js.");
        } else if (str.startsWith("sk_") != null) {
            throw new IllegalArgumentException("Invalid Publishable Key: You are using a secret key to create a token, instead of the publishable one. For more info, see https://stripe.com/docs/stripe.js");
        }
    }

    /* renamed from: a */
    private void m24343a(C5763a c5763a, C5817w c5817w) {
        if (c5763a.f19140b != null) {
            c5817w.m24531a(c5763a.f19140b);
        } else if (c5763a.f19141c != null) {
            c5817w.m24532a(c5763a.f19141c);
        } else {
            c5817w.m24532a(new RuntimeException("Somehow got neither a token response or an error response"));
        }
    }

    /* renamed from: a */
    private void m24347a(Executor executor, AsyncTask<Void, Void, C5763a> asyncTask) {
        if (executor != null) {
            asyncTask.executeOnExecutor(executor, new Void[0]);
        } else {
            asyncTask.execute(new Void[0]);
        }
    }
}
