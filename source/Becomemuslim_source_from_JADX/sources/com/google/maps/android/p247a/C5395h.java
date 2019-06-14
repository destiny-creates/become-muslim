package com.google.maps.android.p247a;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.C0453g;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.maps.C5125c;
import com.google.android.gms.maps.C5125c.C5109b;
import com.google.android.gms.maps.model.C5137b;
import com.google.android.gms.maps.model.C5139g;
import com.google.android.gms.maps.model.C5143l;
import com.google.android.gms.maps.model.C5144p;
import com.google.android.gms.maps.model.C5145r;
import com.google.android.gms.maps.model.C7849h;
import com.google.android.gms.maps.model.C7851m;
import com.google.android.gms.maps.model.C7854q;
import com.google.android.gms.maps.model.C7855s;
import com.google.maps.android.C5397a.C5379a;
import com.google.maps.android.C5397a.C5380b;
import com.google.maps.android.p247a.p248a.C5381a;
import com.google.maps.android.p247a.p248a.C6917b;
import com.google.maps.android.p247a.p248a.C6918e;
import com.google.maps.android.p247a.p248a.C6919j;
import com.google.maps.android.p247a.p248a.C6920l;
import com.google.maps.android.p247a.p248a.C7920f;
import com.google.maps.android.p247a.p248a.C7921g;
import com.google.maps.android.p247a.p248a.C7922h;
import com.google.maps.android.p247a.p249b.C5384b;
import com.google.maps.android.p247a.p249b.C5387e;
import com.google.maps.android.p247a.p249b.C6923j;
import com.google.maps.android.p247a.p249b.C6925n;
import com.google.maps.android.p247a.p249b.C7926h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Renderer */
/* renamed from: com.google.maps.android.a.h */
public class C5395h {
    /* renamed from: a */
    private static final Object f18172a = null;
    /* renamed from: b */
    private C5125c f18173b;
    /* renamed from: c */
    private final C5381a<C5392b> f18174c = new C5381a();
    /* renamed from: d */
    private HashMap<String, C6925n> f18175d;
    /* renamed from: e */
    private HashMap<String, C6925n> f18176e;
    /* renamed from: f */
    private HashMap<String, String> f18177f;
    /* renamed from: g */
    private C5381a<C5392b> f18178g;
    /* renamed from: h */
    private HashMap<C5387e, C5139g> f18179h;
    /* renamed from: i */
    private final ArrayList<String> f18180i;
    /* renamed from: j */
    private final C0453g<String, Bitmap> f18181j;
    /* renamed from: k */
    private boolean f18182k;
    /* renamed from: l */
    private Context f18183l;
    /* renamed from: m */
    private ArrayList<C5384b> f18184m;
    /* renamed from: n */
    private final C6919j f18185n;
    /* renamed from: o */
    private final C6918e f18186o;
    /* renamed from: p */
    private final C6920l f18187p;

    /* compiled from: Renderer */
    /* renamed from: com.google.maps.android.a.h$1 */
    class C69291 implements C5109b {
        /* renamed from: a */
        final /* synthetic */ C5395h f24790a;

        public View getInfoWindow(C5143l c5143l) {
            return null;
        }

        C69291(C5395h c5395h) {
            this.f24790a = c5395h;
        }

        public View getInfoContents(C5143l c5143l) {
            View inflate = LayoutInflater.from(this.f24790a.f18183l).inflate(C5380b.amu_info_window, null);
            TextView textView = (TextView) inflate.findViewById(C5379a.window);
            if (c5143l.m21803d() != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(c5143l.m21800c());
                stringBuilder.append("<br>");
                stringBuilder.append(c5143l.m21803d());
                textView.setText(Html.fromHtml(stringBuilder.toString()));
            } else {
                textView.setText(Html.fromHtml(c5143l.m21800c()));
            }
            return inflate;
        }
    }

    public C5395h(C5125c c5125c, Context context) {
        this.f18173b = c5125c;
        this.f18183l = context;
        this.f18182k = null;
        this.f18181j = new C0453g(50);
        this.f18180i = new ArrayList();
        this.f18176e = new HashMap();
        this.f18185n = null;
        this.f18186o = null;
        this.f18187p = null;
        this.f18178g = new C5381a();
    }

    /* renamed from: a */
    public boolean m22929a() {
        return this.f18182k;
    }

    /* renamed from: a */
    protected void m22928a(boolean z) {
        this.f18182k = z;
    }

    /* renamed from: a */
    protected void m22923a(Object obj, C5392b c5392b) {
        this.f18178g.put(c5392b, obj);
    }

    /* renamed from: b */
    protected HashMap<? extends C5392b, Object> m22930b() {
        return this.f18174c;
    }

    /* renamed from: c */
    public ArrayList<String> m22931c() {
        return this.f18180i;
    }

    /* renamed from: d */
    public HashMap<String, C6925n> m22932d() {
        return this.f18176e;
    }

    /* renamed from: e */
    public HashMap<String, String> m22933e() {
        return this.f18177f;
    }

    /* renamed from: f */
    public C0453g<String, Bitmap> m22934f() {
        return this.f18181j;
    }

    /* renamed from: g */
    public HashMap<C5387e, C5139g> m22935g() {
        return this.f18179h;
    }

    /* renamed from: h */
    public ArrayList<C5384b> m22936h() {
        return this.f18184m;
    }

    /* renamed from: a */
    protected C6925n m22919a(String str) {
        return this.f18176e.get(str) != null ? (C6925n) this.f18176e.get(str) : (C6925n) this.f18176e.get(null);
    }

    /* renamed from: i */
    public void m22937i() {
        this.f18176e.putAll(this.f18175d);
    }

    /* renamed from: a */
    public void m22925a(HashMap<String, C6925n> hashMap) {
        this.f18176e.putAll(hashMap);
    }

    /* renamed from: a */
    public void m22924a(String str, Bitmap bitmap) {
        this.f18181j.a(str, bitmap);
    }

    /* renamed from: a */
    private void m22909a(C6917b c6917b) {
        if (c6917b.m32421e() == null) {
            c6917b.m32419a(this.f18185n);
        }
        if (c6917b.m32422f() == null) {
            c6917b.m32418a(this.f18186o);
        }
        if (c6917b.m32423g() == null) {
            c6917b.m32420a(this.f18187p);
        }
    }

    /* renamed from: a */
    protected void m22927a(HashMap<String, C6925n> hashMap, HashMap<String, String> hashMap2, HashMap<C6923j, Object> hashMap3, ArrayList<C5384b> arrayList, HashMap<C5387e, C5139g> hashMap4) {
        this.f18175d = hashMap;
        this.f18177f = hashMap2;
        this.f18174c.putAll(hashMap3);
        this.f18184m = arrayList;
        this.f18179h = hashMap4;
    }

    /* renamed from: a */
    public void m22922a(C5392b c5392b) {
        Object obj = f18172a;
        if (c5392b instanceof C6917b) {
            m22909a((C6917b) c5392b);
        }
        if (this.f18182k) {
            if (this.f18174c.containsKey(c5392b)) {
                C5395h.m22911a(this.f18174c.get(c5392b));
            }
            if (c5392b.m22894d()) {
                if (c5392b instanceof C6923j) {
                    C6923j c6923j = (C6923j) c5392b;
                    obj = m22920a(c6923j, c5392b.m22893c(), m22919a(c5392b.m22891b()), c6923j.m32462f(), C5395h.m22913b(c5392b));
                } else {
                    obj = m22921a(c5392b, c5392b.m22893c());
                }
            }
        }
        this.f18174c.put(c5392b, obj);
    }

    /* renamed from: a */
    public static void m22911a(Object obj) {
        if (obj instanceof C5143l) {
            ((C5143l) obj).m21788a();
        } else if (obj instanceof C5145r) {
            ((C5145r) obj).m21817a();
        } else if (obj instanceof C5144p) {
            ((C5144p) obj).m21806a();
        } else if (obj instanceof ArrayList) {
            obj = ((ArrayList) obj).iterator();
            while (obj.hasNext()) {
                C5395h.m22911a(obj.next());
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    protected java.lang.Object m22921a(com.google.maps.android.p247a.C5392b r3, com.google.maps.android.p247a.C5393c r4) {
        /*
        r2 = this;
        r0 = r4.mo4901c();
        r1 = r0.hashCode();
        switch(r1) {
            case -2116761119: goto L_0x0048;
            case -1065891849: goto L_0x003e;
            case -627102946: goto L_0x0034;
            case 77292912: goto L_0x002a;
            case 1267133722: goto L_0x0020;
            case 1806700869: goto L_0x0016;
            case 1950410960: goto L_0x000c;
            default: goto L_0x000b;
        };
    L_0x000b:
        goto L_0x0052;
    L_0x000c:
        r1 = "GeometryCollection";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0052;
    L_0x0014:
        r0 = 6;
        goto L_0x0053;
    L_0x0016:
        r1 = "LineString";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0052;
    L_0x001e:
        r0 = 1;
        goto L_0x0053;
    L_0x0020:
        r1 = "Polygon";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0052;
    L_0x0028:
        r0 = 2;
        goto L_0x0053;
    L_0x002a:
        r1 = "Point";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0052;
    L_0x0032:
        r0 = 0;
        goto L_0x0053;
    L_0x0034:
        r1 = "MultiLineString";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0052;
    L_0x003c:
        r0 = 4;
        goto L_0x0053;
    L_0x003e:
        r1 = "MultiPoint";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0052;
    L_0x0046:
        r0 = 3;
        goto L_0x0053;
    L_0x0048:
        r1 = "MultiPolygon";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0052;
    L_0x0050:
        r0 = 5;
        goto L_0x0053;
    L_0x0052:
        r0 = -1;
    L_0x0053:
        r1 = 0;
        switch(r0) {
            case 0: goto L_0x00c4;
            case 1: goto L_0x00a8;
            case 2: goto L_0x008c;
            case 3: goto L_0x007f;
            case 4: goto L_0x0072;
            case 5: goto L_0x0065;
            case 6: goto L_0x0058;
            default: goto L_0x0057;
        };
    L_0x0057:
        return r1;
    L_0x0058:
        r3 = (com.google.maps.android.p247a.p248a.C6917b) r3;
        r4 = (com.google.maps.android.p247a.p248a.C7918c) r4;
        r4 = r4.m38518b();
        r3 = r2.m22901a(r3, r4);
        return r3;
    L_0x0065:
        r3 = (com.google.maps.android.p247a.p248a.C6917b) r3;
        r3 = r3.m32423g();
        r4 = (com.google.maps.android.p247a.p248a.C7922h) r4;
        r3 = r2.m22904a(r3, r4);
        return r3;
    L_0x0072:
        r3 = (com.google.maps.android.p247a.p248a.C6917b) r3;
        r3 = r3.m32422f();
        r4 = (com.google.maps.android.p247a.p248a.C7920f) r4;
        r3 = r2.m22902a(r3, r4);
        return r3;
    L_0x007f:
        r3 = (com.google.maps.android.p247a.p248a.C6917b) r3;
        r3 = r3.m32421e();
        r4 = (com.google.maps.android.p247a.p248a.C7921g) r4;
        r3 = r2.m22903a(r3, r4);
        return r3;
    L_0x008c:
        r0 = r3 instanceof com.google.maps.android.p247a.p248a.C6917b;
        if (r0 == 0) goto L_0x0097;
    L_0x0090:
        r3 = (com.google.maps.android.p247a.p248a.C6917b) r3;
        r1 = r3.m32424h();
        goto L_0x00a1;
    L_0x0097:
        r0 = r3 instanceof com.google.maps.android.p247a.p249b.C6923j;
        if (r0 == 0) goto L_0x00a1;
    L_0x009b:
        r3 = (com.google.maps.android.p247a.p249b.C6923j) r3;
        r1 = r3.m32463g();
    L_0x00a1:
        r4 = (com.google.maps.android.p247a.C6921a) r4;
        r3 = r2.m22917a(r1, r4);
        return r3;
    L_0x00a8:
        r0 = r3 instanceof com.google.maps.android.p247a.p248a.C6917b;
        if (r0 == 0) goto L_0x00b3;
    L_0x00ac:
        r3 = (com.google.maps.android.p247a.p248a.C6917b) r3;
        r1 = r3.m32426j();
        goto L_0x00bd;
    L_0x00b3:
        r0 = r3 instanceof com.google.maps.android.p247a.p249b.C6923j;
        if (r0 == 0) goto L_0x00bd;
    L_0x00b7:
        r3 = (com.google.maps.android.p247a.p249b.C6923j) r3;
        r1 = r3.m32465i();
    L_0x00bd:
        r4 = (com.google.maps.android.p247a.p248a.C7919d) r4;
        r3 = r2.m22918a(r1, r4);
        return r3;
    L_0x00c4:
        r0 = r3 instanceof com.google.maps.android.p247a.p248a.C6917b;
        if (r0 == 0) goto L_0x00cf;
    L_0x00c8:
        r3 = (com.google.maps.android.p247a.p248a.C6917b) r3;
        r1 = r3.m32425i();
        goto L_0x00d9;
    L_0x00cf:
        r0 = r3 instanceof com.google.maps.android.p247a.p249b.C6923j;
        if (r0 == 0) goto L_0x00d9;
    L_0x00d3:
        r3 = (com.google.maps.android.p247a.p249b.C6923j) r3;
        r1 = r3.m32464h();
    L_0x00d9:
        r4 = (com.google.maps.android.p247a.p248a.C7923i) r4;
        r3 = r2.m22916a(r1, r4);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.a.h.a(com.google.maps.android.a.b, com.google.maps.android.a.c):java.lang.Object");
    }

    /* renamed from: a */
    protected java.lang.Object m22920a(com.google.maps.android.p247a.p249b.C6923j r11, com.google.maps.android.p247a.C5393c r12, com.google.maps.android.p247a.p249b.C6925n r13, com.google.maps.android.p247a.p249b.C6925n r14, boolean r15) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        r0 = r12.mo4901c();
        r1 = "drawOrder";
        r1 = r11.m22892b(r1);
        r2 = 0;
        r3 = 0;
        if (r1 == 0) goto L_0x001b;
    L_0x000e:
        r4 = "drawOrder";	 Catch:{ NumberFormatException -> 0x001a }
        r4 = r11.m22890a(r4);	 Catch:{ NumberFormatException -> 0x001a }
        r4 = java.lang.Float.parseFloat(r4);	 Catch:{ NumberFormatException -> 0x001a }
        r3 = r4;
        goto L_0x001b;
    L_0x001a:
        r1 = 0;
    L_0x001b:
        r4 = -1;
        r5 = r0.hashCode();
        r6 = 77292912; // 0x49b6570 float:3.653348E-36 double:3.81877725E-316;
        if (r5 == r6) goto L_0x0053;
    L_0x0025:
        r2 = 89139371; // 0x55028ab float:9.7875825E-36 double:4.4040701E-316;
        if (r5 == r2) goto L_0x0049;
    L_0x002a:
        r2 = 1267133722; // 0x4b86ed1a float:1.7685044E7 double:6.260472407E-315;
        if (r5 == r2) goto L_0x003f;
    L_0x002f:
        r2 = 1806700869; // 0x6bb01145 float:4.25705E26 double:8.926288317E-315;
        if (r5 == r2) goto L_0x0035;
    L_0x0034:
        goto L_0x005c;
    L_0x0035:
        r2 = "LineString";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x005c;
    L_0x003d:
        r2 = 1;
        goto L_0x005d;
    L_0x003f:
        r2 = "Polygon";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x005c;
    L_0x0047:
        r2 = 2;
        goto L_0x005d;
    L_0x0049:
        r2 = "MultiGeometry";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x005c;
    L_0x0051:
        r2 = 3;
        goto L_0x005d;
    L_0x0053:
        r5 = "Point";
        r0 = r0.equals(r5);
        if (r0 == 0) goto L_0x005c;
    L_0x005b:
        goto L_0x005d;
    L_0x005c:
        r2 = -1;
    L_0x005d:
        switch(r2) {
            case 0: goto L_0x00c3;
            case 1: goto L_0x0099;
            case 2: goto L_0x006f;
            case 3: goto L_0x0062;
            default: goto L_0x0060;
        };
    L_0x0060:
        r11 = 0;
        return r11;
    L_0x0062:
        r6 = r12;
        r6 = (com.google.maps.android.p247a.p249b.C7926h) r6;
        r4 = r10;
        r5 = r11;
        r7 = r13;
        r8 = r14;
        r9 = r15;
        r11 = r4.m22905a(r5, r6, r7, r8, r9);
        return r11;
    L_0x006f:
        r11 = r13.m32524n();
        if (r14 == 0) goto L_0x0079;
    L_0x0075:
        r10.m22907a(r11, r14);
        goto L_0x008a;
    L_0x0079:
        r13 = r13.m32520j();
        if (r13 == 0) goto L_0x008a;
    L_0x007f:
        r13 = r11.m38353f();
        r13 = com.google.maps.android.p247a.p249b.C6925n.m32493b(r13);
        r11.m38347b(r13);
    L_0x008a:
        r12 = (com.google.maps.android.p247a.C6921a) r12;
        r11 = r10.m22917a(r11, r12);
        r11.m21810a(r15);
        if (r1 == 0) goto L_0x0098;
    L_0x0095:
        r11.m21812b(r3);
    L_0x0098:
        return r11;
    L_0x0099:
        r11 = r13.m32523m();
        if (r14 == 0) goto L_0x00a3;
    L_0x009f:
        r10.m22908a(r11, r14);
        goto L_0x00b4;
    L_0x00a3:
        r13 = r13.m32518i();
        if (r13 == 0) goto L_0x00b4;
    L_0x00a9:
        r13 = r11.m38368c();
        r13 = com.google.maps.android.p247a.p249b.C6925n.m32493b(r13);
        r11.m38359a(r13);
    L_0x00b4:
        r12 = (com.google.maps.android.p247a.C6926e) r12;
        r11 = r10.m22918a(r11, r12);
        r11.m21822a(r15);
        if (r1 == 0) goto L_0x00c2;
    L_0x00bf:
        r11.m21824b(r3);
    L_0x00c2:
        return r11;
    L_0x00c3:
        r0 = r13.m32522l();
        if (r14 == 0) goto L_0x00d1;
    L_0x00c9:
        r2 = r13.m32513g();
        r10.m22906a(r0, r14, r2);
        goto L_0x00de;
    L_0x00d1:
        r14 = r13.m32513g();
        if (r14 == 0) goto L_0x00de;
    L_0x00d7:
        r14 = r13.m32513g();
        r10.m22912a(r14, r0);
    L_0x00de:
        r12 = (com.google.maps.android.p247a.p249b.C7927k) r12;
        r12 = r10.m22916a(r0, r12);
        r12.m21799b(r15);
        r10.m22910a(r13, r12, r11);
        if (r1 == 0) goto L_0x00ef;
    L_0x00ec:
        r12.m21789a(r3);
    L_0x00ef:
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.a.h.a(com.google.maps.android.a.b.j, com.google.maps.android.a.c, com.google.maps.android.a.b.n, com.google.maps.android.a.b.n, boolean):java.lang.Object");
    }

    /* renamed from: a */
    protected C5143l m22916a(C7851m c7851m, C6928g c6928g) {
        c7851m.m38317a(c6928g.m32531a());
        return this.f18173b.m21702a(c7851m);
    }

    /* renamed from: a */
    private void m22906a(C7851m c7851m, C6925n c6925n, String str) {
        C7851m l = c6925n.m32522l();
        if (c6925n.m32505c("heading")) {
            c7851m.m38321b(l.m38335j());
        }
        if (c6925n.m32505c("hotSpot")) {
            c7851m.m38316a(l.m38330e(), l.m38331f());
        }
        if (c6925n.m32505c("markerColor")) {
            c7851m.m38318a(l.m38329d());
        }
        if (c6925n.m32505c("iconUrl")) {
            m22912a(c6925n.m32513g(), c7851m);
        } else if (str != null) {
            m22912a(str, c7851m);
        }
    }

    /* renamed from: a */
    protected C5145r m22918a(C7855s c7855s, C6926e c6926e) {
        c7855s.m38361a(c6926e.mo6266a());
        c7855s = this.f18173b.m21704a(c7855s);
        c7855s.m21827c(true);
        return c7855s;
    }

    /* renamed from: a */
    private void m22908a(C7855s c7855s, C6925n c6925n) {
        C7855s m = c6925n.m32523m();
        if (c6925n.m32505c("outlineColor")) {
            c7855s.m38359a(m.m38368c());
        }
        if (c6925n.m32505c("width")) {
            c7855s.m38358a(m.m38364b());
        }
        if (c6925n.m32518i() != null) {
            c7855s.m38359a(C6925n.m32493b(m.m38368c()));
        }
    }

    /* renamed from: a */
    protected C5144p m22917a(C7854q c7854q, C6921a c6921a) {
        c7854q.m38342a(c6921a.mo6264a());
        for (Iterable b : c6921a.mo6265b()) {
            c7854q.m38348b(b);
        }
        c7854q = this.f18173b.m21703a(c7854q);
        c7854q.m21816c(true);
        return c7854q;
    }

    /* renamed from: a */
    private void m22907a(C7854q c7854q, C6925n c6925n) {
        C7854q n = c6925n.m32524n();
        if (c6925n.m32504c() && c6925n.m32505c("fillColor")) {
            c7854q.m38347b(n.m38353f());
        }
        if (c6925n.m32510e()) {
            if (c6925n.m32505c("outlineColor")) {
                c7854q.m38341a(n.m38350c());
            }
            if (c6925n.m32505c("width")) {
                c7854q.m38340a(n.m38345b());
            }
        }
        if (c6925n.m32520j() != null) {
            c7854q.m38347b(C6925n.m32493b(n.m38353f()));
        }
    }

    /* renamed from: a */
    private ArrayList<Object> m22901a(C6917b c6917b, List<C5393c> list) {
        ArrayList<Object> arrayList = new ArrayList();
        for (C5393c a : list) {
            arrayList.add(m22921a((C5392b) c6917b, a));
        }
        return arrayList;
    }

    /* renamed from: b */
    protected static boolean m22913b(C5392b c5392b) {
        return (c5392b.m22892b("visibility") && Integer.parseInt(c5392b.m22890a("visibility")) == null) ? null : true;
    }

    /* renamed from: a */
    public void m22926a(HashMap<String, String> hashMap, HashMap<String, C6925n> hashMap2) {
        for (String str : hashMap.keySet()) {
            String str2 = (String) hashMap.get(str);
            if (hashMap2.containsKey(str2)) {
                hashMap2.put(str, hashMap2.get(str2));
            }
        }
    }

    /* renamed from: a */
    private ArrayList<Object> m22905a(C6923j c6923j, C7926h c7926h, C6925n c6925n, C6925n c6925n2, boolean z) {
        ArrayList<Object> arrayList = new ArrayList();
        c7926h = c7926h.m38535b().iterator();
        while (c7926h.hasNext()) {
            arrayList.add(m22920a(c6923j, (C5393c) c7926h.next(), c6925n, c6925n2, z));
        }
        return arrayList;
    }

    /* renamed from: a */
    private ArrayList<C5143l> m22903a(C6919j c6919j, C7921g c7921g) {
        ArrayList<C5143l> arrayList = new ArrayList();
        for (C6928g a : c7921g.m38520b()) {
            arrayList.add(m22916a(c6919j.m32447m(), a));
        }
        return arrayList;
    }

    /* renamed from: a */
    private ArrayList<C5145r> m22902a(C6918e c6918e, C7920f c7920f) {
        ArrayList<C5145r> arrayList = new ArrayList();
        for (C6926e a : c7920f.m38519b()) {
            arrayList.add(m22918a(c6918e.m32434i(), a));
        }
        return arrayList;
    }

    /* renamed from: a */
    private ArrayList<C5144p> m22904a(C6920l c6920l, C7922h c7922h) {
        ArrayList<C5144p> arrayList = new ArrayList();
        for (C6921a a : c7922h.m38521b()) {
            arrayList.add(m22917a(c6920l.m32455i(), a));
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m22912a(String str, C7851m c7851m) {
        if (this.f18181j.a(str) != null) {
            c7851m.m38318a(C5137b.m21764a((Bitmap) this.f18181j.a(str)));
        } else if (this.f18180i.contains(str) == null) {
            this.f18180i.add(str);
        }
    }

    /* renamed from: a */
    public C5139g m22915a(C7849h c7849h) {
        return this.f18173b.m21701a(c7849h);
    }

    /* renamed from: a */
    private void m22910a(C6925n c6925n, C5143l c5143l, C6923j c6923j) {
        boolean b = c6923j.m22892b("name");
        boolean b2 = c6923j.m22892b("description");
        boolean f = c6925n.m32512f();
        boolean containsKey = c6925n.m32521k().containsKey("text");
        if (f && containsKey) {
            c5143l.m21793a((String) c6925n.m32521k().get("text"));
            mo4900j();
        } else if (f && b) {
            c5143l.m21793a(c6923j.m22890a("name"));
            mo4900j();
        } else if (b && b2) {
            c5143l.m21793a(c6923j.m22890a("name"));
            c5143l.m21798b(c6923j.m22890a("description"));
            mo4900j();
        } else if (b2) {
            c5143l.m21793a(c6923j.m22890a("description"));
            mo4900j();
        } else if (b) {
            c5143l.m21793a(c6923j.m22890a("name"));
            mo4900j();
        }
    }

    /* renamed from: j */
    private void mo4900j() {
        this.f18173b.m21711a(new C69291(this));
    }
}
