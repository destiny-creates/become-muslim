package host.exp.exponent.experience;

import android.os.Bundle;
import android.support.v4.app.C3178i;
import android.support.v4.app.C4890j;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import host.exp.exponent.C6301d;
import host.exp.exponent.p339f.C6332e;
import host.exp.p333a.C6279c.C6275d;

public class ErrorConsoleFragment extends C3178i {
    /* renamed from: a */
    public ArrayAdapter<C6332e> f30362a;
    @BindView(2131492975)
    View mHomeButton;
    @BindView(2131493101)
    ListView mListView;

    @OnClick({2131492975})
    public void onClickHome() {
        C4890j activity = getActivity();
        if (activity instanceof ErrorActivity) {
            ((ErrorActivity) activity).m44454d();
        }
    }

    @OnClick({2131492976})
    public void onClickReload() {
        C4890j activity = getActivity();
        if (activity instanceof ErrorActivity) {
            ((ErrorActivity) activity).m44455e();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(C6275d.error_console_fragment, viewGroup, false);
        ButterKnife.bind(this, layoutInflater);
        viewGroup = getArguments();
        bundle = viewGroup.getString("manifestUrl");
        if (!(viewGroup.getBoolean("isHome", false) == null && bundle != null && bundle.equals(C6301d.f20496b) == null)) {
            this.mHomeButton.setVisibility(8);
        }
        viewGroup = ErrorActivity.m44452c();
        synchronized (viewGroup) {
            bundle = new ErrorQueueAdapter(getContext(), viewGroup);
            this.mListView.setAdapter(bundle);
            this.f30362a = bundle;
        }
        return layoutInflater;
    }
}
