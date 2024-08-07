package ru.progpuppers.simmsearch.presentation.nvgraph

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import ru.progpuppers.simmsearch.presentation.mainActivity.Greeting
import ru.progpuppers.simmsearch.ui.theme.SimmnextTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            SimmnextTheme {
//                NavGraph(startDestination = Route.MainScreen.route)
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
//        installSplashScreen().apply {
//            setKeepOnScreenCondition(condition = { viewModel.splashCondition.value })
//        }
//        setContent {
//            NewsAppTheme(dynamicColor = false) {
//                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
//                    NavGraph(startDestination = viewModel.startDestination.value)
//                }
//            }
//        }
    }
}