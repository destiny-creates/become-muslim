package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.C0517s;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.p035a.C0591a.C0586f;
import android.support.v7.p035a.C0591a.C0587g;
import android.support.v7.p035a.C0591a.C0590j;
import android.support.v7.view.menu.C0664p.C0663a;
import android.support.v7.widget.bq;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements C0663a {
    /* renamed from: a */
    private C3276j f8424a;
    /* renamed from: b */
    private ImageView f8425b;
    /* renamed from: c */
    private RadioButton f8426c;
    /* renamed from: d */
    private TextView f8427d;
    /* renamed from: e */
    private CheckBox f8428e;
    /* renamed from: f */
    private TextView f8429f;
    /* renamed from: g */
    private ImageView f8430g;
    /* renamed from: h */
    private Drawable f8431h;
    /* renamed from: i */
    private int f8432i;
    /* renamed from: j */
    private Context f8433j;
    /* renamed from: k */
    private boolean f8434k;
    /* renamed from: l */
    private Drawable f8435l;
    /* renamed from: m */
    private int f8436m;
    /* renamed from: n */
    private LayoutInflater f8437n;
    /* renamed from: o */
    private boolean f8438o;

    /* renamed from: a */
    public boolean mo438a() {
        return false;
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0581a.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        attributeSet = bq.m2769a(getContext(), attributeSet, C0590j.MenuView, i, 0);
        this.f8431h = attributeSet.m2773a(C0590j.MenuView_android_itemBackground);
        this.f8432i = attributeSet.m2786g(C0590j.MenuView_android_itemTextAppearance, -1);
        this.f8434k = attributeSet.m2775a(C0590j.MenuView_preserveIconSpacing, false);
        this.f8433j = context;
        this.f8435l = attributeSet.m2773a(C0590j.MenuView_subMenuArrow);
        attributeSet.m2774a();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        C0517s.m1694a((View) this, this.f8431h);
        this.f8427d = (TextView) findViewById(C0586f.title);
        if (this.f8432i != -1) {
            this.f8427d.setTextAppearance(this.f8433j, this.f8432i);
        }
        this.f8429f = (TextView) findViewById(C0586f.shortcut);
        this.f8430g = (ImageView) findViewById(C0586f.submenuarrow);
        if (this.f8430g != null) {
            this.f8430g.setImageDrawable(this.f8435l);
        }
    }

    /* renamed from: a */
    public void mo437a(C3276j c3276j, int i) {
        this.f8424a = c3276j;
        this.f8436m = i;
        setVisibility(c3276j.isVisible() != 0 ? 0 : 8);
        setTitle(c3276j.m10111a((C0663a) this));
        setCheckable(c3276j.isCheckable());
        m10001a(c3276j.m10125f(), c3276j.m10121d());
        setIcon(c3276j.getIcon());
        setEnabled(c3276j.isEnabled());
        setSubMenuArrowVisible(c3276j.hasSubMenu());
        setContentDescription(c3276j.getContentDescription());
    }

    public void setForceShowIcon(boolean z) {
        this.f8438o = z;
        this.f8434k = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f8427d.setText(charSequence);
            if (this.f8427d.getVisibility() != null) {
                this.f8427d.setVisibility(0);
            }
        } else if (this.f8427d.getVisibility() != 8) {
            this.f8427d.setVisibility(8);
        }
    }

    public C3276j getItemData() {
        return this.f8424a;
    }

    public void setCheckable(boolean z) {
        if (z || this.f8426c != null || this.f8428e != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.f8424a.m10126g()) {
                if (this.f8426c == null) {
                    m9998c();
                }
                compoundButton = this.f8426c;
                compoundButton2 = this.f8428e;
            } else {
                if (this.f8428e == null) {
                    m9999d();
                }
                compoundButton = this.f8428e;
                compoundButton2 = this.f8426c;
            }
            if (z) {
                compoundButton.setChecked(this.f8424a.isChecked());
                z = z ? false : true;
                if (compoundButton.getVisibility() != z) {
                    compoundButton.setVisibility(z);
                }
                if (!(compoundButton2 == null || compoundButton2.getVisibility())) {
                    compoundButton2.setVisibility(8);
                }
            } else {
                if (this.f8428e) {
                    this.f8428e.setVisibility(8);
                }
                if (this.f8426c) {
                    this.f8426c.setVisibility(8);
                }
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f8424a.m10126g()) {
            if (this.f8426c == null) {
                m9998c();
            }
            compoundButton = this.f8426c;
        } else {
            if (this.f8428e == null) {
                m9999d();
            }
            compoundButton = this.f8428e;
        }
        compoundButton.setChecked(z);
    }

    private void setSubMenuArrowVisible(boolean z) {
        if (this.f8430g != null) {
            this.f8430g.setVisibility(z ? false : true);
        }
    }

    /* renamed from: a */
    public void m10001a(boolean z, char c) {
        z = (z && this.f8424a.m10125f()) ? false : true;
        if (!z) {
            this.f8429f.setText(this.f8424a.m10123e());
        }
        if (this.f8429f.getVisibility() != z) {
            this.f8429f.setVisibility(z);
        }
    }

    public void setIcon(Drawable drawable) {
        Object obj;
        ImageView imageView;
        if (!this.f8424a.m10128i()) {
            if (!this.f8438o) {
                obj = null;
                if (obj != null && !this.f8434k) {
                    return;
                }
                if (this.f8425b == null || drawable != null || this.f8434k) {
                    if (this.f8425b == null) {
                        m9997b();
                    }
                    if (drawable == null) {
                        if (this.f8434k) {
                            this.f8425b.setVisibility(8);
                        }
                    }
                    imageView = this.f8425b;
                    if (obj != null) {
                        drawable = null;
                    }
                    imageView.setImageDrawable(drawable);
                    if (this.f8425b.getVisibility() != null) {
                        this.f8425b.setVisibility(0);
                    }
                }
                return;
            }
        }
        obj = 1;
        if (obj != null) {
        }
        if (this.f8425b == null) {
        }
        if (this.f8425b == null) {
            m9997b();
        }
        if (drawable == null) {
            if (this.f8434k) {
                this.f8425b.setVisibility(8);
            }
        }
        imageView = this.f8425b;
        if (obj != null) {
            drawable = null;
        }
        imageView.setImageDrawable(drawable);
        if (this.f8425b.getVisibility() != null) {
            this.f8425b.setVisibility(0);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f8425b != null && this.f8434k) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f8425b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    /* renamed from: b */
    private void m9997b() {
        this.f8425b = (ImageView) getInflater().inflate(C0587g.abc_list_menu_item_icon, this, false);
        addView(this.f8425b, 0);
    }

    /* renamed from: c */
    private void m9998c() {
        this.f8426c = (RadioButton) getInflater().inflate(C0587g.abc_list_menu_item_radio, this, false);
        addView(this.f8426c);
    }

    /* renamed from: d */
    private void m9999d() {
        this.f8428e = (CheckBox) getInflater().inflate(C0587g.abc_list_menu_item_checkbox, this, false);
        addView(this.f8428e);
    }

    private LayoutInflater getInflater() {
        if (this.f8437n == null) {
            this.f8437n = LayoutInflater.from(getContext());
        }
        return this.f8437n;
    }
}
