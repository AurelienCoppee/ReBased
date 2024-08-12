/*
 * Copyright (C) 2024 Rahmouni Neïl & Aurélien Coppée
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.rahmouni.neil.counters.core.data.test.repository

import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber
import dev.rahmouni.neil.counters.core.data.repository.userData.UserDataRepository
import dev.rahmouni.neil.counters.core.datastore.Rn3PreferencesDataSource
import dev.rahmouni.neil.counters.core.model.data.AddressInfo
import dev.rahmouni.neil.counters.core.model.data.UserData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Fake implementation of the [UserDataRepository] that returns hardcoded user data.
 *
 * This allows us to run the app with fake data, without needing an internet connection or working
 * backend.
 */
class FakeUserDataRepository @Inject constructor(
    private val rn3PreferencesDataSource: Rn3PreferencesDataSource,
) : UserDataRepository {

    override val userData: Flow<UserData> =
        rn3PreferencesDataSource.userData

    override suspend fun setAccessibilityEmphasizedSwitches(value: Boolean) {
        rn3PreferencesDataSource.setAccessibilityEmphasizedSwitchesPreference(value)
    }

    override suspend fun setAccessibilityIconTooltips(value: Boolean) {
        rn3PreferencesDataSource.setAccessibilityIconTooltipsPreference(value)
    }

    override suspend fun setAccessibilityAltText(value: Boolean) {
        rn3PreferencesDataSource.setAccessibilityAltTextPreference(value)
    }

    override suspend fun setTravelMode(value: Boolean) {
        rn3PreferencesDataSource.setTravelModeEnabledPreference(value)
    }

    override suspend fun setFriendsMain(value: Boolean) {
        rn3PreferencesDataSource.setFriendsMainEnabledPreference(value)
    }

    override suspend fun setMetricsEnabled(value: Boolean) {
        rn3PreferencesDataSource.setMetricsEnabledPreference(value)
    }

    override suspend fun setCrashlyticsEnabled(value: Boolean) {
        rn3PreferencesDataSource.setCrashlyticsEnabledPreference(value)
    }

    override suspend fun setShouldShowLoginScreenOnStartup(value: Boolean) {
        rn3PreferencesDataSource.setShouldShowLoginScreenOnStartup(value)
    }

    override suspend fun setNotAppFirstLaunch() {
        rn3PreferencesDataSource.setNotAppFirstLaunch()
    }

    override suspend fun setNeedInformation(value: Boolean) {
        rn3PreferencesDataSource.setNeedInformation(value)
    }

    override suspend fun setAddressInfo(value: AddressInfo) {
        rn3PreferencesDataSource.setAddressInfo(value)
    }

    override suspend fun setPhoneNumber(value: PhoneNumber) {
        rn3PreferencesDataSource.setPhoneNumber(value)
    }
}
