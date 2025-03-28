package jetbrains.kotlin.course.alias.results

import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService
import org.springframework.stereotype.Service

//creating an alias referring to team list
typealias GameResult = List<Team>

@Service
class GameResultsService {

    companion object {
        val gameHistory : MutableList<GameResult> = mutableListOf()
    }
    fun saveGameResults(result: GameResult) {
//        check if result is empty
        if (result.isEmpty()){
            throw IllegalArgumentException("Game result is empty")
        }
//        check if all teams exist
        val allTeamsExist = result.all {TeamService.teamsStorage.containsKey(it.id)}
        if(!allTeamsExist){
            throw IllegalArgumentException("some teams in the result are not in the Team Storage")
        }
        gameHistory.add(result)
    }

    fun getAllGameResults(): List<GameResult> {
        val reversedGameHistoryList = gameHistory.reversed()
        return reversedGameHistoryList
    }
}
