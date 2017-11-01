package com.sandu.builder;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

/**
 * Created by Administrator on 2017/11/1.
 */

public class CommonPopupWindow extends PopupWindow {

    private PopupController controller;

    private CommonPopupWindow(Context context){
        controller = new PopupController(context, this);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        controller.setWindowAlpha(1.0F);
    }

    public interface ViewInterface{
        void getChildView(View popupView);
    }

    public static class Builder{

        private PopupController.Params params;
        private ViewInterface viewInterface;
        private Context context;

        public Builder(Context context){
            params = new PopupController.Params();
            this.context = context;
        }

        /**
         * 设置内容View
         * @param layoutId
         */
        public Builder setView(int layoutId){
            params.layoutId = layoutId;
            return this;
        }

        /**
         * 设置内容View
         * @param view
         */
        public Builder setView(View view){
            params.popupView = view;
            return this;
        }

        /**
         * 设置宽高
         * @param width  宽度
         * @param height  高度
         */
        public Builder setWidthAndHeight(int width, int height){
            params.width = width;
            params.height = height;
            return this;
        }

        /**
         * 设置窗口透明度
         * @param alpha  透明度
         */
        public Builder setWindowAlpha(float alpha){
            params.alpha = alpha;
            return this;
        }

        /**
         * 设置PopupWindow外界是否可以点击
         * @param isTouchable
         */
        public Builder setOutsideTouchable(boolean isTouchable){
            params.isTouchable = isTouchable;
            return this;
        }

        /**
         * 设置动画
         * @param animStyle
         */
        public Builder setAnimationStyle(int animStyle){
            params.animStyle = animStyle;
            return this;
        }

        public Builder setViewInterface(ViewInterface viewInterface){
            this.viewInterface = viewInterface;
            return this;
        }

        public CommonPopupWindow create(){
            CommonPopupWindow popupWindow = new CommonPopupWindow(context);
            params.apply(popupWindow.controller);
            if(viewInterface != null &&
                    (params.popupView != null || params.layoutId != 0)){
                viewInterface.getChildView(params.popupView);
            }
            return popupWindow;
        }
    }

}
