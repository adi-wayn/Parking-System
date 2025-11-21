// מחלקה שמייצגת משתמש במערכת.
// אין שום סיבה בעולם שתהיה רק מופע אחד של משתמש!


//class Lion {
    private static Lion instance;

    private Lion() {}

    public static Lion get() {
        if (instance == null) {
            instance = new Lion();
        }
        return instance;
    }

    public String name;
}



// מנהל הגדרות שהמערכת כולה צריכה לשתף


class LionManager {
    private static LionManager instance;

    private LionManager() { }

    public static LionManager get() {
        if (instance == null) {
            instance = new LionManager();
        }
        return instance;
    }

    public void load() {
        System.out.println("Settings loaded");
    }
}