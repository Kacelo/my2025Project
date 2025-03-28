package jetbrains.kotlin.course.alias.team

import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.IdentifierFactory
import org.springframework.stereotype.Service

@Service
class TeamService {
    companion object {
        val teamsStorage: MutableMap<Identifier, Team> = mutableMapOf()
    }
    private val identifierFactory = IdentifierFactory()

    fun generateTeamsForOneRound(teamsNumber: Int): List<Team> {
        val teams = mutableListOf<Team>()

            repeat(teamsNumber){
                val newId = identifierFactory.uniqueIdentifier()
                val team = Team(newId)
                teams.add(team)
                teamsStorage[newId] = team
            }
        return teams
    }
}
