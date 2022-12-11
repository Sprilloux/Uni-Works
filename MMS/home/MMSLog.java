import java.util.ArrayList;
public class MMSLog {
    private ArrayList<MMS> MMSLog;
    public MMSLog()
    {
        MMSLog = new ArrayList<MMS>();

    }



    public void MMSlogin(String name,SuperMarket superMarket, Memberships memberships){

        for(MMS mms : MMSLog){
            MMSLog.add(mms);
        }
        MMS mms = new MMS(superMarket,memberships);
        mms.MMSmenu(name);
    }
}


