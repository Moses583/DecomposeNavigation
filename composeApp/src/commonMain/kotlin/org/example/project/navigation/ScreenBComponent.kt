package org.example.project.navigation

import com.arkivanov.decompose.ComponentContext

class ScreenBComponent(
    val text: String,
    componentContext: ComponentContext,
    private val onNavigateToScreenA: () -> Unit

): ComponentContext by componentContext {

    fun goBack(){
        onNavigateToScreenA()
    }

}