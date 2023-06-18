package com.efecjo.photoeditor.presentation.main

import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import com.efecjo.photoeditor.domain.ImageListItem
import com.efecjo.photoeditor.util.EnumLauncherType

data class MainScreenState(
    val isMainInit : Boolean = true,
    val imageList : List<ImageListItem> = emptyList(),
    val launcherType: EnumLauncherType = EnumLauncherType.NONE,
    val permissionList : List<String> = emptyList(),
)