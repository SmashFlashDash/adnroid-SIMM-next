package ru.progpuppers.simmsearch.presentation.deviceSelect.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.health.connect.datatypes.Device
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.progpuppers.simmsearch.domain.model.SimmDevice
import ru.progpuppers.simmsearch.presentation.MockData
import ru.progpuppers.simmsearch.presentation.common.InputIcon
import ru.progpuppers.simmsearch.ui.theme.Gray
import ru.progpuppers.simmsearch.ui.theme.SimmnextTheme
import java.util.Optional

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeviceCard(
    modifier: Modifier = Modifier,
    device: SimmDevice,
    onEditClick: ((SimmDevice) -> Unit)
) {
    Card(
        modifier = Modifier.fillMaxWidth().background(Color.Transparent),
        elevation = CardDefaults.cardElevation(),
        colors = CardColors(Gray, Color.Black, Color.Red, Color.Red),
        shape =RoundedCornerShape(8.dp),
    ) {
        CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
            Column (
                modifier = modifier.fillMaxWidth()
                    .padding(start = 16.dp, top = 0.dp, end = 0.dp, bottom = 8.dp)
                    .background(Color.Transparent)
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth().background(Color.Transparent),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(text = device.name, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 0.dp)
                            .weight(1f).align(Alignment.CenterVertically),
                        maxLines = 1, overflow = TextOverflow.Ellipsis
                    )
                        InputIcon( icon = Icons.Filled.EditNote,
                            modifier =  Modifier,
                            onClick = { onEditClick.invoke(device) }
                        )
                }
                // TODO: вторая строка: кнопка и статус - В сети, Недоступен (не найден по блютус), Подключено,
                Row {
                    Text(text = "great")
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "mouse")
                }
            }
        }
    }



    // val context = LocalContext.current
    // Column(
    //     // modifier = modifier.clickable { onClick?.invoke() }
    //     modifier = Modifier
    //         .padding(16.dp)
    //         .border(2.dp, MaterialTheme.colorScheme.primary, shape)
    //         // .background(MaterialTheme.colorScheme.background, shape)
    //         .padding(16.dp)
    // ) {
    //     Row(
    //         horizontalArrangement = Arrangement.SpaceAround,
    //         verticalAlignment = Alignment.Top
    //     ) {
    //         Text(
    //             text = device.name,
    //             style = MaterialTheme.typography.titleMedium,
    //         )
    //         Button(onClick = { /*TODO*/ }) {
    //
    //         }
    //     }
    //
    //     Row(horizontalArrangement = Arrangement.SpaceAround) {
    //         Button(onClick = { /*TODO*/ }) {
    //
    //         }
    //     }
    // }

}

@Preview(showBackground = true)
@Composable
fun DeviceCardPreview() {
    SimmnextTheme(dynamicColor = false) {
        DeviceCard(
            device = SimmDevice(
                name = "Device name",
                macAddress = Optional.of("whatttidy"),
                isEnable = false,
            ),
            onEditClick = { }
        )
    }
}


@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DeviceCardPreviewNight() {
    SimmnextTheme(dynamicColor = false) {
        DeviceCard(
            device = MockData.mockSimmDevice,
            onEditClick = { }
        )
    }
}