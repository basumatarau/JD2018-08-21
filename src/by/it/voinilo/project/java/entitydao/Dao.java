package by.it.voinilo.project.java.entitydao;


public class Dao {
    private static Dao instance;

    public Roles_Dao role;
    public Roleparam_Dao user;
    //public InterfaceDao<Ads> ad;
    public Ads_Dao ad;


    private Dao() {
        role = new Roles_Dao();
        user = new Roleparam_Dao();
        ad = new Ads_Dao();
    }

    public  static Dao getDao() {
        if (instance == null) {
            synchronized (Dao.class) {
                if (instance == null)
                    instance = new Dao();
            }
        }

        return instance;
}

        public void reset() {
            Reset.main(new String[0]);
        }
}
