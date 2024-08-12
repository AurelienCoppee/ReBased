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

package dev.rahmouni.neil.counters.core.data.repository.friendFeedData

import com.google.firebase.firestore.dataObjects
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dev.rahmouni.neil.counters.core.auth.AuthHelper
import dev.rahmouni.neil.counters.core.data.model.PostRawData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.transformLatest
import javax.inject.Inject

class FirestoreFriendFeedDataRepository @Inject constructor(
    private val authHelper: AuthHelper,
) : FriendFeedDataRepository {

    override val userFriendPosts: Flow<List<PostRawData>> =
        authHelper.getUserFlow().transformLatest { user ->
            emitAll(
                try {
                    Firebase.firestore
                        .collection("friendfeed")
                        .dataObjects<PostRawData>()
                } catch (e: Exception) {
                    throw e
                    // TODO Feedback error
                },
            )
        }
}
