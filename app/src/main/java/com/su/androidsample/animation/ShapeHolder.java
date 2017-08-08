package com.su.androidsample.animation;

import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;

/**
 * A data structure that holds a Shape and various properties that can be used to define how the shape is drawn.
 * <p>
 * Created by Clever.Su at Zoom on 7/27/2017.
 */

public class ShapeHolder {
    private float x = 0, y = 0;
    private ShapeDrawable shapeDrawable;
    private int color;
    private RadialGradient gradient;
    private float alpha = 1f;
    private Paint paint;

    public ShapeHolder(ShapeDrawable shapeDrawable) {
        this.shapeDrawable = shapeDrawable;
    }

    public void setPaint(Paint value) {
        this.paint = value;
    }

    public Paint getPaint() {
        return this.paint;
    }

    public void setX(float value) {
        x = value;
    }

    public float getX() {
        return x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return this.y;
    }

    public ShapeDrawable getShape() {
        return this.shapeDrawable;
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int value) {
        shapeDrawable.getPaint().setColor(value);
        color = value;
    }

    public void setGradient(RadialGradient value) {
        gradient = value;
    }

    public RadialGradient getGradient() {
        return this.gradient;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
        shapeDrawable.setAlpha((int) ((alpha * 255f) + .5f));
    }

    public float getWidth() {
        return shapeDrawable.getShape().getWidth();
    }

    public void setWidth(float width) {
        Shape s = shapeDrawable.getShape();
        s.resize(width, s.getHeight());
    }

    public float getHeight() {
        return shapeDrawable.getShape().getHeight();
    }

    public void setHeight(float height) {
        Shape s = shapeDrawable.getShape();
        s.resize(s.getWidth(), height);
    }
}
