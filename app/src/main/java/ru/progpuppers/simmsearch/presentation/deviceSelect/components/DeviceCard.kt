package ru.progpuppers.simmsearch.presentation.deviceSelect.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Cached
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.progpuppers.simmsearch.presentation.deviceSelect.DeviceCardItem
import ru.progpuppers.simmsearch.presentation.common.InputIcon
import ru.progpuppers.simmsearch.presentation.common.TextIconButton
import ru.progpuppers.simmsearch.ui.theme.SimmnextTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeviceCard(
    modifier: Modifier = Modifier,
    device: DeviceCardItem,
    onEditClick: ((DeviceCardItem) -> Unit),
    onConnectClick: () -> Unit,
    onControlClick: () -> Unit,
) {
    // todo: здесь нужен state
    //  - если устройтсво подключено - подключить меняется на отключить, и мб цувет кнопки
    //  - если подключено становится доступа кнопка управлять

    // var isEnabled by remember { mutableStateOf(device.isConnected) }
    // val context = LocalContext.current

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(),
        colors = CardDefaults.cardColors(
            MaterialTheme.colorScheme.surface,
            MaterialTheme.colorScheme.onSurface,
            MaterialTheme.colorScheme.surfaceContainerLow,
            MaterialTheme.colorScheme.onSurfaceVariant,
        ),
        shape = RoundedCornerShape(8.dp),
    ) {
        CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 0.dp, end = 0.dp, bottom = 8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = device.name,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(horizontal = 24.dp, vertical = 0.dp)
                            .weight(1f)
                            .align(Alignment.CenterVertically),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    InputIcon(icon = Icons.Filled.EditNote,
                        modifier = Modifier,
                        // tint = MaterialTheme.colorScheme.onSurface,
                        onClick = { onEditClick.invoke(device) }
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.weight(2f)
                    ) {
                        Text(
                            text = device.description,
                            modifier = Modifier.padding(8.dp),
                            style = MaterialTheme.typography.bodyMedium,
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.End
                    ) {
                        // println("draw DeviceCard name=${device.address}," +
                        //         "\n\tisConnected=${device.isConnected},")
                        TextIconButton(
                            text = if (device.isConnected) "Отключить" else "Подключить",
                            modifier = Modifier.defaultMinSize(minWidth = 1.dp, minHeight = 1.dp),
                            contentPadding = PaddingValues(5.dp, 5.dp),
                            icon = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            onClick = { onConnectClick() }
                        )
                        TextIconButton(
                            text = "Управлять",
                            modifier = Modifier.defaultMinSize(minWidth = 1.dp, minHeight = 1.dp),
                            contentPadding = PaddingValues(5.dp, 5.dp),
                            icon = Icons.Filled.Cached,
                            iconModifier = Modifier.padding(3.dp, 0.dp, 3.dp, 0.dp).size(20.dp),
                            enabled = device.isConnected,
                            onClick = { onControlClick() }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DeviceCardPreview() {
    SimmnextTheme(dynamicColor = false) {
        DeviceCard(
            device = DeviceCardItem(
                name = "Device name",
                address = "whatttidy",
                description = "Описание устройства"
            ),
            onEditClick = { },
            onConnectClick = { },
            onControlClick = { },
        )
    }
}


@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DeviceCardPreviewNight() {
    SimmnextTheme(dynamicColor = false) {
        DeviceCard(
            device = DeviceCardItem(
                name = "Device name",
                address = "whatttidy",
                description = "Описание устройства"
            ),
            onEditClick = { },
            onConnectClick = { },
            onControlClick = { },
        )
    }
}