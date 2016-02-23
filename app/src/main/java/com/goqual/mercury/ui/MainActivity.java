package com.goqual.mercury.ui;

import android.os.Bundle;

import com.goqual.mercury.R;
import com.goqual.mercury.service.SyncDataService;
import com.goqual.mercury.ui.base.BaseActivity;

import butterknife.BindString;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    private final String TAG = "ACTIVITY_MAIN";
    @BindString(R.string.EXTRA_TRIGGER_SYNC_FLAG)
    String EXTRA_TRIGGER_SYNC_FLAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (getIntent().getBooleanExtra(EXTRA_TRIGGER_SYNC_FLAG, true)) {
            startService(SyncDataService.getStartIntent(this));
        }
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
