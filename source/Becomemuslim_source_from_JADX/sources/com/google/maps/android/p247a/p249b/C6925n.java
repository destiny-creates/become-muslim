package com.google.maps.android.p247a.p249b;

import android.graphics.Color;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.maps.model.C5137b;
import com.google.android.gms.maps.model.C7851m;
import com.google.android.gms.maps.model.C7854q;
import com.google.android.gms.maps.model.C7855s;
import com.google.maps.android.p247a.C5396i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/* compiled from: KmlStyle */
/* renamed from: com.google.maps.android.a.b.n */
public class C6925n extends C5396i {
    /* renamed from: d */
    private final HashMap<String, String> f24775d = new HashMap();
    /* renamed from: e */
    private final HashSet<String> f24776e = new HashSet();
    /* renamed from: f */
    private boolean f24777f = true;
    /* renamed from: g */
    private boolean f24778g = true;
    /* renamed from: h */
    private String f24779h;
    /* renamed from: i */
    private double f24780i = 1.0d;
    /* renamed from: j */
    private String f24781j = null;
    /* renamed from: k */
    private boolean f24782k = false;
    /* renamed from: l */
    private boolean f24783l = false;
    /* renamed from: m */
    private boolean f24784m = false;
    /* renamed from: n */
    private float f24785n = 0.0f;

    C6925n() {
    }

    /* renamed from: a */
    void m32498a(String str) {
        this.f24775d.put("text", str);
    }

    /* renamed from: b */
    String m32500b() {
        return this.f24781j;
    }

    /* renamed from: b */
    void m32502b(String str) {
        this.f24781j = str;
    }

    /* renamed from: c */
    public boolean m32505c(String str) {
        return this.f24776e.contains(str);
    }

    /* renamed from: c */
    public boolean m32504c() {
        return this.f24777f;
    }

    /* renamed from: a */
    public void m32499a(boolean z) {
        this.f24777f = z;
    }

    /* renamed from: d */
    double m32506d() {
        return this.f24780i;
    }

    /* renamed from: a */
    void m32496a(double d) {
        this.f24780i = d;
        this.f24776e.add("iconScale");
    }

    /* renamed from: e */
    public boolean m32510e() {
        return this.f24778g;
    }

    /* renamed from: f */
    public boolean m32512f() {
        return this.f24775d.size() > 0;
    }

    /* renamed from: b */
    void m32503b(boolean z) {
        this.f24778g = z;
        this.f24776e.add("outline");
    }

    /* renamed from: g */
    public String m32513g() {
        return this.f24779h;
    }

    /* renamed from: d */
    void m32508d(String str) {
        this.f24779h = str;
        this.f24776e.add("iconUrl");
    }

    /* renamed from: e */
    void m32509e(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#");
        stringBuilder.append(C6925n.m32495k(str));
        m22941a((int) Color.parseColor(stringBuilder.toString()));
        this.f24776e.add("fillColor");
    }

    /* renamed from: f */
    void m32511f(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#");
        stringBuilder.append(C6925n.m32495k(str));
        this.f24785n = C6925n.m32494c(Color.parseColor(stringBuilder.toString()));
        this.a.m38318a(C5137b.m21762a(this.f24785n));
        this.f24776e.add("markerColor");
    }

    /* renamed from: c */
    private static float m32494c(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        return fArr[0];
    }

    /* renamed from: k */
    private static String m32495k(String str) {
        StringBuilder stringBuilder;
        if (str.length() > 6) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str.substring(0, 2));
            stringBuilder.append(str.substring(6, 8));
            stringBuilder.append(str.substring(4, 6));
            stringBuilder.append(str.substring(2, 4));
            str = stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str.substring(4, 6));
            stringBuilder.append(str.substring(2, 4));
            stringBuilder.append(str.substring(0, 2));
            str = stringBuilder.toString();
        }
        if (!str.substring(0, 1).equals(" ")) {
            return str;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        stringBuilder2.append(str.substring(1, str.length()));
        return stringBuilder2.toString();
    }

    /* renamed from: d */
    void m32507d(float f) {
        m22939a(f);
        this.f24776e.add("heading");
    }

    /* renamed from: b */
    void m32501b(float f, float f2, String str, String str2) {
        m22940a(f, f2, str, str2);
        this.f24776e.add("hotSpot");
    }

    /* renamed from: g */
    void m32514g(String str) {
        this.f24782k = str.equals("random");
        this.f24776e.add("iconColorMode");
    }

    /* renamed from: h */
    boolean m32516h() {
        return this.f24782k;
    }

    /* renamed from: h */
    void m32515h(String str) {
        this.f24783l = str.equals("random");
        this.f24776e.add("lineColorMode");
    }

    /* renamed from: i */
    public boolean m32518i() {
        return this.f24783l;
    }

    /* renamed from: i */
    void m32517i(String str) {
        this.f24784m = str.equals("random");
        this.f24776e.add("polyColorMode");
    }

    /* renamed from: j */
    public boolean m32520j() {
        return this.f24784m;
    }

    /* renamed from: j */
    void m32519j(String str) {
        C7855s c7855s = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#");
        stringBuilder.append(C6925n.m32495k(str));
        c7855s.m38359a(Color.parseColor(stringBuilder.toString()));
        C7854q c7854q = this.c;
        stringBuilder = new StringBuilder();
        stringBuilder.append("#");
        stringBuilder.append(str);
        c7854q.m38341a(Color.parseColor(stringBuilder.toString()));
        this.f24776e.add("outlineColor");
    }

    /* renamed from: a */
    void m32497a(Float f) {
        m22942b(f.floatValue());
        m22943c(f.floatValue());
        this.f24776e.add("width");
    }

    /* renamed from: k */
    public HashMap<String, String> m32521k() {
        return this.f24775d;
    }

    /* renamed from: a */
    private static C7851m m32490a(C7851m c7851m, boolean z, float f) {
        C7851m c7851m2 = new C7851m();
        c7851m2.m38321b(c7851m.m38335j());
        c7851m2.m38316a(c7851m.m38330e(), c7851m.m38331f());
        if (z) {
            c7851m.m38318a(C5137b.m21762a(C6925n.m32494c(C6925n.m32493b((int) f))));
        }
        c7851m2.m38318a(c7851m.m38329d());
        return c7851m2;
    }

    /* renamed from: a */
    private static C7855s m32492a(C7855s c7855s) {
        C7855s c7855s2 = new C7855s();
        c7855s2.m38359a(c7855s.m38368c());
        c7855s2.m38358a(c7855s.m38364b());
        return c7855s2;
    }

    /* renamed from: a */
    private static C7854q m32491a(C7854q c7854q, boolean z, boolean z2) {
        C7854q c7854q2 = new C7854q();
        if (z) {
            c7854q2.m38347b(c7854q.m38353f());
        }
        if (z2) {
            c7854q2.m38341a(c7854q.m38350c());
            c7854q2.m38340a(c7854q.m38345b());
        }
        return c7854q2;
    }

    /* renamed from: l */
    public C7851m m32522l() {
        return C6925n.m32490a(this.a, m32516h(), this.f24785n);
    }

    /* renamed from: m */
    public C7855s m32523m() {
        return C6925n.m32492a(this.b);
    }

    /* renamed from: n */
    public C7854q m32524n() {
        return C6925n.m32491a(this.c, this.f24777f, this.f24778g);
    }

    /* renamed from: b */
    public static int m32493b(int i) {
        Random random = new Random();
        int red = Color.red(i);
        int green = Color.green(i);
        i = Color.blue(i);
        if (red != 0) {
            red = random.nextInt(red);
        }
        if (i != 0) {
            i = random.nextInt(i);
        }
        if (green != 0) {
            green = random.nextInt(green);
        }
        return Color.rgb(red, green, i);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Style");
        stringBuilder.append("{");
        stringBuilder.append("\n balloon options=");
        stringBuilder.append(this.f24775d);
        stringBuilder.append(",\n fill=");
        stringBuilder.append(this.f24777f);
        stringBuilder.append(",\n outline=");
        stringBuilder.append(this.f24778g);
        stringBuilder.append(",\n icon url=");
        stringBuilder.append(this.f24779h);
        stringBuilder.append(",\n scale=");
        stringBuilder.append(this.f24780i);
        stringBuilder.append(",\n style id=");
        stringBuilder.append(this.f24781j);
        stringBuilder.append("\n}\n");
        return stringBuilder.toString();
    }
}
