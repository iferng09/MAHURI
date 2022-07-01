package com.iferng09.myapp

class Datasource() {

    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
                Affirmation(R.string.salon, R.drawable.salon),
                Affirmation(R.string.cocina, R.drawable.cocina),
                Affirmation(R.string.habitaci_n, R.drawable.habitacion)
        )

    }
}

