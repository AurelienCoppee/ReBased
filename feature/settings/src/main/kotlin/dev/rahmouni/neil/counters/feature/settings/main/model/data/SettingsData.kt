/*
 * Copyright (C) 2024 Rahmouni Neïl
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package dev.rahmouni.neil.counters.feature.settings.main.model.data

import com.google.android.play.core.appupdate.AppUpdateInfo
import com.google.android.play.core.appupdate.AppUpdateManager
import dev.rahmouni.neil.counters.core.user.Rn3User

data class SettingsData(
    val user: Rn3User,
    val devSettingsEnabled: Boolean,
    val inAppUpdateData: InAppUpdateState,
)

sealed interface InAppUpdateState {

    data object NoUpdateAvailable : InAppUpdateState
    data class UpdateAvailable(
        val appUpdateManager: AppUpdateManager?,
        val appUpdateInfo: AppUpdateInfo?,
    ) : InAppUpdateState

    data class DownloadingUpdate(val progress: Float) : InAppUpdateState
    data class WaitingForRestart(val appUpdateManager: AppUpdateManager?) : InAppUpdateState

    fun shouldShowTile() = this != NoUpdateAvailable
    fun actionPossible() = this is UpdateAvailable || this is WaitingForRestart
}
