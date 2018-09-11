/*
package com.hx.mvvm.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;


import com.hx.mvvm.R;

import java.lang.reflect.Field;

*/
/**
 * Created by hexiao on 2018/9/5.
 * 自定义通用的按钮样式
 *//*


public class CommonShapeBtn extends AppCompatButton {

    private Integer shapeMod=1;//默认0
    private Integer btnFullColor=0xFFFFFFFF;//整个按钮的颜色
    private Integer btnPressColor=0xFF666666;//按下的颜色
    private Integer btnStrokeColor=0;//边框颜色
    private float btnStrokeWidth=0F;//边框宽度
    private float btnRadius=0F;//边框的度数
    private Integer btnCornPosition=-1;//哪个位置圆角
    private boolean btnSpecialEffect=false;//是否开启特效
    private Integer btnDrawablePosition=-1;//图片的位置
    private Integer btnStartColor=0xFFFFFFFF;//开始的颜色
    private Integer btnEndColor=0xFFFFFFFF;//结束的颜色
    private Integer btnGradualChange=0;//渐变方向
    private GradientDrawable normalGradient=null;//正常情况下
    private GradientDrawable pressGradient=null;//按下效果
    private StateListDrawable stateListDrawable=null;
    private float contentWidth = 0f;//button内容总宽度
    private float contentHeight = 0f;//button内容总宽度

    public CommonShapeBtn(Context context) {
        this(context,null);
    }

    public CommonShapeBtn(Context context, AttributeSet attrs) {
       this(context,attrs,0);
    }

    public CommonShapeBtn(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context,attrs);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray arrays=context.obtainStyledAttributes(attrs,R.styleable.commonShapeBtn);
        shapeMod=arrays.getInt(R.styleable.commonShapeBtn_csb_shapeMod,shapeMod);
        btnFullColor=arrays.getColor(R.styleable.commonShapeBtn_csb_color,btnFullColor);
        btnPressColor=arrays.getColor(R.styleable.commonShapeBtn_csb_press_color,btnPressColor);
        btnStrokeColor=arrays.getColor(R.styleable.commonShapeBtn_csb_stroke_color,btnStrokeColor);
        btnStrokeWidth=arrays.getDimension(R.styleable.commonShapeBtn_csb_stroke_width,btnStrokeWidth);
        btnRadius=arrays.getDimension(R.styleable.commonShapeBtn_csb_corner_radius,btnRadius);
        btnCornPosition=arrays.getInt(R.styleable.commonShapeBtn_csb_corner_position,btnCornPosition);
        btnSpecialEffect=arrays.getBoolean(R.styleable.commonShapeBtn_csb_special_effect,btnSpecialEffect);
        btnDrawablePosition=arrays.getInt(R.styleable.commonShapeBtn_csb_drawable_position,btnDrawablePosition);
        btnStartColor=arrays.getColor(R.styleable.commonShapeBtn_csb_start_color,btnStartColor);
        btnEndColor=arrays.getColor(R.styleable.commonShapeBtn_csb_end_color,btnEndColor);
        btnGradualChange=arrays.getInt(R.styleable.commonShapeBtn_gradual_change,btnGradualChange);
        arrays.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        normalGradient=new GradientDrawable();
        if (btnStartColor!=0xFFFFFFFF&&btnEndColor!=0xFFFFFFFF){//是否设置了渐变颜色
            normalGradient.setColors(new int[]{btnStartColor,btnEndColor});//设置多个颜色
            switch (btnGradualChange){
                case 0:
                    normalGradient.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
                    break;
                case 1:
                    normalGradient.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                    break;
            }
        }else {//没有设置渐变颜色则填充整个颜色
            normalGradient.setColor(btnFullColor);
        }
        switch (shapeMod){  //设置按钮的形状
            case 1:
                normalGradient.setShape(GradientDrawable.RECTANGLE);
                break;
            case 2:
                normalGradient.setShape(GradientDrawable.OVAL);
                break;
            case 3:
                normalGradient.setShape(GradientDrawable.LINE);
                break;
            case 4:
                normalGradient.setShape(GradientDrawable.RING);
                break;
        }
        if (btnCornPosition==-1){//如果没有写设置哪个角的角度则统一设置
            normalGradient.setCornerRadius(btnRadius);
        }else {
            normalGradient.setCornerRadii(getCornerRadiusByPosition());
        }
        if (btnStrokeColor!=0){//设置边框的颜色
            normalGradient.setStroke((int)btnStrokeWidth,btnStrokeColor);
        }

        if (btnSpecialEffect){//是否开启特效 5.0以上
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                setBackground(new RippleDrawable(ColorStateList.valueOf(btnPressColor),normalGradient,null));
            }else {//5.0以下效果
                pressGradient=new GradientDrawable();
                pressGradient.setColor(btnPressColor);
                switch (shapeMod){
                    case 1:
                        pressGradient.setShape(GradientDrawable.RECTANGLE);
                        break;
                    case 2:
                        pressGradient.setShape(GradientDrawable.OVAL);
                        break;
                    case 3:
                        pressGradient.setShape(GradientDrawable.LINE);
                        break;
                    case 4:
                        pressGradient.setShape(GradientDrawable.RING);
                        break;
                }
                pressGradient.setCornerRadius(btnRadius);
                pressGradient.setStroke((int)btnStrokeWidth,btnStrokeColor);
                stateListDrawable=new StateListDrawable();
                //添加顺序必须最后添加正常的
                stateListDrawable.addState(new int[]{android.R.attr.state_pressed},pressGradient);
                stateListDrawable.addState(new int[]{},normalGradient);
                setBackground(stateListDrawable);
            }
        }else {
            setBackground(normalGradient);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (btnDrawablePosition>-1){
            Drawable[] drawables=getCompoundDrawables();
            Drawable drawable=drawables[btnDrawablePosition];
            if (drawable!=null){
                int padding=getCompoundDrawablePadding();//获取间距
                switch (btnDrawablePosition){//1,3代表左右 /2，4代表上下
                    case 0://左右drawable
                    case 2:
                        float drawableWidth=drawable.getIntrinsicWidth();//获取图片的宽度
                        float textWidth=getPaint().measureText(getText().toString());//获取的文字的宽度
                        contentWidth=textWidth+drawableWidth+padding; //内容总宽度
                        float rightPadding=getWidth()-contentWidth;//图片和文字全部靠在左侧
                        setPadding(0,0,(int)rightPadding,0);
                        break;
                    case 1://上下drawable
                    case 3:
                        float drawableHeight=drawable.getIntrinsicHeight();
                        Paint.FontMetrics pfm=getPaint().getFontMetrics();//获取文字的密度
                        float singleLineHeight= (float) Math.ceil(pfm.descent-pfm.ascent);//单行的高度
                        float totalLIneSpaceHeight=(getLineCount()-1)*getLineSpacingExtra();//总的行间距
                        float textHeight=singleLineHeight*getLineCount()+totalLIneSpaceHeight;
                        contentHeight=drawableHeight+textHeight+padding;
                        int bottomPadding= (int) (getHeight()-contentHeight);
                        setPadding(0,0,0,bottomPadding);
                        break;
                }
            }
        }
        setGravity(Gravity.CENTER);
        setClickable(true);
        changeTintContextWrapperToActivity();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //使图片和文字居中
        if (contentWidth>0&&(btnDrawablePosition==0||btnDrawablePosition==2)){
            canvas.translate((getWidth()-contentWidth)/2,0f);
        }else if (contentHeight>0&&(btnDrawablePosition==1||btnDrawablePosition==3)){
            canvas.translate(0f,(getHeight()-contentHeight)/2);
        }
        super.onDraw(canvas);
    }

    */
/**
     * 从support23.3.0开始View中的getContext方法返回的是TintContextWrapper而不再是Activity
     * 如果使用xml注册onClick属性，就会通过反射到Activity中去找对应的方法
     * 5.0以下系统会反射到TintContextWrapper中去找对应的方法，程序直接crash
     * 所以这里需要针对5.0以下系统单独处理View中的getContext返回值
     *//*

    private void changeTintContextWrapperToActivity(){
        if (Build.VERSION.SDK_INT<Build.VERSION_CODES.LOLLIPOP){//版本小于5.0
            Context context=getActivity();
            Class clazz=context.getClass();
            while (clazz!=null){
                try {
                    Field field=clazz.getDeclaredField("mContext");
                    field.setAccessible(true);
                    field.set(this,context);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                clazz=clazz.getSuperclass();
            }
        }
    }

    */
/**
     * 从activity中得到真正的activity
     * @return
     *//*

    private Context getActivity(){
        Context context= getContext();
        while (context instanceof ContextWrapper){
            if (context instanceof Activity){
                return context;
            }
            context=((ContextWrapper) context).getBaseContext();
        }
        return null;
    }


    */
/**
     * 设置角度 flag进行位或运算
     * @return
     *//*

    private float[] getCornerRadiusByPosition() {
        float[] result=new float[8];
        if (btnRadius<0){
            throw new RuntimeException("度数设置错误");
        }
        Log.i("info_shape",btnCornPosition+"");
        switch (btnCornPosition){
            case 1://左上
                result[0]=btnRadius;
                result[1]=btnRadius;
                return result;
            case 2://右上
                result[2]=btnRadius;
                result[3]=btnRadius;
                return result;
            case 4://右下
                result[4]=btnRadius;
                result[5]=btnRadius;
                return result;
            case 8://左下
                result[6]=btnRadius;
                result[7]=btnRadius;
                return result;
            case 3://上方
                result[0]=btnRadius;
                result[1]=btnRadius;
                result[2]=btnRadius;
                result[3]=btnRadius;
                return result;
            case 5://左上右下
                result[0]=btnRadius;
                result[1]=btnRadius;
                result[4]=btnRadius;
                result[5]=btnRadius;
                return result;
            case 9://左侧
                result[0]=btnRadius;
                result[1]=btnRadius;
                result[6]=btnRadius;
                result[7]=btnRadius;
                return result;
            case 6://右侧
                result[2]=btnRadius;
                result[3]=btnRadius;
                result[4]=btnRadius;
                result[5]=btnRadius;
                return result;
            case 10://左下右上
                result[2]=btnRadius;
                result[3]=btnRadius;
                result[6]=btnRadius;
                result[7]=btnRadius;
                return result;
            case 12://下方
                result[4]=btnRadius;
                result[5]=btnRadius;
                result[6]=btnRadius;
                result[7]=btnRadius;
                return result;
        }
        return result;
    }

}
*/
