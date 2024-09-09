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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

    Scaffold(
        topBar = {
            TopBar(
                title = "Управление устройством",
                onBackClick = onBackClick,
                onExtendClick = onExtendClick
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
            EditableRow("Имя устройства", viewModel.state.savedDevice?.name)
            NotEditableRow("Bluetooth адрес", viewModel.state.savedDevice?.address)
            EditableRow("Описание", viewModel.state.savedDevice?.description)
        }
    }
}

@Composable
fun EditableRow(
    title: String,
    value: String?
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
            text = value ?: "loading",
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
    value: String?
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Text(text = title)
        Row {
            Text(
                text = value ?: "loading",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.width(12.dp))
        }
    }
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
            EditableRow("Описание", "Какойто-то текст")
        }
    }
}