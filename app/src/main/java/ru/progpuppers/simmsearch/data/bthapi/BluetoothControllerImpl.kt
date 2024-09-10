package ru.progpuppers.simmsearch.data.bthapi

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.serialization.json.Json
import ru.progpuppers.simmsearch.domain.controller.BluetoothController
import ru.progpuppers.simmsearch.domain.model.BthDevice

// todo: используется для поиска новых и спаренных устройств
// на выходе выдает BluetoothDevice который маписат в упрощенный обьект
// сейчас это не надо, т.к. мы сейвим устройства на вкладке addDevice

// todo:
//  - на вкладке addDevice сейвим в бд
//  - на вкладук selectDevice показываем все остюда но отфильтровывыем которых нет в бд
//    но уже во viewModel ?

// todo: classic bluettoth
//  или bluetoothble
//  сделать так чтобы при переключении в другое приложение продолжал принимать данные

// todo: серилазицию десериалзацию мб вынести в другой класс
@SuppressLint("MissingPermission")
class BluetoothControllerImpl(
    private val context: Context,
    private val jsonRequestFactory: Json,
    private val jsonResponseFactory: Json
) : BluetoothController {

    private val bluetoothManager by lazy {
        context.getSystemService(BluetoothManager::class.java)
    }
    private val bluetoothAdapter by lazy {
        bluetoothManager?.adapter
    }

    private val _scannedDevices = MutableStateFlow<List<BthDevice>>(emptyList())
    override val scannedDevices: StateFlow<List<BthDevice>>
        get() = _scannedDevices.asStateFlow()

    private val _pairedDevices = MutableStateFlow<List<BthDevice>>(emptyList())
    override val pairedDevices: StateFlow<List<BthDevice>>
        get() = _pairedDevices.asStateFlow()

    private val foundDeviceReceiver = FoundDeviceReceiver { device ->
        _scannedDevices.update { devices ->
            val newDevice = device
            if (newDevice in devices) devices else devices + newDevice
        }
    }

    init {
        updatePairedDevices()
    }

    override fun startDiscovery() {
        if (!hasPermission(Manifest.permission.BLUETOOTH_SCAN)) {
            return
        }
        context.registerReceiver(foundDeviceReceiver, IntentFilter(BluetoothDevice.ACTION_FOUND))
        updatePairedDevices()
        bluetoothAdapter?.startDiscovery()
    }

    override fun stopDiscovery() {
        if (!hasPermission(Manifest.permission.BLUETOOTH_SCAN)) {
            return
        }
        bluetoothAdapter?.cancelDiscovery()
    }

    override fun release() {
        context.unregisterReceiver(foundDeviceReceiver)
    }

    override fun disconnect(address: String) {
        TODO("Not yet implemented")
    }

    override fun connect(address: String) {
        TODO("Not yet implemented")
    }

    private fun updatePairedDevices() {
        if (!hasPermission(Manifest.permission.BLUETOOTH_CONNECT)) {
            return
        }
        bluetoothAdapter
            ?.bondedDevices
            ?.map { BthDevice.from(it) }
            ?.also { devices ->
                _pairedDevices.update { devices }
            }
    }

    private fun hasPermission(permission: String): Boolean {
        return context.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }

}

class FoundDeviceReceiver(
    private val onDeviceFound: (BthDevice) -> Unit
) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            BluetoothDevice.ACTION_FOUND -> {
                val device = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    intent.getParcelableExtra(
                        BluetoothDevice.EXTRA_DEVICE,
                        BluetoothDevice::class.java
                    )
                } else {
                    intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
                }
                device?.let {
                    onDeviceFound(BthDevice.from(it))
                }
                // device?.let { BthDevice.from(it) }?.let(onDeviceFound)
            }
        }
    }
}