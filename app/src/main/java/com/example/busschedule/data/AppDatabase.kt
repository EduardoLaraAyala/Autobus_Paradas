
package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/*se utiliza para crear y configurar la base de datos Room en tu aplicación.
Proporciona un método para obtener la instancia de la base de datos y asegura
que solo haya una instancia en ejecución. También se encarga de crear la base de
datos a partir de un archivo en el directorio de activos y manejar las migraciones
en caso de cambios en la estructura de la base de datos.*/

@Database(entities = arrayOf(BusSchedule::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun busScheduleDao(): BusScheduleDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .createFromAsset("database/bus_schedule.db")

                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
        }
    }
}
