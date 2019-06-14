package versioned.host.exp.exponent.modules.api.components.maps;

import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.UIViewOperationQueue;
import java.util.HashMap;
import java.util.Map;

public class SizeReportingShadowNode extends LayoutShadowNode {
    public void onCollectExtraUpdates(UIViewOperationQueue uIViewOperationQueue) {
        super.onCollectExtraUpdates(uIViewOperationQueue);
        Map hashMap = new HashMap();
        hashMap.put("width", Float.valueOf(getLayoutWidth()));
        hashMap.put("height", Float.valueOf(getLayoutHeight()));
        uIViewOperationQueue.enqueueUpdateExtraData(getReactTag(), hashMap);
    }
}
