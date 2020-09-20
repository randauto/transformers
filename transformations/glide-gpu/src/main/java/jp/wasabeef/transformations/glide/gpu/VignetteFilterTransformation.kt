package jp.wasabeef.transformations.glide.gpu

import android.graphics.PointF
import jp.co.cyberagent.android.gpuimage.filter.GPUImageVignetteFilter

/**
 * Copyright (C) 2020 Wasabeef
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Performs a vignetting effect, fading out the image at the edges
 * The directional intensity of the vignetting,
 * with a default of x = 0.5, y = 0.5, start = 0, end = 0.75
 */
class VignetteFilterTransformation @JvmOverloads constructor(
  private val center: PointF = PointF(0.5f, 0.5f),
  private val vignetteColor: FloatArray = floatArrayOf(0.0f, 0.0f, 0.0f),
  private val vignetteStart: Float = 0.0f,
  private val vignetteEnd: Float = 0.75f
) : GPUFilterTransformation(GPUImageVignetteFilter()) {

  init {
    val filter: GPUImageVignetteFilter = filter()
    filter.setVignetteCenter(center)
    filter.setVignetteColor(vignetteColor)
    filter.setVignetteStart(vignetteStart)
    filter.setVignetteEnd(vignetteEnd)
  }

  override fun key(): String =
    "$id(center=$center," +
      " vignetteColor=${vignetteColor.contentToString()}, vignetteStart=$vignetteStart," +
      " vignetteEnd=$vignetteEnd)"

  override fun equals(o: Any?): Boolean {
    if (this === o) return true
    if (javaClass != o?.javaClass) return false
    if (!super.equals(o)) return false

    o as VignetteFilterTransformation

    if (center != o.center) return false
    if (!vignetteColor.contentEquals(o.vignetteColor)) return false
    if (vignetteStart != o.vignetteStart) return false
    if (vignetteEnd != o.vignetteEnd) return false

    return true
  }

  override fun hashCode(): Int = key().hashCode()
}