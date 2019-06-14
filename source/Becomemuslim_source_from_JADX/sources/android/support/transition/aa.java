package android.support.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TransitionValues */
public class aa {
    /* renamed from: a */
    public final Map<String, Object> f541a = new HashMap();
    /* renamed from: b */
    public View f542b;
    /* renamed from: c */
    final ArrayList<C0254u> f543c = new ArrayList();

    public boolean equals(Object obj) {
        if (obj instanceof aa) {
            aa aaVar = (aa) obj;
            if (this.f542b == aaVar.f542b && this.f541a.equals(aaVar.f541a) != null) {
                return true;
            }
        }
        return null;
    }

    public int hashCode() {
        return (this.f542b.hashCode() * 31) + this.f541a.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TransitionValues@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        stringBuilder.append(":\n");
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("    view = ");
        stringBuilder3.append(this.f542b);
        stringBuilder3.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuilder2 = stringBuilder3.toString();
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("    values:");
        stringBuilder2 = stringBuilder3.toString();
        for (String str : this.f541a.keySet()) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append("    ");
            stringBuilder4.append(str);
            stringBuilder4.append(": ");
            stringBuilder4.append(this.f541a.get(str));
            stringBuilder4.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder2 = stringBuilder4.toString();
        }
        return stringBuilder2;
    }
}
