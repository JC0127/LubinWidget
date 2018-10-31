package com.lubin.widget.tabbar;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lubin.widget.R;

/**
 * @author lubin
 * @version 1.0 ·2018/10/10
 */
public class TabItemLayout extends LinearLayout {
    private ImageView mIcon;
    private TextView mTxt;
    private TabItem mItem;
    private int position;
    private int tarbarWidth;
    private int tarbarHeight;
    private LinearLayout.LayoutParams params;

    public TabItemLayout(Context context) {
        super(context);
        initTabItemLayout(context);
    }

    public TabItemLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTabItemLayout(context);
    }

    public TabItemLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTabItemLayout(context);
    }

    void initTabItemLayout(Context context) {
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        LayoutInflater.from(context).inflate(R.layout.tabbar_item_layout, this, true);
        mIcon = findViewById(R.id.tat_icon);
        mTxt = findViewById(R.id.tab_txt);


    }

    public void initData(TabItem item) {
        this.mItem = item;
        if (item.getIcItem() == 0) {
            mIcon.setVisibility(GONE);
        } else {
            mIcon.setVisibility(VISIBLE);
            if (tarbarWidth > 0 && tarbarHeight > 0) {
                params = (LayoutParams) mIcon.getLayoutParams();
                params.height = tarbarHeight;
                params.width = tarbarWidth;
                params.gravity = Gravity.CENTER;
                mIcon.setLayoutParams(params);
            }
            mIcon.setImageResource(item.getIcItem());
            mIcon.setScaleType(ImageView.ScaleType.FIT_CENTER);

        }
        if (!getResources().getString(item.getTxtItem()).equals(getResources().getString(R.string.txt_null))) {
            mTxt.setText(item.getTxtItem());
            mTxt.setTextSize(item.getTxtSize());
            mTxt.setVisibility(VISIBLE);
            reTextColor();
        } else {
            mTxt.setVisibility(GONE);
        }
    }

    public void reTextColor() {

        if (this.isSelected()) {
            mTxt.setTextColor(ContextCompat.getColor(getContext(), mItem.getTxtColor()[0]));
        } else {
            if (mItem.getTxtColor().length > 1)
                mTxt.setTextColor(ContextCompat.getColor(getContext(), mItem.getTxtColor()[1]));
        }
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public ImageView getmIcon() {
        return mIcon;
    }

    public void setIconParams(int tarbarWidth, int tarbarHeight) {
        this.tarbarHeight = tarbarHeight;
        this.tarbarWidth = tarbarWidth;
    }
}
