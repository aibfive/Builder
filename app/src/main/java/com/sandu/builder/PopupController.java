package com.sandu.builder;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.PopupWindow;

/**
 * Created by Administrator on 2017/11/1.
 */

public class PopupController {

    private PopupWindow popupWindow;
    private Context context;
    public PopupController(Context context, PopupWindow popupWindow){
        this.context = context;
        this.popupWindow = popupWindow;
    }

    /**
     * 设置内容View
     * @param layoutId
     */
    private void setView(int layoutId){
        View view = LayoutInflater.from(context).inflate(layoutId, null);
        popupWindow.setContentView(view);
    }

    /**
     * 设置内容View
     * @param view
     */
    private void setView(View view){
        popupWindow.setContentView(view);
    }

    /**
     * 设置宽高
     * @param width  宽度
     * @param height  高度
     */
    private void setWidthAndHeight(int width, int height){
        if(width == 0 || height == 0){
            popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
            popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        }else {
            popupWindow.setWidth(width);
            popupWindow.setHeight(height);
        }
    }

    /**
     * 设置窗口透明度
     * @param alpha  透明度
     */
    public void setWindowAlpha(float alpha){
        Window window = ((Activity)context).getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.alpha = alpha;
        window.setAttributes(params);
    }

    /**
     * 设置PopupWindow外界是否可以点击
     * @param isTouchable
     */
    private void setOutsideTouchable(boolean isTouchable){
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.setOutsideTouchable(isTouchable);
        popupWindow.setFocusable(isTouchable);
    }

    /**
     * 设置动画
     * @param animStyle
     */
    private void setAnimationStyle(int animStyle){
        popupWindow.setAnimationStyle(animStyle);
    }

    public static class Params{
        public int layoutId;
        public View popupView;
        public int width, height;
        public float alpha;
        public boolean isShowBg;
        public boolean isTouchable;
        public int animStyle;

        public void apply(PopupController controller){
            if(layoutId != 0) {
                controller.setView(layoutId);
            } else if(popupView != null){
                controller.setView(popupView);
            }
            controller.setWidthAndHeight(width, height);
            controller.setWindowAlpha(alpha);
            controller.setOutsideTouchable(isTouchable);
            controller.setAnimationStyle(animStyle);
        }
    }

}
