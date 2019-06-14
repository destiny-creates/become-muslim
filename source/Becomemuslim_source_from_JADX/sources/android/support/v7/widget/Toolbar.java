package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.view.C0487a;
import android.support.v4.view.C0501e;
import android.support.v4.view.C0504g;
import android.support.v4.view.C0517s;
import android.support.v7.app.C0608a.C0605a;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.p035a.C0591a.C0590j;
import android.support.v7.p037c.p038a.C0631b;
import android.support.v7.view.C0641c;
import android.support.v7.view.C0646g;
import android.support.v7.view.menu.C0662o;
import android.support.v7.view.menu.C0662o.C0661a;
import android.support.v7.view.menu.C3273h;
import android.support.v7.view.menu.C3273h.C0657a;
import android.support.v7.view.menu.C3276j;
import android.support.v7.view.menu.C4487u;
import android.support.v7.widget.ActionMenuView.C0676e;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private static final String TAG = "Toolbar";
    private C0661a mActionMenuPresenterCallback;
    int mButtonGravity;
    ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private be mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private C3299a mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList<View> mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    private C0657a mMenuBuilderCallback;
    private ActionMenuView mMenuView;
    private final C0676e mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    C0736c mOnMenuItemClickListener;
    private C4492d mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private int mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private int mTitleTextColor;
    private TextView mTitleTextView;
    private br mWrapper;

    /* renamed from: android.support.v7.widget.Toolbar$2 */
    class C07342 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ Toolbar f1904a;

        C07342(Toolbar toolbar) {
            this.f1904a = toolbar;
        }

        public void run() {
            this.f1904a.showOverflowMenu();
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar$3 */
    class C07353 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ Toolbar f1905a;

        C07353(Toolbar toolbar) {
            this.f1905a = toolbar;
        }

        public void onClick(View view) {
            this.f1905a.collapseActionView();
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar$c */
    public interface C0736c {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    /* renamed from: android.support.v7.widget.Toolbar$1 */
    class C32981 implements C0676e {
        /* renamed from: a */
        final /* synthetic */ Toolbar f8702a;

        C32981(Toolbar toolbar) {
            this.f8702a = toolbar;
        }

        /* renamed from: a */
        public boolean mo602a(MenuItem menuItem) {
            return this.f8702a.mOnMenuItemClickListener != null ? this.f8702a.mOnMenuItemClickListener.onMenuItemClick(menuItem) : null;
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar$a */
    private class C3299a implements C0662o {
        /* renamed from: a */
        C3273h f8703a;
        /* renamed from: b */
        C3276j f8704b;
        /* renamed from: c */
        final /* synthetic */ Toolbar f8705c;

        /* renamed from: a */
        public void mo464a(C3273h c3273h, boolean z) {
        }

        /* renamed from: a */
        public void mo465a(C0661a c0661a) {
        }

        /* renamed from: a */
        public boolean mo467a(C4487u c4487u) {
            return false;
        }

        /* renamed from: b */
        public boolean mo469b() {
            return false;
        }

        C3299a(Toolbar toolbar) {
            this.f8705c = toolbar;
        }

        /* renamed from: a */
        public void mo463a(Context context, C3273h c3273h) {
            if (!(this.f8703a == null || this.f8704b == null)) {
                this.f8703a.mo2754d(this.f8704b);
            }
            this.f8703a = c3273h;
        }

        /* renamed from: b */
        public void mo468b(boolean z) {
            if (this.f8704b) {
                Object obj = null;
                if (this.f8703a) {
                    z = this.f8703a.size();
                    for (boolean z2 = false; z2 < z; z2++) {
                        if (this.f8703a.getItem(z2) == this.f8704b) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    mo470b(this.f8703a, this.f8704b);
                }
            }
        }

        /* renamed from: a */
        public boolean mo466a(C3273h c3273h, C3276j c3276j) {
            this.f8705c.ensureCollapseButtonView();
            c3273h = this.f8705c.mCollapseButtonView.getParent();
            if (c3273h != this.f8705c) {
                if (c3273h instanceof ViewGroup) {
                    ((ViewGroup) c3273h).removeView(this.f8705c.mCollapseButtonView);
                }
                this.f8705c.addView(this.f8705c.mCollapseButtonView);
            }
            this.f8705c.mExpandedActionView = c3276j.getActionView();
            this.f8704b = c3276j;
            c3273h = this.f8705c.mExpandedActionView.getParent();
            if (c3273h != this.f8705c) {
                if (c3273h instanceof ViewGroup) {
                    ((ViewGroup) c3273h).removeView(this.f8705c.mExpandedActionView);
                }
                c3273h = this.f8705c.generateDefaultLayoutParams();
                c3273h.a = 8388611 | (this.f8705c.mButtonGravity & 112);
                c3273h.f8706b = 2;
                this.f8705c.mExpandedActionView.setLayoutParams(c3273h);
                this.f8705c.addView(this.f8705c.mExpandedActionView);
            }
            this.f8705c.removeChildrenForExpandedActionView();
            this.f8705c.requestLayout();
            c3276j.m10124e(true);
            if ((this.f8705c.mExpandedActionView instanceof C0641c) != null) {
                ((C0641c) this.f8705c.mExpandedActionView).mo478a();
            }
            return true;
        }

        /* renamed from: b */
        public boolean mo470b(C3273h c3273h, C3276j c3276j) {
            if ((this.f8705c.mExpandedActionView instanceof C0641c) != null) {
                ((C0641c) this.f8705c.mExpandedActionView).mo479b();
            }
            this.f8705c.removeView(this.f8705c.mExpandedActionView);
            this.f8705c.removeView(this.f8705c.mCollapseButtonView);
            this.f8705c.mExpandedActionView = null;
            this.f8705c.addChildrenForExpandedActionView();
            this.f8704b = null;
            this.f8705c.requestLayout();
            c3276j.m10124e(null);
            return true;
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar$b */
    public static class C3300b extends C0605a {
        /* renamed from: b */
        int f8706b;

        public C3300b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8706b = null;
        }

        public C3300b(int i, int i2) {
            super(i, i2);
            this.f8706b = 0;
            this.a = 8388627;
        }

        public C3300b(C3300b c3300b) {
            super((C0605a) c3300b);
            this.f8706b = 0;
            this.f8706b = c3300b.f8706b;
        }

        public C3300b(C0605a c0605a) {
            super(c0605a);
            this.f8706b = null;
        }

        public C3300b(MarginLayoutParams marginLayoutParams) {
            super((LayoutParams) marginLayoutParams);
            this.f8706b = 0;
            m10363a(marginLayoutParams);
        }

        public C3300b(LayoutParams layoutParams) {
            super(layoutParams);
            this.f8706b = null;
        }

        /* renamed from: a */
        void m10363a(MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar$d */
    public static class C3301d extends C0487a {
        public static final Creator<C3301d> CREATOR = new C07371();
        /* renamed from: a */
        int f8707a;
        /* renamed from: b */
        boolean f8708b;

        /* renamed from: android.support.v7.widget.Toolbar$d$1 */
        static class C07371 implements ClassLoaderCreator<C3301d> {
            C07371() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2474a(parcel);
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m2475a(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2476a(i);
            }

            /* renamed from: a */
            public C3301d m2475a(Parcel parcel, ClassLoader classLoader) {
                return new C3301d(parcel, classLoader);
            }

            /* renamed from: a */
            public C3301d m2474a(Parcel parcel) {
                return new C3301d(parcel, null);
            }

            /* renamed from: a */
            public C3301d[] m2476a(int i) {
                return new C3301d[i];
            }
        }

        public C3301d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8707a = parcel.readInt();
            this.f8708b = parcel.readInt() != null ? true : null;
        }

        public C3301d(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f8707a);
            parcel.writeInt(this.f8708b);
        }
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0581a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList();
        this.mHiddenViews = new ArrayList();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new C32981(this);
        this.mShowOverflowMenuRunnable = new C07342(this);
        context = bq.m2769a(getContext(), attributeSet, C0590j.Toolbar, i, 0);
        this.mTitleTextAppearance = context.m2786g(C0590j.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = context.m2786g(C0590j.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = context.m2778c(C0590j.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = context.m2778c(C0590j.Toolbar_buttonGravity, 48);
        attributeSet = context.m2780d(C0590j.Toolbar_titleMargin, 0);
        if (context.m2787g(C0590j.Toolbar_titleMargins) != 0) {
            attributeSet = context.m2780d(C0590j.Toolbar_titleMargins, attributeSet);
        }
        this.mTitleMarginBottom = attributeSet;
        this.mTitleMarginTop = attributeSet;
        this.mTitleMarginEnd = attributeSet;
        this.mTitleMarginStart = attributeSet;
        attributeSet = context.m2780d(C0590j.Toolbar_titleMarginStart, -1);
        if (attributeSet >= null) {
            this.mTitleMarginStart = attributeSet;
        }
        attributeSet = context.m2780d(C0590j.Toolbar_titleMarginEnd, -1);
        if (attributeSet >= null) {
            this.mTitleMarginEnd = attributeSet;
        }
        attributeSet = context.m2780d(C0590j.Toolbar_titleMarginTop, -1);
        if (attributeSet >= null) {
            this.mTitleMarginTop = attributeSet;
        }
        attributeSet = context.m2780d(C0590j.Toolbar_titleMarginBottom, -1);
        if (attributeSet >= null) {
            this.mTitleMarginBottom = attributeSet;
        }
        this.mMaxButtonHeight = context.m2782e(C0590j.Toolbar_maxButtonHeight, -1);
        attributeSet = context.m2780d(C0590j.Toolbar_contentInsetStart, LinearLayoutManager.INVALID_OFFSET);
        int d = context.m2780d(C0590j.Toolbar_contentInsetEnd, LinearLayoutManager.INVALID_OFFSET);
        int e = context.m2782e(C0590j.Toolbar_contentInsetLeft, 0);
        int e2 = context.m2782e(C0590j.Toolbar_contentInsetRight, 0);
        ensureContentInsets();
        this.mContentInsets.m2740b(e, e2);
        if (!(attributeSet == -2147483648 && d == LinearLayoutManager.INVALID_OFFSET)) {
            this.mContentInsets.m2737a(attributeSet, d);
        }
        this.mContentInsetStartWithNavigation = context.m2780d(C0590j.Toolbar_contentInsetStartWithNavigation, LinearLayoutManager.INVALID_OFFSET);
        this.mContentInsetEndWithActions = context.m2780d(C0590j.Toolbar_contentInsetEndWithActions, LinearLayoutManager.INVALID_OFFSET);
        this.mCollapseIcon = context.m2773a(C0590j.Toolbar_collapseIcon);
        this.mCollapseDescription = context.m2779c(C0590j.Toolbar_collapseContentDescription);
        CharSequence c = context.m2779c(C0590j.Toolbar_title);
        if (!TextUtils.isEmpty(c)) {
            setTitle(c);
        }
        c = context.m2779c(C0590j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c)) {
            setSubtitle(c);
        }
        this.mPopupContext = getContext();
        setPopupTheme(context.m2786g(C0590j.Toolbar_popupTheme, 0));
        Drawable a = context.m2773a(C0590j.Toolbar_navigationIcon);
        if (a != null) {
            setNavigationIcon(a);
        }
        c = context.m2779c(C0590j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c)) {
            setNavigationContentDescription(c);
        }
        a = context.m2773a(C0590j.Toolbar_logo);
        if (a != null) {
            setLogo(a);
        }
        c = context.m2779c(C0590j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c)) {
            setLogoDescription(c);
        }
        if (context.m2787g(C0590j.Toolbar_titleTextColor) != null) {
            setTitleTextColor(context.m2776b(C0590j.Toolbar_titleTextColor, -1));
        }
        if (context.m2787g(C0590j.Toolbar_subtitleTextColor) != null) {
            setSubtitleTextColor(context.m2776b(C0590j.Toolbar_subtitleTextColor, -1));
        }
        context.m2774a();
    }

    public void setPopupTheme(int i) {
        if (this.mPopupTheme != i) {
            this.mPopupTheme = i;
            if (i == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public void setTitleMargin(int i, int i2, int i3, int i4) {
        this.mTitleMarginStart = i;
        this.mTitleMarginTop = i2;
        this.mTitleMarginEnd = i3;
        this.mTitleMarginBottom = i4;
        requestLayout();
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public void setTitleMarginStart(int i) {
        this.mTitleMarginStart = i;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    public void setTitleMarginTop(int i) {
        this.mTitleMarginTop = i;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public void setTitleMarginEnd(int i) {
        this.mTitleMarginEnd = i;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public void setTitleMarginBottom(int i) {
        this.mTitleMarginBottom = i;
        requestLayout();
    }

    public void onRtlPropertiesChanged(int i) {
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        ensureContentInsets();
        be beVar = this.mContentInsets;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        beVar.m2738a(z);
    }

    public void setLogo(int i) {
        setLogo(C0631b.m2112b(getContext(), i));
    }

    public boolean canShowOverflowMenu() {
        return getVisibility() == 0 && this.mMenuView != null && this.mMenuView.m10197a();
    }

    public boolean isOverflowMenuShowing() {
        return this.mMenuView != null && this.mMenuView.m10207g();
    }

    public boolean isOverflowMenuShowPending() {
        return this.mMenuView != null && this.mMenuView.m10208h();
    }

    public boolean showOverflowMenu() {
        return this.mMenuView != null && this.mMenuView.m10205e();
    }

    public boolean hideOverflowMenu() {
        return this.mMenuView != null && this.mMenuView.m10206f();
    }

    public void setMenu(C3273h c3273h, C4492d c4492d) {
        if (c3273h != null || this.mMenuView != null) {
            ensureMenuView();
            C3273h d = this.mMenuView.m10204d();
            if (d != c3273h) {
                if (d != null) {
                    d.m10075b(this.mOuterActionMenuPresenter);
                    d.m10075b(this.mExpandedMenuPresenter);
                }
                if (this.mExpandedMenuPresenter == null) {
                    this.mExpandedMenuPresenter = new C3299a(this);
                }
                c4492d.m15211d(true);
                if (c3273h != null) {
                    c3273h.m10065a((C0662o) c4492d, this.mPopupContext);
                    c3273h.m10065a(this.mExpandedMenuPresenter, this.mPopupContext);
                } else {
                    c4492d.mo463a(this.mPopupContext, null);
                    this.mExpandedMenuPresenter.mo463a(this.mPopupContext, null);
                    c4492d.mo468b(true);
                    this.mExpandedMenuPresenter.mo468b(true);
                }
                this.mMenuView.setPopupTheme(this.mPopupTheme);
                this.mMenuView.setPresenter(c4492d);
                this.mOuterActionMenuPresenter = c4492d;
            }
        }
    }

    public void dismissPopupMenus() {
        if (this.mMenuView != null) {
            this.mMenuView.m10209i();
        }
    }

    public boolean isTitleTruncated() {
        if (this.mTitleTextView == null) {
            return false;
        }
        Layout layout = this.mTitleTextView.getLayout();
        if (layout == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i = 0; i < lineCount; i++) {
            if (layout.getEllipsisCount(i) > 0) {
                return true;
            }
        }
        return false;
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            ensureLogoView();
            if (!isChildOrHidden(this.mLogoView)) {
                addSystemView(this.mLogoView, true);
            }
        } else if (this.mLogoView != null && isChildOrHidden(this.mLogoView)) {
            removeView(this.mLogoView);
            this.mHiddenViews.remove(this.mLogoView);
        }
        if (this.mLogoView != null) {
            this.mLogoView.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        return this.mLogoView != null ? this.mLogoView.getDrawable() : null;
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureLogoView();
        }
        if (this.mLogoView != null) {
            this.mLogoView.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        return this.mLogoView != null ? this.mLogoView.getContentDescription() : null;
    }

    private void ensureLogoView() {
        if (this.mLogoView == null) {
            this.mLogoView = new AppCompatImageView(getContext());
        }
    }

    public boolean hasExpandedActionView() {
        return (this.mExpandedMenuPresenter == null || this.mExpandedMenuPresenter.f8704b == null) ? false : true;
    }

    public void collapseActionView() {
        C3276j c3276j = this.mExpandedMenuPresenter == null ? null : this.mExpandedMenuPresenter.f8704b;
        if (c3276j != null) {
            c3276j.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mTitleTextView == null) {
                Context context = getContext();
                this.mTitleTextView = new AppCompatTextView(context);
                this.mTitleTextView.setSingleLine();
                this.mTitleTextView.setEllipsize(TruncateAt.END);
                if (this.mTitleTextAppearance != 0) {
                    this.mTitleTextView.setTextAppearance(context, this.mTitleTextAppearance);
                }
                if (this.mTitleTextColor != 0) {
                    this.mTitleTextView.setTextColor(this.mTitleTextColor);
                }
            }
            if (!isChildOrHidden(this.mTitleTextView)) {
                addSystemView(this.mTitleTextView, true);
            }
        } else if (this.mTitleTextView != null && isChildOrHidden(this.mTitleTextView)) {
            removeView(this.mTitleTextView);
            this.mHiddenViews.remove(this.mTitleTextView);
        }
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setText(charSequence);
        }
        this.mTitleText = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mSubtitleTextView == null) {
                Context context = getContext();
                this.mSubtitleTextView = new AppCompatTextView(context);
                this.mSubtitleTextView.setSingleLine();
                this.mSubtitleTextView.setEllipsize(TruncateAt.END);
                if (this.mSubtitleTextAppearance != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, this.mSubtitleTextAppearance);
                }
                if (this.mSubtitleTextColor != 0) {
                    this.mSubtitleTextView.setTextColor(this.mSubtitleTextColor);
                }
            }
            if (!isChildOrHidden(this.mSubtitleTextView)) {
                addSystemView(this.mSubtitleTextView, true);
            }
        } else if (this.mSubtitleTextView != null && isChildOrHidden(this.mSubtitleTextView)) {
            removeView(this.mSubtitleTextView);
            this.mHiddenViews.remove(this.mSubtitleTextView);
        }
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }

    public void setTitleTextAppearance(Context context, int i) {
        this.mTitleTextAppearance = i;
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setTextAppearance(context, i);
        }
    }

    public void setSubtitleTextAppearance(Context context, int i) {
        this.mSubtitleTextAppearance = i;
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        this.mTitleTextColor = i;
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(int i) {
        this.mSubtitleTextColor = i;
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setTextColor(i);
        }
    }

    public CharSequence getNavigationContentDescription() {
        return this.mNavButtonView != null ? this.mNavButtonView.getContentDescription() : null;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : 0);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureNavButtonView();
        }
        if (this.mNavButtonView != null) {
            this.mNavButtonView.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(C0631b.m2112b(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            ensureNavButtonView();
            if (!isChildOrHidden(this.mNavButtonView)) {
                addSystemView(this.mNavButtonView, true);
            }
        } else if (this.mNavButtonView != null && isChildOrHidden(this.mNavButtonView)) {
            removeView(this.mNavButtonView);
            this.mHiddenViews.remove(this.mNavButtonView);
        }
        if (this.mNavButtonView != null) {
            this.mNavButtonView.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        return this.mNavButtonView != null ? this.mNavButtonView.getDrawable() : null;
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.m10204d() == null) {
            C3273h c3273h = (C3273h) this.mMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new C3299a(this);
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            c3273h.m10065a(this.mExpandedMenuPresenter, this.mPopupContext);
        }
    }

    private void ensureMenuView() {
        if (this.mMenuView == null) {
            this.mMenuView = new ActionMenuView(getContext());
            this.mMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            this.mMenuView.m10196a(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.a = 8388613 | (this.mButtonGravity & 112);
            this.mMenuView.setLayoutParams(generateDefaultLayoutParams);
            addSystemView(this.mMenuView, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new C0646g(getContext());
    }

    public void inflateMenu(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public void setOnMenuItemClickListener(C0736c c0736c) {
        this.mOnMenuItemClickListener = c0736c;
    }

    public void setContentInsetsRelative(int i, int i2) {
        ensureContentInsets();
        this.mContentInsets.m2737a(i, i2);
    }

    public int getContentInsetStart() {
        return this.mContentInsets != null ? this.mContentInsets.m2741c() : 0;
    }

    public int getContentInsetEnd() {
        return this.mContentInsets != null ? this.mContentInsets.m2742d() : 0;
    }

    public void setContentInsetsAbsolute(int i, int i2) {
        ensureContentInsets();
        this.mContentInsets.m2740b(i, i2);
    }

    public int getContentInsetLeft() {
        return this.mContentInsets != null ? this.mContentInsets.m2736a() : 0;
    }

    public int getContentInsetRight() {
        return this.mContentInsets != null ? this.mContentInsets.m2739b() : 0;
    }

    public int getContentInsetStartWithNavigation() {
        if (this.mContentInsetStartWithNavigation != LinearLayoutManager.INVALID_OFFSET) {
            return this.mContentInsetStartWithNavigation;
        }
        return getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = LinearLayoutManager.INVALID_OFFSET;
        }
        if (i != this.mContentInsetStartWithNavigation) {
            this.mContentInsetStartWithNavigation = i;
            if (getNavigationIcon() != 0) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        if (this.mContentInsetEndWithActions != LinearLayoutManager.INVALID_OFFSET) {
            return this.mContentInsetEndWithActions;
        }
        return getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = LinearLayoutManager.INVALID_OFFSET;
        }
        if (i != this.mContentInsetEndWithActions) {
            this.mContentInsetEndWithActions = i;
            if (getNavigationIcon() != 0) {
                requestLayout();
            }
        }
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        Object obj;
        if (this.mMenuView != null) {
            C3273h d = this.mMenuView.m10204d();
            if (d != null && d.hasVisibleItems()) {
                obj = 1;
                if (obj == null) {
                    return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
                }
                return getContentInsetEnd();
            }
        }
        obj = null;
        if (obj == null) {
            return getContentInsetEnd();
        }
        return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
    }

    public int getCurrentContentInsetLeft() {
        if (C0517s.m1711e(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (C0517s.m1711e(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new C3327p(getContext(), null, C0581a.toolbarNavigationButtonStyle);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.a = 8388611 | (this.mButtonGravity & 112);
            this.mNavButtonView.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    void ensureCollapseButtonView() {
        if (this.mCollapseButtonView == null) {
            this.mCollapseButtonView = new C3327p(getContext(), null, C0581a.toolbarNavigationButtonStyle);
            this.mCollapseButtonView.setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.a = 8388611 | (this.mButtonGravity & 112);
            generateDefaultLayoutParams.f8706b = 2;
            this.mCollapseButtonView.setLayoutParams(generateDefaultLayoutParams);
            this.mCollapseButtonView.setOnClickListener(new C07353(this));
        }
    }

    private void addSystemView(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        } else if (checkLayoutParams(layoutParams)) {
            layoutParams = (C3300b) layoutParams;
        } else {
            layoutParams = generateLayoutParams(layoutParams);
        }
        layoutParams.f8706b = 1;
        if (z && this.mExpandedActionView) {
            view.setLayoutParams(layoutParams);
            this.mHiddenViews.add(view);
            return;
        }
        addView(view, layoutParams);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c3301d = new C3301d(super.onSaveInstanceState());
        if (!(this.mExpandedMenuPresenter == null || this.mExpandedMenuPresenter.f8704b == null)) {
            c3301d.f8707a = this.mExpandedMenuPresenter.f8704b.getItemId();
        }
        c3301d.f8708b = isOverflowMenuShowing();
        return c3301d;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C3301d) {
            C3301d c3301d = (C3301d) parcelable;
            super.onRestoreInstanceState(c3301d.m1558a());
            Menu d = this.mMenuView != null ? this.mMenuView.m10204d() : null;
            if (!(c3301d.f8707a == 0 || this.mExpandedMenuPresenter == null || d == null)) {
                MenuItem findItem = d.findItem(c3301d.f8707a);
                if (findItem != null) {
                    findItem.expandActionView();
                }
            }
            if (c3301d.f8708b != null) {
                postShowOverflowMenu();
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private void postShowOverflowMenu() {
        removeCallbacks(this.mShowOverflowMenuRunnable);
        post(this.mShowOverflowMenuRunnable);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            motionEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && motionEvent == null) {
                this.mEatingTouch = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            motionEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && motionEvent == null) {
                this.mEatingHover = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.mEatingHover = false;
        }
        return true;
    }

    private void measureChildConstrained(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        i = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        i2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height);
        i3 = MeasureSpec.getMode(i2);
        if (i3 != 1073741824 && i5 >= 0) {
            if (i3 != 0) {
                i5 = Math.min(MeasureSpec.getSize(i2), i5);
            }
            i2 = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(i, i2);
    }

    private int measureChildCollapseMargins(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private boolean shouldCollapse() {
        if (!this.mCollapsible) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (shouldLayout(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int measuredWidth;
        int max;
        int combineMeasuredStates;
        int measuredHeight;
        int combineMeasuredStates2;
        int[] iArr = this.mTempMargins;
        if (by.m2841a(this)) {
            i3 = 1;
            i4 = 0;
        } else {
            i3 = 0;
            i4 = 1;
        }
        if (shouldLayout(r7.mNavButtonView)) {
            measureChildConstrained(r7.mNavButtonView, i, 0, i2, 0, r7.mMaxButtonHeight);
            measuredWidth = r7.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(r7.mNavButtonView);
            max = Math.max(0, r7.mNavButtonView.getMeasuredHeight() + getVerticalMargins(r7.mNavButtonView));
            combineMeasuredStates = View.combineMeasuredStates(0, r7.mNavButtonView.getMeasuredState());
        } else {
            measuredWidth = 0;
            max = 0;
            combineMeasuredStates = 0;
        }
        if (shouldLayout(r7.mCollapseButtonView)) {
            measureChildConstrained(r7.mCollapseButtonView, i, 0, i2, 0, r7.mMaxButtonHeight);
            measuredWidth = r7.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(r7.mCollapseButtonView);
            max = Math.max(max, r7.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(r7.mCollapseButtonView));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, r7.mCollapseButtonView.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max2 = Math.max(currentContentInsetStart, measuredWidth) + 0;
        iArr[i3] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (shouldLayout(r7.mMenuView)) {
            measureChildConstrained(r7.mMenuView, i, max2, i2, 0, r7.mMaxButtonHeight);
            measuredWidth = r7.mMenuView.getMeasuredWidth() + getHorizontalMargins(r7.mMenuView);
            max = Math.max(max, r7.mMenuView.getMeasuredHeight() + getVerticalMargins(r7.mMenuView));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, r7.mMenuView.getMeasuredState());
        } else {
            measuredWidth = 0;
        }
        currentContentInsetStart = getCurrentContentInsetEnd();
        i3 = max2 + Math.max(currentContentInsetStart, measuredWidth);
        iArr[i4] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (shouldLayout(r7.mExpandedActionView)) {
            i3 += measureChildCollapseMargins(r7.mExpandedActionView, i, i3, i2, 0, iArr);
            max = Math.max(max, r7.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(r7.mExpandedActionView));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, r7.mExpandedActionView.getMeasuredState());
        }
        if (shouldLayout(r7.mLogoView)) {
            i3 += measureChildCollapseMargins(r7.mLogoView, i, i3, i2, 0, iArr);
            max = Math.max(max, r7.mLogoView.getMeasuredHeight() + getVerticalMargins(r7.mLogoView));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, r7.mLogoView.getMeasuredState());
        }
        i4 = getChildCount();
        max2 = max;
        max = i3;
        for (i3 = 0; i3 < i4; i3++) {
            View childAt = getChildAt(i3);
            if (((C3300b) childAt.getLayoutParams()).f8706b == 0) {
                if (shouldLayout(childAt)) {
                    max += measureChildCollapseMargins(childAt, i, max, i2, 0, iArr);
                    max2 = Math.max(max2, childAt.getMeasuredHeight() + getVerticalMargins(childAt));
                    combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, childAt.getMeasuredState());
                }
            }
        }
        i3 = r7.mTitleMarginTop + r7.mTitleMarginBottom;
        i4 = r7.mTitleMarginStart + r7.mTitleMarginEnd;
        if (shouldLayout(r7.mTitleTextView)) {
            measureChildCollapseMargins(r7.mTitleTextView, i, max + i4, i2, i3, iArr);
            measuredWidth = r7.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(r7.mTitleTextView);
            measuredHeight = r7.mTitleTextView.getMeasuredHeight() + getVerticalMargins(r7.mTitleTextView);
            combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, r7.mTitleTextView.getMeasuredState());
            combineMeasuredStates = measuredWidth;
        } else {
            combineMeasuredStates2 = combineMeasuredStates;
            combineMeasuredStates = 0;
            measuredHeight = 0;
        }
        if (shouldLayout(r7.mSubtitleTextView)) {
            int i5 = measuredHeight + i3;
            i3 = combineMeasuredStates2;
            combineMeasuredStates = Math.max(combineMeasuredStates, measureChildCollapseMargins(r7.mSubtitleTextView, i, max + i4, i2, i5, iArr));
            measuredHeight += r7.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(r7.mSubtitleTextView);
            combineMeasuredStates2 = View.combineMeasuredStates(i3, r7.mSubtitleTextView.getMeasuredState());
        } else {
            i3 = combineMeasuredStates2;
        }
        max += combineMeasuredStates;
        measuredWidth = Math.max(max2, measuredHeight) + (getPaddingTop() + getPaddingBottom());
        int i6 = i;
        currentContentInsetStart = View.resolveSizeAndState(Math.max(max + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i6, -16777216 & combineMeasuredStates2);
        measuredWidth = View.resolveSizeAndState(Math.max(measuredWidth, getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16);
        if (shouldCollapse()) {
            measuredWidth = 0;
        }
        setMeasuredDimension(currentContentInsetStart, measuredWidth);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int layoutChildRight;
        int currentContentInsetLeft;
        int currentContentInsetRight;
        int max;
        boolean shouldLayout;
        boolean shouldLayout2;
        int i6;
        int i7;
        int i8;
        C3300b c3300b;
        int i9;
        int i10;
        int size;
        C3300b c3300b2;
        Object obj;
        int i11;
        C3300b c3300b3;
        int i12;
        Toolbar toolbar = this;
        Object obj2 = C0517s.m1711e(this) == 1 ? 1 : null;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i13 = width - paddingRight;
        int[] iArr = toolbar.mTempMargins;
        iArr[1] = 0;
        iArr[0] = 0;
        int j = C0517s.m1716j(this);
        j = j >= 0 ? Math.min(j, i4 - i2) : 0;
        if (!shouldLayout(toolbar.mNavButtonView)) {
            i5 = paddingLeft;
        } else if (obj2 != null) {
            layoutChildRight = layoutChildRight(toolbar.mNavButtonView, i13, iArr, j);
            i5 = paddingLeft;
            if (shouldLayout(toolbar.mCollapseButtonView)) {
                if (obj2 == null) {
                    layoutChildRight = layoutChildRight(toolbar.mCollapseButtonView, layoutChildRight, iArr, j);
                } else {
                    i5 = layoutChildLeft(toolbar.mCollapseButtonView, i5, iArr, j);
                }
            }
            if (shouldLayout(toolbar.mMenuView)) {
                if (obj2 == null) {
                    i5 = layoutChildLeft(toolbar.mMenuView, i5, iArr, j);
                } else {
                    layoutChildRight = layoutChildRight(toolbar.mMenuView, layoutChildRight, iArr, j);
                }
            }
            currentContentInsetLeft = getCurrentContentInsetLeft();
            currentContentInsetRight = getCurrentContentInsetRight();
            iArr[0] = Math.max(0, currentContentInsetLeft - i5);
            iArr[1] = Math.max(0, currentContentInsetRight - (i13 - layoutChildRight));
            max = Math.max(i5, currentContentInsetLeft);
            i13 = Math.min(layoutChildRight, i13 - currentContentInsetRight);
            if (shouldLayout(toolbar.mExpandedActionView)) {
                if (obj2 == null) {
                    i13 = layoutChildRight(toolbar.mExpandedActionView, i13, iArr, j);
                } else {
                    max = layoutChildLeft(toolbar.mExpandedActionView, max, iArr, j);
                }
            }
            if (shouldLayout(toolbar.mLogoView)) {
                if (obj2 == null) {
                    i13 = layoutChildRight(toolbar.mLogoView, i13, iArr, j);
                } else {
                    max = layoutChildLeft(toolbar.mLogoView, max, iArr, j);
                }
            }
            shouldLayout = shouldLayout(toolbar.mTitleTextView);
            shouldLayout2 = shouldLayout(toolbar.mSubtitleTextView);
            if (shouldLayout) {
                i6 = paddingRight;
                i7 = 0;
            } else {
                C3300b c3300b4 = (C3300b) toolbar.mTitleTextView.getLayoutParams();
                i6 = paddingRight;
                i7 = ((c3300b4.topMargin + toolbar.mTitleTextView.getMeasuredHeight()) + c3300b4.bottomMargin) + 0;
            }
            if (shouldLayout2) {
                i8 = width;
            } else {
                c3300b = (C3300b) toolbar.mSubtitleTextView.getLayoutParams();
                i8 = width;
                i7 += (c3300b.topMargin + toolbar.mSubtitleTextView.getMeasuredHeight()) + c3300b.bottomMargin;
            }
            if (!shouldLayout) {
                if (shouldLayout2) {
                    i9 = paddingLeft;
                    i10 = j;
                    paddingRight = 0;
                    addCustomViewsWithGravity(toolbar.mTempViews, 3);
                    size = toolbar.mTempViews.size();
                    i7 = max;
                    for (max = 0; max < size; max++) {
                        i7 = layoutChildLeft((View) toolbar.mTempViews.get(max), i7, iArr, i10);
                    }
                    j = i10;
                    addCustomViewsWithGravity(toolbar.mTempViews, 5);
                    size = toolbar.mTempViews.size();
                    for (max = 0; max < size; max++) {
                        i13 = layoutChildRight((View) toolbar.mTempViews.get(max), i13, iArr, j);
                    }
                    addCustomViewsWithGravity(toolbar.mTempViews, 1);
                    size = getViewListMeasuredWidth(toolbar.mTempViews, iArr);
                    max = (i9 + (((i8 - i9) - i6) / 2)) - (size / 2);
                    size += max;
                    if (max < i7) {
                        i7 = size <= i13 ? max - (size - i13) : max;
                    }
                    size = toolbar.mTempViews.size();
                    for (paddingRight = 
/*
Method generation error in method: android.support.v7.widget.Toolbar.onLayout(boolean, int, int, int, int):void, dex: classes.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r7_17 'paddingRight' int) = (r7_8 'paddingRight' int), (r7_16 'paddingRight' int), (r7_16 'paddingRight' int) binds: {(r7_16 'paddingRight' int)=B:99:0x0294, (r7_16 'paddingRight' int)=B:100:0x0296, (r7_8 'paddingRight' int)=B:46:0x0128} in method: android.support.v7.widget.Toolbar.onLayout(boolean, int, int, int, int):void, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:146)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:124)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:187)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:320)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:257)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:220)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:110)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:75)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:12)
	at jadx.core.ProcessClass.process(ProcessClass.java:40)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:537)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:509)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 35 more

*/

                    private int getViewListMeasuredWidth(List<View> list, int[] iArr) {
                        int i = iArr[0];
                        iArr = iArr[1];
                        int size = list.size();
                        int i2 = iArr;
                        iArr = null;
                        int i3 = 0;
                        while (iArr < size) {
                            View view = (View) list.get(iArr);
                            C3300b c3300b = (C3300b) view.getLayoutParams();
                            int i4 = c3300b.leftMargin - i;
                            i = c3300b.rightMargin - i2;
                            i2 = Math.max(0, i4);
                            int max = Math.max(0, i);
                            i4 = Math.max(0, -i4);
                            i3 += (i2 + view.getMeasuredWidth()) + max;
                            iArr++;
                            i2 = Math.max(0, -i);
                            i = i4;
                        }
                        return i3;
                    }

                    private int layoutChildLeft(View view, int i, int[] iArr, int i2) {
                        C3300b c3300b = (C3300b) view.getLayoutParams();
                        int i3 = c3300b.leftMargin - iArr[0];
                        i += Math.max(0, i3);
                        iArr[0] = Math.max(0, -i3);
                        iArr = getChildTop(view, i2);
                        i2 = view.getMeasuredWidth();
                        view.layout(i, iArr, i + i2, view.getMeasuredHeight() + iArr);
                        return i + (i2 + c3300b.rightMargin);
                    }

                    private int layoutChildRight(View view, int i, int[] iArr, int i2) {
                        C3300b c3300b = (C3300b) view.getLayoutParams();
                        int i3 = c3300b.rightMargin - iArr[1];
                        i -= Math.max(0, i3);
                        iArr[1] = Math.max(0, -i3);
                        iArr = getChildTop(view, i2);
                        i2 = view.getMeasuredWidth();
                        view.layout(i - i2, iArr, i, view.getMeasuredHeight() + iArr);
                        return i - (i2 + c3300b.leftMargin);
                    }

                    private int getChildTop(View view, int i) {
                        C3300b c3300b = (C3300b) view.getLayoutParams();
                        view = view.getMeasuredHeight();
                        i = i > 0 ? (view - i) / 2 : 0;
                        int childVerticalGravity = getChildVerticalGravity(c3300b.a);
                        if (childVerticalGravity == 48) {
                            return getPaddingTop() - i;
                        }
                        if (childVerticalGravity == 80) {
                            return (((getHeight() - getPaddingBottom()) - view) - c3300b.bottomMargin) - i;
                        }
                        i = getPaddingTop();
                        childVerticalGravity = getPaddingBottom();
                        int height = getHeight();
                        int i2 = (((height - i) - childVerticalGravity) - view) / 2;
                        if (i2 < c3300b.topMargin) {
                            i2 = c3300b.topMargin;
                        } else {
                            height = (((height - childVerticalGravity) - view) - i2) - i;
                            if (height < c3300b.bottomMargin) {
                                i2 = Math.max(0, i2 - (c3300b.bottomMargin - height));
                            }
                        }
                        return i + i2;
                    }

                    private int getChildVerticalGravity(int i) {
                        i &= 112;
                        return (i == 16 || i == 48 || i == 80) ? i : this.mGravity & 112;
                    }

                    private void addCustomViewsWithGravity(List<View> list, int i) {
                        Object obj = C0517s.m1711e(this) == 1 ? 1 : null;
                        int childCount = getChildCount();
                        i = C0501e.m1587a(i, C0517s.m1711e(this));
                        list.clear();
                        View childAt;
                        if (obj != null) {
                            for (childCount--; childCount >= 0; childCount--) {
                                childAt = getChildAt(childCount);
                                C3300b c3300b = (C3300b) childAt.getLayoutParams();
                                if (c3300b.f8706b == 0 && shouldLayout(childAt) && getChildHorizontalGravity(c3300b.a) == i) {
                                    list.add(childAt);
                                }
                            }
                            return;
                        }
                        for (int i2 = 0; i2 < childCount; i2++) {
                            childAt = getChildAt(i2);
                            C3300b c3300b2 = (C3300b) childAt.getLayoutParams();
                            if (c3300b2.f8706b == 0 && shouldLayout(childAt) && getChildHorizontalGravity(c3300b2.a) == i) {
                                list.add(childAt);
                            }
                        }
                    }

                    private int getChildHorizontalGravity(int i) {
                        int e = C0517s.m1711e(this);
                        i = C0501e.m1587a(i, e) & 7;
                        if (i != 1) {
                            int i2 = 3;
                            if (!(i == 3 || i == 5)) {
                                if (e == 1) {
                                    i2 = 5;
                                }
                                return i2;
                            }
                        }
                        return i;
                    }

                    private boolean shouldLayout(View view) {
                        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? null : true;
                    }

                    private int getHorizontalMargins(View view) {
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
                        return C0504g.m1592a(marginLayoutParams) + C0504g.m1593b(marginLayoutParams);
                    }

                    private int getVerticalMargins(View view) {
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
                        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                    }

                    public C3300b generateLayoutParams(AttributeSet attributeSet) {
                        return new C3300b(getContext(), attributeSet);
                    }

                    protected C3300b generateLayoutParams(LayoutParams layoutParams) {
                        if (layoutParams instanceof C3300b) {
                            return new C3300b((C3300b) layoutParams);
                        }
                        if (layoutParams instanceof C0605a) {
                            return new C3300b((C0605a) layoutParams);
                        }
                        if (layoutParams instanceof MarginLayoutParams) {
                            return new C3300b((MarginLayoutParams) layoutParams);
                        }
                        return new C3300b(layoutParams);
                    }

                    protected C3300b generateDefaultLayoutParams() {
                        return new C3300b(-2, -2);
                    }

                    protected boolean checkLayoutParams(LayoutParams layoutParams) {
                        return (!super.checkLayoutParams(layoutParams) || (layoutParams instanceof C3300b) == null) ? null : true;
                    }

                    private static boolean isCustomView(View view) {
                        return ((C3300b) view.getLayoutParams()).f8706b == null ? true : null;
                    }

                    public aj getWrapper() {
                        if (this.mWrapper == null) {
                            this.mWrapper = new br(this, true);
                        }
                        return this.mWrapper;
                    }

                    void removeChildrenForExpandedActionView() {
                        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                            View childAt = getChildAt(childCount);
                            if (!(((C3300b) childAt.getLayoutParams()).f8706b == 2 || childAt == this.mMenuView)) {
                                removeViewAt(childCount);
                                this.mHiddenViews.add(childAt);
                            }
                        }
                    }

                    void addChildrenForExpandedActionView() {
                        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
                            addView((View) this.mHiddenViews.get(size));
                        }
                        this.mHiddenViews.clear();
                    }

                    private boolean isChildOrHidden(View view) {
                        if (view.getParent() != this) {
                            if (this.mHiddenViews.contains(view) == null) {
                                return null;
                            }
                        }
                        return true;
                    }

                    public void setCollapsible(boolean z) {
                        this.mCollapsible = z;
                        requestLayout();
                    }

                    public void setMenuCallbacks(C0661a c0661a, C0657a c0657a) {
                        this.mActionMenuPresenterCallback = c0661a;
                        this.mMenuBuilderCallback = c0657a;
                        if (this.mMenuView != null) {
                            this.mMenuView.m10196a(c0661a, c0657a);
                        }
                    }

                    private void ensureContentInsets() {
                        if (this.mContentInsets == null) {
                            this.mContentInsets = new be();
                        }
                    }

                    C4492d getOuterActionMenuPresenter() {
                        return this.mOuterActionMenuPresenter;
                    }

                    Context getPopupContext() {
                        return this.mPopupContext;
                    }
                }
