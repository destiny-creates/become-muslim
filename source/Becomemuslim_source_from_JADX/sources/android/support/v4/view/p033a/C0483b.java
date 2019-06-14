package android.support.v4.view.p033a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import com.facebook.common.util.ByteConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;

/* compiled from: AccessibilityNodeInfoCompat */
/* renamed from: android.support.v4.view.a.b */
public class C0483b {
    /* renamed from: a */
    public int f1251a = -1;
    /* renamed from: b */
    private final AccessibilityNodeInfo f1252b;

    /* compiled from: AccessibilityNodeInfoCompat */
    /* renamed from: android.support.v4.view.a.b$a */
    public static class C0480a {
        /* renamed from: A */
        public static final C0480a f1218A = new C0480a(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_DOWN : null);
        /* renamed from: B */
        public static final C0480a f1219B = new C0480a(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_RIGHT : null);
        /* renamed from: C */
        public static final C0480a f1220C = new C0480a(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_CONTEXT_CLICK : null);
        /* renamed from: D */
        public static final C0480a f1221D;
        /* renamed from: a */
        public static final C0480a f1222a = new C0480a(1, null);
        /* renamed from: b */
        public static final C0480a f1223b = new C0480a(2, null);
        /* renamed from: c */
        public static final C0480a f1224c = new C0480a(4, null);
        /* renamed from: d */
        public static final C0480a f1225d = new C0480a(8, null);
        /* renamed from: e */
        public static final C0480a f1226e = new C0480a(16, null);
        /* renamed from: f */
        public static final C0480a f1227f = new C0480a(32, null);
        /* renamed from: g */
        public static final C0480a f1228g = new C0480a(64, null);
        /* renamed from: h */
        public static final C0480a f1229h = new C0480a(128, null);
        /* renamed from: i */
        public static final C0480a f1230i = new C0480a(256, null);
        /* renamed from: j */
        public static final C0480a f1231j = new C0480a(512, null);
        /* renamed from: k */
        public static final C0480a f1232k = new C0480a(1024, null);
        /* renamed from: l */
        public static final C0480a f1233l = new C0480a(2048, null);
        /* renamed from: m */
        public static final C0480a f1234m = new C0480a(4096, null);
        /* renamed from: n */
        public static final C0480a f1235n = new C0480a(Utility.DEFAULT_STREAM_BUFFER_SIZE, null);
        /* renamed from: o */
        public static final C0480a f1236o = new C0480a(16384, null);
        /* renamed from: p */
        public static final C0480a f1237p = new C0480a(32768, null);
        /* renamed from: q */
        public static final C0480a f1238q = new C0480a(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, null);
        /* renamed from: r */
        public static final C0480a f1239r = new C0480a(131072, null);
        /* renamed from: s */
        public static final C0480a f1240s = new C0480a(262144, null);
        /* renamed from: t */
        public static final C0480a f1241t = new C0480a(524288, null);
        /* renamed from: u */
        public static final C0480a f1242u = new C0480a(ByteConstants.MB, null);
        /* renamed from: v */
        public static final C0480a f1243v = new C0480a(2097152, null);
        /* renamed from: w */
        public static final C0480a f1244w = new C0480a(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SHOW_ON_SCREEN : null);
        /* renamed from: x */
        public static final C0480a f1245x = new C0480a(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_TO_POSITION : null);
        /* renamed from: y */
        public static final C0480a f1246y = new C0480a(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_UP : null);
        /* renamed from: z */
        public static final C0480a f1247z = new C0480a(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_LEFT : null);
        /* renamed from: E */
        final Object f1248E;

        static {
            Object obj = null;
            if (VERSION.SDK_INT >= 24) {
                obj = AccessibilityAction.ACTION_SET_PROGRESS;
            }
            f1221D = new C0480a(obj);
        }

        public C0480a(int i, CharSequence charSequence) {
            this(VERSION.SDK_INT >= 21 ? new AccessibilityAction(i, charSequence) : null);
        }

        C0480a(Object obj) {
            this.f1248E = obj;
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    /* renamed from: android.support.v4.view.a.b$b */
    public static class C0481b {
        /* renamed from: a */
        final Object f1249a;

        /* renamed from: a */
        public static C0481b m1496a(int i, int i2, boolean z, int i3) {
            if (VERSION.SDK_INT >= 21) {
                return new C0481b(CollectionInfo.obtain(i, i2, z, i3));
            }
            if (VERSION.SDK_INT >= 19) {
                return new C0481b(CollectionInfo.obtain(i, i2, z));
            }
            return new C0481b(0);
        }

        C0481b(Object obj) {
            this.f1249a = obj;
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    /* renamed from: android.support.v4.view.a.b$c */
    public static class C0482c {
        /* renamed from: a */
        final Object f1250a;

        /* renamed from: a */
        public static C0482c m1497a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            if (VERSION.SDK_INT >= 21) {
                return new C0482c(CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
            }
            if (VERSION.SDK_INT >= true) {
                return new C0482c(CollectionItemInfo.obtain(i, i2, i3, i4, z));
            }
            return new C0482c(0);
        }

        C0482c(Object obj) {
            this.f1250a = obj;
        }
    }

    /* renamed from: b */
    private static String m1500b(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case Utility.DEFAULT_STREAM_BUFFER_SIZE /*8192*/:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST /*65536*/:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    private C0483b(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f1252b = accessibilityNodeInfo;
    }

    /* renamed from: a */
    public static C0483b m1499a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new C0483b(accessibilityNodeInfo);
    }

    /* renamed from: a */
    public AccessibilityNodeInfo m1501a() {
        return this.f1252b;
    }

    /* renamed from: a */
    public static C0483b m1498a(C0483b c0483b) {
        return C0483b.m1499a(AccessibilityNodeInfo.obtain(c0483b.f1252b));
    }

    /* renamed from: a */
    public void m1504a(View view) {
        this.f1252b.setSource(view);
    }

    /* renamed from: b */
    public void m1511b(View view) {
        this.f1252b.addChild(view);
    }

    /* renamed from: b */
    public int m1509b() {
        return this.f1252b.getActions();
    }

    /* renamed from: a */
    public void m1502a(int i) {
        this.f1252b.addAction(i);
    }

    /* renamed from: a */
    public boolean m1508a(C0480a c0480a) {
        return VERSION.SDK_INT >= 21 ? this.f1252b.removeAction((AccessibilityAction) c0480a.f1248E) : null;
    }

    /* renamed from: c */
    public void m1516c(View view) {
        this.f1252b.setParent(view);
    }

    /* renamed from: a */
    public void m1503a(Rect rect) {
        this.f1252b.getBoundsInParent(rect);
    }

    /* renamed from: b */
    public void m1510b(Rect rect) {
        this.f1252b.setBoundsInParent(rect);
    }

    /* renamed from: c */
    public void m1515c(Rect rect) {
        this.f1252b.getBoundsInScreen(rect);
    }

    /* renamed from: d */
    public void m1520d(Rect rect) {
        this.f1252b.setBoundsInScreen(rect);
    }

    /* renamed from: c */
    public boolean m1519c() {
        return this.f1252b.isCheckable();
    }

    /* renamed from: a */
    public void m1507a(boolean z) {
        this.f1252b.setCheckable(z);
    }

    /* renamed from: d */
    public boolean m1524d() {
        return this.f1252b.isChecked();
    }

    /* renamed from: b */
    public void m1514b(boolean z) {
        this.f1252b.setChecked(z);
    }

    /* renamed from: e */
    public boolean m1527e() {
        return this.f1252b.isFocusable();
    }

    /* renamed from: c */
    public void m1518c(boolean z) {
        this.f1252b.setFocusable(z);
    }

    /* renamed from: f */
    public boolean m1530f() {
        return this.f1252b.isFocused();
    }

    /* renamed from: d */
    public void m1523d(boolean z) {
        this.f1252b.setFocused(z);
    }

    /* renamed from: g */
    public boolean m1532g() {
        return VERSION.SDK_INT >= 16 ? this.f1252b.isVisibleToUser() : false;
    }

    /* renamed from: e */
    public void m1526e(boolean z) {
        if (VERSION.SDK_INT >= 16) {
            this.f1252b.setVisibleToUser(z);
        }
    }

    /* renamed from: h */
    public boolean m1534h() {
        return VERSION.SDK_INT >= 16 ? this.f1252b.isAccessibilityFocused() : false;
    }

    /* renamed from: f */
    public void m1529f(boolean z) {
        if (VERSION.SDK_INT >= 16) {
            this.f1252b.setAccessibilityFocused(z);
        }
    }

    /* renamed from: i */
    public boolean m1536i() {
        return this.f1252b.isSelected();
    }

    /* renamed from: g */
    public void m1531g(boolean z) {
        this.f1252b.setSelected(z);
    }

    /* renamed from: j */
    public boolean m1538j() {
        return this.f1252b.isClickable();
    }

    /* renamed from: h */
    public void m1533h(boolean z) {
        this.f1252b.setClickable(z);
    }

    /* renamed from: k */
    public boolean m1540k() {
        return this.f1252b.isLongClickable();
    }

    /* renamed from: i */
    public void m1535i(boolean z) {
        this.f1252b.setLongClickable(z);
    }

    /* renamed from: l */
    public boolean m1542l() {
        return this.f1252b.isEnabled();
    }

    /* renamed from: j */
    public void m1537j(boolean z) {
        this.f1252b.setEnabled(z);
    }

    /* renamed from: m */
    public boolean m1543m() {
        return this.f1252b.isPassword();
    }

    /* renamed from: n */
    public boolean m1544n() {
        return this.f1252b.isScrollable();
    }

    /* renamed from: k */
    public void m1539k(boolean z) {
        this.f1252b.setScrollable(z);
    }

    /* renamed from: o */
    public CharSequence m1545o() {
        return this.f1252b.getPackageName();
    }

    /* renamed from: a */
    public void m1505a(CharSequence charSequence) {
        this.f1252b.setPackageName(charSequence);
    }

    /* renamed from: p */
    public CharSequence m1546p() {
        return this.f1252b.getClassName();
    }

    /* renamed from: b */
    public void m1512b(CharSequence charSequence) {
        this.f1252b.setClassName(charSequence);
    }

    /* renamed from: q */
    public CharSequence m1547q() {
        return this.f1252b.getText();
    }

    /* renamed from: c */
    public void m1517c(CharSequence charSequence) {
        this.f1252b.setText(charSequence);
    }

    /* renamed from: r */
    public CharSequence m1548r() {
        return this.f1252b.getContentDescription();
    }

    /* renamed from: d */
    public void m1522d(CharSequence charSequence) {
        this.f1252b.setContentDescription(charSequence);
    }

    /* renamed from: s */
    public void m1549s() {
        this.f1252b.recycle();
    }

    /* renamed from: t */
    public String m1550t() {
        return VERSION.SDK_INT >= 18 ? this.f1252b.getViewIdResourceName() : null;
    }

    /* renamed from: a */
    public void m1506a(Object obj) {
        if (VERSION.SDK_INT >= 19) {
            this.f1252b.setCollectionInfo((CollectionInfo) ((C0481b) obj).f1249a);
        }
    }

    /* renamed from: b */
    public void m1513b(Object obj) {
        if (VERSION.SDK_INT >= 19) {
            this.f1252b.setCollectionItemInfo((CollectionItemInfo) ((C0482c) obj).f1250a);
        }
    }

    /* renamed from: l */
    public void m1541l(boolean z) {
        if (VERSION.SDK_INT >= 19) {
            this.f1252b.setContentInvalid(z);
        }
    }

    /* renamed from: e */
    public void m1525e(CharSequence charSequence) {
        if (VERSION.SDK_INT >= 21) {
            this.f1252b.setError(charSequence);
        }
    }

    /* renamed from: d */
    public void m1521d(View view) {
        if (VERSION.SDK_INT >= 17) {
            this.f1252b.setLabelFor(view);
        }
    }

    /* renamed from: f */
    public void m1528f(CharSequence charSequence) {
        if (VERSION.SDK_INT >= 19) {
            this.f1252b.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
        }
    }

    public int hashCode() {
        return this.f1252b == null ? 0 : this.f1252b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0483b c0483b = (C0483b) obj;
        if (this.f1252b == null) {
            if (c0483b.f1252b != null) {
                return false;
            }
        } else if (this.f1252b.equals(c0483b.f1252b) == null) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        m1503a(rect);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("; boundsInParent: ");
        stringBuilder2.append(rect);
        stringBuilder.append(stringBuilder2.toString());
        m1515c(rect);
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("; boundsInScreen: ");
        stringBuilder2.append(rect);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append("; packageName: ");
        stringBuilder.append(m1545o());
        stringBuilder.append("; className: ");
        stringBuilder.append(m1546p());
        stringBuilder.append("; text: ");
        stringBuilder.append(m1547q());
        stringBuilder.append("; contentDescription: ");
        stringBuilder.append(m1548r());
        stringBuilder.append("; viewId: ");
        stringBuilder.append(m1550t());
        stringBuilder.append("; checkable: ");
        stringBuilder.append(m1519c());
        stringBuilder.append("; checked: ");
        stringBuilder.append(m1524d());
        stringBuilder.append("; focusable: ");
        stringBuilder.append(m1527e());
        stringBuilder.append("; focused: ");
        stringBuilder.append(m1530f());
        stringBuilder.append("; selected: ");
        stringBuilder.append(m1536i());
        stringBuilder.append("; clickable: ");
        stringBuilder.append(m1538j());
        stringBuilder.append("; longClickable: ");
        stringBuilder.append(m1540k());
        stringBuilder.append("; enabled: ");
        stringBuilder.append(m1542l());
        stringBuilder.append("; password: ");
        stringBuilder.append(m1543m());
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("; scrollable: ");
        stringBuilder3.append(m1544n());
        stringBuilder.append(stringBuilder3.toString());
        stringBuilder.append("; [");
        int b = m1509b();
        while (b != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b);
            b &= ~numberOfTrailingZeros;
            stringBuilder.append(C0483b.m1500b(numberOfTrailingZeros));
            if (b != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
