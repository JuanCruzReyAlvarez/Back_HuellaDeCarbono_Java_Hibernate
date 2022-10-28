package dds.tp.carbono.dao.org;

import dds.tp.carbono.dao.Dao;
import dds.tp.carbono.entities.organization.Sector;

public class SectorDao extends Dao<Sector>{

        private static SectorDao instance;
        public static SectorDao getInstance() {
            if (instance == null)
                instance = new SectorDao();
            return instance;
        }
    }

