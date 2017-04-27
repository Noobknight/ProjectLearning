package com.tvo.tavv.productchecking.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.tvo.tavv.productchecking.R;
import com.tvo.tavv.productchecking.common.BaseActivity;
import com.tvo.tavv.productchecking.fragments.ScanbarFragment;
import com.tvo.tavv.productchecking.utils.VersionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tavv
 * on 26/04/2017.
 */

public class HomeActivity extends BaseActivity {
    private final String TAG = HomeActivity.class.getSimpleName();
    private static final int ZXING_CAMERA_PERMISSION = 1;
    private boolean isApprovePerformTransaction;

    @Override
    protected int layoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initEvents() {
        if (VersionUtils.isMarshmallow()) {
            checkAndRequestPermission();
        }
        isApprovePerformTransaction = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
    }

    private void checkAndRequestPermission() {
        int accountPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        List<String> listPermissionNeeded = new ArrayList<>();
        if (accountPermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionNeeded.add(Manifest.permission.CAMERA);
        }
        if (!listPermissionNeeded.isEmpty()) {
            String[] permissions = listPermissionNeeded.toArray(new String[listPermissionNeeded.size()]);
            ActivityCompat.requestPermissions(this, permissions, ZXING_CAMERA_PERMISSION);
        }
    }

    @Override
    protected void initData() {

    }

    private void initScanbarFragment() {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.container, ScanbarFragment.newInstance());
        mFragmentTransaction.commit();
    }

    @Override
    protected String TAG() {
        return TAG;
    }


    @Override
    protected void onResume() {
        super.onResume();
        if(isApprovePerformTransaction){
            initScanbarFragment();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case ZXING_CAMERA_PERMISSION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    isApprovePerformTransaction = true;
                } else {
                    Log.w(TAG, "You did not accept the request can not use the functionality.");
                }
                break;
        }
    }
}
