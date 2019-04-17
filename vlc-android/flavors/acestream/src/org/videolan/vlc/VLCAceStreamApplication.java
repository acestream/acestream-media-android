package org.videolan.vlc;

import android.content.Context;

import org.acestream.engine.AceStreamEngineApplication;
import org.acestream.sdk.AceStream;
import org.acestream.sdk.interfaces.IBaseApplicationFactory;

public class VLCAceStreamApplication extends VLCApplication {

    public VLCAceStreamApplication() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AceStream.setBaseApplicationFactory(new IBaseApplicationFactory() {
            @Override
            public void initialize(Context context) {
                AceStreamEngineApplication.initialize(context);
            }
        });
    }
}
