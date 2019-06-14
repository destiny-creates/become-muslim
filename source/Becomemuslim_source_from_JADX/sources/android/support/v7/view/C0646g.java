package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff.Mode;
import android.support.v4.p024c.p025a.C0350a;
import android.support.v4.view.C0497c;
import android.support.v4.view.C0506h;
import android.support.v7.p035a.C0591a.C0590j;
import android.support.v7.view.menu.C3276j;
import android.support.v7.view.menu.C4483k;
import android.support.v7.widget.al;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import com.facebook.soloader.MinElf;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: SupportMenuInflater */
/* renamed from: android.support.v7.view.g */
public class C0646g extends MenuInflater {
    /* renamed from: a */
    static final Class<?>[] f1667a = new Class[]{Context.class};
    /* renamed from: b */
    static final Class<?>[] f1668b = f1667a;
    /* renamed from: c */
    final Object[] f1669c;
    /* renamed from: d */
    final Object[] f1670d = this.f1669c;
    /* renamed from: e */
    Context f1671e;
    /* renamed from: f */
    private Object f1672f;

    /* compiled from: SupportMenuInflater */
    /* renamed from: android.support.v7.view.g$a */
    private static class C0644a implements OnMenuItemClickListener {
        /* renamed from: a */
        private static final Class<?>[] f1632a = new Class[]{MenuItem.class};
        /* renamed from: b */
        private Object f1633b;
        /* renamed from: c */
        private Method f1634c;

        public C0644a(Object obj, String str) {
            this.f1633b = obj;
            obj = obj.getClass();
            try {
                this.f1634c = obj.getMethod(str, f1632a);
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Couldn't resolve menu item onClick handler ");
                stringBuilder.append(str);
                stringBuilder.append(" in class ");
                stringBuilder.append(obj.getName());
                InflateException inflateException = new InflateException(stringBuilder.toString());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f1634c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1634c.invoke(this.f1633b, new Object[]{menuItem})).booleanValue();
                }
                this.f1634c.invoke(this.f1633b, new Object[]{menuItem});
                return true;
            } catch (MenuItem menuItem2) {
                throw new RuntimeException(menuItem2);
            }
        }
    }

    /* compiled from: SupportMenuInflater */
    /* renamed from: android.support.v7.view.g$b */
    private class C0645b {
        /* renamed from: A */
        private String f1635A;
        /* renamed from: B */
        private String f1636B;
        /* renamed from: C */
        private CharSequence f1637C;
        /* renamed from: D */
        private CharSequence f1638D;
        /* renamed from: E */
        private ColorStateList f1639E = null;
        /* renamed from: F */
        private Mode f1640F = null;
        /* renamed from: a */
        C0497c f1641a;
        /* renamed from: b */
        final /* synthetic */ C0646g f1642b;
        /* renamed from: c */
        private Menu f1643c;
        /* renamed from: d */
        private int f1644d;
        /* renamed from: e */
        private int f1645e;
        /* renamed from: f */
        private int f1646f;
        /* renamed from: g */
        private int f1647g;
        /* renamed from: h */
        private boolean f1648h;
        /* renamed from: i */
        private boolean f1649i;
        /* renamed from: j */
        private boolean f1650j;
        /* renamed from: k */
        private int f1651k;
        /* renamed from: l */
        private int f1652l;
        /* renamed from: m */
        private CharSequence f1653m;
        /* renamed from: n */
        private CharSequence f1654n;
        /* renamed from: o */
        private int f1655o;
        /* renamed from: p */
        private char f1656p;
        /* renamed from: q */
        private int f1657q;
        /* renamed from: r */
        private char f1658r;
        /* renamed from: s */
        private int f1659s;
        /* renamed from: t */
        private int f1660t;
        /* renamed from: u */
        private boolean f1661u;
        /* renamed from: v */
        private boolean f1662v;
        /* renamed from: w */
        private boolean f1663w;
        /* renamed from: x */
        private int f1664x;
        /* renamed from: y */
        private int f1665y;
        /* renamed from: z */
        private String f1666z;

        public C0645b(C0646g c0646g, Menu menu) {
            this.f1642b = c0646g;
            this.f1643c = menu;
            m2159a();
        }

        /* renamed from: a */
        public void m2159a() {
            this.f1644d = 0;
            this.f1645e = 0;
            this.f1646f = 0;
            this.f1647g = 0;
            this.f1648h = true;
            this.f1649i = true;
        }

        /* renamed from: a */
        public void m2160a(AttributeSet attributeSet) {
            attributeSet = this.f1642b.f1671e.obtainStyledAttributes(attributeSet, C0590j.MenuGroup);
            this.f1644d = attributeSet.getResourceId(C0590j.MenuGroup_android_id, 0);
            this.f1645e = attributeSet.getInt(C0590j.MenuGroup_android_menuCategory, 0);
            this.f1646f = attributeSet.getInt(C0590j.MenuGroup_android_orderInCategory, 0);
            this.f1647g = attributeSet.getInt(C0590j.MenuGroup_android_checkableBehavior, 0);
            this.f1648h = attributeSet.getBoolean(C0590j.MenuGroup_android_visible, true);
            this.f1649i = attributeSet.getBoolean(C0590j.MenuGroup_android_enabled, true);
            attributeSet.recycle();
        }

        /* renamed from: b */
        public void m2162b(AttributeSet attributeSet) {
            attributeSet = this.f1642b.f1671e.obtainStyledAttributes(attributeSet, C0590j.MenuItem);
            this.f1651k = attributeSet.getResourceId(C0590j.MenuItem_android_id, 0);
            this.f1652l = (attributeSet.getInt(C0590j.MenuItem_android_menuCategory, this.f1645e) & -65536) | (attributeSet.getInt(C0590j.MenuItem_android_orderInCategory, this.f1646f) & MinElf.PN_XNUM);
            this.f1653m = attributeSet.getText(C0590j.MenuItem_android_title);
            this.f1654n = attributeSet.getText(C0590j.MenuItem_android_titleCondensed);
            this.f1655o = attributeSet.getResourceId(C0590j.MenuItem_android_icon, 0);
            this.f1656p = m2156a(attributeSet.getString(C0590j.MenuItem_android_alphabeticShortcut));
            this.f1657q = attributeSet.getInt(C0590j.MenuItem_alphabeticModifiers, 4096);
            this.f1658r = m2156a(attributeSet.getString(C0590j.MenuItem_android_numericShortcut));
            this.f1659s = attributeSet.getInt(C0590j.MenuItem_numericModifiers, 4096);
            if (attributeSet.hasValue(C0590j.MenuItem_android_checkable)) {
                this.f1660t = attributeSet.getBoolean(C0590j.MenuItem_android_checkable, false);
            } else {
                this.f1660t = this.f1647g;
            }
            this.f1661u = attributeSet.getBoolean(C0590j.MenuItem_android_checked, false);
            this.f1662v = attributeSet.getBoolean(C0590j.MenuItem_android_visible, this.f1648h);
            this.f1663w = attributeSet.getBoolean(C0590j.MenuItem_android_enabled, this.f1649i);
            this.f1664x = attributeSet.getInt(C0590j.MenuItem_showAsAction, -1);
            this.f1636B = attributeSet.getString(C0590j.MenuItem_android_onClick);
            this.f1665y = attributeSet.getResourceId(C0590j.MenuItem_actionLayout, 0);
            this.f1666z = attributeSet.getString(C0590j.MenuItem_actionViewClass);
            this.f1635A = attributeSet.getString(C0590j.MenuItem_actionProviderClass);
            Object obj = this.f1635A != null ? 1 : null;
            if (obj != null && this.f1665y == 0 && this.f1666z == null) {
                this.f1641a = (C0497c) m2157a(this.f1635A, C0646g.f1668b, this.f1642b.f1670d);
            } else {
                if (obj != null) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f1641a = null;
            }
            this.f1637C = attributeSet.getText(C0590j.MenuItem_contentDescription);
            this.f1638D = attributeSet.getText(C0590j.MenuItem_tooltipText);
            if (attributeSet.hasValue(C0590j.MenuItem_iconTintMode)) {
                this.f1640F = al.m2612a(attributeSet.getInt(C0590j.MenuItem_iconTintMode, -1), this.f1640F);
            } else {
                this.f1640F = null;
            }
            if (attributeSet.hasValue(C0590j.MenuItem_iconTint)) {
                this.f1639E = attributeSet.getColorStateList(C0590j.MenuItem_iconTint);
            } else {
                this.f1639E = null;
            }
            attributeSet.recycle();
            this.f1650j = false;
        }

        /* renamed from: a */
        private char m2156a(String str) {
            return str == null ? '\u0000' : str.charAt(0);
        }

        /* renamed from: a */
        private void m2158a(MenuItem menuItem) {
            Object obj = null;
            menuItem.setChecked(this.f1661u).setVisible(this.f1662v).setEnabled(this.f1663w).setCheckable(this.f1660t >= 1).setTitleCondensed(this.f1654n).setIcon(this.f1655o);
            if (this.f1664x >= 0) {
                menuItem.setShowAsAction(this.f1664x);
            }
            if (this.f1636B != null) {
                if (this.f1642b.f1671e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new C0644a(this.f1642b.m2167a(), this.f1636B));
            }
            boolean z = menuItem instanceof C3276j;
            if (z) {
                C3276j c3276j = (C3276j) menuItem;
            }
            if (this.f1660t >= 2) {
                if (z) {
                    ((C3276j) menuItem).m10114a(true);
                } else if (menuItem instanceof C4483k) {
                    ((C4483k) menuItem).m15093a(true);
                }
            }
            if (this.f1666z != null) {
                menuItem.setActionView((View) m2157a(this.f1666z, C0646g.f1667a, this.f1642b.f1669c));
                obj = 1;
            }
            if (this.f1665y > 0) {
                if (obj == null) {
                    menuItem.setActionView(this.f1665y);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            if (this.f1641a != null) {
                C0506h.m1600a(menuItem, this.f1641a);
            }
            C0506h.m1604a(menuItem, this.f1637C);
            C0506h.m1606b(menuItem, this.f1638D);
            C0506h.m1605b(menuItem, this.f1656p, this.f1657q);
            C0506h.m1601a(menuItem, this.f1658r, this.f1659s);
            if (this.f1640F != null) {
                C0506h.m1603a(menuItem, this.f1640F);
            }
            if (this.f1639E != null) {
                C0506h.m1602a(menuItem, this.f1639E);
            }
        }

        /* renamed from: b */
        public void m2161b() {
            this.f1650j = true;
            m2158a(this.f1643c.add(this.f1644d, this.f1651k, this.f1652l, this.f1653m));
        }

        /* renamed from: c */
        public SubMenu m2163c() {
            this.f1650j = true;
            SubMenu addSubMenu = this.f1643c.addSubMenu(this.f1644d, this.f1651k, this.f1652l, this.f1653m);
            m2158a(addSubMenu.getItem());
            return addSubMenu;
        }

        /* renamed from: d */
        public boolean m2164d() {
            return this.f1650j;
        }

        /* renamed from: a */
        private <T> T m2157a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                clsArr = this.f1642b.f1671e.getClassLoader().loadClass(str).getConstructor(clsArr);
                clsArr.setAccessible(true);
                return clsArr.newInstance(objArr);
            } catch (Class<?>[] clsArr2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot instantiate class: ");
                stringBuilder.append(str);
                Log.w("SupportMenuInflater", stringBuilder.toString(), clsArr2);
                return null;
            }
        }
    }

    public C0646g(Context context) {
        super(context);
        this.f1671e = context;
        this.f1669c = new Object[]{context};
    }

    public void inflate(int i, Menu menu) {
        if (menu instanceof C0350a) {
            XmlResourceParser xmlResourceParser = null;
            try {
                i = this.f1671e.getResources().getLayout(i);
                try {
                    m2166a(i, Xml.asAttributeSet(i), menu);
                    if (i != 0) {
                        i.close();
                    }
                    return;
                } catch (XmlPullParserException e) {
                    menu = e;
                    Object obj = i;
                    throw new InflateException("Error inflating menu XML", menu);
                } catch (IOException e2) {
                    menu = e2;
                    xmlResourceParser = i;
                    throw new InflateException("Error inflating menu XML", menu);
                } catch (Throwable th) {
                    menu = th;
                    xmlResourceParser = i;
                    if (xmlResourceParser != null) {
                        xmlResourceParser.close();
                    }
                    throw menu;
                }
            } catch (XmlPullParserException e3) {
                menu = e3;
                throw new InflateException("Error inflating menu XML", menu);
            } catch (IOException e4) {
                menu = e4;
                throw new InflateException("Error inflating menu XML", menu);
            } catch (Throwable th2) {
                menu = th2;
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
                throw menu;
            }
        }
        super.inflate(i, menu);
    }

    /* renamed from: a */
    private void m2166a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        C0645b c0645b = new C0645b(this, menu);
        menu = xmlPullParser.getEventType();
        while (menu != 2) {
            menu = xmlPullParser.next();
            if (menu == 1) {
                break;
            }
        }
        menu = xmlPullParser.getName();
        if (menu.equals("menu")) {
            menu = xmlPullParser.next();
            int i = menu;
            Object obj = null;
            menu = null;
            Object obj2 = null;
            while (menu == null) {
                String name;
                switch (i) {
                    case 1:
                        throw new RuntimeException("Unexpected end of document");
                    case 2:
                        if (obj2 == null) {
                            name = xmlPullParser.getName();
                            if (!name.equals("group")) {
                                if (!name.equals("item")) {
                                    if (!name.equals("menu")) {
                                        obj = name;
                                        obj2 = 1;
                                        break;
                                    }
                                    m2166a(xmlPullParser, attributeSet, c0645b.m2163c());
                                    break;
                                }
                                c0645b.m2162b(attributeSet);
                                break;
                            }
                            c0645b.m2160a(attributeSet);
                            break;
                        }
                        break;
                    case 3:
                        name = xmlPullParser.getName();
                        if (obj2 == null || !name.equals(r6)) {
                            if (!name.equals("group")) {
                                if (!name.equals("item")) {
                                    if (!name.equals("menu")) {
                                        break;
                                    }
                                    menu = true;
                                    break;
                                } else if (!c0645b.m2164d()) {
                                    if (c0645b.f1641a != null && c0645b.f1641a.mo477e()) {
                                        c0645b.m2163c();
                                        break;
                                    } else {
                                        c0645b.m2161b();
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            c0645b.m2159a();
                            break;
                        }
                        obj = null;
                        obj2 = null;
                        break;
                    default:
                        break;
                }
                i = xmlPullParser.next();
            }
            return;
        }
        attributeSet = new StringBuilder();
        attributeSet.append("Expecting menu, got ");
        attributeSet.append(menu);
        throw new RuntimeException(attributeSet.toString());
    }

    /* renamed from: a */
    Object m2167a() {
        if (this.f1672f == null) {
            this.f1672f = m2165a(this.f1671e);
        }
        return this.f1672f;
    }

    /* renamed from: a */
    private Object m2165a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? m2165a(((ContextWrapper) obj).getBaseContext()) : obj;
    }
}
