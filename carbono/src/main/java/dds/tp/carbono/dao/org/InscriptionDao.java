package dds.tp.carbono.dao.org;

public class InscriptionDao {
    public class RequestDao extends Dao<SolicitudVinculacion> {
        private static RequestDao instance;
    
        public static RequestDao getInstance() {
            if (instance == null)
                instance = new RequestDao();
    
            return instance;
        }
    }
}
