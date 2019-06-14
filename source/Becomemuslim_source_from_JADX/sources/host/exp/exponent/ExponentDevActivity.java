package host.exp.exponent;

import android.os.Bundle;
import android.support.v4.content.C0366b;
import android.support.v7.app.C4908c;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p339f.C7560j;
import host.exp.exponent.p344h.C6373d;
import host.exp.p333a.C6279c.C6272a;
import host.exp.p333a.C6279c.C6274c;
import host.exp.p333a.C6279c.C6275d;
import javax.inject.C6562a;

public class ExponentDevActivity extends C4908c {
    /* renamed from: a */
    LinearLayout f32942a;
    @C6562a
    /* renamed from: b */
    C6373d f32943b;
    @C6562a
    /* renamed from: c */
    C7560j f32944c;

    /* renamed from: host.exp.exponent.ExponentDevActivity$2 */
    class C62812 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ ExponentDevActivity f20427a;

        C62812(ExponentDevActivity exponentDevActivity) {
            this.f20427a = exponentDevActivity;
        }

        public void onClick(View view) {
            this.f20427a.f32944c.m34250b();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C6275d.exponent_dev_activity);
        this.f32942a = (LinearLayout) findViewById(C6274c.linearLayout);
        C6294a.m25957a().m25961b(ExponentDevActivity.class, this);
        m44514a("Use Internet Kernel", "use_internet_kernel", null);
        m44515f();
    }

    /* renamed from: a */
    private void m44514a(String str, final String str2, final OnCheckedChangeListener onCheckedChangeListener) {
        CheckBox checkBox = (CheckBox) getLayoutInflater().inflate(C6275d.exponent_check_box, null);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, (int) TypedValue.applyDimension(1, 20.0f, getResources().getDisplayMetrics()));
        checkBox.setLayoutParams(layoutParams);
        checkBox.setTextColor(C0366b.c(this, C6272a.colorText));
        checkBox.setText(str);
        checkBox.setChecked(this.f32943b.m26155a(str2));
        checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            /* renamed from: c */
            final /* synthetic */ ExponentDevActivity f20426c;

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(compoundButton, z);
                }
                this.f20426c.f32943b.m26153a(str2, z);
            }
        });
        this.f32942a.addView(checkBox);
    }

    /* renamed from: f */
    private void m44515f() {
        Button button = (Button) getLayoutInflater().inflate(C6275d.exponent_button, null);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, (int) TypedValue.applyDimension(1, 20.0f, getResources().getDisplayMetrics()));
        button.setLayoutParams(layoutParams);
        button.setText("Reload Kernel");
        button.setOnClickListener(new C62812(this));
        this.f32942a.addView(button);
    }
}
