package versioned.host.exp.exponent.modules.api.components.maps;

import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.LinkedList;

public class ViewChangesTracker {
    private static ViewChangesTracker instance;
    private final long fps = 40;
    private Handler handler = new Handler(Looper.myLooper());
    private boolean hasScheduledFrame = false;
    private LinkedList<AirMapMarker> markers = new LinkedList();
    private LinkedList<AirMapMarker> markersToRemove = new LinkedList();
    private Runnable updateRunnable = new C67431();

    /* renamed from: versioned.host.exp.exponent.modules.api.components.maps.ViewChangesTracker$1 */
    class C67431 implements Runnable {
        C67431() {
        }

        public void run() {
            ViewChangesTracker.this.hasScheduledFrame = false;
            ViewChangesTracker.this.update();
            if (ViewChangesTracker.this.markers.size() > 0) {
                ViewChangesTracker.this.handler.postDelayed(ViewChangesTracker.this.updateRunnable, 40);
            }
        }
    }

    private ViewChangesTracker() {
    }

    static ViewChangesTracker getInstance() {
        if (instance == null) {
            synchronized (ViewChangesTracker.class) {
                instance = new ViewChangesTracker();
            }
        }
        return instance;
    }

    public void addMarker(AirMapMarker airMapMarker) {
        this.markers.add(airMapMarker);
        if (this.hasScheduledFrame == null) {
            this.hasScheduledFrame = true;
            this.handler.postDelayed(this.updateRunnable, 40);
        }
    }

    public void removeMarker(AirMapMarker airMapMarker) {
        this.markers.remove(airMapMarker);
    }

    public boolean containsMarker(AirMapMarker airMapMarker) {
        return this.markers.contains(airMapMarker);
    }

    public void update() {
        Iterator it = this.markers.iterator();
        while (it.hasNext()) {
            AirMapMarker airMapMarker = (AirMapMarker) it.next();
            if (!airMapMarker.updateCustomForTracking()) {
                this.markersToRemove.add(airMapMarker);
            }
        }
        if (this.markersToRemove.size() > 0) {
            this.markers.removeAll(this.markersToRemove);
            this.markersToRemove.clear();
        }
    }
}
