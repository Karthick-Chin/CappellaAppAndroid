package com.cappella.app

import com.cappella.core.buildconfig.BuildConfigFields
import com.cappella.core.buildconfig.BuildConfigFieldsProvider
import javax.inject.Inject

class ApplicationBuildConfigFieldsProvider @Inject constructor(): BuildConfigFieldsProvider {
    override fun get(): BuildConfigFields {
        return BuildConfigFields(
            isDebug = BuildConfig.DEBUG,
            baseUrl = BuildConfig.BASE_URL
        )
    }
}