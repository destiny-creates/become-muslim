package host.exp.exponent.experience;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.C4908c;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import host.exp.exponent.C6369g;
import host.exp.exponent.C6369g.C6359a;
import host.exp.exponent.modules.C6395a;
import host.exp.exponent.p334a.C6289b;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p339f.C7560j;
import host.exp.exponent.p344h.C6373d;
import host.exp.p333a.C6279c.C6275d;
import host.exp.p333a.C6279c.C6277f;
import javax.inject.C6562a;
import org.json.JSONException;
import org.json.JSONObject;

public class InfoActivity extends C4908c {
    /* renamed from: e */
    private static final String f32945e = "InfoActivity";
    @C6562a
    /* renamed from: a */
    Context f32946a;
    @C6562a
    /* renamed from: b */
    C7560j f32947b;
    @C6562a
    /* renamed from: c */
    C6369g f32948c;
    @C6562a
    /* renamed from: d */
    C6373d f32949d;
    /* renamed from: f */
    private String f32950f;
    /* renamed from: g */
    private JSONObject f32951g;
    /* renamed from: h */
    private String f32952h;
    /* renamed from: i */
    private boolean f32953i = false;
    @BindView(2131492905)
    TextView mAppNameView;
    @BindView(2131493037)
    TextView mExperienceIdView;
    @BindView(2131492904)
    ImageView mImageView;
    @BindView(2131493083)
    TextView mIsVerifiedView;
    @BindView(2131493107)
    TextView mManifestTextView;
    @BindView(2131493149)
    TextView mPublishedTimeView;
    @BindView(2131493184)
    TextView mSdkVersionView;
    @BindView(2131493248)
    Button mToggleManifestButton;
    @BindView(2131493249)
    Toolbar mToolbar;

    /* renamed from: host.exp.exponent.experience.InfoActivity$1 */
    class C75381 implements C6359a {
        /* renamed from: a */
        final /* synthetic */ InfoActivity f26131a;

        C75381(InfoActivity infoActivity) {
            this.f26131a = infoActivity;
        }

        /* renamed from: a */
        public void mo5380a(Bitmap bitmap) {
            this.f26131a.mImageView.setImageBitmap(bitmap);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C6294a.m25957a().m25961b(InfoActivity.class, this);
        this.f32950f = getIntent().getExtras().getString("manifestUrl");
        if (this.f32950f != null) {
            bundle = this.f32949d.m26160c(this.f32950f);
            if (bundle != null) {
                this.f32951g = bundle.f20639a;
            }
        }
        setContentView(C6275d.info_activity);
        ButterKnife.bind(this);
        a(this.mToolbar);
        b().b(true);
        b().a(true);
        if (this.f32951g != null) {
            this.f32952h = this.f32951g.optString("id");
            String optString = this.f32951g.optString("iconUrl");
            if (optString != null) {
                this.f32948c.m26140a(optString, new C75381(this));
            }
            this.mAppNameView.setText(this.f32951g.optString("name", getString(C6277f.info_app_name_placeholder)));
            this.mSdkVersionView.setText(getString(C6277f.info_sdk_version, new Object[]{this.f32951g.optString("sdkVersion")}));
            this.mExperienceIdView.setText(getString(C6277f.info_id, new Object[]{this.f32952h}));
            this.mPublishedTimeView.setText(getString(C6277f.info_published_time, new Object[]{this.f32951g.optString("publishedTime")}));
            this.mIsVerifiedView.setText(getString(C6277f.info_is_verified, new Object[]{String.valueOf(this.f32951g.optBoolean("isVerified", false))}));
        }
    }

    /* renamed from: c */
    public boolean m44516c() {
        onBackPressed();
        return true;
    }

    @OnClick({2131492961})
    public void onClickClearData() {
        C6395a.m26251a(this.f32946a, this.f32952h);
        this.f32947b.m26070i(this.f32950f);
    }

    @OnClick({2131493248})
    public void onClickToggleManifest() {
        if (this.f32953i) {
            this.f32953i = false;
            if (this.mManifestTextView != null) {
                this.mManifestTextView.setText("");
            }
            this.mToggleManifestButton.setText(C6277f.info_show_manifest);
            return;
        }
        this.f32953i = true;
        if (this.mManifestTextView != null) {
            try {
                this.mManifestTextView.setText(this.f32951g.toString(4));
            } catch (JSONException e) {
                String str = f32945e;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not stringify manifest: ");
                stringBuilder.append(e.getMessage());
                C6289b.m25953c(str, stringBuilder.toString());
            }
        }
        this.mToggleManifestButton.setText(C6277f.info_hide_manifest);
    }
}
