package versioned.host.exp.exponent.modules.api.components.gesturehandler;

public abstract class BaseGestureHandlerInteractionController implements GestureHandlerInteractionController {
    public boolean shouldRecognizeSimultaneously(GestureHandler gestureHandler, GestureHandler gestureHandler2) {
        return false;
    }

    public boolean shouldRequireHandlerToWaitForFailure(GestureHandler gestureHandler, GestureHandler gestureHandler2) {
        return false;
    }

    public boolean shouldWaitForHandlerFailure(GestureHandler gestureHandler, GestureHandler gestureHandler2) {
        return false;
    }
}
