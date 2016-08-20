package com.wittgroupinc.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by Pawan Gupta on 08-08-2016.
 */
public class EditTextWithLabel extends LinearLayout {
    private TextView mLabel;
    private EditText mEditBox;
    private int labelColor = Color.MAGENTA;
    private int textColor = Color.GRAY;
    private int labelTextSize = dpToPx(getContext(), 12);
    private int textSize = dpToPx(getContext(), 10);


    public EditTextWithLabel(Context context) {
        super(context);
        init(context, null, 0);
    }

    public EditTextWithLabel(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public EditTextWithLabel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attributeSet, int defStyleAttr) {
        this.setOrientation(VERTICAL);
        LayoutInflater.from(context).inflate(R.layout.edit_text_with_label, this, true);
        mEditBox = (EditText) findViewById(R.id.box);
        mLabel = (TextView) findViewById(R.id.label);
        if (attributeSet != null) {
            final TypedArray attrs = context.obtainStyledAttributes(attributeSet, R.styleable.EditTextWithLabel, defStyleAttr, 0);
            String label = attrs.getString(R.styleable.EditTextWithLabel_label);
            String text = attrs.getString(R.styleable.EditTextWithLabel_text);
            labelColor = attrs.getColor(R.styleable.EditTextWithLabel_label_text_color,labelColor );
            textColor = attrs.getColor(R.styleable.EditTextWithLabel_text_color, textColor);
            labelTextSize = attrs.getDimensionPixelSize(R.styleable.EditTextWithLabel_label_text_size, labelTextSize);
            textSize = attrs.getDimensionPixelSize(R.styleable.EditTextWithLabel_text_size, textSize);
            String hint = attrs.getString(R.styleable.EditTextWithLabel_hint);
            attrs.recycle();
            setHint(hint);
            setLabelText(label);
            setText(text);
            setLabelFontSize(labelTextSize);
            setFontSize(textSize);
            setLabelTextColor(labelColor);
            setTextColor(textColor);

        }
    }


    public void setLabelText(String text) {
        mLabel.setText(text);
    }

    public void setText(String text) {
        mEditBox.setText(text);
    }

    public void setTextColor(int color) {
        mEditBox.setTextColor(color);
    }

    public void setLabelTextColor(int color) {
        mLabel.setTextColor(color);
    }

    public void setLabelFontSize(int fontSize) {
        mLabel.setTextSize(TypedValue.COMPLEX_UNIT_PX, fontSize);
    }

    public void setFontSize(int fontSize) {
        mEditBox.setTextSize(TypedValue.COMPLEX_UNIT_PX, fontSize);
    }
public void setHint(String hint){
    mEditBox.setHint(hint);
}

    private int dpToPx(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return Math.round(dp * scale);
    }


}
