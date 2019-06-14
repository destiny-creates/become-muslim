package versioned.host.exp.exponent.modules.api.av.video;

public interface FullscreenVideoPlayerPresentationChangeListener {
    void onFullscreenPlayerDidDismiss();

    void onFullscreenPlayerDidPresent();

    void onFullscreenPlayerWillDismiss();

    void onFullscreenPlayerWillPresent();
}
