package org.example.project.navigation

sealed interface Screen {
    object Home: Screen
    data class Detail(val id: String): Screen
}

sealed interface Configuration {
    object Home: Configuration
    data class Detail(val id: String): Configuration
}