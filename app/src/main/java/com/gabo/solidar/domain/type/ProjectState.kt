package com.gabo.solidar.domain.type

enum class ProjectState(
    val n: String
) {
    URGENT(
        n = "En urgencia"
    ),
    STARTING(
        n = "Por Empezar"
    ),
    ACTIVE(
        n = "Activo"
    )
}