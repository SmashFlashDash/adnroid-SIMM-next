package ru.progpuppers.simmsearch.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Report
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.SecureFlagPolicy
import kotlinx.coroutines.launch
import ru.progpuppers.simmsearch.ui.theme.SimmnextTheme

// todo: в идеале перейти ModalBottomeSheet
//  т.к. он по дефолту с анимацией,
//  но сделать его не убираемым по клику вне диалога

@Composable
fun ConfirmDialog(
    isShown: MutableState<Boolean>,
    title: String? = null,
    icon: ImageVector? = null,
    text: String,
    confirmButtonText: String,
    dismissButtonText: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit = { }
) {
    AlertDialog(
        onDismissRequest = { isShown.value = false },
        title = title?.let { { Text(text = title) } },
        icon = icon?.let {
            {
                Icon(
                    icon,
                    contentDescription = "Example Icon",
                    modifier = Modifier.size(32.dp)
                )
            }
        },
        text = { Text(text = text) },
        dismissButton = {
            Button(
                onClick = {
                    isShown.value = false
                    onDismiss()
                }) {
                Text(
                    text = dismissButtonText,
                    color = Color.White
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    isShown.value = false
                    onConfirm()
                }) {
                Text(
                    text = confirmButtonText,
                    color = Color.White
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetDialog(
    sheetState: SheetState,
    isShown: MutableState<Boolean>,
    // title: String? = null,
    // icon: ImageVector? = null,
    // text: String,
    // confirmButtonText: String,
    // dismissButtonText: String,
    // onConfirm: () -> Unit,
    // onDismiss: () -> Unit = { }
) {
    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = {
            isShown.value = false
        },
        dragHandle = null ,
        // tonalElevation = 0.dp,
        // scrimColor = Color.Transparent,
        properties = ModalBottomSheetProperties(
            securePolicy = SecureFlagPolicy.Inherit,
            isFocusable = false,
            shouldDismissOnBackPress = false
        ),
        sheetState = sheetState
    ) {
        // Sheet content
        Button(onClick = {
            scope.launch { sheetState.hide() }.invokeOnCompletion {
                if (!sheetState.isVisible) {
                    isShown.value = false
                }
            }
        }) {
            Text("Hide bottom sheet")
        }
    }
}


@Composable
fun ConfirmBottomDialog(
    isShown: MutableState<Boolean>,
    title: String,
    description: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit = { },
    // @StringRes dismissText: Int = R.string.confirm,
    confirmButtonText: String,
    dismissButtonText: String,
) {
    Dialog(
        onDismissRequest = onDismiss,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    onClick = onDismiss,
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                )
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            MaterialTheme.colorScheme.onPrimary,
                            shape = MaterialTheme.shapes.medium
                        )
                        .padding(16.dp),
                        // .padding(MaterialTheme.spacing.medium),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = title,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineSmall
                    )
                    //Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = description, style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        Button(
                            onClick = onDismiss,
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimary),
                        ) {
                            Text(text = dismissButtonText, color = MaterialTheme.colorScheme.primary)
                        }
                        Button(
                            onClick = onConfirm,
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                        ) {
                            Text(text = confirmButtonText, color = MaterialTheme.colorScheme.background)
                        }
                    }
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun BottomSheetDialogPreview() {
    SimmnextTheme(dynamicColor = false) {
        BottomSheetDialog(
            isShown = remember { mutableStateOf(true) },
            sheetState = rememberModalBottomSheetState(),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ConfirmDialogPreview() {
    SimmnextTheme(dynamicColor = false) {
        ConfirmDialog(
            isShown = remember { mutableStateOf(false) },
            icon = Icons.Filled.Report,
            // title = "ЙО",
            text = "А ВЫ УВЕРЕНЫ ЧТО ХОТИТЕ ОТВЯЗАТЬ УСТРОЙСТВО",
            dismissButtonText = "ОТМЕНА",
            confirmButtonText = "ПОДТВЕРДИТЬ",
            onConfirm = { },
            onDismiss = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ConfirmBottomDialogPreview() {
    SimmnextTheme(dynamicColor = false) {
        ConfirmBottomDialog(
            isShown = remember { mutableStateOf(false) },
            // title = "ЙО",
            title = "ЙО",
            description = "А ВЫ УВЕРЕНЫ ЧТО ХОТИТЕ ОТВЯЗАТЬ УСТРОЙСТВО",
            dismissButtonText = "ОТМЕНА",
            confirmButtonText = "ПОДТВЕРДИТЬ",
            onConfirm = { },
            onDismiss = { }
        )
    }
}