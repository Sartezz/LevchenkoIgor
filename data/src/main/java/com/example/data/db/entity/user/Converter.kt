package com.example.data.db.entity.user

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converter {
    companion object {
        @TypeConverter
        @JvmStatic
        fun fromAddressDb(value: AddressDB): String {
            return Gson().toJson(value)
        }

        @TypeConverter
        @JvmStatic
        fun toAddressDb(value: String): AddressDB {
            return Gson().fromJson(value, AddressDB::class.java)
        }

        @TypeConverter
        @JvmStatic
        fun fromCompanyDb(value: CompanyDB): String {
            return Gson().toJson(value)
        }

        @TypeConverter
        @JvmStatic
        fun toCompanyDb(value: String): CompanyDB {
            return Gson().fromJson(value, CompanyDB::class.java)
        }

        @TypeConverter
        @JvmStatic
        fun fromGeoDb(value: GeoDB): String {
            return Gson().toJson(value)
        }

        @TypeConverter
        @JvmStatic
        fun toGeoDb(value: String): GeoDB {
            return Gson().fromJson(value, GeoDB::class.java)
        }
    }
}