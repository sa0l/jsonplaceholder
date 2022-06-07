package com.jgc.myjsonplaceholder.utils

import android.view.View

infix fun View.setVisibleOrGone(isVisible: Boolean) {
    this.visibility = if (isVisible) View.VISIBLE else View.GONE
}