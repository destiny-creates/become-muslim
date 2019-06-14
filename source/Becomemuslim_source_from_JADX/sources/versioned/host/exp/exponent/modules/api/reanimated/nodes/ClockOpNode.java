package versioned.host.exp.exponent.modules.api.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import versioned.host.exp.exponent.modules.api.reanimated.NodesManager;

public abstract class ClockOpNode extends Node {
    private int clockID;

    public static class ClockStartNode extends ClockOpNode {
        protected /* bridge */ /* synthetic */ Object evaluate() {
            return super.evaluate();
        }

        public ClockStartNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
            super(i, readableMap, nodesManager);
        }

        protected Double eval(ClockNode clockNode) {
            clockNode.start();
            return ZERO;
        }
    }

    public static class ClockStopNode extends ClockOpNode {
        protected /* bridge */ /* synthetic */ Object evaluate() {
            return super.evaluate();
        }

        public ClockStopNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
            super(i, readableMap, nodesManager);
        }

        protected Double eval(ClockNode clockNode) {
            clockNode.stop();
            return ZERO;
        }
    }

    public static class ClockTestNode extends ClockOpNode {
        protected /* bridge */ /* synthetic */ Object evaluate() {
            return super.evaluate();
        }

        public ClockTestNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
            super(i, readableMap, nodesManager);
        }

        protected Double eval(ClockNode clockNode) {
            return Double.valueOf(clockNode.isRunning != null ? 1.0d : 0.0d);
        }
    }

    protected abstract Double eval(ClockNode clockNode);

    public ClockOpNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.clockID = readableMap.getInt("clock");
    }

    protected Double evaluate() {
        return eval((ClockNode) this.mNodesManager.findNodeById(this.clockID, ClockNode.class));
    }
}
