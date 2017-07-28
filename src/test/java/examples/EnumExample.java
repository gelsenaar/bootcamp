package examples;

public class EnumExample {

    public enum BootCampDays{
        DAYONE,
        DAYTWO,
        DAYTRHEE,
        DAYFOUR,
        DAYFIVE;
    }

    public static String checkBootCampDaysInfo(BootCampDays bootCampDays) {
        switch (bootCampDays){
            case DAYONE:
                return "Zin in!!";
            case DAYTWO:
                return "Het wordt al minder!";
            case DAYTRHEE:
                return "Huiswerk mee!! Het moet niet gekker worden!!!";
            case DAYFOUR:
                return "Huiswerk goed! YEEEAAHHH!";
            case DAYFIVE:
                return "Laatste dag ..... JAMMER!!";
            default:
                return "Welke dag bedoel je?";
        }
    }
}
