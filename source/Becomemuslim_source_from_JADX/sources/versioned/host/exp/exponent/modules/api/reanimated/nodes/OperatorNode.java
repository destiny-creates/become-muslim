package versioned.host.exp.exponent.modules.api.reanimated.nodes;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import versioned.host.exp.exponent.modules.api.reanimated.NodesManager;
import versioned.host.exp.exponent.modules.api.reanimated.Utils;

public class OperatorNode extends Node {
    private static final Operator ADD = new C82021();
    private static final Operator AND = new Operator() {
        public double evaluate(Node[] nodeArr) {
            boolean access$200 = OperatorNode.truthy(nodeArr[0].value());
            for (int i = 1; i < nodeArr.length && access$200; i++) {
                access$200 = access$200 && OperatorNode.truthy(nodeArr[i].value());
            }
            return access$200 ? 1.0d : 0.0d;
        }
    };
    private static final Operator COS = new C82109();
    private static final Operator DEFINED = new Operator() {
        public double evaluate(Node[] nodeArr) {
            nodeArr = nodeArr[0].value();
            return (nodeArr == null || ((nodeArr instanceof Double) && ((Double) nodeArr).isNaN() != null)) ? 0.0d : 1.0d;
        }
    };
    private static final Operator DIVIDE = new C82054();
    private static final Operator EQ = new CompOperator() {
        public boolean eval(Double d, Double d2) {
            return d.equals(d2);
        }
    };
    private static final Operator EXP = new SingleOperator() {
        public double eval(Double d) {
            return Math.exp(d.doubleValue());
        }
    };
    private static final Operator GREATER_OR_EQ = new CompOperator() {
        public boolean eval(Double d, Double d2) {
            return d.doubleValue() >= d2.doubleValue() ? true : null;
        }
    };
    private static final Operator GREATER_THAN = new CompOperator() {
        public boolean eval(Double d, Double d2) {
            return d.doubleValue() > d2.doubleValue() ? true : null;
        }
    };
    private static final Operator LESS_OR_EQ = new CompOperator() {
        public boolean eval(Double d, Double d2) {
            return d.doubleValue() <= d2.doubleValue() ? true : null;
        }
    };
    private static final Operator LESS_THAN = new CompOperator() {
        public boolean eval(Double d, Double d2) {
            return d.doubleValue() < d2.doubleValue() ? true : null;
        }
    };
    private static final Operator MODULO = new C82076();
    private static final Operator MULTIPLY = new C82043();
    private static final Operator NEQ = new CompOperator() {
        public boolean eval(Double d, Double d2) {
            return d.equals(d2) ^ 1;
        }
    };
    private static final Operator NOT = new Operator() {
        public double evaluate(Node[] nodeArr) {
            return OperatorNode.truthy(nodeArr[0].value()) != null ? 0.0d : 1.0d;
        }
    };
    private static final Operator OR = new Operator() {
        public double evaluate(Node[] nodeArr) {
            boolean access$200 = OperatorNode.truthy(nodeArr[0].value());
            for (int i = 1; i < nodeArr.length && !access$200; i++) {
                if (!access$200) {
                    if (!OperatorNode.truthy(nodeArr[i].value())) {
                        access$200 = false;
                    }
                }
                access$200 = true;
            }
            return access$200 ? 1.0d : 0.0d;
        }
    };
    private static final Operator POW = new C82065();
    private static final Operator ROUND = new SingleOperator() {
        public double eval(Double d) {
            return (double) Math.round(d.doubleValue());
        }
    };
    private static final Operator SIN = new C82098();
    private static final Operator SQRT = new C82087();
    private static final Operator SUB = new C82032();
    private final int[] mInputIDs;
    private final Node[] mInputNodes = new Node[this.mInputIDs.length];
    private final Operator mOperator;

    private interface Operator {
        double evaluate(Node[] nodeArr);
    }

    private static abstract class CompOperator implements Operator {
        public abstract boolean eval(Double d, Double d2);

        private CompOperator() {
        }

        public double evaluate(Node[] nodeArr) {
            return eval((Double) nodeArr[0].value(), (Double) nodeArr[1].value()) != null ? 1.0d : 0.0d;
        }
    }

    private static abstract class ReduceOperator implements Operator {
        public abstract double reduce(Double d, Double d2);

        private ReduceOperator() {
        }

        public double evaluate(Node[] nodeArr) {
            double doubleValue = nodeArr[0].doubleValue().doubleValue();
            for (int i = 1; i < nodeArr.length; i++) {
                doubleValue = reduce(Double.valueOf(doubleValue), nodeArr[i].doubleValue());
            }
            return doubleValue;
        }
    }

    private static abstract class SingleOperator implements Operator {
        public abstract double eval(Double d);

        private SingleOperator() {
        }

        public double evaluate(Node[] nodeArr) {
            return eval((Double) nodeArr[0].value());
        }
    }

    /* renamed from: versioned.host.exp.exponent.modules.api.reanimated.nodes.OperatorNode$1 */
    static class C82021 extends ReduceOperator {
        C82021() {
            super();
        }

        public double reduce(Double d, Double d2) {
            return d.doubleValue() + d2.doubleValue();
        }
    }

    /* renamed from: versioned.host.exp.exponent.modules.api.reanimated.nodes.OperatorNode$2 */
    static class C82032 extends ReduceOperator {
        C82032() {
            super();
        }

        public double reduce(Double d, Double d2) {
            return d.doubleValue() - d2.doubleValue();
        }
    }

    /* renamed from: versioned.host.exp.exponent.modules.api.reanimated.nodes.OperatorNode$3 */
    static class C82043 extends ReduceOperator {
        C82043() {
            super();
        }

        public double reduce(Double d, Double d2) {
            return d.doubleValue() * d2.doubleValue();
        }
    }

    /* renamed from: versioned.host.exp.exponent.modules.api.reanimated.nodes.OperatorNode$4 */
    static class C82054 extends ReduceOperator {
        C82054() {
            super();
        }

        public double reduce(Double d, Double d2) {
            return d.doubleValue() / d2.doubleValue();
        }
    }

    /* renamed from: versioned.host.exp.exponent.modules.api.reanimated.nodes.OperatorNode$5 */
    static class C82065 extends ReduceOperator {
        C82065() {
            super();
        }

        public double reduce(Double d, Double d2) {
            return Math.pow(d.doubleValue(), d2.doubleValue());
        }
    }

    /* renamed from: versioned.host.exp.exponent.modules.api.reanimated.nodes.OperatorNode$6 */
    static class C82076 extends ReduceOperator {
        C82076() {
            super();
        }

        public double reduce(Double d, Double d2) {
            return ((d.doubleValue() % d2.doubleValue()) + d2.doubleValue()) % d2.doubleValue();
        }
    }

    /* renamed from: versioned.host.exp.exponent.modules.api.reanimated.nodes.OperatorNode$7 */
    static class C82087 extends SingleOperator {
        C82087() {
            super();
        }

        public double eval(Double d) {
            return Math.sqrt(d.doubleValue());
        }
    }

    /* renamed from: versioned.host.exp.exponent.modules.api.reanimated.nodes.OperatorNode$8 */
    static class C82098 extends SingleOperator {
        C82098() {
            super();
        }

        public double eval(Double d) {
            return Math.sin(d.doubleValue());
        }
    }

    /* renamed from: versioned.host.exp.exponent.modules.api.reanimated.nodes.OperatorNode$9 */
    static class C82109 extends SingleOperator {
        C82109() {
            super();
        }

        public double eval(Double d) {
            return Math.cos(d.doubleValue());
        }
    }

    private static boolean truthy(Object obj) {
        return (obj == null || obj.equals(Double.valueOf(0.0d)) != null) ? null : true;
    }

    public OperatorNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mInputIDs = Utils.processIntArray(readableMap.getArray("input"));
        i = readableMap.getString("op");
        if ("add".equals(i) != null) {
            this.mOperator = ADD;
        } else if ("sub".equals(i) != null) {
            this.mOperator = SUB;
        } else if ("multiply".equals(i) != null) {
            this.mOperator = MULTIPLY;
        } else if ("divide".equals(i) != null) {
            this.mOperator = DIVIDE;
        } else if ("pow".equals(i) != null) {
            this.mOperator = POW;
        } else if ("modulo".equals(i) != null) {
            this.mOperator = MODULO;
        } else if ("sqrt".equals(i) != null) {
            this.mOperator = SQRT;
        } else if ("sin".equals(i) != null) {
            this.mOperator = SIN;
        } else if ("cos".equals(i) != null) {
            this.mOperator = COS;
        } else if ("exp".equals(i) != null) {
            this.mOperator = EXP;
        } else if ("round".equals(i) != null) {
            this.mOperator = ROUND;
        } else if ("and".equals(i) != null) {
            this.mOperator = AND;
        } else if ("or".equals(i) != null) {
            this.mOperator = OR;
        } else if ("not".equals(i) != null) {
            this.mOperator = NOT;
        } else if ("defined".equals(i) != null) {
            this.mOperator = DEFINED;
        } else if ("lessThan".equals(i) != null) {
            this.mOperator = LESS_THAN;
        } else if ("eq".equals(i) != null) {
            this.mOperator = EQ;
        } else if ("greaterThan".equals(i) != null) {
            this.mOperator = GREATER_THAN;
        } else if ("lessOrEq".equals(i) != null) {
            this.mOperator = LESS_OR_EQ;
        } else if ("greaterOrEq".equals(i) != null) {
            this.mOperator = GREATER_OR_EQ;
        } else if ("neq".equals(i) != null) {
            this.mOperator = NEQ;
        } else {
            nodesManager = new StringBuilder();
            nodesManager.append("Unrecognized operator ");
            nodesManager.append(i);
            throw new JSApplicationIllegalArgumentException(nodesManager.toString());
        }
    }

    protected Object evaluate() {
        for (int i = 0; i < this.mInputIDs.length; i++) {
            this.mInputNodes[i] = this.mNodesManager.findNodeById(this.mInputIDs[i], Node.class);
        }
        return Double.valueOf(this.mOperator.evaluate(this.mInputNodes));
    }
}
