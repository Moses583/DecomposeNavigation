package org.example.project.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import org.example.project.navigation.ScreenAComponent
import org.example.project.navigation.ScreenAEvent

@Composable
fun ScreenAComposable( component: ScreenAComponent) {

    val _text by component.text.subscribeAsState()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text("Screen A")
        TextField(
            value = _text,
            onValueChange = {
                component.onEvent(ScreenAEvent.UpdateText(it))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)

        )
        Button(
            onClick = {
                component.onEvent(ScreenAEvent.ClickButtonA)
            }
        ){
            Text("Go to screen b")
        }
    }

}