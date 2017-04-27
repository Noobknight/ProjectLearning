package com.tvo.tavv.productchecking.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.tvo.tavv.productchecking.R;
import com.tvo.tavv.productchecking.models.ResponseModel;
import com.tvo.tavv.productchecking.presenters.ScanbarPresenter;
import com.tvo.tavv.productchecking.views.ScanbarView;

import java.util.ArrayList;
import java.util.Map;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by Tavv
 * on 25/04/2017.
 */

public class ScanbarFragment extends BaseFragment implements ZXingScannerView.ResultHandler, ScanbarView.Render<ResponseModel> {
    private static final String TAG = ScanbarFragment.class.getSimpleName();
    private static final String FLASH_STATE = "FLASH_STATE";
    private static final String AUTO_FOCUS_STATE = "AUTO_FOCUS_STATE";
    private static final String SELECTED_FORMATS = "SELECTED_FORMATS";
    private static final String CAMERA_ID = "CAMERA_ID";
    private ZXingScannerView mScannerView;
    private boolean mFlash;
    private boolean mAutoFocus;
    private ArrayList<Integer> mSelectedIndices;
    private int mCameraId = -1;
    private AppCompatButton btnSyncProduct;
    private ScanbarPresenter mPresenter;
    private AppCompatActivity activity;
    private FrameLayout mFrameScanView;

    public static ScanbarFragment newInstance() {
        Log.i(TAG, "newInstance ");
        return new ScanbarFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume ");
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
//        mScannerView.setFlash(mFlash);
//        mScannerView.setAutoFocus(mAutoFocus);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putBoolean(FLASH_STATE, mFlash);
//        outState.putBoolean(AUTO_FOCUS_STATE, mAutoFocus);
//        outState.putIntegerArrayList(SELECTED_FORMATS, mSelectedIndices);
//        outState.putInt(CAMERA_ID, mCameraId);
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_scanbar;
    }

    @Override
    protected void initViews(View view) {
        mPresenter = new ScanbarPresenter(baseActivity.getService());
//        mFrameScanView = (FrameLayout) view.findViewById(R.id.zxing_scarbar);
//        mScannerView = new ZXingScannerView(getContext()) {
//            @Override
//            protected IViewFinder createViewFinderView(Context context) {
//                return new ViewFinderView(context);
//            }
//        };
//        mFrameScanView.addView(mScannerView);
        mScannerView = (ZXingScannerView) view.findViewById(R.id.zxing_scarbar);
    }

    @Override
    protected void initEvents() {
        mScannerView.setResultHandler(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void handleResult(Result result) {
        if (result != null) {
            Map<ResultMetadataType, Object> data = result.getResultMetadata();
            Log.i(TAG, "handleResult " + data);
            Log.i(TAG, "handleResult " + result.getText());
            Log.i(TAG, "handleResult " + result.toString());
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mScannerView.resumeCameraPreview(ScanbarFragment.this);
            }
        }, 2000);

    }

    @Override
    public void showBottomControl(boolean isShow) {

    }

    @Override
    public void onResponse(ResponseModel responseModel) {

    }

    @Override
    public void onFailure(String msgError) {

    }
}
