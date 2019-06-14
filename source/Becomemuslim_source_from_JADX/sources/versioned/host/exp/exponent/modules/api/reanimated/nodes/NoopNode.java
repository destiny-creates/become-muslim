package versioned.host.exp.exponent.modules.api.reanimated.nodes;

import versioned.host.exp.exponent.modules.api.reanimated.NodesManager;

public class NoopNode extends ValueNode {
    public void addChild(Node node) {
    }

    protected void markUpdated() {
    }

    public void removeChild(Node node) {
    }

    public void setValue(Object obj) {
    }

    public NoopNode(NodesManager nodesManager) {
        super(-2, null, nodesManager);
    }
}
