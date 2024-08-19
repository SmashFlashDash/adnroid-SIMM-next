package ru.progpuppers.simmsearch.presentation.deviceselect.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.progpuppers.simmsearch.domain.model.SimmDevice
import ru.progpuppers.simmsearch.ui.theme.SimmnextTheme
import java.util.Optional

@Composable
fun DeviceCard(
    modifier: Modifier = Modifier,
    device: SimmDevice,
    onClick: (() -> Unit)? = null
) {
    // todo: на кароточку в верхней строке
    // - верхняя строка: имя устройства, кнопка редактировать данные
    // - вторая строка: кнопка Состояние - В сети, Недоступен, Подключено,

    // todo: переделать colorScheme
    val context = LocalContext.current
    Column(
        // modifier = modifier.clickable { onClick?.invoke() }
        modifier = Modifier
            .padding(16.dp)
            .border(2.dp, MaterialTheme.colorScheme.primary, shape)
            // .background(MaterialTheme.colorScheme.background, shape)
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = device.name,
                style = MaterialTheme.typography.titleMedium,
            )
            Button(onClick = { /*TODO*/ }) {

            }
        }

        Row(horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = { /*TODO*/ }) {

            }
        }
    }

}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DeviceCardPreview() {
    SimmnextTheme(dynamicColor = false) {
        DeviceCard(
            device = SimmDevice(
                name = "Device name",
                macAddress = Optional.of("whatttidy"),
                isEnable = false,
            )
        )
    }
}