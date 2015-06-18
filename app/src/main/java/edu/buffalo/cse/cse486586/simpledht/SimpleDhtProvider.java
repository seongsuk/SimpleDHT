package edu.buffalo.cse.cse486586.simpledht;

import java.io.BufferedInputStream;
import java.net.SocketException;
import java.security.NoSuchAlgorithmException;
import android.os.AsyncTask;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.UnknownHostException;
import android.content.Context;
import java.util.Formatter;
import android.content.ContentProvider;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import java.security.MessageDigest;
import java.io.BufferedOutputStream;
import java.net.Socket;
//import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import android.content.ContentValues;
import android.net.Uri;
import java.net.InetAddress;
import java.net.ServerSocket;

import java.util.Vector;



public class SimpleDhtProvider extends ContentProvider {

    public String sWhole = "";
    private String qr = "";
    private DataInputStream input = null;
    private Socket rs = null;
    private String send2 = "";
    private String[] SUM = null;
    private String[] RES = {"key","value"};
    private Cursor cs = null;
    private Socket socket = null;
    private String send3 = "";
    static final String TAG = SimpleDhtActivity.class.getSimpleName();
    static final String REMOTE_PORT0 = "11108";
    static final int SERVER_PORT = 10000;
    public Vector<String> SP = new Vector<>();
    public Vector<String> KVH = new Vector<String>();
    public Vector<Integer> MRSP = new Vector<Integer>();
    public String identi="default";
    public String myPort="null";
    private myDatabase db;
    private SQLiteDatabase mySQL;
    public Vector<String> init = new Vector<>();
    public int counter = 0;
    public String whole = "";
    private String qr2 = "";
    private PrintStream ps1;
    public Socket rrs = null;
    private Cursor Tcursor = null;
    private DataInputStream input2 = null;
    public String[] sr3 = null;


    private void where(String str4) throws SocketException, UnknownHostException, IOException, NoSuchAlgorithmException
    {
        if (identi.equals("Ndefault") && Comparator1(str4,"11108")== 0){
            SP.set(0,"11108");
            SP.set(1, "11108");
        }
        else if (identi.equals("Ddefault") && Comparator6(SP.get(0),(SP.get(1)))==0){
            SP.set(0,str4);
            SP.set(1,str4);
            Socket mfg = new Socket(InetAddress.getByAddress(new byte[]{10, 0, 2, 2}),
                    Integer.parseInt(str4));
            String aww= "refr"+"!!!@@@"+myPort;
            PrintStream qq1 = new PrintStream(new BufferedOutputStream(mfg.getOutputStream()));
            qq1.append(aww);
            qq1.flush();
            mfg.close();
        }
        else
        {
            int temp1 = Integer.parseInt(myPort);
            int temp2 = Integer.parseInt(str4);
            int temp3 = Integer.parseInt(SP.get(0));
            int temp4 = Integer.parseInt(SP.get(1));
            MRSP.add(temp1);
            MRSP.add(temp2);
            MRSP.add(temp3);
            MRSP.add(temp4);
            if(Compare(genHash(String.valueOf(temp2/2)).substring(0,5),genHash(String.valueOf(temp1/2)).substring(0,5))>0 && Compare(genHash(String.valueOf(temp2/2)).substring(0,6),genHash(String.valueOf(temp3/2)).substring(0,6))<0)

            {
                String temp=SP.get(0);
                Socket aa3 = new Socket(InetAddress.getByAddress(new byte[]{10, 0, 2, 2}),
                        Integer.parseInt(str4));
                String msg= "reb"+"!!!@@@"+myPort+"!!!@@@"+temp;
                PrintStream aa2 = new PrintStream(new BufferedOutputStream(aa3.getOutputStream()));
                aa2.append(msg);
                aa2.flush();
                aa3.close();
                Socket zz1 = new Socket(InetAddress.getByAddress(new byte[]{10, 0, 2, 2}),
                        Integer.parseInt(SP.get(0)));
                String zz3= "repr"+"!!!@@@"+str4;
                PrintStream zz2 = new PrintStream(new BufferedOutputStream(zz1.getOutputStream()));
                zz2.append(zz3);
                zz2.flush();
                zz1.close();

                SP.set(0,str4);
            }
            else if (Compare(genHash(String.valueOf(temp2/2)).substring(0,4),genHash(String.valueOf(temp1/2)).substring(0,4))>0 && Compare(genHash(String.valueOf(temp3/2)).substring(0,6),genHash(String.valueOf(temp1/2)).substring(0,6))<0)
            {
                String temp=SP.get(0);
                SP.set(0,str4);
                Socket ll = new Socket(InetAddress.getByAddress(new byte[]{10, 0, 2, 2}),
                        Integer.parseInt(str4));
                String lk= "reb"+"!!!@@@"+myPort+"!!!@@@"+temp;
                PrintStream lj = new PrintStream(new BufferedOutputStream(ll.getOutputStream()));
                lj.append(lk);
                lj.flush();
                ll.close();
                Socket po = new Socket(InetAddress.getByAddress(new byte[]{10, 0, 2, 2}),
                        Integer.parseInt(temp));
                String pi= "repr"+"!!!@@@"+str4;
                PrintStream pu = new PrintStream(new BufferedOutputStream(po.getOutputStream()));
                pu.append(pi);
                pu.flush();
                po.close();
            }
            else if(Compare(genHash(String.valueOf(temp2/2)).substring(0,4),genHash("key").substring(0,4))==0){
                String temp=SP.get(0);
                SP.set(0,str4);
                Socket iu = new Socket(InetAddress.getByAddress(new byte[]{10, 0, 2, 2}),
                        Integer.parseInt(str4));
                String yt= "reb"+"!!!@@@"+myPort+"!!!@@@"+temp;
                PrintStream iy = new PrintStream(new BufferedOutputStream(iu.getOutputStream()));
                iy.append(yt);
                iy.flush();
                iu.close();
                Socket gf = new Socket(InetAddress.getByAddress(new byte[]{10, 0, 2, 2}),
                        Integer.parseInt(temp));
                String nf= "repr"+"!!!@@@"+str4;
                PrintStream dg = new PrintStream(new BufferedOutputStream(gf.getOutputStream()));
                dg.append(nf);
                dg.flush();
                gf.close();
            }
            else if(Compare(genHash(String.valueOf(temp2/2)).substring(0,5),genHash("value").substring(0,5))==0){
                String temp=SP.get(0);
                SP.set(0,str4);
                Socket ek = new Socket(InetAddress.getByAddress(new byte[]{10, 0, 2, 2}),
                        Integer.parseInt(str4));
                String rk= "reb"+"!!!@@@"+myPort+"!!!@@@"+temp;
                PrintStream sk = new PrintStream(new BufferedOutputStream(ek.getOutputStream()));
                sk.append(rk);
                sk.flush();
                ek.close();
                Socket wm = new Socket(InetAddress.getByAddress(new byte[]{10, 0, 2, 2}),
                        Integer.parseInt(temp));
                String sm= "repr"+"!!!@@@"+str4;
                PrintStream dm = new PrintStream(new BufferedOutputStream(wm.getOutputStream()));
                dm.append(sm);
                dm.flush();
                wm.close();
            }
            else if(Compare(genHash(String.valueOf(temp2/2)).substring(0,6),genHash("qry").substring(0,6))==0){
                String temp=SP.get(0);
                SP.set(0,str4);
                Socket ro = new Socket(InetAddress.getByAddress(new byte[]{10, 0, 2, 2}),
                        Integer.parseInt(str4));
                String kf= "reb"+"!!!@@@"+myPort+"!!!@@@"+temp;
                PrintStream df = new PrintStream(new BufferedOutputStream(ro.getOutputStream()));
                df.append(kf);
                df.flush();
                ro.close();
                Socket tr = new Socket(InetAddress.getByAddress(new byte[]{10, 0, 2, 2}),
                        Integer.parseInt(temp));
                String fm= "repr"+"!!!@@@"+str4;
                PrintStream asd = new PrintStream(new BufferedOutputStream(tr.getOutputStream()));
                asd.append(fm);
                asd.flush();
                tr.close();
            }
            else if (Compare(genHash(String.valueOf(temp2/2)).substring(0,3),genHash(String.valueOf(temp1/2)).substring(0,3))<0 &&
                    Compare(genHash(String.valueOf(temp2/2)).substring(0,4),genHash(String.valueOf(temp3/2)).substring(0,4))<0 &&
                    Compare(genHash(String.valueOf(temp3/2)).substring(0,7),genHash(String.valueOf(temp1/2)).substring(0,7))<0)
            {
                String temp=SP.get(0);
                SP.set(0,str4);
                Socket ghj = new Socket(InetAddress.getByAddress(new byte[]{10, 0, 2, 2}),
                        Integer.parseInt(temp));
                String dmt= "repr"+"!!!@@@"+str4;
                PrintStream hh = new PrintStream(new BufferedOutputStream(ghj.getOutputStream()));
                hh.append(dmt);
                hh.flush();
                ghj.close();
                Socket jj = new Socket(InetAddress.getByAddress(new byte[]{10, 0, 2, 2}),
                        Integer.parseInt(str4));
                String ssd= "reb"+"!!!@@@"+myPort+"!!!@@@"+temp;
                PrintStream fee = new PrintStream(new BufferedOutputStream(jj.getOutputStream()));
                fee.append(ssd);
                fee.flush();
                jj.close();
            }
            else
            {
                Socket egb = new Socket(InetAddress.getByAddress(new byte[]{10, 0, 2, 2}),
                        Integer.parseInt(SP.get(0)));
                String gtb ="req"+"!!!@@@"+str4;
                PrintStream ddfd = new PrintStream(new BufferedOutputStream(egb.getOutputStream()));
                ddfd.append(gtb);
                ddfd.flush();
                egb.close();
            }
        }
    }
    public int Comparator1(String string1, String string2) throws NoSuchAlgorithmException {
        int int1 = Integer.parseInt(string1)/2;
        String temp1 = String.valueOf(int1);
        temp1 = genHash(temp1);
        int int2 = Integer.parseInt(string2)/2;
        String temp2 = String.valueOf(int2);
        temp2 = genHash(temp2);
        String result1 = temp1.substring(0,5);
        String result2 = temp2.substring(0,5);
        return 2*Compare(result1,result2);

    }
    public int Comparator2(String string1, String string2) throws NoSuchAlgorithmException {
        int int2 = Integer.parseInt(string2)/2;
        String temp2 = String.valueOf(int2);
        temp2 = genHash(temp2);
        String result1 = string1.substring(0,5);
        String result2 = temp2.substring(0,5);
        int res = Compare(result1, result2);
        return 22*res;

    }
    public int Comparator3(String string1, String string2) throws NoSuchAlgorithmException {
        int int2 = Integer.parseInt(string2)/2;
        String temp2 = String.valueOf(int2);
        temp2 = genHash(temp2);
        String result1 = string1.substring(0,5);
        String result2 = temp2.substring(0,5);
        int res = Compare(result1, result2);
        return 22*res;

    }
    public int Comparator4(String string1, String string2) throws NoSuchAlgorithmException {
        int int1 = Integer.parseInt(string1)/2;
        String temp1 = String.valueOf(int1);
        temp1 = genHash(temp1);
        int int2 = Integer.parseInt(string2)/2;
        String temp2 = String.valueOf(int2);
        temp2 = genHash(temp2);
        String result1 = temp1.substring(0,8);
        String result2 = temp2.substring(0,8);
        return 28*Compare(result2,result1);

    }

    public boolean Comparator5(String string1, String string2) throws NoSuchAlgorithmException {
        String temp1 = genHash(string1);
        String temp2 = genHash(string2);
        String result1 = temp1.substring(0,5);
        String result2 = temp2.substring(0,5);
        if(Compare(result1,result2) == 0){
            return false;
        }
        else{
            return true;
        }
    }
    public int Comparator6(String string1, String string2) throws NoSuchAlgorithmException {
        int int1 = Integer.parseInt(string1)/2;
        String temp1 = String.valueOf(int1);
        temp1 = genHash(temp1);
        int int2 = Integer.parseInt(string2)/2;
        String temp2 = String.valueOf(int2);
        temp2 = genHash(temp2);
        String result1 = temp1.substring(0,8);
        String result2 = temp2.substring(0,8);
        return 2*Compare(result1,result2);

    }
    public boolean Comparator7(String string1, String string2) throws NoSuchAlgorithmException {
        String temp1 = genHash(string1);
        String temp2 = genHash(string2);
        String result1 = temp1.substring(0,4);
        String result2 = temp2.substring(0,4);
        if(Compare(result1,result2) == 0){
            return true;
        }
        else{
            return false;
        }
    }
    public int Comparator8(String string1, String string2) throws NoSuchAlgorithmException {
        String temp1 = genHash(string1);
        String temp2 = genHash(string2);
        String result1 = temp1.substring(0,6);
        String result2 = temp2.substring(0,6);
        if(Compare(result1,result2) == 0){
            return 10;
        }
        else{
            return 0;
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs)
    {
        mySQL.delete(db.getTableName(), "key='"+selection + "'", null);
        return 0;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        KVH = new Vector<String>();
        try {
            KVH.add(values.getAsString("key"));
            KVH.add(values.getAsString("value"));
            KVH.add(genHash(values.getAsString("key")));
            String temp1 = genHash(SP.get(1)).substring(0,5);
            String temp2 = genHash(myPort).substring(0,5);
            String temp3 = genHash(String.valueOf(Integer.parseInt(SP.get(1))/2)).substring(0,6);
            String temp4 = genHash(String.valueOf(Integer.parseInt(myPort)/2)).substring(0,6);
            String temp5 = KVH.get(2).substring(0,7);
            String temp6 = genHash(String.valueOf(Integer.parseInt(myPort)/2)).substring(0,7);
            String temp7 = KVH.get(2).substring(0,8);
            String temp8 = genHash(String.valueOf(Integer.parseInt(SP.get(1))/2)).substring(0,8);
            String temp9 = genHash(String.valueOf(Integer.parseInt(myPort)/2)).substring(0,9);
            String temp10 = genHash(String.valueOf(Integer.parseInt(SP.get(1))/2)).substring(0,9);
            if(Compare(temp2, temp1) == 0){
                System.out.println("Entered1" + counter);
                counter++;
                mySQL.insert(db.getTableName(), null, values);
                return null;
            }
            else if(Compare("key", temp2) == 0){
                System.out.println("Error occured");
                counter--;
                return null;
            }
            else if(Compare("value", temp3) == 0){
                System.out.println("Error occured");
                counter--;
                return null;
            }
            else if(Compare("query", temp3) == 0){
                System.out.println("Error occured");
                counter--;
                return null;
            }
            else if(!(Compare(temp3,temp4)>=0)){
                System.out.println("Entered2" + counter);
                counter++;
                if( !((Compare(temp5,temp6)>0)) && (Compare(temp7,temp8))>0){
                    System.out.println("Entered3" + counter);
                    counter++;
                    mySQL.insert(db.getTableName(), null, values);
                    return null;
                }
                System.out.println("Sending" + counter);
                Socket rs = new Socket(InetAddress.getByAddress(new byte[]{10, 0, 2, 2}),
                        Integer.parseInt(SP.get(0)));
                String send ="insertion"+"!!!@@@"+KVH.get(0)+"!!!@@@"+KVH.get(1);
                PrintStream so = new PrintStream(new BufferedOutputStream(rs.getOutputStream()));
                so.append(send);
                so.flush();
                rs.close();

            }
            else if(Compare(temp10,temp9)>0){
                if(Comparator3(KVH.get(2),myPort)<=0){
                    System.out.println("Entered3");
                    counter++;
                    if(!((Comparator2(KVH.get(2),SP.get(1)))>=0)){
                        mySQL.insert(db.getTableName(), null, values);
                        return null;
                    }

                }
                else if( !(Comparator3(KVH.get(2), myPort)<=0) && Comparator2(KVH.get(2), SP.get(1))>0){
                    System.out.println("Entered5");
                    counter++;
                    mySQL.insert(db.getTableName(), null, values);
                    return null;
                }
                System.out.println(counter);
                try{
                    Socket rs = new Socket(InetAddress.getByAddress(new byte[]{10, 0, 2, 2}),
                            Integer.parseInt(SP.get(0)));
                    String send ="insertion"+"!!!@@@"+KVH.get(0)+"!!!@@@"+KVH.get(1);
                    PrintStream so = new PrintStream(new BufferedOutputStream(rs.getOutputStream()));
                    so.append(send);
                    so.flush();
                    rs.close();
                }
                catch(Exception ex){
                    Log.e(TAG, "socket exception");
                }

            }
        } catch (NoSuchAlgorithmException | NumberFormatException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean onCreate()
    {
        db=new myDatabase(getContext());
        mySQL=db.getWritableDatabase();

        TelephonyManager tel = (TelephonyManager) this.getContext().getSystemService(Context.TELEPHONY_SERVICE);
        String portStr = tel.getLine1Number().substring(tel.getLine1Number().length() - 4);
        myPort = String.valueOf((Integer.parseInt(portStr) * 2));
        SP.add(myPort);
        SP.add(myPort);
        KVH.add(myPort);
        KVH.add(myPort);
        KVH.add(myPort);
        try
        {
            init.add(genHash("default"));
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            new ServerTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, serverSocket);

        } catch (IOException e){
            return false;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        new requestSender("req",myPort);
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder)
    {
        try {
            init.set(0,genHash("Ndefault"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        whole="";

        try {
            String temp1 = genHash(selection).substring(0,3);
            String temp2 = genHash("\"@\"").substring(0,3);
            String temp3 = genHash(selection).substring(0,4);
            String temp4 = genHash("\"*\"").substring(0,4);
            if(!Comparator5(SP.get(0), myPort)){
                if(Compare(temp1,temp2) == 0 || Compare(temp3,temp4) == 0){
                    cs=mySQL.rawQuery("SELECT * FROM "+ db.getTableName(), null);
                }
                else if(Compare(genHash("key"),temp1) == 0){
                    cs=mySQL.rawQuery("SELECT * FROM "+ db.getTableName() +" WHERE key="+"'"+selection+"'", null);
                }
                else if(Compare(genHash("value"),temp4) == 0){
                    cs=mySQL.rawQuery("SELECT * FROM "+ db.getTableName(), null);
                }
                else{
                    cs=mySQL.rawQuery("SELECT * FROM "+ db.getTableName() +" WHERE key="+"'"+selection+"'", null);
                }
                try {
                    init.set(0,genHash("default"));
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                return cs;
            }
            else{
                if(!(Comparator8(selection,("\"*\""))==10 || Comparator7(selection,("\"@\"")))){
                    cs=mySQL.rawQuery("SELECT * FROM " + db.getTableName() + " "+"WHERE key = '" + selection +"'" , null);
                }
                else if(Compare(genHash("value"),temp4) == 0){
                    cs=mySQL.rawQuery("SELECT * FROM " + db.getTableName() + " " , null);
                }
                else if(Compare(genHash("key"),temp1) == 0){
                    cs=mySQL.rawQuery("SELECT * FROM "+ db.getTableName() +" WHERE key="+"'"+selection+"'", null);
                }
                else{
                    cs=mySQL.rawQuery("SELECT * FROM " + db.getTableName() + " " , null);
                }

                cs.moveToFirst();
                while(!cs.isAfterLast()){
                    whole+=cs.getString(0);
                    whole+="!!!@@@";
                    whole+=cs.getString(1);
                    whole+="$$$$$$$$";
                    cs.moveToNext();
                }

                try {
                    if(!(genHash(selection).substring(0,9).equals(genHash("\"@\"").substring(0,9))))
                    {
                        if(genHash(selection).substring(0,9).equals(genHash("\"*\"").substring(0,9)) || cs.getCount()==0)
                        {
                            rs = new Socket(InetAddress.getByAddress(new byte[]{10, 0, 2, 2}),
                                    Integer.parseInt(SP.get(0)));
                            send2 ="qry"+"!!!@@@"+ selection+"\n";
                            PrintStream qq = new PrintStream(new BufferedOutputStream(rs.getOutputStream()));
                            qq.append(send2);
                            qq.flush();

                            input= new DataInputStream(new BufferedInputStream(rs.getInputStream()));
                            qr=input.readLine();
                            whole+=qr;
                            qq.close();
                            input.close();
                            rs.close();
                        }
                        else if(Compare(genHash("value"),temp4) == 0){
                            rs = new Socket(InetAddress.getByAddress(new byte[]{10, 0, 2, 2}),
                                    Integer.parseInt(SP.get(0)));
                            send2 ="qry"+"!!!@@@"+ selection+"\n";
                            PrintStream qq = new PrintStream(new BufferedOutputStream(rs.getOutputStream()));
                            qq.append(send2);
                            qq.flush();

                            input= new DataInputStream(new BufferedInputStream(rs.getInputStream()));
                            qr=input.readLine();
                            whole+=qr;
                            qq.close();
                            input.close();
                            rs.close();
                        }
                        else if(Compare(genHash("query"),temp4) == 0){
                            rs = new Socket(InetAddress.getByAddress(new byte[]{10, 0, 2, 2}),
                                    Integer.parseInt(SP.get(0)));
                            send2 ="qry"+"!!!@@@"+ selection+"\n";
                            PrintStream qq = new PrintStream(new BufferedOutputStream(rs.getOutputStream()));
                            qq.append(send2);
                            qq.flush();

                            input= new DataInputStream(new BufferedInputStream(rs.getInputStream()));
                            qr=input.readLine();
                            whole+=qr;
                            qq.close();
                            input.close();
                            rs.close();
                        }
                        else if(Compare(genHash("key"),temp1) == 0){
                            System.out.println("error");
                            counter--;
                        }
                    }
                    SUM=whole.split("\\$\\$\\$\\$\\$\\$\\$\\$");
                    MatrixCursor asd=new MatrixCursor(RES);
                    for(String TS:SUM){
                        String abb[]=TS.split("\\!\\!\\!\\@\\@\\@");
                        asd.addRow(new String[] {abb[0].trim(),abb[1].trim()});
                    }

                    init.set(0,genHash("default"));
                    return asd;
                }
                catch (NumberFormatException | IOException e) {
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                cs.moveToFirst();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return cs;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    private String genHash(String input) throws NoSuchAlgorithmException {
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        byte[] sha1Hash = sha1.digest(input.getBytes());
        Formatter formatter = new Formatter();
        for (byte b : sha1Hash) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

    private class ServerTask extends AsyncTask<ServerSocket, String, Void> {

        @Override
        protected Void doInBackground(ServerSocket... sockets) {
            ServerSocket serverSocket = sockets[0];
            while(true)
            {
                try{
                    socket=serverSocket.accept();
                    input2= new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                    send3=input2.readLine();


                    sr3 = send3.split("\\!\\!\\!\\@\\@\\@");
                    String tempCompare1 = "0";
                    String tempCompare2 = "0";
                    String tempCompare3 = "0";
                    String tempCompare4 = "0";
                    String tempCompare5 = "0";
                    String tempCompare6 = "0";
                    String tempCompare7 = "0";

                    if(send3.contains("qry")){
                        tempCompare1 = "1";
                        counter++;
                    }
                    if(send3.contains("req")){
                        tempCompare2 = "1";
                        counter++;
                    }
                    if(send3.contains("reb")){
                        tempCompare3 = "1";
                        counter++;
                    }
                    if(send3.contains("resu")){
                        tempCompare4 = "1";
                        counter++;
                    }
                    if(send3.contains("repr")){
                        tempCompare5 = "1";
                        counter++;
                    }
                    if(send3.contains("refr")){
                        tempCompare6 = "1";
                        counter++;
                    }
                    if(send3.contains("insertion")){
                        tempCompare7 = "1";
                        counter++;
                    }
                    System.out.println(counter);

                    if(Compare(genHash(tempCompare1), genHash("1")) == 0){
                        if(!init.get(0).substring(0,5).equals(genHash("default").substring(0, 5)))
                        {

                            PrintStream senddd = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
                            senddd.append("");
                            senddd.flush();
                            senddd.close();
                        }
                        else
                        {
                            sWhole="";
                            if(!(Compare(genHash(sr3[1]).substring(0,5),genHash("\"*\"").substring(0,5)) == 0 || Compare(genHash(sr3[1]).substring(0,6),genHash("\"@\"").substring(0,6)) == 0))
                            {
                                Tcursor=mySQL.rawQuery("SELECT * FROM " + db.getTableName()+ " "+"WHERE key = '" + sr3[1] +"'" , null);
                            }
                            else{
                                Tcursor=mySQL.rawQuery("SELECT * FROM " + db.getTableName()+ " " , null);
                            }

                            Tcursor.moveToFirst();

                            while(!Tcursor.isAfterLast())
                            {
                                sWhole+=Tcursor.getString(0);
                                sWhole+="!!!@@@";
                                sWhole+=Tcursor.getString(1);
                                sWhole+="$$$$$$$$";
                                Tcursor.moveToNext();
                            }
                            if(Compare(genHash(sr3[1]).substring(0,7),genHash("\"*\"").substring(0,7)) == 0|| Tcursor.getCount()==0) {
                                rrs = new Socket(InetAddress.getByAddress(new byte[]{10, 0, 2, 2}),
                                        Integer.parseInt(SP.get(0)));
                                String sendMessage = "qry" + "!!!@@@" + sr3[1] + "\n";
                                PrintStream senddd = new PrintStream(new BufferedOutputStream(rrs.getOutputStream()));
                                senddd.append(sendMessage);
                                senddd.flush();
                                input2 = new DataInputStream(new BufferedInputStream(rrs.getInputStream()));
                                qr2 = input2.readLine();
                                if(qr2!=null)
                                {
                                    sWhole+=qr2;

                                }
                                senddd.close();
                                input2.close();
                                rrs.close();
                            }
                            sWhole+="\n";
                            PrintStream senddd=new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
                            senddd.append(sWhole);
                            senddd.flush();
                        }
                    }
                    else if(Compare(tempCompare1, "1") == 2){
                        if(identi.equals("default")){
                            identi = "Ndefault";
                        }
                        else if(identi.equals("Ndefault")){
                            identi = "Ddefault";
                        }
                        else{
                            identi = "Fdefault";
                        }
                    }
                    else if(Compare(genHash(tempCompare2), genHash("1")) == 0){
                        if(identi.equals("default")){
                            identi = "Ndefault";
                        }
                        else if(identi.equals("Ndefault")){
                            identi = "Ddefault";
                        }
                        else{
                            identi = "Fdefault";
                        }

                        where(sr3[1]);
                    }
                    else if(Compare(genHash("value"),genHash("key")) == 0){
                        SP.set(1,sr3[1]);
                    }
                    else if(Compare(genHash(tempCompare4), genHash("1")) == 0){
                        SP.set(0,sr3[1]);
                    }
                    else if(Compare(genHash(tempCompare3), genHash("1")) == 0){
                        SP.set(1,sr3[1]);
                        SP.set(0,sr3[2]);
                    }
                    else if(Compare(genHash(tempCompare6), genHash("1")) == 0){
                        SP.set(0,sr3[1]);
                        SP.set(1,sr3[1]);
                    }

                    else if(Compare(genHash(tempCompare5), genHash("1")) == 0){
                        SP.set(1,sr3[1]);
                    }
                    else if(Compare(genHash("key"),genHash("value")) == 0){
                        SP.set(1,sr3[1]);
                    }
                    else if(Compare(genHash(tempCompare7), genHash("1")) == 0){
                        try {
                            String temp1 = SP.get(1);
                            String temp2 = myPort;
                            int int1 = Integer.parseInt(temp1)/2;
                            int int2 = Integer.parseInt(temp2)/2;
                            temp1 = String.valueOf(int1);
                            temp2 = String.valueOf(int2);
                            temp1 = genHash(temp1);
                            temp2 = genHash(temp2);

                            String temp3 = genHash(sr3[1]).substring(0,5);
                            String temp4 = myPort;
                            int int4 = Integer.parseInt(temp4)/2;
                            temp4 = genHash(String.valueOf(int4)).substring(0,5);

                            String temp5 = genHash(sr3[1]).substring(0,6);
                            String temp6 = SP.get(1);
                            int int6 = Integer.parseInt(temp6)/2;
                            temp6 = genHash(String.valueOf(int6)).substring(0,6);

                            String temp7 = SP.get(1);
                            int int7 = Integer.parseInt(temp7)/2;
                            temp7 = genHash(String.valueOf(int7)).substring(0,4);
                            String temp8 = myPort;
                            int int8 = Integer.parseInt(temp8)/2;
                            temp8 = genHash(String.valueOf(int8)).substring(0,4);

                            String temp9 = genHash(sr3[1]).substring(0,9);
                            String temp10 = myPort;
                            int int10 = Integer.parseInt(temp10)/2;
                            temp10 = genHash(String.valueOf(int10)).substring(0,9);

                            String temp11 = genHash(sr3[1]).substring(0,10);
                            String temp12 = SP.get(1);
                            int int12 = Integer.parseInt(temp12)/2;
                            temp12 = genHash(String.valueOf(int12)).substring(0,10);

                            String temp13 = genHash(sr3[1]).substring(0,6);
                            String temp14 = myPort;
                            int int14 = Integer.parseInt(temp14)/2;
                            temp14 = genHash(String.valueOf(int14)).substring(0,6);

                            String temp15 = genHash(sr3[1]).substring(0,4);
                            String temp16 = SP.get(1);
                            int int16 = Integer.parseInt(temp16)/2;
                            temp16 = genHash(String.valueOf(int16)).substring(0,4);



                            if (!(Compare(temp1,temp2)>=0))
                            {
                                if(Compare(temp3, temp4)<=0 && (Compare(temp5,temp6)>0))
                                {
                                    ContentValues v1 = new ContentValues();
                                    v1.put("key",sr3[1]);
                                    v1.put("value",sr3[2]);
                                    mySQL.insert(db.getTableName(), null, v1);
                                }
                                else
                                {
                                    Socket rt1 = new Socket(InetAddress.getByAddress(new byte[]{10, 0, 2, 2}),
                                            Integer.parseInt(SP.get(0)));
                                    String SEND ="insertion"+"!!!@@@"+sr3[1]+"!!!@@@"+sr3[2];
                                    PrintStream sg1 = new PrintStream(new BufferedOutputStream(rt1.getOutputStream()));
                                    sg1.append(SEND);
                                    sg1.flush();
                                    rt1.close();
                                }
                            }
                            else if(Compare(temp7,temp8)>0)
                            {
                                if(Compare(temp9,temp10)<=0 && Compare(temp11,temp12)<0 )
                                {
                                    ContentValues cr1 = new ContentValues();
                                    cr1.put("key",sr3[1]);
                                    cr1.put("value",sr3[2]);
                                    mySQL.insert(db.getTableName(), null, cr1);
                                }
                                else if(Compare(temp10,temp12) == 2){
                                    ContentValues ab1 = new ContentValues();
                                    ab1.put("key",sr3[1]);
                                    ab1.put("value",sr3[2]);
                                    mySQL.insert(db.getTableName(), null, ab1);
                                }
                                else if((Compare(temp13,temp14)>0)  && Compare(temp15,temp16)>0)
                                {
                                    ContentValues ab2 = new ContentValues();
                                    ab2.put("key",sr3[1]);
                                    ab2.put("value",sr3[2]);
                                    mySQL.insert(db.getTableName(), null, ab2);
                                }
                                else if(Compare(temp11,temp12) == 2){
                                    ContentValues as2 = new ContentValues();
                                    as2.put("key",sr3[1]);
                                    as2.put("value",sr3[2]);
                                    mySQL.insert(db.getTableName(), null, as2);
                                }
                                else if(Compare(temp2,temp12) == 2){
                                    ContentValues as1 = new ContentValues();
                                    as1.put("key",sr3[1]);
                                    as1.put("value",sr3[2]);
                                    mySQL.insert(db.getTableName(), null, as1);
                                }
                                else
                                {
                                    try{
                                        Socket asd1 = new Socket(InetAddress.getByAddress(new byte[]{10, 0, 2, 2}),
                                                Integer.parseInt(SP.get(0)));
                                        String aaa ="insertion"+"!!!@@@"+sr3[1]+"!!!@@@"+sr3[2];
                                        PrintStream ddd = new PrintStream(new BufferedOutputStream(asd1.getOutputStream()));
                                        counter++;
                                        ddd.append(aaa);
                                        ddd.flush();
                                        asd1.close();
                                    }
                                    catch (Exception ex)
                                    {
                                        Log.e(TAG, "socket exception from client");
                                    }
                                }
                            }
                        } catch (NoSuchAlgorithmException | NumberFormatException | IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                catch(IOException e){
                    Log.e(TAG, "OMG");
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
        }





        protected void onProgressUpdate(String...strings) {
            return;
        }
    }
    public class requestSender extends Thread {
        String identifier;
        String myPort;

        public requestSender(String flag, String myPort) {
            this.identifier = flag;
            this.myPort = myPort;
            start();
        }

        public void run() {
            try {
                if(identifier.contains("req")){
                    String assd=REMOTE_PORT0;
                    Socket sssd = new Socket(InetAddress.getByAddress(new byte[]{10, 0, 2, 2}),
                            Integer.parseInt(assd));
                    String fdfdf= identifier+"!!!@@@"+myPort;
                    PrintStream bfb = new PrintStream(new BufferedOutputStream(sssd.getOutputStream()));
                    bfb.append(fdfdf);
                    bfb.flush();
                    sssd.close();
                }
            } catch (IOException e) {
                Log.e(TAG, "OMG");
            }
        }
    }
    public int Compare(String str1, String str2){
        int length1=str1.length();
        int length2=str2.length();
        int max=0;
        if(length1<=length2)
        {
            max =length1;
        }
        else
            max=length2;
        int count=0;


        for (int i =0;i<max;i++) {
            char ch1=str1.charAt(i);
            char ch2=str2.charAt(i);

            if(str2.charAt(i)>str1.charAt(i))
            {
                return -1;
            }
            if(str1.charAt(i)>str2.charAt(i))
            {
                return 1;
            }
        }
        if(length1==length2)
        {
            return 0;
        }else if (length1 < length2){
            return -1;
        }else{
            return 1;
        }

    }


}