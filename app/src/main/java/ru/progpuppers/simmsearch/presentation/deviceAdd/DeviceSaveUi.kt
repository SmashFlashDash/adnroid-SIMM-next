package ru.progpuppers.simmsearch.presentation.deviceAdd

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.progpuppers.simmsearch.domain.model.BthDevice
import ru.progpuppers.simmsearch.presentation.common.TopBar

@Composable
fun DeviceSaveUi(
    viewModel: DeviceSaveViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onExtendClick: () -> Unit,
) {
    // todo: сюда передвавать devices и запускать серчинг bth
    //  сделать карочтоку нового устройства
    // todo: добавить крутилку кода идет поиск устройств
    // todo: LazyList updationg from viewModel
    // todo: здесб тоже показываем card с именами устройства и киким-то инофо, кнопкой добавить

    val state by viewModel.state

    Scaffold(
        topBar = {
            TopBar(
                title = "Добавить устройство",
                onBackClick = onBackClick,
                onExtendClick = onExtendClick
            )
        }
    ) { paddingValues ->
        Column (modifier = Modifier.padding(
            start = 16.dp,
            top = paddingValues.calculateTopPadding(),
            end = 16.dp,
            bottom = 16.dp
        )) {

            PropertyEditRow(
                modifier = Modifier.fillMaxWidth(),
                name = "Имя",
                valueState = state.name
            )
            PropertyEditRow(
                modifier = Modifier.fillMaxWidth(),
                name = "Описание",
                valueState = state.description
            )


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {

                OutlinedButton(
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = MaterialTheme.colorScheme.errorContainer,
                        contentColor = MaterialTheme.colorScheme.onError
                    ),
                    onClick = { onBackClick() },
                    modifier = Modifier.padding(8.dp),
                ) { Text(
                    text = "Отменить",
                    style = MaterialTheme.typography.bodyLarge)
                }

                OutlinedButton(
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                    ),
                    onClick = {
                        viewModel.saveDevice()
                        onBackClick()
                    },
                    modifier = Modifier.padding(8.dp),
                ) {
                    Text(
                        text = "Добавить",
                        style = MaterialTheme.typography.labelLarge
                ) }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PropertyEditRow(
    modifier: Modifier = Modifier,
    name: String,
    valueState: MutableState<String>
) {
    Column {
        val maxLength = 110
        val lightBlue = Color(0xffd8e6ff)
        val blue = Color(0xff76a9ff)

        Text(
            text = name,
            modifier = Modifier.fillMaxWidth().padding(bottom = 0.dp),
            textAlign = TextAlign.Start,
            color = blue
        )
        TextField(
            value = valueState.value,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = lightBlue,
                unfocusedTrailingIconColor = lightBlue,
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedTextColor = blue,
                focusedContainerColor = lightBlue,
                focusedTrailingIconColor = lightBlue,
                focusedIndicatorColor = Color.Transparent,
                focusedTextColor = blue,
                cursorColor = Color.Black,
            ),
            onValueChange = {
                if (it.length <= maxLength) valueState.value = it
            },
            shape = RoundedCornerShape(8.dp),
            singleLine = false,
            maxLines = 3,
            trailingIcon = {
                if (valueState.value.isNotEmpty()) {
                    IconButton(onClick = { valueState.value = "" }) {
                        Icon(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = null
                        )
                    }
                }
            }
        )
        Text(
            text = "${valueState.value.length} / $maxLength",
            modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
            textAlign = TextAlign.End,
            color = blue
        )
    }

    // Row(
    //     modifier = modifier.fillMaxWidth(),
    //     horizontalArrangement = Arrangement.Center,
    //     verticalAlignment = Alignment.CenterVertically
    // ) {
    //     Text(
    //         text = "$name:",
    //         modifier = Modifier
    //             .padding(start = 8.dp)
    //             .width(80.dp),
    //         style = MaterialTheme.typography.bodyMedium,
    //         maxLines = 3,
    //         overflow = TextOverflow.Ellipsis,
    //     )
    //     TextField(
    //         value = valueState.value,
    //         onValueChange = { valueState.value = it },
    //         textStyle = MaterialTheme.typography.bodyMedium,
    //         // overflow = TextOverflow.Ellipsis,
    //     )
    // }
}