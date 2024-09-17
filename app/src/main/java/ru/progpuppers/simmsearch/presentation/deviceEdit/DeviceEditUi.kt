package ru.progpuppers.simmsearch.presentation.deviceEdit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Report
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.progpuppers.simmsearch.presentation.common.TextIconButton
import ru.progpuppers.simmsearch.presentation.common.TopBar
import ru.progpuppers.simmsearch.ui.theme.SimmnextTheme

@Composable
fun DeviceEditUi(
    viewModel: DeviceEditViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onExtendClick: () -> Unit
) {
    // todo:
    //  - Bottom bar - кнопка Отвязать устройстов
    //    или в top bat flat action, но какие еще устройства там нужны
    //  - Всплывающее окно с TextField при нажатии на копку редактировать

    val showDialog = remember { mutableStateOf(false) }

    if (showDialog.value) {
        ConfirmDialog(
            isShown = showDialog,
            // title = "ЙО",
            icon = Icons.Filled.Report,
            text = "А ВЫ УВЕРЕНЫ ЧТО ХОТИТЕ ОТВЯЗАТЬ УСТРОЙСТВО",
            dismissButtonText = "ОТМЕНА",
            confirmButtonText = "ОТВЯЗАТЬ",
            onConfirm = {
                viewModel.deleteDevice()
                onBackClick()
            }
        )
    }

    Scaffold(
        topBar = {
            TopBar(
                title = "Управление устройством",
                onBackClick = onBackClick,
                onExtendClick = onExtendClick
            )
        },
        bottomBar = {
            BottomBar(
                showDialog = showDialog,
                onUpdate = { viewModel.updateDevice() }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            // карточки spaceBetwwen [Black Text  ---  Gray editable ButtonIcon]
            EditableRow("Имя устройства", viewModel.state.name)
            NotEditableRow("Bluetooth адрес", viewModel.state.address)
            EditableRow("Описание", viewModel.state.description, "Нет описания")
        }
    }
}

@Composable
fun EditableRow(
    title: String,
    value: String?,
    default: String = "null"
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title)
        TextIconButton(
            text = value ?: default,
            textStyle = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
            modifier = Modifier.defaultMinSize(minWidth = 1.dp, minHeight = 1.dp),
            contentPadding = PaddingValues(5.dp, 5.dp),
            icon = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.onSurfaceVariant
            ),
            onClick = { /* TODO: raise up bottom menu with Text Field */ }
        )
    }
}

@Composable
fun NotEditableRow(
    title: String,
    value: String?,
    default: String = "null"
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Text(text = title)
        Row {
            Text(
                text = value ?: default,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.width(12.dp))
        }
    }
}

@Composable
fun BottomBar(showDialog: MutableState<Boolean>, onUpdate: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedButton(
            // todo: показать диалог
            //  ждать пока выполнить показывать крутилку
            //  выйьи в seceltUI
            modifier = Modifier.fillMaxWidth().weight(1f),
            onClick = { showDialog.value = true }
        ) {
            Text(text = "Отвязать")
        }
        OutlinedButton(
            // todo: ждать пока выполниться, показывать крутилку
            //  обновить activity, перегрузив state из БД
            modifier = Modifier.fillMaxWidth().weight(1f),
            onClick = { onUpdate() }) {
            Text(text = "Сохранить")
        }
    }
}

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
        title = title?.let{ { Text(text = title) } },
        icon = icon?.let { { Icon(
            icon,
            contentDescription = "Example Icon",
            modifier = Modifier.size(32.dp)
        ) } },
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

@Preview(showBackground = true)
@Composable
fun EditableRowPreview() {
    SimmnextTheme(dynamicColor = false) {
        Column(
            modifier = Modifier
        ) {
            EditableRow("Имя устройства", "Какойто-то текст")
            NotEditableRow("Bluetooth адрес", "Какойто-то текст")
            EditableRow("Описание", null, "Нет описания")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomPreview() {
    SimmnextTheme(dynamicColor = false) {
        BottomBar(
            showDialog = remember { mutableStateOf(false) },
            onUpdate = { }
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