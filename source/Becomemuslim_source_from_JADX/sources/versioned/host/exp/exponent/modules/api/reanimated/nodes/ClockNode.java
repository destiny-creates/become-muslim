package versioned.host.exp.exponent.modules.api.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import versioned.host.exp.exponent.modules.api.reanimated.NodesManager;
import versioned.host.exp.exponent.modules.api.reanimated.NodesManager.OnAnimationFrame;

public class ClockNode extends Node implements OnAnimationFrame {
    public boolean isRunning;

    public ClockNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
    }

    public void start() {
        if (!this.isRunning) {
            this.isRunning = true;
            this.mNodesManager.postOnAnimation(this);
        }
    }

    public void stop() {
        this.isRunning = false;
    }

    protected Double evaluate() {
        return Double.valueOf(this.mNodesManager.currentFrameTimeMs);
    }

    public void onAnimationFrame() {
        if (this.isRunning) {
            markUpdated();
            this.mNodesManager.postOnAnimation(this);
        }
    }
}
