package gdrive

import Operation
import operation.OperationType
import util.parseStringWithCommaSeparatorToDouble
import java.util.*

class OperationsBuilder {

    fun buildOperationsUsingTitleToValuePairsListToDate(
        pairTitleOperationValueOperation:
        List<Pair<String, String>>, dateOnReceipt: Date?
    ): List<Operation> {
        val operationList: MutableList<Operation> = mutableListOf()
        for (pair in pairTitleOperationValueOperation) {
            operationList.add(createOperationFromPair(pair, dateOnReceipt))
        }
        return operationList
    }

    private fun createOperationFromPair(pair: Pair<String, String>, dateOnReceipt: Date?) =
        Operation(pair.second.parseStringWithCommaSeparatorToDouble(), pair.first, OperationType.OUTCOME, dateOnReceipt
        )
}