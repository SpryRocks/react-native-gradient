package com.gradient

import android.graphics.Color
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.GradientViewManagerInterface
import com.facebook.react.viewmanagers.GradientViewManagerDelegate

@ReactModule(name = GradientViewManager.NAME)
class GradientViewManager : SimpleViewManager<GradientView>(),
  GradientViewManagerInterface<GradientView> {
  private val mDelegate: ViewManagerDelegate<GradientView>

  init {
    mDelegate = GradientViewManagerDelegate(this)
  }

  override fun getDelegate(): ViewManagerDelegate<GradientView>? {
    return mDelegate
  }

  override fun getName(): String {
    return NAME
  }

  public override fun createViewInstance(context: ThemedReactContext): GradientView {
    return GradientView(context)
  }

  @ReactProp(name = "color")
  override fun setColor(view: GradientView?, color: String?) {
//    view?.setBackgroundColor(Color.parseColor(color))
  }

  override fun setBorderColor(view: GradientView?, value: Int?) {
    view?.borderColor = value
  }

  companion object {
    const val NAME = "GradientView"
  }
}
