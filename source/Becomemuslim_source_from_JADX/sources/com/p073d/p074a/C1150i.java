package com.p073d.p074a;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.react.uimanager.ViewProps;
import com.p073d.p074a.C1150i;
import com.p073d.p074a.C1166t;
import com.p073d.p074a.C3482m;
import com.p073d.p074a.p075a.C1131e;
import com.p073d.p074a.p075a.C4540a;
import com.p073d.p074a.p075a.C4541c;
import com.p073d.p074a.p075a.C4542d;
import com.p073d.p074a.p075a.C4543g;
import com.p073d.p074a.p075a.C4544h;
import com.p073d.p074a.p076b.C1139b;
import java.util.Map;

/* compiled from: IntegrationOperation */
/* renamed from: com.d.a.i */
abstract class C1150i {
    /* renamed from: a */
    static final C1150i f3256a = new C34745();
    /* renamed from: b */
    static final C1150i f3257b = new C34756();

    /* compiled from: IntegrationOperation */
    /* renamed from: com.d.a.i$5 */
    static class C34745 extends C1150i {
        public String toString() {
            return "Flush";
        }

        C34745() {
            super();
        }

        /* renamed from: a */
        void mo787a(String str, C1131e<?> c1131e, C3482m c3482m) {
            c1131e.mo797a();
        }
    }

    /* compiled from: IntegrationOperation */
    /* renamed from: com.d.a.i$6 */
    static class C34756 extends C1150i {
        public String toString() {
            return "Reset";
        }

        C34756() {
            super();
        }

        /* renamed from: a */
        void mo787a(String str, C1131e<?> c1131e, C3482m c3482m) {
            c1131e.m3965d();
        }
    }

    /* renamed from: a */
    abstract void mo787a(String str, C1131e<?> c1131e, C3482m c3482m);

    /* renamed from: a */
    static boolean m4073a(C1166t c1166t, String str) {
        boolean z = true;
        if (C1139b.m4023a((Map) c1166t) || "Segment.io".equals(str)) {
            return true;
        }
        if (c1166t.containsKey(str)) {
            z = c1166t.m4133b(str, true);
        } else if (c1166t.containsKey("All") != null) {
            z = c1166t.m4133b("All", true);
        }
        return z;
    }

    /* renamed from: a */
    static C1150i m4067a(final Activity activity, final Bundle bundle) {
        return new C1150i() {
            public String toString() {
                return "Activity Created";
            }

            /* renamed from: a */
            public void mo787a(String str, C1131e<?> c1131e, C3482m c3482m) {
                c1131e.m3956a(activity, bundle);
            }
        };
    }

    /* renamed from: a */
    static C1150i m4066a(final Activity activity) {
        return new C1150i() {
            public String toString() {
                return "Activity Started";
            }

            /* renamed from: a */
            public void mo787a(String str, C1131e<?> c1131e, C3482m c3482m) {
                c1131e.m3955a(activity);
            }
        };
    }

    /* renamed from: b */
    static C1150i m4074b(final Activity activity) {
        return new C1150i() {
            public String toString() {
                return "Activity Resumed";
            }

            /* renamed from: a */
            public void mo787a(String str, C1131e<?> c1131e, C3482m c3482m) {
                c1131e.m3962b(activity);
            }
        };
    }

    /* renamed from: c */
    static C1150i m4076c(final Activity activity) {
        return new C1150i() {
            public String toString() {
                return "Activity Paused";
            }

            /* renamed from: a */
            public void mo787a(String str, C1131e<?> c1131e, C3482m c3482m) {
                c1131e.m3964c(activity);
            }
        };
    }

    /* renamed from: d */
    static C1150i m4077d(final Activity activity) {
        return new C1150i() {
            public String toString() {
                return "Activity Stopped";
            }

            /* renamed from: a */
            public void mo787a(String str, C1131e<?> c1131e, C3482m c3482m) {
                c1131e.m3966d(activity);
            }
        };
    }

    /* renamed from: b */
    static C1150i m4075b(final Activity activity, final Bundle bundle) {
        return new C1150i() {
            public String toString() {
                return "Activity Save Instance";
            }

            /* renamed from: a */
            public void mo787a(String str, C1131e<?> c1131e, C3482m c3482m) {
                c1131e.m3963b(activity, bundle);
            }
        };
    }

    /* renamed from: e */
    static C1150i m4078e(final Activity activity) {
        return new C1150i() {
            public String toString() {
                return "Activity Destroyed";
            }

            /* renamed from: a */
            public void mo787a(String str, C1131e<?> c1131e, C3482m c3482m) {
                c1131e.m3967e(activity);
            }
        };
    }

    /* renamed from: a */
    static C1150i m4070a(final C4542d c4542d) {
        return new C1150i() {
            /* renamed from: a */
            public void mo787a(String str, C1131e<?> c1131e, C3482m c3482m) {
                if (C1150i.m4073a((C1166t) c4542d.m11120d(), str) != null) {
                    c1131e.mo800a(c4542d);
                }
            }

            public String toString() {
                return c4542d.toString();
            }
        };
    }

    /* renamed from: a */
    static C1150i m4069a(final C4541c c4541c) {
        return new C1150i() {
            /* renamed from: a */
            public void mo787a(String str, C1131e<?> c1131e, C3482m c3482m) {
                if (C1150i.m4073a((C1166t) c4541c.m11120d(), str) != null) {
                    c1131e.mo799a(c4541c);
                }
            }

            public String toString() {
                return c4541c.toString();
            }
        };
    }

    /* renamed from: a */
    static C1150i m4072a(final C4544h c4544h) {
        return new C1150i() {
            /* renamed from: a */
            public void mo787a(String str, C1131e<?> c1131e, C3482m c3482m) {
                Map d = c4544h.m11120d();
                Map c = c3482m.m11192c();
                if (C1139b.m4023a(c)) {
                    if (C1150i.m4073a((C1166t) d, str) != null) {
                        c1131e.mo802a(c4544h);
                    }
                    return;
                }
                c = c.m4129a(c4544h.m15451a());
                if (C1139b.m4023a(c)) {
                    if (C1150i.m4073a((C1166t) d, str) != null) {
                        c1131e.mo802a(c4544h);
                    }
                } else if (c.m4133b(ViewProps.ENABLED, true)) {
                    C1166t c1166t = new C1166t();
                    c = c.m4129a("integrations");
                    if (!C1139b.m4023a(c)) {
                        c1166t.putAll(c);
                    }
                    c1166t.putAll(d);
                    if (C1150i.m4073a(c1166t, str) != null) {
                        c1131e.mo802a(c4544h);
                    }
                }
            }

            public String toString() {
                return c4544h.toString();
            }
        };
    }

    /* renamed from: a */
    static C1150i m4071a(final C4543g c4543g) {
        return new C1150i() {
            /* renamed from: a */
            public void mo787a(String str, C1131e<?> c1131e, C3482m c3482m) {
                if (C1150i.m4073a((C1166t) c4543g.m11120d(), str) != null) {
                    c1131e.mo801a(c4543g);
                }
            }

            public String toString() {
                return c4543g.toString();
            }
        };
    }

    /* renamed from: a */
    static C1150i m4068a(final C4540a c4540a) {
        return new C1150i() {
            /* renamed from: a */
            public void mo787a(String str, C1131e<?> c1131e, C3482m c3482m) {
                if (C1150i.m4073a((C1166t) c4540a.m11120d(), str) != null) {
                    c1131e.mo798a(c4540a);
                }
            }

            public String toString() {
                return c4540a.toString();
            }
        };
    }

    private C1150i() {
    }
}
