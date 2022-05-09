package com.commdel.carservicewale.common.composition

import androidx.appcompat.app.AppCompatActivity

class ActivityCompositionRoot(
    private val activity: AppCompatActivity,
    private val appCompositionRoot: AppCompositionRoot
) {
    val application get() = appCompositionRoot.application
    val apiCaller get() = appCompositionRoot.apiCaller
}