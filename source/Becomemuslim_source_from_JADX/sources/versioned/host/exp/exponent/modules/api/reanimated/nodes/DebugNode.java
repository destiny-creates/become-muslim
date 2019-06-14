package versioned.host.exp.exponent.modules.api.reanimated.nodes;

import android.util.Log;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.share.internal.ShareConstants;
import versioned.host.exp.exponent.modules.api.reanimated.NodesManager;

public class DebugNode extends Node {
    private final String mMessage;
    private final int mValueID;

    public DebugNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mMessage = readableMap.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.mValueID = readableMap.getInt("value");
    }

    protected Object evaluate() {
        Log.d("REANIMATED", String.format("%s %s", new Object[]{this.mMessage, this.mNodesManager.findNodeById(this.mValueID, Node.class).value()}));
        return this.mNodesManager.findNodeById(this.mValueID, Node.class).value();
    }
}
