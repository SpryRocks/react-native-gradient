package com.gradient

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Shader
import android.util.AttributeSet
import android.view.View

class GradientView : View {
  constructor(context: Context?) : super(context)
  constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
    context,
    attrs,
    defStyleAttr
  )

  private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
  private var shader: LinearGradient? = null

  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    super.onSizeChanged(w, h, oldw, oldh)

    shader = LinearGradient(
      0f, 0f, 0f, h.toFloat(),
      Color.argb(0, 255, 0, 0), Color.argb(255/2, 0, 0, 255),
      Shader.TileMode.CLAMP
    )

    paint.shader = shader
  }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
  }
}
