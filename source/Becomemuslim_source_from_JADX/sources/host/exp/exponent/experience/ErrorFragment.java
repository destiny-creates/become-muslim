package host.exp.exponent.experience;

import android.os.Bundle;
import android.support.v4.app.C3178i;
import android.support.v4.app.C4890j;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import host.exp.exponent.C6301d;
import host.exp.exponent.p334a.C6288a;
import host.exp.exponent.p334a.C6289b;
import host.exp.p333a.C6279c.C6275d;
import org.json.JSONObject;

public class ErrorFragment extends C3178i {
    /* renamed from: a */
    private static String f30363a = "ErrorFragment";
    @BindString(2132082857)
    String mDefaultError;
    @BindString(2132082858)
    String mDefaultErrorShell;
    @BindView(2131493014)
    TextView mErrorMessageView;
    @BindView(2131493061)
    View mHomeButton;

    @OnClick({2131493061})
    public void onClickHome() {
        C4890j activity = getActivity();
        if (activity instanceof ErrorActivity) {
            ((ErrorActivity) activity).m44454d();
        }
    }

    @OnClick({2131493153})
    public void onClickReload() {
        C4890j activity = getActivity();
        if (activity instanceof ErrorActivity) {
            ((ErrorActivity) activity).m44455e();
        }
    }

    @OnClick({2131493257})
    public void onClickViewErrorLog() {
        C4890j activity = getActivity();
        if (activity instanceof ErrorActivity) {
            ((ErrorActivity) activity).m44456f();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        boolean z = false;
        layoutInflater = layoutInflater.inflate(C6275d.error_fragment, viewGroup, false);
        ButterKnife.bind(this, layoutInflater);
        viewGroup = getArguments();
        bundle = Boolean.valueOf(viewGroup.getBoolean("isDebugModeEnabled"));
        String string = viewGroup.getString("userErrorMessage");
        String string2 = viewGroup.getString("developerErrorMessage");
        String string3 = viewGroup.getString("manifestUrl");
        viewGroup = viewGroup.getBoolean("isHome", false);
        if (string3 != null && string3.equals(C6301d.f20496b)) {
            z = true;
        }
        Object obj = z ? this.mDefaultErrorShell : this.mDefaultError;
        if (string != null) {
            if (string.length() != 0) {
                obj = string;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("USER_ERROR_MESSAGE", string);
                jSONObject.put("DEVELOPER_ERROR_MESSAGE", string2);
                jSONObject.put("MANIFEST_URL", string3);
                C6288a.m25945a("ERROR_SCREEN", jSONObject);
                if (!(viewGroup == null && string3 != null && string3.equals(C6301d.f20496b) == null)) {
                    this.mHomeButton.setVisibility(8);
                }
                this.mErrorMessageView.setText(obj);
                viewGroup = f30363a;
                bundle = new StringBuilder();
                bundle.append("ErrorActivity message: ");
                bundle.append(obj);
                C6289b.m25953c(viewGroup, bundle.toString());
                return layoutInflater;
            }
        }
        if (bundle.booleanValue() != null) {
            obj = string2;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("USER_ERROR_MESSAGE", string);
            jSONObject2.put("DEVELOPER_ERROR_MESSAGE", string2);
            jSONObject2.put("MANIFEST_URL", string3);
            C6288a.m25945a("ERROR_SCREEN", jSONObject2);
        } catch (Bundle bundle2) {
            C6289b.m25953c(f30363a, bundle2.getMessage());
        }
        this.mHomeButton.setVisibility(8);
        this.mErrorMessageView.setText(obj);
        viewGroup = f30363a;
        bundle2 = new StringBuilder();
        bundle2.append("ErrorActivity message: ");
        bundle2.append(obj);
        C6289b.m25953c(viewGroup, bundle2.toString());
        return layoutInflater;
    }
}
