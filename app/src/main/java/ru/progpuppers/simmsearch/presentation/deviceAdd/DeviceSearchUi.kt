package ru.progpuppers.simmsearch.presentation.deviceAdd

import android.annotation.SuppressLint
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.ParcelUuid
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.progpuppers.simmsearch.app.R
import ru.progpuppers.simmsearch.domain.model.BthDevice
import ru.progpuppers.simmsearch.presentation.common.InputIcon
import ru.progpuppers.simmsearch.presentation.common.TopBar
import ru.progpuppers.simmsearch.ui.theme.SimmnextTheme
import java.util.UUID

@Composable
fun DeviceAddUi(
    viewModel: DeviceAddViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onExtendClick: () -> Unit,
    navigateToSaveDeviceUi: (BthDevice) -> Unit
) {
    // todo: добавить крутилку кода идет поиск устройств

    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopBar(
                title = stringResource(R.string.DeviceSearchUi_TopBar_title),
                onBackClick = onBackClick,
                onExtendClick = onExtendClick
            )
        }
    ) { paddingValues ->


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentPadding = paddingValues,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.notSavedDevices.count()) { id ->
                state.notSavedDevices[id].let { device ->
                    DeviceAddCard(
                        device = device,
                        routeToSaveDeviceUi = navigateToSaveDeviceUi
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeviceAddCard(
    modifier: Modifier = Modifier,
    device: BthDevice,
    routeToSaveDeviceUi: (BthDevice) -> Unit
) {
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
                    InputIcon(icon = Icons.Filled.Add,
                        modifier = Modifier,
                        onClick = { routeToSaveDeviceUi.invoke(device) }
                    )
                }
                PropertyRow(name = stringResource(R.string.DeviceSearchUi_AdressRow), value = device.address)
                PropertyRow(name = stringResource(R.string.DeviceSearchUi_UuidRow), value =
                if (device.uuids.isEmpty())
                    stringResource(R.string.DeviceSearchUi_Row_ValueDefault)
                    else device.uuids.joinToString(separator = ", ") { it.toString() })
                PropertyRow(
                    name = stringResource(R.string.DeviceSearchUi_BluetoothClass),
                    value = device.bluetoothClass?.toString() ?: stringResource(R.string.DeviceSearchUi_Row_ValueDefault))
                PropertyRow(name = stringResource(R.string.DeviceSearchUi_Type), value = device.type.toString())
                PropertyRow(name = stringResource(R.string.DeviceSearchUi_BondState), value = device.bondState.toString())
            }
        }
    }
}

@Composable
fun PropertyRow(
    modifier: Modifier = Modifier,
    name: String,
    value: String
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "$name:",
            modifier = Modifier.padding(start = 8.dp),
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            text = value,
            modifier = Modifier.padding(start = 8.dp),
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
        )
    }
}


@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun DeviceCardPreview() {
    SimmnextTheme(dynamicColor = false) {
        DeviceAddCard(
            device = BthDevice(
                name = "New Device 1",
                address = "00:11:22:33:AA:BB",
                type = 1,
                uuids = listOf(ParcelUuid(UUID.randomUUID())),
                bluetoothClass = null,
                bondState = 2
            ),
            routeToSaveDeviceUi = {}
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DeviceCardPreviewNight() {
    SimmnextTheme(dynamicColor = false) {
        DeviceAddCard(
            device = BthDevice(
                name = "New Device 1",
                address = "00:11:22:33:AA:BB",
                type = 1,
                uuids = emptyList(),
                bluetoothClass = null,
                bondState = 2
            ),
            routeToSaveDeviceUi = {}
        )
    }
}