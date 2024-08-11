package ru.progpuppers.simmsearch.presentation.nvgraph

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import ru.progpuppers.simmsearch.ui.theme.SimmnextTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()
        enableEdgeToEdge()
        // todo: заимплементить тему
        //  https://developer.android.com/develop/ui/views/theming/darktheme
        //  https://stackoverflow.com/questions/69186894/trigger-dark-mode-of-system-from-application-programmatically-in-android-studio
        //  https://medium.com/androiddevelopers/appcompat-v23-2-daynight-d10f90c83e94
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        setContent {
            SimmnextTheme {
                NavGraph(startDestination = Route.AppStartNavigation.route)
            }
        }
       // installSplashScreen().apply {
       //     setKeepOnScreenCondition(condition = { viewModel.splashCondition.value })
       // }
       // setContent {
       //     NewsAppTheme(dynamicColor = false) {
       //         Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
       //             NavGraph(startDestination = viewModel.startDestination.value)
       //         }
       //     }
       // }
    }
}