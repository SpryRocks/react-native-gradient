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

  private val borderPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
    style = Paint.Style.STROKE
  }

  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    super.onSizeChanged(w, h, oldw, oldh)

    shader = LinearGradient(
      0f, 0f, 0f, h.toFloat(),
      Color.argb(255, 0, 255, 0),
      Color.argb(255, 0, 0, 255),
      Shader.TileMode.CLAMP
    )

    paint.shader = shader
  }

  var borderColor: Int? = null
    set(value) {
      field = value
      invalidate()
    }

  var borderWidth: Float? = null
    set(value) {
      field = value
      invalidate()
    }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    val borderWidth = this.borderWidth ?: 0f

    if (borderWidth > 0) {
      borderColor?.let { color ->
        borderPaint.color = color
        borderPaint.strokeWidth = borderWidth
        canvas.drawRect(
          0f,
          0f,
          width.toFloat() - borderWidth,
          height.toFloat() - borderWidth,
          borderPaint
        )
      }
    }

    canvas.drawRect(
      borderWidth,
      borderWidth,
      width.toFloat() - borderWidth * 2,
      height.toFloat() - borderWidth * 2,
      paint,
    )
  }
}
