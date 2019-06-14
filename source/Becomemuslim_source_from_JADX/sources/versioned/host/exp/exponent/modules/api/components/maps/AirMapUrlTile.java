package versioned.host.exp.exponent.modules.api.components.maps;

import android.content.Context;
import com.google.android.gms.maps.C5125c;
import com.google.android.gms.maps.model.C5147x;
import com.google.android.gms.maps.model.C7857y;
import com.google.android.gms.maps.model.aa;
import java.net.URL;

public class AirMapUrlTile extends AirMapFeature {
    private float maximumZ;
    private float minimumZ;
    private C5147x tileOverlay;
    private C7857y tileOverlayOptions;
    private AIRMapUrlTileProvider tileProvider;
    private String urlTemplate;
    private float zIndex;

    class AIRMapUrlTileProvider extends aa {
        private String urlTemplate;

        public AIRMapUrlTileProvider(int i, int i2, String str) {
            super(i, i2);
            this.urlTemplate = str;
        }

        public synchronized URL getTileUrl(int i, int i2, int i3) {
            i = this.urlTemplate.replace("{x}", Integer.toString(i)).replace("{y}", Integer.toString(i2)).replace("{z}", Integer.toString(i3));
            if (AirMapUrlTile.this.maximumZ > 0.0f && ((float) i3) > AirMapUrlTile.this.maximumZ) {
                return null;
            }
            if (AirMapUrlTile.this.minimumZ > 0.0f && ((float) i3) < AirMapUrlTile.this.minimumZ) {
                return null;
            }
            try {
                return new URL(i);
            } catch (int i4) {
                throw new AssertionError(i4);
            }
        }

        public void setUrlTemplate(String str) {
            this.urlTemplate = str;
        }
    }

    public AirMapUrlTile(Context context) {
        super(context);
    }

    public void setUrlTemplate(String str) {
        this.urlTemplate = str;
        if (this.tileProvider != null) {
            this.tileProvider.setUrlTemplate(str);
        }
        if (this.tileOverlay != null) {
            this.tileOverlay.m21830b();
        }
    }

    public void setZIndex(float f) {
        this.zIndex = f;
        if (this.tileOverlay != null) {
            this.tileOverlay.m21829a(f);
        }
    }

    public void setMaximumZ(float f) {
        this.maximumZ = f;
        if (this.tileOverlay != null) {
            this.tileOverlay.m21830b();
        }
    }

    public void setMinimumZ(float f) {
        this.minimumZ = f;
        if (this.tileOverlay != null) {
            this.tileOverlay.m21830b();
        }
    }

    public C7857y getTileOverlayOptions() {
        if (this.tileOverlayOptions == null) {
            this.tileOverlayOptions = createTileOverlayOptions();
        }
        return this.tileOverlayOptions;
    }

    private C7857y createTileOverlayOptions() {
        C7857y c7857y = new C7857y();
        c7857y.m38380a(this.zIndex);
        this.tileProvider = new AIRMapUrlTileProvider(256, 256, this.urlTemplate);
        c7857y.m38381a(this.tileProvider);
        return c7857y;
    }

    public Object getFeature() {
        return this.tileOverlay;
    }

    public void addToMap(C5125c c5125c) {
        this.tileOverlay = c5125c.m21705a(getTileOverlayOptions());
    }

    public void removeFromMap(C5125c c5125c) {
        this.tileOverlay.m21828a();
    }
}
