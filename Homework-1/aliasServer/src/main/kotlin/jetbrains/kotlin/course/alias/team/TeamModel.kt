package jetbrains.kotlin.course.alias.team

import jetbrains.kotlin.course.alias.util.Identifier

data class Team(
    public val id: Identifier,
    public var points: Int = 0
) {
    public val name: String = "Team#${id + 1}"

}
