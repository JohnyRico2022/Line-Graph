package ru.nikita.linegraph.data

import ru.nikita.linegraph.dto.DataModel

class DataSource {

    fun listWithData(): List<DataModel> {

        return listOf(
            DataModel("12:00", 50.0f, 1),
            DataModel("12:30", 300.0f, 2),
            DataModel("13:00", 600.0f, 1),
            DataModel("13:30", 500.0f, 2),
            DataModel("14:00", 700.0f, 1),
            DataModel("14:30", 400.0f, 2),
            DataModel("15:00", 350.0f, 1),
            DataModel("15:30", 550.0f, 2),
        )
    }
}