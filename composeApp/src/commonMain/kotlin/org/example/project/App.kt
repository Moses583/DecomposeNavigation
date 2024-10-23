package org.example.project

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import org.example.project.navigation.RootComponent
import org.example.project.screens.ScreenAComposable
import org.example.project.screens.ScreenBComposable
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(root: RootComponent) {
    MaterialTheme {
        val childStack by root.childStack.subscribeAsState()
        Children(
            stack = childStack,
            animation = stackAnimation ( slide() )
        ){
            child ->
            when( val instance = child.instance){
                is RootComponent.Child.ScreenA -> ScreenAComposable(instance.component)
                is RootComponent.Child.ScreenB -> ScreenBComposable(instance.component.text,instance.component)
            }

        }
    }
}