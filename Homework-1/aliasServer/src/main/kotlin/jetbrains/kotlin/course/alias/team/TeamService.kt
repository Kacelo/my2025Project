package jetbrains.kotlin.course.alias.team

import jetbrains.kotlin.course.alias.util.Identifier
import org.springframework.stereotype.Service

@Service
class TeamService {
    companion object {
        public val teamsStorage: MutableMap<Identifier, Team> = mutableMapOf()
    }
    fun generateTeamsForOneRound(teamsNumber: Int): List<Team> {
        val teams = mutableListOf<Team>()

            repeat(teamsNumber){
                val newId = Team.identifierFactory.uniqueIdentifier()
                val team = Team(newId)
                teams.add(team)
                teamsStorage[newId] = team
            }
        return teams
    }
}
