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

package dev.rahmouni.neil.counters.core.config

import androidx.compose.runtime.staticCompositionLocalOf

/**
 * Global key used to obtain access to the ConfigHelper through a CompositionLocal.
 */
val LocalConfigHelper = staticCompositionLocalOf<ConfigHelper> {
    // Provide a default ConfigHelper which does nothing. This is so that tests and previews
    // do not have to provide one. For real app builds provide a different implementation.
    StubConfigHelper()
}
