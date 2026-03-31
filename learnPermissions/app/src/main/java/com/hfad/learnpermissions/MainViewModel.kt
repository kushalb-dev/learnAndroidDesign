package com.hfad.learnpermissions

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val visiblePermissionDialogQueue = mutableListOf<String>()

    fun dismissDialog() {
        visiblePermissionDialogQueue.removeAt(visiblePermissionDialogQueue.lastIndex)
    }

    fun onPermissionResult(
        permission: String,
        isGranted: Boolean
    ) {
        if (!isGranted) {
            visiblePermissionDialogQueue.add(0, permission)
        }
    }
}