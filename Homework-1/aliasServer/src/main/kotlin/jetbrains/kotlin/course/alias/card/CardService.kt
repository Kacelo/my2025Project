package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.util.IdentifierFactory
import jetbrains.kotlin.course.alias.util.words
import org.springframework.stereotype.Service

@Service
class CardService {

//adding property identifier
    private val identifierFactory = IdentifierFactory()
// adding cards property
    val cards: List<Card> = generateCards()
//    adding a companion object
    companion object {
       private const val WORDS_IN_CARD =4
    val cardsAmount:Int = words.size/WORDS_IN_CARD
    }

    private fun generateCards(): List<Card> {
        val shuffledWords = words.shuffled()
        val chunkedWords = shuffledWords.chunked(WORDS_IN_CARD)
        val takenChunks = chunkedWords.take(cardsAmount)
        val cardForEachChunk = takenChunks.map{chunk -> Card(identifierFactory.uniqueIdentifier(), chunk.toWords())}
        return cardForEachChunk
    }

    private fun List<String>.toWords(): List<Word> = this.map {Word(it)}

    fun getCardByIndex(index: Int): Card {
       return cards.getOrElse(index) { throw IndexOutOfBoundsException("Card index $index is out of range.")}
    }
}
