package com.gabo.solidar.domain.model

import com.gabo.solidar.domain.type.AssistanceArea
import com.gabo.solidar.domain.type.AssistanceType
import com.gabo.solidar.domain.type.ProjectState

data class ProjectModel(
    val id: Long,
    val organization: String,
    val logo: String,
    val title: String,
    val description: String,
    val assistanceType: AssistanceType,
    val assistanceArea: AssistanceArea,
    val state: ProjectState,
    val location: String,
    val photos: List<String>,
    val activityDate: String,
    val publicationDate: String,
    val participating: Boolean,
    val saved: Boolean,
)
