package versioned.host.exp.exponent.modules.api.components.maps;

import android.content.Context;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.android.gms.maps.C5125c;

public abstract class AirMapFeature extends ReactViewGroup {
    public abstract void addToMap(C5125c c5125c);

    public abstract Object getFeature();

    public abstract void removeFromMap(C5125c c5125c);

    public AirMapFeature(Context context) {
        super(context);
    }
}
