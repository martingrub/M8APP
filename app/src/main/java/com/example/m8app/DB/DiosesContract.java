package com.example.m8app.DB;

import android.provider.BaseColumns;

public class DiosesContract{
    private DiosesContract(){}
    public static class DiosesEntry implements BaseColumns {
        public static final String TABLE_NAME = "Dioses";
        public static final String ID = "id";
        public static final String COLUMN_NAME_TITLE = "Name";
        public static final String COLUMN_PANTHEON_TITLE = "Pantheon";
        public static final String COLUMN_ROL_TITLE = "Rol";
        public static final String COLUMN_RANGO_TITLE = "Rango";
        public static final String COLUMN_DAÑO_TITLE = "Daño";

    }

}
