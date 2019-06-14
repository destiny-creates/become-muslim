package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri.Builder;
import android.support.v4.widget.C4471o;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.p035a.C0591a.C0586f;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.util.UriUtil;
import java.util.WeakHashMap;

/* compiled from: SuggestionsAdapter */
class bj extends C4471o implements OnClickListener {
    /* renamed from: j */
    private final SearchManager f13689j = ((SearchManager) this.d.getSystemService("search"));
    /* renamed from: k */
    private final SearchView f13690k;
    /* renamed from: l */
    private final SearchableInfo f13691l;
    /* renamed from: m */
    private final Context f13692m;
    /* renamed from: n */
    private final WeakHashMap<String, ConstantState> f13693n;
    /* renamed from: o */
    private final int f13694o;
    /* renamed from: p */
    private boolean f13695p = false;
    /* renamed from: q */
    private int f13696q = 1;
    /* renamed from: r */
    private ColorStateList f13697r;
    /* renamed from: s */
    private int f13698s = -1;
    /* renamed from: t */
    private int f13699t = -1;
    /* renamed from: u */
    private int f13700u = -1;
    /* renamed from: v */
    private int f13701v = -1;
    /* renamed from: w */
    private int f13702w = -1;
    /* renamed from: x */
    private int f13703x = -1;

    /* compiled from: SuggestionsAdapter */
    /* renamed from: android.support.v7.widget.bj$a */
    private static final class C0777a {
        /* renamed from: a */
        public final TextView f2114a;
        /* renamed from: b */
        public final TextView f2115b;
        /* renamed from: c */
        public final ImageView f2116c;
        /* renamed from: d */
        public final ImageView f2117d;
        /* renamed from: e */
        public final ImageView f2118e;

        public C0777a(View view) {
            this.f2114a = (TextView) view.findViewById(16908308);
            this.f2115b = (TextView) view.findViewById(16908309);
            this.f2116c = (ImageView) view.findViewById(16908295);
            this.f2117d = (ImageView) view.findViewById(16908296);
            this.f2118e = (ImageView) view.findViewById(C0586f.edit_query);
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public bj(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f13690k = searchView;
        this.f13691l = searchableInfo;
        this.f13694o = searchView.getSuggestionCommitIconResId();
        this.f13692m = context;
        this.f13693n = weakHashMap;
    }

    /* renamed from: a */
    public void m17173a(int i) {
        this.f13696q = i;
    }

    /* renamed from: a */
    public Cursor mo332a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f13690k.getVisibility() == 0) {
            if (this.f13690k.getWindowVisibility() == 0) {
                try {
                    charSequence = m17169a(this.f13691l, charSequence2, 50);
                    if (charSequence != null) {
                        charSequence.getCount();
                        return charSequence;
                    }
                } catch (CharSequence charSequence3) {
                    Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", charSequence3);
                }
                return null;
            }
        }
        return null;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m17165d(mo331a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m17165d(mo331a());
    }

    /* renamed from: d */
    private void m17165d(Cursor cursor) {
        cursor = cursor != null ? cursor.getExtras() : null;
        if (cursor != null && cursor.getBoolean("in_progress") == null) {
        }
    }

    /* renamed from: a */
    public void mo333a(Cursor cursor) {
        if (this.f13695p) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
            }
            return;
        }
        try {
            super.mo333a(cursor);
            if (cursor != null) {
                this.f13698s = cursor.getColumnIndex("suggest_text_1");
                this.f13699t = cursor.getColumnIndex("suggest_text_2");
                this.f13700u = cursor.getColumnIndex("suggest_text_2_url");
                this.f13701v = cursor.getColumnIndex("suggest_icon_1");
                this.f13702w = cursor.getColumnIndex("suggest_icon_2");
                this.f13703x = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Cursor cursor2) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", cursor2);
        }
    }

    /* renamed from: a */
    public View mo2706a(Context context, Cursor cursor, ViewGroup viewGroup) {
        context = super.mo2706a(context, cursor, viewGroup);
        context.setTag(new C0777a(context));
        ((ImageView) context.findViewById(C0586f.edit_query)).setImageResource(this.f13694o);
        return context;
    }

    /* renamed from: a */
    public void mo3341a(View view, Context context, Cursor cursor) {
        C0777a c0777a = (C0777a) view.getTag();
        context = this.f13703x != -1 ? cursor.getInt(this.f13703x) : null;
        if (c0777a.f2114a != null) {
            m17159a(c0777a.f2114a, m17156a(cursor, this.f13698s));
        }
        if (c0777a.f2115b != null) {
            CharSequence a = m17156a(cursor, this.f13700u);
            if (a != null) {
                a = m17164b(a);
            } else {
                a = m17156a(cursor, this.f13699t);
            }
            if (TextUtils.isEmpty(a)) {
                if (c0777a.f2114a != null) {
                    c0777a.f2114a.setSingleLine(false);
                    c0777a.f2114a.setMaxLines(2);
                }
            } else if (c0777a.f2114a != null) {
                c0777a.f2114a.setSingleLine(true);
                c0777a.f2114a.setMaxLines(1);
            }
            m17159a(c0777a.f2115b, a);
        }
        if (c0777a.f2116c != null) {
            m17158a(c0777a.f2116c, m17166e(cursor), 4);
        }
        if (c0777a.f2117d != null) {
            m17158a(c0777a.f2117d, m17167f(cursor), 8);
        }
        if (this.f13696q != 2) {
            if (this.f13696q != 1 || (context & 1) == null) {
                c0777a.f2118e.setVisibility(8);
                return;
            }
        }
        c0777a.f2118e.setVisibility(0);
        c0777a.f2118e.setTag(c0777a.f2114a.getText());
        c0777a.f2118e.setOnClickListener(this);
    }

    public void onClick(View view) {
        view = view.getTag();
        if (view instanceof CharSequence) {
            this.f13690k.m10285a((CharSequence) view);
        }
    }

    /* renamed from: b */
    private CharSequence m17164b(CharSequence charSequence) {
        if (this.f13697r == null) {
            TypedValue typedValue = new TypedValue();
            this.d.getTheme().resolveAttribute(C0581a.textColorSearchUrl, typedValue, true);
            this.f13697r = this.d.getResources().getColorStateList(typedValue.resourceId);
        }
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f13697r, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    /* renamed from: a */
    private void m17159a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence) != null) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(null);
        }
    }

    /* renamed from: e */
    private Drawable m17166e(Cursor cursor) {
        if (this.f13701v == -1) {
            return null;
        }
        Drawable a = m17155a(cursor.getString(this.f13701v));
        if (a != null) {
            return a;
        }
        return m17168g(cursor);
    }

    /* renamed from: f */
    private Drawable m17167f(Cursor cursor) {
        if (this.f13702w == -1) {
            return null;
        }
        return m17155a(cursor.getString(this.f13702w));
    }

    /* renamed from: a */
    private void m17158a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    /* renamed from: c */
    public CharSequence mo334c(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        CharSequence a = m17157a(cursor, "suggest_intent_query");
        if (a != null) {
            return a;
        }
        if (this.f13691l.shouldRewriteQueryFromData()) {
            a = m17157a(cursor, "suggest_intent_data");
            if (a != null) {
                return a;
            }
        }
        if (this.f13691l.shouldRewriteQueryFromText()) {
            cursor = m17157a(cursor, "suggest_text_1");
            if (cursor != null) {
                return cursor;
            }
        }
        return null;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (int i2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", i2);
            view = mo2706a(this.d, this.c, viewGroup);
            if (view != null) {
                ((C0777a) view.getTag()).f2114a.setText(i2.toString());
            }
            return view;
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (int i2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", i2);
            view = mo2707b(this.d, this.c, viewGroup);
            if (view != null) {
                ((C0777a) view.getTag()).f2114a.setText(i2.toString());
            }
            return view;
        }
    }

    /* renamed from: a */
    private android.graphics.drawable.Drawable m17155a(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r4 = this;
        r0 = 0;
        if (r5 == 0) goto L_0x0071;
    L_0x0003:
        r1 = r5.isEmpty();
        if (r1 != 0) goto L_0x0071;
    L_0x0009:
        r1 = "0";
        r1 = r1.equals(r5);
        if (r1 == 0) goto L_0x0012;
    L_0x0011:
        goto L_0x0071;
    L_0x0012:
        r1 = java.lang.Integer.parseInt(r5);	 Catch:{ NumberFormatException -> 0x005d, NotFoundException -> 0x0046 }
        r2 = new java.lang.StringBuilder;	 Catch:{ NumberFormatException -> 0x005d, NotFoundException -> 0x0046 }
        r2.<init>();	 Catch:{ NumberFormatException -> 0x005d, NotFoundException -> 0x0046 }
        r3 = "android.resource://";	 Catch:{ NumberFormatException -> 0x005d, NotFoundException -> 0x0046 }
        r2.append(r3);	 Catch:{ NumberFormatException -> 0x005d, NotFoundException -> 0x0046 }
        r3 = r4.f13692m;	 Catch:{ NumberFormatException -> 0x005d, NotFoundException -> 0x0046 }
        r3 = r3.getPackageName();	 Catch:{ NumberFormatException -> 0x005d, NotFoundException -> 0x0046 }
        r2.append(r3);	 Catch:{ NumberFormatException -> 0x005d, NotFoundException -> 0x0046 }
        r3 = "/";	 Catch:{ NumberFormatException -> 0x005d, NotFoundException -> 0x0046 }
        r2.append(r3);	 Catch:{ NumberFormatException -> 0x005d, NotFoundException -> 0x0046 }
        r2.append(r1);	 Catch:{ NumberFormatException -> 0x005d, NotFoundException -> 0x0046 }
        r2 = r2.toString();	 Catch:{ NumberFormatException -> 0x005d, NotFoundException -> 0x0046 }
        r3 = r4.m17163b(r2);	 Catch:{ NumberFormatException -> 0x005d, NotFoundException -> 0x0046 }
        if (r3 == 0) goto L_0x003c;	 Catch:{ NumberFormatException -> 0x005d, NotFoundException -> 0x0046 }
    L_0x003b:
        return r3;	 Catch:{ NumberFormatException -> 0x005d, NotFoundException -> 0x0046 }
    L_0x003c:
        r3 = r4.f13692m;	 Catch:{ NumberFormatException -> 0x005d, NotFoundException -> 0x0046 }
        r1 = android.support.v4.content.C0366b.m1103a(r3, r1);	 Catch:{ NumberFormatException -> 0x005d, NotFoundException -> 0x0046 }
        r4.m17160a(r2, r1);	 Catch:{ NumberFormatException -> 0x005d, NotFoundException -> 0x0046 }
        return r1;
    L_0x0046:
        r1 = "SuggestionsAdapter";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Icon resource not found: ";
        r2.append(r3);
        r2.append(r5);
        r5 = r2.toString();
        android.util.Log.w(r1, r5);
        return r0;
        r0 = r4.m17163b(r5);
        if (r0 == 0) goto L_0x0065;
    L_0x0064:
        return r0;
    L_0x0065:
        r0 = android.net.Uri.parse(r5);
        r0 = r4.m17162b(r0);
        r4.m17160a(r5, r0);
        return r0;
    L_0x0071:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.bj.a(java.lang.String):android.graphics.drawable.Drawable");
    }

    /* renamed from: b */
    private android.graphics.drawable.Drawable m17162b(android.net.Uri r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r6 = this;
        r0 = 0;
        r1 = r7.getScheme();	 Catch:{ FileNotFoundException -> 0x0089 }
        r2 = "android.resource";	 Catch:{ FileNotFoundException -> 0x0089 }
        r1 = r2.equals(r1);	 Catch:{ FileNotFoundException -> 0x0089 }
        if (r1 == 0) goto L_0x0029;
    L_0x000d:
        r1 = r6.m17171a(r7);	 Catch:{ NotFoundException -> 0x0012 }
        return r1;
    L_0x0012:
        r1 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0089 }
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0089 }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x0089 }
        r3 = "Resource does not exist: ";	 Catch:{ FileNotFoundException -> 0x0089 }
        r2.append(r3);	 Catch:{ FileNotFoundException -> 0x0089 }
        r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0089 }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0089 }
        r1.<init>(r2);	 Catch:{ FileNotFoundException -> 0x0089 }
        throw r1;	 Catch:{ FileNotFoundException -> 0x0089 }
    L_0x0029:
        r1 = r6.f13692m;	 Catch:{ FileNotFoundException -> 0x0089 }
        r1 = r1.getContentResolver();	 Catch:{ FileNotFoundException -> 0x0089 }
        r1 = r1.openInputStream(r7);	 Catch:{ FileNotFoundException -> 0x0089 }
        if (r1 == 0) goto L_0x0072;
    L_0x0035:
        r2 = android.graphics.drawable.Drawable.createFromStream(r1, r0);	 Catch:{ all -> 0x0055 }
        r1.close();	 Catch:{ IOException -> 0x003d }
        goto L_0x0054;
    L_0x003d:
        r1 = move-exception;
        r3 = "SuggestionsAdapter";	 Catch:{ FileNotFoundException -> 0x0089 }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0089 }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x0089 }
        r5 = "Error closing icon stream for ";	 Catch:{ FileNotFoundException -> 0x0089 }
        r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0089 }
        r4.append(r7);	 Catch:{ FileNotFoundException -> 0x0089 }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x0089 }
        android.util.Log.e(r3, r4, r1);	 Catch:{ FileNotFoundException -> 0x0089 }
    L_0x0054:
        return r2;
    L_0x0055:
        r2 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x005a }
        goto L_0x0071;
    L_0x005a:
        r1 = move-exception;
        r3 = "SuggestionsAdapter";	 Catch:{ FileNotFoundException -> 0x0089 }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0089 }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x0089 }
        r5 = "Error closing icon stream for ";	 Catch:{ FileNotFoundException -> 0x0089 }
        r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0089 }
        r4.append(r7);	 Catch:{ FileNotFoundException -> 0x0089 }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x0089 }
        android.util.Log.e(r3, r4, r1);	 Catch:{ FileNotFoundException -> 0x0089 }
    L_0x0071:
        throw r2;	 Catch:{ FileNotFoundException -> 0x0089 }
    L_0x0072:
        r1 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0089 }
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0089 }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x0089 }
        r3 = "Failed to open ";	 Catch:{ FileNotFoundException -> 0x0089 }
        r2.append(r3);	 Catch:{ FileNotFoundException -> 0x0089 }
        r2.append(r7);	 Catch:{ FileNotFoundException -> 0x0089 }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x0089 }
        r1.<init>(r2);	 Catch:{ FileNotFoundException -> 0x0089 }
        throw r1;	 Catch:{ FileNotFoundException -> 0x0089 }
    L_0x0089:
        r1 = move-exception;
        r2 = "SuggestionsAdapter";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Icon not found: ";
        r3.append(r4);
        r3.append(r7);
        r7 = ", ";
        r3.append(r7);
        r7 = r1.getMessage();
        r3.append(r7);
        r7 = r3.toString();
        android.util.Log.w(r2, r7);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.bj.b(android.net.Uri):android.graphics.drawable.Drawable");
    }

    /* renamed from: b */
    private Drawable m17163b(String str) {
        ConstantState constantState = (ConstantState) this.f13693n.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    /* renamed from: a */
    private void m17160a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f13693n.put(str, drawable.getConstantState());
        }
    }

    /* renamed from: g */
    private Drawable m17168g(Cursor cursor) {
        cursor = m17154a(this.f13691l.getSearchActivity());
        if (cursor != null) {
            return cursor;
        }
        return this.d.getPackageManager().getDefaultActivityIcon();
    }

    /* renamed from: a */
    private Drawable m17154a(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        Object obj = null;
        if (this.f13693n.containsKey(flattenToShortString)) {
            Drawable newDrawable;
            ConstantState constantState = (ConstantState) this.f13693n.get(flattenToShortString);
            if (constantState != null) {
                newDrawable = constantState.newDrawable(this.f13692m.getResources());
            }
            return newDrawable;
        }
        componentName = m17161b(componentName);
        if (componentName != null) {
            obj = componentName.getConstantState();
        }
        this.f13693n.put(flattenToShortString, obj);
        return componentName;
    }

    /* renamed from: b */
    private Drawable m17161b(ComponentName componentName) {
        PackageManager packageManager = this.d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid icon resource ");
            stringBuilder.append(iconResource);
            stringBuilder.append(" for ");
            stringBuilder.append(componentName.flattenToShortString());
            Log.w("SuggestionsAdapter", stringBuilder.toString());
            return null;
        } catch (ComponentName componentName2) {
            Log.w("SuggestionsAdapter", componentName2.toString());
            return null;
        }
    }

    /* renamed from: a */
    public static String m17157a(Cursor cursor, String str) {
        return m17156a(cursor, cursor.getColumnIndex(str));
    }

    /* renamed from: a */
    private static String m17156a(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Cursor cursor2) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", cursor2);
            return null;
        }
    }

    /* renamed from: a */
    android.graphics.drawable.Drawable m17171a(android.net.Uri r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r7 = this;
        r0 = r8.getAuthority();
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x00ba;
    L_0x000a:
        r1 = r7.d;	 Catch:{ NameNotFoundException -> 0x00a3 }
        r1 = r1.getPackageManager();	 Catch:{ NameNotFoundException -> 0x00a3 }
        r1 = r1.getResourcesForApplication(r0);	 Catch:{ NameNotFoundException -> 0x00a3 }
        r2 = r8.getPathSegments();
        if (r2 == 0) goto L_0x008c;
    L_0x001a:
        r3 = r2.size();
        r4 = 0;
        r5 = 1;
        if (r3 != r5) goto L_0x0044;
    L_0x0022:
        r0 = r2.get(r4);	 Catch:{ NumberFormatException -> 0x002d }
        r0 = (java.lang.String) r0;	 Catch:{ NumberFormatException -> 0x002d }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x002d }
        goto L_0x0057;
    L_0x002d:
        r0 = new java.io.FileNotFoundException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Single path segment is not a resource ID: ";
        r1.append(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x0044:
        r6 = 2;
        if (r3 != r6) goto L_0x0075;
    L_0x0047:
        r3 = r2.get(r5);
        r3 = (java.lang.String) r3;
        r2 = r2.get(r4);
        r2 = (java.lang.String) r2;
        r0 = r1.getIdentifier(r3, r2, r0);
    L_0x0057:
        if (r0 == 0) goto L_0x005e;
    L_0x0059:
        r8 = r1.getDrawable(r0);
        return r8;
    L_0x005e:
        r0 = new java.io.FileNotFoundException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "No resource found for: ";
        r1.append(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x0075:
        r0 = new java.io.FileNotFoundException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "More than two path segments: ";
        r1.append(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x008c:
        r0 = new java.io.FileNotFoundException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "No path: ";
        r1.append(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x00a3:
        r0 = new java.io.FileNotFoundException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "No package found for authority: ";
        r1.append(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x00ba:
        r0 = new java.io.FileNotFoundException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "No authority: ";
        r1.append(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.bj.a(android.net.Uri):android.graphics.drawable.Drawable");
    }

    /* renamed from: a */
    Cursor m17169a(SearchableInfo searchableInfo, String str, int i) {
        String[] strArr = null;
        if (searchableInfo == null) {
            return null;
        }
        String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return null;
        }
        Builder fragment = new Builder().scheme(UriUtil.LOCAL_CONTENT_SCHEME).authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }
}
