package versioned.host.exp.exponent.modules.api.reanimated.nodes;

import android.graphics.PointF;
import com.facebook.react.bridge.ReadableMap;
import versioned.host.exp.exponent.modules.api.reanimated.NodesManager;

public class BezierNode extends Node {
    private final int mInputID;
    private final CubicBezierInterpolator mInterpolator;

    private static class CubicBezierInterpolator {
        /* renamed from: a */
        protected PointF f23514a;
        /* renamed from: b */
        protected PointF f23515b;
        /* renamed from: c */
        protected PointF f23516c;
        protected PointF end;
        protected PointF start;

        public CubicBezierInterpolator(PointF pointF, PointF pointF2) {
            this.f23514a = new PointF();
            this.f23515b = new PointF();
            this.f23516c = new PointF();
            if (pointF.x < 0.0f || pointF.x > 1.0f) {
                throw new IllegalArgumentException("startX value must be in the range [0, 1]");
            } else if (pointF2.x < 0.0f || pointF2.x > 1.0f) {
                throw new IllegalArgumentException("endX value must be in the range [0, 1]");
            } else {
                this.start = pointF;
                this.end = pointF2;
            }
        }

        public CubicBezierInterpolator(float f, float f2, float f3, float f4) {
            this(new PointF(f, f2), new PointF(f3, f4));
        }

        public float getInterpolation(float f) {
            return getBezierCoordinateY(getXForTime(f));
        }

        protected float getBezierCoordinateY(float f) {
            this.f23516c.y = this.start.y * 3.0f;
            this.f23515b.y = ((this.end.y - this.start.y) * 3.0f) - this.f23516c.y;
            this.f23514a.y = (1.0f - this.f23516c.y) - this.f23515b.y;
            return f * (this.f23516c.y + ((this.f23515b.y + (this.f23514a.y * f)) * f));
        }

        protected float getXForTime(float f) {
            float f2 = f;
            for (int i = 1; i < 14; i++) {
                float bezierCoordinateX = getBezierCoordinateX(f2) - f;
                if (((double) Math.abs(bezierCoordinateX)) < 0.001d) {
                    break;
                }
                f2 -= bezierCoordinateX / getXDerivate(f2);
            }
            return f2;
        }

        private float getXDerivate(float f) {
            return this.f23516c.x + (f * ((this.f23515b.x * 2.0f) + ((this.f23514a.x * 3.0f) * f)));
        }

        private float getBezierCoordinateX(float f) {
            this.f23516c.x = this.start.x * 3.0f;
            this.f23515b.x = ((this.end.x - this.start.x) * 3.0f) - this.f23516c.x;
            this.f23514a.x = (1.0f - this.f23516c.x) - this.f23515b.x;
            return f * (this.f23516c.x + ((this.f23515b.x + (this.f23514a.x * f)) * f));
        }
    }

    public BezierNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mInputID = readableMap.getInt("input");
        this.mInterpolator = new CubicBezierInterpolator((float) readableMap.getDouble("mX1"), (float) readableMap.getDouble("mY1"), (float) readableMap.getDouble("mX2"), (float) readableMap.getDouble("mY2"));
    }

    protected Double evaluate() {
        return Double.valueOf((double) this.mInterpolator.getInterpolation(((Double) this.mNodesManager.getNodeValue(this.mInputID)).floatValue()));
    }
}
