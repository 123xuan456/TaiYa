package com.example.administrator.taiya.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.taiya.R;
import com.example.administrator.taiya.base.BaseActivity;

/*
  *调胎页面
 */
public class ChooseActivity extends BaseActivity implements View.OnClickListener{

    private ImageView iv;
    private PopupWindow popupWindow;
    private View view;
    private RelativeLayout rl_pop;
    private Intent intent;
    private int fromActivity;
    private TextView tv_num_left_front,tv_address_left_front;
    private TextView tv_num_right_front,tv_address_right_front;
    private TextView tv_num_left_rear,tv_address_left_rear;
    private TextView tv_num_right_rear,tv_address_right_rear;


    @Override
    protected void setView() {
        setContentView(R.layout.activity_device);
        this.intent = getIntent();
        fromActivity = this.intent.getIntExtra("ChooseDeviceActivity",0);
        Log.d("ChooseActivity", "fromActivity:" + fromActivity);
    }

    @Override
    protected void initView() {
        tv_num_left_front=(TextView)findViewById(R.id.tv_num_left_front);
        tv_address_left_front=(TextView)findViewById(R.id.tv_address_left_front);
        tv_num_right_front=(TextView)findViewById(R.id.tv_num_right_front);
        tv_address_right_front=(TextView)findViewById(R.id.tv_address_right_front);
        tv_num_left_rear=(TextView)findViewById(R.id.tv_num_left_rear);
        tv_address_left_rear=(TextView)findViewById(R.id.tv_address_left_rear);
        tv_num_right_rear=(TextView)findViewById(R.id.tv_num_right_rear);
        tv_address_right_rear=(TextView)findViewById(R.id.tv_address_right_rear);

        view= LayoutInflater.from(this).inflate(
                R.layout.popup_dialog, null);
        iv=(ImageView)findViewById(R.id.btn_title_right);
    }

    @Override
    protected void setListener() {
        //点击右上角按钮
        iv.setOnClickListener(this);
        tv_address_left_front.setOnClickListener(this);
        tv_address_right_front.setOnClickListener(this);
        tv_address_left_rear.setOnClickListener(this);
       tv_address_right_rear.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        //手动配对
        if (fromActivity==1){
            setActivityTitle(this,this.getString(R.string.manual_input),true);
            setText(R.string.input_tire_id);
            return;
        }else if (fromActivity==2) {
            //自动配对
            setActivityTitle(this,this.getString(R.string.scan_input),true);
            setText(R.string.scan_device);
            return;
        }else if (fromActivity==0){
            setText(R.string.pls_bind_device);
            setActivityTitle(this,this.getString(R.string.menu_change),true);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_title_right:
                if (fromActivity == 1)
                {
                    showPopup(R.string.help_manual);
                }else if (fromActivity==2){
                    showPopup(R.string.help_auto);
                }else if (fromActivity==0){
                    showPopup(R.string.help_change);
                }
                break;
            case R.id.rl_pop:
                popupWindow.dismiss();
                break;

            case R.id.tv_address_left_front:
                if (fromActivity == 1){
                showDialog1(tv_address_left_front);
                }else
                if (fromActivity==2){
                }


                break;
            case R.id.tv_address_right_front:
                if (fromActivity == 1){
                    showDialog1(tv_address_right_front);
                }else
                if (fromActivity==2){
                }
                break;
            case R.id.tv_address_left_rear:
                if (fromActivity == 1){
                    showDialog1(tv_address_left_rear);
                }else
                if (fromActivity==2){
                }
                break;
            case R.id.tv_address_right_rear:
                if (fromActivity == 1){
                    showDialog1(tv_address_right_rear);
                }else
                if (fromActivity==2){
                }
                break;

        }
    }

    private void showDialog1(final TextView paramTextView) {
        final View localView = LayoutInflater.from(this).inflate(R.layout.dailog_view, null);
        new AlertDialog.Builder(this).
                setTitle(getResources().getString(R.string.input_tire_id)).
                setView(localView).
                setPositiveButton(getResources().getString(R.string.ok),new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
               // EditText localEditText = (EditText)localView.findViewById(R.id.et_tire_id);
//                if (ParseData.isDeviceId(localEditText.getText().toString().trim()))
//                {
//                    paramTextView.setText((localEditText.getText().toString().trim()));
//                    return;
//                }
                new AlertDialog.Builder(ChooseActivity.this).
                        setTitle(ChooseActivity.this.getResources().getString(R.string.error_tire_id)).
                        setNegativeButton(ChooseActivity.this.getResources().getString(R.string.ok), null).show();
            }
        }).setNegativeButton(getResources().getString(R.string.cancel), null).show();

    }

    private void showPopup(int i) {
        if(popupWindow==null){
            popupWindow=new PopupWindow(view, WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT,true);
           // popupWindow.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.bg_help_text));
        }
        popupWindow.setOutsideTouchable(true);//触碰PopupWindow以外的布局可以获得触摸事件
        //设置popwindow的位置  tv:为微信右上角+号view，居于+号下方
        popupWindow.showAsDropDown(iv, 0, 0);
        TextView tv_pop = ((TextView) this.view.findViewById(R.id.tv_pop));
        tv_pop.setText(i);
        rl_pop = ((RelativeLayout) this.view.findViewById(R.id.rl_pop));
        rl_pop.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (popupWindow!=null){
            popupWindow.dismiss();
        }
    }

    /**
     * 针对不同状态，四个按钮显示不同数据
     * @param text
     */
    public void setText(int text) {
        tv_address_left_front.setText(text);
        tv_address_right_front.setText(text);
        tv_address_left_rear.setText(text);
        tv_address_right_rear.setText(text);


    }
}
