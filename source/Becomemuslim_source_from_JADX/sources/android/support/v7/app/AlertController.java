package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.C0517s;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.C0528b;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.p035a.C0591a.C0586f;
import android.support.v7.p035a.C0591a.C0590j;
import android.support.v7.widget.as.C0762a;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.facebook.login.widget.ProfilePictureView;
import java.lang.ref.WeakReference;

class AlertController {
    /* renamed from: A */
    private int f1504A;
    /* renamed from: B */
    private boolean f1505B = false;
    /* renamed from: C */
    private CharSequence f1506C;
    /* renamed from: D */
    private Drawable f1507D;
    /* renamed from: E */
    private CharSequence f1508E;
    /* renamed from: F */
    private Drawable f1509F;
    /* renamed from: G */
    private CharSequence f1510G;
    /* renamed from: H */
    private Drawable f1511H;
    /* renamed from: I */
    private int f1512I = 0;
    /* renamed from: J */
    private Drawable f1513J;
    /* renamed from: K */
    private ImageView f1514K;
    /* renamed from: L */
    private TextView f1515L;
    /* renamed from: M */
    private TextView f1516M;
    /* renamed from: N */
    private View f1517N;
    /* renamed from: O */
    private int f1518O;
    /* renamed from: P */
    private int f1519P;
    /* renamed from: Q */
    private boolean f1520Q;
    /* renamed from: R */
    private int f1521R = 0;
    /* renamed from: S */
    private final OnClickListener f1522S = new C05921(this);
    /* renamed from: a */
    final C3256k f1523a;
    /* renamed from: b */
    ListView f1524b;
    /* renamed from: c */
    Button f1525c;
    /* renamed from: d */
    Message f1526d;
    /* renamed from: e */
    Button f1527e;
    /* renamed from: f */
    Message f1528f;
    /* renamed from: g */
    Button f1529g;
    /* renamed from: h */
    Message f1530h;
    /* renamed from: i */
    NestedScrollView f1531i;
    /* renamed from: j */
    ListAdapter f1532j;
    /* renamed from: k */
    int f1533k = -1;
    /* renamed from: l */
    int f1534l;
    /* renamed from: m */
    int f1535m;
    /* renamed from: n */
    int f1536n;
    /* renamed from: o */
    int f1537o;
    /* renamed from: p */
    Handler f1538p;
    /* renamed from: q */
    private final Context f1539q;
    /* renamed from: r */
    private final Window f1540r;
    /* renamed from: s */
    private final int f1541s;
    /* renamed from: t */
    private CharSequence f1542t;
    /* renamed from: u */
    private CharSequence f1543u;
    /* renamed from: v */
    private View f1544v;
    /* renamed from: w */
    private int f1545w;
    /* renamed from: x */
    private int f1546x;
    /* renamed from: y */
    private int f1547y;
    /* renamed from: z */
    private int f1548z;

    /* renamed from: android.support.v7.app.AlertController$1 */
    class C05921 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ AlertController f1437a;

        C05921(AlertController alertController) {
            this.f1437a = alertController;
        }

        public void onClick(View view) {
            view = (view != this.f1437a.f1525c || this.f1437a.f1526d == null) ? (view != this.f1437a.f1527e || this.f1437a.f1528f == null) ? (view != this.f1437a.f1529g || this.f1437a.f1530h == null) ? null : Message.obtain(this.f1437a.f1530h) : Message.obtain(this.f1437a.f1528f) : Message.obtain(this.f1437a.f1526d);
            if (view != null) {
                view.sendToTarget();
            }
            this.f1437a.f1538p.obtainMessage(1, this.f1437a.f1523a).sendToTarget();
        }
    }

    public static class RecycleListView extends ListView {
        /* renamed from: a */
        private final int f1447a;
        /* renamed from: b */
        private final int f1448b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, C0590j.RecycleListView);
            this.f1448b = context.getDimensionPixelOffset(C0590j.RecycleListView_paddingBottomNoButtons, -1);
            this.f1447a = context.getDimensionPixelOffset(C0590j.RecycleListView_paddingTopNoTitle, -1);
        }

        /* renamed from: a */
        public void m1963a(boolean z, boolean z2) {
            if (!z2 || !z) {
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f1447a, getPaddingRight(), z2 ? getPaddingBottom() : this.f1448b);
            }
        }
    }

    /* renamed from: android.support.v7.app.AlertController$a */
    public static class C0601a {
        /* renamed from: A */
        public int f1461A;
        /* renamed from: B */
        public int f1462B;
        /* renamed from: C */
        public int f1463C;
        /* renamed from: D */
        public int f1464D;
        /* renamed from: E */
        public boolean f1465E = false;
        /* renamed from: F */
        public boolean[] f1466F;
        /* renamed from: G */
        public boolean f1467G;
        /* renamed from: H */
        public boolean f1468H;
        /* renamed from: I */
        public int f1469I = -1;
        /* renamed from: J */
        public OnMultiChoiceClickListener f1470J;
        /* renamed from: K */
        public Cursor f1471K;
        /* renamed from: L */
        public String f1472L;
        /* renamed from: M */
        public String f1473M;
        /* renamed from: N */
        public OnItemSelectedListener f1474N;
        /* renamed from: O */
        public C0600a f1475O;
        /* renamed from: P */
        public boolean f1476P = true;
        /* renamed from: a */
        public final Context f1477a;
        /* renamed from: b */
        public final LayoutInflater f1478b;
        /* renamed from: c */
        public int f1479c = 0;
        /* renamed from: d */
        public Drawable f1480d;
        /* renamed from: e */
        public int f1481e = 0;
        /* renamed from: f */
        public CharSequence f1482f;
        /* renamed from: g */
        public View f1483g;
        /* renamed from: h */
        public CharSequence f1484h;
        /* renamed from: i */
        public CharSequence f1485i;
        /* renamed from: j */
        public Drawable f1486j;
        /* renamed from: k */
        public DialogInterface.OnClickListener f1487k;
        /* renamed from: l */
        public CharSequence f1488l;
        /* renamed from: m */
        public Drawable f1489m;
        /* renamed from: n */
        public DialogInterface.OnClickListener f1490n;
        /* renamed from: o */
        public CharSequence f1491o;
        /* renamed from: p */
        public Drawable f1492p;
        /* renamed from: q */
        public DialogInterface.OnClickListener f1493q;
        /* renamed from: r */
        public boolean f1494r;
        /* renamed from: s */
        public OnCancelListener f1495s;
        /* renamed from: t */
        public OnDismissListener f1496t;
        /* renamed from: u */
        public OnKeyListener f1497u;
        /* renamed from: v */
        public CharSequence[] f1498v;
        /* renamed from: w */
        public ListAdapter f1499w;
        /* renamed from: x */
        public DialogInterface.OnClickListener f1500x;
        /* renamed from: y */
        public int f1501y;
        /* renamed from: z */
        public View f1502z;

        /* renamed from: android.support.v7.app.AlertController$a$a */
        public interface C0600a {
            /* renamed from: a */
            void m1964a(ListView listView);
        }

        public C0601a(Context context) {
            this.f1477a = context;
            this.f1494r = true;
            this.f1478b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* renamed from: a */
        public void m1966a(AlertController alertController) {
            if (this.f1483g != null) {
                alertController.m1987b(this.f1483g);
            } else {
                if (this.f1482f != null) {
                    alertController.m1984a(this.f1482f);
                }
                if (this.f1480d != null) {
                    alertController.m1982a(this.f1480d);
                }
                if (this.f1479c != 0) {
                    alertController.m1986b(this.f1479c);
                }
                if (this.f1481e != 0) {
                    alertController.m1986b(alertController.m1990c(this.f1481e));
                }
            }
            if (this.f1484h != null) {
                alertController.m1988b(this.f1484h);
            }
            if (!(this.f1485i == null && this.f1486j == null)) {
                alertController.m1981a(-1, this.f1485i, this.f1487k, null, this.f1486j);
            }
            if (!(this.f1488l == null && this.f1489m == null)) {
                alertController.m1981a(-2, this.f1488l, this.f1490n, null, this.f1489m);
            }
            if (!(this.f1491o == null && this.f1492p == null)) {
                alertController.m1981a(-3, this.f1491o, this.f1493q, null, this.f1492p);
            }
            if (!(this.f1498v == null && this.f1471K == null && this.f1499w == null)) {
                m1965b(alertController);
            }
            if (this.f1502z != null) {
                if (this.f1465E) {
                    alertController.m1983a(this.f1502z, this.f1461A, this.f1462B, this.f1463C, this.f1464D);
                    return;
                }
                alertController.m1991c(this.f1502z);
            } else if (this.f1501y != 0) {
                alertController.m1980a(this.f1501y);
            }
        }

        /* renamed from: b */
        private void m1965b(final AlertController alertController) {
            ListAdapter simpleCursorAdapter;
            final RecycleListView recycleListView = (RecycleListView) this.f1478b.inflate(alertController.f1534l, null);
            if (!this.f1467G) {
                int i;
                if (this.f1468H) {
                    i = alertController.f1536n;
                } else {
                    i = alertController.f1537o;
                }
                int i2 = i;
                if (this.f1471K != null) {
                    simpleCursorAdapter = new SimpleCursorAdapter(this.f1477a, i2, this.f1471K, new String[]{this.f1472L}, new int[]{16908308});
                } else if (this.f1499w != null) {
                    simpleCursorAdapter = this.f1499w;
                } else {
                    simpleCursorAdapter = new C0603c(this.f1477a, i2, 16908308, this.f1498v);
                }
            } else if (this.f1471K == null) {
                final RecycleListView recycleListView2 = recycleListView;
                r1 = new ArrayAdapter<CharSequence>(this, this.f1477a, alertController.f1535m, 16908308, this.f1498v) {
                    /* renamed from: b */
                    final /* synthetic */ C0601a f1450b;

                    public View getView(int i, View view, ViewGroup viewGroup) {
                        view = super.getView(i, view, viewGroup);
                        if (!(this.f1450b.f1466F == null || this.f1450b.f1466F[i] == null)) {
                            recycleListView2.setItemChecked(i, true);
                        }
                        return view;
                    }
                };
            } else {
                final RecycleListView recycleListView3 = recycleListView;
                final AlertController alertController2 = alertController;
                r1 = new CursorAdapter(this, this.f1477a, this.f1471K, false) {
                    /* renamed from: c */
                    final /* synthetic */ C0601a f1453c;
                    /* renamed from: d */
                    private final int f1454d;
                    /* renamed from: e */
                    private final int f1455e;

                    public void bindView(View view, Context context, Cursor cursor) {
                        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f1454d));
                        view = recycleListView3;
                        context = cursor.getPosition();
                        boolean z = true;
                        if (cursor.getInt(this.f1455e) != 1) {
                            z = false;
                        }
                        view.setItemChecked(context, z);
                    }

                    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                        return this.f1453c.f1478b.inflate(alertController2.f1535m, viewGroup, false);
                    }
                };
            }
            if (this.f1475O != null) {
                this.f1475O.m1964a(recycleListView);
            }
            alertController.f1532j = simpleCursorAdapter;
            alertController.f1533k = this.f1469I;
            if (this.f1500x != null) {
                recycleListView.setOnItemClickListener(new OnItemClickListener(this) {
                    /* renamed from: b */
                    final /* synthetic */ C0601a f1457b;

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.f1457b.f1500x.onClick(alertController.f1523a, i);
                        if (this.f1457b.f1468H == null) {
                            alertController.f1523a.dismiss();
                        }
                    }
                });
            } else if (this.f1470J != null) {
                recycleListView.setOnItemClickListener(new OnItemClickListener(this) {
                    /* renamed from: c */
                    final /* synthetic */ C0601a f1460c;

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        if (this.f1460c.f1466F != null) {
                            this.f1460c.f1466F[i] = recycleListView.isItemChecked(i);
                        }
                        this.f1460c.f1470J.onClick(alertController.f1523a, i, recycleListView.isItemChecked(i));
                    }
                });
            }
            if (this.f1474N != null) {
                recycleListView.setOnItemSelectedListener(this.f1474N);
            }
            if (this.f1468H) {
                recycleListView.setChoiceMode(1);
            } else if (this.f1467G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f1524b = recycleListView;
        }
    }

    /* renamed from: android.support.v7.app.AlertController$b */
    private static final class C0602b extends Handler {
        /* renamed from: a */
        private WeakReference<DialogInterface> f1503a;

        public C0602b(DialogInterface dialogInterface) {
            this.f1503a = new WeakReference(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                switch (i) {
                    case ProfilePictureView.NORMAL /*-3*/:
                    case -2:
                    case -1:
                        ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f1503a.get(), message.what);
                        return;
                    default:
                        return;
                }
            }
            ((DialogInterface) message.obj).dismiss();
        }
    }

    /* renamed from: android.support.v7.app.AlertController$c */
    private static class C0603c extends ArrayAdapter<CharSequence> {
        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }

        public C0603c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }
    }

    /* renamed from: a */
    private static boolean m1972a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0581a.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != null) {
            return true;
        }
        return false;
    }

    public AlertController(Context context, C3256k c3256k, Window window) {
        this.f1539q = context;
        this.f1523a = c3256k;
        this.f1540r = window;
        this.f1538p = new C0602b(c3256k);
        context = context.obtainStyledAttributes(null, C0590j.AlertDialog, C0581a.alertDialogStyle, 0);
        this.f1518O = context.getResourceId(C0590j.AlertDialog_android_layout, 0);
        this.f1519P = context.getResourceId(C0590j.AlertDialog_buttonPanelSideLayout, 0);
        this.f1534l = context.getResourceId(C0590j.AlertDialog_listLayout, 0);
        this.f1535m = context.getResourceId(C0590j.AlertDialog_multiChoiceItemLayout, 0);
        this.f1536n = context.getResourceId(C0590j.AlertDialog_singleChoiceItemLayout, 0);
        this.f1537o = context.getResourceId(C0590j.AlertDialog_listItemLayout, 0);
        this.f1520Q = context.getBoolean(C0590j.AlertDialog_showTitle, true);
        this.f1541s = context.getDimensionPixelSize(C0590j.AlertDialog_buttonIconDimen, 0);
        context.recycle();
        c3256k.m9888a(1);
    }

    /* renamed from: a */
    static boolean m1973a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (m1973a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void m1979a() {
        this.f1523a.setContentView(m1974b());
        m1976c();
    }

    /* renamed from: b */
    private int m1974b() {
        if (this.f1519P == 0) {
            return this.f1518O;
        }
        if (this.f1521R == 1) {
            return this.f1519P;
        }
        return this.f1518O;
    }

    /* renamed from: a */
    public void m1984a(CharSequence charSequence) {
        this.f1542t = charSequence;
        if (this.f1515L != null) {
            this.f1515L.setText(charSequence);
        }
    }

    /* renamed from: b */
    public void m1987b(View view) {
        this.f1517N = view;
    }

    /* renamed from: b */
    public void m1988b(CharSequence charSequence) {
        this.f1543u = charSequence;
        if (this.f1516M != null) {
            this.f1516M.setText(charSequence);
        }
    }

    /* renamed from: a */
    public void m1980a(int i) {
        this.f1544v = null;
        this.f1545w = i;
        this.f1505B = false;
    }

    /* renamed from: c */
    public void m1991c(View view) {
        this.f1544v = view;
        this.f1545w = 0;
        this.f1505B = false;
    }

    /* renamed from: a */
    public void m1983a(View view, int i, int i2, int i3, int i4) {
        this.f1544v = view;
        this.f1545w = null;
        this.f1505B = true;
        this.f1546x = i;
        this.f1547y = i2;
        this.f1548z = i3;
        this.f1504A = i4;
    }

    /* renamed from: a */
    public void m1981a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f1538p.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case ProfilePictureView.NORMAL /*-3*/:
                this.f1510G = charSequence;
                this.f1530h = message;
                this.f1511H = drawable;
                return;
            case -2:
                this.f1508E = charSequence;
                this.f1528f = message;
                this.f1509F = drawable;
                return;
            case -1:
                this.f1506C = charSequence;
                this.f1526d = message;
                this.f1507D = drawable;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    /* renamed from: b */
    public void m1986b(int i) {
        this.f1513J = null;
        this.f1512I = i;
        if (this.f1514K == null) {
            return;
        }
        if (i != 0) {
            this.f1514K.setVisibility(0);
            this.f1514K.setImageResource(this.f1512I);
            return;
        }
        this.f1514K.setVisibility(8);
    }

    /* renamed from: a */
    public void m1982a(Drawable drawable) {
        this.f1513J = drawable;
        this.f1512I = 0;
        if (this.f1514K == null) {
            return;
        }
        if (drawable != null) {
            this.f1514K.setVisibility(0);
            this.f1514K.setImageDrawable(drawable);
            return;
        }
        this.f1514K.setVisibility(8);
    }

    /* renamed from: c */
    public int m1990c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f1539q.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    /* renamed from: a */
    public boolean m1985a(int i, KeyEvent keyEvent) {
        return (this.f1531i == 0 || this.f1531i.m14969a(keyEvent) == 0) ? false : true;
    }

    /* renamed from: b */
    public boolean m1989b(int i, KeyEvent keyEvent) {
        return (this.f1531i == 0 || this.f1531i.m14969a(keyEvent) == 0) ? false : true;
    }

    /* renamed from: a */
    private ViewGroup m1967a(View view, View view2) {
        if (view == null) {
            if ((view2 instanceof ViewStub) != null) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if ((view instanceof ViewStub) != null) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    /* renamed from: c */
    private void m1976c() {
        View findViewById = this.f1540r.findViewById(C0586f.parentPanel);
        View findViewById2 = findViewById.findViewById(C0586f.topPanel);
        View findViewById3 = findViewById.findViewById(C0586f.contentPanel);
        View findViewById4 = findViewById.findViewById(C0586f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(C0586f.customPanel);
        m1969a(viewGroup);
        View findViewById5 = viewGroup.findViewById(C0586f.topPanel);
        View findViewById6 = viewGroup.findViewById(C0586f.contentPanel);
        View findViewById7 = viewGroup.findViewById(C0586f.buttonPanel);
        ViewGroup a = m1967a(findViewById5, findViewById2);
        ViewGroup a2 = m1967a(findViewById6, findViewById3);
        ViewGroup a3 = m1967a(findViewById7, findViewById4);
        m1977c(a2);
        m1978d(a3);
        m1975b(a);
        int i = 0;
        Object obj = (viewGroup == null || viewGroup.getVisibility() == 8) ? null : 1;
        boolean z = (a == null || a.getVisibility() == 8) ? false : true;
        boolean z2 = (a3 == null || a3.getVisibility() == 8) ? false : true;
        if (!(z2 || a2 == null)) {
            findViewById5 = a2.findViewById(C0586f.textSpacerNoButtons);
            if (findViewById5 != null) {
                findViewById5.setVisibility(0);
            }
        }
        if (z) {
            if (this.f1531i != null) {
                this.f1531i.setClipToPadding(true);
            }
            findViewById5 = null;
            if (!(this.f1543u == null && this.f1524b == null)) {
                findViewById5 = a.findViewById(C0586f.titleDividerNoCustom);
            }
            if (findViewById5 != null) {
                findViewById5.setVisibility(0);
            }
        } else if (a2 != null) {
            findViewById2 = a2.findViewById(C0586f.textSpacerNoTitle);
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
        }
        if (this.f1524b instanceof RecycleListView) {
            ((RecycleListView) this.f1524b).m1963a(z, z2);
        }
        if (obj == null) {
            findViewById = this.f1524b != null ? this.f1524b : this.f1531i;
            if (findViewById != null) {
                if (z2) {
                    i = 2;
                }
                m1970a(a2, findViewById, z | i, 3);
            }
        }
        ListView listView = this.f1524b;
        if (listView != null && this.f1532j != null) {
            listView.setAdapter(this.f1532j);
            int i2 = this.f1533k;
            if (i2 > -1) {
                listView.setItemChecked(i2, true);
                listView.setSelection(i2);
            }
        }
    }

    /* renamed from: a */
    private void m1970a(ViewGroup viewGroup, View view, int i, int i2) {
        View findViewById = this.f1540r.findViewById(C0586f.scrollIndicatorUp);
        View findViewById2 = this.f1540r.findViewById(C0586f.scrollIndicatorDown);
        if (VERSION.SDK_INT >= 23) {
            C0517s.m1689a(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        view = null;
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view != null) {
            if (this.f1543u != 0) {
                this.f1531i.setOnScrollChangeListener(new C0528b(this) {
                    /* renamed from: c */
                    final /* synthetic */ AlertController f8327c;

                    /* renamed from: a */
                    public void mo359a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                        AlertController.m1968a(nestedScrollView, findViewById, view);
                    }
                });
                this.f1531i.post(new Runnable(this) {
                    /* renamed from: c */
                    final /* synthetic */ AlertController f1440c;

                    public void run() {
                        AlertController.m1968a(this.f1440c.f1531i, findViewById, view);
                    }
                });
            } else if (this.f1524b != 0) {
                this.f1524b.setOnScrollListener(new OnScrollListener(this) {
                    /* renamed from: c */
                    final /* synthetic */ AlertController f1443c;

                    public void onScrollStateChanged(AbsListView absListView, int i) {
                    }

                    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                        AlertController.m1968a(absListView, findViewById, view);
                    }
                });
                this.f1524b.post(new Runnable(this) {
                    /* renamed from: c */
                    final /* synthetic */ AlertController f1446c;

                    public void run() {
                        AlertController.m1968a(this.f1446c.f1524b, findViewById, view);
                    }
                });
            } else {
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (view != null) {
                    viewGroup.removeView(view);
                }
            }
        }
    }

    /* renamed from: a */
    private void m1969a(ViewGroup viewGroup) {
        boolean z = false;
        View inflate = this.f1544v != null ? this.f1544v : this.f1545w != 0 ? LayoutInflater.from(this.f1539q).inflate(this.f1545w, viewGroup, false) : null;
        if (inflate != null) {
            z = true;
        }
        if (!(z && m1973a(inflate))) {
            this.f1540r.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f1540r.findViewById(C0586f.custom);
            frameLayout.addView(inflate, new LayoutParams(-1, -1));
            if (this.f1505B) {
                frameLayout.setPadding(this.f1546x, this.f1547y, this.f1548z, this.f1504A);
            }
            if (this.f1524b != null) {
                ((C0762a) viewGroup.getLayoutParams()).f2027g = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* renamed from: b */
    private void m1975b(ViewGroup viewGroup) {
        if (this.f1517N != null) {
            viewGroup.addView(this.f1517N, 0, new LayoutParams(-1, -2));
            this.f1540r.findViewById(C0586f.title_template).setVisibility(8);
            return;
        }
        this.f1514K = (ImageView) this.f1540r.findViewById(16908294);
        if ((TextUtils.isEmpty(this.f1542t) ^ 1) == 0 || !this.f1520Q) {
            this.f1540r.findViewById(C0586f.title_template).setVisibility(8);
            this.f1514K.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        this.f1515L = (TextView) this.f1540r.findViewById(C0586f.alertTitle);
        this.f1515L.setText(this.f1542t);
        if (this.f1512I != null) {
            this.f1514K.setImageResource(this.f1512I);
        } else if (this.f1513J != null) {
            this.f1514K.setImageDrawable(this.f1513J);
        } else {
            this.f1515L.setPadding(this.f1514K.getPaddingLeft(), this.f1514K.getPaddingTop(), this.f1514K.getPaddingRight(), this.f1514K.getPaddingBottom());
            this.f1514K.setVisibility(8);
        }
    }

    /* renamed from: c */
    private void m1977c(ViewGroup viewGroup) {
        this.f1531i = (NestedScrollView) this.f1540r.findViewById(C0586f.scrollView);
        this.f1531i.setFocusable(false);
        this.f1531i.setNestedScrollingEnabled(false);
        this.f1516M = (TextView) viewGroup.findViewById(16908299);
        if (this.f1516M != null) {
            if (this.f1543u != null) {
                this.f1516M.setText(this.f1543u);
            } else {
                this.f1516M.setVisibility(8);
                this.f1531i.removeView(this.f1516M);
                if (this.f1524b != null) {
                    viewGroup = (ViewGroup) this.f1531i.getParent();
                    int indexOfChild = viewGroup.indexOfChild(this.f1531i);
                    viewGroup.removeViewAt(indexOfChild);
                    viewGroup.addView(this.f1524b, indexOfChild, new LayoutParams(-1, -1));
                } else {
                    viewGroup.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: a */
    static void m1968a(View view, View view2, View view3) {
        int i = 4;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (view.canScrollVertically(1) != null) {
                i = 0;
            }
            view3.setVisibility(i);
        }
    }

    /* renamed from: d */
    private void m1978d(ViewGroup viewGroup) {
        int i;
        this.f1525c = (Button) viewGroup.findViewById(16908313);
        this.f1525c.setOnClickListener(this.f1522S);
        Object obj = 1;
        if (TextUtils.isEmpty(this.f1506C) && this.f1507D == null) {
            this.f1525c.setVisibility(8);
            i = 0;
        } else {
            this.f1525c.setText(this.f1506C);
            if (this.f1507D != null) {
                this.f1507D.setBounds(0, 0, this.f1541s, this.f1541s);
                this.f1525c.setCompoundDrawables(this.f1507D, null, null, null);
            }
            this.f1525c.setVisibility(0);
            i = 1;
        }
        this.f1527e = (Button) viewGroup.findViewById(16908314);
        this.f1527e.setOnClickListener(this.f1522S);
        if (TextUtils.isEmpty(this.f1508E) && this.f1509F == null) {
            this.f1527e.setVisibility(8);
        } else {
            this.f1527e.setText(this.f1508E);
            if (this.f1509F != null) {
                this.f1509F.setBounds(0, 0, this.f1541s, this.f1541s);
                this.f1527e.setCompoundDrawables(this.f1509F, null, null, null);
            }
            this.f1527e.setVisibility(0);
            i |= 2;
        }
        this.f1529g = (Button) viewGroup.findViewById(16908315);
        this.f1529g.setOnClickListener(this.f1522S);
        if (TextUtils.isEmpty(this.f1510G) && this.f1511H == null) {
            this.f1529g.setVisibility(8);
        } else {
            this.f1529g.setText(this.f1510G);
            if (this.f1507D != null) {
                this.f1507D.setBounds(0, 0, this.f1541s, this.f1541s);
                this.f1525c.setCompoundDrawables(this.f1507D, null, null, null);
            }
            this.f1529g.setVisibility(0);
            i |= 4;
        }
        if (m1972a(this.f1539q)) {
            if (i == 1) {
                m1971a(this.f1525c);
            } else if (i == 2) {
                m1971a(this.f1527e);
            } else if (i == 4) {
                m1971a(this.f1529g);
            }
        }
        if (i == 0) {
            obj = null;
        }
        if (obj == null) {
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: a */
    private void m1971a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }
}
