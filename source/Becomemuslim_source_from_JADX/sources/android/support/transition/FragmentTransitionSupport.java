package android.support.transition;

import android.graphics.Rect;
import android.support.transition.C0254u.C0252b;
import android.support.transition.C0254u.C0253c;
import android.support.v4.app.C0340w;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class FragmentTransitionSupport extends C0340w {
    /* renamed from: a */
    public boolean mo111a(Object obj) {
        return obj instanceof C0254u;
    }

    /* renamed from: b */
    public Object mo112b(Object obj) {
        return obj != null ? ((C0254u) obj).mo159m() : null;
    }

    /* renamed from: c */
    public Object mo117c(Object obj) {
        if (obj == null) {
            return null;
        }
        C3157y c3157y = new C3157y();
        c3157y.m9372b((C0254u) obj);
        return c3157y;
    }

    /* renamed from: a */
    public void mo107a(Object obj, View view, ArrayList<View> arrayList) {
        obj = (C3157y) obj;
        List g = obj.m668g();
        g.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C0340w.m1000a(g, (View) arrayList.get(i));
        }
        g.add(view);
        arrayList.add(view);
        mo109a(obj, (ArrayList) arrayList);
    }

    /* renamed from: a */
    public void mo106a(Object obj, View view) {
        if (view != null) {
            C0254u c0254u = (C0254u) obj;
            final Rect rect = new Rect();
            m1005a(view, rect);
            c0254u.mo148a(new C0252b(this) {
                /* renamed from: b */
                final /* synthetic */ FragmentTransitionSupport f8062b;
            });
        }
    }

    /* renamed from: a */
    public void mo109a(Object obj, ArrayList<View> arrayList) {
        C0254u c0254u = (C0254u) obj;
        if (c0254u != null) {
            int i = 0;
            int o;
            if (c0254u instanceof C3157y) {
                C3157y c3157y = (C3157y) c0254u;
                o = c3157y.mo160o();
                while (i < o) {
                    mo109a(c3157y.m9368b(i), (ArrayList) arrayList);
                    i++;
                }
            } else if (!m9280a(c0254u) && C0340w.m1001a(c0254u.m668g())) {
                o = arrayList.size();
                while (i < o) {
                    c0254u.mo152b((View) arrayList.get(i));
                    i++;
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m9280a(C0254u c0254u) {
        if (C0340w.m1001a(c0254u.m667f()) && C0340w.m1001a(c0254u.m669h())) {
            if (C0340w.m1001a((List) c0254u.m670i()) != null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    public Object mo103a(Object obj, Object obj2, Object obj3) {
        C3157y c3157y = new C3157y();
        if (obj != null) {
            c3157y.m9372b((C0254u) obj);
        }
        if (obj2 != null) {
            c3157y.m9372b((C0254u) obj2);
        }
        if (obj3 != null) {
            c3157y.m9372b((C0254u) obj3);
        }
        return c3157y;
    }

    /* renamed from: b */
    public void mo115b(Object obj, final View view, final ArrayList<View> arrayList) {
        ((C0254u) obj).mo146a(new C0253c(this) {
            /* renamed from: c */
            final /* synthetic */ FragmentTransitionSupport f8065c;

            /* renamed from: b */
            public void mo100b(C0254u c0254u) {
            }

            /* renamed from: c */
            public void mo101c(C0254u c0254u) {
            }

            /* renamed from: d */
            public void mo102d(C0254u c0254u) {
            }

            /* renamed from: a */
            public void mo99a(C0254u c0254u) {
                c0254u.mo151b((C0253c) this);
                view.setVisibility(8);
                c0254u = arrayList.size();
                for (int i = 0; i < c0254u; i++) {
                    ((View) arrayList.get(i)).setVisibility(0);
                }
            }
        });
    }

    /* renamed from: b */
    public Object mo113b(Object obj, Object obj2, Object obj3) {
        C0254u c0254u = (C0254u) obj;
        C0254u c0254u2 = (C0254u) obj2;
        C0254u c0254u3 = (C0254u) obj3;
        if (c0254u != null && c0254u2 != null) {
            c0254u = new C3157y().m9372b(c0254u).m9372b(c0254u2).m9363a(1);
        } else if (c0254u == null) {
            c0254u = c0254u2 != null ? c0254u2 : null;
        }
        if (c0254u3 == null) {
            return c0254u;
        }
        obj2 = new C3157y();
        if (c0254u != null) {
            obj2.m9372b(c0254u);
        }
        obj2.m9372b(c0254u3);
        return obj2;
    }

    /* renamed from: a */
    public void mo104a(ViewGroup viewGroup, Object obj) {
        C0256w.m678a(viewGroup, (C0254u) obj);
    }

    /* renamed from: a */
    public void mo108a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        final Object obj5 = obj2;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj6 = obj3;
        final ArrayList<View> arrayList5 = arrayList2;
        final Object obj7 = obj4;
        final ArrayList<View> arrayList6 = arrayList3;
        ((C0254u) obj).mo146a(new C0253c(this) {
            /* renamed from: g */
            final /* synthetic */ FragmentTransitionSupport f8072g;

            /* renamed from: a */
            public void mo99a(C0254u c0254u) {
            }

            /* renamed from: b */
            public void mo100b(C0254u c0254u) {
            }

            /* renamed from: c */
            public void mo101c(C0254u c0254u) {
            }

            /* renamed from: d */
            public void mo102d(C0254u c0254u) {
                if (obj5 != null) {
                    this.f8072g.mo116b(obj5, arrayList4, null);
                }
                if (obj6 != null) {
                    this.f8072g.mo116b(obj6, arrayList5, null);
                }
                if (obj7 != null) {
                    this.f8072g.mo116b(obj7, arrayList6, null);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo110a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        obj = (C3157y) obj;
        if (obj != null) {
            obj.m668g().clear();
            obj.m668g().addAll(arrayList2);
            mo116b(obj, (ArrayList) arrayList, (ArrayList) arrayList2);
        }
    }

    /* renamed from: b */
    public void mo116b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        C0254u c0254u = (C0254u) obj;
        int i = 0;
        int o;
        if (c0254u instanceof C3157y) {
            C3157y c3157y = (C3157y) c0254u;
            o = c3157y.mo160o();
            while (i < o) {
                mo116b(c3157y.m9368b(i), (ArrayList) arrayList, (ArrayList) arrayList2);
                i++;
            }
        } else if (!m9280a(c0254u)) {
            List g = c0254u.m668g();
            if (g.size() == arrayList.size() && g.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    o = 0;
                } else {
                    o = arrayList2.size();
                }
                while (i < o) {
                    c0254u.mo152b((View) arrayList2.get(i));
                    i++;
                }
                for (arrayList2 = arrayList.size() - 1; arrayList2 >= null; arrayList2--) {
                    c0254u.mo153c((View) arrayList.get(arrayList2));
                }
            }
        }
    }

    /* renamed from: b */
    public void mo114b(Object obj, View view) {
        if (obj != null) {
            ((C0254u) obj).mo152b(view);
        }
    }

    /* renamed from: c */
    public void mo118c(Object obj, View view) {
        if (obj != null) {
            ((C0254u) obj).mo153c(view);
        }
    }

    /* renamed from: a */
    public void mo105a(Object obj, final Rect rect) {
        if (obj != null) {
            ((C0254u) obj).mo148a(new C0252b(this) {
                /* renamed from: b */
                final /* synthetic */ FragmentTransitionSupport f8074b;
            });
        }
    }
}
