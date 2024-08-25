package ru.progpuppers.simmsearch.presentation.deviceSelect.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import ru.progpuppers.simmsearch.presentation.common.InputIcon
import ru.progpuppers.simmsearch.presentation.common.NotAvailablePopUpState
import ru.progpuppers.simmsearch.presentation.common.NotAvailablePopup


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(onMenuIconClick: () -> Unit) {
    var notAvailablePopupVisibility by rememberSaveable {
        mutableStateOf(
            NotAvailablePopUpState.GONE
        )
    }
    if (notAvailablePopupVisibility.isVisible()) {
        NotAvailablePopup { notAvailablePopupVisibility = NotAvailablePopUpState.GONE }
    }

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            // containerColor = MaterialTheme.colorScheme.primaryContainer,
            // titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        navigationIcon = {
            InputIcon(
                onClick = onMenuIconClick,
                icon = Icons.Filled.Menu,
                description = "navigation menu",
                tint = Color.Black
            )
        },
        actions = {
            InputIcon(
                onClick = { notAvailablePopupVisibility = NotAvailablePopUpState.VISIBLE },
                icon = Icons.Filled.Add,
                description = "add device",
                tint = Color.Black
            )
        },
        title = { }
    )
}


@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar {
        println("click")
    }
}

//
// @OptIn(ExperimentalMaterial3Api::class)
// @Composable
// fun TopBarNavigation() {
//     val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
//
//     Scaffold(
//         modifier = Modifier.fillMaxSize(),
//         topBar = {
//             CenterAlignedTopAppBar(
//                 colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
//                     containerColor = MaterialTheme.colorScheme.primaryContainer,
//                     titleContentColor = MaterialTheme.colorScheme.primary,
//                 ),
//                 title = {
//                     Text(
//                         "Centered Top App Bar",
//                         maxLines = 1,
//                         overflow = TextOverflow.Ellipsis
//                     )
//                 },
//                 navigationIcon = {
//                     IconButton(onClick = { /* do something */ }) {
//                         Icon(
//                             imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                             contentDescription = "Localized description"
//                         )
//                     }
//                 },
//                 actions = {
//                     IconButton(onClick = { /* do something */ }) {
//                         Icon(
//                             imageVector = Icons.Filled.Menu,
//                             contentDescription = "Localized description"
//                         )
//                     }
//                 },
//                 scrollBehavior = scrollBehavior,
//             )
//         },
//     ) { innerPadding ->
//         ScrollContent(innerPadding)
//     }
//
// }
//
// @Composable
// fun ScrollContent(innerPadding: PaddingValues) {
//     val range = 1..100
//
//     LazyColumn(
//         modifier = Modifier.fillMaxSize(),
//         contentPadding = innerPadding,
//         verticalArrangement = Arrangement.spacedBy(8.dp)
//     ) {
//         items(range.count()) { index ->
//             Text(text = "- List item number ${index + 1}")
//         }
//     }
// }