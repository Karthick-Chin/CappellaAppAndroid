package com.cappella.core.buildconfig

interface BuildConfigFieldsProvider {
    fun get(): BuildConfigFields
}