package com.gabo.solidar.domain.type

enum class ProjectState(
    name: String
) {
    URGENT(
        name = "En urgencia"
    ),
    STARTING(
        name = "Por Empezar"
    ),
    ACTIVE(
        name = "Activo"
    )
}