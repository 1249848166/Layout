package mf.com.sulayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class SuRelativeLayout extends RelativeLayout {


    public SuRelativeLayout(Context context) {
        this(context,null);
    }

    public SuRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SuRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int wSpect=MeasureSpec.getSize(widthMeasureSpec);
        int hSpect=MeasureSpec.getSize(heightMeasureSpec);
        int i=0;
        int size=getChildCount();
        for(i=0;i<size;i++){
            ViewGroup.LayoutParams params=getChildAt(i).getLayoutParams();
            float wRatio = 0,hRatio = 0;
            if(params instanceof SuRelativeLayout.LayoutParam){
                wRatio=((LayoutParam) params).getWidthPercent();
                hRatio=((LayoutParam) params).getHeightPercent();
            }
            if(wRatio>0&&wRatio<1){
                params.width= (int) (wSpect*wRatio);
            }
            if(hRatio>0&&hRatio<1){
                params.height= (int) (hSpect*hRatio);
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParam(getContext(),attrs);
    }

    public class LayoutParam extends RelativeLayout.LayoutParams{

        float widthPercent;
        float heightPercent;

        public float getWidthPercent() {
            return widthPercent;
        }

        public void setWidthPercent(float widthPercent) {
            this.widthPercent = widthPercent;
        }

        public float getHeightPercent() {
            return heightPercent;
        }

        public void setHeightPercent(float heightPercent) {
            this.heightPercent = heightPercent;
        }

        public LayoutParam(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray typedArray=c.obtainStyledAttributes(attrs,R.styleable.SuLayout);
            widthPercent=typedArray.getFloat(R.styleable.SuLayout_layout_widthPercent,widthPercent);
            heightPercent=typedArray.getFloat(R.styleable.SuLayout_layout_heightPercent,heightPercent);
            typedArray.recycle();
        }

        public LayoutParam(int w, int h) {
            super(w, h);
        }

        public LayoutParam(ViewGroup.LayoutParams source) {
            super(source);
        }

        public LayoutParam(MarginLayoutParams source) {
            super(source);
        }

    }
}
