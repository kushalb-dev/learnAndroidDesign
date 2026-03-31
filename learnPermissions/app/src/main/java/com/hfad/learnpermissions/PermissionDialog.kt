package com.hfad.learnpermissions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PermissionDialog(
    permission: String,
    isPermanentlyDeclined: Boolean,
    onDismiss: () -> Unit,
    onOkClick: () -> Unit,
    onGoToAppSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        modifier = modifier,
        confirmButton = {},
        dismissButton = {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
                Text(
                    text = if (isPermanentlyDeclined) {
                        "Grant permission in app settings"
                    } else {
                        "OK"
                    }
                )

            }
        },
        icon = {},
        shape = {} ,
        containerColor = ,
        iconContentColor =  ,
        titleContentColor =  ,
        textContentColor =  ,
        tonalElevation =  ,
        properties =
    )

}