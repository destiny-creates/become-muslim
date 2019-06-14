package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.C0366b;
import android.support.v4.p024c.p025a.C0350a;
import android.support.v4.view.C0497c;
import android.support.v7.p035a.C0591a.C0582b;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.facebook.soloader.MinElf;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MenuBuilder */
/* renamed from: android.support.v7.view.menu.h */
public class C3273h implements C0350a {
    /* renamed from: d */
    private static final int[] f8484d = new int[]{1, 4, 5, 3, 2, 0};
    /* renamed from: a */
    CharSequence f8485a;
    /* renamed from: b */
    Drawable f8486b;
    /* renamed from: c */
    View f8487c;
    /* renamed from: e */
    private final Context f8488e;
    /* renamed from: f */
    private final Resources f8489f;
    /* renamed from: g */
    private boolean f8490g;
    /* renamed from: h */
    private boolean f8491h;
    /* renamed from: i */
    private C0657a f8492i;
    /* renamed from: j */
    private ArrayList<C3276j> f8493j;
    /* renamed from: k */
    private ArrayList<C3276j> f8494k;
    /* renamed from: l */
    private boolean f8495l;
    /* renamed from: m */
    private ArrayList<C3276j> f8496m;
    /* renamed from: n */
    private ArrayList<C3276j> f8497n;
    /* renamed from: o */
    private boolean f8498o;
    /* renamed from: p */
    private int f8499p = 0;
    /* renamed from: q */
    private ContextMenuInfo f8500q;
    /* renamed from: r */
    private boolean f8501r = false;
    /* renamed from: s */
    private boolean f8502s = false;
    /* renamed from: t */
    private boolean f8503t = false;
    /* renamed from: u */
    private boolean f8504u = false;
    /* renamed from: v */
    private boolean f8505v = false;
    /* renamed from: w */
    private ArrayList<C3276j> f8506w = new ArrayList();
    /* renamed from: x */
    private CopyOnWriteArrayList<WeakReference<C0662o>> f8507x = new CopyOnWriteArrayList();
    /* renamed from: y */
    private C3276j f8508y;
    /* renamed from: z */
    private boolean f8509z;

    /* compiled from: MenuBuilder */
    /* renamed from: android.support.v7.view.menu.h$a */
    public interface C0657a {
        /* renamed from: a */
        void mo388a(C3273h c3273h);

        /* renamed from: a */
        boolean mo389a(C3273h c3273h, MenuItem menuItem);
    }

    /* compiled from: MenuBuilder */
    /* renamed from: android.support.v7.view.menu.h$b */
    public interface C0658b {
        /* renamed from: a */
        boolean mo436a(C3276j c3276j);
    }

    /* renamed from: a */
    protected String mo2748a() {
        return "android:menu:actionviewstates";
    }

    /* renamed from: p */
    public C3273h mo2755p() {
        return this;
    }

    public C3273h(Context context) {
        this.f8488e = context;
        this.f8489f = context.getResources();
        this.f8493j = new ArrayList();
        this.f8494k = new ArrayList();
        this.f8495l = true;
        this.f8496m = new ArrayList();
        this.f8497n = new ArrayList();
        this.f8498o = true;
        m10051e(true);
    }

    /* renamed from: a */
    public C3273h m10054a(int i) {
        this.f8499p = i;
        return this;
    }

    /* renamed from: a */
    public void m10064a(C0662o c0662o) {
        m10065a(c0662o, this.f8488e);
    }

    /* renamed from: a */
    public void m10065a(C0662o c0662o, Context context) {
        this.f8507x.add(new WeakReference(c0662o));
        c0662o.mo463a(context, this);
        this.f8498o = true;
    }

    /* renamed from: b */
    public void m10075b(C0662o c0662o) {
        Iterator it = this.f8507x.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0662o c0662o2 = (C0662o) weakReference.get();
            if (c0662o2 == null || c0662o2 == c0662o) {
                this.f8507x.remove(weakReference);
            }
        }
    }

    /* renamed from: d */
    private void m10050d(boolean z) {
        if (!this.f8507x.isEmpty()) {
            m10088g();
            Iterator it = this.f8507x.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0662o c0662o = (C0662o) weakReference.get();
                if (c0662o == null) {
                    this.f8507x.remove(weakReference);
                } else {
                    c0662o.mo468b(z);
                }
            }
            m10089h();
        }
    }

    /* renamed from: a */
    private boolean m10049a(C4487u c4487u, C0662o c0662o) {
        boolean z = false;
        if (this.f8507x.isEmpty()) {
            return false;
        }
        if (c0662o != null) {
            z = c0662o.mo467a(c4487u);
        }
        c0662o = this.f8507x.iterator();
        while (c0662o.hasNext()) {
            WeakReference weakReference = (WeakReference) c0662o.next();
            C0662o c0662o2 = (C0662o) weakReference.get();
            if (c0662o2 == null) {
                this.f8507x.remove(weakReference);
            } else if (!z) {
                z = c0662o2.mo467a(c4487u);
            }
        }
        return z;
    }

    /* renamed from: a */
    public void m10061a(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((C4487u) item.getSubMenu()).m10061a(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(mo2748a(), sparseArray);
        }
    }

    /* renamed from: b */
    public void m10073b(Bundle bundle) {
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(mo2748a());
            int size = size();
            for (int i = 0; i < size; i++) {
                MenuItem item = getItem(i);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((C4487u) item.getSubMenu()).m10073b(bundle);
                }
            }
            bundle = bundle.getInt("android:menu:expandedactionview");
            if (bundle > null) {
                bundle = findItem(bundle);
                if (bundle != null) {
                    bundle.expandActionView();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo2749a(C0657a c0657a) {
        this.f8492i = c0657a;
    }

    /* renamed from: a */
    protected MenuItem m10059a(int i, int i2, int i3, CharSequence charSequence) {
        int f = C3273h.m10052f(i3);
        i = m10046a(i, i2, i3, f, charSequence, this.f8499p);
        if (this.f8500q != 0) {
            i.m10113a(this.f8500q);
        }
        this.f8493j.add(C3273h.m10045a(this.f8493j, f), i);
        m10076b((boolean) 1);
        return i;
    }

    /* renamed from: a */
    private C3276j m10046a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new C3276j(this, i, i2, i3, i4, charSequence, i5);
    }

    public MenuItem add(CharSequence charSequence) {
        return m10059a(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return m10059a(0, 0, 0, this.f8489f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m10059a(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m10059a(i, i2, i3, this.f8489f.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f8489f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C3276j c3276j = (C3276j) m10059a(i, i2, i3, charSequence);
        C4487u c4487u = new C4487u(this.f8488e, this, c3276j);
        c3276j.m10112a(c4487u);
        return c4487u;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f8489f.getString(i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f8488e.getPackageManager();
        int i5 = 0;
        componentName = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = componentName != null ? componentName.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        while (i5 < size) {
            ResolveInfo resolveInfo = (ResolveInfo) componentName.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
            i5++;
        }
        return size;
    }

    public void removeItem(int i) {
        m10048a(m10072b(i), true);
    }

    public void removeGroup(int i) {
        int c = m10078c(i);
        if (c >= 0) {
            int size = this.f8493j.size() - c;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || ((C3276j) this.f8493j.get(c)).getGroupId() != i) {
                    m10076b((boolean) 1);
                } else {
                    m10048a(c, false);
                    i2 = i3;
                }
            }
            m10076b((boolean) 1);
        }
    }

    /* renamed from: a */
    private void m10048a(int i, boolean z) {
        if (i >= 0) {
            if (i < this.f8493j.size()) {
                this.f8493j.remove(i);
                if (z) {
                    m10076b((boolean) 1);
                }
            }
        }
    }

    public void clear() {
        if (this.f8508y != null) {
            mo2754d(this.f8508y);
        }
        this.f8493j.clear();
        m10076b(true);
    }

    /* renamed from: a */
    void m10066a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f8493j.size();
        m10088g();
        for (int i = 0; i < size; i++) {
            MenuItem menuItem2 = (C3276j) this.f8493j.get(i);
            if (menuItem2.getGroupId() == groupId) {
                if (menuItem2.m10126g()) {
                    if (menuItem2.isCheckable()) {
                        menuItem2.m10117b(menuItem2 == menuItem);
                    }
                }
            }
        }
        m10089h();
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f8493j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C3276j c3276j = (C3276j) this.f8493j.get(i2);
            if (c3276j.getGroupId() == i) {
                c3276j.m10114a(z2);
                c3276j.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.f8493j.size();
        Object obj = null;
        for (int i2 = 0; i2 < size; i2++) {
            C3276j c3276j = (C3276j) this.f8493j.get(i2);
            if (c3276j.getGroupId() == i && c3276j.m10120c(z)) {
                obj = 1;
            }
        }
        if (obj != null) {
            m10076b(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.f8493j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C3276j c3276j = (C3276j) this.f8493j.get(i2);
            if (c3276j.getGroupId() == i) {
                c3276j.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.f8509z) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((C3276j) this.f8493j.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            C3276j c3276j = (C3276j) this.f8493j.get(i2);
            if (c3276j.getItemId() == i) {
                return c3276j;
            }
            if (c3276j.hasSubMenu()) {
                MenuItem findItem = c3276j.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return 0;
    }

    /* renamed from: b */
    public int m10072b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((C3276j) this.f8493j.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: c */
    public int m10078c(int i) {
        return m10053a(i, 0);
    }

    /* renamed from: a */
    public int m10053a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < size) {
            if (((C3276j) this.f8493j.get(i2)).getGroupId() == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public int size() {
        return this.f8493j.size();
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.f8493j.get(i);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m10058a(i, keyEvent) != 0;
    }

    public void setQwertyMode(boolean z) {
        this.f8490g = z;
        m10076b(false);
    }

    /* renamed from: f */
    private static int m10052f(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 < 0 || i2 >= f8484d.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        return (i & MinElf.PN_XNUM) | (f8484d[i2] << 16);
    }

    /* renamed from: b */
    boolean mo2751b() {
        return this.f8490g;
    }

    /* renamed from: e */
    private void m10051e(boolean z) {
        boolean z2 = true;
        if (!z || this.f8489f.getConfiguration().keyboard || !this.f8489f.getBoolean(C0582b.abc_config_showMenuShortcutsWhenKeyboardPresent)) {
            z2 = false;
        }
        this.f8491h = z2;
    }

    /* renamed from: c */
    public boolean mo2752c() {
        return this.f8491h;
    }

    /* renamed from: d */
    Resources m10082d() {
        return this.f8489f;
    }

    /* renamed from: e */
    public Context m10085e() {
        return this.f8488e;
    }

    /* renamed from: a */
    boolean mo2750a(C3273h c3273h, MenuItem menuItem) {
        return (this.f8492i == null || this.f8492i.mo389a(c3273h, menuItem) == null) ? null : true;
    }

    /* renamed from: f */
    public void m10087f() {
        if (this.f8492i != null) {
            this.f8492i.mo388a(this);
        }
    }

    /* renamed from: a */
    private static int m10045a(ArrayList<C3276j> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((C3276j) arrayList.get(size)).m10119c() <= i) {
                return size + 1;
            }
        }
        return null;
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = m10058a(i, keyEvent);
        i = a != 0 ? m10070a(a, i2) : 0;
        if ((i2 & 2) != null) {
            m10068a(true);
        }
        return i;
    }

    /* renamed from: a */
    void m10067a(List<C3276j> list, int i, KeyEvent keyEvent) {
        boolean b = mo2751b();
        int modifiers = keyEvent.getModifiers();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f8493j.size();
            for (int i2 = 0; i2 < size; i2++) {
                C3276j c3276j = (C3276j) this.f8493j.get(i2);
                if (c3276j.hasSubMenu()) {
                    ((C3273h) c3276j.getSubMenu()).m10067a((List) list, i, keyEvent);
                }
                char alphabeticShortcut = b ? c3276j.getAlphabeticShortcut() : c3276j.getNumericShortcut();
                if (!(((modifiers & 69647) == ((b ? c3276j.getAlphabeticModifiers() : c3276j.getNumericModifiers()) & 69647) ? 1 : null) == null || alphabeticShortcut == '\u0000' || ((alphabeticShortcut != keyData.meta[0] && alphabeticShortcut != keyData.meta[2] && (!b || alphabeticShortcut != '\b' || i != 67)) || !c3276j.isEnabled()))) {
                    list.add(c3276j);
                }
            }
        }
    }

    /* renamed from: a */
    C3276j m10058a(int i, KeyEvent keyEvent) {
        List list = this.f8506w;
        list.clear();
        m10067a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        keyEvent = list.size();
        if (keyEvent == 1) {
            return (C3276j) list.get(0);
        }
        boolean b = mo2751b();
        for (int i2 = 0; i2 < keyEvent; i2++) {
            char alphabeticShortcut;
            C3276j c3276j = (C3276j) list.get(i2);
            if (b) {
                alphabeticShortcut = c3276j.getAlphabeticShortcut();
            } else {
                alphabeticShortcut = c3276j.getNumericShortcut();
            }
            if ((alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) || ((alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) || (b && alphabeticShortcut == '\b' && i == 67))) {
                return c3276j;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return m10070a(findItem(i), i2);
    }

    /* renamed from: a */
    public boolean m10070a(MenuItem menuItem, int i) {
        return m10071a(menuItem, null, i);
    }

    /* renamed from: a */
    public boolean m10071a(MenuItem menuItem, C0662o c0662o, int i) {
        C3276j c3276j = (C3276j) menuItem;
        if (c3276j != null) {
            if (c3276j.isEnabled()) {
                boolean b = c3276j.m10118b();
                C0497c a = c3276j.mo442a();
                Object obj = (a == null || !a.mo477e()) ? null : 1;
                if (c3276j.m10133n()) {
                    b |= c3276j.expandActionView();
                    if (b) {
                        m10068a(true);
                    }
                } else {
                    if (!c3276j.hasSubMenu()) {
                        if (obj == null) {
                            if ((i & 1) == null) {
                                m10068a(true);
                            }
                        }
                    }
                    if ((i & 4) == 0) {
                        m10068a(false);
                    }
                    if (c3276j.hasSubMenu() == 0) {
                        c3276j.m10112a(new C4487u(m10085e(), this, c3276j));
                    }
                    C4487u c4487u = (C4487u) c3276j.getSubMenu();
                    if (obj != null) {
                        a.mo475a((SubMenu) c4487u);
                    }
                    b |= m10049a(c4487u, c0662o);
                    if (!b) {
                        m10068a(true);
                    }
                }
                return b;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final void m10068a(boolean z) {
        if (!this.f8505v) {
            this.f8505v = true;
            Iterator it = this.f8507x.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0662o c0662o = (C0662o) weakReference.get();
                if (c0662o == null) {
                    this.f8507x.remove(weakReference);
                } else {
                    c0662o.mo464a(this, z);
                }
            }
            this.f8505v = false;
        }
    }

    public void close() {
        m10068a(true);
    }

    /* renamed from: b */
    public void m10076b(boolean z) {
        if (this.f8501r) {
            this.f8502s = true;
            if (z) {
                this.f8503t = true;
                return;
            }
            return;
        }
        if (z) {
            this.f8495l = true;
            this.f8498o = true;
        }
        m10050d(z);
    }

    /* renamed from: g */
    public void m10088g() {
        if (!this.f8501r) {
            this.f8501r = true;
            this.f8502s = false;
            this.f8503t = false;
        }
    }

    /* renamed from: h */
    public void m10089h() {
        this.f8501r = false;
        if (this.f8502s) {
            this.f8502s = false;
            m10076b(this.f8503t);
        }
    }

    /* renamed from: a */
    void m10063a(C3276j c3276j) {
        this.f8495l = true;
        m10076b(true);
    }

    /* renamed from: b */
    void m10074b(C3276j c3276j) {
        this.f8498o = true;
        m10076b(true);
    }

    /* renamed from: i */
    public ArrayList<C3276j> m10090i() {
        if (!this.f8495l) {
            return this.f8494k;
        }
        this.f8494k.clear();
        int size = this.f8493j.size();
        for (int i = 0; i < size; i++) {
            C3276j c3276j = (C3276j) this.f8493j.get(i);
            if (c3276j.isVisible()) {
                this.f8494k.add(c3276j);
            }
        }
        this.f8495l = false;
        this.f8498o = true;
        return this.f8494k;
    }

    /* renamed from: j */
    public void m10091j() {
        ArrayList i = m10090i();
        if (this.f8498o) {
            Iterator it = this.f8507x.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0662o c0662o = (C0662o) weakReference.get();
                if (c0662o == null) {
                    this.f8507x.remove(weakReference);
                } else {
                    i2 |= c0662o.mo469b();
                }
            }
            if (i2 != 0) {
                this.f8496m.clear();
                this.f8497n.clear();
                int size = i.size();
                for (i2 = 0; i2 < size; i2++) {
                    C3276j c3276j = (C3276j) i.get(i2);
                    if (c3276j.m10129j()) {
                        this.f8496m.add(c3276j);
                    } else {
                        this.f8497n.add(c3276j);
                    }
                }
            } else {
                this.f8496m.clear();
                this.f8497n.clear();
                this.f8497n.addAll(m10090i());
            }
            this.f8498o = false;
        }
    }

    /* renamed from: k */
    public ArrayList<C3276j> m10092k() {
        m10091j();
        return this.f8496m;
    }

    /* renamed from: l */
    public ArrayList<C3276j> m10093l() {
        m10091j();
        return this.f8497n;
    }

    public void clearHeader() {
        this.f8486b = null;
        this.f8485a = null;
        this.f8487c = null;
        m10076b(false);
    }

    /* renamed from: a */
    private void m10047a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources d = m10082d();
        if (view != null) {
            this.f8487c = view;
            this.f8485a = null;
            this.f8486b = null;
        } else {
            if (i > 0) {
                this.f8485a = d.getText(i);
            } else if (charSequence != null) {
                this.f8485a = charSequence;
            }
            if (i2 > 0) {
                this.f8486b = C0366b.m1103a(m10085e(), i2);
            } else if (drawable != null) {
                this.f8486b = drawable;
            }
            this.f8487c = null;
        }
        m10076b((boolean) 0);
    }

    /* renamed from: a */
    protected C3273h m10057a(CharSequence charSequence) {
        m10047a(0, charSequence, 0, null, null);
        return this;
    }

    /* renamed from: d */
    protected C3273h m10083d(int i) {
        m10047a(i, null, 0, null, null);
        return this;
    }

    /* renamed from: a */
    protected C3273h m10055a(Drawable drawable) {
        m10047a(0, null, 0, drawable, null);
        return this;
    }

    /* renamed from: e */
    protected C3273h m10086e(int i) {
        m10047a(0, null, i, null, null);
        return this;
    }

    /* renamed from: a */
    protected C3273h m10056a(View view) {
        m10047a(0, null, 0, null, view);
        return this;
    }

    /* renamed from: m */
    public CharSequence m10094m() {
        return this.f8485a;
    }

    /* renamed from: n */
    public Drawable m10095n() {
        return this.f8486b;
    }

    /* renamed from: o */
    public View m10096o() {
        return this.f8487c;
    }

    /* renamed from: q */
    boolean m10098q() {
        return this.f8504u;
    }

    /* renamed from: c */
    public boolean mo2753c(C3276j c3276j) {
        boolean z = false;
        if (this.f8507x.isEmpty()) {
            return false;
        }
        m10088g();
        Iterator it = this.f8507x.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0662o c0662o = (C0662o) weakReference.get();
            if (c0662o == null) {
                this.f8507x.remove(weakReference);
            } else {
                z = c0662o.mo466a(this, c3276j);
                if (z) {
                    break;
                }
            }
        }
        m10089h();
        if (z) {
            this.f8508y = c3276j;
        }
        return z;
    }

    /* renamed from: d */
    public boolean mo2754d(C3276j c3276j) {
        boolean z = false;
        if (!this.f8507x.isEmpty()) {
            if (this.f8508y == c3276j) {
                m10088g();
                Iterator it = this.f8507x.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    C0662o c0662o = (C0662o) weakReference.get();
                    if (c0662o == null) {
                        this.f8507x.remove(weakReference);
                    } else {
                        z = c0662o.mo470b(this, c3276j);
                        if (z) {
                            break;
                        }
                    }
                }
                m10089h();
                if (z) {
                    this.f8508y = null;
                }
                return z;
            }
        }
        return false;
    }

    /* renamed from: r */
    public C3276j m10099r() {
        return this.f8508y;
    }

    /* renamed from: c */
    public void m10079c(boolean z) {
        this.f8509z = z;
    }
}
